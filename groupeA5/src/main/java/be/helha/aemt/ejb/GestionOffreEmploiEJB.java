package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.OffreEmploiDao;
import be.helha.aemt.entities.OffreEmploi;
@Stateless
public class GestionOffreEmploiEJB {

	@EJB
	private OffreEmploiDao dao;
	
	
	public List<OffreEmploi> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}
	
	public OffreEmploi add(OffreEmploi of) {
		// TODO Auto-generated method stub
		dao.post(of);
		return null;
	}

	

	

	
	

}
