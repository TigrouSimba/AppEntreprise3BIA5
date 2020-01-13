package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.dao.PortraitDAO;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Portrait;

@Stateless
public class GestionPortraitEJB implements IGestionPortraitEJB {

	@EJB 
	private PortraitDAO dao;

	@Override
	public List<Portrait> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Portrait add(Portrait e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}

	@Override
	public Portrait modifier(Portrait e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	

}
