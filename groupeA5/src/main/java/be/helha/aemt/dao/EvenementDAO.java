package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Evenement;

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
}
