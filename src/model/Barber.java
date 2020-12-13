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
    private int id;
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

    public Barber(int id, String name, String surname) {
        this.id = id;
        this.firstName = name;
        this.surname = surname;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBarberShop() {
        return barberShop;
    }

    public void setBarberShop(String barberShop) {
        this.barberShop = barberShop;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
}
