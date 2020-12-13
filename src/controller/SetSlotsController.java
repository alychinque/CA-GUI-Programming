/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import javax.swing.JOptionPane;
import model.BarberAvailability;
import model.DAO.BarberAvailabilityDAO;
import model.DAO.ConnectionDB;
import view.SetSlots;

/**
 *
 * @author Alysson Chinque
 */
public class SetSlotsController implements ActionListener {

    private final SetSlots view;
    Date date;
    private ArrayList<String> times;
    SimpleDateFormat formato;
    BarberAvailability availability;

    public SetSlotsController(SetSlots view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "add":
                //get and format the date
                date = view.jDateChooser.getDate();
                formato = new SimpleDateFormat("dd/MM/yyyy");
                String dateString = formato.format(date);
                int idBarber = view.getValidBarber().getId();
                
                //if there is no date send a message
                if (view.jDateChooser.getDate() == null) {
                    JOptionPane.showMessageDialog(null, "please insert a date");
                    break;
                }
                //if all is selected times is assigned with all times the day
                if (this.view.getAll()) {
                    times = new ArrayList<>();
                    times.add("9:00");
                    times.add("10:00");
                    times.add("11:00");
                    times.add("12:00");
                    times.add("13:00");
                    times.add("14:00");
                    times.add("15:00");
                    times.add("16:00");
                    times.add("17:00");
                    times.add("18:00");
                    times.add("19:00");

                    String[] array = times.toArray(new String[times.size()]);
                    availability = new BarberAvailability(idBarber, dateString, array);
                    try {
                        //creating a new Connection conn and giving connection with the DB
                        Connection conn = new ConnectionDB().getConnection();

                        //instantiating userDAO passing a connection as a parameter
                        BarberAvailabilityDAO barberAvailabilityDAO = new BarberAvailabilityDAO(conn);

                        //accessing method insert in the userDAO class passing a user as a parameter
                        barberAvailabilityDAO.insert(availability);

                        //write date and times added to the DB in text area
                        this.view.getConfirmTextArea().append("Added the day " + formato.format(date)
                                + "\nTimes:\n" + times + "\n");

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error saving barber,\nPlease, try again");
                        System.out.println(ex);
                        break;
                    }

                    //System.out.println(times.get(0));
                    //clear the array after add
                    times.clear();
                } else {
                   
                    //if a time is selected it is added to times
                    times = new ArrayList<>();
                    if (view.getBox9()) {
                        times.add("9:00");
                    }
                    if (view.getBox10()) {
                        times.add("10:00");
                    }
                    if (view.getBox11()) {
                        times.add("11:00");
                    }
                    if (view.getBox12()) {
                        times.add("12:00");
                    }
                    if (view.getBox13()) {
                        times.add("13:00");
                    }
                    if (view.getBox14()) {
                        times.add("14:00");
                    }
                    if (view.getBox15()) {
                        times.add("15:00");
                    }
                    if (view.getBox16()) {
                        times.add("16:00");
                    }
                    if (view.getBox17()) {
                        times.add("17:00");
                    }
                    if (view.getBox18()) {
                        times.add("18:00");
                    }
                    if (view.getBox19()) {
                        times.add("19:00");
                    }
                    
                     //it checks if times is empty
                    if (times.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "please insert time slots");
                        break;
                    }
                    
                    String[] array = times.toArray(new String[times.size()]);
                    availability = new BarberAvailability(idBarber, dateString, array);
                    
                    try {
                        //creating a new Connection conn and giving connection with the DB
                        Connection conn = new ConnectionDB().getConnection();

                        //instantiating userDAO passing a connection as a parameter
                        BarberAvailabilityDAO barberAvailabilityDAO = new BarberAvailabilityDAO(conn);

                        //accessing method insert in the userDAO class passing a user as a parameter
                        barberAvailabilityDAO.insert(availability);

                        //write date and times added to the DB in text area
                        this.view.getConfirmTextArea().append("Added the day " + formato.format(date)
                                + "\nTimes:\n" + times + "\n");

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error saving barber,\nPlease, try again");
                        System.out.println(ex);
                        break;
                    }
                    
                    this.view.getConfirmTextArea().append("Added the day " + formato.format(date)
                            + "\nTimes:\n" + times + "\n");

                    //clear the array after add
                    times.clear();
                }
                break;
        }
    }

}
