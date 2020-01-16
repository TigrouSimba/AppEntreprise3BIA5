package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.dao.PortraitDAO;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Portrait;

@Stateless
public class GestionPortraitEJB {

	@EJB 
	private PortraitDAO dao;

	
	public List<Portrait> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
	public Portrait add(Portrait e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}

	
	public Portrait modifier(Portrait e) {
		// TODO Auto-generated method stub
		return dao.modifier(e);
	}
	
	
	public void delete(Portrait e) {
		// TODO Auto-generated method stub
		dao.delete(e);
	}

	

}
