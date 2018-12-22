package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;



@Entity
@NamedQuery(name="Session.findAll", query="SELECT s FROM Session s")
public class Session implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id7;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateSession;

	private String heureDebut;

	private String heureFin;

	private int id2;

	private int id5;

	private int id6;

	private String ititule;

	private int nombrePlace;

	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="session1")
	private List<Inscription> inscriptions1;

	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="session2")
	private List<Inscription> inscriptions2;

	public Session() {
	}

	public int getId7() {
		return this.id7;
	}

	public void setId7(int id7) {
		this.id7 = id7;
	}

	public Date getDateSession() {
		return this.dateSession;
	}

	public void setDateSession(Date dateSession) {
		this.dateSession = dateSession;
	}

	public String getHeureDebut() {
		return this.heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return this.heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public int getId2() {
		return this.id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public int getId5() {
		return this.id5;
	}

	public void setId5(int id5) {
		this.id5 = id5;
	}

	public int getId6() {
		return this.id6;
	}

	public void setId6(int id6) {
		this.id6 = id6;
	}

	public String getItitule() {
		return this.ititule;
	}

	public void setItitule(String ititule) {
		this.ititule = ititule;
	}

	public int getNombrePlace() {
		return this.nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public List<Inscription> getInscriptions1() {
		return this.inscriptions1;
	}

	public void setInscriptions1(List<Inscription> inscriptions1) {
		this.inscriptions1 = inscriptions1;
	}

	public Inscription addInscriptions1(Inscription inscriptions1) {
		getInscriptions1().add(inscriptions1);
		inscriptions1.setSession1(this);

		return inscriptions1;
	}

	public Inscription removeInscriptions1(Inscription inscriptions1) {
		getInscriptions1().remove(inscriptions1);
		inscriptions1.setSession1(null);

		return inscriptions1;
	}

	public List<Inscription> getInscriptions2() {
		return this.inscriptions2;
	}

	public void setInscriptions2(List<Inscription> inscriptions2) {
		this.inscriptions2 = inscriptions2;
	}

	public Inscription addInscriptions2(Inscription inscriptions2) {
		getInscriptions2().add(inscriptions2);
		inscriptions2.setSession2(this);

		return inscriptions2;
	}

	public Inscription removeInscriptions2(Inscription inscriptions2) {
		getInscriptions2().remove(inscriptions2);
		inscriptions2.setSession2(null);

		return inscriptions2;
	}

}