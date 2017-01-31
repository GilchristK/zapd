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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name = "pwdupdates")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pwdupdate.findAll", query = "SELECT p FROM Pwdupdate p"),
    @NamedQuery(name = "Pwdupdate.findById", query = "SELECT p FROM Pwdupdate p WHERE p.id = :id"),
    @NamedQuery(name = "Pwdupdate.findByContactnumber", query = "SELECT p FROM Pwdupdate p WHERE p.contactnumber = :contactnumber"),
    @NamedQuery(name = "Pwdupdate.findByDateofbirth", query = "SELECT p FROM Pwdupdate p WHERE p.dateofbirth = :dateofbirth"),
    @NamedQuery(name = "Pwdupdate.findByDateofregistration", query = "SELECT p FROM Pwdupdate p WHERE p.dateofregistration = :dateofregistration"),
    @NamedQuery(name = "Pwdupdate.findByLevelofeducation", query = "SELECT p FROM Pwdupdate p WHERE p.levelofeducation = :levelofeducation"),
    @NamedQuery(name = "Pwdupdate.findByMaritalstatus", query = "SELECT p FROM Pwdupdate p WHERE p.maritalstatus = :maritalstatus"),
    @NamedQuery(name = "Pwdupdate.findByNextofkincontactphone", query = "SELECT p FROM Pwdupdate p WHERE p.nextofkincontactphone = :nextofkincontactphone"),
    @NamedQuery(name = "Pwdupdate.findByNextofkinnrc", query = "SELECT p FROM Pwdupdate p WHERE p.nextofkinnrc = :nextofkinnrc"),
    @NamedQuery(name = "Pwdupdate.findByNextofkinothernames", query = "SELECT p FROM Pwdupdate p WHERE p.nextofkinothernames = :nextofkinothernames"),
    @NamedQuery(name = "Pwdupdate.findByNextofkinsurname", query = "SELECT p FROM Pwdupdate p WHERE p.nextofkinsurname = :nextofkinsurname"),
    @NamedQuery(name = "Pwdupdate.findByNrcnumber", query = "SELECT p FROM Pwdupdate p WHERE p.nrcnumber = :nrcnumber"),
    @NamedQuery(name = "Pwdupdate.findByOccupation", query = "SELECT p FROM Pwdupdate p WHERE p.occupation = :occupation"),
    @NamedQuery(name = "Pwdupdate.findByOthernames", query = "SELECT p FROM Pwdupdate p WHERE p.othernames = :othernames"),
    @NamedQuery(name = "Pwdupdate.findBySex", query = "SELECT p FROM Pwdupdate p WHERE p.sex = :sex"),
    @NamedQuery(name = "Pwdupdate.findBySurname", query = "SELECT p FROM Pwdupdate p WHERE p.surname = :surname")})
public class Pwdupdate implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 255)
    @Column(name = "CONTACTNUMBER")
    private String contactnumber;
    @Column(name = "DATEOFBIRTH")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofbirth;
    @Column(name = "DATEOFREGISTRATION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateofregistration;
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
    @JoinColumn(name = "DMISNUMBER", referencedColumnName = "DMISNUMBER")
    @ManyToOne(optional = false)
    private PersonDisability dmisnumber;

    public Pwdupdate() {
    }

    public Pwdupdate(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public PersonDisability getDmisnumber() {
        return dmisnumber;
    }

    public void setDmisnumber(PersonDisability dmisnumber) {
        this.dmisnumber = dmisnumber;
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
        if (!(object instanceof Pwdupdate)) {
            return false;
        }
        Pwdupdate other = (Pwdupdate) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.unza.ctu.zapd.beans.entity.Pwdupdate[ id=" + id + " ]";
    }
    
}
