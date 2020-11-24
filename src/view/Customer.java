/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alysson Chinque
 */
public class Customer extends JFrame{

    public void Customer() {
        this.setTitle("Style Barber Shop - customer");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

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
        
        //WELCOME TEXT
        JLabel welcome = new JLabel("Welcome");
        welcome.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        welcome.setForeground(new java.awt.Color(255, 204, 0));
        welcome.setBounds(50, 30, 150, 70);
        main.add(welcome);
        JLabel nameCust = new JLabel("receive the name");
        nameCust.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        nameCust.setForeground(new java.awt.Color(255, 204, 0));
        nameCust.setBounds(195, 30, 350, 70);
        main.add(nameCust);
        JLabel searchText = new JLabel("Search a baber by name or location:");
        searchText.setFont(new Font("Arial", Font.PLAIN, 20));
        searchText.setForeground(new java.awt.Color(255, 204, 0));
        searchText.setBounds(50, 70, 400, 70);
        main.add(searchText);
        
        //NAME LABEL, TEXTFIELD AND BUTTON
        JLabel name = new JLabel("NAME:");
        name.setFont(new Font("Arial", Font.PLAIN, 20));
        name.setForeground(new java.awt.Color(255, 204, 0));
        name.setBounds(250, 140, 80, 30);
        main.add(name);
        JTextField nameT = new JTextField();
        nameT.setBounds(370, 140, 300, 30);
        main.add(nameT);
        JButton nameB = new JButton("SEARCH");
        nameB.setBounds(675, 150, 90, 20);
        main.add(nameB);
        
        //LOCATION LABEL, TEXTFIELD AND BUTTON
        JLabel location = new JLabel("LOCATION:");
        location.setFont(new Font("Arial", Font.PLAIN, 20));
        location.setForeground(new java.awt.Color(255, 204, 0));
        location.setBounds(250, 190, 120, 30);
        main.add(location);
        JTextField locationT = new JTextField("");
        locationT.setBounds(370, 190, 300, 30);
        main.add(locationT);
        JButton locationB = new JButton("SEARCH");
        locationB.setBounds(675, 200, 90, 20);
        main.add(locationB);
        
        //COMPLAIN LABEL, TEXTFIELD AND BUTTON
        JLabel complain = new JLabel("DO YOU HAVE ANY SUGGESTION OR COMPLAIN?");
        complain.setFont(new Font("Arial", Font.PLAIN, 20));
        complain.setForeground(new java.awt.Color(255, 204, 0));
        complain.setBounds(250, 240, 550, 30);
        main.add(complain);
        JTextArea complainT = new JTextArea("");
        complainT.setBounds(370, 280, 395, 120);
        //SET THE INSERTION POINT TO THE TOP OF THE FIELD
        main.add(complainT);
        JButton complainB = new JButton("SEND");
        complainB.setBounds(675, 410, 90, 20);
        main.add(complainB);
        this.add(main);
        
        
         // RETURN BUTTON AND FOOTER PANEL
        JButton back = new JButton("BACK");
        back.setBounds(15, 548, 80, 19);
        this.add(back);
        //back.addActionListener();
        back.setActionCommand("back");
        
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
    
}
