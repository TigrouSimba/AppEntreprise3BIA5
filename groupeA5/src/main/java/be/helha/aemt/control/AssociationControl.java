package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedProperty;
import javax.inject.Named;

import be.helha.aemt.ejb.IGestionEvenementEJB;


@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class AssociationControl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@EJB
	private IGestionEvenementEJB ejb;
	
	

	public AssociationControl() {
		
	}

	public IGestionEvenementEJB getEjb() {
		return ejb;
	}

	public void setEjb(IGestionEvenementEJB ejb) {
		this.ejb = ejb;
	}

	
	
}
