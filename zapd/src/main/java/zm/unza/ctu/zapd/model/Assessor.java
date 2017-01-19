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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Katuta
 */
@Entity
@Table(name="ASSESSORS")
public class Assessor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String sex;
    private String destination;
    private String nrc;
    private String hpc;
    @ManyToOne
    private District district;
    @ManyToOne
    private Station station;
    @ManyToOne
    private ClientReferral referal;

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
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the nrc
     */
    public String getNrc() {
        return nrc;
    }

    /**
     * @param nrc the nrc to set
     */
    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    /**
     * @return the hpc
     */
    public String getHpc() {
        return hpc;
    }

    /**
     * @param hpc the hpc to set
     */
    public void setHpc(String hpc) {
        this.hpc = hpc;
    }

    /**
     * @return the district
     */
    public District getDistrict() {
        return district;
    }

    /**
     * @param district the district to set
     */
    public void setDistrict(District district) {
        if (district == null) {
            district = new District();
        }
        this.district = district;
    }

    /**
     * @return the station
     */
    public Station getStation() {
         if (station == null) {
            station = new Station();
        }
        return station;
    }

    /**
     * @param station the station to set
     */
    public void setStation(Station station) {
        this.station = station;
    }

    /**
     * @return the referal
     */
    public ClientReferral getReferal() {
        return referal;
    }

    /**
     * @param referal the referal to set
     */
    public void setReferal(ClientReferral referal) {
        this.referal = referal;
    }
    
    
}
