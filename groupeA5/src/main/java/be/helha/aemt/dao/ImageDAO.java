package be.helha.aemt.dao;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import be.helha.aemt.entities.Image;

@Stateless
@LocalBean
public class ImageDAO {

	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;
	
	public List<Image> findAll() {		
		String requete="SELECT img FROM Image img";
		TypedQuery<Image>qSelectAll=em.createQuery(requete,Image.class);
		return qSelectAll.getResultList();
	}
	
	public Image findOccurence(String nom) {
		String requete="select img FROM Image img where img.login=:pLogin";
		TypedQuery<Image>qFind=em.createQuery(requete, Image.class);
		qFind.setParameter("pLogin", nom);		
		List<Image>req=qFind.getResultList();
		return req.size()==0?null:req.get(0);
	}
	
	public Image add(Image i) {
		em.persist(i);
		return i;	
	}
}
