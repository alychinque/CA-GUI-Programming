/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import model.User;
import controller.ChooseTimeController;
import java.util.ArrayList;
import model.BarberAvailability;

/**
 *
 * @author alych
 */
public class ChooseTime extends JFrame {

    private User validUser;
    private ArrayList<BarberAvailability> barberAvailability;
    private JComboBox boxTime;
    private String[] times;
    public int idBarber;
    private String day;
    private String nameBarber;

    public void ChooseTime(User validUser, ArrayList<BarberAvailability> barberAvailability) {

        this.setTitle("Style Barber Shop - time");
        this.setSize(450, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.validUser = validUser;
        this.barberAvailability = barberAvailability;

        //controller
        ChooseTimeController chooseTimeController = new ChooseTimeController(this);

        //CREATED A PANEL AND A LABEL
        JPanel top = new JPanel();
        JLabel style = new JLabel("Choose the time");

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

        //labels for time
        JLabel barber = new JLabel(this.nameBarber);
        barber.setForeground(new java.awt.Color(255, 204, 0));
        barber.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        barber.setBounds(147, 40, 250, 30);
        main.add(barber);

        //jcombobox time
        String[] times2 = times;
        boxTime = new JComboBox(times2);
        boxTime.setBounds(147, 150, 150, 30);
        boxTime.addActionListener(chooseTimeController);
        boxTime.setActionCommand("time");
        main.add(boxTime);
        this.add(main);

        this.validate();
        this.repaint();

    }

    public User getValidUser() {
        return validUser;
    }

    public ArrayList<BarberAvailability> getBarberAvailability() {
        return barberAvailability;
    }
    
    public String getBoxTime() {
        return boxTime.getSelectedItem().toString();
    }

    public void setTimes(String[] times) {
        int size = times.length;
        times[0] = times[0].replace("[", "");
        times[size-1] = times[size-1].replace("]", "");
        this.times = times;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setNameBarber(String nameBarber) {
        this.nameBarber = nameBarber;
    }
    
}
