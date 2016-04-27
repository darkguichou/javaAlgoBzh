package metier;

public class Utilisateur {

    private int id;
    private String code;
    private String email;
    private String nom;
    private int codeZone;
    private String ville;
    private String numTel;


    public Utilisateur(int id, String code, String email, String nom, int codeZone, String numTel, String ville) {


        this.id = id;
        this.code = code;
        this.email = email;
        this.nom = nom;
        this.codeZone = codeZone;
        this.numTel = numTel;
        this.ville = ville;


    }

    public Utilisateur() {


    }

    public void creer(int id, String code, String email, String nom, int codeZone) {

        this.id = id;
        this.code = code;
        this.email = email;
        this.nom = nom;
        this.codeZone = codeZone;


    }


    public void afficher() {


        System.out.println(this.id + "\n" + this.code + "\n" + this.email + "\n" + this.nom);


    }

    public String getCodeClient() {
        return code;
    }

    public int getCOdeZone() {


        return codeZone;

    }

    public int getCodeZone() {
        return codeZone;
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getEmail() {
        return email;
    }

    public String getNom() {
        return nom;
    }


    public String getNumTel() {
        return numTel;
    }

    public String getVille() {
        return ville;
    }
}
