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
import model.Appointment;
import model.DAO.AppointmentDAO;
import model.DAO.ConnectionDB;
import view.ChooseTime;
import view.Customer;

/**
 *
 * @author Alysson Chinque
 */
public class ChooseTimeController implements ActionListener {

    private final ChooseTime view;
    private Connection conn;

    public ChooseTimeController(ChooseTime view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         try {
            conn = new ConnectionDB().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Failed");
        }
        if (e.getActionCommand().equals("time")) {
            int idUser = this.view.getValidUser().getId();
            int idBarber = this.view.getBarberAvailability().get(0).getId();
            String day = this.view.getDay();
            String time = this.view.getBoxTime();

            Appointment appointment = new Appointment(idUser, idBarber, day, time, "pendent");
            AppointmentDAO appointmentDAO = new AppointmentDAO(conn);
            try {
                appointmentDAO.insertAppointment(appointment);
            } catch (Exception ew) {
                JOptionPane.showMessageDialog(view, "Failed making the appointment");
            }
            
            JOptionPane.showMessageDialog(view, "Congrats you have made an appointment\n"
                    + "Barber: " + this.view.getNameBarber() + "on " + day + "at " + time
                    + "\nThe current status is 'PENDENT' it is waiting for barber approval");

            Customer customer = new Customer();
            customer.Customer(this.view.getValidUser());
            this.view.dispose();
        }

    }

}
