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
import model.DAO.BarberAvailabilityDAO;
import model.DAO.ConnectionDB;
import view.Customer;
import view.MakeAppointment;

/**
 *
 * @author Alysson Chinque
 */
public class makeAppointmentController implements ActionListener {

    private final MakeAppointment view;
    private Connection conn;

    public makeAppointmentController(MakeAppointment view) {
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
        switch (e.getActionCommand()) {
            case "pickedDay":
                BarberAvailabilityDAO barberAvailabilityDAO = new BarberAvailabilityDAO(conn);

                try {
                    this.view.setTimes(barberAvailabilityDAO.search(this.view.getId(), "time"));
                } catch (SQLException ex) {
                    Logger.getLogger(makeAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }

                break;

            case "back":
                this.view.setVisible(false);
                Customer customer = new Customer();
                // customer.Customer();
                break;
        }
    }

}
