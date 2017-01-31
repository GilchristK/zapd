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
@Table(name = "service_providers")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServiceProvider.findAll", query = "SELECT s FROM ServiceProvider s"),
    @NamedQuery(name = "ServiceProvider.findById", query = "SELECT s FROM ServiceProvider s WHERE s.id = :id"),
    @NamedQuery(name = "ServiceProvider.findByCategory", query = "SELECT s FROM ServiceProvider s WHERE s.category = :category"),
    @NamedQuery(name = "ServiceProvider.findByName", query = "SELECT s FROM ServiceProvider s WHERE s.name = :name"),
    @NamedQuery(name = "ServiceProvider.findByPhysicaladdress", query = "SELECT s FROM ServiceProvider s WHERE s.physicaladdress = :physicaladdress"),
    @NamedQuery(name = "ServiceProvider.findByPostaladdress", query = "SELECT s FROM ServiceProvider s WHERE s.postaladdress = :postaladdress"),
    @NamedQuery(name = "ServiceProvider.findBySector", query = "SELECT s FROM ServiceProvider s WHERE s.sector = :sector"),
    @NamedQuery(name = "ServiceProvider.findByStatus", query = "SELECT s FROM ServiceProvider s WHERE s.status = :status"),
    @NamedQuery(name = "ServiceProvider.findByTypeofservice", query = "SELECT s FROM ServiceProvider s WHERE s.typeofservice = :typeofservice")})
public class ServiceProvider implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "CATEGORY")
    private String category;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "PHYSICALADDRESS")
    private String physicaladdress;
    @Size(max = 255)
    @Column(name = "POSTALADDRESS")
    private String postaladdress;
    @Size(max = 255)
    @Column(name = "SECTOR")
    private String sector;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;
    @Size(max = 255)
    @Column(name = "TYPEOFSERVICE")
    private String typeofservice;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "serviceprovider")
    private Collection<ClientReferral> clientReferralCollection;

    public ServiceProvider() {
    }

    public ServiceProvider(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhysicaladdress() {
        return physicaladdress;
    }

    public void setPhysicaladdress(String physicaladdress) {
        this.physicaladdress = physicaladdress;
    }

    public String getPostaladdress() {
        return postaladdress;
    }

    public void setPostaladdress(String postaladdress) {
        this.postaladdress = postaladdress;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTypeofservice() {
        return typeofservice;
    }

    public void setTypeofservice(String typeofservice) {
        this.typeofservice = typeofservice;
    }

    @XmlTransient
    public Collection<ClientReferral> getClientReferralCollection() {
        return clientReferralCollection;
    }

    public void setClientReferralCollection(Collection<ClientReferral> clientReferralCollection) {
        this.clientReferralCollection = clientReferralCollection;
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
        if (!(object instanceof ServiceProvider)) {
            return false;
        }
        ServiceProvider other = (ServiceProvider) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.unza.ctu.zapd.beans.entity.ServiceProvider[ id=" + id + " ]";
    }
    
}
