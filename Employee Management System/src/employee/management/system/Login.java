package employee.management.system;

/**
 *
 * @author Aryan Quraishi
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    
    JTextField jtfusername, jtfpassword;
    
    Login() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel jllusername = new JLabel("Username");
        jllusername.setBounds(40, 20, 100, 30);
        add(jllusername);
        
        jtfusername = new JTextField();
        jtfusername.setBounds(150, 20, 150, 30);
        add(jtfusername);
                
        JLabel jllpassword = new JLabel("Password");
        jllpassword.setBounds(40, 70, 100, 30);
        add(jllpassword);
        
        jtfpassword = new JTextField();
        jtfpassword.setBounds(150, 70, 150, 30);
        add(jtfpassword);
        
        JButton login = new JButton("Login");
        login.setBounds(150, 120, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350, 0, 200, 200);
        add(image);
        
    setSize(600, 300);
    setLocation(450, 200);
    setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae) {
        try{
            String username = jtfusername.getText();
            String password = jtfpassword.getText();
            
            Dbconnection c = new Dbconnection();
            String query = "select * from login where username = '"+username+"' and password = '"+password+"'";
            
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
                setVisible(false);
                new Home();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password");
                setVisible(false);
                new Login();
            }
        }catch(Exception e){
         e.printStackTrace();
        }
    }
    
    public static void main(String args[]){
        new Login();
    }
}
