package employee.management.system;

/**
 *
 * @author Aryan Quraishi
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class UpdateEmployee extends JFrame implements ActionListener {
  
    JTextField jtfeducation, jtffname, jtfslry, jtfadrs, jtfphone, jtfemail, jtfd, jtfadr;
    JLabel lblempId;
    JButton back, add;
    String empId;
    
    UpdateEmployee(String empId) {
        this.empId = empId;
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Update Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblname);
        
        JLabel lblnamE = new JLabel();
        lblnamE.setBounds(200, 150, 150, 30);
        add(lblnamE);
        
        JLabel lblfname = new JLabel("Father Name");
        lblfname.setBounds(400, 150, 150, 30);
        lblfname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblfname);
        
        jtffname = new JTextField();
        jtffname.setBounds(600, 150, 150, 30);
        add(jtffname);
        
        JLabel lbldob = new JLabel("Date Of Birth");
        lbldob.setBounds(50, 200, 150, 30);
        lbldob.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbldob);
        
        JLabel lbldoB = new JLabel();
        lbldoB.setBounds(200, 200, 150, 30);
        add(lbldoB);
        
        JLabel lblslry = new JLabel("Salary");
        lblslry.setBounds(400, 200, 150, 30);
        lblslry.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblslry);
        
        jtfslry = new JTextField();
        jtfslry.setBounds(600, 200, 150, 30);
        add(jtfslry);
     
        JLabel lbladrs = new JLabel("Address");
        lbladrs.setBounds(50, 250, 150, 30);
        lbladrs.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbladrs);
        
        jtfadrs = new JTextField();
        jtfadrs.setBounds(200, 250, 150, 30);
        add(jtfadrs);
        
        JLabel lblphone = new JLabel("Mobile Number");
        lblphone.setBounds(400, 250, 150, 30);
        lblphone.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblphone);
        
        jtfphone = new JTextField();
        jtfphone.setBounds(600, 250, 150, 30);
        add(jtfphone);
        
        JLabel lblemail = new JLabel("Email");
        lblemail.setBounds(50, 300, 150, 30);
        lblemail.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblemail);
        
        jtfemail = new JTextField();
        jtfemail.setBounds(200, 300, 150, 30);
        add(jtfemail);
        
        JLabel labeleducation = new JLabel("Higest Education");
        labeleducation.setBounds(400, 300, 150, 30);
        labeleducation.setFont(new Font("serif", Font.PLAIN, 20));
        add(labeleducation);
        
        jtfeducation = new JTextField();
        jtfeducation.setBounds(600, 300, 150, 30);
        add(jtfeducation);
        
        JLabel lbld = new JLabel("Designation");
        lbld.setBounds(50, 350, 150, 30);
        lbld.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbld);
        
        jtfd = new JTextField();
        jtfd.setBounds(200, 350, 150, 30);
        add(jtfd);
        
        JLabel lbladr = new JLabel("Aadhar Number");
        lbladr.setBounds(400, 350, 150, 30);
        lbladr.setFont(new Font("serif", Font.PLAIN, 20));
        add(lbladr);
        
        JLabel lbladR = new JLabel();
        lbladR.setBounds(600, 350, 150, 30);
        add(lbladR);
        
        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(50, 400, 150, 30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);
        
        lblempId = new JLabel();
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        try{
            Dbconnection c = new Dbconnection();
            String query = "select * from employee where empId = '"+empId+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblnamE.setText(rs.getString("name"));
                jtffname.setText(rs.getString("fname"));
                lbldoB.setText(rs.getString("dob"));
                jtfslry.setText(rs.getString("salary"));
                jtfadrs.setText(rs.getString("address"));
                jtfphone.setText(rs.getString("phone"));
                jtfemail.setText(rs.getString("email"));
                jtfeducation.setText(rs.getString("education"));
                jtfd.setText(rs.getString("designation"));
                lbladR.setText(rs.getString("aadhar"));
                lblempid.setText(rs.getString("empId"));
                
            }
        } catch(Exception e) {
         e.printStackTrace();
        }
        
        back = new JButton("Back");
        back.setBounds(250, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        add = new JButton("Update Details");
        add.setBounds(450, 550, 150, 40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        
        
        setSize(900, 700);
        setLocation(300, 50);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== add){
            
            String fname = jtffname.getText();
            String salary = jtfslry.getText();
            String address = jtfadrs.getText();
            String phone = jtfphone.getText();
            String email = jtfemail.getText();
            String education = jtfeducation.getText();
            String designation = jtfd.getText();
            
            try{
                Dbconnection db = new Dbconnection();
                String query = "update employee set fname = '"+fname+"',salary = '"+salary+"',address = '"+address+"',phone =  '"+phone+"',email = '"+email+"',education = '"+education+"',designation = '"+designation+"' where empId = '"+empId+"'";
                db.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Updated Succesfully");
                setVisible(false);
                new Home();
                
            }catch(Exception e){
                e.printStackTrace();
            }
           
        } else {
            setVisible(false);
            new Home();
        }
    }
    
    public static void main(String[] args) {
        new UpdateEmployee("");
    }
}
