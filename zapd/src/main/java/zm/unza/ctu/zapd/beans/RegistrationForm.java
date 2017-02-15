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
import zm.unza.ctu.zapd.beans.entity.Assessor;
import zm.unza.ctu.zapd.beans.entity.Constituency;
import zm.unza.ctu.zapd.beans.entity.District;
import zm.unza.ctu.zapd.beans.entity.PersonDisability;
import zm.unza.ctu.zapd.beans.entity.Province;
import zm.unza.ctu.zapd.beans.entity.Skill;
import zm.unza.ctu.zapd.beans.entity.Village;
import zm.unza.ctu.zapd.beans.entity.Ward;
import zm.unza.ctu.zapd.beans.session.AssessorFacade;
import zm.unza.ctu.zapd.beans.session.ConstituencyFacade;
import zm.unza.ctu.zapd.beans.session.DistrictFacade;
import zm.unza.ctu.zapd.beans.session.PersonDisabilityFacade;
import zm.unza.ctu.zapd.beans.session.ProvinceFacade;
import zm.unza.ctu.zapd.beans.session.SkillFacade;
import zm.unza.ctu.zapd.beans.session.VillageFacade;
import zm.unza.ctu.zapd.beans.session.WardFacade;
@Named
@SessionScoped
public class RegistrationForm implements Serializable {
    private PersonDisability person;
    private Village village;
    private List<Province> provinces;
    private List<District> districts;
    private List<Constituency> constituencies;
    private List<Ward> wards;
    private List<Village> villages;
    private List<Skill> skills;
    private List<Assessor> assessors;
    private Assessor assessor;
    private String provinceId;
    private String districtId;
    private String constituencyId;
    private String wardId;
    private String vilageId;
    private String dmis;
    private String skillId;
    private String selectedAssessorId;
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
    @EJB
    private ConstituencyFacade constituencyFacade;
    @EJB
    private WardFacade wardFacade;
    @EJB
    private VillageFacade villageFacade;
    @EJB
    private SkillFacade skillFacade;
    @EJB
    private AssessorFacade assessorFacade;
    
    
    
    public void showDistricts(){
        System.out.println("Invoked by ajax call!!");
        System.out.println("Ajax provinceId:"+getProvinceId());
        if(getProvinceId() != null){
            setDistricts(getDistrictFacade().findByProvinceId(getProvinceFacade().find(Integer.parseInt(getProvinceId()))));
        }else{
             setDistricts(getDistrictFacade().findAll());
        }
    }
    public void showConstituencies(){
        System.out.println("Invoked by ajax call!!");
        System.out.println("Ajax DistrictId:"+getDistrictId());
        if(getDistrictId() != null){
            setConstituencies(getConstituencyFacade().findByDistrict(getDistrictFacade().find(Integer.parseInt(getDistrictId()))));
        }else{
             setConstituencies(getConstituencyFacade().findAll());
        }
    }
    public void showWards(){
        System.out.println("Invoked by ajax call!!");
        System.out.println("Ajax ConstituencyId:"+getConstituencyId());
        if(getConstituencyId() != null){
           setWards(getWardFacade().findByConstituency(getConstituencyFacade().find(Integer.parseInt(getConstituencyId()))));
        }else{
             setWards(getWardFacade().findAll());
        }
    }
    public void showVillages(){
        System.out.println("Invoked by ajax call!!");
        System.out.println("Ajax WardId:"+getWardId());
        if(getWardId() != null){
           setVillages(getVillageFacade().findByWard(getWardFacade().find(Integer.parseInt(getWardId()))));
        }else{
             setWards(getWardFacade().findAll());
        }
    }
    public void showAssessorDetails(){
        System.out.println("Invoked by ajax call!!");
        System.out.println("Ajax assessordetails:"+getSelectedAssessorId());
        if(getSelectedAssessorId() != null){
           setAssessor(getAssessorFacade().find(Integer.parseInt(getSelectedAssessorId())));
        }else{
             setAssessor(new Assessor());
        }
    }
    
