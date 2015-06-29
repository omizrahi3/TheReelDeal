/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import UserManagement.User;
import gatech.cs2340.team7.ControlHub;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author ODell
 */
public class UserIO implements Serializable {

    public static HashMap<String, User> readFile() {
        HashMap<String, User> users = new HashMap<>();
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream(ControlHub.pathToDataPersistence + "users.bin"));
            users = (HashMap<String, User>) is.readObject();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public static void WriteToFile(Map<String, User> users) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream(ControlHub.pathToDataPersistence + "users.bin"));
            os.writeObject(users);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
