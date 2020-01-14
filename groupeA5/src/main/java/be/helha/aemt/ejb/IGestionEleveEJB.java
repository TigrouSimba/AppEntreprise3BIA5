package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Eleve;


@Remote
public interface IGestionEleveEJB {

	public List<Eleve>findAll();
	
	public List<Eleve>findAllSections(String sections);
	
	public List<Eleve>findSections();
	
	public Eleve findOccurence(Eleve eleve);
	
}
