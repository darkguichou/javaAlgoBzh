package metier;

import dao.UtilisateursDao;

public class Connexion {
	
	
	private String identifiant;
	private String mdp;
	private boolean etat = false;
	private UtilisateursDao utilisateursDao;
	private Commercial commercial;
	
	
	
	
	public Connexion(String identifiant, String mdp, UtilisateursDao utilisateursDao){
		
		
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.utilisateursDao = utilisateursDao;

		
		
		
	}
	
	
	public boolean connecter(){
		
		
		this.commercial = utilisateursDao.selectCommercial(this.identifiant);
		
		if (commercial.getCodeClient() != null){
			
			
			this.etat = true; 
			
		}
		
		
		return this.etat;
		
		
		
	}
	
	
	public Commercial getCommercial(){
		
		
		return this.commercial;
		
	}
	
	
	

}
