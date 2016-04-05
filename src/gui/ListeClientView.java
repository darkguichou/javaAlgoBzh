package gui;

import javax.swing.*;

/**
 * Created by guillaume on 04/04/16.
 */
public class ListeClientView extends JScrollPane {


    JButton bouton1;
    JButton bouton2;
    JMenuBar menu;
    JTable table;

    public ListeClientView(){

        this.menu = new JMenuBar();
        JLabel label = new JLabel("Salut");
        this.add(label);
        bouton1 = new JButton("clique");
        bouton2 = new JButton("oui");



    }



    public void init(){

        menu.add(bouton1);
        menu.add(bouton2);
        this.add(menu);



    }


    public JButton getBouton() {
        return bouton1;
    }
}
