package gui;

import controllers.ConnexionListener;
import controllers.ListeCLientsListener;
import dao.Db;
import dao.UtilisateursDao;
import metier.Connexion;
import metier.ListeClients;

import javax.rmi.CORBA.Util;
import javax.swing.JFrame;



public class GuiMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Db db = new Db();
        db.connexion();
        UtilisateursDao utilisateursDao = new UtilisateursDao(db);
		Connexion connexion = new Connexion(utilisateursDao);
        ListeClients listeClients = new ListeClients();
        listeClients.init(utilisateursDao);
		ConnexionView connexionView = new ConnexionView();
        ListeClientView listeClientView = new ListeClientView();
        ConnexionListener connexionListener = new ConnexionListener(connexionView, connexion);
        ListeCLientsListener listeCLientsListener = new ListeCLientsListener(listeClients,listeClientView);
        listeClientView.getBouton().addMouseListener(listeCLientsListener);
        listeClientView.init();
        connexionView.getBouton().addMouseListener(connexionListener);
        connexionView.init();
		Fenetre fenetre = new Fenetre(connexionView,listeClientView, connexion, listeClients);
		

	}

}
