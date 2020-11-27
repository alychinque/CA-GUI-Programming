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
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alysson Chinque
 */
public class Registration extends JFrame {

    JComboBox combo;
    JPanel barberSection;

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

        //CREATED PANEL OF CHOICE
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

        JLabel firstNameL = new JLabel("FIRST NAME:");
        firstNameL.setBounds(150, 32, 200, 27);
        main.add(firstNameL);
        JTextField firstName = new JTextField();
        firstName.setBounds(250, 32, 400, 27);
        main.add(firstName);

        JLabel surnameL = new JLabel("SURNAME:");
        surnameL.setBounds(150, 79, 200, 27);
        main.add(surnameL);
        JTextField surname = new JTextField();
        surname.setBounds(250, 79, 400, 27);
        main.add(surname);

        JLabel phoneL = new JLabel("PHONE:");
        phoneL.setBounds(150, 126, 200, 27);
        main.add(phoneL);
        JTextField phone = new JTextField();
        phone.setBounds(250, 126, 400, 27);
        main.add(phone);

        JLabel emailL = new JLabel("EMAIL:");
        emailL.setBounds(150, 173, 200, 27);
        main.add(emailL);
        JTextField email = new JTextField();
        email.setBounds(250, 173, 400, 27);
        main.add(email);

        JLabel passwordL = new JLabel("PASSWORD:");
        passwordL.setBounds(150, 220, 200, 27);
        main.add(passwordL);
        JTextField password = new JTextField();
        password.setBounds(250, 220, 400, 27);
        main.add(password);

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

        //BARBER SECTION
        barberSection = new JPanel();
        barberSection.setBounds(4, 260, 886, 134);
        barberSection.setBackground(Color.black);
        barberSection.setLayout(null);
        barberSection.setVisible(false);

        JLabel barberShopL = new JLabel("BARBERSHOP:");
        barberShopL.setBounds(146, 5, 200, 27);
        barberSection.add(barberShopL);
        JTextField barberShop = new JTextField();
        barberShop.setBounds(246, 5, 400, 27);
        barberSection.add(barberShop);

        JLabel addressL = new JLabel("ADDRESS:");
        addressL.setBounds(146, 52, 200, 27);
        barberSection.add(addressL);
        JTextField address = new JTextField();
        address.setBounds(246, 52, 400, 27);
        barberSection.add(address);

        JLabel locationL = new JLabel("LOCATION:");
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

        JButton register = new JButton("REGISTER");
        register.setBounds(400, 395, 100, 30);
        main.add(register);

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

    public JPanel getBarberSection() {
        return barberSection;
    }

    public void setBarberSection(boolean barberSection) {
        this.barberSection.setVisible(barberSection);
    }
}
