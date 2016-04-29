package listeners;

import gui.views.AjouterRdvView;
import gui.views.ConnexionView;
import gui.views.ListeClientView;
import gui.views.ListeVisitesView;

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
    private AjouterRdvView ajouterRdvView;



    public MenuListener(ListeClientView listeClientView, ConnexionView connexionView, ListeVisitesView listeVisitesView, AjouterRdvView ajouterRdvView){


        this.listeClientView = listeClientView;
        this.connexionView = connexionView;
        this.listeVisitesView = listeVisitesView;
        this.ajouterRdvView = ajouterRdvView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource().equals(listeClientView.getMenu().getListeCilentsB()) || e.getSource().equals(listeVisitesView.getMenu().getListeCilentsB()) || e.getSource().equals(ajouterRdvView.getMenu().getListeCilentsB())){

            setChanged();
            notifyObservers(listeClientView);
            System.out.println("liste Clients");
        }

        else if (e.getSource().equals(listeClientView.getMenu().getListeVisitesB()) || e.getSource().equals(listeVisitesView.getMenu().getListeVisitesB()) || e.getSource().equals(ajouterRdvView.getMenu().getListeVisitesB())){


            setChanged();
            notifyObservers(listeVisitesView);
            System.out.println("liste Visites");

        }


        else if (e.getSource().equals(listeClientView.getMenu().getSavedRdV()) || e.getSource().equals(listeVisitesView.getMenu().getSavedRdV()) || e.getSource().equals(ajouterRdvView.getMenu().getSavedRdV())){

            setChanged();
            notifyObservers(ajouterRdvView);
            System.out.println("Enregistrer un rendez vous");

        }


        else if(e.getSource().equals(listeClientView.getMenu().getDeconnexion()) || e.getSource().equals(listeVisitesView.getMenu().getDeconnexion()) || e.getSource().equals(ajouterRdvView.getMenu().getDeconnexion())){


            setChanged();
            notifyObservers(null);
            System.out.println("Deconnexion");


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
