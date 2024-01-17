package Calender;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Console;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;
public class CalenderView extends JFrame {
    DefaultTableModel model;
  Calendar cal = new GregorianCalendar();
  JLabel label;


  CalenderView(){

    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Swing Calandar");
    this.setSize(300,140);
    this.setLayout(new BorderLayout());
    this.setVisible(true);



    label = new JLabel();
    label.setHorizontalAlignment(SwingConstants.CENTER);
 
    JButton b1 = new JButton("<-");
    b1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        cal.add(Calendar.MONTH, -1);
        updateMonth();
      }
    });
 
    JButton b2 = new JButton("->");
    b2.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent ae) {
        cal.add(Calendar.MONTH, +1);
        updateMonth();
      }
    });
 JPanel mainpanel = new JPanel();
 mainpanel.setLayout(new BorderLayout());
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(b1,BorderLayout.WEST);
    panel.add(label,BorderLayout.CENTER);
    panel.add(b2,BorderLayout.EAST);
 
 
    String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    model = new DefaultTableModel(null,columns);
    JTable table = new JTable(model);

     // Disable editing for all cells
     table.setDefaultEditor(Object.class, null);
            // Set cell selection mode to allow selecting individual cells
     table.setCellSelectionEnabled(true);


     // Add a ListSelectionListener to the table's selection model
            table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (!e.getValueIsAdjusting()) {
                        int selectedRow = table.getSelectedRow();
                        int selectedColumn = table.getSelectedColumn();

                        if (selectedRow != -1 && selectedColumn != -1) {
                            Object selectedValue = table.getValueAt(selectedRow, selectedColumn);
                            //JOptionPane.showMessageDialog(null, "Selected Cell Value: " + selectedValue);
                            // System.out.println(selectedRow +"  "+ selectedColumn);
                            
                              
                      
                         System.out.print(selectedValue);
                          System.out.print(  updateMonth()[0]);
                          System.out.println(  updateMonth()[1]);

                            
                        
                        }
                    }
                }
            });
    JScrollPane pane = new JScrollPane(table);
 
    // this.add(panel,BorderLayout.NORTH);
    // this.add(pane,BorderLayout.CENTER);
    mainpanel.add(panel,BorderLayout.NORTH);
    mainpanel.add(pane,BorderLayout.NORTH);
 this.add(mainpanel);




 
    this.updateMonth();

  }
    // Method to set a specific date
    public void setDate(int day, int month, int year) {
      cal.set(year, month - 1, day); // Month is 0-based, so subtract 1
      updateMonth();
  }


  Object[] updateMonth() {
    cal.set(Calendar.DAY_OF_MONTH, 1);
 
    String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
    int year = cal.get(Calendar.YEAR);
    label.setText(month + " " + year);
 
    int startDay = cal.get(Calendar.DAY_OF_WEEK);
    int numberOfDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
    int weeks = cal.getActualMaximum(Calendar.WEEK_OF_MONTH);
 
    model.setRowCount(0);
    model.setRowCount(weeks);
 
    int i = startDay-1;
    for(int day=1;day<=numberOfDays;day++){
      model.setValueAt(day, i/7 , i%7 );    
      i = i + 1;
    }
    Object[] deatils= {month,year};
 return deatils;
  }
  public static void main(String[] arguments) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    CalenderView sc = new CalenderView();
    sc.setDate(14,12,2004);
  }
}
