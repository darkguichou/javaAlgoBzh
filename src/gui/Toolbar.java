package gui;

import javax.swing.*;
import java.awt.event.MouseListener;
import java.security.PublicKey;

/**
 * Created by guillaume on 05/04/16.
 *
 */
public class Toolbar extends JToolBar{


    private JButton listeCilentsB;
    private JButton listeVisitesB;
    private JButton savedRdV;

    public Toolbar(){


        listeCilentsB = new JButton("Liste des clients");
        listeVisitesB = new JButton("Liste des visites");
        savedRdV = new JButton("Enregistrer un RDV");

        this.add(listeCilentsB);
        this.add(listeVisitesB);
        this.add(savedRdV);


    }


    public JButton getListeCilentsB() {
        return listeCilentsB;
    }

    public JButton getSavedRdV() {
        return savedRdV;
    }

    public JButton getListeVisitesB() {
        return listeVisitesB;
    }

    public void setListeners(MouseListener mouseListener){


        this.savedRdV.addMouseListener(mouseListener);
        this.listeCilentsB.addMouseListener(mouseListener);
        this.listeVisitesB.addMouseListener(mouseListener);

    }


}

