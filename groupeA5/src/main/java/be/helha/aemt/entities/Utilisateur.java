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
	private String email;
	private String groupName;
	private Image photo;
	@OneToMany(mappedBy = "createurAnnonce")
	private List<Annonce> annonces;
	@OneToMany(mappedBy = "createurEmploi")
	private List<OffreEmploi> offresEmploi;
	
	public Utilisateur() {
		
	}
	
	
	public Utilisateur(String login, String password, String email,String groupName) {
		this.login = login;
		try {
			this.password = toHexString(getSHA(password));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//this.password=password;
		this.email = email;
		this.groupName=groupName;
		annonces=new ArrayList<Annonce>();
		offresEmploi=new ArrayList<OffreEmploi>();
	}


	/*public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}*/


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getGroupName() {
		return groupName;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public Image getPhoto() {
		return photo;
	}


	public void setPhoto(Image photo) {
		this.photo = photo;
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


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((annonces == null) ? 0 : annonces.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((groupName == null) ? 0 : groupName.hashCode());
		//result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((offresEmploi == null) ? 0 : offresEmploi.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		if (annonces == null) {
			if (other.annonces != null)
				return false;
		} else if (!annonces.equals(other.annonces))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (groupName == null) {
			if (other.groupName != null)
				return false;
		} else if (!groupName.equals(other.groupName))
			return false;
		/*if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;*/
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
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Utilisateur [id=" + /*id +*/ ", login=" + login + ", password=" + password + ", email=" + email
				+ ", groupName=" + groupName + ", photo=" + photo + ", annonces=" + annonces + ", offresEmploi="
				+ offresEmploi + "]";
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
	
}
