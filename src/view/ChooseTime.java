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

/**
 *
 * @author alych
 */
public class ChooseTime extends JFrame {

    private User validUser;
    private JComboBox boxTime;
    private String[] times;
    public int idBarber;
    private String day;

    public void ChooseTime(User validUser) {

        this.setTitle("Style Barber Shop - time");
        this.setSize(450, 300);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.validUser = validUser;

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
        JLabel day = new JLabel("name barber");
        day.setForeground(new java.awt.Color(255, 204, 0));
        day.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        day.setBounds(147, 40, 250, 30);
        main.add(day);

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

    public String getBoxTime() {
        return boxTime.getSelectedItem().toString();
    }

    public void setTimes(String[] times) {
        int size = times.length;
        times[0] = times[0].replace("[", "");
        times[size-1] = times[size-1].replace("]", "");
        this.times = times;
    }

    public int getIdBarber() {
        System.out.println("this."+ this.idBarber);
        return this.idBarber;
    }

    public void setIdBarber(int idBarber) {
        System.out.println("setIdBarber: "+ idBarber);
        this.idBarber = idBarber;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
    
}
