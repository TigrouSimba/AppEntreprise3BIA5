package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Formation;

@Stateless
@LocalBean
public class FormationDAO {
	
	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;

	public List<Formation> findAllAccepter() {		
		String requete="SELECT eve FROM Formation eve where eve.accepter=1";
		TypedQuery<Formation>qSelectAll=em.createQuery(requete,Formation.class);
		return qSelectAll.getResultList();
	}
	
	public List<Formation> findAllEnCours() {		
		String requete="SELECT eve FROM Formation eve where eve.accepter=0";
		TypedQuery<Formation>qSelectAll=em.createQuery(requete,Formation.class);
		return qSelectAll.getResultList();
	}
	
	public Formation add(Formation f) {
		em.persist(f);
		return f;
	}
	
	public Formation modifier(Formation f) {
		em.merge(f);
		return f;
	}
}

