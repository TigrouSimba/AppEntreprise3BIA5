package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import be.helha.aemt.dao.ImageDAO;
import be.helha.aemt.dao.UtilisateurDAO;
import be.helha.aemt.dao.VisiteurDAO;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

@Stateless
public class GestionImageEJB {

	@EJB 
	private ImageDAO dao;
	
	
	public List<ImgEntite> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	
	public ImgEntite findOccurence(ImgEntite img) {
		// TODO Auto-generated method stub
		return dao.findOccurence(img);
	}

	
	public ImgEntite add(ImgEntite i) {
		// TODO Auto-generated method stub
		return dao.add(i);
	}
	
	
	public List<ImgEntite> addList(List<ImgEntite> i) {
		// TODO Auto-generated method stub
		return dao.addList(i);
	}

	
	public ImgEntite add2(ImgEntite i) {
		// TODO Auto-generated method stub
		return dao.add2(i);
	}
	
	
	public List<ImgEntite> findAllImagesFromEvent(int id) {
		// TODO Auto-generated method stub
		return dao.findAllImagesFromEvent(id);
	}

}
