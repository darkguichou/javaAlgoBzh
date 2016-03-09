package metier;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import dao.Db;

public class Utilisateurs {
	
	
	
	private List<Utilisateur> utilisateurs =new LinkedList<Utilisateur>();

    
    public Utilisateurs(){
        
   
    	
    	
    }
    
    

    
    
    public void afficher(){
        
        int i;
        
        for (i = 0; i < utilisateurs.size(); i++ ){
            
            
            System.out.println(utilisateurs.get(i).getCodeClient());
            
            
        }
        
        
   
        
        
    }


	public List<Utilisateur> getClients() {
		return utilisateurs;
	}


	public void setClients(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
    

}
