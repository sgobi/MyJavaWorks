package StudentManagementSystem.database;

   import java.sql.*;

import javax.swing.JOptionPane;

import StudentManagementSystem.env;

    public class DbConnection {

        public Connection dbcon () throws ClassNotFoundException{

        
    
    String database=new env().DatabaseName;
    String username=new env().UserName;
    String password=new env().Password;
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con;
    try {
         con =DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", ""+username+"", ""+password+"");
JOptionPane.showMessageDialog(null, "hi", password, 0);
         return con;
    
    } catch (SQLException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return null;
    
    
        }
    }
    