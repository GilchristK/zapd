/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name = "constituencies")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Constituency.findAll", query = "SELECT c FROM Constituency c"),
    @NamedQuery(name = "Constituency.findById", query = "SELECT c FROM Constituency c WHERE c.id = :id"),
    @NamedQuery(name = "Constituency.findByName", query = "SELECT c FROM Constituency c WHERE c.name = :name")})
public class Constituency implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "constituency")
    private Collection<Ward> wardCollection;
    @JoinColumn(name = "DISTRICT", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private District district;

    public Constituency() {
    }

    public Constituency(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public Collection<Ward> getWardCollection() {
        return wardCollection;
    }

    public void setWardCollection(Collection<Ward> wardCollection) {
        this.wardCollection = wardCollection;
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Constituency)) {
            return false;
        }
        Constituency other = (Constituency) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.unza.ctu.zapd.beans.entity.Constituency[ id=" + id + " ]";
    }
    
}
