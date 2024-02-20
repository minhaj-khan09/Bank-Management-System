package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton login, clear, signup;
    JTextField cardText;
    JPasswordField pinText;
    
    Login(){
        setTitle("Automated Teller Machine");
        
        setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("icons/bank.png"));
        Image i=img.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT);
        ImageIcon i2=new ImageIcon(i);
        JLabel label=new JLabel(i2);
        label.setBounds(70,20,150,150);
        add(label);
        
        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Ariel",Font.BOLD,38));
        text.setBounds(300, 80,400,40);
        add(text);
        
        JLabel cardno=new JLabel("Card No:");
        cardno.setFont(new Font("Ariel",Font.BOLD,28));
        cardno.setBounds(100, 220,200,40);
        add(cardno);
        
        cardText=new JTextField();
        cardText.setBounds(300,230,250,30);
        cardText.setFont(new Font("Calibary",Font.BOLD,14));
        add(cardText);
        
        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Ariel",Font.BOLD,28));
        pin.setBounds(100, 280,100,40);
        add(pin);
         
        pinText=new JPasswordField();
        pinText.setBounds(300,290,250,30);
        pinText.setFont(new Font("Calibary",Font.BOLD,14));
        add(pinText);
        
        login=new JButton("SIGN IN");
        login.setBounds(300,350,100,30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        clear=new JButton("CLEAR");
        clear.setBounds(450,350,100,30);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);
        
        
        signup=new JButton("SIGN UP");
        signup.setBounds(300,400,250,30);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);
        
        
        
        getContentPane().setBackground(Color.white);
        
        setSize(800,500);
        setVisible(true);
        setLocation(220,100);
        
    } 
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==clear){
             cardText.setText("");
             pinText.setText("");
         }
         
         else if(ae.getSource()==login){
             Conn conn=new Conn();
             String cardnumber=cardText.getText();
             String pinnumber=pinText.getText();
             String query="select * from login where card_no='"+cardnumber+"' and pin_no='"+pinnumber+"'";
             try{
                 ResultSet rs = conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transaction(pinnumber).setVisible(true);
                 }else{
                     JOptionPane.showMessageDialog(null, "Incorrect Card Number or Pin Number");
                 }
             }
             catch(Exception e){
                 System.out.println(e);
             }
         }
         else if(ae.getSource()==signup){
             setVisible(false);
             new SignupOne().setVisible(true);
         }
    }
    
    public static void main(String[] args) {
        new Login();
    }
    
}
