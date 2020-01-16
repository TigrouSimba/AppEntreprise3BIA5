package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import be.helha.aemt.dao.DemandeStageDao;
import be.helha.aemt.entities.DemandeStage;
@Stateless
public class GestionDemandeStageEJB {
	
	@EJB
	private DemandeStageDao dao;
	
	
	public List<DemandeStage>findAll()
	{
		System.out.println("test");
		return dao.findAll();
	}
	public List<DemandeStage>findAllAccepte()
	{
		return dao.findAllAccept();
	}
	
	public void Add(DemandeStage post) {
		// TODO Auto-generated method stub
		dao.Add(post);
	}
	
	public DemandeStage findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}
	
	public DemandeStage delete(DemandeStage del) {
		// TODO Auto-generated method stub
		 dao.delete(del);
		 return null;
	}

	
}
