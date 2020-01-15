package be.helha.aemt.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Evenement implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nomEvenement;
	private Integer accepter;
	@OneToMany(targetEntity=ImgEntite.class,mappedBy = "evenement",cascade= CascadeType.PERSIST)
	private List<ImgEntite> imgsEvenement;
	@OneToOne(targetEntity=Utilisateur.class,cascade= CascadeType.PERSIST)
	private Utilisateur user;
	
	public Evenement() {
		
	}

	public Evenement(String nomEvenement,int accepter,Utilisateur user) {
		this.nomEvenement = nomEvenement;
		this.accepter=accepter;
		this.user=user;
		imgsEvenement =new ArrayList<ImgEntite>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomEvenement() {
		return nomEvenement;
	}

	public void setNomEvenement(String nomEvenement) {
		this.nomEvenement = nomEvenement;
	}

	public List<ImgEntite> getImgsEvenement() {
		return imgsEvenement;
	}

	public void setImgsEvenement(List<ImgEntite> imgsEvenement) {
		this.imgsEvenement = imgsEvenement;
	}
	
	public void ajoutImage(ImgEntite img) {
		imgsEvenement.add(img);
	}

	public Integer getAccepter() {
		return accepter;
	}

	public void setAccepter(Integer accepter) {
		this.accepter = accepter;
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accepter == null) ? 0 : accepter.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgsEvenement == null) ? 0 : imgsEvenement.hashCode());
		result = prime * result + ((nomEvenement == null) ? 0 : nomEvenement.hashCode());
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
		Evenement other = (Evenement) obj;
		if (accepter == null) {
			if (other.accepter != null)
				return false;
		} else if (!accepter.equals(other.accepter))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgsEvenement == null) {
			if (other.imgsEvenement != null)
				return false;
		} else if (!imgsEvenement.equals(other.imgsEvenement))
			return false;
		if (nomEvenement == null) {
			if (other.nomEvenement != null)
				return false;
		} else if (!nomEvenement.equals(other.nomEvenement))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Evenement [id=" + id + ", nomEvenement=" + nomEvenement + ", accepter=" + accepter + ", imgsEvenement="
				+ imgsEvenement + "]";
	}
	
	

}
