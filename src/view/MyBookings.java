/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BookingController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import model.User;

/**
 *
 * @author Alysson Chinque
 */
public class MyBookings extends JFrame {

    private User validUser;
    private final String[] colNames = {"Barber", "BarberShop", "Address", "Day", "Time", "Status"};
    private String[][] data;

    public void MyBookings(User validUser) {
        this.setTitle("Style Barber Shop - barber search");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        BookingController bookingController = new BookingController(this);
        this.validUser = validUser;

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

        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(bookingController);
        logout.setActionCommand("logout");
        myMenu.add(logout);

        //MAIN PANEL
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(Color.black);
        main.setBorder(BorderFactory.createLineBorder(Color.orange));
        main.setBounds(0, 72, 894, 449);

        JLabel nameBarber;
        nameBarber = new JLabel(this.validUser.getFirstName() + " Bookings");
        nameBarber.setForeground(new java.awt.Color(255, 204, 0));
        nameBarber.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        nameBarber.setBounds(200, 70, 600, 30);
        main.add(nameBarber);

        //TABLE TO SHOW BARBERS FOUND
        JTable tableBarbers = new JTable(data, colNames);
        JScrollPane scroll = new JScrollPane(tableBarbers);
        scroll.setBounds(175, 150, 550, 200);
        main.add(scroll);

        this.add(main);
        // RETURN BUTTON AND FOOTER PANEL
        JButton back = new JButton("BACK");
        back.setBounds(15, 525, 80, 19);
        this.add(back);
        back.addActionListener(bookingController);
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

   
    public String[][] getData() {
        return data;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

    public User getValidUser() {
        return validUser;
    }

}
