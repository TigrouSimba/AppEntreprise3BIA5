package be.helha.aemt.control;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import be.helha.aemt.ejb.GestionFormationEJB;
import be.helha.aemt.entities.Formation;



	@SessionScoped
	@Named
	public class FormationControl implements Serializable {
		
		
		private static final long serialVersionUID = 1L;
		
		private String nomFormation;
		
		private String lienFormation;
		
		private String newNomFormation;
		
		private String newLienFormation;

		private Formation formation;
		
		@EJB
		private GestionFormationEJB ejb;
		
		/**
		 * 
		 * @return la valeur de ejb
		 */
		public GestionFormationEJB getEjb() {
			return ejb;
		}
		
		/**
		 * change la valeur de ejb par celui passe en parametre
		 * @param ejb la valeur qui doit remplacer celle actuelle
		 */
		public void setEjb(GestionFormationEJB ejb) {
			this.ejb = ejb;
		}
		
		//Getteur et setteur
		
		/**
		 * 
		 * @return la valeur de nomFormation
		 */
		public String getNomFormation() {
			return nomFormation;
		}
		
		/**
		 * change la valeur de nomFormation par celui passe en parametre
		 * @param nomFormation la valeur qui doit remplacer celle actuelle
		 */
		public void setNomFormation(String nomFormation) {
			this.nomFormation = nomFormation;
		}
		
		/**
		 * 
		 * @return la valeur de lienFormation
		 */
		public String getLienFormation() {
			return lienFormation;
		}
		
		/**
		 * change la valeur de lienFormation par celui passe en parametre
		 * @param lienFormation la valeur qui doit remplacer celle actuelle
		 */
		public void setLienFormation(String lienFormation) {
			this.lienFormation = lienFormation;
		}
		
		/**
		 * 
		 * @return la valeur de newNomFormation
		 */
		public String getNewNomFormation() {
			return newNomFormation;
		}
		
		/**
		 * change la valeur de newNomFormation par celui passe en parametre
		 * @param newNomFormation la valeur qui doit remplacer celle actuelle
		 */
		public void setNewNomFormation(String newNomFormation) {
			this.newNomFormation = newNomFormation;
		}
		
		/**
		 * 
		 * @return la valeur de newLienFormation
		 */
		public String getNewLienFormation() {
			return newLienFormation;
		}
		
		/**
		 * change la valeur de newLienFormation par celui passe en parametre
		 * @param newLienFormation la valeur qui doit remplacer celle actuelle
		 */
		public void setNewLienFormation(String newLienFormation) {
			this.newLienFormation = newLienFormation;
		}

		public FormationControl() {						
			
		}
		
		//Methode
		/**
		 * permet d'ajouter une formation dans la base de données
		 * @return la formation
		 */
		public void postFormation()
		{
			Formation form = new Formation(nomFormation,lienFormation);
			System.out.println(form.getNomFormation());
			ejb.add(form);
			nomFormation="";
			lienFormation="";
		}
		
		/**
		 * permet de modifier une formation dans la base de données
		 * @param formation la formation a modifier
		 * @return la formation
		 */
		public void updateFormation(Formation formation)
		{
			formation.setLienFormation(newLienFormation);
			formation.setNomFormation(newNomFormation);						
			ejb.updateFormation(formation);
			newLienFormation="";
			newNomFormation="";
			
		}
		
		/**
		 * permet de supprimer une formation de la base de donnees
		 * @param formation la formation a supprimer
		 * @return la formation
		 */
		public void removeFormation(Formation formation)
		{
			ejb.remove(formation);
		}
		
	}


