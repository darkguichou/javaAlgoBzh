package gui.components;

import com.sun.prism.paint.*;

import javax.swing.*;
import java.awt.*;
import java.awt.Color;
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
    private JButton deconnexion;

    public Toolbar(){


        listeCilentsB = new JButton("Liste des clients");
        listeVisitesB = new JButton("Liste des visites prévues");
        savedRdV = new JButton("Enregistrer un RDV");
        deconnexion = new JButton("Déconnexion");
        deconnexion.setBackground(Color.red);
        deconnexion.setForeground(Color.black );
        this.addSeparator();
        this.add(listeCilentsB);
        this.addSeparator(new Dimension(100, this.getHeight()));
        this.add(listeVisitesB);
        this.addSeparator(new Dimension(100, this.getHeight()));
        this.add(savedRdV);
        this.addSeparator(new Dimension(100, this.getHeight()));
        this.add(deconnexion);
        this.setFloatable(false);


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

    public JButton getDeconnexion() {
        return deconnexion;
    }

    public void setListeners(MouseListener mouseListener){


        this.savedRdV.addMouseListener(mouseListener);
        this.listeCilentsB.addMouseListener(mouseListener);
        this.listeVisitesB.addMouseListener(mouseListener);
        this.deconnexion.addMouseListener(mouseListener);

    }


}

