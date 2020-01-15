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


import be.helha.aemt.ejb.IGestionImageEJB;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;

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
	

	public String imageShow(int index) {
		
	    /*byte[] buffer = null;	 
	    try {			
	    	InputStream initialStream = new FileInputStream(ejb.findAll().get(index).getImg());
			buffer = new byte[initialStream.available()];
			initialStream.read(buffer);
			initialStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		return Base64.getEncoder().encodeToString(ejb.findAll().get(index).getImg());		
	}
	
	public String imageShow(byte[] img) {
		return Base64.getEncoder().encodeToString(img);
	}
	
	
	
}
