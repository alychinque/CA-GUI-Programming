/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BarberSearch;
import view.Customer;
import view.MakeAppointment;

/**
 *
 * @author Alysson Chinque
 */
public class BarberSController implements ActionListener {

    private final BarberSearch view;

    public BarberSController(BarberSearch view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "name":
                MakeAppointment appointment = new MakeAppointment(this.view.getValidUser());
                break;
            case "back":
                this.view.dispose();
                Customer customer = new Customer();
                customer.Customer(this.view.getValidUser());
                break;
        }
    }

}
