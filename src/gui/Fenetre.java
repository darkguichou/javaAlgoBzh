package gui;

import controllers.MenuListener;
import metier.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Fenetre extends JFrame implements Observer{





    Connexion connexion;
    AjouterRdvModel ajouterRdvModel;
    ListeClients listeClients;
    ListeVisites listeVisites;
    MenuListener menuListener;
    private ConnexionView connexionView;
    private ListeClientView listeClientView;
    private ListeVisitesView listeVisitesView;
    private AjouterRdvView ajouterRdvView;
    private Commercial commercial;
    private static final long serialVersionUID = 1L;

    public Fenetre( MenuListener menuListener,ConnexionView connexionView, ListeClientView listeClientView, ListeVisitesView listeVisitesView, AjouterRdvView ajouterRdvView , Connexion connexion, AjouterRdvModel ajouterRdvModel, ListeClients listeCliens, ListeVisites listeVisites){


        this.ajouterRdvModel = ajouterRdvModel;
        this.connexion = connexion;
        this.listeClients = listeCliens;
        this.listeVisites = listeVisites;
        menuListener.addObserver(this);
        connexion.addObserver(this);
        ajouterRdvModel.addObserver(this);
        listeClients.addObserver(this);
        this.setTitle("Algo Breizh:");
        this.setMinimumSize(new Dimension(1600, 900));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setEnabled(true);
        this.setVisible(true);
        this.connexionView = connexionView;
        this.listeClientView = listeClientView;
        this.listeVisitesView = listeVisitesView;
        this.ajouterRdvView = ajouterRdvView;

        //Init avec la vue initiale
        this.getContentPane().add(this.connexionView);


    }



    @Override
    public void update(Observable o, Object arg) {


        if (o instanceof Connexion) {

            if (connexion.getEtat()) {


                this.commercial = this.connexion.getCommercial();
                this.getContentPane().removeAll();
                listeClients.setCodeZone(commercial.getCodeZone());
                listeClients.create();
                ListeClientTable table = new ListeClientTable(listeClients.getUtilisateurs());
                table.create();
                listeClientView.getTabPanel().setViewportView(table.getTable());
                this.getContentPane().add(listeClientView);

                revalidate();
                repaint();

            }else{

                Border border = BorderFactory.createLineBorder(Color.red);
                connexionView.getIdField().setBorder(border);
                connexionView.getPwdField().setBorder(border);
                connexionView.getError().setText("Erreur de connexion.");
                connexionView.getIdField().setBorder(border);
                connexionView.revalidate();
                connexionView.repaint();
                validate();


            }

        }

        else if (o instanceof AjouterRdvModel){


          ajouterRdvView.getMessage().add(new JLabel("Votre visite a bien été ajoutée"));
            ajouterRdvView.getMessage().revalidate();
            ajouterRdvView.getMessage().repaint();
            ajouterRdvView.revalidate();
            ajouterRdvView.repaint();



        }

       else  if (o instanceof MenuListener) {


            if (arg == null){


                System.out.println("deco");
                this.getContentPane().removeAll();
                this.getContentPane().add(connexionView);
                this.revalidate();
                this.repaint();

            }

            else {


                if (arg.equals(listeClientView)) {

                    this.getContentPane().removeAll();
                    listeClients.setCodeZone(commercial.getCodeZone());
                    listeClients.create();
                    ListeClientTable table = new ListeClientTable(listeClients.getUtilisateurs());
                    table.create();
                    listeClientView.getTabPanel().setViewportView(table.getTable());
                    this.getContentPane().add(listeClientView);
                    revalidate();
                    repaint();
                    System.out.println("menu: clients");


                }

                if (arg.equals(listeVisitesView)) {


                    this.getContentPane().removeAll();
                    listeVisites.create(commercial.getCodeZone());
                    listeVisitesView.getMenu().getListeVisitesB().setBackground(Color.white);
                    listeVisitesView.getMenu().revalidate();
                    listeVisitesView.getMenu().repaint();

                    if (!listeVisites.getVisites().getVisites().isEmpty()) {

                        System.out.println("ya");
                        ListeVisitesTable table = new ListeVisitesTable(listeVisites.getVisites());
                        table.create();
                        listeVisitesView.getTabPan().setViewportView(table.getTable());


                    } else {

                        this.getContentPane().removeAll();
                        this.getContentPane().add(connexionView);

                        listeVisitesView.getTabPan().setViewportView(new JLabel("yapas"));
                        System.out.println("yapas");

                    }
                    this.getContentPane().add(listeVisitesView);
                    validate();
                    System.out.println("menu: visites");


                } else if (arg.equals(ajouterRdvView)) {

                    System.out.println("salut");
                    ajouterRdvModel.setCommercial(this.commercial);
                    this.getContentPane().removeAll();

                    ajouterRdvView.setUtilisateurs(ajouterRdvView.getUtilisateursDao().selectClients(commercial.getCodeZone()).toCodeArray());
                    ajouterRdvView.getChoixClient().setModel(new DefaultComboBoxModel(ajouterRdvView.getUtilisateurs()));
                    ajouterRdvView.getForm().revalidate();
                    ajouterRdvView.getForm().repaint();
                    ajouterRdvView.getMenu().getSavedRdV().setBackground(Color.white);
                    ajouterRdvView.getMenu().revalidate();
                    ajouterRdvView.getMenu().repaint();
                    ajouterRdvView.revalidate();
                    ajouterRdvView.repaint();

                    //faut ajouter les machins en attributs

                    this.getContentPane().add(ajouterRdvView);
                    this.validate();
                    this.repaint();


                } else {


                }
            }
        }

    }
}
