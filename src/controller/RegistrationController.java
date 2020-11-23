/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Home;
import view.Registration;

/**
 *
 * @author Alysson Chinque
 */
public class RegistrationController implements ActionListener{
    private final Registration view;
    
    public RegistrationController(Registration view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("back")){
            Home home = new Home();
            this.view.setVisible(false);
            home.setVisible(true);
        }else if(e.getActionCommand().equals("customer")){
            this.view.setBarberSection(false);
        }else if(e.getActionCommand().equals("barber")){
            this.view.setBarberSection(true);
        }
    }
    
    
}
