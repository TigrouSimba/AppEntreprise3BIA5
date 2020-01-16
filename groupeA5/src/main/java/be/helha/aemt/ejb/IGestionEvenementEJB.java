package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Utilisateur;


@Remote
public interface IGestionEvenementEJB {
	
	public List<Evenement>findAll();

	public List<Evenement>findAllAccepter();
	
	public List<Evenement>findAllEnCours();
	
	public Evenement findOccurence(int id);
	
	public Evenement add(Evenement e);
	
	public Evenement modifier(Evenement e);
	
	public void delete(Evenement e);
	
}
