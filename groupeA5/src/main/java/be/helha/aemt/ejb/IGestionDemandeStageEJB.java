package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.DemandeStage;

@Remote
public interface IGestionDemandeStageEJB {

	public List<DemandeStage> findAll();
	public void Add(DemandeStage post);
	public DemandeStage findById(int id);
	public DemandeStage delete(DemandeStage del);
	
		
	
}
