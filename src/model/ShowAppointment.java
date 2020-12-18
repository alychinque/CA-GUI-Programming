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
public class ShowAppointment {
    
    private String nameBarber ;
    private String barberShop ;
    private String address ;
    private String day ;
    private String time ;
    private String status ;
    private String nameCustomer;

    public ShowAppointment(String nameBarber, String barberShop, String address, String day, String time, String status) {
        this.nameBarber = nameBarber;
        this.barberShop = barberShop;
        this.address = address;
        this.day = day;
        this.time = time;
        this.status = status;
    }
    
    public ShowAppointment(String nameCustomer, String day, String time, String status) {
        this.nameCustomer = nameCustomer;
        this.day = day;
        this.time = time;
        this.status = status;
    }    

    public String getNameBarber() {
        return nameBarber;
    }

    public String getBarberShop() {
        return barberShop;
    }

    public String getAddress() {
        return address;
    }

    public String getDay() {
        return day;
    }

    public String getTime() {
        return time;
    }

    public String getStatus() {
        return status;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }
    
    
}
