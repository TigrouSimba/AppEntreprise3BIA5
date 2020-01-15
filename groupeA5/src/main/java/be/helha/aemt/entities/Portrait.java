package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Portrait implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String temoignage;
	private String nom;
	@OneToOne(targetEntity=ImgEntite.class,cascade= CascadeType.PERSIST)
	private ImgEntite img;
	
	public Portrait() {
		
	}

	public Portrait(String temoignage, String nom,ImgEntite img) {
		
		this.temoignage = temoignage;
		this.img = img;
		this.nom=nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTemoignage() {
		return temoignage;
	}

	public void setTemoignage(String temoignage) {
		this.temoignage = temoignage;
	}

	public ImgEntite getImg() {
		return img;
	}

	public void setImg(ImgEntite img) {
		this.img = img;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((img == null) ? 0 : img.hashCode());
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((temoignage == null) ? 0 : temoignage.hashCode());
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
		Portrait other = (Portrait) obj;
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
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (temoignage == null) {
			if (other.temoignage != null)
				return false;
		} else if (!temoignage.equals(other.temoignage))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Portrait [id=" + id + ", temoignage=" + temoignage + ", nom=" + nom + ", img=" + img + "]";
	}
	
	
	
	

}
