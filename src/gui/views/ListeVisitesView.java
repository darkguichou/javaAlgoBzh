package gui.views;

import gui.components.Toolbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Hashtable;

/**
 * Created by guillaume on 06/04/16.
 */
public class ListeVisitesView extends JPanel implements View {


    private JScrollPane tabPan;
    private JTable table;
    private Toolbar menu;

    public ListeVisitesView(){

        tabPan = new JScrollPane();
        this.menu = new Toolbar();



    }

    public void init(){

        this.setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel();
        menuPanel.add(this.menu);
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(tabPan, BorderLayout.CENTER);



    }

    @Override
    public void setListeners(Hashtable<String, MouseListener> listeners) {

        this.getMenu().setListeners(listeners.get("menuListener"));
    }

    public JScrollPane getTabPan() {
        return tabPan;
    }

    public Toolbar getMenu() {
        return menu;
    }
}
