/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans.session;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import zm.unza.ctu.zapd.beans.entity.PersonDisability;

/**
 *
 * @author Katuta
 */
@Stateless
public class PersonDisabilityFacade extends AbstractFacade<PersonDisability> {

    @PersistenceContext(unitName = "zapdPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PersonDisabilityFacade() {
        super(PersonDisability.class);
    }
    public List<PersonDisability> findBydmis(String dmis) {

		return getEntityManager().createNamedQuery("PersonDisability.findByDmisnumber").setParameter("dmisnumber", dmis)
				.getResultList();
	}

	public List<PersonDisability> findBySurname(String surname) {

		return getEntityManager().createNamedQuery("PersonDisability.findBySurname").setParameter("surname", surname)
				.getResultList();
	}

	public List<PersonDisability> findByOthernames(String othernames) {

		return getEntityManager().createNamedQuery("PersonDisability.findByOthernames").setParameter("othernames", othernames)
				.getResultList();
	}
    
}
