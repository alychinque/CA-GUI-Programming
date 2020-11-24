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
