package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the invitation database table.
 * 
 */
@Entity
@NamedQuery(name="Invitation.findAll", query="SELECT i FROM Invitation i")
public class Invitation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id4;

	private byte paiement;

	private int qrCode;

	//bi-directional many-to-one association to Inscription
	@OneToMany(mappedBy="invitation")
	private List<Inscription> inscriptions;

	public Invitation() {
	}

	public int getId4() {
		return this.id4;
	}

	public void setId4(int id4) {
		this.id4 = id4;
	}

	public byte getPaiement() {
		return this.paiement;
	}

	public void setPaiement(byte paiement) {
		this.paiement = paiement;
	}

	public int getQrCode() {
		return this.qrCode;
	}

	public void setQrCode(int qrCode) {
		this.qrCode = qrCode;
	}

	public List<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(List<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	public Inscription addInscription(Inscription inscription) {
		getInscriptions().add(inscription);
		inscription.setInvitation(this);

		return inscription;
	}

	public Inscription removeInscription(Inscription inscription) {
		getInscriptions().remove(inscription);
		inscription.setInvitation(null);

		return inscription;
	}

}