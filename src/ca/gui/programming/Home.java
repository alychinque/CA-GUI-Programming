package ca.gui.programming;

import javax.swing.JFrame;

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
    }
    
}
