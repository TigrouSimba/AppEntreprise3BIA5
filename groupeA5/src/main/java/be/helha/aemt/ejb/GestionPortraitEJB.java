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

	/**
	 * requete permettant de recuperer toutes les images
	 * @return une liste d'images
	 */
	public List<Portrait> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	/**
	 * permet d'ajouter un portrait dans la base de donnees
	 * @param i le portrait a ajouter
	 * @return un portrait
	 */
	public Portrait add(Portrait e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}

	/**
	 * permet de modifier le portrait dans la base donnees
	 * @param e le portrait a modifier
	 * @return le portrait
	 */
	public Portrait modifier(Portrait e) {
		// TODO Auto-generated method stub
		return dao.modifier(e);
	}
	
	/**
	 * permet de supprimer un portrait
	 * @param e le portrait a supprimer
	 */
	public void delete(Portrait e) {
		// TODO Auto-generated method stub
		dao.delete(e);
	}

	

}
