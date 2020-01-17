package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Eleve;
import be.helha.aemt.entities.Utilisateur;

@Stateless
@LocalBean
public class EleveDAO {

	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	/**
	 * requete permettant de recuperer tous les anciens
	 * @return une liste d'ancien
	 */
	public List<Eleve> findAll() {		
		String requete="SELECT el FROM Eleve el";
		TypedQuery<Eleve>qSelectAll=em.createQuery(requete,Eleve.class);
		return qSelectAll.getResultList();
	}
	
	/**
	 * requete permettant de recuperer tous les anciens non accepter par l'admin
	 * @return une liste d'ancien
	 */
	public List<Eleve> findAllNotAccepted() {		
		String requete="SELECT el FROM Eleve el where el.accepter=0";
		TypedQuery<Eleve>qSelectAll=em.createQuery(requete,Eleve.class);
		return qSelectAll.getResultList();
	}
	
	/**
	 * requete permettant d'afficher une liste d'ancien en fonction d'une section
	 * @return une liste d'anciens
	 */
	public List<Eleve> findAllSections(String sections) {		
		String requete="SELECT el FROM Eleve el where el.sections=:pSections order by el.annee asc";
		TypedQuery<Eleve>qSelectAllSections=em.createQuery(requete,Eleve.class);
		qSelectAllSections.setParameter("pSections", sections);	
		List<Eleve>req=qSelectAllSections.getResultList();
		return req.size()==0?null:req;
	}
	
	/**
	 * requete permettant d'afficher chaque section une seule fois
	 * @return une liste de sections
	 */
	public List<Eleve> findSections() {		
		String requete="SELECT distinct el.sections FROM Eleve el";
		TypedQuery<Eleve>qSelectSections=em.createQuery(requete,Eleve.class);
		return qSelectSections.getResultList();
	}
	
	/**
	 * requete permettant de recuperer une liste d'ancien grace a un tri
	 * @return une liste d'ancien
	 */
	public List<Eleve> findSections2(String sections, String option){
        boolean valide = true;
        Query qSelectAll;
        String requete;
        if(option == null || option.contentEquals("")) {
            requete ="SELECT eleve from Eleve eleve where eleve.sections =:sections";
            qSelectAll=em.createQuery(requete);
            qSelectAll.setParameter("sections", sections );
        }
        else {
            requete ="SELECT eleve from Eleve eleve where eleve.sections =:sections and (eleve.nom like :option or eleve.prenom like :option)";
            qSelectAll=em.createQuery(requete);
            qSelectAll.setParameter("sections", sections );
            qSelectAll.setParameter("option", "%" + option + "%" );
        }
        
        return qSelectAll.getResultList();
    }
	
	/**
	 * requete permettant de recuperer un ancien grace a son id
	 * @return un ancien
	 */
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
	
	/**
	 * requete permettant de recuperer un ancien grace a une div
	 * @return un ancien
	 */
	public Eleve afficherUtilisateur(Eleve eleve) {
		String requete="select el FROM Eleve el where el=:pEl";
		TypedQuery<Eleve>afficherQuery=em.createQuery(requete, Eleve.class);
		afficherQuery.setParameter("pEl",eleve);
		List<Eleve>req=afficherQuery.getResultList();
		return req.size()==0?null:req.get(0);
	}
	
	/**
	 * permet d'ajouter un ancien dans la base de donnees
	 * @param u l'ancien a ajouter
	 * @return l'ancien
	 */
	public Eleve add(Eleve u) {
		em.merge(u);
		return u;	
	}
}
