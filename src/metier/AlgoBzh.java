/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.sql.Time;
import java.util.Date;

import dao.UtilisateursDao;
import dao.Db;
import dao.VisitesDao;


/**
 *
 * @author Utilisateur
 */
public class AlgoBzh {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
       String url = "jdbc:mysql://localhost:3306/newalb";
       String user = "root";
       String mdp = "password";
        
       Db db = new Db(url, user, mdp);
       db.connexion();
       
       UtilisateursDao utilisateursDao = new UtilisateursDao(db);
       VisitesDao visitesDao = new VisitesDao(db);
       
       Clients clients = utilisateursDao.selectClients();
       
 
	
	@SuppressWarnings("deprecation")
	java.sql.Date date = (java.sql.Date) new java.sql.Date(2016, 4, 4);
  
	@SuppressWarnings("deprecation")
	Time heure = new Time(17, 0, 0);
	
       
       boolean res = visitesDao.insertVisite( date, heure, "rayon fruits et légumes", "M algue", 1);
       System.out.println(res);
       
       clients.afficher();
       
       String identifiant = "CC00001";
       String pwd = "test";
       
       Connexion connexion = new Connexion(identifiant, pwd, utilisateursDao);
       
       if (connexion.connecter()){
    	   
    	  
    	  
    	   connexion.getCommercial().afficher();
    	   
    	   
    	   
       } else {
    	   
    	   System.out.println("Erreur");
    	   
       }
       
       
       
       
       
       gui.GuiMain.main(args);
    
       
       
        
        
    }
    
}
