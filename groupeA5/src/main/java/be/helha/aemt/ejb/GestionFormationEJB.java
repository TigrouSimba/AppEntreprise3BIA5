package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.FormationDAO;
import be.helha.aemt.entities.Formation;

@Stateless
public class GestionFormationEJB {

	@EJB 
	private FormationDAO dao;
	
	
	public List<Formation> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	
	public List<Formation> findAllEnCours() {
		// TODO Auto-generated method stub
		return dao.findAllEnCours();
	}

	
	public Formation add(Formation f) {
		// TODO Auto-generated method stub
		return dao.add(f);
	}

	
	public Formation updateFormation(Formation f) {
		// TODO Auto-generated method stub
		return dao.updateFormation(f);
	}
	
	
	public void supprimer(Formation f) {
		// TODO Auto-generated method stub
		dao.supprimer(f);
	}
	
	
	public void remove(Formation f) {
		// TODO Auto-generated method stub
		dao.remove(f);
	}
	
	
	public void deleteFormation(Formation f) {
		// TODO Auto-generated method stub
		dao.deleteFormation(f);
	}

	

}
