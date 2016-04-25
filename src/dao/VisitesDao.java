package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import com.mysql.jdbc.PreparedStatement;

import metier.Visite;
import metier.Visites;

public class VisitesDao {

	public Db db;


	public VisitesDao(Db db){


		this.db = db;


	}

	public Visites selectVisites(int zone){


		Visites visites = new Visites();


		try {

			String query = "SELECT * FROM visites, utilisateurs, zones WHERE utilisateurs.codeZone =" + zone + " and visites.dateVisite > CURRENT_DATE and zones.codeZone = utilisateurs.codeZone and utilisateurs.codeClient = visites.codeClient";
			ResultSet res = db.exec(query);

			while (res.next()){

				int id = res.getInt("visites.idVisite");
				Date date = res.getDate("visites.dateVisite");
				Time time = res.getTime("visites.heureVisite");
				String lieu =  res.getString("visites.lieuVisite");
				String interlocuteur = res.getString("visites.interlocuteur");
				int idClient = res.getInt("utilisateurs.idUtilisateur");
				String nomZone = res.getString("zones.nomZone");


				visites.getVisites().add(new Visite(id, date, time, lieu, interlocuteur, idClient, nomZone));


			}



		} catch (SQLException ex){


			System.err.println(ex);

		}


		return visites;




	}


	public boolean insertVisite(String codeClient, String codeCommercial , Date dateVisite, Time heureVisite, String lieuVisite, String interlocuteur)
	{

		boolean res = false;

		try {

			String query = "INSERT INTO visites VALUES ( NULL, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prepare = db.prepare(query);
			prepare.setString(1, codeClient);
			prepare.setString(2, codeCommercial);
			prepare.setDate(3, dateVisite);
			prepare.setTime(4, heureVisite);
			prepare.setString(5, lieuVisite);
			prepare.setString(6, interlocuteur);
			prepare.execute();
			res = true;


		}catch (SQLException ex){


			System.err.println(ex);

		}




		return res;


	}



}
