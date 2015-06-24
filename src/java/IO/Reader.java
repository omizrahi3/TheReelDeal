/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import javax.faces.context.FacesContext;

/**
 *
 * @author ODell
 */

public class Reader {
    InputStream stream;
    BufferedReader br;
    private Scanner scan;
    
    public void OpenFile() {
        try {
            stream = FacesContext.getCurrentInstance().getExternalContext()
.getResourceAsStream("/resources/datafiles/passwords.txt");
            br = new BufferedReader(new InputStreamReader(stream));
            scan = new Scanner(br);
            //scan = new Scanner(new File("/resources/readwritefiles/passwords.txt"));
            System.out.println("FILE FOUND");
        }
        catch (Exception e) {
            System.out.println("File Not Found STUPID");
        }
    }
    
    public HashMap readFile() {
        HashMap<String, String> map = new HashMap<>();
        while (scan.hasNext()) {
            String user = scan.next();
            String pass = scan.next();
            
            map.put(user, pass);
        }
        return map;
    }
    
}
