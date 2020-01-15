package be.helha.aemt.ejb;

import java.util.List;

import javax.ejb.Remote;

import be.helha.aemt.entities.ImgEntite;


@Remote
public interface IGestionImageEJB {

	public List<ImgEntite>findAll();
	
	public ImgEntite findOccurence(ImgEntite img);
	
	public ImgEntite add(ImgEntite i);
	
	public List<ImgEntite> addList(List<ImgEntite> i);
	
	public ImgEntite add2(ImgEntite i);
	
}
