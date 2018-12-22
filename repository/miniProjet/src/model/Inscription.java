package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the inscription database table.
 * 
 */
@Entity
@NamedQuery(name="Inscription.findAll", query="SELECT i FROM Inscription i")
public class Inscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id3;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date_inscription")
	private Date dateInscription;

	private int id5;

	//bi-directional many-to-one association to Session
	@ManyToOne
	@JoinColumn(name="id7")
	private Session session1;

	//bi-directional many-to-one association to Invitation
	@ManyToOne
	@JoinColumn(name="id4")
	private Invitation invitation;

	//bi-directional many-to-one association to Session
	@ManyToOne
	@JoinColumn(name="id7")
	private Session session2;

	public Inscription() {
	}

	public int getId3() {
		return this.id3;
	}

	public void setId3(int id3) {
		this.id3 = id3;
	}

	public Date getDateInscription() {
		return this.dateInscription;
	}

	public void setDateInscription(Date dateInscription) {
		this.dateInscription = dateInscription;
	}

	public int getId5() {
		return this.id5;
	}

	public void setId5(int id5) {
		this.id5 = id5;
	}

	public Session getSession1() {
		return this.session1;
	}

	public void setSession1(Session session1) {
		this.session1 = session1;
	}

	public Invitation getInvitation() {
		return this.invitation;
	}

	public void setInvitation(Invitation invitation) {
		this.invitation = invitation;
	}

	public Session getSession2() {
		return this.session2;
	}

	public void setSession2(Session session2) {
		this.session2 = session2;
	}

}