package models;

import dao.CommercialDao;
import models.entities.Commercial;

import java.util.Observable;

public class ConnexionModel extends Observable{
	
	
	private String identifiant;
	private String mdp;
	private boolean etat = false;
	private CommercialDao commercialDao;
	private Commercial commercial;
	
	



	public ConnexionModel(CommercialDao commercialDao){


        this.commercialDao = commercialDao;

	}
	
	public void init(String identifiant, String mdp){
		
		
		this.identifiant = identifiant;
		this.mdp = mdp;

		
		
		
	}
	
	
	public void connecter(){
		
		
		this.commercial = commercialDao.selectCommercial(this.identifiant);
		
		if (commercial.getCode() != null){
			
			
			setEtat(true);
			
		}

		else{

			setEtat(false);
		}

		
		
		
	}
	
	
	public Commercial getCommercial(){
		
		
		return this.commercial;
		
	}


	public void setEtat(boolean etat) {
		this.etat = etat;
		setChanged();
		notifyObservers(this);

	}

	public boolean getEtat(){

		return this.etat;
	}


}
