package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.DemandeStage;
import be.helha.aemt.entities.Evenement;
@Stateless
@LocalBean
public class DemandeStageDao  {

	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	public List<DemandeStage> findAll(){

		String requete ="SELECT eve FROM DemandeStage eve Where eve.isValide = 0";

		
		TypedQuery<DemandeStage>qSelectAll=em.createQuery(requete,DemandeStage.class);
		return qSelectAll.getResultList();
	}
	public List<DemandeStage>findAllAccept()
	{
		String requete ="SELECT eve FROM DemandeStage eve Where eve.isValide = 1";
		TypedQuery<DemandeStage>qSelectAll=em.createQuery(requete,DemandeStage.class);
		return qSelectAll.getResultList();
	}
	
	public void Add(DemandeStage post) {
		// TODO Auto-generated method stub
		em.merge(post);	
	}
	public void delete(DemandeStage del)
	{
		if (!em.contains(del)) {
		    del = em.merge(del);
		}
		em.remove(del);
		
	}
	public DemandeStage findById(int id)
	{
		String requete ="SELECT eve FROM DemandeStage eve Where eve.id =:pId";
		TypedQuery<DemandeStage>qSelectOne=em.createQuery(requete,DemandeStage.class);
		qSelectOne.setParameter("pId", id);
		return qSelectOne.getResultList().get(0);
		
	}
}
