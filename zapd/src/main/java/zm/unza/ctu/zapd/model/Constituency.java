/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name="CONSTITUENCIES")
public class Constituency {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    //@OneToMany(mappedBy = "constituency", cascade = CascadeType.PERSIST)
    //@OrderColumn(name="id")
    //private List<Ward> wards;
    //@ManyToOne(cascade = CascadeType.PERSIST)
    //private District district;

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
     * @return the wards
     */
    /*public List<Ward> getWards() {
        if( wards == null){
            wards = new ArrayList<Ward>();
        }
        return wards;
    }*/

    /**
     * @param wards the wards to set
     */
    /*public void setWards(List<Ward> wards) {
        this.wards = wards;
    }*/

    /**
     * @return the district
     */
    /*public District getDistrict() {
        if( district == null){
            district = new District();
        }
        return district;
    }*/

    /**
     * @param district the district to set
     */
    /*public void setDistrict(District district) {
        this.district = district;
    }*/
    
    
}
