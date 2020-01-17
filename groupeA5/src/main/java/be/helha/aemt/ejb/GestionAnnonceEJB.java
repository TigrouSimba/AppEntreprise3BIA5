package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AnnonceDAO;
import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionAnnonceEJB  {

	@EJB 
	private AnnonceDAO dao;
	
	/**
	 * requete permettant de recuperer toutes les annonces
	 * @return une liste d'annnonce
	 */
	public List<Annonce> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	/**
	 * requete permettant de recuperer toutes les annonces accepter par l'admin
	 * @return une liste d'annnonce
	 */
	public List<Annonce> findAllAccepted() {
		// TODO Auto-generated method stub
		return dao.findAllAccepted();
	}
	
	/**
	 * requete permettant de recuperer toutes les annonces non accepter par l'admin
	 * @return une liste d'annnonce
	 */
	public List<Annonce> findAllNotAccepted() {
		// TODO Auto-generated method stub
		return dao.findAllNotAccepted();
	}
	
	/**
	 * requete permettant de recuperer une annonce grace a son id
	 * @return une annonce
	 */
	public Annonce findOccurence(int id) {
		// TODO Auto-generated method stub
		return dao.findOccurence(id);
	}

	/**
	 * permet d'ajouter une annonce dans la base de donnees
	 * @param e l'annonce a ajouter
	 * @return l'annonce
	 */
	public Annonce add(Annonce e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}
	
	/**
	 * permet de supprimer une annonce dans la base de donnees
	 * @param e l'annonce a supprimer
	 * @return l'annonce
	 */
	public void delete(Annonce e) {
		dao.delete(e);
	}

	

}
