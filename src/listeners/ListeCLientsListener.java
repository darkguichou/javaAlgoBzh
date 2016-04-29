package listeners;

import gui.views.ListeClientView;
import models.ListeClientsModel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by guillaume on 04/04/16.
 */
public class ListeCLientsListener implements MouseListener{

    private ListeClientsModel listeClients;
    private ListeClientView listeClientView;


    public ListeCLientsListener(ListeClientsModel listeCLients, ListeClientView listeClientView){

        this.listeClients = listeCLients;
        this.listeClientView = listeClientView;



    }

    @Override
    public void mouseClicked(MouseEvent e) {

        listeClients.setNext(true);
        System.out.println("to");

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
