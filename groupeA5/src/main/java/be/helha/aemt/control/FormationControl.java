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
		
		public GestionFormationEJB getEjb() {
			return ejb;
		}

		public void setEjb(GestionFormationEJB ejb) {
			this.ejb = ejb;
		}
		
		//Getteur et setteur
		
		public String getNomFormation() {
			return nomFormation;
		}

		public void setNomFormation(String nomFormation) {
			this.nomFormation = nomFormation;
		}
		
		public String getLienFormation() {
			return lienFormation;
		}

		public void setLienFormation(String lienFormation) {
			this.lienFormation = lienFormation;
		}

		public String getNewNomFormation() {
			return newNomFormation;
		}

		public void setNewNomFormation(String newNomFormation) {
			this.newNomFormation = newNomFormation;
		}

		public String getNewLienFormation() {
			return newLienFormation;
		}

		public void setNewLienFormation(String newLienFormation) {
			this.newLienFormation = newLienFormation;
		}

		public FormationControl() {						
			
		}
		
		//Methode
		public void postFormation()
		{
			Formation form = new Formation(nomFormation,lienFormation);
			System.out.println(form.getNomFormation());
			ejb.add(form);
			nomFormation="";
			lienFormation="";
		}
		
		public void updateFormation(Formation formation)
		{
			formation.setLienFormation(newLienFormation);
			formation.setNomFormation(newNomFormation);						
			ejb.updateFormation(formation);
			newLienFormation="";
			newNomFormation="";
			
		}
		
		public void removeFormation(Formation formation)
		{
			ejb.remove(formation);
		}
		
	}


