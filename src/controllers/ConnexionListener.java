package controllers;

import gui.ConnexionView;
import gui.Panel;

import java.awt.event.MouseListener;

import dao.UtilisateursDao;

import metier.Connexion;
import metier.Utilisateur;

public class ConnexionListener extends Controlleur implements MouseListener{
	
	
	private Connexion connexion;
	private ConnexionView vue;
	private UtilisateursDao utilisateurDao;
	private Utilisateur utilisateur;



    public ConnexionListener(ConnexionView vue, Connexion connexion){
		
		
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
