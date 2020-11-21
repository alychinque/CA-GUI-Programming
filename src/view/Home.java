package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author alychinque
 */
public class Home extends JFrame {

    public static void main(String[] args) {
        new Home();
    }

    public Home() {
        // SET THE HOME WINDOW
        this.setTitle("Style Barber Shop");
        this.setSize(900, 600);
        this.setResizable(false);
        this.setVisible(true);
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

        // MAIN PANEL
        JPanel main = new JPanel();
        GridLayout mainLayout = new GridLayout(1,2);
        main.setLayout(mainLayout);

        // LEFT PANEL
        JPanel left = new JPanel();
        
        GridLayout lLayout = new GridLayout(4, 1);
        left.setLayout(lLayout);
        
        left.setBackground(Color.black);
        left.setBorder(BorderFactory.createLineBorder(Color.orange));  
        
        // LINES OF LEFT PANEL
        JLabel emp = new JLabel();
        left.add(emp);
        JLabel newPeople = new JLabel("                 ARE YOU NEW HERE?");
        newPeople.setFont(new Font("Showcard Gothic", Font.PLAIN, 26));
        newPeople.setForeground(new java.awt.Color(255, 204, 0));
        left.add(newPeople, BorderLayout.CENTER);
        JLabel empty = new JLabel();
        left.add(empty);
        JPanel but = new JPanel();
        JButton reg = new JButton("REGISTER");
        but.setBackground(Color.black);
        but.add(reg, BorderLayout.CENTER);
        left.add(but);
        
        main.add(left);
        
        // RIGHT PANEL
        JPanel right = new JPanel();
        
        GridLayout rLayout = new GridLayout(4, 1);
        right.setLayout(rLayout);
        
        right.setBackground(Color.black);
        right.setBorder(BorderFactory.createLineBorder(Color.orange));
        
        // LINES OF RIGHT PANEL
        JLabel emp0 = new JLabel();
        right.add(emp0);
        JLabel oldPeople = new JLabel("                   NO... SO LET'S LOG IN");
        oldPeople.setFont(new Font("Showcard Gothic", Font.PLAIN, 26));
        oldPeople.setForeground(new java.awt.Color(255, 204, 0));
        right.add(oldPeople, BorderLayout.CENTER);
        JLabel emp1 = new JLabel();
        right.add(emp1);
        JPanel but0 = new JPanel();
        JButton log = new JButton("LOG IN");
        but0.setBackground(Color.black);
        but0.add(log, BorderLayout.CENTER);
        right.add(but0);
        
        main.add(right);
        
        // BOTTOM PANEL
        JPanel bottom = new JPanel();
        JLabel b = new JLabel("2020© Alysson Chinque");

        bottom.setBackground(Color.black);
        bottom.setBorder(BorderFactory.createLineBorder(Color.orange));
        b.setFont(new Font("Arial", Font.PLAIN, 12));
        b.setForeground(new java.awt.Color(255, 204, 0));
        
        bottom.add(b);
        this.add(bottom, BorderLayout.SOUTH);

        this.add(main);
        
        this.validate();
        this.repaint();

    }

}
