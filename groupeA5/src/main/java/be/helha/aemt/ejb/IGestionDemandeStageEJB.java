package be.helha.aemt.ejb;

import java.util.List;

import be.helha.aemt.entities.DemandeStage;

public interface IGestionDemandeStageEJB {

	public List<DemandeStage> findAll();
	public void Add(DemandeStage post);
	
		
	
}
