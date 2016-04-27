package dao;


import java.sql.ResultSet;
import java.sql.SQLException;

import metier.*;


public class UtilisateursDao {


	private Db db;


	public UtilisateursDao(Db db){


		this.db = db;


	}



	
	public Utilisateurs selectClients(int zone){


		Utilisateurs utilisateurs = new Utilisateurs();
		
		
		try {
			
			String query = "SELECT * FROM (SELECT codeClient, MAX(visites.dateVisite) FROM visites GROUP BY codeClient ORDER BY visites.dateVisite) AS lastVisites, utilisateurs, zones " +
					"WHERE lastVisites.codeClient = utilisateurs.codeClient AND utilisateurs.codeZone = zones.codeZone AND utilisateurs.codeZone = " + zone ;
 

			ResultSet res = db.exec(query);
			
			while (res.next()){
				int id = res.getInt("idUtilisateur");
				String code = res.getString("codeClient");
				String email = res.getString("email");
				String nom = res.getString("nom");
				int codeZone = res.getInt("codeZone");
				String numTel = res.getString("telephone");
				String ville = res.getString("ville");
				utilisateurs.getClients().add(new Utilisateur(id, code, email, nom, codeZone, numTel, ville));
				
				
				
				
			}
			
			
			
		} catch (SQLException ex){
			
			
			System.err.println(ex);
			
		}
		
		
		return utilisateurs;
		
		
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
				int codeZone = res.getInt("codeZone");
				commercial.creer(id, code, email, nom, codeZone);
				
				
			}
			
			
			
			
		} catch (SQLException ex){
			
			
			System.err.println(ex);
			
		}
		
		return commercial;
		
		
	}





}
