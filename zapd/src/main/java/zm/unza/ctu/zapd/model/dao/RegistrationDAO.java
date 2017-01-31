/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model.dao;

import java.util.HashMap;
import java.util.Map;
import zm.unza.ctu.zapd.beans.entity.PersonDisability;

/**
 *
 * @author Katuta
 */
public class RegistrationDAO extends ZapdDAO<PersonDisability> {
    
    public RegistrationDAO() {
        super(PersonDisability.class);
    }
    public PersonDisability finByDmis(String dmis){
        Map<String,Object> parameters = new HashMap<String,Object>(); 
        parameters.put("dmis",dmis);
        return null;
    }
    
}
