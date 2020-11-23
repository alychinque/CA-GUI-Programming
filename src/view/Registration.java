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
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alysson Chinque
 */
public class Registration extends JFrame {

    JComboBox combo;
    JPanel right;
    JPanel left;

    public String getCombo() {
        return combo.getSelectedItem().toString();
    }

    public void setCombo(JComboBox combo) {
        this.combo = combo;
    }

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

        //BACKGROUND PANEL
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
        
        JLabel barberShopL = new JLabel("BARBERSHOP:");
        barberShopL.setBounds(150, 267, 200, 27);
        main.add(barberShopL);
        JTextField barberShop = new JTextField();
        barberShop.setBounds(250, 267, 400, 27);
        main.add(barberShop);
        
        JLabel addressL = new JLabel("ADDRESS:");
        addressL.setBounds(150, 314, 200, 27);
        main.add(addressL);
        JTextField address = new JTextField();
        address.setBounds(250, 314, 400, 27);
        main.add(address);
        
        JLabel locationL = new JLabel("LOCATION:");
        locationL.setBounds(150, 361, 200, 27);
        main.add(locationL);
        JTextField location = new JTextField();
        location.setBounds(250, 361, 400, 27);
        main.add(location);
        
        
        
        
        JButton register = new JButton("REGISTER");
        register.setBounds(400, 395, 100, 30);
        main.add(register);
        
        
        
        
        
        
        
        
        
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
}
