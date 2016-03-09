package dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import metier.Client;
import metier.Clients;
import metier.Commercial;
import metier.Commerciaux;


public class UtilisateursDao {


	private Db db;


	public UtilisateursDao(Db db){


		this.db = db;


	}



	
	public Clients selectClients(){
		
		
		Clients clients = new Clients();
		
		
		try {
			
			String query = "SELECT * FROM utilisateurs WHERE teleprospecteur = 0 AND commercial = 0";
			ResultSet res = db.exec(query);
			
			while (res.next()){
				
				int id = res.getInt("idUtilisateur");
				String code = res.getString("codeClient");
				String email = res.getString("email");
				String nom = res.getString("nom");
				clients.getClients().add(new Client(id, code, email, nom));
				
				
				
				
			}
			
			
			
		} catch (SQLException ex){
			
			
			System.err.println(ex);
			
		}
		
		
		return clients;
		
		
	}
	
	
	public Commercial selectCommercial(String code){
		
		Commercial commercial = new Commercial();
		
		try{
			
			String query = "SELECT * FROM utilisateurs WHERE commercial = 1 and codeClient = '" + code + "'"; 
			ResultSet res = db.exec(query);
			
			if (res.next()){
				
				int id = res.getInt("idUtilisateur");
				String identifiant = res.getString("codeClient");
				String mdp = res.getString("motDePasse");
				String email = res.getString("email");
				String nom = res.getString("nom");
				commercial.creer(id, code, email, nom);
				
				
			}
			
			
			
			
		} catch (SQLException ex){
			
			
			System.err.println(ex);
			
		}
		
		return commercial;
		
		
	}





}
