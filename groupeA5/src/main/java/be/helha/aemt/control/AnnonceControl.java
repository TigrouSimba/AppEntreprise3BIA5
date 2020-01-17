package be.helha.aemt.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

import be.helha.aemt.ejb.GestionAnnonceEJB;
import be.helha.aemt.ejb.GestionEvenementEJB;
import be.helha.aemt.ejb.GestionImageEJB;
import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Utilisateur;


@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class AnnonceControl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	@EJB
	private GestionAnnonceEJB ejb;
	
	@EJB
	private GestionImageEJB ejbImg;
	
	@EJB
	private GestionVisiteurEJB ejbVisiteur;
	
	private String nomEvenement="",contenu="",nomModif,contenuModif;	
	
	private List<ImgEntite> imgs=new ArrayList<ImgEntite>();
	
	private Part img;
	
	private Annonce eventToModif;

	public AnnonceControl() {
		
	}

	/**
	 * 
	 * @return la valeur de ejb
	 */
	public GestionAnnonceEJB getEjb() {
		return ejb;
	}

	/**
	 * change la valeur de ejb par celui passe en parametre
	 * @param ejb la valeur qui doit remplacer celle actuelle
	 */
	public void setEjb(GestionAnnonceEJB ejb) {
		this.ejb = ejb;
	}

	/**
	 * 
	 * @return la valeur de nomEvenement
	 */
	public String getNomEvenement() {
		return nomEvenement;
	}

	/**
	 * change la valeur de nomEvenement par celui passe en parametre
	 * @param nomEvenement la valeur qui doit remplacer celle actuelle
	 */
	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}
	
	/**
	 * 
	 * @return la valeur de imgs
	 */
	public List<ImgEntite> getImgs() {
		return imgs;
	}

	/**
	 * change la valeur de imgs par celui passe en parametre
	 * @param imgs la valeur qui doit remplacer celle actuelle
	 */
	public void setImgs(List<ImgEntite> imgs) {
		this.imgs = imgs;
	}

	/**
	 * 
	 * @return la valeur de img
	 */
	public Part getImg() {
		return img;
	}

	/**
	 * change la valeur de img par celui passe en parametre
	 * @param img la valeur qui doit remplacer celle actuelle
	 */
	public void setImg(Part img) {
		this.img = img;
	}

	/**
	 * 
	 * @return la valeur de ejbImg
	 */
	public GestionImageEJB getEjbImg() {
		return ejbImg;
	}

	/**
	 * change la valeur de ejbImg par celui passe en parametre
	 * @param ejbImg la valeur qui doit remplacer celle actuelle
	 */
	public void setEjbImg(GestionImageEJB ejbImg) {
		this.ejbImg = ejbImg;
	}
	
	/**
	 * 
	 * @return la valeur de ejbVisiteur
	 */
	public GestionVisiteurEJB getEjbVisiteur() {
		return ejbVisiteur;
	}

	/**
	 * change la valeur de ejbVisiteur par celui passe en parametre
	 * @param ejbVisiteur la valeur qui doit remplacer celle actuelle
	 */
	public void setEjbVisiteur(GestionVisiteurEJB ejbVisiteur) {
		this.ejbVisiteur = ejbVisiteur;
	}
	
	/**
	 * 
	 * @return la valeur de contenu
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * change la valeur de contenu par celui passe en parametre
	 * @param contenu la valeur qui doit remplacer celle actuelle
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	/**
	 * 
	 * @return la valeur de nomModif
	 */
	public String getNomModif() {
		return nomModif;
	}

	/**
	 * change la valeur de nomModif par celui passe en parametre
	 * @param nomModif la valeur qui doit remplacer celle actuelle
	 */
	public void setNomModif(String nomModif) {
		this.nomModif = nomModif;
	}

	/**
	 * 
	 * @return la valeur de contenuModif
	 */
	public String getContenuModif() {
		return contenuModif;
	}

	/**
	 * change la valeur de contenuModif par celui passe en parametre
	 * @param contenuModif la valeur qui doit remplacer celle actuelle
	 */
	public void setContenuModif(String contenuModif) {
		this.contenuModif = contenuModif;
	}
	
	/**
	 * permet d'ajouter une annonce dans la base de données
	 * @return la page d'accueil
	 */
	public String ajoutEvenement() {
		if(nomEvenement.equals("")){
			return "annonce.xhtml?faces-redirect=true";
		}
		Utilisateur us = ejbVisiteur.findOccurence(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		
		Annonce el =new Annonce(nomEvenement,contenu,0,us);
		if(us.getGroupName().equals("admin")) {
			el.setAccepter(1);
		}
		//ejb.add(el);
		//el.setImgsEvenement(imgs);
		for (ImgEntite imgEntite : imgs) {
			imgEntite.setAnnonce(el);
			//ejbImg.add2(imgEntite);
		}
		//ejbImg.addList(imgs);
		el.setImgsEvenement(imgs);
		ejb.add(el);
		nomEvenement="";
		contenu="";
		imgs.clear();
		return "annonce.xhtml?faces-redirect=true";
	}
	
	/**
	 * permet de modifier une annonce dans la base de données
	 * @return la page d'accueil
	 */
	public String modifEvenement() {
		if(nomModif.equals("")){
			return "annonce.xhtml?faces-redirect=true";
		}
		Utilisateur us = ejbVisiteur.findOccurence(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		
		eventToModif.setNomEvenement(nomModif);
		eventToModif.setContenu(contenuModif);
		if(!eventToModif.getUser().getGroupName().equals("admin")) {
			eventToModif.setAccepter(0);
		}
		
		ejb.add(eventToModif);
		nomModif="";
		contenuModif="";
		eventToModif=null;
		return "annonce.xhtml?faces-redirect=true";
	}
	
	/**
	 * permet de changer une valeur d'une annonce pour qu'elle soit considere comme accepter par l'admin
	 * @param e l'annonce a accepter
	 * @return la page d'annonce
	 */
	public String accepterEvenement(Annonce e) {
		e.setAccepter(1);
		ejb.add(e);
		return "annonce.xhtml?faces-redirect=true";
	}
	
	/**
	 * permet d'ajouter une image dans la liste des images de l'annonce
	 */
	public void addtoList() { 
	    imgs.add(createImg());
	}

	/**
	 * permet de creer une image a partir d'un fichier importer depuis la page internet
	 * @return une ImgEntite contenant l'image
	 */
	public ImgEntite createImg() {
		InputStream initialStream = null;
		//pour etre envoyer sur le serveur, l'image doit etre recuperer en type Part depuis la page
		//internet et envoyer en type byte[] pour etre reconnu en blob dans la base de donnees
	    byte[] buffer = null;
	    OutputStream outStream = null;
		try {
			initialStream = img.getInputStream();
			buffer = new byte[initialStream.available()];
			initialStream.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		
		return new ImgEntite(buffer);
	}

	/**
	 * permet de supprimer une annonce de la base de donnees
	 * @param event l'annonce a supprimer
	 * @return la page des annonces
	 */
	public String deleteEvent(Annonce event) {
		ejb.delete(event);
		return "annonce.xhtml?faces-redirect=true";
		
	}

	/**
	 * permet de savoir si l'annonce actuelle est creer par l'utilisateur connecter
	 * @param e l'annonce
	 * @return "true" s'il est le createur sinon "false"
	 */
	public String isCreator(Annonce e) {
		String nom=FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
		if(nom==null) {
			return "false";
		}
		Utilisateur ul=ejbVisiteur.findOccurence(nom);
		if(ul==null) {
			return "false";
		}
		if (e.getUser().getLogin().equals(nom) || ul.getGroupName().equals("admin")) {
			return "true";
		}
		return "false";
	}
	
	/**
	 * permet de donner les valeurs de l'annonce a modifier dans les champs correspondants
	 * @param e l'annonce a modifier
	 */
	public void changeToModif(Annonce e) {
		nomModif=e.getNomEvenement();
		contenuModif=e.getContenu();
		eventToModif=e;
	}

	
	
}
