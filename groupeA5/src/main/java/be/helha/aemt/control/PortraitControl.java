package be.helha.aemt.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Part;

import be.helha.aemt.ejb.GestionImageEJB;
import be.helha.aemt.ejb.GestionPortraitEJB;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Portrait;
import be.helha.aemt.entities.Utilisateur;


@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class PortraitControl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	@EJB
	private GestionPortraitEJB ejb;
	
	@EJB
	private GestionImageEJB ejbImg;
	
	private String temoignage="",nom="",temoignageModif="",nomModif="";
	
	private ImageControl imgControl;
	
	private Part file,fileModif;
	
	private Portrait portraitToModif;

	public PortraitControl() {
		
	}
	
	public String ajoutPortrait() {
			
		Portrait po =new Portrait(temoignage,nom,createImg(file));
		ejb.add(po);
		temoignage="";
		nom="";
		return "index.xhtml";
	}
	
	public ImgEntite createImg(Part fichier) {
		InputStream initialStream = null;
	    byte[] buffer = null;
	    OutputStream outStream = null;
		try {
			initialStream = fichier.getInputStream();
			buffer = new byte[initialStream.available()];
			initialStream.read(buffer);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	 
		return new ImgEntite(buffer);
	}

	public GestionPortraitEJB getEjb() {
		return ejb;
	}




	public void setEjb(GestionPortraitEJB ejb) {
		this.ejb = ejb;
	}




	public String getTemoignage() {
		return temoignage;
	}

	public void setTemoignage(String temoignage) {
		this.temoignage = temoignage;
	}

	public ImageControl getImgControl() {
		if(imgControl==null) {
			imgControl=new ImageControl();
		}
		return imgControl;
	}

	public void setImgControl(ImageControl imgControl) {
		this.imgControl = imgControl;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public GestionImageEJB getEjbImg() {
		return ejbImg;
	}

	public void setEjbImg(GestionImageEJB ejbImg) {
		this.ejbImg = ejbImg;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String deletePortrait(Portrait portrait) {
		ejb.delete(portrait);
		return "index.xhtml?faces-redirect=true";		
	}

	public String getTemoignageModif() {
		return temoignageModif;
	}

	public void setTemoignageModif(String temoignageModif) {
		this.temoignageModif = temoignageModif;
	}

	public String getNomModif() {
		return nomModif;
	}

	public void setNomModif(String nomModif) {
		this.nomModif = nomModif;
	}

	public Part getFileModif() {
		return fileModif;
	}

	public void setFileModif(Part fileModif) {
		this.fileModif = fileModif;
	}
	
	public String modifPortrait() {
		if(nomModif.equals("")){
			return "index.xhtml?faces-redirect=true";
		}
		
		portraitToModif.setTemoignage(temoignageModif);
		portraitToModif.setNom(nomModif);
		if(fileModif!=null) {
			portraitToModif.setImg(createImg(fileModif));
		}
		
		ejb.modifier(portraitToModif);
		nomModif="";
		temoignageModif="";
		portraitToModif=null;
		return "index.xhtml?faces-redirect=true";
	}
	
	public void changeToModif(Portrait e) {
		temoignageModif=e.getTemoignage();
		nomModif=e.getNom();
		portraitToModif=e;
	}
	
}
