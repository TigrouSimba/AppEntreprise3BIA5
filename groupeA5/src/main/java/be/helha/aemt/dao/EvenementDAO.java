package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class EvenementDAO {
	
	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	/**
	 * requete permettant de recuperer tous les evenements
	 * @return une liste d'evenements
	 */
	public List<Evenement> findAll() {		
		String requete="SELECT eve FROM Evenement eve";
		TypedQuery<Evenement>qSelectAll=em.createQuery(requete,Evenement.class);
		return qSelectAll.getResultList();
	}

	/**
	 * requete permettant de recuperer tous les evenements accepter par l'admin
	 * @return une liste d'evenements
	 */
	public List<Evenement> findAllAccepted() {		
		String requete="SELECT eve FROM Evenement eve where eve.accepter=1";
		TypedQuery<Evenement>qSelectAll=em.createQuery(requete,Evenement.class);
		return qSelectAll.getResultList();
	}
	
	/**
	 * requete permettant de recuperer tous les evenements non accepter par l'admin
	 * @return une liste d'evenements
	 */
	public List<Evenement> findAllNotAccepted() {		
		String requete="SELECT eve FROM Evenement eve where eve.accepter=0";
		TypedQuery<Evenement>qSelectAll=em.createQuery(requete,Evenement.class);
		return qSelectAll.getResultList();
	}
	
	/**
	 * requete permettant de recuperer un evenement grace a son id
	 * @return un evenement
	 */
	public Evenement findOccurence(int id) {
		String requete="select eve FROM Evenement eve where eve.id=:pId";
		TypedQuery<Evenement>qFind=em.createQuery(requete, Evenement.class);
		qFind.setParameter("pId", id);		
		return qFind.getSingleResult();
	}
	
	/**
	 * permet d'ajouter un ancien dans la base de donnees
	 * @param e l'evenement a ajouter
	 * @return l'evenement
	 */
	public Evenement add(Evenement e) {
		em.merge(e);
		return e;
	}
	
	/**
	 * permet de supprimer un evenement de la base de donnees
	 * @param e l'evenement a supprimer
	 */
	public void delete(Evenement e) {		
		String requete="delete FROM Evenement event where event=:pEvent";
		Query deleteQuery=em.createQuery(requete);
		deleteQuery.setParameter("pEvent",e);
		deleteQuery.executeUpdate();
		//em.remove(em.merge(e));
	}
}
