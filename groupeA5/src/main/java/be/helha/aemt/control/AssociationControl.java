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

	
	
}
