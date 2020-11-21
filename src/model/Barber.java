/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author alych
 */
public class Barber {
    private String firstName;
    private String surname;
    private String barberShop;
    private int phone;
    private String address;
    private String location;
    private String email;
    private String password;

    public Barber(String firstName, String surname, String barberShop, int phone, String address, String location, String email, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.barberShop = barberShop;
        this.phone = phone;
        this.address = address;
        this.location = location;
        this.email = email;
        this.password = password;
    }
    
    
}
