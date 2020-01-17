package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.dao.VisiteurDAO;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@Stateless
public class GestionVisiteurEJB {

	@EJB 
	private VisiteurDAO dao;
	
	/**
	 * requete permettant de recuperer tous les utilisateurs
	 * @return une liste d'utilisateurs
	 */
	public List<Visiteur> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	/**
	 * requete permettant de recuperer un utilisateur grace a son id
	 * @return un utilisateur
	 */	
	public Utilisateur findOccurence(String pseudo) {
		// TODO Auto-generated method stub
		return dao.findOccurence(pseudo);
	}

	/**
	 * permet d'ajouter un utilisateur dans la base de donnees
	 * @param u l'utilisateur a ajouter
	 * @return l'utilisateur
	 */
	public Utilisateur add(Utilisateur u) {
		// TODO Auto-generated method stub
		return dao.add(u);
	}

	

}
