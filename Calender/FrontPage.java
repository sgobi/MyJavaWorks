package Calender;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FrontPage {

    public static void main(String[] args) {
        JFrame jf = new JFrame("test");
        JPanel main = new JPanel();
        main.setLayout(new BorderLayout());
        JPanel sub = new JPanel();
        sub.setLayout(new GridLayout(2, 1));

        CalenderView cv = new CalenderView();
       
        JButton b1 = new JButton("B1");
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code to be executed when the button is clicked
            
                System.out.println(cv.getDMY()[0] + " "+cv.getDMY()[1]+" "+ cv.getDMY()[2]);
            }
        });

        sub.add(cv.UI());sub.add(b1);
        cv.addDateMonthYear(25, 8, 2025);
        main.add(sub);
        jf.add(main);
        // jf.setSize(200,170); //min size
        // jf.setSize(500,170);//max size
        jf.setSize(500,500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
}