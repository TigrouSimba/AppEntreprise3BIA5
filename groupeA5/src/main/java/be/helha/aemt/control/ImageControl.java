package be.helha.aemt.control;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Base64;
import java.util.zip.Deflater;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.imageio.ImageIO;
import javax.inject.Named;
import javax.servlet.http.Part;

import be.helha.aemt.ejb.GestionImageEJB;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;

@SessionScoped
@Named //permet d'utiliser les controller dans les pages html
public class ImageControl implements Serializable{

	private Part file;

	@EJB
	private GestionImageEJB ejb;
	
	public ImageControl() {
		
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
	 * @return la valeur de ejb
	 */
	public GestionImageEJB getEjb() {
		return ejb;
	}

	/**
	 * change la valeur de ejb par celui passe en parametre
	 * @param ejb la valeur qui doit remplacer celle actuelle
	 */
	public void setEjb(GestionImageEJB ejb) {
		this.ejb = ejb;
	}

	/**
	 * permet d'ajouter une image dans la base de données
	 * @return une "ImgEntite"
	 */
	public ImgEntite ajoutImage() {		
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
		new Thread(new Runnable() {
		    public void run() {
		    	ejb.add(img);	
		    }
		}).start();
		
		return img;	

	}
	
	/**
	 * permet d'encoder une image pour qu'elle soit affichable sur la page internet
	 * @param index l'index de l'image dans la base de données
	 * @return l'image encodee
	 */
	public String imageShow(int index) {
		
		return Base64.getEncoder().encodeToString(ejb.findAll().get(index).getImg());		
	}
	
	/**
	 * permet d'encoder une image pour qu'elle soit affichable sur la page internet
	 * @param img une image en format byte[] brut
	 * @return l'image encodee
	 */
	public String imageShow(byte[] img) {
		return Base64.getEncoder().encodeToString(img);
	}
	
	
	
}
