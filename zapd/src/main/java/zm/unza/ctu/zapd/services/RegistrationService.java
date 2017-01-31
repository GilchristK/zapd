/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.services;

import zm.unza.ctu.zapd.beans.entity.PersonDisability;

/**
 *
 * @author Katuta
 */
public interface RegistrationService {
    /**
     * Register a new person with disabilities
     * @param pwd 
     */
    public void createNewRegistration(PersonDisability pwd);
    /**
     * Update the details of a person with disabilities
     * @param pwd
     * @return 
     */
    public PersonDisability updateClient(PersonDisability pwd);
    /**
     * Finds the person with disability associated with the dmis number
     * @param dmis
     * @return 
     */
    public PersonDisability findPwdById(String dmis);
     /**
     * Finds the person with disability associated with the surname
     * @param surname
     * @return 
     */
    public PersonDisability findPwdBySurname(String surname);
     /**
     * Finds the person with disability associated with the othernames
     * @param othernames
     * @return 
     */
    public PersonDisability findPwdByOthernames(String othernames);
     /**
     * Finds the person with disability associated with the province
     * @param province
     * @return 
     */
    public PersonDisability findPwdByProvince(String province);
     /**
     * Finds the person with disability associated with the district
     * @param district
     * @return 
     */
    public PersonDisability findPwdByDistrict(String district);
     /**
     * Finds the person with disability associated with the constituency
     * @param constituency
     * @return 
     */
    public PersonDisability findPwdByConstituency(String constituency);
     /**
     * Finds the person with disability associated with the ward
     * @param ward
     * @return 
     */
    public PersonDisability findPwdByWard(String ward);
     /**
     * Finds the person with disability associated with the village
     * @param village
     * @return 
     */
    public PersonDisability findPwdByVillage(String village);
     /**
     * Finds the person with disability associated with the status
     * @param status
     * @return 
     */
    public PersonDisability findPwdByStatus(String status);
}
