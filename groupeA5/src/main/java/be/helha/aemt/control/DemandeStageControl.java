package be.helha.aemt.control;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;



import be.helha.aemt.ejb.GestionDemandeStageEJB;
import be.helha.aemt.ejb.GestionVisiteurEJB;
import be.helha.aemt.entities.DemandeStage;
import be.helha.aemt.entities.Utilisateur;
@SessionScoped
@Named
public class DemandeStageControl implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String nom;
	
	private String contenu;
	
	private int dateJour;
	
	private int dateMois;
	
	private int dateAnne;
	
	private int id;
	
	private String entreprise;
	
	private String mailEntreprise;
	
	private String numero;
	
	private String tri="";
	
	private String durre;
	
	private boolean estUnEmploi;
	
	private String sections;
	
	private String triSection ="";
	
	
	public String getTriSection() {
		return triSection;
	}


	public String getSections() {
		return sections;
	}


	public void setSections(String sections) {
		this.sections = sections;
	}


	public void setTriSection(String triSection) {
		this.triSection = triSection;
	}


	public String getDurre() {
		return durre;
	}


	public void setDurre(String durre) {
		this.durre = durre;
	}


	public boolean isEstUnEmploi() {
		return estUnEmploi;
	}


	public void setEstUnEmploi(boolean estUnEmploi) {
		this.estUnEmploi = estUnEmploi;
	}


	private DemandeStage demandestage;
	
	@EJB
	private GestionDemandeStageEJB ejb;
	
	@EJB
	private GestionVisiteurEJB ejbVisiteur;
	
	public GestionDemandeStageEJB getEjb() {
		return ejb;
	}
	

	//Getteur et setteur

	public void setEjb(GestionDemandeStageEJB ejb) {
		this.ejb = ejb;
	}
	
	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}


	public DemandeStageControl() {
		
		
		demandestage = new DemandeStage();
		
	}
	
	public DemandeStage getDemandestage() {
		return demandestage;
	}

	public void setDemandestage(DemandeStage demandestage) {
		this.demandestage = demandestage;
	}
	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public int getDateJour() {
		return dateJour;
	}

	public void setDateJour(int dateJour) {
		this.dateJour = dateJour;
	}

	public int getDateMois() {
		return dateMois;
	}

	public void setDateMois(int dateMois) {
		this.dateMois = dateMois;
	}

	public int getDateAnne() {
		return dateAnne;
	}

	public void setDateAnne(int dateAnne) {
		this.dateAnne = dateAnne;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public String getMailEntreprise() {
		return mailEntreprise;
	}

	public void setMailEntreprise(String mailEntreprise) {
		this.mailEntreprise = mailEntreprise;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	//Methode
	public void postDemandeStage()
	{
		Utilisateur us = ejbVisiteur.findOccurence(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		DemandeStage da;
		int emploie = 0;
		if(estUnEmploi == true)
		{
			emploie = 1;
			System.out.println(emploie+"emploie");
		}
		System.out.println("estEmploie"+estUnEmploi);
		
			
		
		if(id==0)
		{
			da = new DemandeStage( nom, contenu, new Date(dateAnne, dateMois, dateJour), mailEntreprise, entreprise,
					 durre, numero, 0, emploie, us,sections);
		}
		else
		{
			da = new DemandeStage(id,nom,contenu,new Date(dateJour, dateMois, dateAnne),mailEntreprise,entreprise,numero,us);
			new DemandeStage( nom, contenu, new Date(dateAnne, dateMois, dateJour), mailEntreprise, entreprise,
					 durre, numero, 0, emploie, us,sections);
		}
		
		System.out.println(da.toString());
		ejb.Add(da);
	}
	//Permet l'affichage du stage et de son contenu
	public void selectAffichage(int id)
	{
		demandestage=ejb.findById(id);
		System.out.println(demandestage.toString());
	}
	public String Modifier(DemandeStage item)
	{
		nom = item.getNom();
		contenu = item.getContenu();
		dateAnne = item.getDate().getDay();
		dateMois = item.getDate().getMonth();
		dateJour = item.getDate().getDay();
		entreprise =item.getEntreprise();
		mailEntreprise = item.getMailEntreprise();
		numero = item.getEntreprise();
		id=item.getId();
		return "DemandeStageGenerator.xhtml";
	}
	public void supprimer(DemandeStage item)
	{
		ejb.delete(item);
	}
	public ArrayList<DemandeStage>query()
	{
		ArrayList<DemandeStage>listeTrier = new ArrayList<DemandeStage>();
		Vector<DemandeStage>list =  (Vector<DemandeStage>) ejb.findAll();
		for (DemandeStage demandeStage : list) {
			if(demandeStage.getNom().startsWith(tri))
			{
				if(demandeStage.getSection().startsWith(triSection))
				{
					listeTrier.add(demandeStage);
					System.out.println(tri);
				}
				
			}
		}
		CreerPdf();
		return listeTrier;
	}
	
	public void CreerPdf()
	{
		
		try {
			PDDocument doc = new PDDocument();
			doc.addPage(new PDPage());
			doc.save("test.pdf");
			doc.close();
			System.out.println("pdf creer");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public String getTri() {
		return tri;
	}


	public void setTri(String tri) {
		this.tri = tri;
	}
}
