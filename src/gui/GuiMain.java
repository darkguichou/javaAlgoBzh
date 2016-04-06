package gui;

import controllers.ConnexionListener;
import controllers.ListeCLientsListener;
import controllers.MenuListener;
import dao.Db;
import dao.UtilisateursDao;
import dao.VisitesDao;
import metier.Connexion;
import metier.ListeClients;
import metier.ListeVisites;
import org.omg.CORBA.portable.ValueInputStream;

import javax.rmi.CORBA.Util;
import javax.swing.JFrame;



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
		Connexion connexion = new Connexion(utilisateursDao);
        ListeClients listeClients = new ListeClients();
        ListeVisites listeVisites = new ListeVisites();
        listeClients.init(utilisateursDao);
        listeVisites.init(visitesDao);

        //Instanciation des Vues
		ConnexionView connexionView = new ConnexionView();
        ListeClientView listeClientView = new ListeClientView();
        ListeVisitesView listeVisitesView = new ListeVisitesView();

        //Instanciation des Listeners
        ConnexionListener connexionListener = new ConnexionListener(connexionView, connexion);
        ListeCLientsListener listeCLientsListener = new ListeCLientsListener(listeClients,listeClientView);
        MenuListener menuListener = new MenuListener(listeClientView, connexionView, listeVisitesView);

        //Mise en place des listeners
        listeClientView.getMenu().setListeners(menuListener);
        listeVisitesView.getMenu().setListeners(menuListener);
        connexionView.getBouton().addMouseListener(connexionListener);

        //Initialisation des Vues
        listeClientView.init();
        connexionView.init();
        listeVisitesView.init();

        //Création de la fenètre
		Fenetre fenetre = new Fenetre(menuListener, connexionView,listeClientView, listeVisitesView, connexion, listeClients, listeVisites);
		

	}

}
