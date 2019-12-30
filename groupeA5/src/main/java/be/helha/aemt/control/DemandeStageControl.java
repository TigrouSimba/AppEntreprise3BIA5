package be.helha.aemt.control;

import java.io.Serializable;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.helha.aemt.entities.DemandeStage;

public class DemandeStageControl extends HttpServlet implements Serializable {
	
	private static final String FIELD_NOM ="nom";
	private static final String FIELD_CONTENU="contenu";
	
	public void doPost(HttpServletRequest request,HttpServletResponse reponse)
	{
		String nom = request.getParameter(FIELD_NOM);
		String contenu = request.getParameter(FIELD_CONTENU);
		
		DemandeStage dd = new DemandeStage(nom, contenu);
		System.out.println(dd.toString());
		
	}

}
