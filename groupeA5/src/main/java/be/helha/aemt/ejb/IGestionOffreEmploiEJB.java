package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.OffreEmploi;

@Remote
public interface IGestionOffreEmploiEJB {
	
	public List<OffreEmploi>findAll();
}