    @PostConstruct
    public void init(){
        setProvinces(getProvinceFacade().findAll());
        setDistricts(getDistrictFacade().findAll());
        setConstituencies(getConstituencyFacade().findAll());
        setWards(getWardFacade().findAll());
        setVillages(getVillageFacade().findAll());
        setSkills(getSkillFacade().findAll());
        setAssessors(getAssessorFacade().findAll());
        System.out.println("Provinces count:"+getProvinces().size());
        System.out.println("District count:"+getDistricts().size());
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
       System.out.println("Saving ... reg form");
        getLog().info("name: "+getPerson().getSurname());
        getLog().info("dmis: "+getPerson().getDmisnumber());
        getLog().info("testing dmis:"+getDmis());
        //create and save the village
        //villageService
        //add the village to the person object
        //person.setVillage(villageFacade.find(Integer.parseInt(vilageId)));
        getPerson().setVillage(getVillageFacade().findAll().get(0));
        getRegistrationService().create(getPerson());
        
        
        getLog().info("Finished saving the info...");
        return "/admin/registrationSearch?faces-redirect=true";
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

    /**
     * @return the constituencies
     */
    public List<Constituency> getConstituencies() {
        return constituencies;
    }

    /**
     * @param constituencies the constituencies to set
     */
    public void setConstituencies(List<Constituency> constituencies) {
        this.constituencies = constituencies;
    }

    /**
     * @return the wards
     */
    public List<Ward> getWards() {
        return wards;
    }

    /**
     * @param wards the wards to set
     */
    public void setWards(List<Ward> wards) {
        this.wards = wards;
    }

    /**
     * @return the villages
     */
    public List<Village> getVillages() {
        return villages;
    }

    /**
     * @param villages the villages to set
     */
    public void setVillages(List<Village> villages) {
        this.villages = villages;
    }

    /**
     * @return the constituencyId
     */
    public String getConstituencyId() {
        return constituencyId;
    }

    /**
     * @param constituencyId the constituencyId to set
     */
    public void setConstituencyId(String constituencyId) {
        this.constituencyId = constituencyId;
    }

    /**
     * @return the wardId
     */
    public String getWardId() {
        return wardId;
    }

    /**
     * @param wardId the wardId to set
     */
    public void setWardId(String wardId) {
        this.wardId = wardId;
    }

    /**
     * @return the vilageId
     */
    public String getVilageId() {
        return vilageId;
    }

    /**
     * @param vilageId the vilageId to set
     */
    public void setVilageId(String vilageId) {
        this.vilageId = vilageId;
    }

    /**
     * @return the constituencyFacade
     */
    public ConstituencyFacade getConstituencyFacade() {
        return constituencyFacade;
    }

    /**
     * @param constituencyFacade the constituencyFacade to set
     */
    public void setConstituencyFacade(ConstituencyFacade constituencyFacade) {
        this.constituencyFacade = constituencyFacade;
    }

    /**
     * @return the wardFacade
     */
    public WardFacade getWardFacade() {
        return wardFacade;
    }

    /**
     * @param wardFacade the wardFacade to set
     */
    public void setWardFacade(WardFacade wardFacade) {
        this.wardFacade = wardFacade;
    }

    /**
     * @return the villageFacade
     */
    public VillageFacade getVillageFacade() {
        return villageFacade;
    }

    /**
     * @param villageFacade the villageFacade to set
     */
    public void setVillageFacade(VillageFacade villageFacade) {
        this.villageFacade = villageFacade;
    }

    /**
     * @return the skills
     */
    public List<Skill> getSkills() {
        return skills;
    }

    /**
     * @param skills the skills to set
     */
    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    /**
     * @return the skillFacade
     */
    public SkillFacade getSkillFacade() {
        return skillFacade;
    }

    /**
     * @param skillFacade the skillFacade to set
     */
    public void setSkillFacade(SkillFacade skillFacade) {
        this.skillFacade = skillFacade;
    }

    /**
     * @return the skillId
     */
    public String getSkillId() {
        return skillId;
    }

    /**
     * @param skillId the skillId to set
     */
    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }

    /**
     * @return the assessors
     */
    public List<Assessor> getAssessors() {
        return assessors;
    }

    /**
     * @param assessors the assessors to set
     */
    public void setAssessors(List<Assessor> assessors) {
        this.assessors = assessors;
    }

    /**
     * @return the assessorFacade
     */
    public AssessorFacade getAssessorFacade() {
        return assessorFacade;
    }

    /**
     * @param assessorFacade the assessorFacade to set
     */
    public void setAssessorFacade(AssessorFacade assessorFacade) {
        this.assessorFacade = assessorFacade;
    }

    /**
     * @return the assessor
     */
    public Assessor getAssessor() {
        return assessor;
    }

    /**
     * @param assessor the assessor to set
     */
    public void setAssessor(Assessor assessor) {
        this.assessor = assessor;
    }

    /**
     * @param selectedAssessorId the selectedAssessorId to set
     */
    public void setSelectedAssessorId(String selectedAssessorId) {
        this.selectedAssessorId = selectedAssessorId;
    }

    /**
     * @return the selectedAssessorId
     */
    public String getSelectedAssessorId() {
        return selectedAssessorId;
    }
    
    
    
}
