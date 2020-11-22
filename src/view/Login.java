/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author alych
 */
public class Login extends JFrame {

    public void Login() {
        this.setTitle("Style Barber Shop - login");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        BorderLayout frameLayout = new BorderLayout();
        this.setLayout(frameLayout);

        //CREATED A PANEL AND A LABEL
        JPanel top = new JPanel();
        JLabel style = new JLabel("STYLE BARBER SHOP");

        //SET HEADER
        top.setBackground(Color.black);
        top.setBorder(BorderFactory.createLineBorder(Color.orange));
        style.setFont(new Font("Showcard Gothic", Font.PLAIN, 48));
        style.setForeground(new java.awt.Color(255, 204, 0));
        //ADDED LABEL TO PANEL AND PANEL TO FRAME
        top.add(style);
        this.add(top, BorderLayout.PAGE_START);
        
        //CREATED PANEL OF CHOICE
        JPanel choice = new JPanel();
        JComboBox combo;
        String[] option = {"CUSTOMER", "BARBER"};
        combo = new JComboBox(option);
//        combo.addActionListener((ActionListener) this);
        choice.setBorder(BorderFactory.createLineBorder(Color.orange));
        choice.setBackground(Color.black);
        choice.add(combo);
        this.add(choice, BorderLayout.CENTER);
        
        // BOTTOM PANEL
        JPanel bottom = new JPanel();
        JLabel copy = new JLabel("2020© Alysson Chinque");

        bottom.setBackground(Color.black);
        bottom.setBorder(BorderFactory.createLineBorder(Color.orange));
        copy.setFont(new Font("Arial", Font.PLAIN, 12));
        copy.setForeground(new java.awt.Color(255, 204, 0));
        
        bottom.add(copy);
        this.add(bottom, BorderLayout.SOUTH);
        
        this.validate();
        this.repaint();
    }
}
