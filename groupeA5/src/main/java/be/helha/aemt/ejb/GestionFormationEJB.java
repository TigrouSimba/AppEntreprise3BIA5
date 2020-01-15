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
	public List<Formation> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Override
	public List<Formation> findAllEnCours() {
		// TODO Auto-generated method stub
		return dao.findAllEnCours();
	}

	@Override
	public Formation add(Formation f) {
		// TODO Auto-generated method stub
		return dao.add(f);
	}

	@Override
	public Formation updateFormation(Formation f) {
		// TODO Auto-generated method stub
		return dao.updateFormation(f);
	}
	
	@Override
	public void supprimer(Formation f) {
		// TODO Auto-generated method stub
		dao.supprimer(f);
	}
	
	@Override
	public void remove(Formation f) {
		// TODO Auto-generated method stub
		dao.remove(f);
	}
	
	@Override
	public void deleteFormation(Formation f) {
		// TODO Auto-generated method stub
		dao.deleteFormation(f);
	}

	

}
