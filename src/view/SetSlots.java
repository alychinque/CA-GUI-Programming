/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import controller.SetSlotsController;
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
public class SetSlots extends JFrame {
    private Barber validBarber;
    JDateChooser jDateChooser;

    public void SetSlots(Barber validBarber) {
        this.setTitle("Style Barber Shop - Barber");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.validBarber = validBarber;
        SetSlotsController setSlotsController = new SetSlotsController(this);

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

        //MENU ITEMS
        JMenuItem today = new JMenuItem("Today");
        myMenu.add(today);
        today.addActionListener(setSlotsController);
        today.setActionCommand("today");
        myMenu.add(today);
        
        JMenuItem week = new JMenuItem("Week");
        myMenu.add(week);
        week.addActionListener(setSlotsController);
        week.setActionCommand("week");
        myMenu.add(week);
        
        JMenuItem logout = new JMenuItem("Logout");
        myMenu.add(logout);
        logout.addActionListener(setSlotsController);
        logout.setActionCommand("logout");
        myMenu.add(logout);

        //MAIN PANEL
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(Color.black);
        main.setBorder(BorderFactory.createLineBorder(Color.orange));
        main.setBounds(0, 72, 894, 449);

        //TEXT 
        JLabel instructions = new JLabel("Add the days you are available to work:");
        instructions.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        instructions.setForeground(new java.awt.Color(255, 204, 0));
        instructions.setBounds(50, 30, 700, 70);
        main.add(instructions);
        
        JLabel instructions2 = new JLabel("Please choose one day, then choose the hours you are available, then click in add");
        instructions2.setFont(new Font("Arial", Font.PLAIN, 16));
        instructions2.setForeground(new java.awt.Color(255, 204, 0));
        instructions2.setBounds(50, 70, 700, 70);
        main.add(instructions2);
        
        //JDATECHOOSER CREATED TO GET AND ADD DATES THAT BARBERS ARE AVAILABLE
        jDateChooser = new JDateChooser();
        jDateChooser.setBounds(50, 130, 200, 20);
        main.add(jDateChooser);
        
        //HOURS PANEL
        JPanel hoursPanel = new JPanel();
        hoursPanel.setBackground(Color.black);
        hoursPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        hoursPanel.setBounds(260, 130, 200, 190);
        main.add(hoursPanel);
        
        //LABEL HOURS
        JLabel hours = new JLabel("Hours");
        hours.setForeground(new java.awt.Color(255, 204, 0));
        hoursPanel.add(hours);
        
        
        //BUTTON TO ADD DATES
        JButton jb1 = new JButton("ADD");
        jb1.addActionListener(setSlotsController);
        jb1.setBounds(470, 205, 70, 20);
        main.add(jb1);
        this.add(main);
        
        //CONFIRMATION PANEL
        JPanel confirmPanel = new JPanel();
        confirmPanel.setBackground(Color.black);
        confirmPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        confirmPanel.setBounds(550, 130, 300, 298);
        main.add(confirmPanel);
        
        //LABEL CONFIRMATION
        JLabel confirmation = new JLabel("Confirmation");
        confirmation.setForeground(new java.awt.Color(255, 204, 0));
        confirmPanel.add(confirmation);

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
    //methods getters
    public Barber getValidBarber() {
        return validBarber;
    }

    public JDateChooser getjDateChooser() {
        return jDateChooser;
    }
}
