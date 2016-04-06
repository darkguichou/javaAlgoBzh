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
	private String zone;
	
	
	public Visite (int id, Date date, Time heure, String lieu, String interlocuteur, int idClient, String zone){
		
		
		this.id = id;
		this.date = date;
		this.lieu = lieu;
		this.heure = heure;
		this.interlocuteur = interlocuteur;
		this.idClient = idClient;
		this.zone = zone;
		
		
		
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

	public int getId() {
		return id;
	}

	public Date getDate() {
		return date;
	}

	public int getIdClient() {
		return idClient;
	}

	public String getInterlocuteur() {
		return interlocuteur;
	}

	public String getLieu() {
		return lieu;
	}

	public String getZone() {
		return zone;
	}

	public Time getHeure() {
		return heure;
	}
}
