package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;

import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.ejb.IGestionVisiteurEJB;

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
	
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();
		final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		request.getSession(false).invalidate(); // on invalide
	     return "index.xhtml";
	}
	
	
	
	
}
