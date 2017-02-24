/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import zm.unza.ctu.zapd.beans.entity.AssessmentDetail;
import zm.unza.ctu.zapd.beans.entity.Assessor;
import zm.unza.ctu.zapd.beans.entity.PersonDisability;
import zm.unza.ctu.zapd.beans.entity.Province;
import zm.unza.ctu.zapd.beans.entity.Skill;
import zm.unza.ctu.zapd.beans.entity.Village;
import zm.unza.ctu.zapd.beans.session.AssessmentDetailFacade;
import zm.unza.ctu.zapd.beans.session.PersonDisabilityFacade;
import zm.unza.ctu.zapd.beans.session.ProvinceFacade;
import zm.unza.ctu.zapd.beans.session.VillageFacade;
@Named
@SessionScoped
public class RegistrationUpdateForm implements Serializable {
    private PersonDisability person;
    private Village village;
    private AssessmentDetail assessmentDetail;
    private Assessor assessor;
    private List<Province> provinces;
    private List<Skill> skills;
    private String dmis;
    private String updateType;
    private Logger log = Logger.getLogger(RegistrationUpdateForm.class.getName());
    
    @EJB
    PersonDisabilityFacade registrationService;
    @EJB
    VillageFacade villageService;
    @EJB
    private AssessmentDetailFacade assessmentDetails;
    @EJB
    ProvinceFacade provinceFacade;
    
   @PostConstruct
   public void init(){
        setProvinces(provinceFacade.findAll());
        
        log.info("provinces count:"+provinces.size());
   }
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
        if(village == null){
            village = new Village();
        }
        return village;
    }

    /**
     * @param village the village to set
     */
    public void setVillage(Village village) {
        this.village = village;
    }

    /**
     * @return the assessmentDetail
     */
    public AssessmentDetail getAssessmentDetail() {
        if(assessmentDetail == null){
            assessmentDetail = new AssessmentDetail();
        }
        return assessmentDetail;
    }

    /**
     * @param assessmentDetail the assessmentDetail to set
     */
    public void setAssessmentDetail(AssessmentDetail assessmentDetail) {
        this.assessmentDetail = assessmentDetail;
    }

    /**
     * @return the assessor
     */
    public Assessor getAssessor() {
        if( assessor == null){
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
     * @return the skills
     */
    public List<Skill> getSkills() {
        if( skills == null){
            skills = new ArrayList<Skill>();
        }
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    /**
     * @return the updateType
     */
    public String getUpdateType() {
        return updateType;
    }

    /**
     * @param updateType the updateType to set
     */
    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    /**
     * @return the provinces
     */
    public List<Province> getProvinces() {
        return provinces;
    }

    /**
     * @param provinces the provinces to set
     */
    public void setProvinces(List<Province> provinces) {
        this.provinces = provinces;
    }
    public String clientUpdate(PersonDisability p){
        System.out.println("client update running...");
        System.out.println(p);
        this.setPerson(p);
        System.out.println(person.getSurname());
        return "/staff/clientUpdate.xhtml";
    }
    
    
}
