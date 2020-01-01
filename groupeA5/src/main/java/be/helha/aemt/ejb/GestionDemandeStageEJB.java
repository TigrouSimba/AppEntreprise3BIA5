package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DemandeStageDao;
import be.helha.aemt.entities.DemandeStage;

public class GestionDemandeStageEJB implements IGestionDemandeStageEJB  {
	@EJB
	private DemandeStageDao dao;
	
	public List<DemandeStage>findAll()
	{
		return dao.findAll();
	}
	@Override
	public void Add(DemandeStage post) {
		// TODO Auto-generated method stub
		dao.Add(post);
	}

	
}
