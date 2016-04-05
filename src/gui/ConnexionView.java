package gui;



import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

public class ConnexionView extends Panel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField idField;
	private JPasswordField pwdField;
	private JButton bouton;

	public ConnexionView(){
		
		
		this.idField = new JTextField("id");
		this.pwdField = new JPasswordField("pwd");
		this.bouton = new JButton("se Connecter");

		
		
		
	}

	public void init(){

		idField.setColumns(10);
		pwdField.setColumns(10);

		this.add(new JLabel("Connexion:"));
		this.add(idField);
		this.add(pwdField);
		this.add(bouton);

	}

	public JTextField getIdField() {
		return idField;
	}

	public JPasswordField getPwdField() {
		return pwdField;
	}


	public JButton getBouton() {
		return bouton;
	}
}
