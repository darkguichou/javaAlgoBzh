package dao;

import models.entities.Client;
import models.entities.Clients;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by guillaume on 28/04/16.
 */
public class ClientsDao extends Dao {


    public ClientsDao(Db db) {
        super(db);
    }

    public Clients selectClients(int zone){


        Clients utilisateurs = new Clients();


        try {

            String query = "SELECT * FROM (SELECT codeClient, MAX(visites.dateVisite) FROM visites GROUP BY codeClient ORDER BY visites.dateVisite) AS lastVisites, utilisateurs, zones " +
                    "WHERE lastVisites.codeClient = utilisateurs.codeClient AND utilisateurs.codeZone = zones.codeZone AND utilisateurs.codeZone = " + zone ;


            ResultSet res = super.getDb().exec(query);

            while (res.next()){
                int id = res.getInt("idUtilisateur");
                String code = res.getString("codeClient");
                String email = res.getString("email");
                String nom = res.getString("nom");
                int codeZone = res.getInt("codeZone");
                String numTel = res.getString("telephone");
                String ville = res.getString("ville");
                utilisateurs.getClients().add(new Client(id, code, email, nom, codeZone, numTel, ville));




            }



        } catch (SQLException ex){


            System.err.println(ex);

        }


        return utilisateurs;


    }
}

