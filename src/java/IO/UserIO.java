/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import UserManagement.User;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ODell
 */
public class UserIO implements Serializable {

    public static List<User> readFile() {
        List<User> users = new ArrayList<>();
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("/ABSOLUTE_PATH/users.bin"));
            users = (ArrayList<User>) is.readObject();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return users;
    }
    
    public static void WriteToFile(List<User> users) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("/ABSOLUTE_PATH/users.bin"));
            os.writeObject(users);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
