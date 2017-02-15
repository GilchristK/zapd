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
import zm.unza.ctu.zapd.beans.entity.Village;
import zm.unza.ctu.zapd.beans.entity.Ward;

/**
 *
 * @author Katuta
 */
@Stateless
public class VillageFacade extends AbstractFacade<Village> {

    @PersistenceContext(unitName = "zapdPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VillageFacade() {
        super(Village.class);
    }
    public List<Village> findByWard(Ward ward) {

        return getEntityManager().createNamedQuery("Village.findByWard").setParameter("ward", ward)
                .getResultList();
    }
    
}
