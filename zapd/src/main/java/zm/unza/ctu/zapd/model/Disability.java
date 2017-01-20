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
@Table(name="DISABILITIES")
public class Disability {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String natureOfDisability;
    private String name;

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
     * @return the natureOfDisability
     */
    public String getNatureOfDisability() {
        return natureOfDisability;
    }

    /**
     * @param natureOfDisability the natureOfDisability to set
     */
    public void setNatureOfDisability(String natureOfDisability) {
        this.natureOfDisability = natureOfDisability;
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
    
    
}
