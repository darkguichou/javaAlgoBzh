package gui;

import javafx.scene.control.PasswordField;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controllers.ConnexionListener;

public class ConnexionView extends Panel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField idField;
	private JPasswordField pwdField;

	public ConnexionView(){
		
		
		this.idField = new JTextField("id");
		this.pwdField = new JPasswordField("pwd");
		
		this.add(new JLabel("Connexion:"));
		this.add(idField);
		this.add(pwdField);
		JButton bouton = new JButton("se Connecter");
		bouton.addMouseListener(new ConnexionListener(this));
		this.add(bouton);
		
		
		
	}

	public JTextField getIdField() {
		return idField;
	}

	public JPasswordField getPwdField() {
		return pwdField;
	}
	
	
	
	

}
