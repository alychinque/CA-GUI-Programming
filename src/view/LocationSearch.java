/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LocationSController;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

/**
 *
 * @author Alysson Chinque
 */
public class LocationSearch extends JFrame{
    String[] colNames = {"Module", "Lecture", "Days"};
        String[][]  data = {
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
            {"GUI", "Amilcar", "Friday"},
            {"Laboratory", "Aldana", "Tuesday"},
        };

    public void LocationSearch() {
        this.setTitle("Style Barber Shop - customer");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        LocationSController locationController = new LocationSController(this);

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
        
        JLabel nameBarber = new JLabel("Found barbers in + Location"); //ADD BARBER'S LOCATION HERE
        nameBarber.setForeground(new java.awt.Color(255, 204, 0));
        nameBarber.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        nameBarber.setBounds(200, 70, 400, 30);
        main.add(nameBarber);
        
        JTable tableBarbers = new JTable(data, colNames);
        tableBarbers.setFont(new Font("Showcard Gothic", Font.PLAIN, 16));
        tableBarbers.setForeground(new java.awt.Color(255, 255, 255));
        tableBarbers.setBackground(Color.black);
        JScrollPane scroll = new JScrollPane(tableBarbers);
        scroll.setBounds(200, 150, 500, 200);
        scroll.setBackground(Color.red);
        main.add(scroll);
        this.add(main);
         
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
}
