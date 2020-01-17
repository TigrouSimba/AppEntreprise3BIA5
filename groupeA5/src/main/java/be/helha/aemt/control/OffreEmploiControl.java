package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionOffreEmploiEJB;
import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.Utilisateur;
@SessionScoped
@Named
public class OffreEmploiControl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	//atribut utiliser pour recuperer les valeurs dans les formualaire
	
	
	private String nom ="kevin";
	private String contenu="contenu";
	private String categorie="2";
	private int id;
	
	
	@EJB
	private GestionOffreEmploiEJB ejb;
	
	@EJB
	private GestionVisiteurEJB ejbVisiteur;
	//Constructeur
	public OffreEmploiControl() {
		
	}
	//Getteur des attributs
	public GestionOffreEmploiEJB getEjb() {
		return ejb;
	}
	//Permet de changer la valeur de l'attribut ejb
	public void setEjb(GestionOffreEmploiEJB ejb) {
		this.ejb = ejb;
	}

	public String getNom() {
		return nom;
	}
	//Permet de changer la valeur de l'attribut nom
	public void setNom(String nom) {
		this.nom = nom;
	}
	//Permet de recuperer la valeur de l'attribut contenu
	public String getContenu() {
		return contenu;
	}
	//Permet de changer la valeur de l'attribut Contenu
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getCategorie() {
		return categorie;
	}
	//Permet de changer la valeur de l'attribut categorie
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	//Permet de recuperer la valeur de l'attribut id
	public int getId() {
		return id;
	}
	//Permet de changer la valeur de l'attribut id
	public void setId(int id) {
		this.id = id;
	}
	
	//Methode
	//Ajoute L'offre d'emploie
	public void post()
	{
		
		
		//System.out.println(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		Utilisateur us = ejbVisiteur.findOccurence(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		//System.out.println(usc.getEjb().findOccurence(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser()).toString());
		//System.out.println(us.toString());
		//System.out.println(us.toString());
		ejb.add(new OffreEmploi(nom, contenu, categorie, us));
		System.out.println(us);
	}
	//Permet de recuperer la valeur de l'attribut ejb
	public GestionVisiteurEJB getEjbVisiteur() {
		return ejbVisiteur;
	}
	//Permet de changer la valeur de l'attribut ejb
	public void setEjbVisiteur(GestionVisiteurEJB ejbVisiteur) {
		this.ejbVisiteur = ejbVisiteur;
	}
	
	
}
