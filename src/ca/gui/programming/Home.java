package ca.gui.programming;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author alychinque
 */
public class Home  extends JFrame {

    
    public static void main(String[] args) {
        new Home();
    }
    
    public Home(){
         // SET THE HOME WINDOW
        this.setTitle("Style Barber Shop");
        this.setSize(900, 600);
        this.setResizable(false);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        
       //CREATED A PANEL AND A LABEL
        JPanel top = new JPanel();
        JLabel style = new JLabel("STYLE BARBER SHOP");

        //SET HEADER
        top.setBackground(new java.awt.Color(0, 0, 0));
        style.setFont(new Font("Showcard Gothic", Font.PLAIN, 48));
        style.setForeground(new java.awt.Color(255, 204, 0));
        //ADDED LABEL TO PANEL AND PANEL TO FRAME
        top.add(style);
        this.add(top, BorderLayout.PAGE_START);

        
    }
    
}
