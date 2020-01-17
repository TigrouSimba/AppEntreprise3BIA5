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
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1CFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

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
	
	private String nomPersonneRes;
	
	private boolean AfficherEmploi;
	
	//Retoune la valeur de l'attribut TriSelection
	public String getTriSection() {
		return triSection;
	}

	//Retoune la valeur de l'attribut Section
	public String getSections() {
		return sections;
	}

	//Permet de changer la valeur de l'attribut Section
	public void setSections(String sections) {
		this.sections = sections;
	}

	//Permet de changer la valeur de l'attribut triSection
	public void setTriSection(String triSection) {
		this.triSection = triSection;
	}

	//Retoune la valeur de l'attribut Durée
	public String getDurre() {
		return durre;
	}

	//Permet de changer la valeur de l'attribut Duree
	public void setDurre(String durre) {
		this.durre = durre;
	}


	public boolean isEstUnEmploi() {
		return estUnEmploi;
	}

	//Permet de changer la valeur de l'attribut est un emploi
	public void setEstUnEmploi(boolean estUnEmploi) {
		this.estUnEmploi = estUnEmploi;
	}


	private DemandeStage demandestage;
	
	@EJB
	private GestionDemandeStageEJB ejb;
	
	@EJB
	private GestionVisiteurEJB ejbVisiteur;
	
	//Retoune la valeur de l'attribut Ejb
	public GestionDemandeStageEJB getEjb() {
		return ejb;
	}
	

	//Getteur et setteur

	public void setEjb(GestionDemandeStageEJB ejb) {
		this.ejb = ejb;
	}
	//Retoune la valeur de l'attribut Nom
	public String getNom() {
		return nom;
	}


	//Permet de changer la valeur de l'attribut Nom
	public void setNom(String nom) {
		this.nom = nom;
	}

	//Constructeur
	public DemandeStageControl() {
		
		
		demandestage = new DemandeStage();
		
	}
	//Retoune la valeur de l'attribut DemandeStage
	public DemandeStage getDemandestage() {
		return demandestage;
	}
	//Permet de changer la valeur de l'attribut DemandeStage
	public void setDemandestage(DemandeStage demandestage) {
		this.demandestage = demandestage;
	}
	//Retoune la valeur de l'attribut Contenu
	public String getContenu() {
		return contenu;
	}
	//Permet de changer la valeur de l'attribut Contenu
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	//Retoune la valeur de l'attribut DateJour
	public int getDateJour() {
		return dateJour;
	}
	//Permet de changer la valeur de l'attribut DateJour
	public void setDateJour(int dateJour) {
		this.dateJour = dateJour;
	}
	//Retoune la valeur de l'attribut DateMois
	public int getDateMois() {
		return dateMois;
	}
	//Permet de changer la valeur de l'attribut dateMois
	public void setDateMois(int dateMois) {
		this.dateMois = dateMois;
	}
	//Retoune la valeur de l'attribut d'annee
	public int getDateAnne() {
		return dateAnne;
	}
	//Permet de changer la valeur de l'attribut Dateanne
	public void setDateAnne(int dateAnne) {
		this.dateAnne = dateAnne;
	}
	//Retoune la valeur de l'attribut id
	public int getId() {
		return id;
	}
	//Permet de changer la valeur de l'attribut id
	public void setId(int id) {
		this.id = id;
	}
	//Retoune la valeur de l'attribut entreprise
	public String getEntreprise() {
		return entreprise;
	}
	//Permet de changer la valeur de l'attribut entreprise
	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}
	//Retoune la valeur de l'attribut MailEntreprise
	public String getMailEntreprise() {
		return mailEntreprise;
	}
	//Permet de changer la valeur de l'attribut Mail
	public void setMailEntreprise(String mailEntreprise) {
		this.mailEntreprise = mailEntreprise;
	}
	//Retoune la valeur de l'attribut Numero
	public String getNumero() {
		return numero;
	}
	//Permet de changer la valeur de l'attribut Numero
	public void setNumero(String numero) {
		this.numero = numero;
	}

	//Methode
	public void postDemandeStage()
	{
		Utilisateur us = ejbVisiteur.findOccurence(FacesContext.getCurrentInstance().getExternalContext().getRemoteUser());
		DemandeStage da;
		int emploie = 0;
		int accepter =0;
		
		if(estUnEmploi == true)
		{
			emploie = 1;
			System.out.println(emploie+"emploie");
		}
		System.out.println("estEmploie"+estUnEmploi);
		if(us.getGroupName().equals("admin"))
		{
			accepter =1;
		}
		
			
		
		if(id==0)
		{
			da = new DemandeStage( nom, contenu, new Date(dateAnne, dateMois, dateJour), mailEntreprise, entreprise,durre, numero, accepter, emploie, us,sections,nomPersonneRes);
			System.out.println(da.getDate().toString());
			System.out.println(dateJour+" "+dateMois+" "+dateAnne);
		}
		else
		{
			da = new DemandeStage(id,nom, contenu, new Date(dateAnne, dateMois, dateJour), mailEntreprise, entreprise,
					 durre, numero, accepter, emploie, us,sections,nomPersonneRes);
			System.out.println(da.getDate().toString());
			System.out.println(dateJour+dateMois+dateAnne);
			
		}
		
		System.out.println(da.toString());
		ejb.Add(da);
	}
	public String getNomPersonneRes() {
		return nomPersonneRes;
	}

	//Permet de changer la valeur de l'attribut NomPersonneRes
	public void setNomPersonneRes(String nomPersonneRes) {
		this.nomPersonneRes = nomPersonneRes;
	}


	//Permet l'affichage du stage et de son contenu
	public void selectAffichage(int id)
	{
		demandestage=ejb.findById(id);
		System.out.println(demandestage.toString());
	}
	//Permet de garder en memoire les attribut de demande de Stage
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
	//Permet de supprimer les demandes
	public void supprimer(DemandeStage item)
	{
		ejb.delete(item);
	}
	//Permet de recuper les données et le querry
	public ArrayList<DemandeStage>query()
	{
		int affiche = 0;
		if(AfficherEmploi == true)
		{
			affiche = 1;
		}
		ArrayList<DemandeStage>listeTrier = new ArrayList<DemandeStage>();
		Vector<DemandeStage>list =  (Vector<DemandeStage>) ejb.findAllAccepte();
		for (DemandeStage demandeStage : list) {
			if(demandeStage.getNom().startsWith(tri))
			{
				if(demandeStage.getSection().startsWith(triSection))
				{
					if(demandeStage.getEstUnEmploi() == affiche)
					{
						listeTrier.add(demandeStage);
						System.out.println(tri);
					}
					
				}
				
			}
		}
	
		return listeTrier;
	}
	//Permet de changer la valeur de l'attribut estAfficher
	public boolean isAfficherEmploi() {
		return AfficherEmploi;
	}

	//Permet de changer la valeur de l'attribut estAfficher
	public void setAfficherEmploi(boolean afficherEmploi) {
		AfficherEmploi = afficherEmploi;
	}

	//Permet de creer un pdf avec les demande de stage
	public void CreerPdf()
	{
		
		try {
			PDDocument doc = new PDDocument();
			PDPage page = new PDPage();
			PDPageContentStream content = new PDPageContentStream(doc, page);
			content.beginText();
			content.setFont(PDType1Font.TIMES_BOLD, 26);
			content.showText(demandestage.getNom()+""+demandestage.getContenu()+"<br>"+demandestage.getDuree()+"<br>"+demandestage.getEntreprise()+"<br>"+demandestage.getMailEntreprise()+"<br>");
			content.endText();
			content.close();
			doc.addPage(page);
			doc.save("test.pdf");
			doc.close();
			System.out.println("pdf creer");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Retoune la valeur de l'attribut tri
	public String getTri() {
		return tri;
	}

	//Permet de changer la valeur de l'attribut Tri
	public void setTri(String tri) {
		this.tri = tri;
	}
}
