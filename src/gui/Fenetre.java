package gui;

import metier.Commercial;
import metier.Connexion;
import metier.ListeClients;
import metier.Utilisateur;

import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class Fenetre extends JFrame implements Observer{
	
	
	
	

    Connexion connexion;
    ListeClients listeClients;
	private JPanel connexionView;
    private JScrollPane listeClientView;
    private Commercial commercial;
	private static final long serialVersionUID = 1L;

	public Fenetre(JPanel connexionView, JScrollPane listeClientView, Connexion connexion, ListeClients listeCliens){
		


        this.connexion = connexion;
        this.listeClients = listeCliens;
        connexion.addObserver(this);
        listeClients.addObserver(this);
		this.setTitle("Algo Breizh:");
        this.setMinimumSize(new Dimension(800, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setEnabled(true);
        this.setVisible(true);
        this.connexionView = connexionView;
        this.listeClientView = listeClientView;
        this.getContentPane().add(this.connexionView);
		
		
	}


    public void setMainPanel(JPanel mainPanel) {
        this.connexionView = mainPanel;
        this.getContentPane().add(mainPanel);
    }

    @Override
    public void update(Observable o, Object arg) {


        if (o instanceof Connexion) {

            if (connexion.getEtat()) {


                this.commercial = this.connexion.getCommercial();
                this.getContentPane().removeAll();
                listeClients.create();
                ListeClientTable table = new ListeClientTable(listeClients.getUtilisateurs());
                table.create();
                listeClientView.setViewportView(table.getTable());
                this.getContentPane().add(listeClientView);

                validate();

            }else{

                connexionView.add(new JLabel("Erreur de connexion."));
                connexionView.revalidate();
                connexionView.repaint();
                validate();


            }

        }

        if (o instanceof ListeClients){

            System.out.println("ta");

        }

    }
}
