/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Appointment;
import view.ChooseTime;
import view.Customer;

/**
 *
 * @author Alysson Chinque
 */
public class ChooseTimeController implements ActionListener{
    private final ChooseTime view;

    public ChooseTimeController(ChooseTime view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("time")){
            int idUser = this.view.getValidUser().getId();
            int idBarber = this.view.getBarberAvailability().get(0).getId();
            String day = this.view.getDay();
            String time = this.view.getBoxTime();
            
            Appointment appointment = new Appointment(idUser, idBarber, day, time, "pendent");
            
            Customer customer = new Customer();
            customer.Customer(this.view.getValidUser());
            this.view.dispose();
        }
        
    }
    
}
