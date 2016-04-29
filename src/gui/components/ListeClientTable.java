package gui.components;

import models.parts.TableClients;
import models.entities.Clients;

import javax.swing.*;

/**
 * Created by guillaume on 04/04/16.
 */
public class ListeClientTable {

    private Clients utilisateurs;
    private JTable table;


    public ListeClientTable(Clients utilisateurs){


            this.utilisateurs = utilisateurs;


    }

    public void create(){




        TableClients tableClients = new TableClients(utilisateurs.getClients());
        table = new JTable(tableClients);



    }

    public JTable getTable() {
        return table;
    }
}



