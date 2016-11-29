package org.zapd.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class PersonWithDisability implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String firstname;

	@Column
	private String surname;

	@Column
	private String dateOfBirth;

	@Column
	private String nrc;

	@Column(length = 6)
	private String sex;

	@Column(length = 20)
	private Interger dmisNumber;

	@Column(length = 1)
	private Char maritalStatus;

	@Column
	private String educationLevel;

	@Column
	private String occupation;

	@Column(length = 15)
	private Date dateOfRegistration;

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
		if (!(obj instanceof PersonWithDisability)) {
			return false;
		}
		PersonWithDisability other = (PersonWithDisability) obj;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNrc() {
		return nrc;
	}

	public void setNrc(String nrc) {
		this.nrc = nrc;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Interger getDmisNumber() {
		return dmisNumber;
	}

	public void setDmisNumber(Interger dmisNumber) {
		this.dmisNumber = dmisNumber;
	}

	public Char getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(Char maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public Date getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(Date dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (firstname != null && !firstname.trim().isEmpty())
			result += "firstname: " + firstname;
		if (surname != null && !surname.trim().isEmpty())
			result += ", surname: " + surname;
		if (dateOfBirth != null && !dateOfBirth.trim().isEmpty())
			result += ", dateOfBirth: " + dateOfBirth;
		if (nrc != null && !nrc.trim().isEmpty())
			result += ", nrc: " + nrc;
		if (sex != null && !sex.trim().isEmpty())
			result += ", sex: " + sex;
		if (educationLevel != null && !educationLevel.trim().isEmpty())
			result += ", educationLevel: " + educationLevel;
		if (occupation != null && !occupation.trim().isEmpty())
			result += ", occupation: " + occupation;
		return result;
	}
}