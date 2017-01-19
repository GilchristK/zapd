/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name="PERSON_DISABILITIES")
@NamedQueries(
        @NamedQuery(name="PersonWithDisability.findByDmis",query="SELECT p FROM PersonWithDisability WHERE p.dmisNumber = :dmis")
)
public class PersonWithDisability {
    @Id
    private Integer id;
    @Column(unique=true)
    private String dmisNumber;
    private String surname;
    private String otherNames;
    private String nrcNumber;
    private String sex;
    private Date dateOfBirth;
    private String contactNumber;
    private String maritalStatus;
    private String levelOfEducation;
    private Date dateOfRegistration;
    private String occupation;
    private Province province;
    private District district;
    private Constituency constituency;
    private Ward ward;
    private Village village;
    private Skill[] skills;
    public final static String  FIND_BY_DMIS = "PersonWithDisability.findByDmis";
    
    public PersonWithDisability(){
    }

    
    /**
     * @return the dmisNumber
     */
    public String getDmisNumber() {
        return dmisNumber;
    }

    /**
     * @param dmisNumber the dmisNumber to set
     */
    public void setDmisNumber(String dmisNumber) {
        this.dmisNumber = dmisNumber;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the otherNames
     */
    public String getOtherNames() {
        return otherNames;
    }

    /**
     * @param otherNames the otherNames to set
     */
    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    /**
     * @return the nrcNumber
     */
    public String getNrcNumber() {
        return nrcNumber;
    }

    /**
     * @param nrcNumber the nrcNumber to set
     */
    public void setNrcNumber(String nrcNumber) {
        this.nrcNumber = nrcNumber;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the dateOfBirth
     */
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the contactNumber
     */
    public String getContactNumber() {
        return contactNumber;
    }

    /**
     * @param contactNumber the contactNumber to set
     */
    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus the maritalStatus to set
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the levelOfEducation
     */
    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    /**
     * @param levelOfEducation the levelOfEducation to set
     */
    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    /**
     * @return the dateOfRegistration
     */
    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    /**
     * @param dateOfRegistration the dateOfRegistration to set
     */
    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }

    /**
     * @return the occupation
     */
    public String getOccupation() {
        return occupation;
    }

    /**
     * @param occupation the occupation to set
     */
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    /**
     * @return the province
     */
    public Province getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(Province province) {
        this.province = province;
    }

    /**
     * @return the district
     */
    public District getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(District district) {
        this.district = district;
    }

    /**
     * @return the constituency
     */
    public Constituency getConstituency() {
        return constituency;
    }

    /**
     * @param constituency the constituency to set
     */
    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }

    /**
     * @return the ward
     */
    public Ward getWard() {
        return ward;
    }

    /**
     * @param ward the ward to set
     */
    public void setWard(Ward ward) {
        this.ward = ward;
    }

    /**
     * @return the village
     */
    public Village getVillage() {
        return village;
    }

    /**
     * @param village the village to set
     */
    public void setVillage(Village village) {
        this.village = village;
    }

    /**
     * @return the skills
     */
    public Skill[] getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(Skill[] skills) {
        this.skills = skills;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }
    
}
