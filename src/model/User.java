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
public class User {
    private int id;
    private String firstName;
    private String surname;
    private int phone;
    private String email;
    private String password;

    public User(String firstName, String surname, int phone, String email, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }

    public User(int id, String name, String surname) {
        this.id = id;
        this.firstName = name;
        this.surname = surname;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
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
