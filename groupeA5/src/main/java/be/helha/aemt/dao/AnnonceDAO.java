package be.helha.aemt.dao;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class AnnonceDAO {
	
	@PersistenceContext(unitName = "gAVisiteurJTA")
	private EntityManager em;

}
