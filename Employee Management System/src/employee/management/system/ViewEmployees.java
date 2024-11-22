package employee.management.system;

/**
 *
 * @author Aryan Quraishi
 */

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class ViewEmployees extends JFrame implements ActionListener {
    
    JTable table;
    Choice cemployeeid;
    JButton search, print, update, back;
    
    ViewEmployees(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel searchlbl = new JLabel("Search By Employee Id");
        searchlbl.setBounds(20, 20, 150, 20);
        add(searchlbl);
        
        cemployeeid = new Choice();
        cemployeeid.setBounds(180, 20, 150, 20);
        add(cemployeeid);
        
        table = new JTable();
        
        try{
            Dbconnection c = new Dbconnection();
            ResultSet rs = c.s.executeQuery("Select * from employee");
           
            while(rs.next()){
                cemployeeid.add(rs.getString("empId"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        try{
            Dbconnection c = new Dbconnection();
            ResultSet rs = c.s.executeQuery("Select * from employee");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 80, 900, 600);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 50, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 50, 80, 20);
        print.addActionListener(this);
        add(print);
        
        update = new JButton("Update");
        update.setBounds(220, 50, 80, 20);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("Back");
        back.setBounds(320, 50, 80, 20);
        back.addActionListener(this);
        add(back);
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == search) {
            String query = "select * from employee where empId = '"+cemployeeid.getSelectedItem()+"'";
            try {
                Dbconnection c = new Dbconnection();
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == print) {
            try {
                table.print();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            setVisible(false);
            new UpdateEmployee(cemployeeid.getSelectedItem());
       } else {
            setVisible(false);
            new Home();
        }
    }
    public static void main(String[] args){
        new ViewEmployees();
    }
}