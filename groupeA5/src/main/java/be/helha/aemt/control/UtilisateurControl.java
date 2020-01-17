package be.helha.aemt.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
import javax.servlet.http.Part;

import be.helha.aemt.ejb.GestionEleveEJB;
import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.entities.DemandeStage;
import be.helha.aemt.entities.Eleve;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class UtilisateurControl implements Serializable{

	private String nom="",prenom="",mdp="",message="",description="",email="";
	private int annee;
	private Part file;
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
	     return "index.xhtml?faces-redirect=true";
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
	
	public ImgEntite createImg(Part fichier) {
		InputStream initialStream = null;
	    byte[] buffer = null;
	    OutputStream outStream = null;
		try {
			initialStream = fichier.getInputStream();
			buffer = new byte[initialStream.available()];
			initialStream.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	 
		return new ImgEntite(buffer);
	}
	
	public String register() {
		el=new Eleve(nom,prenom,email,description,annee,sections,createImg(file),0);
		if(ejb.findOccurence(email)!=null) {
			setMessage("L'utilisateur existe déjà");
			setNom("");
			setPrenom("");
			setEmail("");
			setDescription("");
			setAnnee(0);
			setSections("");
			return "inscription.xhtml?faces-redirect=true";
		}
		//Utilisateur ul=new Utilisateur(nom+prenom+annee,mdp,"ancien");
		setMessage("");
		setNom("");
		setPrenom("");
		setEmail("");
		setDescription("");
		setAnnee(0);
		setSections("");		
		ejbEleve.add(el);
		return "index.xhtml?faces-redirect=true";
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
