/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans.session;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import zm.unza.ctu.zapd.beans.entity.Pwdupdate;

/**
 *
 * @author Katuta
 */
@Stateless
public class PwdupdateFacade extends AbstractFacade<Pwdupdate> {

    @PersistenceContext(unitName = "zapdPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PwdupdateFacade() {
        super(Pwdupdate.class);
    }
    
}
