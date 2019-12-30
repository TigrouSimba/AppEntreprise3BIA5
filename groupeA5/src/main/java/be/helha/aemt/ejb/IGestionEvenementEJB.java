package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Evenement;


@Remote
public interface IGestionEvenementEJB {

	public List<Evenement>findAll();
	
}
