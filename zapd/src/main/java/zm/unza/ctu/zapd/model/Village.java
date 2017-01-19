/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name = "VILLAGES")
class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Ward ward;
    private CWAC[] cwacs;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the ward
     */
    public Ward getWard() {
        return ward;
    }

    /**
     * @param ward the ward to set
     */
    public void setWard(Ward ward) {
        this.ward = ward;
    }

    /**
     * @return the cwacs
     */
    public CWAC[] getCwacs() {
        return cwacs;
    }

    /**
     * @param cwacs the cwacs to set
     */
    public void setCwacs(CWAC[] cwacs) {
        this.cwacs = cwacs;
    }
    
    
}
