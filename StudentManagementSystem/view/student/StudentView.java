
package StudentManagementSystem.view.student;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class StudentView implements ActionListener {
    JFrame jf; 
    JPanel mainpanel,uppanel, topuppanel,middlepanel,topmiddlepanel,downpanel,topdownpanel,genderpanel,textAreaPanel,GtextAreaPanel;

    JLabel LblFName,LblLname,LblAddress,LblTpNo,LblDob,LblRegNo,LblGname,LblGAddress,LblGMobileNo,emptylbl1,emptylbl2;
    JTextField JtfFName,JtfLname,JtfTpNo,JtfGname,JtfGMobileNo;
    JTextArea JtaAddress,JtfGAddress;
    JComboBox<String> JcbRegNo ;
    JButton JbAdd,JbUpdate,JbDelete,JbExit;


    JRadioButton JrbMale,JrbFemale;
    public StudentView()
    {
      jf= new JFrame("Student Deatils");

    //*********
    // Create a SpinnerDateModel to define date range and step
    SpinnerDateModel dateModel = new SpinnerDateModel(new Date(), null, null, Calendar.DAY_OF_MONTH);
    JSpinner dateSpinner = new JSpinner(dateModel);

    // Customize the editor to display the date in a specific format
    JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd");
    dateSpinner.setEditor(dateEditor);

    JButton getSelectedDateButton = new JButton("Get Selected Date");
    getSelectedDateButton.addActionListener(e -> {
        Date selectedDate = (Date) dateSpinner.getValue();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        JOptionPane.showMessageDialog(jf, "Selected Date: " + sdf.format(selectedDate));
    });
    
    //***************** */



      mainpanel= new JPanel(new BorderLayout());

      // uppanel = new JPanel(new GridLayout(2,4,2,2));
       uppanel = new JPanel(new BorderLayout(20,20));// new FlowLayout(FlowLayout.CENTER));
       uppanel.setBorder(new TitledBorder("Personal Infomartion"));
       topuppanel = new JPanel(new GridLayout(4,4,10,10));

      middlepanel = new JPanel(new BorderLayout(20,20));
      middlepanel.setBorder(new TitledBorder("Gurdian Infomartion"));
      topmiddlepanel = new JPanel(new GridLayout(2,4,10,10));


      downpanel = new JPanel(new BorderLayout(20,20));
      // downpanel.setBorder(new TitledBorder());
      topdownpanel = new JPanel(new GridLayout(2,6,10,10));


      genderpanel= new JPanel(new GridLayout(1,2,10,10));
      genderpanel.setBorder(new TitledBorder("Gender"));

       JrbMale = new JRadioButton("Male");
       JrbFemale = new JRadioButton("Female");
       genderpanel.add(JrbMale);
       genderpanel.add(JrbFemale);
       ButtonGroup genderGroup = new ButtonGroup();
       genderGroup.add(JrbMale);
       genderGroup.add(JrbFemale);

       LblFName =new JLabel("First Name");
       LblLname=new JLabel("Last Name");;
       LblAddress=new JLabel("Residence Address");
       LblTpNo = new JLabel("Mobile Number");
       LblDob = new JLabel("Date Of Birth");
       LblRegNo = new JLabel("RegNo");


       LblGname =  new JLabel("Gardian Name");
       LblGAddress = new JLabel("Gardian Address");
       LblGMobileNo = new JLabel("Gardian Mobile No");
    //testing ----------------------------
    String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
    
JcbRegNo = new JComboBox<>(items);



    //-------------------
      JtfGname =  new JTextField(15); 
      JtfGMobileNo = new JTextField(15); 
       JtfGAddress = new JTextArea(2,15);
       GtextAreaPanel = new JPanel(new BorderLayout());
       GtextAreaPanel.add(new JScrollPane(JtfGAddress));


       JtfFName =new JTextField(15); 
       JtfLname =new JTextField(15);
       JtaAddress = new JTextArea(2,15);
       textAreaPanel = new JPanel(new BorderLayout());
       textAreaPanel.add(new JScrollPane(JtaAddress));
       JtfTpNo= new JTextField(15);


        JbAdd = new JButton("ADD");JbUpdate  = new JButton("UPDATE");JbDelete  = new JButton("DELETE");
        JbExit = new JButton("EXIT");
       
       topuppanel.add(LblRegNo); topuppanel.add(JcbRegNo);topuppanel.add(new JLabel()); topuppanel.add(new JLabel()); 
       topuppanel.add(LblFName); topuppanel.add(JtfFName);topuppanel.add(LblTpNo); topuppanel.add(JtfTpNo); 
       topuppanel.add(LblLname); topuppanel.add(JtfLname);  topuppanel.add(LblDob); topuppanel.add(dateSpinner); 
       topuppanel.add(LblAddress);topuppanel.add(textAreaPanel);        topuppanel.add(new JLabel()) ;    topuppanel.add(genderpanel) ;
       uppanel.add(topuppanel,BorderLayout.NORTH);

       topmiddlepanel.add(LblGname);topmiddlepanel.add(JtfGname); topmiddlepanel.add(LblGMobileNo);topmiddlepanel.add(JtfGMobileNo);
      topmiddlepanel.add(LblGAddress);topmiddlepanel.add(GtextAreaPanel);
      topmiddlepanel.add(new JLabel() ); topmiddlepanel.add(new JLabel());//for empy


      middlepanel.add(topmiddlepanel,BorderLayout.NORTH);
      topdownpanel.add(new JLabel() ); topdownpanel.add(JbAdd);topdownpanel.add(JbUpdate);topdownpanel.add(JbDelete);
      topdownpanel.add(JbExit );  topdownpanel.add(new JLabel() ); 


      topdownpanel.add(new JLabel() );  topdownpanel.add(new JLabel() );  topdownpanel.add(new JLabel() );  topdownpanel.add(new JLabel() ); 
      topdownpanel.add(new JLabel() );   topdownpanel.add(new JLabel() ); 
      downpanel.add(topdownpanel,BorderLayout.CENTER);
           
  

 mainpanel.add(uppanel,BorderLayout.NORTH);
mainpanel.add(middlepanel,BorderLayout.CENTER);
 mainpanel.add(downpanel,BorderLayout.SOUTH);


JcbRegNo.addActionListener(this);
JbExit.addActionListener(this);

      jf.add(mainpanel);

      jf.setSize(750, 250);
      jf.setLocation(250,100);
       jf.pack();
      jf.setVisible(true);
   
    }
    public  void StudentDeatilsView()
    {
       new StudentView();
    }
    @Override
    public void actionPerformed(ActionEvent e) {

      if(e.getSource()==JcbRegNo){
     JOptionPane.showMessageDialog(null, JcbRegNo.getSelectedIndex(), null, 0);
      }

      if(e.getSource()==JbExit){
        System.exit(0);
         }
    }
        
}
