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

		this.add(new JLabel("Connexion:"));
		this.add(idField);
		this.add(pwdField);
		this.add(bouton);
		this.add(error);

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
