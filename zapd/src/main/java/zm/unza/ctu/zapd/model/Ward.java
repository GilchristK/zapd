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
@Table(name="WARDS")
class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private Village[] villages;
    private Constituency constituency;

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
     * @return the villages
     */
    public Village[] getVillages() {
        return villages;
    }

    /**
     * @param villages the villages to set
     */
    public void setVillages(Village[] villages) {
        this.villages = villages;
    }

    /**
     * @return the constituency
     */
    public Constituency getConstituency() {
        return constituency;
    }

    /**
     * @param constituency the constituency to set
     */
    public void setConstituency(Constituency constituency) {
        this.constituency = constituency;
    }
    
    
}
