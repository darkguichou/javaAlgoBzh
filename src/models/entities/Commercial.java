package models.entities;

public class Commercial{


	private int id;
	private String code;
	private String email;
	private String nom;
	private int codeZone;


	public Commercial(int id, String code, String email, String nom, int zone) {

		this.id = id;
		this.code = code;
		this.email = email;
		this.nom = nom;
		this.codeZone = zone;

		
		
		
	}
	
	public Commercial(){

		
	}

	public void creer(int id, String code, String email, String nom, int codeZone){


		this.id = id;
		this.code = code;
		this.email = email;
		this.nom = nom;
		this.codeZone = codeZone;

	}


	public String getCode() {
		return code;
	}

	public int getId() {
		return id;
	}

	public int getZone() {
		return codeZone;
	}

	public String getEmail() {
		return email;
	}

	public String getNom() {
		return nom;
	}


}
