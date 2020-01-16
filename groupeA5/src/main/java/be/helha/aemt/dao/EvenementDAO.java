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
	
	public List<Evenement> findAll() {		
		String requete="SELECT eve FROM Evenement eve";
		TypedQuery<Evenement>qSelectAll=em.createQuery(requete,Evenement.class);
		return qSelectAll.getResultList();
	}

	public List<Evenement> findAllAccepter() {		
		String requete="SELECT eve FROM Evenement eve where eve.accepter=1";
		TypedQuery<Evenement>qSelectAll=em.createQuery(requete,Evenement.class);
		return qSelectAll.getResultList();
	}
	
	public List<Evenement> findAllEnCours() {		
		String requete="SELECT eve FROM Evenement eve where eve.accepter=0";
		TypedQuery<Evenement>qSelectAll=em.createQuery(requete,Evenement.class);
		return qSelectAll.getResultList();
	}
	
	public Evenement findOccurence(int id) {
		String requete="select eve FROM Evenement eve where eve.id=:pId";
		TypedQuery<Evenement>qFind=em.createQuery(requete, Evenement.class);
		qFind.setParameter("pId", id);		
		return qFind.getSingleResult();
	}
	
	public Evenement add(Evenement e) {
		em.merge(e);
		return e;
	}
	
	public Evenement modifier(Evenement e) {
		em.merge(e);
		return e;
	}
	
	public void delete(Evenement e) {
		String requete2="delete FROM ImgEntite img where img.evenement=:pEvent";
		Query deleteQuery2=em.createQuery(requete2);
		deleteQuery2.setParameter("pEvent",e);
		deleteQuery2.executeUpdate();
		
		String requete="delete FROM Evenement event where event=:pEvent";
		Query deleteQuery=em.createQuery(requete);
		deleteQuery.setParameter("pEvent",e);
		deleteQuery.executeUpdate();
		//em.remove(em.merge(e));
	}
}
