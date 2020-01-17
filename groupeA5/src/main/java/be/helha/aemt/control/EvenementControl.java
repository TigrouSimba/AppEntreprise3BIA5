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

	/**
	 * 
	 * @return la valeur de ejb
	 */
	public GestionEvenementEJB getEjb() {
		return ejb;
	}

	/**
	 * change la valeur de ejb par celui passe en parametre
	 * @param ejb la valeur qui doit remplacer celle actuelle
	 */
	public void setEjb(GestionEvenementEJB ejb) {
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
	 * recupere le message de bienvenue contenu dans le fichier "message.txt" et l'affiche
	 * @return le message de bienvenue
	 */
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
	
	/**
	 * change la valeur de messageBienvenue par celui passe en parametre
	 * @param messageBienvenue la valeur qui doit remplacer celle actuelle
	 */
	public void setMessageBienvenue(String messageBienvenue) {
		this.messageBienvenue = messageBienvenue;
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
	 * permet d'ajouter un evenement dans la base de données
	 * @return la page d'accueil
	 */
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
	
	/**
	 * permet de modifier un evenement dans la base de données
	 * @return la page d'accueil
	 */
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
	
	/**
	 * permet de changer une valeur d'un evenement pour qu'elle soit considere comme accepter par l'admin
	 * @param e l'evenement a accepter
	 * @return la page d'accueil
	 */
	public String accepterEvenement(Evenement e) {
		e.setAccepter(1);
		ejb.add(e);
		return "index.xhtml?faces-redirect=true";
	}

	/**
	 * permet de supprimer une annonce de la base de donnees
	 * @param event l'annonce a supprimer
	 * @return la page des annonces
	 */
	public String deleteEvent(Evenement event) {
		ejb.delete(event);
		return "index.xhtml?faces-redirect=true";
		
	}

	/**
	 * permet de savoir si l'annonce actuelle est creer par l'utilisateur connecter
	 * @param e l'annonce
	 * @return "true" s'il est le createur sinon "false"
	 */
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
	
	/**
	 * permet de donner les valeurs de l'annonce a modifier dans les champs correspondants
	 * @param e l'annonce a modifier
	 */
	public void changeToModif(Evenement e) {
		nomModif=e.getNomEvenement();
		contenuModif=e.getContenu();
		eventToModif=e;
	}	

	/**
	 * permet de modifier le message de bienvenue dans le fichier
	 * @return la page d'accueil
	 */
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

	
}
