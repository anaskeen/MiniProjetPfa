package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the inscrit database table.
 * 
 */
@Entity
@NamedQuery(name="Inscrit.findAll", query="SELECT i FROM Inscrit i")
public class Inscrit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id5;

	private String email;

	private String nom;

	private String password;

	private String prenom;

	public Inscrit() {
	}

	public int getId5() {
		return this.id5;
	}

	public void setId5(int id5) {
		this.id5 = id5;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}