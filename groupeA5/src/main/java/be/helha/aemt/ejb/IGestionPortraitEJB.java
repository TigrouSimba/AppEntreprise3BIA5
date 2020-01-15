package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Portrait;


@Remote
public interface IGestionPortraitEJB {

	public List<Portrait>findAll();
	
	public Portrait add(Portrait e);
	
	public Portrait modifier(Portrait e);
	
	public void delete(Portrait e);
	
}
