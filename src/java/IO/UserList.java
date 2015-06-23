/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import UserManagement.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author ODell
 */
public class UserList implements Serializable  {
    
    private static final long serialVersionUID = 1L;
    private static final Logger myLogger = Logger.getLogger("IO.UserList");
    private static ArrayList<User>  users;
    
    public UserList() {
        users = new ArrayList<>();
    }
    
    public void save() {
         try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("/resources/datafiles/passwords.txt"));
            out.writeObject(UserList.users);
        } catch (FileNotFoundException e) {
            myLogger.log(Level.SEVERE, "Save file not found: ");
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "General IO Error on saving: ");
        }
     }
    
    public List<User> getUserList() {
        return users;
    }
    
    public void addUserToList(User user) {
         users.add(user);
     }
    
    public ArrayList<User> getFromFile() {
         try {
            ObjectInputStream in = new ObjectInputStream(FacesContext.getCurrentInstance().getExternalContext()
.getResourceAsStream("/resources/datafiles/userlist.txt"));
            users = (ArrayList<User>) in.readObject();
            
        } catch (FileNotFoundException e) {
            myLogger.log(Level.SEVERE, "Load file not found: ");
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "General IO Error on loading: ");
        } catch (ClassNotFoundException e) {
            myLogger.log(Level.SEVERE, "Company class not found on loading: ");
        }
        return users;
     }
    
    public void uploadFromFile() {
         try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("/resources/datafiles/passwords.txt"));
            users = (ArrayList<User>) in.readObject();
            
        } catch (FileNotFoundException e) {
            myLogger.log(Level.SEVERE, "Load file not found: ");
        } catch (IOException e) {
            myLogger.log(Level.SEVERE, "General IO Error on loading: ");
        } catch (ClassNotFoundException e) {
            myLogger.log(Level.SEVERE, "Company class not found on loading: ");
        }
     }
}
