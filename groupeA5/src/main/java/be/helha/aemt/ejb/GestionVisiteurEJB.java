package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.dao.VisiteurDAO;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@Stateless
public class GestionVisiteurEJB implements IGestionVisiteurEJB {

	@EJB 
	private VisiteurDAO dao;
	
	@Override
	public List<Visiteur> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	

}
