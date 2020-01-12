package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OffreEmploi implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomEmploi,contenuEmploi,categorieEmploi;
	@ManyToOne(targetEntity=Utilisateur.class,cascade= CascadeType.PERSIST)
	private Utilisateur createurEmploi;
	
	public OffreEmploi() {
		
	}

	public OffreEmploi(String nomEmploi, String contenuEmploi, String categorieEmploi, Utilisateur createurEmploi) {
		super();
		this.nomEmploi = nomEmploi;
		this.contenuEmploi = contenuEmploi;
		this.categorieEmploi = categorieEmploi;
		this.createurEmploi = createurEmploi;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomEmploi() {
		return nomEmploi;
	}

	public void setNomEmploi(String nomEmploi) {
		this.nomEmploi = nomEmploi;
	}

	public String getContenuEmploi() {
		return contenuEmploi;
	}

	public void setContenuEmploi(String contenuEmploi) {
		this.contenuEmploi = contenuEmploi;
	}

	public String getCategorieEmploi() {
		return categorieEmploi;
	}

	public void setCategorieEmploi(String categorieEmploi) {
		this.categorieEmploi = categorieEmploi;
	}

	public Utilisateur getCreateurEmploi() {
		return createurEmploi;
	}

	public void setCreateurEmploi(Utilisateur createurEmploi) {
		this.createurEmploi = createurEmploi;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categorieEmploi == null) ? 0 : categorieEmploi.hashCode());
		result = prime * result + ((contenuEmploi == null) ? 0 : contenuEmploi.hashCode());
		result = prime * result + ((createurEmploi == null) ? 0 : createurEmploi.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomEmploi == null) ? 0 : nomEmploi.hashCode());
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
		OffreEmploi other = (OffreEmploi) obj;
		if (categorieEmploi == null) {
			if (other.categorieEmploi != null)
				return false;
		} else if (!categorieEmploi.equals(other.categorieEmploi))
			return false;
		if (contenuEmploi == null) {
			if (other.contenuEmploi != null)
				return false;
		} else if (!contenuEmploi.equals(other.contenuEmploi))
			return false;
		if (createurEmploi == null) {
			if (other.createurEmploi != null)
				return false;
		} else if (!createurEmploi.equals(other.createurEmploi))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomEmploi == null) {
			if (other.nomEmploi != null)
				return false;
		} else if (!nomEmploi.equals(other.nomEmploi))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OffreEmploi [id=" + id + ", nomEmploi=" + nomEmploi + ", contenuEmploi=" + contenuEmploi
				+ ", categorieEmploi=" + categorieEmploi + ", createurEmploi=" + createurEmploi + "]";
	}

	public OffreEmploi(Integer id, String nomEmploi, String contenuEmploi, String categorieEmploi,
			Utilisateur createurEmploi) {
		super();
		this.id = id;
		this.nomEmploi = nomEmploi;
		this.contenuEmploi = contenuEmploi;
		this.categorieEmploi = categorieEmploi;
		this.createurEmploi = createurEmploi;
	}
	
	

}
