package employee.management.system;

/**
 *
 * @author Aryan Quraishi
 */

import java.awt.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener {
   
    Random ran = new Random();
    int number = ran.nextInt(99999);
    
    JTextField jtfname, jtffname, jtfslry, jtfadrs, jtfphone, jtfemail, jtfd, jtfadr;
    JDateChooser edob;
    JComboBox cbeducation;
    JLabel lblempId;
    JButton back, add;
    
    AddEmployee() {
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320, 30, 500, 50);
        heading.setFont(new Font("SAN_SERIF", Font.BOLD, 25));
        add(heading);
        
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 150, 30);
        lblname.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblname);
        
        jtfname = new JTextField();
        jtfname.setBounds(200, 150, 150, 30);
        add(jtfname);
        
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
        
        edob = new JDateChooser();
        edob.setBounds(200, 200, 150, 30);
        add(edob);
        
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
        
        String courses[] = {"BCA", "BBA", "BA", "BSC", "B.COM", "BTech", "MBA", "MCA", "MA", "MTech", "MSC", "PHD"};
        cbeducation = new JComboBox(courses);
        cbeducation.setBackground(Color.WHITE);
        cbeducation.setBounds(600, 300, 150, 30);
        add(cbeducation);
        
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
        
        jtfadr = new JTextField();
        jtfadr.setBounds(600, 350, 150, 30);
        add(jtfadr);
        
        JLabel lblempid = new JLabel("Employee Id");
        lblempid.setBounds(50, 400, 150, 30);
        lblempid.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempid);
        
        lblempId = new JLabel("" + number);
        lblempId.setBounds(200, 400, 150, 30);
        lblempId.setFont(new Font("serif", Font.PLAIN, 20));
        add(lblempId);
        
        back = new JButton("Back");
        back.setBounds(250, 550, 150, 40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        add = new JButton("Add Details");
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
            
            String name = jtfname.getText();
            String fname = jtffname.getText();
            String dob = ((JTextField) edob.getDateEditor().getUiComponent()).getText();
            String salary = jtfslry.getText();
            String address = jtfadrs.getText();
            String phone = jtfphone.getText();
            String email = jtfemail.getText();
            String education = (String) cbeducation.getSelectedItem();
            String designation = jtfd.getText();
            String aadhar = jtfadr.getText();
            String empId = lblempId.getText();
            
            try{
                Dbconnection db = new Dbconnection();
                String query = "insert into employee values('"+name+"', '"+fname+"', '"+dob+"', '"+salary+"', '"+address+"', '"+phone+"', '"+email+"', '"+education+"', '"+designation+"', '"+aadhar+"', '"+empId+"')";
                db.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Details Added Succesfully");
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
        new AddEmployee();
    }
}
