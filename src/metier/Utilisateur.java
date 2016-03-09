package metier;

public class Utilisateur {
	
	   private int id;
	   private String code;
	   private String email;
	   private String nom;
	
	
	   public Utilisateur(int id, String code, String email, String nom){
		   
		   
		   this.id = id;
		   this.code = code;
		   this.email = email;
		   this.nom = nom;
		   
		   
		   
	   }
	   
	   public Utilisateur(){
		   
		   
		   
	   }
	   
	   public void creer(int id, String code, String email, String nom){
		   
		   this.id = id;
		   this.code = code;
		   this.email = email;
		   this.nom = nom;
		   
		   
	   }
	   
	   
	    
	    public void afficher(){
	        
	        
	        System.out.println(this.id + "\n" + this.code + "\n" + this.email + "\n" + this.nom);
	        
	        
	        
	        
	    } 

	    public String getCodeClient() {
	        return code;
	    }
	    
	    
	   
	   

}
