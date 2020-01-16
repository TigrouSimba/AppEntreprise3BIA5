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
	
	
	public List<Visiteur> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
	public Utilisateur findOccurence(String pseudo) {
		// TODO Auto-generated method stub
		return dao.findOccurence(pseudo);
	}

	
	public Utilisateur add(Utilisateur u) {
		// TODO Auto-generated method stub
		return dao.add(u);
	}

	

}
