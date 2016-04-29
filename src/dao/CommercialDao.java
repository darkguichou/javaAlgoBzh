package dao;

import models.entities.Commercial;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by guillaume on 28/04/16.
 */
public class CommercialDao extends Dao {





    public CommercialDao(Db db) {
        super(db);
    }


    public Commercial selectCommercial(String code){

        Commercial commercial = new Commercial();

        try{

            String query = "SELECT * FROM utilisateurs WHERE commercial = 1 and codeClient = '" + code + "'";
            ResultSet res = super.getDb().exec(query);

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
