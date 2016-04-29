package gui;

import dao.*;
import gui.views.*;
import listeners.AjouterRdvListener;
import listeners.ConnexionListener;
import listeners.MenuListener;
import models.AjouterRdvModel;
import models.ConnexionModel;
import models.ListeClientsModel;
import models.ListeVisitesModel;

import java.awt.event.MouseListener;
import java.util.Hashtable;

/**
 * Created by guillaume on 28/04/16.
 */
public class Application {


    private Db db;
    private Hashtable<String, Dao> daos = new Hashtable();
    private Hashtable<String, Object>models = new Hashtable();
    private Hashtable<String, View>views = new Hashtable();
    private Hashtable<String, MouseListener>listeners = new Hashtable();



    public Application(){

    }


    public void connexionDb(){


        Db db = new Db();
        db.connexion();
        this.db = db;

    }


    public void initDao(){


        UtilisateursDao utilisateursDao = new UtilisateursDao(db);
        VisitesDao visitesDao = new VisitesDao(db);
        daos.put("utilisateurs", utilisateursDao);
        daos.put("visites", visitesDao);


    }


    public void initModels(){


        ConnexionModel connexion = new ConnexionModel((CommercialDao) daos.get("utilisateurs"));
        AjouterRdvModel ajouterRdvModel = new AjouterRdvModel((VisitesDao)daos.get("visites"));
        ListeClientsModel listeClients = new ListeClientsModel((ClientsDao) daos.get("utilisateurs"));
        ListeVisitesModel listeVisites = new ListeVisitesModel((VisitesDao)daos.get("visites"));

        models.put("connexion", connexion);
        models.put("ajouterRdv", ajouterRdvModel);
        models.put("listeClients", listeClients);
        models.put("listeVisites", listeVisites);


    }

    public void initViews(){

        ConnexionView connexionView = new ConnexionView();
        ListeClientView listeClientView = new ListeClientView();
        ListeVisitesView listeVisitesView = new ListeVisitesView();
        AjouterRdvView ajouterRdvView = new AjouterRdvView();

        views.put("connexion", connexionView);
        views.put("listeClients", listeClientView);
        views.put("listeVisites", listeVisitesView);
        views.put("ajouterRdv", ajouterRdvView);



    }

    public void initListeners(){

        ConnexionListener connexionListener = new ConnexionListener((ConnexionView)views.get("connexion"),(ConnexionModel)models.get("connexion"));
        MenuListener menuListener = new MenuListener(
                (ListeClientView)views.get("listeClients"),
                (ConnexionView)views.get("connexion"),
                (ListeVisitesView) views.get("listeVisites"),
                (AjouterRdvView)views.get("listeClients")
                );
        AjouterRdvListener ajouterRdvListener = new AjouterRdvListener((AjouterRdvView)views.get("ajouterRdv"), (AjouterRdvModel)models.get("ajouterRdv"));

        listeners.put("connexion", connexionListener);
        listeners.put("menuListener", menuListener);
        listeners.put("ajouterRdv", ajouterRdvListener);

    }

    public void setListeners(){



        for(View v : views.values()){


            v.setListeners(listeners);

        }



    }


    public void createViews(){

        for (View v : views.values()){



            v.init();

        }


    }




    public void run(){


        connexionDb();
        initDao();
        initModels();
        initViews();
        initListeners();
        setListeners();
        createViews();
        Fenetre fenetre = new Fenetre(
                listeners.get("menuListener"),
                views.get("connexion"),
                views.get("listeClients"),
                views.get("listeVisites"),
                views.get("ajouterRdv"),
                models.get("connexion"),
                models.get("ajouterRdv"),
                models.get("listeClients"),
                models.get("listeVisites")
        );



    }







}
