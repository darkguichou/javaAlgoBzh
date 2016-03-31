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

	public Visites selectVisites(){ 


		Visites visites = new Visites();


		try {

			String query = "SELECT * FROM visites WHERE";
			ResultSet res = db.exec(query);

			while (res.next()){

				int id = res.getInt("idVisite");
				Date date = res.getDate("dateVisite");
				Time time = res.getTime("heureVisite");
				String lieu =  res.getString("lieuVisite");
				String interlocuteur = res.getString("interlocuteur");
				int idClient = res.getInt("idClient");


				visites.getVisites().add(new Visite(id, date, time, lieu, interlocuteur, idClient));




			}



		} catch (SQLException ex){


			System.err.println(ex);

		}


		return visites;




	}


	public boolean insertVisite(Date dateVisite, Time heureVisite, String lieuVisite, String interlocuteur, int idClient)
	{

		boolean res = false;

		try {

			String query = "INSERT INTO visites VALUES ( NULL, ?, ?, ?, ?, ?)";
			PreparedStatement prepare = db.prepare(query);
			prepare.setDate(1, dateVisite);
			prepare.setTime(2, heureVisite);
			prepare.setString(3, lieuVisite);
			prepare.setString(4, interlocuteur);
			prepare.setInt(5, idClient);
			prepare.execute();
			res = true;


		}catch (SQLException ex){


			System.err.println(ex);

		}




		return res;


	}



}
