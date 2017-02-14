/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import zm.unza.ctu.zapd.beans.entity.PersonDisability;
import zm.unza.ctu.zapd.beans.session.PersonDisabilityFacade;

/**
 *
 * @author Katuta
 */
@Named
@SessionScoped
public class RegistrationSearchForm implements Serializable {

    private String searchValue;
    private String searchField;
    private Collection<PersonDisability> pwdList;

    @EJB
    private PersonDisabilityFacade pwdFacade;

    @PostConstruct
    public void init() {
        setPwdList(pwdFacade.findAll());
    }

    /**
     * @return the searchField
     */
    public String getSearchField() {
        return searchField;
    }

    /**
     * @param searchField the searchField to set
     */
    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    /**
     * @return the searchValue
     */
    public String getSearchValue() {
        return searchValue;
    }

    /**
     * @param searchValue the searchValue to set
     */
    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public void search() {
        if (searchField.equals("dmis_number")) {
            setPwdList(pwdFacade.findBydmis(searchValue));
        } else if (searchField.equals("surname")) {
            setPwdList(pwdFacade.findBySurname(searchValue));
        } else if (searchField.equals("othernames")) {
            setPwdList(pwdFacade.findByOthernames(searchValue));
        } else if (searchField.equals("province")) {
            //setPwdList(pwdFacade.findByProvince(searchValue));
        } else if (searchField.equals("district")) {
            //setPwdList(pwdFacade.findByDistrict(searchValue));
        } else if (searchField.equals("constituency")) {
            //setPwdList(pwdFacade.findByConstituency(searchValue));
        } else if (searchField.equals("ward")) {
            //setPwdList(pwdFacade.findByWard(searchValue));
        } else if (searchField.equals("village")) {
            //setPwdList(pwdFacade.findByVillage(searchValue));
        }
        //System.out.println("Number of elements:"+pwdList.size());
        //System.out.println("Number(f) of elements:"+pwdFacade.findAll().size());
    }

    /**
     * @return the pwdList
     */
    public Collection<PersonDisability> getPwdList() {
        return pwdList;
    }

    /**
     * @param pwdList the pwdList to set
     */
    public void setPwdList(Collection<PersonDisability> pwdList) {
        this.pwdList = pwdList;
    }

}
