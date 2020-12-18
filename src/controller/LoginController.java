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
import model.Barber;
import model.DAO.AppointmentDAO;
import model.DAO.ConnectionDB;
import model.DAO.UserDAO;
import model.DAO.BarberDAO;
import model.User;
import view.BarberView;
import view.Customer;
import view.Home;
import view.Login;

/**
 *
 * @author Alysson Chinque
 */
public class LoginController implements ActionListener {

    private final Login view;
    private Connection conn;

    public LoginController(Login view) {
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //creating a new Connection conn and giving connection with the DB

        try {
            conn = new ConnectionDB().getConnection();
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (e.getActionCommand()) {
            case "combo":
                if (this.view.getCombo().equals("CUSTOMER")) {
                    this.view.changeVisibilityCustomer(true);
                    this.view.changeVisibilityBarber(false);
                    break;
                } else {
                    this.view.changeVisibilityCustomer(false);
                    this.view.changeVisibilityBarber(true);
                }
                break;

            case "customer":
                try {

                    //instantiating userDAO passing a connection as a parameter
                    UserDAO userDAO = new UserDAO(conn);

                    //data customer
                    String email = this.view.getEmailCustomer().getText();
                    String pass = this.view.getPassCustomer().getText();

                    if (email.equals("") || pass.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill the fields up!");
                        break;
                    }

                    //accessing method checkCustumer in the userDAO class passing email and password as a parameter
                    User validUser = userDAO.checkCustomer(email, pass);

                    if (validUser == null) {
                        JOptionPane.showMessageDialog(null, "User not found!\nPlease enter a valid email and password!\nIf you are new, please back and register");
                        break;
                    } else {
                        Customer cust = new Customer();
                        cust.Customer(validUser);
                        this.view.setVisible(false);
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                    break;
                }

                break;
            case "barber":
                try {

                    //instantiating userDAO passing a connection as a parameter
                    BarberDAO barberDAO = new BarberDAO(conn);

                    //data customer
                    String email = this.view.getEmailBarber().getText();
                    String pass = this.view.getPassBarber().getText();

                    if (email.equals("") || pass.equals("")) {
                        JOptionPane.showMessageDialog(null, "Please fill the fields up!");
                        break;
                    }

                    //accessing method checkCustumer in the userDAO class passing email and password as a parameter
                    Barber validBarber = barberDAO.checkBarber(email, pass);

                    if (validBarber == null) {
                        JOptionPane.showMessageDialog(null, "Barber not found!\nPlease enter a valid email and password!\nIf you are new, please back and register");
                        break;
                    } else {
                        BarberView barView = new BarberView();
                        barView.BarberView(validBarber);
                        this.view.dispose();
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error");
                    break;
                }

                break;
            case "back":
                Home home = new Home();
                this.view.setVisible(false);
                home.setVisible(true);
                break;
        }
    }

}
