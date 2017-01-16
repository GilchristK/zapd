/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import zm.unza.ctu.zapd.model.Skill;

/**
 *
 * @author Katuta
 */
@ManagedBean
@ViewScoped
public class RegistrationForm implements Serializable {
    private String dmisNumber;
    private String nrcNumber;
    private String surname;
    private String otherNames;
    private String sex;
    private String maritalStatus;
    private String dateOfBirth;
    private String educationalLevel;
    private String occupation;
    private String contactPhone;
    private String province;
    private String district;
    private String ward;
    private String village;
    private List<Skill> skills;
    private String constituency;
    
    @PostConstruct
    public  void init(){
        skills = new ArrayList<>();//refactor this to get from service
        skills.add(new Skill("1","plumbing","good plumber"));
        skills.add(new Skill("2","carpenter","good carpenter"));
        skills.add(new Skill("3","Brick layer","good brick layer"));
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
     * @return the dateOfBirth
     */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * @param dateOfBirth the dateOfBirth to set
     */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the educationalLevel
     */
    public String getEducationalLevel() {
        return educationalLevel;
    }

    /**
     * @param educationalLevel the educationalLevel to set
     */
    public void setEducationalLevel(String educationalLevel) {
        this.educationalLevel = educationalLevel;
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
     * @return the contactPhone
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * @param contactPhone the contactPhone to set
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province the province to set
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * @return the ward
     */
    public String getWard() {
        return ward;
    }

    /**
     * @param ward the ward to set
     */
    public void setWard(String ward) {
        this.ward = ward;
    }

    /**
     * @return the village
     */
    public String getVillage() {
        return village;
    }

    /**
     * @param village the village to set
     */
    public void setVillage(String village) {
        this.village = village;
    }
    public List<Skill> getSkills(){
        return this.skills;
    }
    public String getConstituency(){
        return this.constituency;
    }
    
}
