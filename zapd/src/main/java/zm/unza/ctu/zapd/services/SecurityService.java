/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zm.unza.ctu.zapd.services;

/**
 *
 * @author Katuta
 */
public interface SecurityService {
    /**
     * Authenticate
     * @param username
     * @param password 
     */
    public void login(String username, String password);
    /**
     * logout
     */
    public void logout();
    
}
