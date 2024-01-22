package Calender;

import javax.swing.*;
import java.awt.*;

public class FrontPage {

    public static void main(String[] args) {
        JFrame jf = new JFrame("Calendar");
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());

        JPanel sub = new JPanel();
        sub.setLayout(new FlowLayout()); // Use FlowLayout instead of GridLayout

        CalenderView cv = new CalenderView();

        JButton b1 = new JButton("Get DD MM YYYY ");

        // Set preferred size for the button
        // Dimension buttonSize = new Dimension(150, 30);
        // b1.setPreferredSize(buttonSize);

        b1.addActionListener(e -> {
            // Code to be executed when the button is clicked
            System.out.println(cv.getDMY()[0] + " " + cv.getDMY()[1] + " " + cv.getDMY()[2]);
        });

        sub.add(cv.UI());
        sub.add(b1);
        cv.addDateMonthYear(25, 8, 2025);
        main.add(sub);
        jf.getContentPane().add(main);
      
    
        jf.setSize(450, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setVisible(true);
    }
}