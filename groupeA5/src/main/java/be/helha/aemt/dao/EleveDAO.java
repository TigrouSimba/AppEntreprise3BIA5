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
public class EleveDAO {

	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	public List<Eleve> findAll() {		
		String requete="SELECT el FROM Eleve el";
		TypedQuery<Eleve>qSelectAll=em.createQuery(requete,Eleve.class);
		return qSelectAll.getResultList();
	}
	
	public Eleve findOccurence(Eleve eleve) {
		String requete="select el FROM Eleve el where el.nom=:pNom and "
				+ "el.prenom=:pPrenom and el.annee=:pAnnee";
		TypedQuery<Eleve>qFind=em.createQuery(requete, Eleve.class);
		qFind.setParameter("pNom", eleve.getNom());	
		qFind.setParameter("pPrenom", eleve.getPrenom());		
		qFind.setParameter("pAnnee", eleve.getAnnee());		
		List<Eleve>req=qFind.getResultList();
		return req.size()==0?null:req.get(0);
	}
}
