package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.Image;


@Remote
public interface IGestionImageEJB {

	public List<Image>findAll();
	
	public Image findOccurence(String nom);
	
	public Image add(Image i);
	
}
