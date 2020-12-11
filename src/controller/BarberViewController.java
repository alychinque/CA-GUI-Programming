/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.BarberView;
import view.SetSlots;

/**
 *
 * @author Alysson Chinque
 */
public class BarberViewController implements ActionListener{
    private final BarberView view;
    
    public BarberViewController(BarberView view) {
        this.view = view;
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        switch (e.getActionCommand()) {
            case "setSlots":
                SetSlots setSlots = new SetSlots();
                setSlots.SetSlots(this.view.getValidBarber());
                this.view.dispose();
                break;
                
                
        }
    }
    
}
