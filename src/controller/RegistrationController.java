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
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import model.Barber;
import model.DAO.ConnectionDB;
import model.DAO.UserDAO;
import model.DAO.barberDAO;
import model.User;
import view.Home;
import view.Registration;

/**
 *
 * @author Alysson Chinque
 */
public class RegistrationController implements ActionListener {

    private final Registration view;
    private String[] fullName;
    private String name;
    private String surname;
    private int phone;
    private String phoneString;
    private String email;
    private String pass;
    private String barberShop;
    private String address;
    private String location;

    public RegistrationController(Registration view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            //instatiating Home and turn visible true while turn Registration off
            case "back":
                Home home = new Home();
                this.view.dispose();
                home.setVisible(true);
                break;
            //show customer section and hide barber section
            case "customer":
                this.view.setBarberSection(false);
                this.view.setRegisterCust(true);
                break;
            //show barber section and hide customer section
            case "barber":
                this.view.setBarberSection(true);
                this.view.setRegisterCust(false);
                break;

            case "registerCust":
                //validate a user
                if (validateName() && validatePhone() && validateEmail()) {
                    JOptionPane.showMessageDialog(null, "Success");
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed");
                }
                //validatedPass();
                //creating a new user receiving a validated user
                User user = new User(name, surname, phone, email, pass);
                try {
                    //creating a new Connection conn and giving connection with the DB
                    Connection conn = new ConnectionDB().getConnection();

                    //instantiating userDAO passing a connection as a parameter
                    UserDAO userDAO = new UserDAO(conn);

                    //accessing method insert in the userDAO class passing a user as a parameter
                    userDAO.insert(user);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "registerBarber":
                if (validateName() && validatePhone() && validateEmail()) {
                    JOptionPane.showMessageDialog(null, "Success");
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed");
                }
                barberShop = view.getBarberShop().getText();
                phone = Integer.parseInt(view.getPhone().getText());
                address = view.getAddress().getText();
                location = view.getCombo();
                email = view.getEmail().getText();
                pass = view.getPassword().getText();

                //creating a new barber 
                Barber barber = new Barber(name, surname, barberShop, phone, address, location, email, pass);
                try {
                    //creating a new Connection conn and giving connection with the DB
                    Connection conn = new ConnectionDB().getConnection();

                    //instantiating userDAO passing a connection as a parameter
                    barberDAO barberDAO = new barberDAO(conn);

                    //accessing method insert in the userDAO class passing a user as a parameter
                    barberDAO.insert(barber);
                } catch (SQLException ex) {
                    java.util.logging.Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
        }
    }

    private Boolean validateName() {
        //receiving custumers' attributes
        try {
            fullName = view.getFullName().getText().trim().split(" ");
            if (fullName.length >= 2) {
                name = fullName[0].toLowerCase();
                surname = fullName[fullName.length - 1].toLowerCase();
                return isValidName(name, surname);
            } else {
                JOptionPane.showMessageDialog(null, "Failed!\nPlease enter name and surname with a space between them!");
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error");
            return false;
        }
    }

    private boolean isValidName(String name, String surname) {
        boolean nameBoo = Pattern.matches("[a-z]+", name);
        boolean surnameBoo = Pattern.matches("[a-z]+", surname);
        if (nameBoo && surnameBoo == true) {

            return true;
        } else {
            if (!nameBoo) {
                JOptionPane.showMessageDialog(null, "Name is not valid!\nPlease enter again!");
            }
            if (!surnameBoo) {
                JOptionPane.showMessageDialog(null, "Surname is not valid!\nPlease enter again!");
            }
            return false;
        }
    }

    private Boolean validatePhone() {
        try {
            phoneString = view.getPhone().getText();
            phone = Integer.parseInt(phoneString);
            if (phoneString.length() >= 7 && phoneString.length() <= 10) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Phone is not valid!\nPlease enter again, just numbers between 7 and 10 digits!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Phone is not valid!\nPlease enter again just numbers between 7 and 10 digits!");
            return false;
        }

    }
    //method implemented from geeksforgeeks
    //URL:https://www.geeksforgeeks.org/check-email-address-valid-not-java/
    private Boolean validateEmail() {
        try {
            email = view.getEmail().getText();
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."
                    + "[a-zA-Z0-9_+&*-]+)*@"
                    + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
                    + "A-Z]{2,7}$";

            Pattern pat = Pattern.compile(emailRegex);
            if (email == null) {
                JOptionPane.showMessageDialog(null, "Email field is empty!\nPlease enter an email!");
                return false;
            }
            if (pat.matcher(email).matches() == true) {
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Email is not valid!\nPlease enter again!");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Email is not valid!\nPlease enter again!");
            return false;
        }
    }
}
