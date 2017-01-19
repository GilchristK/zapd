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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
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
    @ManyToOne
    private Ward ward;
    @OneToMany
    @OrderColumn(name="id")
    private List<CWAC> cwacs;

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
    public List<CWAC> getCwacs() {
        if(cwacs == null){
                cwacs = new ArrayList<CWAC>();
        }
        return cwacs;
    }

    /**
     * @param cwacs the cwacs to set
     */
    public void setCwacs(List<CWAC> cwacs) {
        this.cwacs = cwacs;
    }
    
    
}
