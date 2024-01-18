//REf : https://www.javacodex.com/Swing/Swing-Calendar

package Calender;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;


public class CalenderView extends JFrame {
    DefaultTableModel model;
  Calendar cal = new GregorianCalendar();
  JLabel label;
  int selectedRow, selectedColumn;
  JTable table;



  CalenderView(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setTitle("Swing Calandar");
    this.setSize(300,200);
    this.setLayout(new BorderLayout());
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
    JPanel panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(b1,BorderLayout.WEST);
    panel.add(label,BorderLayout.CENTER);
    panel.add(b2,BorderLayout.EAST);
    String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    model = new DefaultTableModel(null,columns);
     table = new JTable(model);
    JScrollPane pane = new JScrollPane(table);
   // Disable editing for all cells
   table.setDefaultEditor(Object.class, null);
   // Set cell selection mode to allow selecting individual cells
table.setCellSelectionEnabled(true);
 // Set selection mode to only allow selection of single cells
 table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//  table.setColumnSelectionAllowed(true);
//  table.setRowSelectionAllowed(true);
 // Add a ListSelectionListener to the table's selection model
table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
  @Override
  public void valueChanged(ListSelectionEvent e) {
      if (!e.getValueIsAdjusting()) {
           selectedRow = table.getSelectedRow();
           selectedColumn = table.getSelectedColumn();
          if (selectedRow != -1 && selectedColumn != -1) {
              Object selectedValue = table.getValueAt(selectedRow, selectedColumn);
              if (selectedValue == null || selectedValue.toString().isEmpty()) {
                  // Disable row and column selection if the cell is empty
                  table.clearSelection();
                  table.setColumnSelectionAllowed(false);
                  table.setRowSelectionAllowed(false);
              } else {
                  // Enable row and column selection
                  SetColoure(selectedRow, selectedColumn);
                  Object val = table.getValueAt(selectedRow, selectedColumn);
                  JOptionPane.showMessageDialog(null, val);
                  table.clearSelection();
                  table.setSelectionBackground(Color.BLUE); // Change this to your desired color
                  table.setSelectionForeground(Color.WHITE); // Change this to your desired text
                  table.setColumnSelectionAllowed(true);
                  table.setRowSelectionAllowed(true);
              }
          }
      }
  }
});
    this.add(panel,BorderLayout.NORTH);
    this.add(pane,BorderLayout.CENTER);
    this.pack();
    this.setVisible(true);
    this.updateMonth();
  }


  public void SetColoure(int calenderRow , int calenderCol )
  {
     table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
              @Override
              public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                      boolean hasFocus, int row, int column) {
                  Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                  // Set background color for specific row and column
                  if (row == calenderRow && column == calenderCol) { // Example: set color for row 2, column 3
                      c.setBackground(Color.GREEN);
                  } else {
                      c.setBackground(table.getBackground());
                  }
                  return c;
              }
          });
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


  //finding a date
  public void findAndHighlightDate(int day, int month, int year) {
    int rowCount = model.getRowCount();
    int colCount = model.getColumnCount();
    setDateMonthYear(day, month,  year);
    for (int row = 0; row < rowCount; row++) {
        for (int col = 0; col < colCount; col++) {
            Object cellValue = model.getValueAt(row, col);
            if (cellValue instanceof Integer && (Integer) cellValue == day) {
                // Highlight the cell for the specified date
                table.changeSelection(row, col, false, false);
                table.setSelectionBackground(Color.YELLOW);
                table.setSelectionForeground(Color.BLACK);
                return; // Stop searching after finding the date
            }
        }
    }
}

// Method to set a specific date
    public void setDateMonthYear(int day, int month, int year) {
      cal.set(year, month - 1, day); // Month is 0-based, so subtract 1
      updateMonth();
  }


  public static void main(String[] arguments) {
    JFrame.setDefaultLookAndFeelDecorated(true);
    CalenderView sc = new CalenderView();
    //sc.setDateMonthYear(20, 02, 2004);
   sc.findAndHighlightDate(28, 02, 2004);
  }
}
