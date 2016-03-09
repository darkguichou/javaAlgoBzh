/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

/**
 *
 * @author Utilisateur
 */
public class Db {


	private String url;
	private String user;
	private String mdp;
	private Connection co;
	private Statement statement;



	public Db(String url, String user, String mdp){



		this.url = url;
		this.user = user;
		this.mdp = mdp;

	}

	public void connexion(){

		String msg;

		try {

			Class.forName("com.mysql.jdbc.Driver");

			this.co = (Connection) DriverManager.getConnection(this.url, this.user , this.mdp );
			this.statement = this.co.createStatement();
			msg = "La connection a bien étée éffectuée.";

		} catch (ClassNotFoundException | SQLException e) {

			msg = "Erreur:"  + e;
		}

		System.err.println(msg);

	}


	public ResultSet exec(String query) throws SQLException{


		ResultSet res;

		res = this.statement.executeQuery( query );
		return res;






	}

	public PreparedStatement prepare(String statement ){


		PreparedStatement preparedStatement = null;
		
		try {
			
			preparedStatement = (PreparedStatement) co.prepareStatement(statement);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return preparedStatement;


	}

}
