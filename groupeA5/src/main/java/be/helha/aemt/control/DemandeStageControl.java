package be.helha.aemt.control;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.helha.aemt.ejb.IGestionDemandeStageEJB;
import be.helha.aemt.ejb.IGestionVisiteurEJB;
import be.helha.aemt.entities.DemandeStage;
import be.helha.aemt.entities.Utilisateur;
@SessionScoped
@Named
public class DemandeStageControl implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String nom;
	
	private String contenu;
	
	private int dateJour;
	
	private int dateMois;
	
	private int dateAnne;
	
	private int id;
	
	private String entreprise;
	
	private String mailEntreprise;
	
	private String numero;
	
	
	
	private DemandeStage demandestage;
	
	@EJB
	private IGestionDemandeStageEJB ejb;
	
	@EJB
	private IGestionVisiteurEJB ejbVisiteur;
	
	public IGestionDemandeStageEJB getEjb() {
		return ejb;
	}
	

	//Getteur et setteur

	public void setEjb(IGestionDemandeStageEJB ejb) {
		this.ejb = ejb;
	}
	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}


	public DemandeStageControl() {
		
		
		demandestage = new DemandeStage();
	}
	
	public DemandeStage getDemandestage() {
		return demandestage;
	}

	public void setDemandestage(DemandeStage demandestage) {
		this.demandestage = demandestage;
	}
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public int getDateJour() {
		return dateJour;
	}

	public void setDateJour(int dateJour) {
		this.dateJour = dateJour;
	}

	public int getDateMois() {
		return dateMois;
	}

	public void setDateMois(int dateMois) {
		this.dateMois = dateMois;
	}

	public int getDateAnne() {
		return dateAnne;
	}

	public void setDateAnne(int dateAnne) {
		this.dateAnne = dateAnne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getMailEntreprise() {
		return mailEntreprise;
	}

	public void setMailEntreprise(String mailEntreprise) {
		this.mailEntreprise = mailEntreprise;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	//Methode
	public void postDemandeStage()
	{
		Utilisateur us = ejbVisiteur.findOccurence(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		DemandeStage da;
		if(id==0)
		{
			da = new DemandeStage(nom,contenu,new Date(dateJour, dateMois, dateAnne),mailEntreprise,entreprise,numero,us);
		}
		else
		{
			da = new DemandeStage(id,nom,contenu,new Date(dateJour, dateMois, dateAnne),mailEntreprise,entreprise,numero,us);
		}
		
		System.out.println(da.toString());
		ejb.Add(da);
	}
	//Permet l'affichage du stage et de son contenu
	public void selectAffichage(int id)
	{
		demandestage=ejb.findById(id);
		System.out.println(demandestage.toString());
	}
	public String Modifier(DemandeStage item)
	{
		nom = item.getNom();
		contenu = item.getContenu();
		dateAnne = item.getDate().getDay();
		dateMois = item.getDate().getMonth();
		dateJour = item.getDate().getDay();
		entreprise =item.getEntreprise();
		mailEntreprise = item.getMailEntreprise();
		numero = item.getEntreprise();
		id=item.getId();
		return "DemandeStageGenerator.xhtml";
	}
	public void supprimer(DemandeStage item)
	{
		ejb.delete(item);
	}
	

	
	




	
	
	
	
	

}
