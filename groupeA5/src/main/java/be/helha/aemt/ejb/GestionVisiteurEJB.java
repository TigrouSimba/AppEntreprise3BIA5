package be.helha.aemt.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.VisiteurDAO;
import be.helha.aemt.entities.Visiteur;

@Stateless
public class GestionVisiteurEJB implements IGestionVisiteurEJB {

	@EJB //injection et plus tard on verra @Inject
	private VisiteurDAO dao;
	
	@Override
	public List<Visiteur> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	

}
