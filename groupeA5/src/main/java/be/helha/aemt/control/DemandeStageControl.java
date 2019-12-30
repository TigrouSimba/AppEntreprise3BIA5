package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
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
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}
	private static final String FIELD_NOM ="nom";
	private static final String FIELD_CONTENU="contenu";
	
	private DemandeStage dms;
	private String nom = "test";
	
	@EJB
	private IGestionDemandeStageEJB ejb;
	
	
	public DemandeStage getDms() {
		return dms;
	}

	public void setDms(DemandeStage dms) {
		this.dms = dms;
	}

	public IGestionDemandeStageEJB getEjb() {
		return ejb;
	}

	public void setEjb(IGestionDemandeStageEJB ejb) {
		this.ejb = ejb;
	}


	public DemandeStageControl() {
		super();
		dms = new DemandeStage();
		dms.setNom(FIELD_NOM);
		dms.setContenu("contenu");
	}
	public void enregistreDemandeStage()
	{
		System.out.println(dms.getNom());
	}
	
	
}
