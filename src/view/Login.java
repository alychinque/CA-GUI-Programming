/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

/**
 *
 * @author Alysson Chinque
 */
public class Login extends JFrame{

    JComboBox combo;
    JPanel left;
    JPanel right;
    
    JTextField emailCustomer;
    JPasswordField passCustomer;
    JTextField emailBarber;
    JPasswordField passBarber;

    public void Login() {
        this.setTitle("Style Barber Shop - login");
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

        //CREATED PANEL OF CHOICE
        JPanel choice = new JPanel();
        String[] option = {"CUSTOMER", "BARBER"};
        combo = new JComboBox(option);
        LoginController loginCont = new LoginController(this);
        combo.addActionListener(loginCont);
        combo.setActionCommand("combo");

        choice.setBorder(BorderFactory.createLineBorder(Color.orange));
        choice.setBackground(Color.black);
        choice.add(combo);
        choice.setBounds(0, 72, 894, 38);
        this.add(choice);
                
        //CREATED LEFT PANEL AND STYLED IT
        left = new JPanel();
        left.setVisible(false);
        left.setLayout(null);
        left.setBackground(Color.black);
        left.setBorder(BorderFactory.createLineBorder(Color.orange));
        left.setBounds(0, 110, 448, 434);

        //CUSTOMER LOGIN
        JLabel customer = new JLabel("CUSTOMER");
        customer.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        customer.setForeground(new java.awt.Color(255, 204, 0));
        customer.setBounds(150, 90, 250, 40);
        left.add(customer);

        JLabel emailC = new JLabel("EMAIL:");
        emailC.setBounds(120, 150, 200, 30);
        left.add(emailC);

        emailCustomer = new JTextField(10);
        emailCustomer.setBounds(120, 180, 200, 30);
        left.add(emailCustomer);

        JLabel passC = new JLabel("PASSWORD:");
        passC.setBounds(120, 240, 200, 30);
        left.add(passC);

        passCustomer = new JPasswordField();
        passCustomer.setBounds(120, 270, 200, 30);
        left.add(passCustomer);

        //BUTTON LOGIN CUSTOMER
        JButton loginC = new JButton("LOG IN");
        loginC.setBounds(170, 350, 100, 20);
        loginC.addActionListener(loginCont);
        loginC.setActionCommand("customer");
        left.add(loginC);

        this.add(left);

        //CREATED RIGHT PANEL AND STYLED IT
        right = new JPanel();
        right.setVisible(false);
        right.setLayout(null);
        right.setBackground(Color.black);
        right.setBorder(BorderFactory.createLineBorder(Color.orange));
        right.setBounds(448, 110, 446, 434);

        //BARBER LOGIN
        JLabel barber = new JLabel("BARBER");
        barber.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        barber.setForeground(new java.awt.Color(255, 204, 0));
        barber.setBounds(150, 90, 250, 40);
        right.add(barber);

        JLabel emailB = new JLabel("EMAIL:");
        emailB.setBounds(120, 150, 200, 30);
        right.add(emailB);

        emailBarber = new JTextField(10);
        emailBarber.setBounds(120, 180, 200, 30);
        right.add(emailBarber);

        JLabel passB = new JLabel("PASSWORD:");
        passB.setBounds(120, 240, 200, 30);
        right.add(passB);

        passBarber = new JPasswordField();
        passBarber.setBounds(120, 270, 200, 30);
        right.add(passBarber);
        

        //BUTTON LOGIN BARBER
        JButton loginB = new JButton("LOG IN");
        loginB.setBounds(170, 350, 100, 20);
        loginB.addActionListener(loginCont);
        loginB.setActionCommand("barber");
        right.add(loginB);

        this.add(right);

        //BACKGROUND PANEL
        JPanel background = new JPanel();
        background.setBackground(Color.black);
        background.setBorder(BorderFactory.createLineBorder(Color.orange));
        background.setBounds(0, 110, 894, 434);
        this.add(background);

        // RETURN BUTTON AND FOOTER PANEL
        JButton back = new JButton("BACK");
        back.setBounds(15, 548, 80, 19);
        this.add(back);
        back.addActionListener(loginCont);
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
    
    public void changeVisibilityCustomer(boolean visible){
        left.setVisible(visible);
    }
    
    public void changeVisibilityBarber(boolean visible){
        right.setVisible(visible);
    }

    public String getCombo() {
        return combo.getSelectedItem().toString();
    }
    
    public JTextField getEmailCustomer() {
        return emailCustomer;
    }

    public JPasswordField getPassCustomer() {
        return passCustomer;
    }

    public JTextField getEmailBarber() {
        return emailBarber;
    }

    public JPasswordField getPassBarber() {
        return passBarber;
    }

    public void setEmailCustomer(String emailCustomer) {
        this.emailCustomer.setText(emailCustomer);
    }

    public void setPassCustomer(String passCustomer) {
        this.passCustomer.setText(passCustomer);
    }

    public void setEmailBarber(String emailBarber) {
        this.emailBarber.setText(emailBarber);
    }

    public void setPassBarber(String passBarber) {
        this.passBarber.setText(passBarber);
    }
}
