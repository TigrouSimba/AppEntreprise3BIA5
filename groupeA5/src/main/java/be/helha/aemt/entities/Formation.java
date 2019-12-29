package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Formation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomFormation,lienFormation;
	
	public Formation() {
		
	}

	public Formation(String nomFormation, String lienFormation) {
		this.nomFormation = nomFormation;
		this.lienFormation = lienFormation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomFormation() {
		return nomFormation;
	}

	public void setNomFormation(String nomFormation) {
		this.nomFormation = nomFormation;
	}

	public String getLienFormation() {
		return lienFormation;
	}

	public void setLienFormation(String lienFormation) {
		this.lienFormation = lienFormation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lienFormation == null) ? 0 : lienFormation.hashCode());
		result = prime * result + ((nomFormation == null) ? 0 : nomFormation.hashCode());
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
		Formation other = (Formation) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lienFormation == null) {
			if (other.lienFormation != null)
				return false;
		} else if (!lienFormation.equals(other.lienFormation))
			return false;
		if (nomFormation == null) {
			if (other.nomFormation != null)
				return false;
		} else if (!nomFormation.equals(other.nomFormation))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Formation [id=" + id + ", nomFormation=" + nomFormation + ", lienFormation=" + lienFormation + "]";
	}
	
	

}
