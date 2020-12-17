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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.DAO.AppointmentDAO;
import model.DAO.BarberDAO;
import model.DAO.ComplainDAO;
import model.DAO.ConnectionDB;
import view.BarberSearch;
import view.Customer;
import view.Login;
import view.MyBookings;

/**
 *
 * @author Alysson Chinque
 */
public class CustomerController implements ActionListener {

    private final Customer view;
    private Connection conn;
    private String[][] barberFound;

    public CustomerController(Customer view) {
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

            case "name":

                String name = this.view.getNameT().getText();

                if (nameFilled(name) && isValid(name)) {

                    BarberDAO barberDAO = new BarberDAO(conn);
                    BarberSearch bs = new BarberSearch();
                    try {
                        barberFound = barberDAO.search(name, 1);
                        if (barberFound == null) {
                            break;
                        }

                        bs.setOption(collectNames());
                        bs.setData(barberFound);
                    } catch (Exception ew) {
                        JOptionPane.showMessageDialog(view, name + " Barber not Found");
                        break;
                    }
                    bs.BarberSearch(this.view.getValidUser(), 1);
                    this.view.dispose();
                    break;

                }
                break;

            case "location":
                String location = this.view.getCombo();

                BarberDAO barberDAO = new BarberDAO(conn);
                BarberSearch bs = new BarberSearch();
                try {
                    barberFound = barberDAO.search(location, 2);
                    if (barberFound == null) {
                        break;
                    }

                    bs.setOption(collectNames());
                    bs.setData(barberFound);
                } catch (Exception ew) {
                    JOptionPane.showMessageDialog(view, location + " Location not Found");
                    break;
                }
                bs.BarberSearch(this.view.getValidUser(), 2);
                this.view.dispose();

                break;

            case "complain":
                try {
                    int id = this.view.getValidUser().getId();
                    String text = this.view.getComplainT().getText();
                    Date dateNow = new Date();
                    String date = dateNow.toString();
                    if (text.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please write a message!");
                        break;
                    }
                    ComplainDAO complainDAO = new ComplainDAO(conn);
                    complainDAO.setComplain(id, text, date);
                    JOptionPane.showMessageDialog(null, "SENT");
                    this.view.complainT.setText("");

                    break;
                } catch (Exception ez) {
                    JOptionPane.showMessageDialog(view, "Something went wrong.\nPlease try again");
                }
            case "bookings":

                AppointmentDAO appointmentDAO = new AppointmentDAO(conn);

                try {
                    String[][] appointmentFound = appointmentDAO.returnAppointmet(this.view.getValidUser().getId());
                    MyBookings myBookings = new MyBookings();
                    myBookings.setData(appointmentFound);
                    myBookings.MyBookings(this.view.getValidUser());
                    this.view.dispose();
                    break;
                } catch (SQLException ex) {
                    Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println(ex);
                }
            case "logout":
                this.view.dispose();
                Login login = new Login();
                login.Login();
                break;

            default:
                System.out.println("error");
                break;
        }
    }

    private boolean nameFilled(String name) {
        if (name.equals("")) {
            JOptionPane.showMessageDialog(view, "Please insert a name!");
            return false;
        }
        return true;
    }

    private boolean isValid(String name) {
        boolean nameBoo = Pattern.matches("[a-z]+", name);
        if (nameBoo) {
            return true;
        }
        JOptionPane.showMessageDialog(view, "Names cannot contain numbers or special characters\nPlease try again.");
        return false;
    }

    private String[] collectNames() {
        String[] names = new String[barberFound.length];

        for (int i = 0; i < barberFound.length; i++) {
            names[i] = barberFound[i][0];
        }
        return names;
    }

}
