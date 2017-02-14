/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans;



import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import zm.unza.ctu.zapd.beans.entity.District;
import zm.unza.ctu.zapd.beans.entity.PersonDisability;
import zm.unza.ctu.zapd.beans.entity.Province;
import zm.unza.ctu.zapd.beans.entity.Village;
import zm.unza.ctu.zapd.beans.session.DistrictFacade;
import zm.unza.ctu.zapd.beans.session.PersonDisabilityFacade;
import zm.unza.ctu.zapd.beans.session.ProvinceFacade;
import zm.unza.ctu.zapd.beans.session.VillageFacade;
@Named
@SessionScoped
public class RegistrationForm implements Serializable {
    private PersonDisability person;
    private Village village;
    private List<Province> provinces;
    private List<District> districts;
    private String provinceId;
    private String districtId;
    private String dmis;
    private Logger log = Logger.getLogger(RegistrationForm.class.getName());
    //private Assessor assessor;
    //private AssessmentDetail assessmentDetails;
    //private ServiceProvider serviceProvider;
    //private List<Skill> skills;
    
    //private RegistrationDAO registrationService;
    
    @EJB
    private PersonDisabilityFacade registrationService;
    @EJB
    private VillageFacade villageService;
    @EJB
    private ProvinceFacade provinceFacade;
    @EJB
    private DistrictFacade districtFacade;
    
    
    public void showDistricts(String provinceId){
        System.out.println("Invoked by ajax call!!");
        System.out.println("Ajax provinceId:"+provinceId);
        if(provinceId != null){
            setDistricts(districtFacade.findByProvinceId(Integer.parseInt(provinceId)));
        }else{
             setDistricts(districtFacade.findAll());
        }
    }
    
    @PostConstruct
    public void init(){
        setProvinces(getProvinceFacade().findAll());
        System.out.println("Provinces count:"+getProvinces().size());
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
        getLog().info("Saving the registration....");
        getLog().info("name: "+getPerson().getSurname());
        getLog().info("dmis: "+getPerson().getDmisnumber());
        getLog().info("testing dmis:"+getDmis());
        //create and save the village
        //villageService
        //add the village to the person object
        //registrationService.create(person);
        getLog().info("Finished saving the info...");
        return "/admin/registration?faces-redirect=true";
    }
    public void cancelRegistration(){
        getLog().info("Cancel the registration....");
        setPerson(new PersonDisability());
    }
    public void searchRegistration(){
        getLog().info("Searching the registration...");
        //check if dmis is
        if( getPerson().getDmisnumber() != null){
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

    /**
     * @return the provinceId
     */
    public String getProvinceId() {
        return provinceId;
    }

    /**
     * @param provinceId the provinceId to set
     */
    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    /**
     * @return the log
     */
    public Logger getLog() {
        return log;
    }

    /**
     * @param log the log to set
     */
    public void setLog(Logger log) {
        this.log = log;
    }

    /**
     * @return the registrationService
     */
    public PersonDisabilityFacade getRegistrationService() {
        return registrationService;
    }

    /**
     * @param registrationService the registrationService to set
     */
    public void setRegistrationService(PersonDisabilityFacade registrationService) {
        this.registrationService = registrationService;
    }

    /**
     * @return the villageService
     */
    public VillageFacade getVillageService() {
        return villageService;
    }

    /**
     * @param villageService the villageService to set
     */
    public void setVillageService(VillageFacade villageService) {
        this.villageService = villageService;
    }

    /**
     * @return the provinceFacade
     */
    public ProvinceFacade getProvinceFacade() {
        return provinceFacade;
    }

    /**
     * @param provinceFacade the provinceFacade to set
     */
    public void setProvinceFacade(ProvinceFacade provinceFacade) {
        this.provinceFacade = provinceFacade;
    }

    /**
     * @return the districts
     */
    public List<District> getDistricts() {
        if(provinceId != null){
            setDistricts(getDistrictFacade().findByProvinceId(Integer.parseInt(getProvinceId())));
            System.out.println("District count:"+getDistricts().size());
        }
        return districts;
    }

    /**
     * @param districts the districts to set
     */
    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    /**
     * @return the districtId
     */
    public String getDistrictId() {
        return districtId;
    }

    /**
     * @param districtId the districtId to set
     */
    public void setDistrictId(String districtId) {
        this.districtId = districtId;
    }

    /**
     * @return the districtFacade
     */
    public DistrictFacade getDistrictFacade() {
        return districtFacade;
    }

    /**
     * @param districtFacade the districtFacade to set
     */
    public void setDistrictFacade(DistrictFacade districtFacade) {
        this.districtFacade = districtFacade;
    }
    
    
    
}
