package employee.management.system;

/**
 *
 * @author Aryan Quraishi
 */

import java.sql.*;

public class Dbconnection {
    
    Connection c;
    Statement s;
    
    public Dbconnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemanagementsystem", "root", "aryan123");
            s = c.createStatement();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
}
