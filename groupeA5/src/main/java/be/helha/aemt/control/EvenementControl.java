package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.IGestionEvenementEJB;
import be.helha.aemt.entities.Evenement;


@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class EvenementControl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	@EJB
	private IGestionEvenementEJB ejb;
	
	private String nomEvenement="";

	public EvenementControl() {
		
	}

	public IGestionEvenementEJB getEjb() {
		return ejb;
	}

	public void setEjb(IGestionEvenementEJB ejb) {
		this.ejb = ejb;
	}

	public String getNomEvenement() {
		return nomEvenement;
	}

	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}
	
	public String ajoutEvenement() {
		Evenement el =new Evenement(nomEvenement);
		ejb.add(el);
		nomEvenement="";
		return "index.xhtml";
	}
	
	public String accepterEvenement(Evenement e) {
		e.setAccepter(1);
		ejb.modifier(e);
		return "index.xhtml";
	}
	
	
}
