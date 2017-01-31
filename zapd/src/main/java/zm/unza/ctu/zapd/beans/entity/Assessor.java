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
@Table(name = "assessors")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assessor.findAll", query = "SELECT a FROM Assessor a"),
    @NamedQuery(name = "Assessor.findById", query = "SELECT a FROM Assessor a WHERE a.id = :id"),
    @NamedQuery(name = "Assessor.findByDestination", query = "SELECT a FROM Assessor a WHERE a.destination = :destination"),
    @NamedQuery(name = "Assessor.findByHpc", query = "SELECT a FROM Assessor a WHERE a.hpc = :hpc"),
    @NamedQuery(name = "Assessor.findByName", query = "SELECT a FROM Assessor a WHERE a.name = :name"),
    @NamedQuery(name = "Assessor.findByNrc", query = "SELECT a FROM Assessor a WHERE a.nrc = :nrc"),
    @NamedQuery(name = "Assessor.findBySex", query = "SELECT a FROM Assessor a WHERE a.sex = :sex")})
public class Assessor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "DESTINATION")
    private String destination;
    @Size(max = 255)
    @Column(name = "HPC")
    private String hpc;
    @Size(max = 255)
    @Column(name = "NAME")
    private String name;
    @Size(max = 255)
    @Column(name = "NRC")
    private String nrc;
    @Size(max = 255)
    @Column(name = "SEX")
    private String sex;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assessor")
    private Collection<AssessmentDetail> assessmentDetailCollection;

    public Assessor() {
    }

    public Assessor(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getHpc() {
        return hpc;
    }

    public void setHpc(String hpc) {
        this.hpc = hpc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    @XmlTransient
    public Collection<AssessmentDetail> getAssessmentDetailCollection() {
        return assessmentDetailCollection;
    }

    public void setAssessmentDetailCollection(Collection<AssessmentDetail> assessmentDetailCollection) {
        this.assessmentDetailCollection = assessmentDetailCollection;
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
        if (!(object instanceof Assessor)) {
            return false;
        }
        Assessor other = (Assessor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.unza.ctu.zapd.beans.entity.Assessor[ id=" + id + " ]";
    }
    
}
