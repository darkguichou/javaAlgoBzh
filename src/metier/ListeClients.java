package metier;

import dao.UtilisateursDao;
import gui.ListeClientView;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Observable;

/**
 * Created by guillaume on 04/04/16.
 */
public class ListeClients extends Observable{

    public boolean next;
    public UtilisateursDao utilisateursDao;
    public Utilisateurs utilisateurs;



    public ListeClients(){

    }

    public void init(UtilisateursDao utilisateursDao){


        this.utilisateursDao = utilisateursDao;


    }


    public void create(){




        this.utilisateurs = utilisateursDao.selectClients(22);


    }

    public void setNext(boolean next) {

        this.next = next;
        setChanged();
        notifyObservers();

    }

    public Utilisateurs getUtilisateurs() {
        return utilisateurs;
    }
}
