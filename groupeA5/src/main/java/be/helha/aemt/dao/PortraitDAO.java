package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Portrait;

@Stateless
@LocalBean
public class PortraitDAO {
	
	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;

	/**
	 * requete permettant de recuperer toutes les images
	 * @return une liste d'images
	 */
	public List<Portrait> findAll() {		
		String requete="SELECT po FROM Portrait po";
		TypedQuery<Portrait>qSelectAll=em.createQuery(requete,Portrait.class);
		return qSelectAll.getResultList();
	}
	
	/**
	 * permet d'ajouter un portrait dans la base de donnees
	 * @param i le portrait a ajouter
	 * @return un portrait
	 */
	public Portrait add(Portrait e) {
		em.persist(e);
		return e;
	}
	
	/**
	 * permet de modifier le portrait dans la base donnees
	 * @param e le portrait a modifier
	 * @return le portrait
	 */
	public Portrait modifier(Portrait e) {
		em.merge(e);
		return e;
	}
	
	/**
	 * permet de supprimer un portrait
	 * @param e le portrait a supprimer
	 */
	public void delete(Portrait e) {
		em.remove(em.merge(e));
	}
}
