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
public class GestionImageEJB implements IGestionImageEJB {

	@EJB 
	private ImageDAO dao;
	
	@Override
	public List<ImgEntite> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public ImgEntite findOccurence(ImgEntite img) {
		// TODO Auto-generated method stub
		return dao.findOccurence(img);
	}

	@Override
	public ImgEntite add(ImgEntite i) {
		// TODO Auto-generated method stub
		return dao.add(i);
	}
	
	@Override
	public List<ImgEntite> addList(List<ImgEntite> i) {
		// TODO Auto-generated method stub
		return dao.addList(i);
	}

	@Override
	public ImgEntite add2(ImgEntite i) {
		// TODO Auto-generated method stub
		return dao.add2(i);
	}
	
	@Override
	public List<ImgEntite> findAllImagesFromEvent(int id) {
		// TODO Auto-generated method stub
		return dao.findAllImagesFromEvent(id);
	}

}
