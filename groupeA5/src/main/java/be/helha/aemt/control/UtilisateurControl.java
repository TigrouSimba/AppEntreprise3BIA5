package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.dao.VisiteurDAO;
import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.ejb.IGestionVisiteurEJB;
import be.helha.aemt.entities.Visiteur;

@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class UtilisateurControl implements Serializable{

	private String nom="Anonyme";
	
	@EJB
	private IGestionVisiteurEJB ejb;

	public UtilisateurControl() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String doList() {
		return "list.xhtml";
	}
	
	public String doLogin() {
		return "login.xhtml";
	}

	public IGestionVisiteurEJB getEjb() {
		return ejb;
	}

	public void setEjb(IGestionVisiteurEJB ejb) {
		this.ejb = ejb;
	}
	
	
	
	
	
}
