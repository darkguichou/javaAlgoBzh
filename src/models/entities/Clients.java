package models.entities;

import java.util.LinkedList;
import java.util.List;

public class Clients {
	
	
	
	private List<Client> utilisateurs =new LinkedList<Client>();

    
    public Clients(){
        
   
    	
    	
    }

    public String[] toCodeArray(){

        int i;
        String[] codes = new String[utilisateurs.size()];

        for (i = 0; i < utilisateurs.size(); i++){


            codes[i] = utilisateurs.get(i).getCodeClient();


        }


        return codes;
    }


	public List<Client> getClients() {
		return utilisateurs;
	}


	public void setClients(List<Client> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
    

}
