/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserManagement;

/**
 *
 * @author Anthony
 */
public class Administrator extends User {
    
    public Administrator(String name, String username, String password) {
        super(name, username, password, true);
    }
}
