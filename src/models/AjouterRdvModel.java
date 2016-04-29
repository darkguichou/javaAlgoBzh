package models;

import dao.VisitesDao;
import models.entities.Commercial;

import java.sql.Date;
import java.sql.Time;
import java.util.Observable;

/**
 * Created by guillaume on 11/04/16.
 */
public class AjouterRdvModel extends Observable{


    private VisitesDao visitesDao;
    private Commercial commercial;


    public AjouterRdvModel(VisitesDao visitesDao){


        this.visitesDao = visitesDao;


    }

    public void addVisite(String codeClient, String codeCommercial , Date dateVisite, Time heureVisite, String lieuVisite, String interlocuteur){


            visitesDao.insertVisite(codeClient, codeCommercial, dateVisite, heureVisite, lieuVisite, interlocuteur);
            setChanged();
            notifyObservers();


    }


    public void setCommercial(Commercial commercial) {
        this.commercial = commercial;
    }

    public Commercial getCommercial() {
        return commercial;
    }
}
