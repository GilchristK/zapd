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
@Table(name = "Cases")
public class Cases implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String referenceNumber;

	@Column
	private String reasonOfComplaint;

	@Column
	private String complaintDate;

	@Column
	private String actionTaken;

	@Column
	private String resolutionDate;

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
		if (!(obj instanceof Cases)) {
			return false;
		}
		Cases other = (Cases) obj;
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

	public String getReferenceNumber() {
		return referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public String getReasonOfComplaint() {
		return reasonOfComplaint;
	}

	public void setReasonOfComplaint(String reasonOfComplaint) {
		this.reasonOfComplaint = reasonOfComplaint;
	}

	public String getComplaintDate() {
		return complaintDate;
	}

	public void setComplaintDate(String complaintDate) {
		this.complaintDate = complaintDate;
	}

	public String getActionTaken() {
		return actionTaken;
	}

	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}

	public String getResolutionDate() {
		return resolutionDate;
	}

	public void setResolutionDate(String resolutionDate) {
		this.resolutionDate = resolutionDate;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (referenceNumber != null && !referenceNumber.trim().isEmpty())
			result += "referenceNumber: " + referenceNumber;
		if (reasonOfComplaint != null && !reasonOfComplaint.trim().isEmpty())
			result += ", reasonOfComplaint: " + reasonOfComplaint;
		if (complaintDate != null && !complaintDate.trim().isEmpty())
			result += ", complaintDate: " + complaintDate;
		if (actionTaken != null && !actionTaken.trim().isEmpty())
			result += ", actionTaken: " + actionTaken;
		if (resolutionDate != null && !resolutionDate.trim().isEmpty())
			result += ", resolutionDate: " + resolutionDate;
		return result;
	}
}