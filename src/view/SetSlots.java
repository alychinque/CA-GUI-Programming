/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import com.toedter.calendar.JDateChooser;
import controller.SetSlotsController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import model.Barber;

/**
 *
 * @author Alysson Chinque
 */
public class SetSlots extends JFrame {
    private Barber validBarber;
    public JDateChooser jDateChooser;
    
        JCheckBox box9;
        JCheckBox box10;
        JCheckBox box11;
        JCheckBox box12;
        JCheckBox box13;
        JCheckBox box14;
        JCheckBox box15;
        JCheckBox box16;
        JCheckBox box17;
        JCheckBox box18;
        JCheckBox box19;
        JCheckBox all;
        
        JTextArea confirmTextArea;

    public void SetSlots(Barber validBarber) {
        this.setTitle("Style Barber Shop - Barber");
        this.setSize(900, 600);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.validBarber = validBarber;
        SetSlotsController setSlotsController = new SetSlotsController(this);

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

        //MENU ITEMS
        JMenuItem today = new JMenuItem("Today");
        myMenu.add(today);
        today.addActionListener(setSlotsController);
        today.setActionCommand("today");
        myMenu.add(today);
        
        JMenuItem week = new JMenuItem("Week");
        myMenu.add(week);
        week.addActionListener(setSlotsController);
        week.setActionCommand("week");
        myMenu.add(week);
        
        JMenuItem logout = new JMenuItem("Logout");
        myMenu.add(logout);
        logout.addActionListener(setSlotsController);
        logout.setActionCommand("logout");
        myMenu.add(logout);

        //MAIN PANEL
        JPanel main = new JPanel();
        main.setLayout(null);
        main.setBackground(Color.black);
        main.setBorder(BorderFactory.createLineBorder(Color.orange));
        main.setBounds(0, 72, 894, 449);

        //TEXT 
        JLabel instructions = new JLabel("Add the days you are available to work:");
        instructions.setFont(new Font("Showcard Gothic", Font.PLAIN, 28));
        instructions.setForeground(new java.awt.Color(255, 204, 0));
        instructions.setBounds(50, 30, 700, 70);
        main.add(instructions);
        
        JLabel instructions2 = new JLabel("Please choose one day, then choose the hours you are available, then click in add");
        instructions2.setFont(new Font("Arial", Font.PLAIN, 16));
        instructions2.setForeground(new java.awt.Color(255, 204, 0));
        instructions2.setBounds(50, 70, 700, 70);
        main.add(instructions2);
        
        //JDATECHOOSER CREATED TO GET AND ADD DATES THAT BARBERS ARE AVAILABLE
        jDateChooser = new JDateChooser();
        jDateChooser.setBounds(50, 130, 200, 20);
        main.add(jDateChooser);
        
        //HOURS PANEL
        JPanel hoursPanel = new JPanel();
        hoursPanel.setLayout(null);
        hoursPanel.setBackground(Color.black);
        hoursPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        hoursPanel.setBounds(260, 130, 200, 190);
        main.add(hoursPanel);
        
        //LABEL HOURS
        JPanel headHours = new JPanel();
        headHours.setBackground(Color.black);
        headHours.setBorder(BorderFactory.createLineBorder(Color.orange));
        headHours.setBounds(0, 0, 200, 30);
        JLabel hours = new JLabel("Hours");
        hours.setForeground(new java.awt.Color(255, 204, 0));
        headHours.add(hours);
        hoursPanel.add(headHours);
        
        //CHECKBOXES OF HOURS
        box9 = new JCheckBox("9:00");
        box10 = new JCheckBox("10:00");
        box11 = new JCheckBox("11:00");
        box12 = new JCheckBox("12:00");
        box13 = new JCheckBox("13:00");
        box14 = new JCheckBox("14:00");
        box15 = new JCheckBox("15:00");
        box16 = new JCheckBox("16:00");
        box17 = new JCheckBox("17:00");
        box18 = new JCheckBox("18:00");
        box19 = new JCheckBox("19:00");
        all = new JCheckBox("all");
        
        //SET BOUNDS CHECKBOXES
        box9.setBounds(5, 40, 60, 20);
        box10.setBounds(70, 40, 60, 20);
        box11.setBounds(135, 40, 60, 20);
        box12.setBounds(5, 70, 60, 20);
        box13.setBounds(70, 70, 60, 20);
        box14.setBounds(135, 70, 60, 20);
        box15.setBounds(5, 100, 60, 20);
        box16.setBounds(70, 100, 60, 20);
        box17.setBounds(135, 100, 60, 20);
        box18.setBounds(5, 130, 60, 20);
        box19.setBounds(70, 130, 60, 20);
        all.setBounds(135, 130, 60, 20);
        
        //ADD CHECKBOXES
        hoursPanel.add(box9);
        hoursPanel.add(box10);
        hoursPanel.add(box11);
        hoursPanel.add(box12);
        hoursPanel.add(box13);
        hoursPanel.add(box14);
        hoursPanel.add(box15);
        hoursPanel.add(box16);
        hoursPanel.add(box17);
        hoursPanel.add(box18);
        hoursPanel.add(box19);
        hoursPanel.add(all);
        
        //IF ALL IS SELECTED ALL BECOME TRUE IF IS NOT ALL BECOME FALSE
        all.addItemListener((ItemEvent e) -> {
            if(all.isSelected()){
                box9.setSelected(true);
                box10.setSelected(true);
                box11.setSelected(true);
                box12.setSelected(true);
                box13.setSelected(true);
                box14.setSelected(true);
                box15.setSelected(true);
                box16.setSelected(true);
                box17.setSelected(true);
                box18.setSelected(true);
                box19.setSelected(true);
            }else{
                box9.setSelected(false);
                box10.setSelected(false);
                box11.setSelected(false);
                box12.setSelected(false);
                box13.setSelected(false);
                box14.setSelected(false);
                box15.setSelected(false);
                box16.setSelected(false);
                box17.setSelected(false);
                box18.setSelected(false);
                box19.setSelected(false);
            }
        });
              
        //BUTTON TO ADD DATES
        JButton add = new JButton("ADD");
        add.setBounds(470, 205, 70, 20);
        main.add(add);
        this.add(main);
        
        //ACTION LISTENER
        add.addActionListener(setSlotsController);
        add.setActionCommand("add");
        
        //LABEL CONFIRMATION
        JPanel headConfirmation = new JPanel();
        headConfirmation.setBackground(Color.black);
        headConfirmation.setBorder(BorderFactory.createLineBorder(Color.orange));
        headConfirmation.setBounds(550, 130, 300, 30);
        JLabel confirmation = new JLabel("Confirmation");
        confirmation.setForeground(new java.awt.Color(255, 204, 0));
        headConfirmation.add(confirmation);
        main.add(headConfirmation);
        
        //CONFIRMATION PANEL
        JPanel confirmPanel = new JPanel();
        confirmPanel.setBackground(Color.black);
        confirmPanel.setBorder(BorderFactory.createLineBorder(Color.orange));
        confirmPanel.setBounds(550, 160, 300, 30);
        main.add(confirmPanel);
        JPanel ConfirmArea = new JPanel();
        ConfirmArea.setBackground(Color.black);
        ConfirmArea.setBorder(BorderFactory.createLineBorder(Color.orange));
        ConfirmArea.setBounds(550, 190, 300, 250);
        confirmTextArea = new JTextArea();
        ConfirmArea.add(confirmTextArea);
        main.add(ConfirmArea);

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
    //methods getters
    public Barber getValidBarber() {
        return validBarber;
    }

    public JDateChooser getjDateChooser() {
        return jDateChooser;
    }

    public boolean getBox9() {
        return box9.isSelected();
    }

    public boolean getBox10() {
        return box10.isSelected();
    }

    public boolean getBox11() {
        return box11.isSelected();
    }

    public boolean getBox12() {
        return box12.isSelected();
    }

    public boolean getBox13() {
        return box13.isSelected();
    }

    public boolean getBox14() {
        return box14.isSelected();
    }

    public boolean getBox15() {
        return box15.isSelected();
    }

    public boolean getBox16() {
        return box16.isSelected();
    }

    public boolean getBox17() {
        return box17.isSelected();
    }

    public boolean getBox18() {
        return box18.isSelected();
    }

    public boolean getBox19() {
        return box19.isSelected();
    }

    public boolean getAll() {
        return all.isSelected();
    }
    public JTextArea getConfirmTextArea() {
        return confirmTextArea;
    }
}
