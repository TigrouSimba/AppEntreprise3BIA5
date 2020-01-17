package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Formation;

@Stateless
@LocalBean
public class FormationDAO {
	
	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	/**
	 * requete permettant de recuperer toutes les formations
	 * @return une liste de formations
	 */
	public List<Formation> findAll() {		
		String requete="SELECT formation FROM Formation formation";
		TypedQuery<Formation>qSelectAll=em.createQuery(requete,Formation.class);
		return qSelectAll.getResultList();
	}
	
	/**
	 * requete permettant de recuperer toutes les formations
	 * @return une liste de formations
	 */
	public List<Formation> findAllEnCours() {		
		String requete="SELECT formation FROM Formation formation";
		TypedQuery<Formation>qSelectAll=em.createQuery(requete,Formation.class);
		return qSelectAll.getResultList();
	}
	
	/**
	 * permet de supprimer une formation de la base de donnees
	 * @param f la formation a supprimer
	 */
	public Formation deleteFormation(Formation f) {		
		String requete="delete FROM Formation formation where formation=:pF";
		Query deleteQuery=em.createQuery(requete);
		deleteQuery.setParameter("pF",f);
		em.remove(em.merge(f));
		return f;
	}
	
	/**
	 * permet d'ajouter une formation dans la base de donnees
	 * @param f la formation a ajouter
	 * @return la formation
	 */
	public Formation add(Formation f) {
		em.persist(f);
		return f;
	}
	
	/**
	 * permet de modifier une formation dans la base donnees
	 * @param f la formation a modifier
	 * @return la formation
	 */
	public Formation updateFormation(Formation f) {
		em.merge(f);
		return f;
	}
	
	/**
	 * permet de supprimer une formation de la base de donnees
	 * @param f la formation a supprimer
	 */
	public void supprimer(Formation f) {
		em.remove(f);
	}
	
	/**
	 * permet de supprimer une formation de la base de donnees
	 * @param f la formation a supprimer
	 */
	public void remove(Formation f) {
		em.remove(f);
	}
	
	
}

