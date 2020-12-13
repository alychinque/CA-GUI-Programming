/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import view.SetSlots;

/**
 *
 * @author Alysson Chinque
 */
public class SetSlotsController implements ActionListener {

    private final SetSlots view;
    private JDateChooser jDateChooser;
    Date date;
    private ArrayList<String> times;

    public SetSlotsController(SetSlots view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        switch (e.getActionCommand()) {
            case "add":
                if (this.view.getAll()) {
                    
                    times = new ArrayList<String>();
                    times.add("1"+"2"+"3"+"4"+"5");
                    times.add("10:00");
                    times.add("11:00");
                    times.add("12:00");
                    times.add("13:00");
                    times.add("14:00");
                    times.add("15:00");
                    times.add("16:00");
                    times.add("17:00");
                    times.add("18:00");
                    times.add("18:00");

                    date = view.jDateChooser.getDate();
                    System.out.println(times);
                    System.out.println(date);
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    System.out.println(formato.format(date));
                    this.view.getConfirmTextArea().setText("Added the day " + formato.format(date));
                    System.out.println(times.get(0));
                    break;
                } else {
                    if (view.getBox9()){times.add("9:00");}
                    
                }
                break;
        }
    }

}
