package org.zapd.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;

@Entity
@Table(name = "Update")
public class Update implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String dmisNumber;

	@Column
	private String surname;

	@Column
	private String otherNames;

	@Column
	private String identity;

	@Column
	private String typeOfUpdate;

	@Column
	private String dateOfUpdate;

	@Column
	private String dateOfDeath;

	@Column
	private String causeOfDeath;

	@Column
	private String nextOfKin;

	@Column
	private String nextOfKinContact;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Update)) {
			return false;
		}
		Update other = (Update) obj;
		if (id != null) {
			if (!id.equals(other.id)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public String getDmisNumber() {
		return dmisNumber;
	}

	public void setDmisNumber(String dmisNumber) {
		this.dmisNumber = dmisNumber;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getOtherNames() {
		return otherNames;
	}

	public void setOtherNames(String otherNames) {
		this.otherNames = otherNames;
	}

	public String getIdentity() {
		return identity;
	}

	public void setIdentity(String identity) {
		this.identity = identity;
	}

	public String getTypeOfUpdate() {
		return typeOfUpdate;
	}

	public void setTypeOfUpdate(String typeOfUpdate) {
		this.typeOfUpdate = typeOfUpdate;
	}

	public String getDateOfUpdate() {
		return dateOfUpdate;
	}

	public void setDateOfUpdate(String dateOfUpdate) {
		this.dateOfUpdate = dateOfUpdate;
	}

	public String getDateOfDeath() {
		return dateOfDeath;
	}

	public void setDateOfDeath(String dateOfDeath) {
		this.dateOfDeath = dateOfDeath;
	}

	public String getCauseOfDeath() {
		return causeOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}

	public String getNextOfKin() {
		return nextOfKin;
	}

	public void setNextOfKin(String nextOfKin) {
		this.nextOfKin = nextOfKin;
	}

	public String getNextOfKinContact() {
		return nextOfKinContact;
	}

	public void setNextOfKinContact(String nextOfKinContact) {
		this.nextOfKinContact = nextOfKinContact;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (dmisNumber != null && !dmisNumber.trim().isEmpty())
			result += "dmisNumber: " + dmisNumber;
		if (surname != null && !surname.trim().isEmpty())
			result += ", surname: " + surname;
		if (otherNames != null && !otherNames.trim().isEmpty())
			result += ", otherNames: " + otherNames;
		if (identity != null && !identity.trim().isEmpty())
			result += ", identity: " + identity;
		if (typeOfUpdate != null && !typeOfUpdate.trim().isEmpty())
			result += ", typeOfUpdate: " + typeOfUpdate;
		if (dateOfUpdate != null && !dateOfUpdate.trim().isEmpty())
			result += ", dateOfUpdate: " + dateOfUpdate;
		if (dateOfDeath != null && !dateOfDeath.trim().isEmpty())
			result += ", dateOfDeath: " + dateOfDeath;
		if (causeOfDeath != null && !causeOfDeath.trim().isEmpty())
			result += ", causeOfDeath: " + causeOfDeath;
		if (nextOfKin != null && !nextOfKin.trim().isEmpty())
			result += ", nextOfKin: " + nextOfKin;
		if (nextOfKinContact != null && !nextOfKinContact.trim().isEmpty())
			result += ", nextOfKinContact: " + nextOfKinContact;
		return result;
	}
}