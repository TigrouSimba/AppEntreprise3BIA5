package be.helha.aemt.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import be.helha.aemt.ejb.IGestionEvenementEJB;
import be.helha.aemt.ejb.IGestionImageEJB;
import be.helha.aemt.ejb.IGestionPortraitEJB;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Portrait;


@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class PortraitControl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	@EJB
	private IGestionPortraitEJB ejb;
	
	@EJB
	private IGestionImageEJB ejbImg;
	
	private String temoignage="";
	
	private String nom="";
	
	private ImageControl imgControl;
	
	private Part file;

	public PortraitControl() {
		
	}
	
	public String ajoutPortrait() {
		InputStream initialStream = null;
	    byte[] buffer = null;
	    //File targetFile = new File("targetFile.jpg");
	    OutputStream outStream = null;
		try {
			initialStream = file.getInputStream();
			buffer = new byte[initialStream.available()];
			initialStream.read(buffer);
			/*outStream = new FileOutputStream(targetFile);
			outStream.write(buffer);*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	    	 
		ImgEntite img=new ImgEntite(buffer);
		//ejbImg.add(img);		
		Portrait po =new Portrait(temoignage,nom,img);
		ejb.add(po);
		temoignage="";
		nom="";
		return "index.xhtml";
	}

	public IGestionPortraitEJB getEjb() {
		return ejb;
	}




	public void setEjb(IGestionPortraitEJB ejb) {
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

	public IGestionImageEJB getEjbImg() {
		return ejbImg;
	}

	public void setEjbImg(IGestionImageEJB ejbImg) {
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
	
}
