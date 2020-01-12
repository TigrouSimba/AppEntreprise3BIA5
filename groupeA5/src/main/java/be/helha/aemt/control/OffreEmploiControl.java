package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.IGestionOffreEmploiEJB;
@SessionScoped
@Named
public class OffreEmploiControl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private IGestionOffreEmploiEJB ejb;

	public OffreEmploiControl() {
		
	}

	public IGestionOffreEmploiEJB getEjb() {
		return ejb;
	}

	public void setEjb(IGestionOffreEmploiEJB ejb) {
		this.ejb = ejb;
	}
	
	
}
