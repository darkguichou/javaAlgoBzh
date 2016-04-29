package listeners;

import gui.views.ConnexionView;

import java.awt.event.MouseListener;

import dao.UtilisateursDao;

import models.ConnexionModel;
import models.entities.Client;

public class ConnexionListener implements MouseListener{
	
	
	private ConnexionModel connexion;
	private ConnexionView vue;
	private UtilisateursDao utilisateurDao;
	private Client utilisateur;



    public ConnexionListener(ConnexionView vue, ConnexionModel connexion){
		
		
		this.connexion = connexion;
		this.vue = vue;
	
		
		
	}



	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		
		connexion.init(vue.getIdField().getText().toString(), vue.getPwdField().getText().toString());
		connexion.connecter();


		
	}


	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
