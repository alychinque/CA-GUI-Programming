/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.RegistrationController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alysson Chinque
 */
public class Registration extends JFrame {

    JPanel barberSection;
    JButton registerCust;
    JButton registerBarber;
    
    JTextField fullName;
    JTextField phone;
    JTextField email;
    JPasswordField password;
    JPasswordField passwordConfirm;
    
    JTextField barberShop;
    JTextField address;
    JComboBox combo;

    public void Registration() {
        this.setTitle("Style Barber Shop - registration");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        RegistrationController regController = new RegistrationController(this);

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

        //CREATED PANEL REGISTRATION
        JPanel choice = new JPanel();
        JLabel text = new JLabel("REGISTRATION");
        text.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        text.setForeground(new java.awt.Color(255, 204, 0));
        choice.setBorder(BorderFactory.createLineBorder(Color.orange));
        choice.setBackground(Color.black);
        choice.add(text);

        choice.setBounds(0, 72, 894, 45);
        this.add(choice);

        //MAIN PANEL
        JPanel main = new JPanel();
        main.setBackground(Color.black);
        main.setBorder(BorderFactory.createLineBorder(Color.orange));
        main.setBounds(0, 110, 894, 434);
        main.setLayout(null);

        JLabel fullNameL = new JLabel("FULL NAME:");
        fullNameL.setForeground(new java.awt.Color(255, 204, 0));
        fullNameL.setBounds(150, 56, 200, 25);
        main.add(fullNameL);
        fullName = new JTextField();
        fullName.setBounds(250, 56, 400, 25);
        main.add(fullName);

        JLabel phoneL = new JLabel("PHONE:");
        phoneL.setForeground(new java.awt.Color(255, 204, 0));
        phoneL.setBounds(150, 97, 200, 25);
        main.add(phoneL);
        phone = new JTextField();
        phone.setBounds(250, 97, 400, 25);
        main.add(phone);

        JLabel emailL = new JLabel("EMAIL:");
        emailL.setForeground(new java.awt.Color(255, 204, 0));
        emailL.setBounds(150, 138, 200, 25);
        main.add(emailL);
        email = new JTextField();
        email.setBounds(250, 138, 400, 25);
        main.add(email);

        JLabel passwordL = new JLabel("PASSWORD:");
        passwordL.setForeground(new java.awt.Color(255, 204, 0));
        passwordL.setBounds(150, 179, 200, 25);
        main.add(passwordL);
        password = new JPasswordField();
        password.setBounds(250, 179, 400, 25);
        main.add(password);
        
        JLabel passwordLConfirm = new JLabel("CONFIRM PASSWORD:");
        passwordLConfirm.setForeground(new java.awt.Color(255, 204, 0));
        passwordLConfirm.setBounds(100, 220, 200, 25);
        main.add(passwordLConfirm);
        passwordConfirm = new JPasswordField();
        passwordConfirm.setBounds(250, 220, 400, 25);
        main.add(passwordConfirm);

        //RADIO BUTTON TO SELECT BABER OR CUSTOMER
        JRadioButton customer = new JRadioButton("CUSTOMER");
        customer.setBounds(670, 220, 100, 15);
        customer.setSelected(true);
        customer.setBackground(Color.black);
        customer.setForeground(new java.awt.Color(255, 204, 0));
        customer.addActionListener(regController);
        customer.setActionCommand("customer");
        JRadioButton barber = new JRadioButton("BARBER");
        barber.addActionListener(regController);
        barber.setActionCommand("barber");
        barber.setBounds(770, 220, 100, 15);
        barber.setBackground(Color.black);
        barber.setForeground(new java.awt.Color(255, 204, 0));
        ButtonGroup group = new ButtonGroup();
        group.add(customer);
        group.add(barber);
        main.add(customer);
        main.add(barber);
        
        registerCust = new JButton("REGISTER CUSTOMER");
        registerCust.setBounds(360, 395, 180, 30);
        registerCust.addActionListener(regController);
        registerCust.setActionCommand("registerCust");
        main.add(registerCust);

        //BARBER SECTION
        barberSection = new JPanel();
        barberSection.setBounds(4, 260, 886, 174);
        barberSection.setBackground(Color.black);
        barberSection.setLayout(null);
        barberSection.setVisible(false);

        JLabel barberShopL = new JLabel("BARBERSHOP:");
        barberShopL.setForeground(new java.awt.Color(255, 204, 0));
        barberShopL.setBounds(146, 5, 200, 27);
        barberSection.add(barberShopL);
        barberShop = new JTextField();
        barberShop.setBounds(246, 5, 400, 27);
        barberSection.add(barberShop);

        JLabel addressL = new JLabel("ADDRESS:");
        addressL.setForeground(new java.awt.Color(255, 204, 0));
        addressL.setBounds(146, 52, 200, 27);
        barberSection.add(addressL);
        address = new JTextField();
        address.setBounds(246, 52, 400, 27);
        barberSection.add(address);

        JLabel locationL = new JLabel("LOCATION:");
        locationL.setForeground(new java.awt.Color(255, 204, 0));
        locationL.setBounds(146, 99, 200, 27);
        barberSection.add(locationL);
        String[] option = {"Dublin1", "Dublin2", "Dublin3", "Dublin4",
            "Dublin5", "Dublin6", "Dublin7", "Dublin8",
            "Dublin9", "Dublin10", "Dublin11", "Dublin12",
            "Dublin13", "Dublin14", "Dublin15", "Dublin16",
            "Dublin17", "Dublin18", "Dublin19", "Dublin20",
            "Dublin21", "Dublin22", "Dublin23", "Dublin24",};
        combo = new JComboBox(option);
        combo.addActionListener(regController);
        combo.setActionCommand("combo");
        combo.setBounds(246, 99, 400, 27);
        barberSection.add(combo);

        registerBarber = new JButton("REGISTER BARBER");
        registerBarber.setBounds(360, 135, 180, 30);
        barberSection.add(registerBarber);
        registerBarber.addActionListener(regController);
        registerBarber.setActionCommand("registerBarber");

        main.add(barberSection);

        this.add(main);

        // RETURN BUTTON AND FOOTER PANEL
        JButton back = new JButton("BACK");
        back.setBounds(15, 548, 80, 19);
        this.add(back);
        back.addActionListener(regController);
        back.setActionCommand("back");

        JPanel footer = new JPanel();
        JLabel copy = new JLabel("2020© Alysson Chinque");
        footer.setBackground(Color.black);
        footer.setBorder(BorderFactory.createLineBorder(Color.orange));
        copy.setFont(new Font("Arial", Font.PLAIN, 12));
        copy.setForeground(new java.awt.Color(255, 204, 0));
        footer.add(copy);
        footer.setBounds(0, 544, 894, 27);
        this.add(footer);

        this.validate();
        this.repaint();
    }

    public void setRegisterCust(boolean registerCust) {
        this.registerCust.setVisible(registerCust);
    }


    public void setBarberSection(boolean barberSection) {
        this.barberSection.setVisible(barberSection);
        
    }

    public JTextField getFullName() {
        return fullName;
    }

    public void setFullName (JTextField fullName) {
        this.fullName = fullName;
    }

    public JTextField getPhone() {
        return phone;
    }

    public void setPhone(JTextField phone) {
        this.phone = phone;
    }

    public JTextField getEmail() {
        return email;
    }

    public void setEmail(JTextField email) {
        this.email = email;
    }

    public JTextField getPassword() {
        return password;
    }

    public void setPassword(JPasswordField password) {
        this.password = password;
    }

    public JTextField getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(JPasswordField passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public JTextField getBarberShop() {
        return barberShop;
    }

    public void setBarberShop(JTextField barberShop) {
        this.barberShop = barberShop;
    }

    public JTextField getAddress() {
        return address;
    }

    public void setAddress(JTextField address) {
        this.address = address;
    }

    public String getCombo() {
        return combo.getSelectedItem().toString();
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }
    
}
