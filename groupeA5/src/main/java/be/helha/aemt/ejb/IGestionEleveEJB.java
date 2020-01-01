package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Eleve;


@Remote
public interface IGestionEleveEJB {

	public List<Eleve>findAll();
	
	public Eleve findOccurence(Eleve eleve);
	
}
