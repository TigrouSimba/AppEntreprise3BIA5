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
	
	
	public List<Evenement> findAllAccepted() {
		// TODO Auto-generated method stub
		return dao.findAllAccepted();
	}
	
	
	public List<Evenement> findAllNotAccepted() {
		// TODO Auto-generated method stub
		return dao.findAllNotAccepted();
	}
	
	
	public Evenement findOccurence(int id) {
		// TODO Auto-generated method stub
		return dao.findOccurence(id);
	}

	
	public Evenement add(Evenement e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}

	public void delete(Evenement e) {
		dao.delete(e);
	}

	

}
