package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Formation;

@Remote
public interface IGestionFormationEJB {

	public List<Formation>findAllAccepter();
	
	public List<Formation>findAllEnCours();
	
	public Formation add(Formation e);
	
	public Formation modifier(Formation e);
	
}

