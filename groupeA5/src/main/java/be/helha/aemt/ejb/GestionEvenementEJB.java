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
	
	
	public List<Evenement> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	
	public List<Evenement> findAllAccepter() {
		// TODO Auto-generated method stub
		return dao.findAllAccepter();
	}
	
	
	public List<Evenement> findAllEnCours() {
		// TODO Auto-generated method stub
		return dao.findAllEnCours();
	}
	
	
	public Evenement findOccurence(int id) {
		// TODO Auto-generated method stub
		return dao.findOccurence(id);
	}

	
	public Evenement add(Evenement e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}

	
	public Evenement modifier(Evenement e) {
		// TODO Auto-generated method stub
		return dao.modifier(e);
	}
	
	
	public void delete(Evenement e) {
		dao.delete(e);
	}

	

}
