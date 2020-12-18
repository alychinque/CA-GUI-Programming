/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BarberViewController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import model.Barber;

/**
 *
 * @author Alysson Chinque
 */
public class BarberView extends JFrame {

    private Barber validBarber;

    public void BarberView(Barber validBarber) {
        this.setTitle("Style Barber Shop - Barber");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.validBarber = validBarber;
        BarberViewController barberController = new BarberViewController(this);

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

        JMenuItem today = new JMenuItem("Today");
        today.addActionListener(barberController);
        today.setActionCommand("today");
        myMenu.add(today);
        
        JMenuItem setSlots = new JMenuItem("Set Slots");
        setSlots.addActionListener(barberController);
        setSlots.setActionCommand("setSlots");
        myMenu.add(setSlots);
        
        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(barberController);
        logout.setActionCommand("logout");
        myMenu.add(logout);
        
        //MAIN PANEL
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(Color.black);
        main.setBorder(BorderFactory.createLineBorder(Color.orange));
        main.setBounds(0, 72, 894, 449);

        //WELCOME TEXT
        JLabel welcome = new JLabel("Welcome  " + this.validBarber.getFirstName() + "  " + this.validBarber.getSurname());
        welcome.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        welcome.setForeground(new java.awt.Color(255, 204, 0));
        welcome.setBounds(50, 30, 600, 70);
        main.add(welcome);
        
        //LABEL SHOW APPOINTMENTS
        JLabel label = new JLabel("SHOW YOUR APPOINTMENTS: ");
        label.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
        label.setForeground(new java.awt.Color(255, 204, 0));
        label.setBounds(90, 120, 420, 80);
        main.add(label);
        
        //BUTTON TO SHOW APPOINTMENTS
        JButton show = new JButton("SHOW");
        show.setBounds(575, 125, 170, 50);
        show.setFont(new Font("Arial", Font.PLAIN, 18));
        show.addActionListener(barberController);
        show.setActionCommand("show");
        main.add(show);
        
        //LABEL SHOW TO APPOINTMENTS FOR TODAY
        JLabel labelToday = new JLabel("CHECK YOUR APPOINTMENTS FOR TODAY:");
        labelToday.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
        labelToday.setForeground(new java.awt.Color(255, 204, 0));
        labelToday.setBounds(90, 225, 685, 80);
        main.add(labelToday);
        
        //BUTTON TO SHOW APPOINTMENTS FOR TODAY
        JButton todayB = new JButton("CHECK");
        todayB.setBounds(575, 230, 170, 50);
        todayB.setFont(new Font("Arial", Font.PLAIN, 18));
        todayB.addActionListener(barberController);
        todayB.setActionCommand("today");
        main.add(todayB);
        
        //LABEL SHOW TO SET SLOTS
        JLabel labelSetSlots = new JLabel("SET YOUR DAYS AND TIME FREE: ");
        labelSetSlots.setFont(new Font("Showcard Gothic", Font.PLAIN, 24));
        labelSetSlots.setForeground(new java.awt.Color(255, 204, 0));
        labelSetSlots.setBounds(90, 330, 420, 80);
        main.add(labelSetSlots);
        
        //BUTTON TO SHOW 
        JButton setSlotsB = new JButton("SET SLOTS");
        setSlotsB.setBounds(575, 335, 170, 50);
        setSlotsB.setFont(new Font("Arial", Font.PLAIN, 18));
        setSlotsB.addActionListener(barberController);
        setSlotsB.setActionCommand("setSlots");
        main.add(setSlotsB);
        this.add(main);

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

    public Barber getValidBarber() {
        return validBarber;
    }
}
