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
import javax.swing.JOptionPane;
import model.DAO.ConnectionDB;
import model.DAO.UserDAO;
import view.Customer;
import view.Home;
import view.Login;

/**
 *
 * @author Alysson Chinque
 */
public class LoginController implements ActionListener {
    private final Login view;
    
    public LoginController(Login view) {
        this.view = view;
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()) {
            case "combo":
                if(this.view.getCombo().equals("CUSTOMER")){
                    this.view.changeVisibilityCustomer(true);
                    this.view.changeVisibilityBarber(false);
                }else{
                    this.view.changeVisibilityCustomer(false);
                    this.view.changeVisibilityBarber(true);
                }   break;
            case "back":
                Home home = new Home();
                this.view.setVisible(false);
                home.setVisible(true);
                break;
            case "customer":
                try {
                    //creating a new Connection conn and giving connection with the DB
                    Connection conn = new ConnectionDB().getConnection();

                    //instantiating userDAO passing a connection as a parameter
                    UserDAO userDAO = new UserDAO(conn);

                    //accessing method checkCustumer in the userDAO class passing email and password as a parameter
                    int id = userDAO.checkCustomer(this.view.getEmailCustomer().getText(), this.view.getPassCustomer().getText());
                    Customer cust = new Customer();
                    cust.Customer(id);
                    this.view.setVisible(false);
                    JOptionPane.showMessageDialog(null, "Welcome!");
                    
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "User not found!\nPlease enter a valid email and password!\n\nOr Register");
                    java.util.logging.Logger.getLogger(RegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                break;
            case "barber":
                break;
        }
    }
    
}
