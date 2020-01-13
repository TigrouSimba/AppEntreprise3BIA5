package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.ejb.IGestionDemandeStageEJB;
import be.helha.aemt.entities.DemandeStage;
import be.helha.aemt.entities.Evenement;
@Stateless
@LocalBean
public class DemandeStageDao  {

	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	public List<DemandeStage> findAll(){
		String requete ="SELECT eve FROM DemandeStage eve";
		TypedQuery<DemandeStage>qSelectAll=em.createQuery(requete,DemandeStage.class);
		return qSelectAll.getResultList();
	}
	
	public void Add(DemandeStage post) {
		// TODO Auto-generated method stub
		em.persist(post);
		
		
	}
}
