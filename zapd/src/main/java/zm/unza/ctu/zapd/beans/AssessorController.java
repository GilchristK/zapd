/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import zm.unza.ctu.zapd.beans.entity.AssessmentDetail;
import zm.unza.ctu.zapd.beans.session.AssessmentDetailFacade;
import zm.unza.ctu.zapd.beans.session.AssessorFacade;

/**
 *
 * @author Katuta
 */
@Named
public class AssessorController {
    @EJB
    private AssessmentDetailFacade assessmentsFacade;
    
    public List<AssessmentDetail> pendingAssessments(){
        return assessmentsFacade.findByStatus("1");
    }

}
