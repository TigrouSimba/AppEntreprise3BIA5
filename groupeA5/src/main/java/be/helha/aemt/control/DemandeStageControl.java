package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.helha.aemt.ejb.IGestionDemandeStageEJB;
import be.helha.aemt.entities.DemandeStage;

public class DemandeStageControl implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String nom ="nom";
	
	@EJB
	private IGestionDemandeStageEJB ejb;
	
	public IGestionDemandeStageEJB getEjb() {
		return ejb;
	}



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
		super();
		
	}
	
	




	
	
	
	
	

}
