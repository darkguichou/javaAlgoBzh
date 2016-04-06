package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by guillaume on 06/04/16.
 */
public class ListeVisitesView extends JPanel{


    private JScrollPane tabPan;
    private JTable table;
    private Toolbar menu;

    public ListeVisitesView(){

        tabPan = new JScrollPane();
        menu = new Toolbar();



    }

    public void init(){

        this.setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2,1));
        menuPanel.add(new JLabel("Menu:"));
        menuPanel.add(menu);
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(tabPan, BorderLayout.CENTER);



    }

    public JScrollPane getTabPan() {
        return tabPan;
    }

    public Toolbar getMenu() {
        return menu;
    }
}
