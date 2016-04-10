package metier;

import java.sql.Array;
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

    public String[] toCodeArray(){

        int i;
        String[] codes = new String[utilisateurs.size()];

        for (i = 0; i < utilisateurs.size(); i++){


            codes[i] = utilisateurs.get(i).getCodeClient();


        }


        return codes;
    }


	public List<Utilisateur> getClients() {
		return utilisateurs;
	}


	public void setClients(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
    

}
