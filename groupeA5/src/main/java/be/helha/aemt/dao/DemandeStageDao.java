package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.helha.aemt.ejb.IGestionDemandeStageEJB;
import be.helha.aemt.entities.DemandeStage;

public class DemandeStageDao implements IGestionDemandeStageEJB {

	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	public List<DemandeStage> findAll(){
		return em.createQuery("SELECT demandeStage FROM DEMANDESTAGE demandeStage").getResultList();
	}
	@Override
	public void Add(DemandeStage post) {
		// TODO Auto-generated method stub
		em.persist(post);
		
	}
}
