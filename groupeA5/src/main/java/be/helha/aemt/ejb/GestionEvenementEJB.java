package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Evenement;

@Stateless
public class GestionEvenementEJB implements IGestionEvenementEJB {

	@EJB 
	private EvenementDAO dao;
	
	@Override
	public List<Evenement> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	

}
