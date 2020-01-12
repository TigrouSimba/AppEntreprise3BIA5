package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.OffreEmploi;

@Stateless
@LocalBean
public class OffreEmploiDao {
	
	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	public List<OffreEmploi> findAll() {		
		String requete="SELECT eve FROM Offreemploi eve";
		TypedQuery<OffreEmploi>qSelectAll=em.createQuery(requete,OffreEmploi.class);
		return qSelectAll.getResultList();
	}

}
