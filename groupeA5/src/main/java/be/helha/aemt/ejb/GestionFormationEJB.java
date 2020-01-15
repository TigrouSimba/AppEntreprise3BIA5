package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.FormationDAO;
import be.helha.aemt.entities.Formation;

@Stateless
public class GestionFormationEJB implements IGestionFormationEJB {

	@EJB 
	private FormationDAO dao;
	
	@Override
	public List<Formation> findAllAccepter() {
		// TODO Auto-generated method stub
		return dao.findAllAccepter();
	}
	
	@Override
	public List<Formation> findAllEnCours() {
		// TODO Auto-generated method stub
		return dao.findAllEnCours();
	}

	@Override
	public Formation add(Formation e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}

	@Override
	public Formation modifier(Formation e) {
		// TODO Auto-generated method stub
		return dao.modifier(e);
	}

	

}
