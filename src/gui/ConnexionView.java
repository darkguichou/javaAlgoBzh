package gui;



import javax.swing.*;
import javax.swing.plaf.DimensionUIResource;
import java.awt.*;

public class ConnexionView extends JPanel  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField idField;
	private JPasswordField pwdField;
	private JLabel error;
	private JButton bouton;
	private Image image;

	public ConnexionView(){
		
		
		this.idField = new JTextField("id");
		this.pwdField = new JPasswordField("pwd");
		this.bouton = new JButton("se Connecter");
		this.image = new ImageIcon("../images/laitue.JPG").getImage();
        this.error = new JLabel("");

		
		
		
	}

	public void init(){


        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);

		idField.setColumns(10);
		pwdField.setColumns(10);


		this.setLayout(new GridBagLayout());
        GridBagConstraints constraint = new GridBagConstraints();
        constraint.gridx = 1;
        constraint.gridy = 1;
        constraint.insets = new Insets(10,0, 0, 10);


		this.add(new JLabel("Connexion:"), constraint);
        constraint.gridx = 1;
        constraint.gridy = 2;
		this.add(idField, constraint);
        constraint.gridx = 1;
        constraint.gridy = 3;
		this.add(pwdField, constraint);
        constraint.gridx = 1;
        constraint.gridy = 5;
		this.add(bouton, constraint);
        constraint.gridx = 1;
        constraint.gridy = 6;
		this.add(error, constraint);

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


	public JLabel getError() {

		return error;
	}


}
