package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.EleveDAO;
import be.helha.aemt.entities.Eleve;

@Stateless
public class GestionEleveEJB implements IGestionEleveEJB {

	@EJB 
	private EleveDAO dao;
	
	@Override
	public List<Eleve> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	@Override
	public List<Eleve> findAllSections(String sections) {
		// TODO Auto-generated method stub
		return dao.findAllSections(sections);
	}
	
	@Override
	public List<Eleve> findSections() {
		// TODO Auto-generated method stub
		return dao.findSections();
	}

	@Override
	public Eleve findOccurence(Eleve eleve) {
		// TODO Auto-generated method stub
		return dao.findOccurence(eleve);
	}

	

}
