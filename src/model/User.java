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
    
    
}
