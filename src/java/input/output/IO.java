/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input.output;

import java.util.HashMap;

/**
 *
 * @author ODell

 */
public interface IO {
    
    
    HashMap readFile();
    
    void writeToFile(HashMap data);
    
    
}
