/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.facade;

import java.io.Serializable;
import org.jboss.logging.Logger;
import zm.unza.ctu.zapd.beans.entity.PersonDisability;
import zm.unza.ctu.zapd.model.dao.RegistrationDAO;
import zm.unza.ctu.zapd.services.RegistrationService;

/**
 *
 * @author Katuta
 */
public class RegistrationFacade implements Serializable,RegistrationService {
    private final RegistrationDAO regDAO = new RegistrationDAO();
    private Logger log = Logger.getLogger(this.getClass().getName());
    @Override
    public void createNewRegistration(PersonDisability pwd){
        log.info("Saving the entity:"+ pwd.toString());
        //regDAO.beginTransaction();
        regDAO.save(pwd);
        //regDAO.commitAndCloseTransaction();
    }

    @Override
    public PersonDisability updateClient(PersonDisability pwd) {
       
       regDAO.beginTransaction();
       /*PersonDisability updatedPwd = regDAO.find(pwd.get);
       updatedPwd.setLevelOfEducation(pwd.getLevelOfEducation());
       //updatedPwd.setConstituency(pwd.getConstituency());
       updatedPwd.setContactNumber(pwd.getContactNumber());
       updatedPwd.setDateOfRegistration(pwd.getDateOfRegistration());
       //updatedPwd.setDistrict(pwd.getDistrict());
       updatedPwd.setDmisNumber(pwd.getDmisNumber());
       updatedPwd.setMaritalStatus(pwd.getMaritalStatus());
       updatedPwd.setNrcNumber(pwd.getNrcNumber());
       updatedPwd.setOccupation(pwd.getOccupation());
       updatedPwd.setOtherNames(pwd.getOtherNames());*/
       //updatedPwd.setProvince(pwd.getProvince());
       //set other fields
       regDAO.update(pwd);
       regDAO.commitAndCloseTransaction();
       return null;
    }

    @Override
    public PersonDisability findPwdById(String dmis) {
        return regDAO.finByDmis(dmis);
    }

    @Override
    public PersonDisability findPwdBySurname(String surname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDisability findPwdByOthernames(String othernames) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDisability findPwdByProvince(String province) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDisability findPwdByDistrict(String district) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDisability findPwdByConstituency(String constituency) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDisability findPwdByWard(String ward) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDisability findPwdByVillage(String village) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDisability findPwdByStatus(String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
