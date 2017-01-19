/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name="ASSESSMENT_DETAILS")
public class AssessmentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String dmisNumber;
    private Date dateOfAssessment;
    private Date registrationDate;
    private Date dateOfDisability;
    @ManyToOne
    private Degree degree;
    @ManyToOne
    private Disability disability;
    private String causeOfDisability;
    private String status;
    @ManyToOne
    private Assessor assessor;

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
     * @return the dateOfAssessment
     */
    public Date getDateOfAssessment() {
        return dateOfAssessment;
    }

    /**
     * @param dateOfAssessment the dateOfAssessment to set
     */
    public void setDateOfAssessment(Date dateOfAssessment) {
        this.dateOfAssessment = dateOfAssessment;
    }

    /**
     * @return the dateOfDisability
     */
    public Date getDateOfDisability() {
        return dateOfDisability;
    }

    /**
     * @param dateOfDisability the dateOfDisability to set
     */
    public void setDateOfDisability(Date dateOfDisability) {
        this.dateOfDisability = dateOfDisability;
    }

    /**
     * @return the degreeId
     */
    public Degree getDegree() {
        return degree;
    }

    /**
     * @param degreeId the degreeId to set
     */
    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    /**
     * @return the disability
     */
    public Disability getDisability() {
        if (disability == null){
            disability = new Disability();
        }
        return disability;
    }

    /**
     * @param disability the disability to set
     */
    public void setDisability(Disability disability) {
        this.disability = disability;
    }

    /**
     * @return the causeOfDisability
     */
    public String getCauseOfDisability() {
        return causeOfDisability;
    }

    /**
     * @param causeOfDisability the causeOfDisability to set
     */
    public void setCauseOfDisability(String causeOfDisability) {
        this.causeOfDisability = causeOfDisability;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the registrationDate
     */
    public Date getRegistrationDate() {
        return registrationDate;
    }

    /**
     * @param registrationDate the registrationDate to set
     */
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }
    
    
    
    
    
    
}
