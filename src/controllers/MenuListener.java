package controllers;

import gui.ConnexionView;
import gui.ListeClientView;
import gui.ListeVisitesView;
import metier.Connexion;
import metier.ListeVisites;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

/**
 * Created by guillaume on 05/04/16.
 */
public class MenuListener extends Observable implements MouseListener {


    private ListeClientView listeClientView;
    private ConnexionView connexionView;
    private ListeVisitesView listeVisitesView;

    public MenuListener(ListeClientView listeClientView, ConnexionView connexionView, ListeVisitesView listeVisitesView){


        this.listeClientView = listeClientView;
        this.connexionView = connexionView;
        this.listeVisitesView = listeVisitesView;

    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(listeClientView.getMenu().getListeCilentsB())){

            setChanged();
            notifyObservers(listeClientView);
            System.out.println("liste Clients");
        }

        else if (e.getSource().equals(listeClientView.getMenu().getListeVisitesB())){


            setChanged();
            notifyObservers(listeVisitesView);
            System.out.println("liste Visites");

        }


        else if (e.getSource().equals(listeClientView.getMenu().getSavedRdV())){

            setChanged();
            notifyObservers(this);
            System.out.println("Enregistrer un rendez vous");

        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
