/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.facade;

import java.io.Serializable;
import zm.unza.ctu.zapd.model.PersonWithDisability;
import zm.unza.ctu.zapd.model.dao.RegistrationDAO;
import zm.unza.ctu.zapd.services.RegistrationService;

/**
 *
 * @author Katuta
 */
public class RegistrationFacade implements Serializable,RegistrationService {
    private final RegistrationDAO regDAO = new RegistrationDAO();
    
    @Override
    public void createNewRegistration(PersonWithDisability pwd){
        regDAO.beginTransaction();
        regDAO.save(pwd);
        regDAO.commitAndCloseTransaction();
    }

    @Override
    public PersonWithDisability updateClient(PersonWithDisability pwd) {
       
       regDAO.beginTransaction();
       PersonWithDisability updatedPwd = regDAO.find(pwd.getId());
       updatedPwd.setLevelOfEducation(pwd.getLevelOfEducation());
       updatedPwd.setConstituency(pwd.getConstituency());
       updatedPwd.setContactNumber(pwd.getContactNumber());
       updatedPwd.setDateOfRegistration(pwd.getDateOfRegistration());
       updatedPwd.setDistrict(pwd.getDistrict());
       updatedPwd.setDmisNumber(pwd.getDmisNumber());
       updatedPwd.setMaritalStatus(pwd.getMaritalStatus());
       updatedPwd.setNrcNumber(pwd.getNrcNumber());
       updatedPwd.setOccupation(pwd.getOccupation());
       updatedPwd.setOtherNames(pwd.getOtherNames());
       updatedPwd.setProvince(pwd.getProvince());
       //set other fields
       regDAO.update(pwd);
       regDAO.commitAndCloseTransaction();
       return updatedPwd;
    }

    @Override
    public PersonWithDisability findPwdById(String dmis) {
        return regDAO.finByDmis(dmis);
    }

    @Override
    public PersonWithDisability findPwdBySurname(String surname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonWithDisability findPwdByOthernames(String othernames) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonWithDisability findPwdByProvince(String province) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonWithDisability findPwdByDistrict(String district) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonWithDisability findPwdByConstituency(String constituency) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonWithDisability findPwdByWard(String ward) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonWithDisability findPwdByVillage(String village) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonWithDisability findPwdByStatus(String status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
