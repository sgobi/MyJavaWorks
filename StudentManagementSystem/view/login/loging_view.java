package StudentManagementSystem.view.login;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class loging_view {
    JFrame jf ;
 loging_view()
{

   jf = new JFrame("Loging");
    jf.setSize(500,250);

}

public void loging_textboxes_buttons(){

JLabel lbl_u_name = new JLabel();
lbl_u_name.setText("User Name");
lbl_u_name.setBounds(100, 50,150, 30);

JLabel lbl_password = new JLabel();
lbl_password.setText("Password");
lbl_password.setBounds(100, 100, 150, 30);

JTextField jtf_u_name = new JTextField();
jtf_u_name.setBounds(200, 50,150, 30);

JTextField jtf__password = new JTextField();
jtf__password.setBounds(200, 100, 150, 30);

    JButton btn_loging = new JButton();
    btn_loging.setText("Loging");
    btn_loging.setBounds(100, 150, 150, 30);

    JButton btn_exit = new JButton();
    btn_exit.setText("Exit");
    btn_exit.setBounds(300, 150, 150, 30);



    jf.add(lbl_u_name);
    jf.add(jtf_u_name);
    jf.add(lbl_password);
    jf.add(jtf__password);
    jf.add(btn_loging);
    jf.add(btn_exit);

    jf.setLayout(null);
    jf.setVisible(true);
}

    public static void main(String[] args) {
        loging_view lv = new loging_view();
        lv.loging_textboxes_buttons();
    }
 
}