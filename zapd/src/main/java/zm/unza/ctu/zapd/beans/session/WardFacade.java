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
import zm.unza.ctu.zapd.beans.entity.Constituency;
import zm.unza.ctu.zapd.beans.entity.Ward;

/**
 *
 * @author Katuta
 */
@Stateless
public class WardFacade extends AbstractFacade<Ward> {

    @PersistenceContext(unitName = "zapdPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public WardFacade() {
        super(Ward.class);
    }

    public List<Ward> findByConstituency(Constituency constituency) {

        return getEntityManager().createNamedQuery("Ward.findByConstituency").setParameter("constituency", constituency)
                .getResultList();
    }

}
