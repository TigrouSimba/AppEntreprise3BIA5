package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DemandeStageDao;
import be.helha.aemt.entities.DemandeStage;
@Stateless
public class GestionDemandeStageEJB implements IGestionDemandeStageEJB  {
	
	@EJB
	private DemandeStageDao dao;
	
	@Override
	public List<DemandeStage>findAll()
	{
		System.out.println("test");
		return dao.findAll();
	}
	@Override
	public void Add(DemandeStage post) {
		// TODO Auto-generated method stub
		dao.Add(post);
	}
	@Override
	public DemandeStage findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	@Override
	public DemandeStage delete(DemandeStage del) {
		// TODO Auto-generated method stub
		 dao.delete(del);
		 return null;
	}

	
}
