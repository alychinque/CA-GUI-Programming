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
import model.DAO.ConnectionDB;
import model.DAO.UserDAO;
import model.User;
import view.Home;
import view.Registration;

/**
 *
 * @author Alysson Chinque
 */
public class RegistrationController implements ActionListener{
    private final Registration view;
    
    public RegistrationController(Registration view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "back":
                //instatiating Home and turn visible true while turn Registration off
                Home home = new Home();
                this.view.dispose();
                home.setVisible(true);
                break;
                
            case "customer":
                this.view.setBarberSection(false);
                this.view.setRegisterCust(true);
                break;
                
            case "barber":
                this.view.setBarberSection(true);
                this.view.setRegisterCust(false);
                break;
                
            case "registerCust":
                //receiving custumers' attributes
                String name = view.getFirstName().getText();
                String surname = view.getSurname().getText();
                int phone = Integer.parseInt(view.getPhone().getText());
                String email = view.getEmail().getText();
                String pass = view.getPassword().getText();
                //creating a new user 
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
        }
    } 
}
