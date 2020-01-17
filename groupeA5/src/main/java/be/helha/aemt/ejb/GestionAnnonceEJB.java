package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.AnnonceDAO;
import be.helha.aemt.dao.EvenementDAO;
import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Utilisateur;

@Stateless
public class GestionAnnonceEJB  {

	@EJB 
	private AnnonceDAO dao;
	
	
	public List<Annonce> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	
	public List<Annonce> findAllAccepted() {
		// TODO Auto-generated method stub
		return dao.findAllAccepted();
	}
	
	
	public List<Annonce> findAllNotAccepted() {
		// TODO Auto-generated method stub
		return dao.findAllNotAccepted();
	}
	
	
	public Annonce findOccurence(int id) {
		// TODO Auto-generated method stub
		return dao.findOccurence(id);
	}

	
	public Annonce add(Annonce e) {
		// TODO Auto-generated method stub
		return dao.add(e);
	}
	
	
	public void delete(Annonce e) {
		dao.delete(e);
	}

	

}
