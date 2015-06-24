/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import UserManagement.User;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author ODell
 */
public class UserWriter {
    public void WriteToFile(User user) {
        try (FileOutputStream fs = new FileOutputStream("/resources/datafiles/userlist.txt")) {
            ObjectOutputStream os = new ObjectOutputStream(fs);
            System.out.println(user.getUsername());
            os.writeObject(user);
            os.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
