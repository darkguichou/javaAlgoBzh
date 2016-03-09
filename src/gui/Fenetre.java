package gui;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Fenetre extends JFrame{
	
	
	
	


	
	private static final long serialVersionUID = 1L;

	public Fenetre(Panel mainPanel){
		
		
		this.setTitle("Algo Breizh:");
        this.setMinimumSize(new Dimension(800, 400));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setEnabled(true);
        this.setVisible(true);
        this.getContentPane().add(mainPanel);
		
		
	}
	
	

}
