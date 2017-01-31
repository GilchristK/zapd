/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name = "client_referrals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ClientReferral.findAll", query = "SELECT c FROM ClientReferral c"),
    @NamedQuery(name = "ClientReferral.findByReferencenumber", query = "SELECT c FROM ClientReferral c WHERE c.referencenumber = :referencenumber"),
    @NamedQuery(name = "ClientReferral.findByEndofservice", query = "SELECT c FROM ClientReferral c WHERE c.endofservice = :endofservice"),
    @NamedQuery(name = "ClientReferral.findByLocationofservice", query = "SELECT c FROM ClientReferral c WHERE c.locationofservice = :locationofservice"),
    @NamedQuery(name = "ClientReferral.findByStartofservice", query = "SELECT c FROM ClientReferral c WHERE c.startofservice = :startofservice")})
public class ClientReferral implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "REFERENCENUMBER")
    private String referencenumber;
    @Column(name = "ENDOFSERVICE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endofservice;
    @Size(max = 255)
    @Column(name = "LOCATIONOFSERVICE")
    private String locationofservice;
    @Column(name = "STARTOFSERVICE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startofservice;
    @JoinColumn(name = "DMISNUMBER", referencedColumnName = "DMISNUMBER")
    @ManyToOne
    private PersonDisability dmisnumber;
    @JoinColumn(name = "SERVICEPROVIDER", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private ServiceProvider serviceprovider;

    public ClientReferral() {
    }

    public ClientReferral(String referencenumber) {
        this.referencenumber = referencenumber;
    }

    public String getReferencenumber() {
        return referencenumber;
    }

    public void setReferencenumber(String referencenumber) {
        this.referencenumber = referencenumber;
    }

    public Date getEndofservice() {
        return endofservice;
    }

    public void setEndofservice(Date endofservice) {
        this.endofservice = endofservice;
    }

    public String getLocationofservice() {
        return locationofservice;
    }

    public void setLocationofservice(String locationofservice) {
        this.locationofservice = locationofservice;
    }

    public Date getStartofservice() {
        return startofservice;
    }

    public void setStartofservice(Date startofservice) {
        this.startofservice = startofservice;
    }

    public PersonDisability getDmisnumber() {
        return dmisnumber;
    }

    public void setDmisnumber(PersonDisability dmisnumber) {
        this.dmisnumber = dmisnumber;
    }

    public ServiceProvider getServiceprovider() {
        return serviceprovider;
    }

    public void setServiceprovider(ServiceProvider serviceprovider) {
        this.serviceprovider = serviceprovider;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referencenumber != null ? referencenumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClientReferral)) {
            return false;
        }
        ClientReferral other = (ClientReferral) object;
        if ((this.referencenumber == null && other.referencenumber != null) || (this.referencenumber != null && !this.referencenumber.equals(other.referencenumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.unza.ctu.zapd.beans.entity.ClientReferral[ referencenumber=" + referencenumber + " ]";
    }
    
}
