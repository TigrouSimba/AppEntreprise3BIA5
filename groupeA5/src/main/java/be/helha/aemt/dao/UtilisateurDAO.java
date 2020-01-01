package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Eleve;
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
	
	public Utilisateur findOccurence(String pseudo) {
		String requete="select ul FROM Utilisateur ul where ul.login=:pLogin";
		TypedQuery<Utilisateur>qFind=em.createQuery(requete, Utilisateur.class);
		qFind.setParameter("pLogin", pseudo);		
		List<Utilisateur>req=qFind.getResultList();
		return req.size()==0?null:req.get(0);
	}
}
