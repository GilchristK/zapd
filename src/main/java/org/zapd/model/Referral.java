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
@Table(name = "Referral")
public class Referral implements Serializable {

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
	private String startDate;

	@Column
	private String endDate;

	@Column
	private String locationOfService;

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
		if (!(obj instanceof Referral)) {
			return false;
		}
		Referral other = (Referral) obj;
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getLocationOfService() {
		return locationOfService;
	}

	public void setLocationOfService(String locationOfService) {
		this.locationOfService = locationOfService;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (dmisNumber != null && !dmisNumber.trim().isEmpty())
			result += "dmisNumber: " + dmisNumber;
		if (startDate != null && !startDate.trim().isEmpty())
			result += ", startDate: " + startDate;
		if (endDate != null && !endDate.trim().isEmpty())
			result += ", endDate: " + endDate;
		if (locationOfService != null && !locationOfService.trim().isEmpty())
			result += ", locationOfService: " + locationOfService;
		return result;
	}
}