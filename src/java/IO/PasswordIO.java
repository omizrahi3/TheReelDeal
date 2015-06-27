/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ODell
 */
public class PasswordIO implements Serializable {
    
    
    public static HashMap<String, String> readFile() {
        HashMap<String, String> passwords = new HashMap<>();
        try {
            ObjectInputStream is = new ObjectInputStream(
                    new FileInputStream("/ABSOLUTE_PATH/passwords.bin"));
            passwords = (HashMap<String, String>) is.readObject();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return passwords;
    }
    
    
    public static void WriteToFile(Map<String, String> passwords) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("/ABSOLUTE_PATH/passwords.bin"));
            os.writeObject(passwords);
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
