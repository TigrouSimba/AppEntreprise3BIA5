package be.helha.aemt.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Utilisateur extends Visiteur implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;*/
	private String login;
	private String password;
	private String groupName;
	@OneToMany(mappedBy = "user")
	private List<Annonce> annonces;
	@OneToMany(mappedBy = "createurEmploi")
	private List<OffreEmploi> offresEmploi;
	@OneToMany(mappedBy= "createurStage") 
	private List<DemandeStage>demandeStage;
	@OneToMany(mappedBy= "user") 
	private List<Evenement>evenements;
	
	public Utilisateur() {
		
	}
	
	
	public Utilisateur(String login, String password, String groupName) {
		this.login = login;
		try {
			this.password = toHexString(getSHA(password));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.groupName=groupName;
		annonces=new ArrayList<Annonce>();
		offresEmploi=new ArrayList<OffreEmploi>();
	}

	public Utilisateur(String login, String groupName) {
		this.login = login;
		this.groupName = groupName;
	}


	/*public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}*/


	public Utilisateur(String login, String password, String groupName, 
			List<Annonce> annonces, List<OffreEmploi> offresEmploi, List<DemandeStage> demandeStage,List<Evenement>evenements) {
		super();
		this.login = login;
		this.password = password;
		this.groupName = groupName;
		this.annonces = annonces;
		this.offresEmploi = offresEmploi;
		this.demandeStage = demandeStage;
		this.evenements=evenements;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	
	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	
	public List<Annonce> getAnnonces() {
		return annonces;
	}


	public void setAnnonces(List<Annonce> annonces) {
		this.annonces = annonces;
	}


	public List<OffreEmploi> getOffresEmploi() {
		return offresEmploi;
	}


	public void setOffresEmploi(List<OffreEmploi> offresEmploi) {
		this.offresEmploi = offresEmploi;
	}

	
	public void ajoutAnnonce(Annonce annonce) {
		annonces.add(annonce);
	}
	
	public void ajoutOffreEmploi(OffreEmploi emploi) {
		offresEmploi.add(emploi);
	}
	
	
	//pour crypter en sha256
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {  
        // Static getInstance method is called with hashing SHA  
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
  
        // digest() method called  
        // to calculate message digest of an input  
        // and return array of byte 
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
        // Convert byte array into signum representation  
        BigInteger number = new BigInteger(1, hash);  
  
        // Convert message digest into hex value  
        StringBuilder hexString = new StringBuilder(number.toString(16));  
  
        // Pad with leading zeros 
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    }


	public List<Evenement> getEvenements() {
		return evenements;
	}


	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((annonces == null) ? 0 : annonces.hashCode());
		result = prime * result + ((demandeStage == null) ? 0 : demandeStage.hashCode());
		result = prime * result + ((evenements == null) ? 0 : evenements.hashCode());
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((offresEmploi == null) ? 0 : offresEmploi.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (annonces == null) {
			if (other.annonces != null)
				return false;
		} else if (!annonces.equals(other.annonces))
			return false;
		if (demandeStage == null) {
			if (other.demandeStage != null)
				return false;
		} else if (!demandeStage.equals(other.demandeStage))
			return false;
		if (evenements == null) {
			if (other.evenements != null)
				return false;
		} else if (!evenements.equals(other.evenements))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (offresEmploi == null) {
			if (other.offresEmploi != null)
				return false;
		} else if (!offresEmploi.equals(other.offresEmploi))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Utilisateur [login=" + login + ", password=" + password + ", groupName=" + groupName + ", annonces="
				+ annonces + ", offresEmploi=" + offresEmploi + ", demandeStage=" + demandeStage + ", evenements="
				+ evenements + "]";
	}


	
	
}
