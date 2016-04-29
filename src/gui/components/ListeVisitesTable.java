package gui.components;

import models.parts.TableVisites;
import models.entities.Visites;

import javax.swing.*;

/**
 * Created by guillaume on 06/04/16.
 */
public class ListeVisitesTable {


    public Visites visites;
    public JTable table;


    public ListeVisitesTable(Visites visites){


        this.visites = visites;

    }


    public void create(){

        TableVisites tableVisites = new TableVisites(visites.getVisites());
        table = new JTable(tableVisites);


    }

    public JTable getTable() {
        return table;
    }


}
