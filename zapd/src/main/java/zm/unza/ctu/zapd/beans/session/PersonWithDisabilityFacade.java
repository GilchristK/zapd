/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import zm.unza.ctu.zapd.model.PersonWithDisability;

/**
 *
 * @author Katuta
 */
@Stateless
public class PersonWithDisabilityFacade extends AbstractFacade<PersonWithDisability> {

    @PersistenceContext(unitName = "zapdPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonWithDisabilityFacade() {
        super(PersonWithDisability.class);
    }
    
}
