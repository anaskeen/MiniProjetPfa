package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the typeevenement database table.
 * 
 */
@Entity
@NamedQuery(name="Typeevenement.findAll", query="SELECT t FROM Typeevenement t")
public class Typeevenement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id8;

	private String sujetEvenement;

	private String typeEvenement;

	//bi-directional many-to-one association to Evenement
	@OneToMany(mappedBy="typeevenement")
	private List<Evenement> evenements;

	public Typeevenement() {
	}

	public int getId8() {
		return this.id8;
	}

	public void setId8(int id8) {
		this.id8 = id8;
	}

	public String getSujetEvenement() {
		return this.sujetEvenement;
	}

	public void setSujetEvenement(String sujetEvenement) {
		this.sujetEvenement = sujetEvenement;
	}

	public String getTypeEvenement() {
		return this.typeEvenement;
	}

	public void setTypeEvenement(String typeEvenement) {
		this.typeEvenement = typeEvenement;
	}

	public List<Evenement> getEvenements() {
		return this.evenements;
	}

	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	public Evenement addEvenement(Evenement evenement) {
		getEvenements().add(evenement);
		evenement.setTypeevenement(this);

		return evenement;
	}

	public Evenement removeEvenement(Evenement evenement) {
		getEvenements().remove(evenement);
		evenement.setTypeevenement(null);

		return evenement;
	}

}