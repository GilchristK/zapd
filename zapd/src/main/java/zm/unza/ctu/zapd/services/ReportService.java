/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.services;

import zm.unza.ctu.zapd.beans.entity.PersonDisability;

/**
 *
 * @author Katuta
 */
public interface ReportService {
    public void printDisabilityCard(PersonDisability pwd, String reportFormat);
}
