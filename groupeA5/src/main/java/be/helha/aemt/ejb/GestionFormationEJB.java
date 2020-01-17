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
	
	/**
	 * requete permettant de recuperer toutes les formations
	 * @return une liste de formations
	 */
	public List<Formation> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	/**
	 * requete permettant de recuperer toutes les formations
	 * @return une liste de formations
	 */
	public List<Formation> findAllEnCours() {
		// TODO Auto-generated method stub
		return dao.findAllEnCours();
	}

	/**
	 * permet d'ajouter une formation dans la base de donnees
	 * @param f la formation a ajouter
	 * @return la formation
	 */
	public Formation add(Formation f) {
		// TODO Auto-generated method stub
		return dao.add(f);
	}

	/**
	 * permet de modifier une formation dans la base donnees
	 * @param f la formation a modifier
	 * @return la formation
	 */
	public Formation updateFormation(Formation f) {
		// TODO Auto-generated method stub
		return dao.updateFormation(f);
	}
	
	/**
	 * permet de supprimer une formation de la base de donnees
	 * @param f la formation a supprimer
	 */
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
