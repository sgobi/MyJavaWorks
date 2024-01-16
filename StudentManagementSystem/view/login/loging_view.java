package StudentManagementSystem.view.login;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class loging_view {
    JFrame jf ;
 loging_view()
{



}

public void loging_textboxes_buttons(){
    jf = new JFrame("Loging");

    JPanel mainPanel = new JPanel();
    mainPanel.setLayout(new BorderLayout());


    JPanel groupBoxPanel = new JPanel();

    groupBoxPanel.setLayout(new BorderLayout( )); 
    groupBoxPanel.setBorder(new TitledBorder("Loging"));
     groupBoxPanel.setPreferredSize(new Dimension(400, 150));


    JPanel attributes_grid = new JPanel();

    attributes_grid.setLayout(new GridLayout());

JLabel lbl_u_name = new JLabel();
lbl_u_name.setText("User Name");
// lbl_u_name.setBounds(100, 50,150, 30);

JTextField jtf_u_name = new JTextField();
// jtf_u_name.setBounds(200, 50,150, 30);

JLabel lbl_password = new JLabel();
lbl_password.setText("Password");
// lbl_password.setBounds(100, 100, 150, 30);

JTextField jtf__password = new JTextField();
// jtf__password.setBounds(200, 100, 150, 30);

    JButton btn_loging = new JButton();
    btn_loging.setText("Loging");
    // btn_loging.setBounds(100, 150, 150, 30);

    JButton btn_exit = new JButton();
    btn_exit.setText("Exit");
    // btn_exit.setBounds(300, 150, 150, 30);

    JPanel groupBoxPanel2 = new JPanel();
    groupBoxPanel2.setLayout(new BorderLayout()); 


    groupBoxPanel2.add(lbl_u_name);
    groupBoxPanel2.add(jtf_u_name);
    groupBoxPanel2.add(lbl_password);
    groupBoxPanel2.add(jtf__password);
    groupBoxPanel2.add(btn_loging);
    groupBoxPanel2.add(btn_exit);
groupBoxPanel2.setLayout(new GridLayout(3, 2));

groupBoxPanel.add(groupBoxPanel2);

    mainPanel.add(groupBoxPanel, BorderLayout.CENTER);

    jf.setContentPane(mainPanel);
  //  jf.setSize(500,250);
    jf.pack();
    jf.setVisible(true);
    jf.setLocation(500,250);
}

    public static void main(String[] args) {
        loging_view lv = new loging_view();
        lv.loging_textboxes_buttons();
    }
 
}