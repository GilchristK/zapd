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
@Table(name = "ServiceProvider")
public class ServiceProvider implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String nameOfServiceProvider;

	@Column
	private String postalAddress;

	@Column
	private String physicalAddress;

	@Column
	private String geographicalLocation;

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
		if (!(obj instanceof ServiceProvider)) {
			return false;
		}
		ServiceProvider other = (ServiceProvider) obj;
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

	public String getNameOfServiceProvider() {
		return nameOfServiceProvider;
	}

	public void setNameOfServiceProvider(String nameOfServiceProvider) {
		this.nameOfServiceProvider = nameOfServiceProvider;
	}

	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	public String getPhysicalAddress() {
		return physicalAddress;
	}

	public void setPhysicalAddress(String physicalAddress) {
		this.physicalAddress = physicalAddress;
	}

	public String getGeographicalLocation() {
		return geographicalLocation;
	}

	public void setGeographicalLocation(String geographicalLocation) {
		this.geographicalLocation = geographicalLocation;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (nameOfServiceProvider != null
				&& !nameOfServiceProvider.trim().isEmpty())
			result += "nameOfServiceProvider: " + nameOfServiceProvider;
		if (postalAddress != null && !postalAddress.trim().isEmpty())
			result += ", postalAddress: " + postalAddress;
		if (physicalAddress != null && !physicalAddress.trim().isEmpty())
			result += ", physicalAddress: " + physicalAddress;
		if (geographicalLocation != null
				&& !geographicalLocation.trim().isEmpty())
			result += ", geographicalLocation: " + geographicalLocation;
		return result;
	}
}