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
import model.DAO.BarberDAO;
import model.DAO.ConnectionDB;
import view.BarberSearch;
import view.ChooseTime;
import view.Customer;
import view.MakeAppointment;

/**
 *
 * @author Alysson Chinque
 */
public class BarberSController implements ActionListener {

    private final BarberSearch view;
    private Connection conn;
    private String[] days;
    private int id;

    public int getId() {
        return id;
    }

    public BarberSController(BarberSearch view) {
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
            case "name":
                String name = this.view.getCombo().split(" ")[0];
                String surname = this.view.getCombo().split(" ")[1];
                BarberDAO barberDAO = new BarberDAO(conn);
                BarberAvailabilityDAO barberAvailabilityDAO = new BarberAvailabilityDAO(conn);
                 
                    try {
                        id = barberDAO.searchId(name, surname);
                        System.out.println("barberID: " + id);
                        ChooseTime chooseTime = new ChooseTime();
                        chooseTime.setIdBarber(id);
                        days = barberAvailabilityDAO.searchDays(id);                        
                    } catch (SQLException ex) {
                        Logger.getLogger(BarberSController.class.getName()).log(Level.SEVERE, null, ex);
                    }                
                this.view.dispose();
                MakeAppointment appointment = new MakeAppointment();
                appointment.setId(id);
                appointment.setDays(days);
                appointment.MakeAppointment(this.view.getValidUser());
                break;
                
            case "back":
                this.view.dispose();
                Customer customer = new Customer();
                customer.Customer(this.view.getValidUser());
                break;
        }
    }

}
