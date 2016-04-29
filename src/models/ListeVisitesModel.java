package models;

import dao.VisitesDao;
import models.entities.Visites;

/**
 * Created by guillaume on 06/04/16.
 */
public class ListeVisitesModel {


    private VisitesDao visitesDao;
    private Visites visites;


    public ListeVisitesModel(VisitesDao visitesDao){

        this.visitesDao = visitesDao;
    }



    public void init(VisitesDao visitesDao){

        this.visitesDao = visitesDao;

    }


    public void create(int zone){


        visites = visitesDao.selectVisites(zone);
    }


    public Visites getVisites() {
        return visites;
    }
}
