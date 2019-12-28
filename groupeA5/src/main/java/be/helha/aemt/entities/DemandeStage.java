package be.helha.aemt.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DemandeStage implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nom;
	private String contenu;
	public DemandeStage(Integer id, String nom, String contenu) {
		super();
		this.id = id;
		this.nom = nom;
		this.contenu = contenu;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public DemandeStage() {
		super();
	}

	public DemandeStage(String nom, String contenu) {
		super();
		this.nom = nom;
		this.contenu = contenu;
	}

}
