package gui.views;

import dao.UtilisateursDao;
import gui.components.Toolbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.Hashtable;

/**
 * Created by guillaume on 07/04/16.
 */
public class AjouterRdvView extends JPanel implements View {



    private Toolbar menu;
    private JPanel menuPanel;
    private JPanel form;
    private JPanel message;
    private JComboBox choixClient;
    private JSpinner dateSpinner;
    private JSpinner timeSpinner;
    private JTextField lieuTxt;
    private JTextField interlocuteurTxt;
    private JButton ajouterB;
    private String[] utilisateurs;
    private UtilisateursDao utilisateursDao;
    private SpinnerDateModel dateModel;
    private SpinnerDateModel timeModel;
    private JLabel state;

    public AjouterRdvView(){


        this.menu = new Toolbar();
        this.setLayout(new BorderLayout());
        menuPanel = new JPanel();
        message = new JPanel();
        dateSpinner = new JSpinner();
        lieuTxt = new JTextField();
        timeSpinner = new JSpinner();
        interlocuteurTxt = new JTextField();
        this.ajouterB = new JButton("Enregistrer");
        state = new JLabel("");
    }


    public void init(){

        this.utilisateursDao = utilisateursDao;
        form = new JPanel();
        menuPanel.add(this.menu);

        this.choixClient = new JComboBox();
        form.add(new JLabel("Nouveau RDV:"));
        form.add(new JLabel("Client:"));
        form.add(choixClient);
        this.dateModel = new SpinnerDateModel();
        dateSpinner.setModel(dateModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
        dateEditor.getTextField().setEditable(false);
        dateSpinner.setEditor(dateEditor);
        form.add(new JLabel("Date:"));
        form.add(dateSpinner);
        this.timeModel = new SpinnerDateModel();
        timeSpinner.setModel(timeModel);
        JSpinner.DateEditor timeEditor =  new JSpinner.DateEditor(timeSpinner, "hh-mm-ss");
        timeEditor.getTextField().setEditable(false);
        timeSpinner.setEditor(timeEditor);
        form.add(new JLabel("heure:"));
        form.add(timeSpinner);
        form.add(new JLabel("Lieu"));
        lieuTxt.setColumns(10);
        form.add(lieuTxt);
        form.add(new JLabel("Interlocuteur"));
        interlocuteurTxt.setColumns(10);
        form.add(interlocuteurTxt);
        form.add(ajouterB);
        form.add(state);
        form.revalidate();
        form.repaint();

        //Ajout des Panels
        this.add(form, BorderLayout.CENTER);
        this.add(menuPanel, BorderLayout.NORTH);
        this.add(message, BorderLayout.SOUTH);


    }

    @Override
    public void setListeners(Hashtable<String, MouseListener> listener) {

        this.ajouterB.addMouseListener(listener.get("ajouterRdv"));
        this.getMenu().setListeners(listener.get("menuListener"));
    }

    public void setUtilisateurs(String[] utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    public String[] getUtilisateurs() {
        return utilisateurs;
    }

    public UtilisateursDao getUtilisateursDao() {
        return utilisateursDao;
    }

    public JComboBox getChoixClient() {
        return choixClient;
    }

    public Toolbar getMenu() {
        return menu;
    }

    public JPanel getForm() {
        return form;
    }

    public JButton getAjouterB() {
        return ajouterB;
    }

    public JPanel getMenuPanel() {
        return menuPanel;
    }

    public JSpinner getDateSpinner() {
        return dateSpinner;
    }

    public JSpinner getTimeSpinner() {
        return timeSpinner;
    }

    public JTextField getInterlocuteurTxt() {
        return interlocuteurTxt;
    }

    public JTextField getLieuTxt() {
        return lieuTxt;
    }

    public SpinnerDateModel getDateModel() {
        return dateModel;
    }

    public SpinnerDateModel getTimeModel() {
        return timeModel;
    }

    public JPanel getMessage() {
        return message;
    }

    public void setState(String msg){

        this.state.setText(msg);
    }
}



