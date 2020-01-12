package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.helha.aemt.ejb.IGestionDemandeStageEJB;
import be.helha.aemt.entities.DemandeStage;
@SessionScoped
@Named
public class DemandeStageControl implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String nom;
	
	private String contenu;
	
	



	private DemandeStage demandestage;
	
	

	@EJB
	private IGestionDemandeStageEJB ejb;
	
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
		
		nom ="mamam";
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

	
	




	
	
	
	
	

}
