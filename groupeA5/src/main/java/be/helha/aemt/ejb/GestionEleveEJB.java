package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EleveDAO;
import be.helha.aemt.entities.Eleve;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionEleveEJB {

	@EJB 
	private EleveDAO dao;
	
	/**
	 * requete permettant de recuperer tous les anciens
	 * @return une liste d'ancien
	 */
	public List<Eleve> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	/**
	 * requete permettant de recuperer tous les anciens non accepter par l'admin
	 * @return une liste d'ancien
	 */
	public List<Eleve> findAllNotAccepted() {
		// TODO Auto-generated method stub
		return dao.findAllNotAccepted();
	}
	
	
	public List<Eleve> findAllSections(String sections) {
		// TODO Auto-generated method stub
		return dao.findAllSections(sections);
	}
	
	
	public List<Eleve> findSections() {
		// TODO Auto-generated method stub
		return dao.findSections();
	}
	
	public List<Eleve> findSections2(String sections, String option) {
		// TODO Auto-generated method stub
		return dao.findSections2(sections, option);
	}
	
	public Eleve afficherUtilisateur(Eleve eleve) {
		// TODO Auto-generated method stub
		return dao.afficherUtilisateur(eleve);
	}

	/**
	 * requete permettant de recuperer un ancien grace a son id
	 * @return une ancien
	 */
	public Eleve findOccurence(Eleve eleve) {
		// TODO Auto-generated method stub
		return dao.findOccurence(eleve);
	}
	
	/**
	 * permet d'ajouter un ancien dans la base de donnees
	 * @param u l'ancien a ajouter
	 * @return l'ancien
	 */
	public Eleve add(Eleve u) {
		// TODO Auto-generated method stub
		return dao.add(u);
	}

	

}
