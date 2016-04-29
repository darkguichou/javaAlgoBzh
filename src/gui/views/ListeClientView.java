package gui.views;

import gui.components.Toolbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Hashtable;

/**
 * Created by guillaume on 04/04/16.
 */
public class ListeClientView extends JPanel implements View {

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

    @Override
    public void setListeners(Hashtable<String, MouseListener> listeners) {
        this.getMenu().setListeners(listeners.get("menuListener"));
    }


    public JScrollPane getTabPanel() {

        return tabPanel;
    }

    public Toolbar getMenu() {
        return menu;
    }
}



