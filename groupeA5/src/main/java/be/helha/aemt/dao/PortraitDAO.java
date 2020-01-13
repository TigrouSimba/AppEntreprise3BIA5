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

	public List<Portrait> findAll() {		
		String requete="SELECT po FROM Portrait po";
		TypedQuery<Portrait>qSelectAll=em.createQuery(requete,Portrait.class);
		return qSelectAll.getResultList();
	}
	
	public Portrait add(Portrait e) {
		em.persist(e);
		return e;
	}
	
	public Portrait modifier(Portrait e) {
		em.merge(e);
		return e;
	}
}
