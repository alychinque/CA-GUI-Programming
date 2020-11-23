/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Login;

/**
 *
 * @author Alysson Chinque
 */
public class LoginController implements ActionListener {
    private final Login view;

    public LoginController(Login view) {
        this.view = view;
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand().equals("combo")){
            if(this.view.getCombo().equals("CUSTOMER")){
                this.view.changeVisibilityCustomer(true);
                this.view.changeVisibilityBarber(false);
            }else{
                this.view.changeVisibilityCustomer(false);
                this.view.changeVisibilityBarber(true);
            }
        }
    }
    
}
