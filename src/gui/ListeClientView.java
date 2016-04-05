package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by guillaume on 04/04/16.
 */
public class ListeClientView extends JPanel {

    private JScrollPane tabPanel;
    private JButton bouton1;
    private JButton bouton2;
    private JMenuBar menu;
    private JTable table;

    public ListeClientView(){

        this.tabPanel = new JScrollPane();
        this.menu = new JMenuBar();
        JLabel label = new JLabel("Salut");
        this.add(label);
        bouton1 = new JButton("clique");
        bouton2 = new JButton("oui");



    }



    public void init(){

        this.setLayout(new BorderLayout());
        menu.add(bouton1);
        menu.add(bouton2);
        this.add(menu, BorderLayout.NORTH);
        this.add(tabPanel, BorderLayout.CENTER);




    }


    public JButton getBouton() {
        return bouton1;

    }

    public JScrollPane getTabPanel() {

        return tabPanel;
    }
}



