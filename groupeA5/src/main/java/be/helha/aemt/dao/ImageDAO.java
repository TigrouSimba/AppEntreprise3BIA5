package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.ImgEntite;

@Stateless
@LocalBean
public class ImageDAO {

	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	public List<ImgEntite> findAll() {		
		String requete="SELECT img FROM ImgEntite img";
		TypedQuery<ImgEntite>qSelectAll=em.createQuery(requete,ImgEntite.class);
		return qSelectAll.getResultList();
	}
	
	public ImgEntite findOccurence(String nom) {
		String requete="select img FROM ImgEntite img where img.login=:pLogin";
		TypedQuery<ImgEntite>qFind=em.createQuery(requete, ImgEntite.class);
		qFind.setParameter("pLogin", nom);		
		List<ImgEntite>req=qFind.getResultList();
		return req.size()==0?null:req.get(0);
	}
	
	public ImgEntite add(ImgEntite i) {
		em.persist(i);
		return i;	
	}
}
