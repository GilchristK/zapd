/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.services;

import zm.unza.ctu.zapd.model.PersonWithDisability;

/**
 *
 * @author Katuta
 */
public interface ReportService {
    public void printDisabilityCard(PersonWithDisability pwd, String reportFormat);
}
