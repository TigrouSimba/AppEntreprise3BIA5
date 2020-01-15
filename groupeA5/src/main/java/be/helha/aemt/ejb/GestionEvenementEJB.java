package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;

@Stateless
public class GestionEvenementEJB implements IGestionEvenementEJB {

	@EJB 
	private EvenementDAO dao;
	
	@Override
	public List<Evenement> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Override
	public List<Evenement> findAllAccepter() {
		// TODO Auto-generated method stub
		return dao.findAllAccepter();
	}
	
	@Override
	public List<Evenement> findAllEnCours() {
		// TODO Auto-generated method stub
		return dao.findAllEnCours();
	}

	@Override
	public Evenement add(Evenement e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}

	@Override
	public Evenement modifier(Evenement e) {
		// TODO Auto-generated method stub
		return dao.modifier(e);
	}
	
	@Override
	public void delete(Evenement e) {
		dao.delete(e);
	}

	

}
