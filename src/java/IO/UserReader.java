/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import UserManagement.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.context.FacesContext;


/**
 *
 * @author ODell
 */
public class UserReader implements Serializable {
    InputStream stream;
    
    public ArrayList<User> readFile() {
        ArrayList<User> list = new ArrayList<>();
        try {
            stream = FacesContext.getCurrentInstance().getExternalContext()
.getResourceAsStream("/resources/datafiles/userlist.txt");
            ObjectInputStream os = new ObjectInputStream(stream);
            list = (ArrayList<User>)os.readObject();
            System.out.println(list.toString());
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return list;
    }
    
   
}
