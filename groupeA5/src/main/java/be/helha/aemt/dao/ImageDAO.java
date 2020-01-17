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
	
	/**
	 * requete permettant de recuperer toutes les images
	 * @return une liste d'images
	 */
	public List<ImgEntite> findAll() {		
		String requete="SELECT img FROM ImgEntite img";
		TypedQuery<ImgEntite>qSelectAll=em.createQuery(requete,ImgEntite.class);
		return qSelectAll.getResultList();
	}
	
	/**
	 * requete permettant de recuperer toutes les images d'une annonce
	 * @return une liste d'images
	 */
	public List<ImgEntite> findAllImagesFromEvent(int id) {		
		String requete="SELECT img FROM ImgEntite img join img.annonce e where e.id=:pId";
		TypedQuery<ImgEntite>qSelectAll=em.createQuery(requete,ImgEntite.class);
		qSelectAll.setParameter("pId", id);
		return qSelectAll.getResultList();
	}
	
	/**
	 * requete permettant de recuperer une image grace a son id
	 * @return une image
	 */
	public ImgEntite findOccurence(ImgEntite img) {
		String requete="select image FROM ImgEntite image where image.img=:pImage";
		TypedQuery<ImgEntite>qFind=em.createQuery(requete, ImgEntite.class);
		qFind.setParameter("pImage", img.getImg());		
		List<ImgEntite>req=qFind.getResultList();
		return req.size()==0?null:req.get(0);
	}
	
	/**
	 * permet d'ajouter une image dans la base de donnees
	 * @param i l'image a ajouter
	 * @return une image
	 */
	public ImgEntite add(ImgEntite i) {
		em.persist(i);
		return i;	
	}
	
	/**
	 * permet d'ajouter une image dans la base de donnees
	 * @param i l'image a ajouter
	 * @return une image
	 */
	public ImgEntite add2(ImgEntite i) {
		em.merge(i);
		return i;	
	}
	
	/**
	 * permet d'ajouter une liste d'imaegs dans la base de donnees
	 * @param i les images a ajouter
	 * @return les images
	 */
	public List<ImgEntite> addList(List<ImgEntite> i) {
		em.persist(i);
		return i;	
	}
}
