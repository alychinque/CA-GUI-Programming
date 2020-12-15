/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BarberSController;
import java.awt.Color;
import java.awt.Font;
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
public class BarberSearch extends JFrame {

    private final String[] colNames = {"Name", "BarberShop", "Address", "Location"};
    private String[][] data;
    private User validUser;
    private String[] option;
    private JComboBox combo;

    public void BarberSearch(User validUser, int type) {
        this.setTitle("Style Barber Shop - barber search");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);
        BarberSController barberSController = new BarberSController(this);
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

        JLabel nameBarber;
        if (type == 1){
            nameBarber= new JLabel("Found " + Arrays.toString(data[0]).split(" ")[0]); 
        } else {
            nameBarber= new JLabel("Found " + data[0][3]); 
        }
        nameBarber.setForeground(new java.awt.Color(255, 204, 0));
        nameBarber.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        nameBarber.setBounds(200, 70, 600, 30);
        main.add(nameBarber);

        //TABLE TO SHOW BARBERS FOUND
        JTable tableBarbers = new JTable(data, colNames);
        JScrollPane scroll = new JScrollPane(tableBarbers);
        scroll.setBounds(175, 150, 550, 200);
        main.add(scroll);

        //CREATED PANEL OF CHOICE
        combo = new JComboBox(option);
        combo.addActionListener(barberSController);
        combo.setActionCommand("name");
        combo.setBounds(347, 360, 200, 25);
        main.add(combo);
        this.add(main);

        // RETURN BUTTON AND FOOTER PANEL
        JButton back = new JButton("BACK");
        back.setBounds(15, 525, 80, 19);
        this.add(back);
        back.addActionListener(barberSController);
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

    public void setOption(String[] option) {
        this.option = option;
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

    public String getCombo() {
        return combo.getSelectedItem().toString();
    }

}
