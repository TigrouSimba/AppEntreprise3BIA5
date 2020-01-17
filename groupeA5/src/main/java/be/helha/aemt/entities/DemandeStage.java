package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DemandeStage implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String contenu;
	private Date date;
	private String entreprise;
	private String mailEntreprise;
	private String Duree;
	
	private String numero;
	private int isValide;
	private int estUnEmploi;
	@ManyToOne(targetEntity=Utilisateur.class,cascade= CascadeType.PERSIST)
	private Utilisateur createurStage;
	private String section ="";
	private String nomPersoRes;
	
	//Constructeur de Demande de Stage
	public DemandeStage(String nom, String contenu, Date date, String entreprise, String mailEntreprise, String duree,
			String numero, int isValide, int estUnEmploi, Utilisateur createurStage, String section,
			String nomPersoRes) {
		super();
		this.nom = nom;
		this.contenu = contenu;
		this.date = date;
		this.entreprise = entreprise;
		this.mailEntreprise = mailEntreprise;
		Duree = duree;
		this.numero = numero;
		this.isValide = isValide;
		this.estUnEmploi = estUnEmploi;
		this.createurStage = createurStage;
		this.section = section;
		this.nomPersoRes = nomPersoRes;
	}
	//Constructeur de Demande de Stage
	public DemandeStage(Integer id, String nom, String contenu, Date date, String entreprise, String mailEntreprise,
			String duree, String numero, int isValide, int estUnEmploi, Utilisateur createurStage, String section,
			String nomPersoRes) {
		super();
		this.id = id;
		this.nom = nom;
		this.contenu = contenu;
		this.date = date;
		this.entreprise = entreprise;
		this.mailEntreprise = mailEntreprise;
		Duree = duree;
		this.numero = numero;
		this.isValide = isValide;
		this.estUnEmploi = estUnEmploi;
		this.createurStage = createurStage;
		this.section = section;
		this.nomPersoRes = nomPersoRes;
	}
	//Constructeur de Demande de Stage
	public DemandeStage(String nom, String contenu, Date date, String entreprise, String mailEntreprise, String duree,
			String numero, int isValide, int estUnEmploi, Utilisateur createurStage, String section) {
		super();
		this.nom = nom;
		this.contenu = contenu;
		this.date = date;
		this.entreprise = entreprise;
		this.mailEntreprise = mailEntreprise;
		Duree = duree;
		this.numero = numero;
		this.isValide = isValide;
		this.estUnEmploi = estUnEmploi;
		this.createurStage = createurStage;
		this.section = section;
	}
	//Retoune la valeur de l'attribut section
	public String getSection() {
		return section;
	}
	
	public void setSection(String section) {
		this.section = section;
	}

	public DemandeStage(String nom, String contenu, Date date, String entreprise, String mailEntreprise, String duree,
			String numero, int isValide, int estUnEmploi, Utilisateur createurStage) {
		super();
		this.nom = nom;
		this.contenu = contenu;
		this.date = date;
		this.entreprise = entreprise;
		this.mailEntreprise = mailEntreprise;
		Duree = duree;
		this.numero = numero;
		this.isValide = isValide;
		this.estUnEmploi = estUnEmploi;
		this.createurStage = createurStage;
	}

	public DemandeStage(Integer id, String nom, String contenu, Date date, String entreprise, String mailEntreprise,
			String duree, String numero, int isValide, int estUnEmploi, Utilisateur createurStage) {
		super();
		this.id = id;
		this.nom = nom;
		this.contenu = contenu;
		this.date = date;
		this.entreprise = entreprise;
		this.mailEntreprise = mailEntreprise;
		Duree = duree;
		this.numero = numero;
		this.isValide = isValide;
		this.estUnEmploi = estUnEmploi;
		this.createurStage = createurStage;
		
	}
	
	public DemandeStage(Integer id, String nom, String contenu, Date date, String entreprise, String mailEntreprise,
			String numero, Utilisateur createurStage) {
		super();
		this.id = id;
		this.nom = nom;
		this.contenu = contenu;
		this.date = date;
		this.entreprise = entreprise;
		this.mailEntreprise = mailEntreprise;
		this.numero = numero;
		this.createurStage = createurStage;
		isValide = 0;
	}

	//Constructeur de la classe 
	

	

	public DemandeStage(String nom, String contenu, Date date, String entreprise, String mailEntreprise, String numero,
			Utilisateur createurStage) {
		super();
		this.nom = nom;
		this.contenu = contenu;
		this.date = date;
		this.entreprise = entreprise;
		this.mailEntreprise = mailEntreprise;
		this.numero = numero;
		this.createurStage = createurStage;
	}

	public DemandeStage(Integer id, String nom, String contenu) {
		super();
		this.id = id;
		this.nom = nom;
		this.contenu = contenu;
	}
	//Getteur et setteur des differents attributs
	
	public DemandeStage(Integer id, String nom, String contenu, Date date, String entreprise, String mailEntreprise,
			String duree, String numero, int isValide, int estUnEmploi, Utilisateur createurStage, String section) {
		super();
		this.id = id;
		this.nom = nom;
		this.contenu = contenu;
		this.date = date;
		this.entreprise = entreprise;
		this.mailEntreprise = mailEntreprise;
		Duree = duree;
		this.numero = numero;
		this.isValide = isValide;
		this.estUnEmploi = estUnEmploi;
		this.createurStage = createurStage;
		this.section = section;
	}
	//Retoune la valeur de l'attribut isValide
	public int getIsValide() {
		return isValide;
	}
	//Permet de changer la valeur de l'attribut isValide
	public void setIsValide(int isValide) {
		this.isValide = isValide;
	}
	//Retoune la valeur de l'attribut Date
	public Date getDate() {
		return date;
	}
	//Permet de changer la valeur de l'attribut Date
	public void setDate(Date date) {
		this.date = date;
	}
	//Retoune la valeur de l'attribut entreprise
	public String getEntreprise() {
		return entreprise;
	}
	//Permet de changer la valeur de l'attribut entreprise
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	//Retoune la valeur de l'attribut mailEntreprise
	public String getMailEntreprise() {
		return mailEntreprise;
	}
	//Permet de changer la valeur de l'attribut MailEntreprise
	public void setMailEntreprise(String mailEntreprise) {
		this.mailEntreprise = mailEntreprise;
	}
	//Retoune la valeur de l'attribut numero
	public String getNumero() {
		return numero;
	}
	//Permet de changer la valeur de l'attribut setNumero
	public void setNumero(String numero) {
		this.numero = numero;
	}
	//Retoune la valeur de l'attribut du createurStage
	public Utilisateur getCreateurStage() {
		return createurStage;
	}
	//Permet de changer la valeur de l'attribut setCreateur
	public void setCreateurStage(Utilisateur createurStage) {
		this.createurStage = createurStage;
	}
	//Retoune la valeur de l'attribut ID
	public Integer getId() {
		return id;
	}
	//Permet de changer la valeur de l'attribut Id
	public void setId(Integer id) {
		this.id = id;
	}
	//Retoune la valeur de l'attribut nom
	public String getNom() {
		return nom;
	}
	//Permet de changer la valeur de l'attribut nom
	public void setNom(String nom) {
		this.nom = nom;
	}
	//Retoune la valeur de l'attribut contenu
	public String getContenu() {
		return contenu;
	}
	//Permet de changer la valeur de l'attribut Contenu
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	//Retoune la valeur de l'attribut Durée
	public String getDuree() {
		return Duree;
	}
	//Permet de changer la valeur de l'attribut Duree
	public void setDuree(String duree) {
		Duree = duree;
	}
	//Retoune la valeur de l'attribut estUnEmploi
	public int getEstUnEmploi() {
		return estUnEmploi;
	}
	//Permet de changer la valeur de l'attribut estEmploi
	public void setEstUnEmploi(int estUnEmploi) {
		this.estUnEmploi = estUnEmploi;
	}
	//Retoune la valeur de l'attribut NomPersoRes
	public String getNomPersoRes() {
		return nomPersoRes;
	}
	//Permet de changer la valeur de l'attribut nomPersoRes
	public void setNomPersoRes(String nomPersoRes) {
		this.nomPersoRes = nomPersoRes;
	}
	//Constructeur de demande Stage
	public DemandeStage() {
		super();
		isValide = 0;
	}
	//Contructeur de demande deStage
	public DemandeStage(String nom, String contenu) {
		super();
		this.nom = nom;
		this.contenu = contenu;
	}
	//retourne un affichage d'un toString
	@Override
	public String toString() {
		return "DemandeStage [id=" + id + ", nom=" + nom + ", contenu=" + contenu + "]";
	}


}
