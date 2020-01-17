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

import be.helha.aemt.ejb.GestionEvenementEJB;
import be.helha.aemt.ejb.GestionImageEJB;
import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Utilisateur;


@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class EvenementControl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	@EJB
	private GestionEvenementEJB ejb;
	
	@EJB
	private GestionVisiteurEJB ejbVisiteur;
	
	private String nomEvenement="",contenu="",nomModif,contenuModif,messageBienvenue;	
	
	private Evenement eventToModif;

	public EvenementControl() {
		
	}

	public GestionEvenementEJB getEjb() {
		return ejb;
	}

	public void setEjb(GestionEvenementEJB ejb) {
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
			return "index.xhtml?faces-redirect=true";
		}
		Utilisateur us = ejbVisiteur.findOccurence(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		
		Evenement el =new Evenement(nomEvenement,contenu,0,us);
		if(us.getGroupName().equals("admin")) {
			el.setAccepter(1);
		}
	
		ejb.add(el);
		nomEvenement="";
		contenu="";
		return "index.xhtml?faces-redirect=true";
	}
	
	public String modifEvenement() {
		if(nomModif.equals("")){
			return "index.xhtml?faces-redirect=true";
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
		return "index.xhtml?faces-redirect=true";
	}
	
	public String accepterEvenement(Evenement e) {
		e.setAccepter(1);
		ejb.add(e);
		return "index.xhtml";
	}

	
	public GestionVisiteurEJB getEjbVisiteur() {
		return ejbVisiteur;
	}

	public void setEjbVisiteur(GestionVisiteurEJB ejbVisiteur) {
		this.ejbVisiteur = ejbVisiteur;
	}

	public String deleteEvent(Evenement event) {
		ejb.delete(event);
		return "index.xhtml?faces-redirect=true";
		
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public String getMessageBienvenue() {
		File file = new File(
				getClass().getClassLoader().getResource("message.txt").getFile()
			);	
		  BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		  
		  String st,tmp = ""; 
		  try {
			while ((st = br.readLine()) != null) {
			    messageBienvenue=st; 
			  }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
		return messageBienvenue;
	}

	
	public String isCreator(Evenement e) {
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
	
	public void changeToModif(Evenement e) {
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

	public String modifMessageBienvenue() {
		PrintWriter prw = null;
		try {
			prw = new PrintWriter (getClass().getClassLoader().getResource("message.txt").getFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    prw.println(messageBienvenue);          
	    prw.close();
		return "index.xhtml?faces-redirect=true";
	}

	public void setMessageBienvenue(String messageBienvenue) {
		this.messageBienvenue = messageBienvenue;
	}
	
}
