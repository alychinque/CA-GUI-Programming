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
public class Appointment {
    private int idCustomer; 
    private int idBarber; 
    private String date;
    private String time;
    private String status;

    public Appointment(int id_customer, int id_barber, String date, String time, String status) {
        this.idCustomer = id_customer;
        this.idBarber = id_barber;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public int getIdBarber() {
        return idBarber;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    
    
   
}
 