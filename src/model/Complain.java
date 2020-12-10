/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Alysson Chinque
 */
public class Complain {
    private final int id_customer; 
    private final String text;
    private final String date;

    public Complain(int id_customer, String text, String date) {
        this.id_customer = id_customer;
        this.text = text;
        this.date = date;
    }
    
    
    
}
