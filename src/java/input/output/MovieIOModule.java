/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input.output;

import com.google.inject.AbstractModule;

/**
 *
 * @author ODell
 */
public class MovieIOModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(IO.class).to(PasswordIO.class);
    }
    
}
