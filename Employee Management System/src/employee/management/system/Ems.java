package employee.management.system;

/**
 *
 * @author Aryan Quraishi
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Ems extends JFrame implements ActionListener{
 
    Ems() {
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Welcome To Employee Management System");
        heading.setBounds(139,18,1200,60);
        heading.setFont(new Font("serif", Font.BOLD, 45));
        heading.setForeground(Color.red);
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/f2.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1100, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(50, 85, 1050, 500);
        add(image);
        
        JButton click = new JButton("CLICK HERE TO CONTINUE");
        click.setBounds(395,400,300,70);
        click.setBackground(Color.black);
        click.setForeground(Color.white);
        click.addActionListener(this);
        image.add(click);
        
    setSize(1170, 650);
    setLocation(200, 60);
    setVisible(true);
    
    while(true) {
        heading.setVisible(false);
        try{
            Thread.sleep(500);
        }
        catch (Exception e) {
            
        }
        heading.setVisible(true);
        
        try{
            Thread.sleep(1500);
        }
        catch (Exception e) {
            
        }
        
    }
    
    }
    
    public void actionPerformed(ActionEvent ae) {
        setVisible(false);
        new Login();
    }
    
    public static void main(String args[]){
        new Ems();
    }
}
