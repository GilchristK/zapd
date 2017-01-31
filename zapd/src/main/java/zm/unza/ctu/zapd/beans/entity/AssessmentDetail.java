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
@Table(name = "assessment_details")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AssessmentDetail.findAll", query = "SELECT a FROM AssessmentDetail a"),
    @NamedQuery(name = "AssessmentDetail.findById", query = "SELECT a FROM AssessmentDetail a WHERE a.id = :id"),
    @NamedQuery(name = "AssessmentDetail.findByCauseofdisability", query = "SELECT a FROM AssessmentDetail a WHERE a.causeofdisability = :causeofdisability"),
    @NamedQuery(name = "AssessmentDetail.findByDateofassessment", query = "SELECT a FROM AssessmentDetail a WHERE a.dateofassessment = :dateofassessment"),
    @NamedQuery(name = "AssessmentDetail.findByDateofdisability", query = "SELECT a FROM AssessmentDetail a WHERE a.dateofdisability = :dateofdisability"),
    @NamedQuery(name = "AssessmentDetail.findByRegistrationdate", query = "SELECT a FROM AssessmentDetail a WHERE a.registrationdate = :registrationdate"),
    @NamedQuery(name = "AssessmentDetail.findByStatus", query = "SELECT a FROM AssessmentDetail a WHERE a.status = :status")})
public class AssessmentDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "CAUSEOFDISABILITY")
    private String causeofdisability;
    @Column(name = "DATEOFASSESSMENT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofassessment;
    @Column(name = "DATEOFDISABILITY")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofdisability;
    @Column(name = "REGISTRATIONDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationdate;
    @Size(max = 255)
    @Column(name = "STATUS")
    private String status;
    @JoinColumn(name = "DMISNUMBER", referencedColumnName = "DMISNUMBER")
    @ManyToOne
    private PersonDisability dmisnumber;
    @JoinColumn(name = "ASSESSOR", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Assessor assessor;

    public AssessmentDetail() {
    }

    public AssessmentDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCauseofdisability() {
        return causeofdisability;
    }

    public void setCauseofdisability(String causeofdisability) {
        this.causeofdisability = causeofdisability;
    }

    public Date getDateofassessment() {
        return dateofassessment;
    }

    public void setDateofassessment(Date dateofassessment) {
        this.dateofassessment = dateofassessment;
    }

    public Date getDateofdisability() {
        return dateofdisability;
    }

    public void setDateofdisability(Date dateofdisability) {
        this.dateofdisability = dateofdisability;
    }

    public Date getRegistrationdate() {
        return registrationdate;
    }

    public void setRegistrationdate(Date registrationdate) {
        this.registrationdate = registrationdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public PersonDisability getDmisnumber() {
        return dmisnumber;
    }

    public void setDmisnumber(PersonDisability dmisnumber) {
        this.dmisnumber = dmisnumber;
    }

    public Assessor getAssessor() {
        return assessor;
    }

    public void setAssessor(Assessor assessor) {
        this.assessor = assessor;
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
        if (!(object instanceof AssessmentDetail)) {
            return false;
        }
        AssessmentDetail other = (AssessmentDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.unza.ctu.zapd.beans.entity.AssessmentDetail[ id=" + id + " ]";
    }
    
}
