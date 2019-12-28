package be.helha.aemt.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import be.helha.aemt.entities.Utilisateur;
import be.helha.aemt.entities.Visiteur;

public class MainUtilisateurLocal {

	public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("groupeA5");
		
		EntityManager em=emf.createEntityManager();

		Utilisateur ul=new Utilisateur("us1", "a", "us1@gmail.com","admin");
		Utilisateur ul2=new Utilisateur("us2", "a", "us2@gmail.com","user");
		Utilisateur ul3=new Utilisateur("us3", "a", "us3@gmail.com","ancien");
		Visiteur v1=new Visiteur("192.193.194.195");
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(ul);	
		em.persist(ul2);
		em.persist(ul3);
		em.persist(v1);
		tx.commit();
			
		em.close();
		emf.close();
		
	}

}
