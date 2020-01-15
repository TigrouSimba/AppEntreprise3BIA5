package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;

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
	
	public Evenement add(Evenement e) {
		em.persist(e);
		return e;
	}
	
	public Evenement modifier(Evenement e) {
		em.merge(e);
		return e;
	}
	
	public void delete(Evenement e) {
		em.remove(em.merge(e));
	}
}
