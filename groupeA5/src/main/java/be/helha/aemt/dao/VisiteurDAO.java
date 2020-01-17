package be.helha.aemt.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@Stateless
@LocalBean
public class VisiteurDAO {

	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	/**
	 * requete permettant de recuperer tous les utilisateurs
	 * @return une liste d'utilisateurs
	 */
	public List<Visiteur> findAll() {		
		String requete="SELECT vis FROM Visiteur vis";
		TypedQuery<Visiteur>qSelectAll=em.createQuery(requete,Visiteur.class);
		return qSelectAll.getResultList();
	}
	
	/**
	 * requete permettant de recuperer un utilisateur grace a son id
	 * @return un utilisateur
	 */
	public Utilisateur findOccurence(String pseudo) {
		String requete="select el FROM Utilisateur el where el.login=:pLogin";
		TypedQuery<Utilisateur>qFind=em.createQuery(requete, Utilisateur.class);
		qFind.setParameter("pLogin", pseudo);		
		List<Utilisateur>req=qFind.getResultList();
		return req.size()==0?null:req.get(0);
	}
	
	/**
	 * permet d'ajouter un utilisateur dans la base de donnees
	 * @param u l'utilisateur a ajouter
	 * @return l'utilisateur
	 */
	public Utilisateur add(Utilisateur u) {
		em.persist(u);
		return u;	
	}
}
