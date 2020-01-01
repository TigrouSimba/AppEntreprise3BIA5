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
	public Eleve findOccurence(Eleve eleve) {
		// TODO Auto-generated method stub
		return dao.findOccurence(eleve);
	}

	

}
