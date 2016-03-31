package controllers;

import dao.Db;
import dao.UtilisateursDao;
import gui.Panel;

public class ControlleurGlobal {
	
	
	
	private Panel controlleurActuel;
	private Db db;
	private UtilisateursDao utilisateursDao;
	
	
	
	public ControlleurGlobal(){
		
			String url = "jdbc:mysql://localhost:3306/newalb";
	       String user = "root";
	       String mdp = "password";
	        
	       this.db = new Db(url, user, mdp);
	       this.db.connexion();
	       
	       
	       this.utilisateursDao = new UtilisateursDao(db);
	       
		
		
	}
	
	
	
	
	public void setVueActuelle(Panel vueActuelle){
		
		
			this.vueActuelle = vueActuelle;
		
		
	}





	public Panel getVueActuelle() {
		return vueActuelle;
	}




	public Db getDb() {
		return db;
	}




	public void setDb(Db db) {
		this.db = db;
	}
	
	
	
	

}
