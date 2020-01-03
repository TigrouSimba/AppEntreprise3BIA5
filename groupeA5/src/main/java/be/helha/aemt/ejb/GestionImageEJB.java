package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.ImageDAO;
import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.dao.VisiteurDAO;
import be.helha.aemt.entities.Image;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@Stateless
public class GestionImageEJB implements IGestionImageEJB {

	@EJB 
	private ImageDAO dao;
	
	@Override
	public List<Image> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Image findOccurence(String nom) {
		// TODO Auto-generated method stub
		return dao.findOccurence(nom);
	}

	@Override
	public Image add(Image i) {
		// TODO Auto-generated method stub
		return dao.add(i);
	}

	

}
