/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.makeAppointmentController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import model.User;

/**
 *
 * @author Alysson Chinque
 */
public class MakeAppointment extends JFrame {

    private User validUser;
    private JComboBox boxDay;
    private JComboBox boxTime;
    private String[] days;
    private String[] times;
    private int id;

    public void MakeAppointment(User validUser) {
        this.setTitle("Style Barber Shop - make appointment");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.validUser = validUser;

        //controller
        makeAppointmentController locationController = new makeAppointmentController(this);

        //CREATED A PANEL AND A LABEL
        JPanel top = new JPanel();
        JLabel style = new JLabel("STYLE BARBER SHOP");

        //SET HEADER
        top.setBackground(Color.black);
        top.setBorder(BorderFactory.createLineBorder(Color.orange));
        style.setFont(new Font("Showcard Gothic", Font.PLAIN, 48));
        style.setForeground(new java.awt.Color(255, 204, 0));
        //ADDED LABEL TO PANEL AND PANEL TO FRAME
        top.setBounds(0, 0, 894, 72);
        top.add(style);
        this.add(top);

        //MENUBAR
        JMenuBar myMenuBar = new JMenuBar();
        this.setJMenuBar(myMenuBar);

        JMenu myMenu = new JMenu("MENU");
        myMenuBar.add(myMenu);

        JMenuItem myBookings = new JMenuItem("My Bookings");
        myMenu.add(myBookings);
        JMenuItem logout = new JMenuItem("Logout");
        myMenu.add(logout);

        //MAIN PANEL
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(Color.black);
        main.setBorder(BorderFactory.createLineBorder(Color.orange));
        main.setBounds(0, 72, 894, 449);

       //labels for day and time
        JLabel day = new JLabel("Choose one day: ");
        day.setForeground(new java.awt.Color(255, 204, 0));
        day.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        day.setBounds(100, 70, 300, 30);
        main.add(day);
        JLabel time = new JLabel("Choose one time: ");
        time.setForeground(new java.awt.Color(255, 204, 0));
        time.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        time.setBounds(100, 150, 300, 30);
        main.add(time);

        //jcomboboxes for day and time
        String [] days2 = days; 
        boxDay = new JComboBox(days2);
        boxDay.setBounds(350, 70, 150, 30);
        boxDay.addActionListener(locationController);
        boxDay.setActionCommand("pickedDay");
        main.add(boxDay);

        String [] times2 = {"9:00", "10:00", "11:00", "12:00", "13:00", "14:00"};
        boxTime = new JComboBox(times2);
        boxTime.setBounds(350, 150, 150, 30);
        main.add(boxTime);
        this.add(main);

        // RETURN BUTTON AND FOOTER PANEL
        JButton back = new JButton("BACK");
        back.setBounds(15, 525, 80, 19);
        this.add(back);
        back.addActionListener(locationController);
        back.setActionCommand("back");

        //FOOTER PANEL
        JPanel footer = new JPanel();
        JLabel copy = new JLabel("2020© Alysson Chinque");
        footer.setBackground(Color.black);
        footer.setBorder(BorderFactory.createLineBorder(Color.orange));
        copy.setFont(new Font("Arial", Font.PLAIN, 12));
        copy.setForeground(new java.awt.Color(255, 204, 0));
        footer.add(copy);
        footer.setBounds(0, 521, 894, 27);
        this.add(footer);

        this.validate();
        this.repaint();

    }

    public User getValidUser() {
        return validUser;
    }

    public String getBoxDay() {
        return boxDay.getSelectedItem().toString();
    }

    public String getBoxTime() {
        return boxTime.getSelectedItem().toString();
    }

    public void setDays(String[] days) {
        this.days = days;
    }

    public void setTimes(String[] times) {
        this.times = times;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
