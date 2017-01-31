/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name="CLIENT_REFERRALS")
public class ClientReferral {
    @Id
    private String referenceNumber;
    private String dmisNumber;
    //@ManyToOne
    //private ServiceProvider serviceProvider;
    private Date startOfService;
    private Date endOfService;
    private String locationOfService;

    /**
     * @return the referenceNumber
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * @param referenceNumber the referenceNumber to set
     */
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
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
     * @return the serviceProvider
     */
    /*public ServiceProvider getServiceProvider() {
        if(serviceProvider == null){
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

    /**
     * @return the startOfService
     */
    public Date getStartOfService() {
        if( startOfService == null){
            startOfService = new Date();
        }
        return startOfService;
    }

    /**
     * @param startOfService the startOfService to set
     */
    public void setStartOfService(Date startOfService) {
        this.startOfService = startOfService;
    }

    /**
     * @return the endOfService
     */
    public Date getEndOfService() {
        if( endOfService == null){
            endOfService = new Date();
        }
        return endOfService;
    }

    /**
     * @param endOfService the endOfService to set
     */
    public void setEndOfService(Date endOfService) {
        this.endOfService = endOfService;
    }

    /**
     * @return the locationOfService
     */
    public String getLocationOfService() {
        return locationOfService;
    }

    /**
     * @param locationOfService the locationOfService to set
     */
    public void setLocationOfService(String locationOfService) {
        this.locationOfService = locationOfService;
    }
    
}
