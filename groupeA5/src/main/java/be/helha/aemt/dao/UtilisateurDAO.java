package be.helha.aemt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Utilisateur;

public class UtilisateurDAO {
	
	private EntityManagerFactory emf;
	private EntityManager em;
	private EntityTransaction tx;
	
	public UtilisateurDAO() {
		//pour quand on est en resource local
		emf=Persistence.createEntityManagerFactory("groupeA5");
		em=emf.createEntityManager();
		tx=em.getTransaction();
	}
	
	public void close() {
		em.close();
		emf.close();
	}
	
	public List<Utilisateur>selectAll(){
		String requete="SELECT utilisateur FROM Utilisateur utilisateur";
		TypedQuery<Utilisateur>qSelectAll=em.createQuery(requete,Utilisateur.class);
		return qSelectAll.getResultList();
	}
	
	public Utilisateur add(Utilisateur u) {
		tx.begin();
		em.persist(u);
		tx.commit();
		return u;
	}
	
	public Utilisateur find(Utilisateur u) {
		String requete="select u from Utilisateur u where u.login=:fLogin";
		//Query qFind=em.createQuery(requete);
		TypedQuery<Utilisateur>qFind=em.createQuery(requete, Utilisateur.class);
		qFind.setParameter("fLogin", u.getLogin());		
		List<Utilisateur>req=qFind.getResultList();
		return req.size()==0?null:req.get(0);
	}
	
	public Utilisateur remove(Utilisateur u) {
		if(u.getId()==null) {
			return null;
		}
		
		tx.begin();
		//Utilisateur gerer=em.merge(u);
		em.remove(em.merge(u));
		tx.commit();
		return u;
	}
	
	public void removeAllByLogin(Utilisateur u) {
		String requete="delete from Utilisateur u where u.login=:pLogin";
		Query qDelete=em.createQuery(requete);
		qDelete.setParameter("pLogin", u.getLogin()).executeUpdate();
		tx.begin();
		tx.commit();
		
	}
}
