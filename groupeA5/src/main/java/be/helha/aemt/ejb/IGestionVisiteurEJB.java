package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;


@Remote
public interface IGestionVisiteurEJB {

	public List<Visiteur>findAll();
	
	public Utilisateur findOccurence(String pseudo);
	
	public Utilisateur add(Utilisateur u);
	
}
