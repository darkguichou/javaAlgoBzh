package controllers;

import gui.ConnexionView;
import gui.Panel;

import java.awt.event.MouseListener;

import dao.UtilisateursDao;

import metier.Connexion;

public class ConnexionListener extends Controlleur implements MouseListener{
	
	
	private Connexion connexion;
	private ConnexionView vue;
	private UtilisateursDao utilisateurDao;
	
    
	public ConnexionListener(ConnexionView vue){
		
		
		
		this.vue = vue;
	
		
		
	}


	@SuppressWarnings("deprecation")
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		
		
		
		System.out.println("OK");
		
		
		//Connexion connexion = new Connexion();
		
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
