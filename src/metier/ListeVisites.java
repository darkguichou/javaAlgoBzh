package metier;

import dao.VisitesDao;

/**
 * Created by guillaume on 06/04/16.
 */
public class ListeVisites {


    private VisitesDao visitesDao;
    private Visites visites;



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
