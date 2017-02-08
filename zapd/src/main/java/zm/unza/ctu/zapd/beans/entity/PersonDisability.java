/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name = "person_disabilities")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonDisability.findAll", query = "SELECT p FROM PersonDisability p"),
    @NamedQuery(name = "PersonDisability.findByContactnumber", query = "SELECT p FROM PersonDisability p WHERE p.contactnumber = :contactnumber"),
    @NamedQuery(name = "PersonDisability.findByDateofbirth", query = "SELECT p FROM PersonDisability p WHERE p.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "PersonDisability.findByDateofregistration", query = "SELECT p FROM PersonDisability p WHERE p.dateofregistration = :dateofregistration"),
    @NamedQuery(name = "PersonDisability.findByDmisnumber", query = "SELECT p FROM PersonDisability p WHERE p.dmisnumber = :dmisnumber"),
    @NamedQuery(name = "PersonDisability.findByLevelofeducation", query = "SELECT p FROM PersonDisability p WHERE p.levelofeducation = :levelofeducation"),
    @NamedQuery(name = "PersonDisability.findByMaritalstatus", query = "SELECT p FROM PersonDisability p WHERE p.maritalstatus = :maritalstatus"),
    @NamedQuery(name = "PersonDisability.findByNextofkincontactphone", query = "SELECT p FROM PersonDisability p WHERE p.nextofkincontactphone = :nextofkincontactphone"),
    @NamedQuery(name = "PersonDisability.findByNextofkinnrc", query = "SELECT p FROM PersonDisability p WHERE p.nextofkinnrc = :nextofkinnrc"),
    @NamedQuery(name = "PersonDisability.findByNextofkinothernames", query = "SELECT p FROM PersonDisability p WHERE p.nextofkinothernames = :nextofkinothernames"),
    @NamedQuery(name = "PersonDisability.findByNextofkinsurname", query = "SELECT p FROM PersonDisability p WHERE p.nextofkinsurname = :nextofkinsurname"),
    @NamedQuery(name = "PersonDisability.findByNrcnumber", query = "SELECT p FROM PersonDisability p WHERE p.nrcnumber = :nrcnumber"),
    @NamedQuery(name = "PersonDisability.findByOccupation", query = "SELECT p FROM PersonDisability p WHERE p.occupation = :occupation"),
    @NamedQuery(name = "PersonDisability.findByOthernames", query = "SELECT p FROM PersonDisability p WHERE p.othernames = :othernames"),
    @NamedQuery(name = "PersonDisability.findBySex", query = "SELECT p FROM PersonDisability p WHERE p.sex = :sex"),
    @NamedQuery(name = "PersonDisability.findBySurname", query = "SELECT p FROM PersonDisability p WHERE p.surname = :surname")})
public class PersonDisability implements Serializable {

    private static final long serialVersionUID = 1L;
    @Size(max = 255)
    @Column(name = "CONTACTNUMBER")
    private String contactnumber;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofbirth;
    @Column(name = "DATEOFREGISTRATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofregistration;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DMISNUMBER")
    private String dmisnumber;
    @Size(max = 255)
    @Column(name = "LEVELOFEDUCATION")
    private String levelofeducation;
    @Size(max = 255)
    @Column(name = "MARITALSTATUS")
    private String maritalstatus;
    @Size(max = 255)
    @Column(name = "NEXTOFKINCONTACTPHONE")
    private String nextofkincontactphone;
    @Size(max = 255)
    @Column(name = "NEXTOFKINNRC")
    private String nextofkinnrc;
    @Size(max = 255)
    @Column(name = "NEXTOFKINOTHERNAMES")
    private String nextofkinothernames;
    @Size(max = 255)
    @Column(name = "NEXTOFKINSURNAME")
    private String nextofkinsurname;
    @Size(max = 255)
    @Column(name = "NRCNUMBER")
    private String nrcnumber;
    @Size(max = 255)
    @Column(name = "OCCUPATION")
    private String occupation;
    @Size(max = 255)
    @Column(name = "OTHERNAMES")
    private String othernames;
    @Size(max = 255)
    @Column(name = "SEX")
    private String sex;
    @Size(max = 255)
    @Column(name = "SURNAME")
    private String surname;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dmisnumber")
    private Collection<Pwdupdate> pwdupdateCollection;
    @OneToMany(mappedBy = "dmisnumber")
    private Collection<AssessmentDetail> assessmentDetailCollection;
    @OneToMany(mappedBy = "dmisnumber")
    private Collection<ClientReferral> clientReferralCollection;
    @JoinColumn(name = "VILLAGE", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Village village;

    public PersonDisability() {
    }

    public PersonDisability(String dmisnumber) {
        this.dmisnumber = dmisnumber;
    }

    public String getContactnumber() {
        return contactnumber;
    }

    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber;
    }

