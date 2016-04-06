package metier;

import dao.UtilisateursDao;

import java.util.Observable;

public class Connexion extends Observable{
	
	
	private String identifiant;
	private String mdp;
	private boolean etat = false;
	private UtilisateursDao utilisateursDao;
	private Commercial commercial;
	
	



	public Connexion(UtilisateursDao utilisateursDao){


        this.utilisateursDao = utilisateursDao;

	}
	
	public void init(String identifiant, String mdp){
		
		
		this.identifiant = identifiant;
		this.mdp = mdp;

		
		
		
	}
	
	
	public void connecter(){
		
		
		this.commercial = utilisateursDao.selectCommercial(this.identifiant);
		
		if (commercial.getCodeClient() != null){
			
			
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
