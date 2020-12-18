/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BarberAppointments;

/**
 *
 * @author alych
 */
public class BarberAppointmentsController implements ActionListener{
    private final BarberAppointments view;

    public BarberAppointmentsController(BarberAppointments view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
