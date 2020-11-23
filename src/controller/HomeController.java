/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.Home;
import view.Login;

/**
 *
 * @author alych
 */
public class HomeController implements ActionListener {
    private final Home view;

    public HomeController(Home view) {
        this.view = view;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getActionCommand().equals("login")) {
            this.view.setVisible(false);
            Login lg = new Login();
            lg.Login();
//        }else if(e.getActionCommand().equals("reg")){
//            home.setVisible(false);
//            Register reg = new Register();
//            reg.Register();
        }
    }
    
}
