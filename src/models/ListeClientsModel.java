package models;

import dao.ClientsDao;
import dao.UtilisateursDao;
import dao.VisitesDao;
import models.entities.Clients;

import java.util.Observable;

/**
 * Created by guillaume on 04/04/16.
 */
public class ListeClientsModel extends Observable{

    public boolean next;
    public ClientsDao clientsDao;
    public Clients clients;
    private int codeZone;



    public ListeClientsModel(ClientsDao clientsDao){


        this.clientsDao = clientsDao;

    }



    public void create(){




        this.clients = clientsDao.selectClients(codeZone);


    }

    public void setNext(boolean next) {

        this.next = next;
        setChanged();
        notifyObservers(this);

    }

    public Clients getUtilisateurs() {
        return clients;
    }

    public void setCodeZone(int codeZone) {
        this.codeZone = codeZone;
    }
}


