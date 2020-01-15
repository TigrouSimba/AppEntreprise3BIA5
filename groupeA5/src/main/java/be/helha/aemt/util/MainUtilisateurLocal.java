package be.helha.aemt.util;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.aemt.entities.Annonce;
import be.helha.aemt.entities.DemandeStage;
import be.helha.aemt.entities.Eleve;
import be.helha.aemt.entities.Evenement;
import be.helha.aemt.entities.Formation;
import be.helha.aemt.entities.ImgEntite;
import be.helha.aemt.entities.OffreEmploi;
import be.helha.aemt.entities.Portrait;
import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

public class MainUtilisateurLocal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("groupeA5");
		
		EntityManager em=emf.createEntityManager();

		Utilisateur ul=new Utilisateur("admin", "helha", "admin@gmail.com","admin");
		Utilisateur ul2=new Utilisateur("us2", "a", "us2@gmail.com","user");
		Utilisateur ul3=new Utilisateur("us3", "a", "us3@gmail.com","ancien");
		
		Visiteur v1=new Visiteur("192.193.194.195");
		
		Eleve el=new Eleve("Nya", "Corentin", 2020, "Informatique de gestion");
		Eleve el2=new Eleve("Opese", "Kevin", 2020, "Informatique de gestion");
		Eleve el3=new Eleve("Nicole", "Catherine", 2021, "Comptabilité");
		Eleve el4=new Eleve("Gérard", "Hubert", 2017, "Assistant de direction");
		Eleve el5=new Eleve("Chevalier", "Pierre", 2018, "Informatique de gestion");
		Eleve el6=new Eleve("Vincent", "Hubert", 2022, "Informatique de gestion");
		
		Annonce an1=new Annonce("nomAnnonce", "contenuAnnonce",  new Date(), ul);
		
		Evenement en1=new Evenement("nomEvenement",1,ul);
		
		Formation fo1=new Formation("nomFormation", "lienFormation");
		
		OffreEmploi ofe1=new OffreEmploi("nomEmploi", "contenuEmploi", "categorieEmploi", ul);
		
		DemandeStage do1 = new DemandeStage("nomStage","Stage");
		
		ImgEntite img=new ImgEntite();
		
		Portrait po=new Portrait("","", img);
		
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		
		em.persist(ul);	
		em.persist(ul2);
		em.persist(ul3);
		
		em.persist(v1);
		
		em.persist(el);
		em.persist(el2);
		em.persist(el3);
		em.persist(el4);
		em.persist(el5);
		em.persist(el6);
		
		em.persist(an1);
		
		em.persist(en1);
		
		em.persist(ofe1);
		
		em.persist(do1);
		
		/*em.persist(img);
		
		em.persist(po);*/
		
		tx.commit();
			
		em.close();
		emf.close();
		
	}

}
