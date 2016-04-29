package gui;

import gui.views.AjouterRdvView;
import gui.views.ConnexionView;
import gui.views.ListeClientView;
import gui.views.ListeVisitesView;
import listeners.AjouterRdvListener;
import listeners.ConnexionListener;
import listeners.MenuListener;
import dao.Db;
import dao.UtilisateursDao;
import dao.VisitesDao;
import models.AjouterRdvModel;
import models.ConnexionModel;
import models.ListeClientsModel;
import models.ListeVisitesModel;



public class GuiMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        //Connexion à la base de donnée
        Db db = new Db();
        db.connexion();

        //Instanciation des Classes DAO nécessaires
        UtilisateursDao utilisateursDao = new UtilisateursDao(db);
        VisitesDao visitesDao = new VisitesDao(db);

        //Instanciation des Modèles
		ConnexionModel connexion = new ConnexionModel(utilisateursDao);
        AjouterRdvModel ajouterRdvModel = new AjouterRdvModel(visitesDao);
        ListeClientsModel listeClients = new ListeClientsModel();
        ListeVisitesModel listeVisites = new ListeVisitesModel();
        listeClients.init(utilisateursDao);
        listeVisites.init(visitesDao);

        //Instanciation des Vues
		ConnexionView connexionView = new ConnexionView();
        ListeClientView listeClientView = new ListeClientView();
        ListeVisitesView listeVisitesView = new ListeVisitesView();
        AjouterRdvView ajouterRdvView = new AjouterRdvView(utilisateursDao);



        //Instanciation des Listeners
        ConnexionListener connexionListener = new ConnexionListener(connexionView, connexion);
        MenuListener menuListener = new MenuListener(listeClientView, connexionView, listeVisitesView, ajouterRdvView);
        AjouterRdvListener ajouterRdvListener = new AjouterRdvListener(ajouterRdvView, ajouterRdvModel);

        //Mise en place des listeners
        connexionView.getBouton().addMouseListener(connexionListener);
        ajouterRdvView.getAjouterB().addMouseListener(ajouterRdvListener);
        listeClientView.getMenu().setListeners(menuListener);
        listeVisitesView.getMenu().setListeners(menuListener);
        ajouterRdvView.getMenu().setListeners(menuListener);

        //Initialisation des Vues
        listeClientView.init();
        connexionView.init();
        listeVisitesView.init();
        ajouterRdvView.init();

        //Création de la fenètre
		Fenetre fenetre = new Fenetre(menuListener, connexionView,listeClientView, listeVisitesView, ajouterRdvView, connexion, ajouterRdvModel , listeClients, listeVisites);


	}

}
