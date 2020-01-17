package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionEvenementEJB  {

	@EJB 
	private EvenementDAO dao;
	
	/**
	 * requete permettant de recuperer tous les evenements
	 * @return une liste d'evenements
	 */
	public List<Evenement> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	/**
	 * requete permettant de recuperer tous les evenements accepter par l'admin
	 * @return une liste d'evenements
	 */
	public List<Evenement> findAllAccepted() {
		// TODO Auto-generated method stub
		return dao.findAllAccepted();
	}
	
	/**
	 * requete permettant de recuperer tous les evenements non accepter par l'admin
	 * @return une liste d'evenements
	 */
	public List<Evenement> findAllNotAccepted() {
		// TODO Auto-generated method stub
		return dao.findAllNotAccepted();
	}
	
	/**
	 * requete permettant de recuperer un evenement grace a son id
	 * @return un evenement
	 */
	public Evenement findOccurence(int id) {
		// TODO Auto-generated method stub
		return dao.findOccurence(id);
	}

	/**
	 * permet d'ajouter un ancien dans la base de donnees
	 * @param e l'evenement a ajouter
	 * @return l'evenement
	 */
	public Evenement add(Evenement e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}
	
	/**
	 * permet de supprimer un evenement de la base de donnees
	 * @param e l'evenement a supprimer
	 */
	public void delete(Evenement e) {
		dao.delete(e);
	}

	

}
