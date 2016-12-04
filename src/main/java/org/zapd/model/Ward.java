package org.zapd.model;

import javax.persistence.Entity;
import java.io.Serializable;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Version;
import java.util.Set;
import java.util.HashSet;
import org.zapd.model.PersonWithDisability;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;

@Entity
@Table(name = "Ward")
public class Ward implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	@Version
	@Column(name = "version")
	private int version;

	@Column
	private String nameOfWard;

	@OneToMany(mappedBy = "ward", cascade = CascadeType.ALL)
	private Set<PersonWithDisability> ward = new HashSet<PersonWithDisability>();

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
		if (!(obj instanceof Ward)) {
			return false;
		}
		Ward other = (Ward) obj;
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

	public String getNameOfWard() {
		return nameOfWard;
	}

	public void setNameOfWard(String nameOfWard) {
		this.nameOfWard = nameOfWard;
	}

	@Override
	public String toString() {
		String result = getClass().getSimpleName() + " ";
		if (nameOfWard != null && !nameOfWard.trim().isEmpty())
			result += "nameOfWard: " + nameOfWard;
		return result;
	}

	public Set<PersonWithDisability> getWard() {
		return this.ward;
	}

	public void setWard(final Set<PersonWithDisability> ward) {
		this.ward = ward;
	}
}