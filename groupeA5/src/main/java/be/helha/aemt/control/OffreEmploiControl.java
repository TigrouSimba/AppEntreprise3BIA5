package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import be.helha.aemt.ejb.IGestionOffreEmploiEJB;
import be.helha.aemt.ejb.IGestionVisiteurEJB;
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
	private IGestionOffreEmploiEJB ejb;
	
	@EJB
	private IGestionVisiteurEJB ejbVisiteur;

	public OffreEmploiControl() {
		
	}
	//Getteur des attributs
	public IGestionOffreEmploiEJB getEjb() {
		return ejb;
	}

	public void setEjb(IGestionOffreEmploiEJB ejb) {
		this.ejb = ejb;
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

	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}

	public int getId() {
		return id;
	}

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
	public IGestionVisiteurEJB getEjbVisiteur() {
		return ejbVisiteur;
	}
	public void setEjbVisiteur(IGestionVisiteurEJB ejbVisiteur) {
		this.ejbVisiteur = ejbVisiteur;
	}
	
	
}
