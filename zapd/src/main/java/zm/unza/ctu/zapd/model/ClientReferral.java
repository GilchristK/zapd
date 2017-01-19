/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name="CLIENT_REFERRALS")
class ClientReferral {
    @Id
    private String referenceNumber;
    private String dmisNumber;
    private ServiceProvider serviceProvider;
    private Date startOfService;
    private Date endOfService;
    private String locationOfService;
}
