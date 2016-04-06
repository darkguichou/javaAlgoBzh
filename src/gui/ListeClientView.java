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
        menu =  new Toolbar();



    }



    public void init(){

        this.setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(new GridLayout(2,1));

        menuPanel.add(new JLabel("Menu:"));
        menuPanel.add(menu);
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(tabPanel, BorderLayout.CENTER);




    }


    public Toolbar getMenu() {
        return menu;
    }

    public JScrollPane getTabPanel() {

        return tabPanel;
    }
}



