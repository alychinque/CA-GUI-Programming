/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BarberSearch;
import view.Customer;

/**
 *
 * @author Alysson Chinque
 */
public class CustomerController implements ActionListener{
    private final Customer view;

    public CustomerController(Customer view) {
        this.view = view;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("name")){
            this.view.setVisible(false);
            BarberSearch bs = new BarberSearch();
            bs.BarberSearch();
        }else if(e.getActionCommand().equals("location")){
            System.out.println("Serched by location");
        }else if(e.getActionCommand().equals("complain")){
            System.out.println("let a complain");
        }else{
            System.out.println("error");
        }
    }
    
}
