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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.BarberAvailability;
import model.DAO.BarberAvailabilityDAO;
import model.DAO.ConnectionDB;
import view.ChooseTime;
import view.MakeAppointment;

/**
 *
 * @author Alysson Chinque
 */
public class MakeAppointmentController implements ActionListener {

    private final MakeAppointment view;
    private Connection conn;

    public MakeAppointmentController(MakeAppointment view) {
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
                ChooseTime chooseTime = new ChooseTime();
                chooseTime.setDay(this.view.getBoxDay());
                ArrayList<BarberAvailability> barberAvailability = this.view.getBarberAvailability();
                try {
                    chooseTime.setTimes(barberAvailabilityDAO.searchTime(this.view.getBarberAvailability().get(0).getId(), this.view.getBoxDay()));
                } catch (SQLException ex) {
                    Logger.getLogger(MakeAppointmentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                chooseTime.setNameBarber(this.view.getNameBarber());
                chooseTime.ChooseTime(this.view.getValidUser(), this.view.getBarberAvailability());
                this.view.dispose();
                
                break;
        }
    }

}
