/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BarberAppointmentsController;
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
import model.Barber;

/**
 *
 * @author alych
 */
public class BarberAppointments extends JFrame {

    private Barber validBarber;
    private final String[] colNames = {"Customer", "Day", "Time", "Status"};
    private String[][] data;
    private JTable tableBarbers;
    private JScrollPane scroll;
    private String day;

    public void BarberAppointments(Barber validBarber) {
        this.setTitle("Style Barber Shop - Barber");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.validBarber = validBarber;
        BarberAppointmentsController barberAppointmentsController = new BarberAppointmentsController(this);

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
        today.addActionListener(barberAppointmentsController);
        today.setActionCommand("today");
        myMenu.add(today);
        
        JMenuItem setSlots = new JMenuItem("Set Slots");
        setSlots.addActionListener(barberAppointmentsController);
        setSlots.setActionCommand("setSlots");
        myMenu.add(setSlots);
        
        JMenuItem logout = new JMenuItem("Logout");
        logout.addActionListener(barberAppointmentsController);
        logout.setActionCommand("logout");
        myMenu.add(logout);

        //MAIN PANEL
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(Color.black);
        main.setBorder(BorderFactory.createLineBorder(Color.orange));
        main.setBounds(0, 72, 894, 449);

        //WELCOME TEXT
        JLabel welcome = new JLabel(day);
        welcome.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        welcome.setForeground(new java.awt.Color(255, 204, 0));
        welcome.setBounds(50, 30, 600, 70);
        main.add(welcome);

        //TABLE TO SHOW BARBERS FOUND
        tableBarbers = new JTable(data, colNames);
        scroll = new JScrollPane(tableBarbers);
        scroll.setBounds(175, 150, 550, 200);
        main.add(scroll);

        this.add(main);
        
        // RETURN BUTTON AND FOOTER PANEL
        JButton back = new JButton("BACK");
        back.setBounds(15, 525, 80, 19);
        this.add(back);
        back.addActionListener(barberAppointmentsController);
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

    public Barber getValidBarber() {
        return validBarber;
    }

    public void setData(String[][] data) {
        this.data = data;
    }

}