    public Date getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(Date dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public Date getDateofregistration() {
        return dateofregistration;
    }

    public void setDateofregistration(Date dateofregistration) {
        this.dateofregistration = dateofregistration;
    }

    public String getDmisnumber() {
        return dmisnumber;
    }

    public void setDmisnumber(String dmisnumber) {
        this.dmisnumber = dmisnumber;
    }

    public String getLevelofeducation() {
        return levelofeducation;
    }

    public void setLevelofeducation(String levelofeducation) {
        this.levelofeducation = levelofeducation;
    }

    public String getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(String maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public String getNextofkincontactphone() {
        return nextofkincontactphone;
    }

    public void setNextofkincontactphone(String nextofkincontactphone) {
        this.nextofkincontactphone = nextofkincontactphone;
    }

    public String getNextofkinnrc() {
        return nextofkinnrc;
    }

    public void setNextofkinnrc(String nextofkinnrc) {
        this.nextofkinnrc = nextofkinnrc;
    }

    public String getNextofkinothernames() {
        return nextofkinothernames;
    }

    public void setNextofkinothernames(String nextofkinothernames) {
        this.nextofkinothernames = nextofkinothernames;
    }

    public String getNextofkinsurname() {
        return nextofkinsurname;
    }

    public void setNextofkinsurname(String nextofkinsurname) {
        this.nextofkinsurname = nextofkinsurname;
    }

    public String getNrcnumber() {
        return nrcnumber;
    }

    public void setNrcnumber(String nrcnumber) {
        this.nrcnumber = nrcnumber;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getOthernames() {
        return othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @XmlTransient
    public Collection<Pwdupdate> getPwdupdateCollection() {
        return pwdupdateCollection;
    }

    public void setPwdupdateCollection(Collection<Pwdupdate> pwdupdateCollection) {
        this.pwdupdateCollection = pwdupdateCollection;
    }

    @XmlTransient
    public Collection<AssessmentDetail> getAssessmentDetailCollection() {
        return assessmentDetailCollection;
    }

    public void setAssessmentDetailCollection(Collection<AssessmentDetail> assessmentDetailCollection) {
        this.assessmentDetailCollection = assessmentDetailCollection;
    }

    @XmlTransient
    public Collection<ClientReferral> getClientReferralCollection() {
        return clientReferralCollection;
    }

    public void setClientReferralCollection(Collection<ClientReferral> clientReferralCollection) {
        this.clientReferralCollection = clientReferralCollection;
    }

    public Village getVillage() {
        if(village == null){
            village = new Village();
        }
        return village;
    }

    public void setVillage(Village village) {
        this.village = village;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dmisnumber != null ? dmisnumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonDisability)) {
            return false;
        }
        PersonDisability other = (PersonDisability) object;
        if ((this.dmisnumber == null && other.dmisnumber != null) || (this.dmisnumber != null && !this.dmisnumber.equals(other.dmisnumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.unza.ctu.zapd.beans.entity.PersonDisability[ dmisnumber=" + dmisnumber + " ]";
    }
    
}
