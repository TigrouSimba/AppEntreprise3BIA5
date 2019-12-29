package be.helha.aemt.entities;

import java.io.File;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Image implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private File img;
	@ManyToOne(targetEntity=Annonce.class,cascade= CascadeType.PERSIST)
	private Annonce annonce;
	@ManyToOne(targetEntity=Evenement.class,cascade= CascadeType.PERSIST)
	private Evenement evenement;
	
	public Image() {
		
	}

	public Image(File img, Annonce annonce) {
		super();
		this.img = img;
		this.annonce = annonce;
	}

	public Image(File img, Evenement evenement) {
		super();
		this.img = img;
		this.evenement = evenement;
	}

	public Image(File img) {
		super();
		this.img = img;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public File getImg() {
		return img;
	}

	public void setImg(File img) {
		this.img = img;
	}

	public Annonce getAnnonce() {
		return annonce;
	}

	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Evenement getEvenement() {
		return evenement;
	}

	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annonce == null) ? 0 : annonce.hashCode());
		result = prime * result + ((evenement == null) ? 0 : evenement.hashCode());
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
		Image other = (Image) obj;
		if (annonce == null) {
			if (other.annonce != null)
				return false;
		} else if (!annonce.equals(other.annonce))
			return false;
		if (evenement == null) {
			if (other.evenement != null)
				return false;
		} else if (!evenement.equals(other.evenement))
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
		return "Image [id=" + id + ", img=" + img + ", annonce=" + annonce + ", evenement=" + evenement + "]";
	}
	
	
	
	

}
