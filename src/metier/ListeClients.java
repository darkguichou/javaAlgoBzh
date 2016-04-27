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
    private int codeZone;



    public ListeClients(){

    }

    public void init(UtilisateursDao utilisateursDao){


        this.utilisateursDao = utilisateursDao;


    }


    public void create(){




        this.utilisateurs = utilisateursDao.selectClients(codeZone);


    }

    public void setNext(boolean next) {

        this.next = next;
        setChanged();
        notifyObservers(this);

    }

    public Utilisateurs getUtilisateurs() {
        return utilisateurs;
    }

    public void setCodeZone(int codeZone) {
        this.codeZone = codeZone;
    }
}


