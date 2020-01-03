package be.helha.aemt.control;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.ejb.IGestionEleveEJB;
import be.helha.aemt.ejb.IGestionImageEJB;
import be.helha.aemt.ejb.IGestionVisiteurEJB;
import be.helha.aemt.entities.Eleve;
import be.helha.aemt.entities.Image;
import be.helha.aemt.entities.Utilisateur;

@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class ImageControl implements Serializable{

	private Part file;

	@EJB
	private IGestionImageEJB ejb;
	
	public ImageControl() {
		
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public IGestionImageEJB getEjb() {
		return ejb;
	}

	public void setEjb(IGestionImageEJB ejb) {
		this.ejb = ejb;
	}

	public String ajoutImage() {
		Image img=new Image(file);
		ejb.add(img);
		return "index.xhtml";
	}
	
}
