/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.services;

import zm.unza.ctu.zapd.model.PersonWithDisability;

/**
 *
 * @author Katuta
 */
public interface RegistrationService {
    /**
     * Register a new person with disabilities
     * @param pwd 
     */
    public void createNewRegistration(PersonWithDisability pwd);
    /**
     * Update the details of a person with disabilities
     * @param pwd
     * @return 
     */
    public PersonWithDisability updateClient(PersonWithDisability pwd);
    /**
     * Finds the person with disability associated with the dmis number
     * @param dmis
     * @return 
     */
    public PersonWithDisability findPwdById(String dmis);
     /**
     * Finds the person with disability associated with the surname
     * @param surname
     * @return 
     */
    public PersonWithDisability findPwdBySurname(String surname);
     /**
     * Finds the person with disability associated with the othernames
     * @param othernames
     * @return 
     */
    public PersonWithDisability findPwdByOthernames(String othernames);
     /**
     * Finds the person with disability associated with the province
     * @param province
     * @return 
     */
    public PersonWithDisability findPwdByProvince(String province);
     /**
     * Finds the person with disability associated with the district
     * @param district
     * @return 
     */
    public PersonWithDisability findPwdByDistrict(String district);
     /**
     * Finds the person with disability associated with the constituency
     * @param constituency
     * @return 
     */
    public PersonWithDisability findPwdByConstituency(String constituency);
     /**
     * Finds the person with disability associated with the ward
     * @param ward
     * @return 
     */
    public PersonWithDisability findPwdByWard(String ward);
     /**
     * Finds the person with disability associated with the village
     * @param village
     * @return 
     */
    public PersonWithDisability findPwdByVillage(String village);
     /**
     * Finds the person with disability associated with the status
     * @param status
     * @return 
     */
    public PersonWithDisability findPwdByStatus(String status);
}
