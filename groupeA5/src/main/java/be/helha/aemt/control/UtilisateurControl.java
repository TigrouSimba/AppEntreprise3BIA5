package be.helha.aemt.control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.servlet.http.HttpServletRequest;

import be.helha.aemt.ejb.GestionEleveEJB;
import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.entities.DemandeStage;
import be.helha.aemt.entities.Eleve;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class UtilisateurControl implements Serializable{

	private String nom="",prenom="",mdp="",message="";
	private int annee;
	private String sections="";
	private Eleve el;
	private String tri="";
	private String tri2="";
	private String tri3="";
	private String option="";

	@EJB
	private GestionVisiteurEJB ejb;
	
	@EJB
	private GestionEleveEJB ejbEleve;

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

	public String getSections() {
		return sections;
	}

	public void setSections(String sections) {
		this.sections = sections;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
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
	
	public String getTri() {
		return tri;
	}


	public void setTri(String tri) {
		this.tri = tri;
	}
	
	public String getTri2() {
		return tri2;
	}


	public void setTri2(String tri2) {
		this.tri2 = tri2;
	}
	
	public String getTri3() {
		return tri3;
	}


	public void setTri3(String tri3) {
		this.tri3 = tri3;
	}

	public String doList() {
		return "list.xhtml";
	}
	
	public String doLogin() {
		return "login.xhtml";
	}

	public GestionVisiteurEJB getEjb() {
		return ejb;
	}

	public void setEjb(GestionVisiteurEJB ejb) {
		this.ejb = ejb;
	}
	
	public GestionEleveEJB getEjbEleve() {
		return ejbEleve;
	}

	public void setEjbEleve(GestionEleveEJB ejbEleve) {
		this.ejbEleve = ejbEleve;
	}

	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();
		final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		request.getSession(false).invalidate(); // on invalide
	     return "index.xhtml";
	}
	
	public ArrayList<Eleve>query()
	{
		ArrayList<Eleve>listeTrier = new ArrayList<Eleve>();
		Vector<Eleve>list =  (Vector<Eleve>) ejbEleve.findAllSections("Informatique de gestion");
		for (Eleve eleve : list) {
			if(eleve.getNom().startsWith(tri))
			{
				listeTrier.add(eleve);
				System.out.println(tri);
			}
			
		}
		tri="";
		return listeTrier;
	}
	
	public ArrayList<Eleve>query2()
	{
		ArrayList<Eleve>listeTrier2 = new ArrayList<Eleve>();
		Vector<Eleve>list =  (Vector<Eleve>) ejbEleve.findAllSections("Comptabilité");
		for (Eleve eleve : list) {
			if(eleve.getNom().startsWith(tri2))
			{
				listeTrier2.add(eleve);
				System.out.println(tri2);
			}
			
		}
		tri2="";
		return listeTrier2;
	}
	
	public List<Eleve> findAllSections(String sections) {		
		return ejbEleve.findSections2(sections,option);
	}
	
	public ArrayList<Eleve>query3()
	{
		ArrayList<Eleve>listeTrier3 = new ArrayList<Eleve>();
		Vector<Eleve>list =  (Vector<Eleve>) ejbEleve.findAllSections("Assistant de direction");
		for (Eleve eleve : list) {
			if(eleve.getNom().startsWith(tri3))
			{
				listeTrier3.add(eleve);
				System.out.println(tri3);
			}
			
		}
		tri3="";
		return listeTrier3;
	}
	
	public String register() {
		el=new Eleve(nom,prenom,annee,sections);
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
