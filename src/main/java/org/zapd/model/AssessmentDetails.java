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
@Table(name = "AssessmentDetails")
public class AssessmentDetails implements Serializable {

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
	private String dateOfAssessment;

	@Column
	private String dateOfDisability;

	@Column
	private String causeOfDisabilty;

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
		if (!(obj instanceof AssessmentDetails)) {
			return false;
		}
		AssessmentDetails other = (AssessmentDetails) obj;
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

	public String getDateOfAssessment() {
		return dateOfAssessment;
	}

	public void setDateOfAssessment(String dateOfAssessment) {
		this.dateOfAssessment = dateOfAssessment;
	}

	public String getDateOfDisability() {
		return dateOfDisability;
	}

	public void setDateOfDisability(String dateOfDisability) {
		this.dateOfDisability = dateOfDisability;
	}

	public String getCauseOfDisabilty() {
		return causeOfDisabilty;
	}

	public void setCauseOfDisabilty(String causeOfDisabilty) {
		this.causeOfDisabilty = causeOfDisabilty;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (dmisNumber != null && !dmisNumber.trim().isEmpty())
			result += "dmisNumber: " + dmisNumber;
		if (dateOfAssessment != null && !dateOfAssessment.trim().isEmpty())
			result += ", dateOfAssessment: " + dateOfAssessment;
		if (dateOfDisability != null && !dateOfDisability.trim().isEmpty())
			result += ", dateOfDisability: " + dateOfDisability;
		if (causeOfDisabilty != null && !causeOfDisabilty.trim().isEmpty())
			result += ", causeOfDisabilty: " + causeOfDisabilty;
		return result;
	}
}