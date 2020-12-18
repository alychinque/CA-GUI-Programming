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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.DAO.AppointmentDAO;
import model.DAO.ConnectionDB;
import view.BarberAppointments;
import view.BarberView;
import view.Login;
import view.SetSlots;

/**
 *
 * @author alych
 */
public class BarberAppointmentsController implements ActionListener {

    private final BarberAppointments view;
    private Connection conn;
    AppointmentDAO appointmentDAO;

    public BarberAppointmentsController(BarberAppointments view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //creating a new Connection conn and giving connection with the DB
        try {
            appointmentDAO = new AppointmentDAO(conn);
            conn = new ConnectionDB().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Failed");
        }
        switch (e.getActionCommand()) {
            case "setSlots":
                SetSlots setSlots = new SetSlots();
                setSlots.SetSlots(this.view.getValidBarber());
                this.view.dispose();
                break;

            case "back":
                BarberView barberView = new BarberView();
                this.view.dispose();
                barberView.BarberView(this.view.getValidBarber());
                break;

            case "logout":
                this.view.dispose();
                Login login = new Login();
                login.Login();
                break;

            default:
                JOptionPane.showMessageDialog(view, "Error");
                break;
        }
    }

}
