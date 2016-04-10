package gui;

import controllers.MenuListener;
import dao.UtilisateursDao;
import metier.Commercial;
import metier.Connexion;
import metier.ListeClients;
import metier.ListeVisites;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Fenetre extends JFrame implements Observer{





    Connexion connexion;
    ListeClients listeClients;
    ListeVisites listeVisites;
    MenuListener menuListener;
    private JPanel connexionView;
    private ListeClientView listeClientView;
    private ListeVisitesView listeVisitesView;
    private AjouterRdvView ajouterRdvView;
    private Commercial commercial;
    private static final long serialVersionUID = 1L;

    public Fenetre( MenuListener menuListener,JPanel connexionView, ListeClientView listeClientView, ListeVisitesView listeVisitesView, AjouterRdvView ajouterRdvView , Connexion connexion, ListeClients listeCliens, ListeVisites listeVisites){



        this.connexion = connexion;
        this.listeClients = listeCliens;
        this.listeVisites = listeVisites;
        menuListener.addObserver(this);
        connexion.addObserver(this);
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
        this.getContentPane().add(this.connexionView);


    }


    public void setMainPanel(JPanel mainPanel) {
        this.connexionView = mainPanel;
        this.getContentPane().add(mainPanel);
    }

    @Override
    public void update(Observable o, Object arg) {


        if (o instanceof Connexion) {

            if (connexion.getEtat()) {


                this.commercial = this.connexion.getCommercial();
                this.getContentPane().removeAll();
                listeClients.create();
                ListeClientTable table = new ListeClientTable(listeClients.getUtilisateurs());
                table.create();
                listeClientView.getTabPanel().setViewportView(table.getTable());
                this.getContentPane().add(listeClientView);

                validate();

            }else{

                connexionView.add(new JLabel("Erreur de connexion."));
                connexionView.revalidate();
                connexionView.repaint();
                validate();


            }

        }

       else  if (o instanceof MenuListener) {

            System.out.println(arg);
            System.out.println(listeClientView);
            if (arg.equals(listeClientView)) {

                this.getContentPane().removeAll();
                listeClients.create();
                ListeClientTable table = new ListeClientTable(listeClients.getUtilisateurs());
                table.create();
                listeClientView.getTabPanel().setViewportView(table.getTable());
                this.getContentPane().add(listeClientView);
                validate();
                System.out.println("menu: clients");


            }
            if (arg.equals(listeVisitesView)) {


                this.getContentPane().removeAll();
                listeVisites.create();

                if (!listeVisites.getVisites().getVisites().isEmpty()) {

                    System.out.println("ya");
                    ListeVisitesTable table = new ListeVisitesTable(listeVisites.getVisites());
                    table.create();
                    listeVisitesView.getTabPan().setViewportView(table.getTable());


                } else{

                    listeVisitesView.getTabPan().setViewportView(new JLabel("yapas"));
                    System.out.println("yapas");

                }
                this.getContentPane().add(listeVisitesView);
                validate();
                System.out.println("menu: visites");


            }

            else if (arg.equals(ajouterRdvView)){

                System.out.println("salut");
                this.getContentPane().removeAll();
                ajouterRdvView.setUtilisateurs(ajouterRdvView.getUtilisateursDao().selectClients(commercial.getCodeZone()).toCodeArray());
                ajouterRdvView.getChoixClient().setModel(new DefaultComboBoxModel(ajouterRdvView.getUtilisateurs()));
                ajouterRdvView.revalidate();
                ajouterRdvView.repaint();

                //faut ajouter les machins en attributs

                this.getContentPane().add(ajouterRdvView);
                validate();


            }
        }

    }
}
