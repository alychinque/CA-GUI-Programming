/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author alych
 */
public class BarberAvailability {
    int id;
    String dateAva;
    private String [] time;

    public BarberAvailability(int id, String date, String [] time) {
        this.id = id;
        this.dateAva = date;
        this.time = time;
    }
    public BarberAvailability(int id, String date) {
        this.id = id;
        this.dateAva = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateAva() {
        return dateAva;
    }

    public void setDateAva(String date) {
        this.dateAva = date;
    }

    public String [] getTime() {
        return time;
    }

    public void setTime(String[] time) {
        this.time = time;
    }
    
    
}
