package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionEvenementEJB;
import be.helha.aemt.ejb.GestionImageEJB;


@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class AssociationControl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@EJB
	private GestionEvenementEJB ejb;
	
	@EJB
	private GestionImageEJB ejbImg;
	

	public AssociationControl() {
		
	}

	public GestionEvenementEJB getEjb() {
		return ejb;
	}

	public void setEjb(GestionEvenementEJB ejb) {
		this.ejb = ejb;
	}

	public GestionImageEJB getEjbImg() {
		return ejbImg;
	}

	public void setEjbImg(GestionImageEJB ejbImg) {
		this.ejbImg = ejbImg;
	}

	
	
}
