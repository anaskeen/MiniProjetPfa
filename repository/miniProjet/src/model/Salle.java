package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the salle database table.
 * 
 */
@Entity
@NamedQuery(name="Salle.findAll", query="SELECT s FROM Salle s")
public class Salle implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id6;

	private int capacite;

	private String nomSalle;

	public Salle() {
	}

	public int getId6() {
		return this.id6;
	}

	public void setId6(int id6) {
		this.id6 = id6;
	}

	public int getCapacite() {
		return this.capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getNomSalle() {
		return this.nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

}