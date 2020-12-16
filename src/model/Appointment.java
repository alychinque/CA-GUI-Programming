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
    private int id_customer; 
    private int id_barber; 
    private String date;
    private String time;
    private String status;

    public Appointment(int id_customer, int id_barber, String date, String time, String status) {
        this.id_customer = id_customer;
        this.id_barber = id_barber;
        this.date = date;
        this.time = time;
        this.status = status;
    }

    public int getId_customer() {
        return id_customer;
    }

    public void setId_customer(int id_customer) {
        this.id_customer = id_customer;
    }

    public int getId_barber() {
        return id_barber;
    }

    public void setId_barber(int id_barber) {
        this.id_barber = id_barber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
 