/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Customer;
import view.Login;
import view.MyBookings;

/**
 *
 * @author Alysson Chinque
 */
public class BookingController implements ActionListener{
    private MyBookings view;

    public BookingController(MyBookings aThis) {
        this.view = aThis;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()){
            case "back":
                this.view.dispose();
                Customer customer = new Customer();
                customer.Customer(this.view.getValidUser());
                break;
            case "logout":
                this.view.dispose();
                Login login = new Login();
                login.Login();
        }
        
    }
    
}
