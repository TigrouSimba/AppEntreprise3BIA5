package be.helha.aemt.entities;

import java.io.File;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.servlet.http.Part;

import org.glassfish.jersey.media.multipart.FormDataMultiPart;

import com.mysql.jdbc.Blob;

@Entity
public class ImgEntite implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//private File img;
	@Lob
	private byte[] img;
	@ManyToOne(targetEntity=Annonce.class,cascade= CascadeType.PERSIST)
	private Annonce annonce;
	
	public ImgEntite() {
		
	}

	public ImgEntite(File img, Annonce annonce) {
		
		//this.img = img;
		this.annonce = annonce;
	}

	public ImgEntite(byte[] img) {
		
		this.img = img;
		
	}
	
	public ImgEntite(byte[] img, Annonce annonce) {
		
		this.img = img;
		this.annonce = annonce;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}*/
	
	
	

	public Annonce getAnnonce() {
		return annonce;
	}


	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annonce == null) ? 0 : annonce.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ImgEntite other = (ImgEntite) obj;
		if (annonce == null) {
			if (other.annonce != null)
				return false;
		} else if (!annonce.equals(other.annonce))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (img == null) {
			if (other.img != null)
				return false;
		} else if (!img.equals(other.img))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Image [id=" + id + ", img=" + img + ", annonce=" + annonce + "]";
	}
	
	
	
	

}
