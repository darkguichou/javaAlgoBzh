package metier;

import java.sql.Date;
import java.sql.Time;

public class Visite {
	
	
	private int id;
	private Date date;
	private Time heure;
	private String lieu;
	private String interlocuteur;
	private int  idClient;
	
	
	public Visite (int id, Date date, Time heure, String lieu, String interlocuteur, int idClient){
		
		
		this.id = id;
		this.date = date;
		this.lieu = lieu;
		this.interlocuteur = interlocuteur;
		this.idClient = idClient;
		
		
		
	}
	
	public Visite(){
		
		
		
	}
	
	public void Add(int id, Date date, Time heure, String lieu, String interlocuteur, int idClient){
		
		
		
		this.id = id;
		this.date = date;
		this.lieu = lieu;
		this.interlocuteur = interlocuteur;
		this.idClient = idClient;
		
		
	}
	
	
	public void afficher(){
		
		System.out.println(id);
		
		
	}

}
