//REf : https://www.javacodex.com/Swing/Swing-Calendar


// To remove trailing whitespaces at the end of lines, use:
// \s+$

// To remove multiple consecutive empty lines, use the following regular expression in the search bar:
// ^\s*\n
// Ctrl + H

package Calender;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.time.Month;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.*;


public class CalenderView implements ActionListener, ListSelectionListener {
  DefaultTableModel model;
  Calendar cal = new GregorianCalendar();
  JLabel LblMonthYear;
  int selectedRow, selectedColumn;
  JTable table;
 JButton pre,fwd;
 JScrollPane pane ;
 JPanel  main, panel;
Integer selectedDate,selectedMonth,selectedYear;
Component c;
int TempMonth,TempYear;
   CalenderView(){
    UI();
  }
    public JPanel UI(){

 main = new JPanel();
// main.setSize(300,2);
main.setLayout(new BorderLayout());
    LblMonthYear = new JLabel();
    LblMonthYear.setHorizontalAlignment(SwingConstants.CENTER);
     pre = new JButton("<-"); fwd = new JButton("->");
    pre.addActionListener(this);
    fwd.addActionListener(this);

    TopPanel();
    CalenderTable();

    main.add(panel,BorderLayout.NORTH);
    main.add(pane,BorderLayout.CENTER);
  
         for (int i = 0; i < table.getColumnModel().getColumnCount(); i++) {
          table.getColumnModel().getColumn(i).setResizable(false);
      }
    updateMonth();
    return main;
  }

  public JPanel TopPanel()
  {
    panel = new JPanel();
    panel.setLayout(new BorderLayout());
    panel.add(pre,BorderLayout.WEST);
    panel.add(LblMonthYear,BorderLayout.CENTER);
    panel.add(fwd,BorderLayout.EAST);
    return panel;
  }
public JTable CalenderTable()
{

  String [] columns = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
  model = new DefaultTableModel(null,columns);
   table = new JTable(model);
   pane = new JScrollPane(table);
 // Disable editing for all cells
table.setDefaultEditor(Object.class, null);
table.setCellSelectionEnabled(true);
  // Disable column reordering
  table.getTableHeader().setReorderingAllowed(false);
table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
table.getSelectionModel().addListSelectionListener(this);
return table;
}
  
  Object[] updateMonth() {
    cal.set(Calendar.DAY_OF_MONTH, 1);
    String Month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
    int NumberOfMonth =cal.get(Calendar.MONTH)+1;// cal.//getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US);
    int Year = cal.get(Calendar.YEAR);
    LblMonthYear.setText(Month + " " + Year);
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
    Object[] deatils= {Month,Year,NumberOfMonth};
    return deatils;
  }


  //finding a date
  public void addDateMonthYear(int day, int month, int year) {
    
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

public Object[] getDMY()
{
  Object [] dmy={selectedDate,selectedMonth,selectedYear};
  if(selectedDate !=null ||selectedMonth !=null||selectedYear !=null)
  {
    return dmy;
   }

  JOptionPane.showMessageDialog(null,"Select A Date");

  return null;
}
// Method to set a specific date
    private void setDateMonthYear(int day, int month, int year) {
      cal.set(year, month - 1, day); // Month is 0-based, so subtract 1
      updateMonth();
  }


  public void SetColoure(int calenderRow , int calenderCol )
  {
     table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
              @Override
              public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                      boolean hasFocus, int row, int column) {
                   c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                  // Set background color for specific row and column
                  if (row == calenderRow && column == calenderCol) { // Example: set color for row 2, column 3
                    
                    
                    if(selectedYear == (Integer.parseInt(LblMonthYear.getText().split(" ")[1]))&&selectedMonth== Month.valueOf(LblMonthYear.getText().split(" ")[0].toUpperCase()).getValue())
                    {
                      c.setBackground(Color.GREEN);
                    }
                    else
                    {
                      c.setBackground(Color.WHITE);
                    }
                
                  } else {
                      c.setBackground(table.getBackground());
                  }
                  return c;
              }
          });
        }






  @Override
  public void valueChanged(ListSelectionEvent e) {
    if(e.getSource() != null){

         if (!e.getValueIsAdjusting()) {
           selectedRow = table.getSelectedRow();
           selectedColumn = table.getSelectedColumn();
          if (selectedRow != -1 && selectedColumn != -1) {
              Object selectedValue = table.getValueAt(selectedRow, selectedColumn);
              if (selectedValue == null || selectedValue.toString().isEmpty()) {
                  // Disable row and column selection if the cell is empty
                 // table.clearSelection();
                  table.setColumnSelectionAllowed(false);
                  table.setRowSelectionAllowed(false);
              } else {
                  // Enable row and column selection
                  SetColoure(selectedRow, selectedColumn);
                   selectedDate = (int) table.getValueAt(selectedRow, selectedColumn);

                  selectedMonth=(int) updateMonth()[2];
                  selectedYear=(int) updateMonth()[1];

                 // table.clearSelection();
                  // table.setSelectionBackground(Color.RED); // Change this to your desired color
                  // table.setSelectionForeground(Color.WHITE); // Change this to your desired text
                  table.setColumnSelectionAllowed(true);
                  table.setRowSelectionAllowed(true);
              }
          }
      }
    }

  }

  @Override
  public void actionPerformed(ActionEvent e) {
  
    if(e.getSource()==pre){
 
              cal.add(Calendar.MONTH, -1);
     

              
        updateMonth();
     

    }
    if(e.getSource()==fwd){
              cal.add(Calendar.MONTH, +1);
        updateMonth();
    }

  }


}
