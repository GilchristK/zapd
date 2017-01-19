/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name="PROVINCES")
class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    @OneToMany
     @OrderColumn(name="id")
    private List<District> districts;

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
     * @return the districts
     */
    public List<District> getDistricts() {
        if(districts == null){
            districts = new ArrayList<District>();
        }
        return districts;
    }

    /**
     * @param districts the districts to set
     */
    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }
    
}
