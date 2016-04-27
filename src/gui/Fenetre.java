package gui;

import controllers.MenuListener;
import metier.*;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Fenetre extends JFrame implements Observer {


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

    public Fenetre(MenuListener menuListener, ConnexionView connexionView, ListeClientView listeClientView, ListeVisitesView listeVisitesView, AjouterRdvView ajouterRdvView, Connexion connexion, AjouterRdvModel ajouterRdvModel, ListeClients listeCliens, ListeVisites listeVisites) {


        //<---------------------------------------------Construction de la classe-------------------------------------------------------------------------------------------->
        this.ajouterRdvModel = ajouterRdvModel;
        this.connexion = connexion;
        this.listeClients = listeCliens;
        this.listeVisites = listeVisites;
        this.connexionView = connexionView;
        this.listeClientView = listeClientView;
        this.listeVisitesView = listeVisitesView;
        this.ajouterRdvView = ajouterRdvView;

        //Inscription de la fenétre aux Observables
        menuListener.addObserver(this);
        connexion.addObserver(this);
        ajouterRdvModel.addObserver(this);
        listeClients.addObserver(this);

        //Paramétrage de la Fenétre
        this.setTitle("Algo Breizh:");
        this.setMinimumSize(new Dimension(1500, 500));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setEnabled(true);
        this.setVisible(true);

        //Init avec la vue initiale
        this.getContentPane().add(this.connexionView, BorderLayout.CENTER);


    }


    //<--------------------------------------------------------------Observation des différents modèles ou vues-------------------------------------------------------------−>
    @Override
    public void update(Observable o, Object arg) {


        //*************************Observatiton du modèle de connexion**************************************
        if (o instanceof Connexion) {

            //########CONNEXION -> VALIDE#########
            if (connexion.getEtat()) {


                //Récupération du commercial renseigné à la connexion
                this.commercial = this.connexion.getCommercial();

                //Suppression de tout les panels
                this.getContentPane().removeAll();

                //Récupération des clients affectés au commercial et génération de la liste des clients
                listeClients.setCodeZone(commercial.getZone());
                listeClients.create();

                //Génération de l'affichage (JTable) en fonction de la liste des clients
                ListeClientTable table = new ListeClientTable(listeClients.getUtilisateurs());
                table.create();

                //Ajout de l'affichage à la vue
                listeClientView.getTabPanel().setViewportView(table.getTable());
                this.getContentPane().add(listeClientView);

                //Regénération de la vue
                revalidate();
                repaint();


                //###########CONNEXION -> NON-VALIDE#############
            } else {

                //Ajout de bordures rouges signalant une erreur d'identification
                Border border = BorderFactory.createLineBorder(Color.red);
                connexionView.getIdField().setBorder(border);
                connexionView.getPwdField().setBorder(border);

                //Ajout du message d'erreur
                connexionView.getError().setText("Erreur de connexion.");

                //Regénération de la vue et de la fenètre
                connexionView.revalidate();
                connexionView.repaint();
                validate();


            }

            //**********************Observation du modèle d'ajout de rendez vous****************************
        } else if (o instanceof AjouterRdvModel) {


            //Ajout d'un message signalant que le rendez vous a bien été créé
            ajouterRdvView.getMessage().add(new JLabel("Votre visite a bien été ajoutée"));

            //Régération de la vue
            ajouterRdvView.getMessage().revalidate();
            ajouterRdvView.getMessage().repaint();
            ajouterRdvView.revalidate();
            ajouterRdvView.repaint();


        } else if (o instanceof MenuListener) {


            if (arg == null) {


                System.out.println("deco");
                this.getContentPane().removeAll();
                this.getContentPane().add(connexionView);
                this.revalidate();
                this.repaint();

            } else {


                if (arg.equals(listeClientView)) {

                    this.getContentPane().removeAll();
                    listeClients.setCodeZone(commercial.getZone());
                    listeClients.create();
                    ListeClientTable table = new ListeClientTable(listeClients.getUtilisateurs());
                    table.create();
                    listeClientView.getTabPanel().setViewportView(table.getTable());
                    listeClientView.getMenu().getListeCilentsB().setBackground(Color.white);
                    listeClientView.getMenu().revalidate();
                    listeClientView.getMenu().repaint();
                    this.getContentPane().add(listeClientView);
                    revalidate();
                    repaint();


                }

                if (arg.equals(listeVisitesView)) {


                    this.getContentPane().removeAll();
                    listeVisites.create(commercial.getZone());
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

                        listeVisitesView.getTabPan().setViewportView(new JLabel("Aucunes visites de prévues pour l'instant."));

                    }
                    this.getContentPane().add(listeVisitesView);
                    validate();
                    System.out.println("menu: visites");


                } else if (arg.equals(ajouterRdvView)) {

                    System.out.println("salut");
                    ajouterRdvModel.setCommercial(this.commercial);
                    this.getContentPane().removeAll();

                    ajouterRdvView.setUtilisateurs(ajouterRdvView.getUtilisateursDao().selectClients(commercial.getZone()).toCodeArray());
                    ajouterRdvView.getChoixClient().setModel(new DefaultComboBoxModel(ajouterRdvView.getUtilisateurs()));
                    ajouterRdvView.getForm().revalidate();
                    ajouterRdvView.getForm().repaint();
                    ajouterRdvView.getMenu().getSavedRdV().setBackground(Color.white);
                    ajouterRdvView.getMenu().revalidate();
                    ajouterRdvView.getMenu().repaint();
                    ajouterRdvView.revalidate();
                    ajouterRdvView.repaint();


                    this.getContentPane().add(ajouterRdvView);
                    this.validate();
                    this.repaint();


                } else {


                }
            }
        }

    }
}
