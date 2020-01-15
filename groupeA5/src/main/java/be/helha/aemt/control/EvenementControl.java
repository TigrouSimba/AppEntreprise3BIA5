package be.helha.aemt.control;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

import be.helha.aemt.ejb.IGestionEvenementEJB;
import be.helha.aemt.ejb.IGestionImageEJB;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;


@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class EvenementControl implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	

	@EJB
	private IGestionEvenementEJB ejb;
	
	@EJB
	private IGestionImageEJB ejbImg;
	
	private String nomEvenement="";
	
	private List<ImgEntite> imgs=new ArrayList<ImgEntite>();
	
	private Part img;

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
		if(nomEvenement.equals("")){
			return "index.xhtml?faces-redirect=true";
		}
		Evenement el =new Evenement(nomEvenement);
		//ejb.add(el);
		//el.setImgsEvenement(imgs);
		for (ImgEntite imgEntite : imgs) {
			imgEntite.setEvenement(el);
			//ejbImg.add2(imgEntite);
		}
		//ejbImg.addList(imgs);
		el.setImgsEvenement(imgs);
		ejb.add(el);
		nomEvenement="";
		imgs.clear();
		return "index.xhtml?faces-redirect=true";
	}
	
	public String accepterEvenement(Evenement e) {
		e.setAccepter(1);
		ejb.modifier(e);
		return "index.xhtml";
	}
	
	public void addtoList() { // no parameter
		InputStream initialStream = null;
	    byte[] buffer = null;
	    //File targetFile = new File("targetFile.jpg");
	    OutputStream outStream = null;
		try {
			initialStream = img.getInputStream();
			buffer = new byte[initialStream.available()];
			initialStream.read(buffer);
			/*outStream = new FileOutputStream(targetFile);
			outStream.write(buffer);*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
		
		ImgEntite ie=new ImgEntite(buffer);
	    imgs.add(ie);
	}

	public List<ImgEntite> getImgs() {
		return imgs;
	}

	public void setImgs(List<ImgEntite> imgs) {
		this.imgs = imgs;
	}

	public Part getImg() {
		return img;
	}

	public void setImg(Part img) {
		this.img = img;
	}

	public IGestionImageEJB getEjbImg() {
		return ejbImg;
	}

	public void setEjbImg(IGestionImageEJB ejbImg) {
		this.ejbImg = ejbImg;
	}
	
	public String deleteEvent(Evenement event) {
		ejb.delete(event);
		return "index.xhtml?faces-redirect=true";
		
	}
	
	
}
