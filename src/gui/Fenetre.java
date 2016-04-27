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

            //########CONNEXION -> VALIDE############
            if (connexion.getEtat()) {


                //Récupération du commercial renseigné à la connexion
                this.commercial = this.connexion.getCommercial();

                //Supperssion des vue active
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


            //******************Observation du Menu******************
        } else if (o instanceof MenuListener) {


            //################DECONNEXION##################
            if (arg == null) {

                //Suppression de la vue active
                this.getContentPane().removeAll();

                //Ajout de la vue correspondante
                this.getContentPane().add(connexionView);

                //Régénératiopn de la fenètre
                this.revalidate();
                this.repaint();


            } else {


                //#################LISTE DES CLIENTS##################
                if (arg.equals(listeClientView)) {


                    //Suppressions de la vue active
                    this.getContentPane().removeAll();

                    //Récupération de la liste des clients de la zone correspondante
                    listeClients.setCodeZone(commercial.getZone());
                    listeClients.create();

                    //Génération de l'affichage de la laiste des clietns (JTable)
                    ListeClientTable table = new ListeClientTable(listeClients.getUtilisateurs());
                    table.create();

                    //Paramétrage de la vue
                    listeClientView.getTabPanel().setViewportView(table.getTable());
                    listeClientView.getMenu().getListeCilentsB().setBackground(Color.white);

                    //Régénération de la vue et de la fenètre
                    listeClientView.getMenu().revalidate();
                    listeClientView.getMenu().repaint();
                    this.getContentPane().add(listeClientView);
                    revalidate();
                    repaint();


                }

                //###############LISTE DES VISITES PREVUES####################
                if (arg.equals(listeVisitesView)) {

                    //Suppression de la vue active
                    this.getContentPane().removeAll();

                    //Récupération de la liste des visites correpondantes à la zone
                    listeVisites.create(commercial.getZone());

                    //Paramétrage du Menu
                    listeVisitesView.getMenu().getListeVisitesB().setBackground(Color.white);

                    //Régénération du menu
                    listeVisitesView.getMenu().revalidate();
                    listeVisitesView.getMenu().repaint();


                    //CAS: "il y a des visites de prévues."
                    if (!listeVisites.getVisites().getVisites().isEmpty()) {

                        //Génération de l'affichage de la liste des visites
                        ListeVisitesTable table = new ListeVisitesTable(listeVisites.getVisites());
                        table.create();

                        //Ajout de l'affichage à la vue
                        listeVisitesView.getTabPan().setViewportView(table.getTable());


                    } else {


                        this.getContentPane().add(listeClientView);

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
