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
 * @author Alysson Chinque
 */
public class BarberViewController implements ActionListener {

    private final BarberView view;
    private Connection conn;
    AppointmentDAO appointmentDAO;

    public BarberViewController(BarberView view) {
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
            case "show":
                appointmentDAO = new AppointmentDAO(conn);
                String[][] barberAppointment = null;
                 {
                    try {
                        barberAppointment = appointmentDAO.barberAppointment(this.view.getValidBarber().getId());
                        if (barberAppointment == null) {
                            JOptionPane.showMessageDialog(null, "You don't have appointments");
                            break;
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(view, "Stop here");
                        break;
                    }
                    BarberAppointments barberAppointments = new BarberAppointments();
                    barberAppointments.setData(barberAppointment);
                    barberAppointments.BarberAppointments(this.view.getValidBarber());
                    this.view.dispose();
                    break;
                }

            case "today":
                Date dateToday = new Date();
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                String now = formato.format(dateToday);
                String[][] today = null;
                 {
                    try {
                        today = appointmentDAO.appointmentToday(this.view.getValidBarber().getId(), now);
                        if (today == null) {
                            JOptionPane.showMessageDialog(null, "You don't have appointments on "+ now);
                            break;
                        }
                    } catch (SQLException ew) {
                        Logger.getLogger(BarberViewController.class.getName()).log(Level.SEVERE, null, ew);
                        System.out.println("error: " + ew);
                    }
                    BarberAppointments barberAppointments = new BarberAppointments();
                    barberAppointments.setData(today);
                    barberAppointments.BarberAppointments(this.view.getValidBarber());
                    this.view.dispose();
                }

            case "setSlots":
                SetSlots setSlots = new SetSlots();
                setSlots.SetSlots(this.view.getValidBarber());
                this.view.dispose();
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
