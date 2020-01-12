package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.OffreEmploiDao;
import be.helha.aemt.entities.OffreEmploi;
@Stateless
public class GestionOffreEmploi implements IGestionOffreEmploiEJB  {

	@EJB
	private OffreEmploiDao dao;
	
	@Override
	public List<OffreEmploi> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
