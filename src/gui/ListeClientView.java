package gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by guillaume on 04/04/16.
 */
public class ListeClientView extends JPanel {

    private JScrollPane tabPanel;
    private JTable table;
    private Toolbar menu;

    public ListeClientView(){

        this.tabPanel = new JScrollPane();
        this.menu = new Toolbar();




    }



    public void init(){

        this.setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.add(this.menu);
        System.out.println("c fait");
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(tabPanel, BorderLayout.CENTER);



    }



    public JScrollPane getTabPanel() {

        return tabPanel;
    }

    public Toolbar getMenu() {
        return menu;
    }
}



