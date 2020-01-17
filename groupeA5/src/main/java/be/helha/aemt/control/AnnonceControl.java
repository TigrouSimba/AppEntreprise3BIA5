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

	public GestionAnnonceEJB getEjb() {
		return ejb;
	}

	public void setEjb(GestionAnnonceEJB ejb) {
		this.ejb = ejb;
	}

	public String getNomEvenement() {
		return nomEvenement;
	}

	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}
	
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
	
	public String accepterEvenement(Annonce e) {
		e.setAccepter(1);
		ejb.add(e);
		return "annonce.xhtml";
	}
	
	public void addtoList() { 
	    imgs.add(createImg());
	}

	
	public ImgEntite createImg() {
		InputStream initialStream = null;
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

	public List<ImgEntite> getImgs() {
		return imgs;
	}

	public void setImgs(List<ImgEntite> imgs) {
		this.imgs = imgs;
	}

	public Part getImg() {
		return img;
	}

	public void setImg(Part img) {
		this.img = img;
	}

	public GestionImageEJB getEjbImg() {
		return ejbImg;
	}

	public void setEjbImg(GestionImageEJB ejbImg) {
		this.ejbImg = ejbImg;
	}
	
	public GestionVisiteurEJB getEjbVisiteur() {
		return ejbVisiteur;
	}

	public void setEjbVisiteur(GestionVisiteurEJB ejbVisiteur) {
		this.ejbVisiteur = ejbVisiteur;
	}

	public String deleteEvent(Annonce event) {
		ejb.delete(event);
		return "annonce.xhtml?faces-redirect=true";
		
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
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
	
	public void changeToModif(Annonce e) {
		nomModif=e.getNomEvenement();
		contenuModif=e.getContenu();
		eventToModif=e;
	}

	public String getNomModif() {
		return nomModif;
	}

	public void setNomModif(String nomModif) {
		this.nomModif = nomModif;
	}

	public String getContenuModif() {
		return contenuModif;
	}

	public void setContenuModif(String contenuModif) {
		this.contenuModif = contenuModif;
	}


	
}
