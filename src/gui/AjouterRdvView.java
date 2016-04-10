package gui;

import dao.UtilisateursDao;
import metier.Utilisateur;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by guillaume on 07/04/16.
 */
public class AjouterRdvView extends JPanel{



    private Toolbar menu;
    private JComboBox choixClient;
    private JFormattedTextField dateField;
    private JButton ajouterB;
    private String[] utilisateurs;
    private UtilisateursDao utilisateursDao;


    public AjouterRdvView(UtilisateursDao utilisateursDao){

        this.utilisateursDao = utilisateursDao;
        this.menu = new Toolbar();
        this.setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel();
        JPanel form = new JPanel();
        menuPanel.add(this.menu);
        this.choixClient = new JComboBox();
        form.add(new JLabel("Nouveau RDV:"));
        form.add(new JLabel("Client:"));
        form.add(choixClient);
        JSpinner dateSpinner = new JSpinner();
        dateSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
        dateEditor.getTextField().setEditable(false);
        dateSpinner.setEditor(dateEditor);

        form.add(new JLabel("Date:"));
        form.add(dateSpinner);
        JSpinner timeSpinner = new JSpinner();
        timeSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor =  new JSpinner.DateEditor(timeSpinner, "hh-mm-ss");
        timeEditor.getTextField().setEditable(false);
        timeSpinner.setEditor(timeEditor);
        form.add(new JLabel("heure:"));
        form.add(timeSpinner);
        form.add(new JLabel("Lieu"));
        JTextField lieuTxt = new JTextField();
        lieuTxt.setColumns(10);
        form.add(lieuTxt);
        form.add(new JLabel("Interlocuteur"));
        JTextField interlocuteurTxt = new JTextField();
        interlocuteurTxt.setColumns(10);
        form.add(interlocuteurTxt);
        this.ajouterB = new JButton("Enregistrer");
        form.add(ajouterB);
        form.revalidate();
        form.repaint();

        this.add(form, BorderLayout.CENTER);

        this.add(menuPanel, BorderLayout.NORTH);


    }


    public void reInit(){

        this.removeAll();
        this.menu = new Toolbar();
        this.setLayout(new BorderLayout());
        JPanel menuPanel = new JPanel();
        JPanel form = new JPanel();
        menuPanel.add(this.menu);
        this.choixClient = new JComboBox();
        form.add(new JLabel("Nouveau RDV:"));
        form.add(new JLabel("Client:"));
        form.add(choixClient);
        JSpinner dateSpinner = new JSpinner();
        dateSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "dd-MM-yyyy");
        dateEditor.getTextField().setEditable(false);
        dateSpinner.setEditor(dateEditor);

        form.add(new JLabel("Date:"));
        form.add(dateSpinner);
        JSpinner timeSpinner = new JSpinner();
        timeSpinner.setModel(new SpinnerDateModel());
        JSpinner.DateEditor timeEditor =  new JSpinner.DateEditor(timeSpinner, "hh-mm-ss");
        timeEditor.getTextField().setEditable(false);
        timeSpinner.setEditor(timeEditor);
        form.add(new JLabel("heure:"));
        form.add(timeSpinner);
        form.add(new JLabel("Lieu"));
        JTextField lieuTxt = new JTextField();
        lieuTxt.setColumns(10);
        form.add(lieuTxt);
        form.add(new JLabel("Interlocuteur"));
        JTextField interlocuteurTxt = new JTextField();
        interlocuteurTxt.setColumns(10);
        form.add(interlocuteurTxt);
        this.ajouterB = new JButton("Enregistrer");
        form.add(ajouterB);
        form.revalidate();
        form.repaint();
        menu.revalidate();
        menu.repaint();

        this.add(form, BorderLayout.CENTER);

        this.add(menuPanel, BorderLayout.NORTH);



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
}


