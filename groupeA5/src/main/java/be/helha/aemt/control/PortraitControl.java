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
	
	/**
	 * 
	 * @return la valeur de ejb
	 */
	public GestionPortraitEJB getEjb() {
		return ejb;
	}

	/**
	 * change la valeur de ejb par celui passe en parametre
	 * @param ejb la valeur qui doit remplacer celle actuelle
	 */
	public void setEjb(GestionPortraitEJB ejb) {
		this.ejb = ejb;
	}

	/**
	 * 
	 * @return la valeur de temoignage
	 */
	public String getTemoignage() {
		return temoignage;
	}

	/**
	 * change la valeur de temoignage par celui passe en parametre
	 * @param temoignage la valeur qui doit remplacer celle actuelle
	 */
	public void setTemoignage(String temoignage) {
		this.temoignage = temoignage;
	}

	/**
	 * 
	 * @return la valeur de imgControl
	 */
	public ImageControl getImgControl() {
		if(imgControl==null) {
			imgControl=new ImageControl();
		}
		return imgControl;
	}

	/**
	 * change la valeur de imgControl par celui passe en parametre
	 * @param imgControl la valeur qui doit remplacer celle actuelle
	 */
	public void setImgControl(ImageControl imgControl) {
		this.imgControl = imgControl;
	}

	/**
	 * 
	 * @return la valeur de file
	 */
	public Part getFile() {
		return file;
	}

	/**
	 * change la valeur de file par celui passe en parametre
	 * @param file la valeur qui doit remplacer celle actuelle
	 */
	public void setFile(Part file) {
		this.file = file;
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

	/**
	 * 
	 * @return la valeur de nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * change la valeur de nom par celui passe en parametre
	 * @param nom la valeur qui doit remplacer celle actuelle
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * 
	 * @return la valeur de temoignageModif
	 */
	public String getTemoignageModif() {
		return temoignageModif;
	}

	/**
	 * change la valeur de temoignageModif par celui passe en parametre
	 * @param temoignageModif la valeur qui doit remplacer celle actuelle
	 */
	public void setTemoignageModif(String temoignageModif) {
		this.temoignageModif = temoignageModif;
	}

	/**
	 * 
	 * @return la valeur de nomModif
	 */
	public String getNomModif() {
		return nomModif;
	}

	/**
	 * change la valeur de nomModif par celui passe en parametre
	 * @param nomModif la valeur qui doit remplacer celle actuelle
	 */
	public void setNomModif(String nomModif) {
		this.nomModif = nomModif;
	}

	/**
	 * 
	 * @return la valeur de fileModif
	 */
	public Part getFileModif() {
		return fileModif;
	}

	/**
	 * change la valeur de fileModif par celui passe en parametre
	 * @param fileModif la valeur qui doit remplacer celle actuelle
	 */
	public void setFileModif(Part fileModif) {
		this.fileModif = fileModif;
	}
	
	/**
	 * permet d'ajouter un portrait dans la base de données
	 * @return la page d'accueil
	 */
	public String ajoutPortrait() {
		
		Portrait po =new Portrait(temoignage,nom,createImg(file));
		ejb.add(po);
		temoignage="";
		nom="";
		return "index.xhtml?faces-redirect=true";
	}
	
	/**
	 * permet de creer une image a partir d'un Part fourni
	 * @param fichier le fichier importer depuis la page internet a convertir en image
	 * @return une ImgEntite contenant l'image
	 */
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
	
	/**
	 * permet de supprimer un portrait de la base de donnees
	 * @param portrait le portrait a supprimer
	 * @return la page d'accueil
	 */
	public String deletePortrait(Portrait portrait) {
		ejb.delete(portrait);
		return "index.xhtml?faces-redirect=true";		
	}

	/**
	 * permet de modifier un portrait dans la base de données
	 * @return la page d'accueil
	 */
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
	
	/**
	 * permet de donner les valeurs du portrait a modifier dans les champs correspondants
	 * @param e le portrait a modifier
	 */
	public void changeToModif(Portrait e) {
		temoignageModif=e.getTemoignage();
		nomModif=e.getNom();
		portraitToModif=e;
	}
	
}
