/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Customer;
import view.MakeAppointment;

/**
 *
 * @author Alysson Chinque
 */
public class makeAppointmentController implements ActionListener {
    private final MakeAppointment view;

    public makeAppointmentController(MakeAppointment view) {
        this.view = view;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("back")) {
            this.view.setVisible(false);
            Customer customer = new Customer();
           // customer.Customer();
        }
    }
    
    
}
