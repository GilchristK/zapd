/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.jboss.logging.Logger;

/**
 *
 * @author Katuta
 */
@ManagedBean
@ViewScoped
public class TestBean {

  private String input;
  private String output;
  private Logger log = Logger.getLogger(TestBean.class.toString());

  public void submit() {
    log.info("Logging in test bean...");
    // handle form submission
    output = "You submitted: " + input;
  }

  public String getInput() {
    return input;
  }

  public void setInput(String input) {
    this.input = input;
  }

  public String getOutput() {
    return output;
  }

  public void setOutput(String output) {
    this.output = output;
  }

}
