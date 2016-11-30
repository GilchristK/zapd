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

	@Column
	private String educationLevel;

	@Column
	private String occupation;

	@Column(name = "dmisNumber")
	private Long dmisNumber;

	@Column(name = "dateOfRegistration")
	private String dateOfRegistration;

	@Column
	private String maritalStatus;

	@Column
	private String contactNumber;

	@Column
	private String levelOfEducation;

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

	public Long getDmisNumber() {
		return dmisNumber;
	}

	public void setDmisNumber(Long dmisNumber) {
		this.dmisNumber = dmisNumber;
	}

	public String getDateOfRegistration() {
		return dateOfRegistration;
	}

	public void setDateOfRegistration(String dateOfRegistration) {
		this.dateOfRegistration = dateOfRegistration;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getLevelOfEducation() {
		return levelOfEducation;
	}

	public void setLevelOfEducation(String levelOfEducation) {
		this.levelOfEducation = levelOfEducation;
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
		if (dmisNumber != null)
			result += ", dmisNumber: " + dmisNumber;
		if (dateOfRegistration != null && !dateOfRegistration.trim().isEmpty())
			result += ", dateOfRegistration: " + dateOfRegistration;
		if (maritalStatus != null && !maritalStatus.trim().isEmpty())
			result += ", maritalStatus: " + maritalStatus;
		if (contactNumber != null && !contactNumber.trim().isEmpty())
			result += ", contactNumber: " + contactNumber;
		if (levelOfEducation != null && !levelOfEducation.trim().isEmpty())
			result += ", levelOfEducation: " + levelOfEducation;
		return result;
	}
}