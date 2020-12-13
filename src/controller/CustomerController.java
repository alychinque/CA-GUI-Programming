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
import javax.swing.JOptionPane;
import model.DAO.ComplainDAO;
import model.DAO.ConnectionDB;
import view.BarberSearch;
import view.Customer;
import view.LocationSearch;

/**
 *
 * @author Alysson Chinque
 */
public class CustomerController implements ActionListener {

    private final Customer view;

    public CustomerController(Customer view) {
        this.view = view;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "name":
                this.view.setVisible(false);
                BarberSearch bs = new BarberSearch(this.view.getValidUser());
                bs.BarberSearch();
                break;
            case "location":
                this.view.setVisible(false);
                LocationSearch ls = new LocationSearch();
                ls.LocationSearch();
                break;
            case "complain":
                int id = this.view.getValidUser().getId();
                String text = this.view.getComplainT().getText();
                Date dateNow = new Date();
                String date = dateNow.toString();
                if (text.equals("")){
                    JOptionPane.showMessageDialog(null, "Please write a message!");
                    break;
                }
                //creating a new Connection conn and giving connection with the DB
                try {
                    Connection conn = new ConnectionDB().getConnection();
                    ComplainDAO complainDAO = new ComplainDAO(conn);
                    complainDAO.setComplain(id, text, date);
                    JOptionPane.showMessageDialog(null, "SENT");
                    this.view.complainT.setText(""); 
               } catch (SQLException ex) {
                    Logger.getLogger(CustomerController.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(null, "Failed");
                }
                
                break;
            default:
                System.out.println("error");
                break;
        }
    }

}
