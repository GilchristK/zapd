/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Katuta
 */
@ManagedBean
public class MenuView {
    private String registration;
    private String registrationSearch;
    private String clientUpdate;
    private String clientUpdateSearch;
    private String assessmentSearch;
    public void save() {
        addMessage("Success", "Data saved");
    }
     
    public void update() {
        addMessage("Success", "Data updated");
    }
     
    public void delete() {
        addMessage("Success", "Data deleted");
    }
     
    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    public String getRegistration(){
        StringBuilder target=new StringBuilder();
        target.append("/faces/admin/");
        target.append("registration.xhtml");
        registration =target.toString();
        return registration;
    }
    public String getRegistrationSearch(){
        StringBuilder target=new StringBuilder();
        target.append("/faces/admin/");
        target.append("registrationSearch.xhtml");
        registrationSearch =target.toString();
        return registrationSearch;
    }
    public String getClientUpdate(){
        StringBuilder target=new StringBuilder();
        target.append("/faces/staff/");
        target.append("clientUpdate.xhtml");
        
        clientUpdate =target.toString();
        return clientUpdate;
    }
    public String getClientUpdateSearch(){
        StringBuilder target=new StringBuilder();
        target.append("/faces/staff/");
        target.append("clientUpdateSearch.xhtml");
        
        clientUpdateSearch =target.toString();
        return clientUpdateSearch;
    }

    /**
     * @param registration the registration to set
     */
    public void setRegistration(String registration) {
        this.registration = registration;
    }

    /**
     * @param registrationSearch the registrationSearch to set
     */
    public void setRegistrationSearch(String registrationSearch) {
        this.registrationSearch = registrationSearch;
    }

    /**
     * @param clientUpdate the clientUpdate to set
     */
    public void setClientUpdate(String clientUpdate) {
        this.clientUpdate = clientUpdate;
    }

    /**
     * @param clientUpdateSearch the clientUpdateSearch to set
     */
    public void setClientUpdateSearch(String clientUpdateSearch) {
        this.clientUpdateSearch = clientUpdateSearch;
    }

    /**
     * @return the assessmentSearch
     */
    public String getAssessmentSearch() {
        StringBuilder target=new StringBuilder();
        target.append("/faces/assessor/");
        target.append("index.xhtml");
        assessmentSearch =target.toString();
        return assessmentSearch;
    }

    /**
     * @param assessmentSearch the assessmentSearch to set
     */
    public void setAssessmentSearch(String assessmentSearch) {
        this.assessmentSearch = assessmentSearch;
    }
}
