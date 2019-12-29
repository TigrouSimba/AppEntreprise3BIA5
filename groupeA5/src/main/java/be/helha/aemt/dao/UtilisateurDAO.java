package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class UtilisateurDAO {

	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	public List<Utilisateur> findAll() {		
		String requete="SELECT utilisateur FROM Utilisateur utilisateur";
		TypedQuery<Utilisateur>qSelectAll=em.createQuery(requete,Utilisateur.class);
		return qSelectAll.getResultList();
	}
}
