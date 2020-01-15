package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Formation;

@Remote
public interface IGestionFormationEJB {

	public List<Formation>findAll();
	
	public List<Formation>findAllEnCours();
	
	public Formation add(Formation e);
	
	public Formation updateFormation(Formation e);
	
	public void supprimer(Formation e);
	
	public void remove(Formation e);
	
	public void deleteFormation(Formation e);
	
}

