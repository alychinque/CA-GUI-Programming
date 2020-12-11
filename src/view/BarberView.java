/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.sun.corba.se.impl.ior.NewObjectKeyTemplateBase;
import com.sun.jmx.mbeanserver.Util;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import controller.BarberViewController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import model.Barber;

/**
 *
 * @author Alysson Chinque
 */
public class BarberView extends JFrame implements ActionListener {

    private Barber validBarber;
    JLabel jb;
    String data;
    JDateChooser jDateChooser;
    Date date;

    public void BarberView(Barber validBarber) {
        this.setTitle("Style Barber Shop - Barber");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.validBarber = validBarber;
        BarberViewController barberController = new BarberViewController(this);

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
        myMenu.add(today);
        JMenuItem week = new JMenuItem("Week");
        myMenu.add(week);
        JMenuItem setSlots = new JMenuItem("Set Slots");
        setSlots.addActionListener(barberController);
        setSlots.setActionCommand("setSlots");
        myMenu.add(setSlots);
        JMenuItem logout = new JMenuItem("Logout");
        myMenu.add(logout);

        //MAIN PANEL
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(Color.black);
        main.setBorder(BorderFactory.createLineBorder(Color.orange));
        main.setBounds(0, 72, 894, 449);

        //WELCOME TEXT
        JLabel welcome = new JLabel("Welcome  " + this.validBarber.getFirstName() + "  " + this.validBarber.getSurname());
        welcome.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        welcome.setForeground(new java.awt.Color(255, 204, 0));
        welcome.setBounds(50, 30, 600, 70);
        main.add(welcome);

        jDateChooser = new JDateChooser();
        
//        //SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
//        data = DateFormat.getDateInstance().format(date);
        JButton jb1 = new JButton("send");
        jb1.addActionListener(this);
//    
        jDateChooser.setBounds(50, 100, 250, 20);
//        JXDatePicker picker = new JXDatePicker();
//        picker.setDate(Calendar.getInstance().getTime());
//        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
        main.add(jDateChooser);
        jb = new JLabel("Today ");
        jb.setBounds(200, 330, 100, 20);
        main.add(jb);
        jb1.setBounds(50, 330, 100, 20);
        main.add(jb1);

        this.add(main);

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

    @Override
    public void actionPerformed(ActionEvent e) {
        date = jDateChooser.getDate();
        System.out.println(date);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(formato.format(date));
        jb.setText("Added the day " + formato.format(date));
    }

    public Barber getValidBarber() {
        return validBarber;
    }
    
}
