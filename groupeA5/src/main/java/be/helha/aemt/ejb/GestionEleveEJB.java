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
	
	
	public List<Eleve> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
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

	
	public Eleve findOccurence(Eleve eleve) {
		// TODO Auto-generated method stub
		return dao.findOccurence(eleve);
	}
	
	public Eleve add(Eleve u) {
		// TODO Auto-generated method stub
		return dao.add(u);
	}

	

}
