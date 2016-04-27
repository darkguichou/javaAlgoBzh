package dao;

import java.sql.DriverManager;
import java.sql.SQLException;



import java.sql.*;

import com.mysql.jdbc.PreparedStatement;


public class Db {



	private String url;
	private String user;
	private String mdp;
	private Connection co;
	private Statement statement;



	public Db(){




	}

	public void connexion(){

		String msg;

		try {

			Class.forName("com.mysql.jdbc.Driver");

            this.co = DriverManager.getConnection("jdbc:mysql://localhost/newalb","algobzh","algobzh");
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
