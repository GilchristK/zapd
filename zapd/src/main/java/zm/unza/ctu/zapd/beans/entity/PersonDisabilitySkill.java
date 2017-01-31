/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name = "person_disabilities_skills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonDisabilitySkill.findAll", query = "SELECT p FROM PersonDisabilitySkill p"),
    @NamedQuery(name = "PersonDisabilitySkill.findById", query = "SELECT p FROM PersonDisabilitySkill p WHERE p.id = :id"),
    @NamedQuery(name = "PersonDisabilitySkill.findByComment", query = "SELECT p FROM PersonDisabilitySkill p WHERE p.comment = :comment"),
    @NamedQuery(name = "PersonDisabilitySkill.findBySkill", query = "SELECT p FROM PersonDisabilitySkill p WHERE p.skill = :skill"),
    @NamedQuery(name = "PersonDisabilitySkill.findByDmisnumber", query = "SELECT p FROM PersonDisabilitySkill p WHERE p.dmisnumber = :dmisnumber")})
public class PersonDisabilitySkill implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "COMMENT")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SKILL")
    private int skill;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "DMISNUMBER")
    private String dmisnumber;

    public PersonDisabilitySkill() {
    }

    public PersonDisabilitySkill(Integer id) {
        this.id = id;
    }

    public PersonDisabilitySkill(Integer id, String comment, int skill, String dmisnumber) {
        this.id = id;
        this.comment = comment;
        this.skill = skill;
        this.dmisnumber = dmisnumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public String getDmisnumber() {
        return dmisnumber;
    }

    public void setDmisnumber(String dmisnumber) {
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
        if (!(object instanceof PersonDisabilitySkill)) {
            return false;
        }
        PersonDisabilitySkill other = (PersonDisabilitySkill) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "zm.unza.ctu.zapd.beans.entity.PersonDisabilitySkill[ id=" + id + " ]";
    }
    
}
