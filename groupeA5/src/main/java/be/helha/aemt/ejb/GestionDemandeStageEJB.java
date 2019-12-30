package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DemandeStageDao;
import be.helha.aemt.entities.DemandeStage;
@Stateless
public class GestionDemandeStageEJB  {
	@EJB
	private DemandeStageDao dao;
	
	public List<DemandeStage>findAll()
	{
		return dao.findAll();
	}
	
	public void post(DemandeStage post)
	{
		dao.Add(post);
	}

	
}
