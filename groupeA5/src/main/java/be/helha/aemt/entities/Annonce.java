package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Annonce implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomAnnonce,contenuAnnonce;
	private Date dateAnnonce;
	@OneToMany(mappedBy = "annonce")
	private List<Image> imgsAnnonce;
	@ManyToOne(targetEntity=Utilisateur.class,cascade= CascadeType.PERSIST)
	private Utilisateur createurAnnonce;
	
	public Annonce() {
		
	}

	public Annonce(String nomAnnonce, String contenuAnnonce, Date dateAnnonce,
			Utilisateur createurAnnonce) {
		
		this.nomAnnonce = nomAnnonce;
		this.contenuAnnonce = contenuAnnonce;
		this.dateAnnonce = dateAnnonce;
		imgsAnnonce=new ArrayList<Image>();
		this.createurAnnonce = createurAnnonce;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomAnnonce() {
		return nomAnnonce;
	}

	public void setNomAnnonce(String nomAnnonce) {
		this.nomAnnonce = nomAnnonce;
	}

	public String getContenuAnnonce() {
		return contenuAnnonce;
	}

	public void setContenuAnnonce(String contenuAnnonce) {
		this.contenuAnnonce = contenuAnnonce;
	}

	public Date getDateAnnonce() {
		return dateAnnonce;
	}

	public void setDateAnnonce(Date dateAnnonce) {
		this.dateAnnonce = dateAnnonce;
	}

	public List<Image> getImgsAnnonce() {
		return imgsAnnonce;
	}

	public void setImgsAnnonce(List<Image> imgsAnnonce) {
		this.imgsAnnonce = imgsAnnonce;
	}

	public Utilisateur getCreateurAnnonce() {
		return createurAnnonce;
	}

	public void setCreateurAnnonce(Utilisateur createurAnnonce) {
		this.createurAnnonce = createurAnnonce;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contenuAnnonce == null) ? 0 : contenuAnnonce.hashCode());
		result = prime * result + ((createurAnnonce == null) ? 0 : createurAnnonce.hashCode());
		result = prime * result + ((dateAnnonce == null) ? 0 : dateAnnonce.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgsAnnonce == null) ? 0 : imgsAnnonce.hashCode());
		result = prime * result + ((nomAnnonce == null) ? 0 : nomAnnonce.hashCode());
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
		Annonce other = (Annonce) obj;
		if (contenuAnnonce == null) {
			if (other.contenuAnnonce != null)
				return false;
		} else if (!contenuAnnonce.equals(other.contenuAnnonce))
			return false;
		if (createurAnnonce == null) {
			if (other.createurAnnonce != null)
				return false;
		} else if (!createurAnnonce.equals(other.createurAnnonce))
			return false;
		if (dateAnnonce == null) {
			if (other.dateAnnonce != null)
				return false;
		} else if (!dateAnnonce.equals(other.dateAnnonce))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgsAnnonce == null) {
			if (other.imgsAnnonce != null)
				return false;
		} else if (!imgsAnnonce.equals(other.imgsAnnonce))
			return false;
		if (nomAnnonce == null) {
			if (other.nomAnnonce != null)
				return false;
		} else if (!nomAnnonce.equals(other.nomAnnonce))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Annonce [id=" + id + ", nomAnnonce=" + nomAnnonce + ", contenuAnnonce=" + contenuAnnonce
				+ ", dateAnnonce=" + dateAnnonce + ", imgsAnnonce=" + imgsAnnonce + ", createurAnnonce="
				+ createurAnnonce + "]";
	}

	
	public void ajoutImage(Image img) {
		imgsAnnonce.add(img);
	}
	
	
	

}
