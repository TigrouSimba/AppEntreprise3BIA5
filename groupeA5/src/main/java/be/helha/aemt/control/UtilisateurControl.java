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
import be.helha.aemt.ejb.IGestionEleveEJB;
import be.helha.aemt.ejb.IGestionVisiteurEJB;
import be.helha.aemt.entities.Eleve;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class UtilisateurControl implements Serializable{

	private String nom="",prenom="",mdp="",message="";
	private int annee;
	private Eleve el;

	@EJB
	private IGestionVisiteurEJB ejb;
	
	@EJB
	private IGestionEleveEJB ejbEleve;

	public UtilisateurControl() {
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Eleve getEl() {
		return el;
	}

	public void setEl(Eleve el) {
		this.el = el;
	}
	
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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
	
	public IGestionEleveEJB getEjbEleve() {
		return ejbEleve;
	}

	public void setEjbEleve(IGestionEleveEJB ejbEleve) {
		this.ejbEleve = ejbEleve;
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();
		final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		request.getSession(false).invalidate(); // on invalide
	     return "index.xhtml";
	}
	
	public String register() {
		el=new Eleve(nom,prenom,annee);
		if(ejbEleve.findOccurence(el)==null) {
			setMessage("L'utilisateur n'existe pas");
			setNom("");
			setPrenom("");
			setAnnee(0);
			//return "inscription.xhtml"; 
			return "";
		}
		else if(ejb.findOccurence(nom+prenom+annee)!=null) {
			setMessage("L'utilisateur existe déjà");
			setNom("");
			setPrenom("");
			setAnnee(0);
			//return "inscription.xhtml";
			return "";
		}
		Utilisateur ul=new Utilisateur(nom+prenom+annee,mdp,"ancien");
		setMessage("");
		setNom("");
		setPrenom("");
		setAnnee(0);		
		ejb.add(ul);
		return "index.xhtml";
	}
	
	public String isConnected() {
		String nom=FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		if(nom==null) {
			return "false";
		}
		return "true";
	}
	
	public String isAdmin() {
		String nom=FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		if(nom==null) {
			return "false";
		}
		Utilisateur ul=ejb.findOccurence(nom);
		if(ul==null) {
			return "false";
		}
		if(ul.getGroupName().equals("admin")) {
			return "true";
		}
		return "false";
	}
	
	
}
