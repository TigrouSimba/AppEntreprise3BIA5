package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Annonce;

@Stateless
@LocalBean
public class AnnonceDAO {
	
	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	public List<Annonce> findAll() {		
		String requete="SELECT eve FROM Annonce eve";
		TypedQuery<Annonce>qSelectAll=em.createQuery(requete,Annonce.class);
		return qSelectAll.getResultList();
	}

	public List<Annonce> findAllAccepted() {		
		String requete="SELECT eve FROM Annonce eve where eve.accepter=1";
		TypedQuery<Annonce>qSelectAll=em.createQuery(requete,Annonce.class);
		return qSelectAll.getResultList();
	}
	
	public List<Annonce> findAllNotAccepted() {		
		String requete="SELECT eve FROM Annonce eve where eve.accepter=0";
		TypedQuery<Annonce>qSelectAll=em.createQuery(requete,Annonce.class);
		return qSelectAll.getResultList();
	}
	
	public Annonce findOccurence(int id) {
		String requete="select eve FROM Annonce eve where eve.id=:pId";
		TypedQuery<Annonce>qFind=em.createQuery(requete, Annonce.class);
		qFind.setParameter("pId", id);		
		return qFind.getSingleResult();
	}
	
	public Annonce add(Annonce e) {
		em.merge(e);
		return e;
	}
	
	public void delete(Annonce e) {
		String requete2="delete FROM ImgEntite img where img.annonce=:pEvent";
		Query deleteQuery2=em.createQuery(requete2);
		deleteQuery2.setParameter("pEvent",e);
		deleteQuery2.executeUpdate();
		
		String requete="delete FROM Annonce event where event=:pEvent";
		Query deleteQuery=em.createQuery(requete);
		deleteQuery.setParameter("pEvent",e);
		deleteQuery.executeUpdate();
		//em.remove(em.merge(e));
	}

}
