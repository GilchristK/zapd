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
import zm.unza.ctu.zapd.facade.RegistrationFacade;
import zm.unza.ctu.zapd.model.AssessmentDetail;
import zm.unza.ctu.zapd.model.Assessor;
import zm.unza.ctu.zapd.model.PersonWithDisability;
import zm.unza.ctu.zapd.model.ServiceProvider;
import zm.unza.ctu.zapd.model.Skill;
import zm.unza.ctu.zapd.services.RegistrationService;

/**
 *
 * @author Katuta
 */
@ManagedBean
@ViewScoped
public class RegistrationForm implements Serializable {
    private PersonWithDisability person;
    private Assessor assessor;
    private AssessmentDetail assessmentDetails;
    private ServiceProvider serviceProvider;
    private List<Skill> skills;
    
    private RegistrationService registrationService;
    
    @PostConstruct
    public  void init(){
        skills = new ArrayList<Skill>();//refactor this to get from service
        skills.add(new Skill(1,"plumbing","good plumber"));
        skills.add(new Skill(2,"carpenter","good carpenter"));
        skills.add(new Skill(3,"Brick layer","good brick layer"));
        
        //replace with DI code
        registrationService = new RegistrationFacade();
    }
    
    

   
    /**
     * @return the person
     */
    public PersonWithDisability getPerson() {
        if ( person == null) {
            person = new PersonWithDisability();
        }
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(PersonWithDisability person) {
        this.person = person;
    }

    /**
     * @return the assessor
     */
    public Assessor getAssessor() {
        if (assessor == null) {
            assessor = new Assessor();
        }
        return assessor;
    }

    /**
     * @param assessor the assessor to set
     */
    public void setAssessor(Assessor assessor) {
        this.assessor = assessor;
    }

    /**
     * @return the assessmentDetails
     */
    public AssessmentDetail getAssessmentDetails() {
        return assessmentDetails;
    }

    /**
     * @param assessmentDetails the assessmentDetails to set
     */
    public void setAssessmentDetails(AssessmentDetail assessmentDetails) {
        this.assessmentDetails = assessmentDetails;
    }

    /**
     * @return the serviceProvider
     */
    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    /**
     * @param serviceProvider the serviceProvider to set
     */
    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }
    
    public void saveRegistration(){
        registrationService.createNewRegistration(person);
    }
    public void cancelRegistration(){
        person = new PersonWithDisability();
        assessmentDetails = new AssessmentDetail();
        assessor = new Assessor();
    }
    
    
}
