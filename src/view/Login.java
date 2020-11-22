/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author Alysson Chinque
 */
public class Login extends JFrame {

    JComboBox combo;
    JPanel left;
    
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
        combo.setSelectedIndex(0);
//        combo.addActionListener((ActionListener) this);
        choice.setBorder(BorderFactory.createLineBorder(Color.orange));
        choice.setBackground(Color.black);
        choice.add(combo);
        choice.setBounds(0, 72, 894, 38);
        this.add(choice);      
        
        //CREATED LEFT PANEL AND STYLED IT
        left = new JPanel();
        left.setLayout(null);
        left.setBackground(Color.black);
        left.setBorder(BorderFactory.createLineBorder(Color.orange));
        left.setBounds(0, 110, 448, 434); 
        
        this.add(left);
        
        // FOOTER PANEL
        JPanel footer = new JPanel();
        JLabel copy = new JLabel("2020© Alysson Chinque");
        footer.setBackground(Color.black);
        footer.setBorder(BorderFactory.createLineBorder(Color.orange));
        copy.setFont(new Font("Arial", Font.PLAIN, 12));
        copy.setForeground(new java.awt.Color(255, 204, 0));
        footer.add(copy);
        this.add(footer, BorderLayout.SOUTH);
        
        this.validate();
        this.repaint();
    }
}
