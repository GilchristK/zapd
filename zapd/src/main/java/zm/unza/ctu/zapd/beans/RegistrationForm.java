/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans;



import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import zm.unza.ctu.zapd.beans.entity.PersonDisability;
import zm.unza.ctu.zapd.beans.entity.Village;
import zm.unza.ctu.zapd.beans.session.PersonDisabilityFacade;
import zm.unza.ctu.zapd.beans.session.VillageFacade;
@ManagedBean
@ViewScoped
public class RegistrationForm implements Serializable {
    private PersonDisability person;
    private Village village;
    private String dmis;
    private Logger log = Logger.getLogger(RegistrationForm.class.getName());
    //private Assessor assessor;
    //private AssessmentDetail assessmentDetails;
    //private ServiceProvider serviceProvider;
    //private List<Skill> skills;
    
    //private RegistrationDAO registrationService;
    
    @EJB
    PersonDisabilityFacade registrationService;
    @EJB
    VillageFacade villageService;
    
    

   
    /**
     * @return the person
     */
    public PersonDisability getPerson() {
        if ( person == null) {
            person = new PersonDisability();
        }
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(PersonDisability person) {
        this.person = person;
    }

    /**
     * @return the assessor
     */
    /*public Assessor getAssessor() {
        if (assessor == null) {
            assessor = new Assessor();
        }
        return assessor;
    }*/

    /**
     * @param assessor the assessor to set
     */
    /*public void setAssessor(Assessor assessor) {
        this.assessor = assessor;
    }*/

    /**
     * @return the assessmentDetails
     */
    /*public AssessmentDetail getAssessmentDetails() {
        if(assessmentDetails == null){
            assessmentDetails = new AssessmentDetail();
        }
        return assessmentDetails;
    }*/

    /**
     * @param assessmentDetails the assessmentDetails to set
     */
    /*public void setAssessmentDetails(AssessmentDetail assessmentDetails) {
        this.assessmentDetails = assessmentDetails;
    }*/

    /**
     * @return the serviceProvider
     */
    /*public ServiceProvider getServiceProvider() {
        if( serviceProvider == null){
            serviceProvider = new ServiceProvider();
        }
        return serviceProvider;
    }*/

    /**
     * @param serviceProvider the serviceProvider to set
     */
    /*public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }*/
    
    public String saveRegistration(){
        log.info("Saving the registration....");
        log.info("name: "+person.getSurname());
        log.info("dmis: "+person.getDmisnumber());
        log.info("testing dmis:"+dmis);
        //create and save the village
        //villageService
        //add the village to the person object
        //registrationService.create(person);
        log.info("Finished saving the info...");
        return "/admin/registration?faces-redirect=true";
    }
    public void cancelRegistration(){
        log.info("Cancel the registration....");
        person=new PersonDisability();
    }
    public void searchRegistration(){
        log.info("Searching the registration...");
        //check if dmis is
        if( person.getDmisnumber() != null){
        }
    }

    /**
     * @return the dmis
     */
    public String getDmis() {
        return dmis;
    }

    /**
     * @param dmis the dmis to set
     */
    public void setDmis(String dmis) {
        this.dmis = dmis;
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
    
    
    
}
