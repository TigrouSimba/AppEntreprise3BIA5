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
	private String numero;
	private int isValide;
	private int estUnEmploi;
	@ManyToOne(targetEntity=Utilisateur.class,cascade= CascadeType.PERSIST)
	private Utilisateur createurStage;
	
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
	
	public int getIsValide() {
		return isValide;
	}

	public void setIsValide(int isValide) {
		this.isValide = isValide;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getMailEntreprise() {
		return mailEntreprise;
	}

	public void setMailEntreprise(String mailEntreprise) {
		this.mailEntreprise = mailEntreprise;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Utilisateur getCreateurStage() {
		return createurStage;
	}

	public void setCreateurStage(Utilisateur createurStage) {
		this.createurStage = createurStage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getDuree() {
		return Duree;
	}

	public void setDuree(String duree) {
		Duree = duree;
	}

	public int getEstUnEmploi() {
		return estUnEmploi;
	}

	public void setEstUnEmploi(int estUnEmploi) {
		this.estUnEmploi = estUnEmploi;
	}

	public DemandeStage() {
		super();
		isValide = 0;
	}

	public DemandeStage(String nom, String contenu) {
		super();
		this.nom = nom;
		this.contenu = contenu;
	}
	@Override
	public String toString() {
		return "DemandeStage [id=" + id + ", nom=" + nom + ", contenu=" + contenu + "]";
	}


}
