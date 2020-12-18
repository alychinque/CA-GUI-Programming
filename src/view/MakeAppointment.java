/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.MakeAppointmentController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    private String[] days;
    private String nameBarber;
    private int id;

    public void MakeAppointment(User validUser) {
        this.setTitle("Style Barber Shop - day");
        this.setSize(450, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.validUser = validUser;        

        //controller
        MakeAppointmentController makeAppController = new MakeAppointmentController(this);

        //CREATED A PANEL AND A LABEL
        JPanel top = new JPanel();
        JLabel style = new JLabel("Choose the day");

        //SET HEADER
        top.setBackground(Color.black);
        top.setBorder(BorderFactory.createLineBorder(Color.orange));
        style.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        style.setForeground(new java.awt.Color(255, 204, 0));
        //ADDED LABEL TO PANEL AND PANEL TO FRAME
        top.setBounds(0, 0, 444, 42);
        top.add(style);
        this.add(top);

        //MAIN PANEL
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(Color.black);
        main.setBorder(BorderFactory.createLineBorder(Color.orange));
        main.setBounds(0, 42, 444, 229);

        //labels for day
        JLabel barber = new JLabel(this.nameBarber);
        barber.setForeground(new java.awt.Color(255, 204, 0));
        barber.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        barber.setBounds(147, 40, 300, 30);
        main.add(barber);

        //jcombobox for day
        String[] days2 = days;
        boxDay = new JComboBox(days2);
        boxDay.setBounds(147, 120, 150, 30);
        boxDay.addActionListener(makeAppController);
        boxDay.setActionCommand("pickedDay");
        main.add(boxDay);

        this.add(main);
        this.validate();
        this.repaint();

    }

    public User getValidUser() {
        return validUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getDays() {
        return days;
    }

    public String getBoxDay() {
        return boxDay.getSelectedItem().toString();
    }

    public void setDays(String[] days) {
        this.days = days;
    }

    public void setNameBarber(String nameBarber) {
        this.nameBarber = nameBarber;
    }

    public String getNameBarber() {
        return nameBarber;
    }
    

}
