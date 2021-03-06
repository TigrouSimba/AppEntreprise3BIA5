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
	private String nom2="",prenom2="",description2="",email2="";
	private int annee;
	private Part file;
	private String sections="";
	private Eleve el;
	private String option="";

	@EJB
	private GestionVisiteurEJB ejb;
	
	@EJB
	private GestionEleveEJB ejbEleve;

	public UtilisateurControl() {
		
	}

	/**
	 * 
	 * @return la valeur de nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * change la valeur de nom par celui passe en parametre
	 * @param nom la valeur qui doit remplacer celle actuelle
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * 
	 * @return la valeur de prenom
	 */
	public String getPrenom() {
		return prenom;
	}
	
	/**
	 * 
	 * @return la valeur de nom2
	 */
	public String getNom2() {
		return nom2;
	}
	
	/**
	 * change la valeur de nom2 par celui passe en parametre
	 * @param nom2 la valeur qui doit remplacer celle actuelle
	 */
	public void setNom2(String nom2) {
		this.nom2 = nom2;
	}
	
	/**
	 * 
	 * @return la valeur de prenom2
	 */
	public String getPrenom2() {
		return prenom2;
	}
	
	/**
	 * change la valeur de prenom2 par celui passe en parametre
	 * @param prenom2 la valeur qui doit remplacer celle actuelle
	 */
	public void setPrenom2(String prenom2) {
		this.prenom2 = prenom2;
	}

	/**
	 * change la valeur de prenom par celui passe en parametre
	 * @param prenom la valeur qui doit remplacer celle actuelle
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * 
	 * @return la valeur de annee
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * change la valeur de annee par celui passe en parametre
	 * @param annee la valeur qui doit remplacer celle actuelle
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}

	/**
	 * 
	 * @return la valeur de message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * change la valeur de message par celui passe en parametre
	 * @param message la valeur qui doit remplacer celle actuelle
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * 
	 * @return la valeur de sections
	 */
	public String getSections() {
		return sections;
	}

	/**
	 * change la valeur de sections par celui passe en parametre
	 * @param sections la valeur qui doit remplacer celle actuelle
	 */
	public void setSections(String sections) {
		this.sections = sections;
	}

	/**
	 * 
	 * @return la valeur de option
	 */
	public String getOption() {
		return option;
	}

	/**
	 * change la valeur de option par celui passe en parametre
	 * @param option la valeur qui doit remplacer celle actuelle
	 */
	public void setOption(String option) {
		this.option = option;
	}

	/**
	 * 
	 * @return la valeur de el
	 */
	public Eleve getEl() {
		return el;
	}

	/**
	 * change la valeur de el par celui passe en parametre
	 * @param el la valeur qui doit remplacer celle actuelle
	 */
	public void setEl(Eleve el) {
		this.el = el;
	}
	
	/**
	 * 
	 * @return la valeur de mdp
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * change la valeur de mdp par celui passe en parametre
	 * @param mdp la valeur qui doit remplacer celle actuelle
	 */
	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	/**
	 * 
	 * @return la valeur de ejb
	 */
	public GestionVisiteurEJB getEjb() {
		return ejb;
	}

	/**
	 * change la valeur de ejb par celui passe en parametre
	 * @param ejb la valeur qui doit remplacer celle actuelle
	 */
	public void setEjb(GestionVisiteurEJB ejb) {
		this.ejb = ejb;
	}
	
	/**
	 * 
	 * @return la valeur de ejbEleve
	 */
	public GestionEleveEJB getEjbEleve() {
		return ejbEleve;
	}

	/**
	 * change la valeur de ejbEleve par celui passe en parametre
	 * @param ejbEleve la valeur qui doit remplacer celle actuelle
	 */
	public void setEjbEleve(GestionEleveEJB ejbEleve) {
		this.ejbEleve = ejbEleve;
	}
	
	/**
	 * 
	 * @return la valeur de description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * change la valeur de description par celui passe en parametre
	 * @param description la valeur qui doit remplacer celle actuelle
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 
	 * @return la valeur de file
	 */
	public Part getFile() {
		return file;
	}

	/**
	 * change la valeur de file par celui passe en parametre
	 * @param file la valeur qui doit remplacer celle actuelle
	 */
	public void setFile(Part file) {
		this.file = file;
	}

	/**
	 * 
	 * @return la valeur de email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * change la valeur de email par celui passe en parametre
	 * @param email la valeur qui doit remplacer celle actuelle
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return la valeur de description2
	 */
	public String getDescription2() {
		return description2;
	}
	
	/**
	 * change la valeur de description2 par celui passe en parametre
	 * @param description2 la valeur qui doit remplacer celle actuelle
	 */
	public void setDescription2(String description2) {
		this.description2 = description2;
	}
	
	/**
	 * 
	 * @return la valeur de email2
	 */
	public String getEmail2() {
		return email2;
	}
	
	/**
	 * change la valeur de email2 par celui passe en parametre
	 * @param email2 la valeur qui doit remplacer celle actuelle
	 */
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	/**
	 * permet a l'utilisateur de se deconnecter en invalidant la session
	 * @return la page d'accueil
	 */
	public String logout() {
		FacesContext context = FacesContext.getCurrentInstance();
		ExternalContext ec = context.getExternalContext();
		final HttpServletRequest request = (HttpServletRequest) ec.getRequest();
		request.getSession(false).invalidate(); // on invalide
	     return "index.xhtml?faces-redirect=true";
	}
	
	/**
	 * permet de modifier les valeurs de nom2 et prenom2
	 * @return la page d'informations des �l�ves
	 */
	public String afficherUtilisateur(Eleve item) {
		nom2 = item.getNom();
		prenom2 = item.getPrenom();
		description2 = item.getDescription();
		email2 = item.getEmail();
		return "informations.xhtml";
	}
	
	
	/**
	 * recupere une liste d'ancien grace a une section
	 * @return une liste d'anciens
	 */
	public List<Eleve> findAllSections(String sections) {		
		return ejbEleve.findSections2(sections,option);
	}
	
	/**
	 * permet de creer une image a partir d'un fichier importer depuis la page internet
	 * @return une ImgEntite contenant l'image
	 */
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
	
	/**
	 * permet d'ajouter un eleve dans la base de donnees lors de l'inscription
	 * @return la page d'accueil
	 */
	public String register() {
		el=new Eleve(nom,prenom,email,description,annee,sections,createImg(file),0,mdp);
		if(ejb.findOccurence(email)!=null) {
			setMessage("L'utilisateur existe d�j�");
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
	
	/**
	 * permet de determiner si le visiteur du site est actuellement connecter ou non
	 * @return "true" s'il est connecter sinon "false"
	 */
	public String isConnected() {
		String nom=FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		if(nom==null) {
			return "false";
		}
		return "true";
	}
	
	/**
	 * permet de determiner si le visiteur du site est actuellement connecter en tant que'admin ou non
	 * @return "true" s'il est connecter en tant qu'admin sinon "false"
	 */
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

	/**
	 * permet de changer une valeur d'un ancien pour qu'il soit considere comme accepter par l'admin
	 * @param e l'ancien a accepter
	 * @return la page d'accueil
	 */
	public String accepterEleve(Eleve e) {
		e.setAccepter(1);
		ejbEleve.add(e);
		Utilisateur ul=new Utilisateur(e.getEmail(),"ancien");
		ul.setPassword(e.getMdp());
		ejb.add(ul);
		return "admin.xhtml?faces-redirect=true";
	}
	
	
}
