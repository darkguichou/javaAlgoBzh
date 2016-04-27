package gui;

import metier.TableClients;
import metier.Utilisateur;
import metier.Utilisateurs;

import javax.swing.*;

/**
 * Created by guillaume on 04/04/16.
 */
public class ListeClientTable {

    private Utilisateurs utilisateurs;
    private JTable table;


    public ListeClientTable(Utilisateurs utilisateurs){


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



