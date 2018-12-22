package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the evenement database table.
 * 
 */
@Entity
@NamedQuery(name="Evenement.findAll", query="SELECT e FROM Evenement e")
public class Evenement implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id2;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateEvent;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateFin;

	private int nombrePlace2;

	private String nomEvent;

	//bi-directional many-to-one association to Administrateur
	@ManyToOne
	@JoinColumn(name="adm_id5")
	private Administrateur administrateur;

	//bi-directional many-to-one association to Lieu
	@ManyToOne
	@JoinColumn(name="id")
	private Lieu lieu;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id5")
	private Client client;

	//bi-directional many-to-one association to Typeevenement
	@ManyToOne
	@JoinColumn(name="id8")
	private Typeevenement typeevenement;

	public Evenement() {
	}

	public int getId2() {
		return this.id2;
	}

	public void setId2(int id2) {
		this.id2 = id2;
	}

	public Date getDateEvent() {
		return this.dateEvent;
	}

	public void setDateEvent(Date dateEvent) {
		this.dateEvent = dateEvent;
	}

	public Date getDateFin() {
		return this.dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public int getNombrePlace2() {
		return this.nombrePlace2;
	}

	public void setNombrePlace2(int nombrePlace2) {
		this.nombrePlace2 = nombrePlace2;
	}

	public String getNomEvent() {
		return this.nomEvent;
	}

	public void setNomEvent(String nomEvent) {
		this.nomEvent = nomEvent;
	}

	public Administrateur getAdministrateur() {
		return this.administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

	public Lieu getLieu() {
		return this.lieu;
	}

	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Typeevenement getTypeevenement() {
		return this.typeevenement;
	}

	public void setTypeevenement(Typeevenement typeevenement) {
		this.typeevenement = typeevenement;
	}

}