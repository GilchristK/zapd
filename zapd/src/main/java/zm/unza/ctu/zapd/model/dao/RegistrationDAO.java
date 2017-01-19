/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model.dao;

import java.util.HashMap;
import java.util.Map;
import zm.unza.ctu.zapd.model.PersonWithDisability;

/**
 *
 * @author Katuta
 */
public class RegistrationDAO extends ZapdDAO<PersonWithDisability> {
    
    public RegistrationDAO() {
        super(PersonWithDisability.class);
    }
    public PersonWithDisability finByDmis(String dmis){
        Map<String,Object> parameters = new HashMap<String,Object>(); 
        parameters.put("dmis",dmis);
        return super.findOneResult(PersonWithDisability.FIND_BY_DMIS, parameters);
    }
    
}
