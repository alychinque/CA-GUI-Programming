/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DAO.AppointmentDAO;
import model.DAO.ConnectionDB;
import view.BarberAppointments;
import view.BarberView;
import view.SetSlots;

/**
 *
 * @author Alysson Chinque
 */
public class BarberViewController implements ActionListener {

    private final BarberView view;
    private Connection conn;

    public BarberViewController(BarberView view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //creating a new Connection conn and giving connection with the DB
        try {
            conn = new ConnectionDB().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Failed");
        }

        switch (e.getActionCommand()) {
            case "show":
                AppointmentDAO appointmentDAO = new AppointmentDAO(conn);
                String[][] barberAppointment = null;
                 {
                    try {
                        barberAppointment = appointmentDAO.barberApointment(this.view.getValidBarber().getId());
                        if (barberAppointment == null) {

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(BarberViewController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     BarberAppointments barberAppointments = new BarberAppointments();
                     barberAppointments.setData(barberAppointment);
                     barberAppointments.BarberAppointments(this.view);
                     this.view.dispose();
                }

            case "setSlots":
                SetSlots setSlots = new SetSlots();
                setSlots.SetSlots(this.view.getValidBarber());
                this.view.dispose();
                break;

        }
    }

}
