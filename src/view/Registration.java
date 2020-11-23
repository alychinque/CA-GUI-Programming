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
        JLabel style = new JLabel("STYLE BARBER SHOP - registration");

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
