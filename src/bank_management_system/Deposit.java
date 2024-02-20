package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Deposit extends JFrame implements ActionListener{

    JButton deposit,back;
    String pinnumber;
    JTextField amount;
    
    Deposit(String pinnumber){
        this.pinnumber=pinnumber;
         
        setSize(800,700);
        setLocation(220,10);   
        setLayout(null);
        setUndecorated(true);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2=i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,800,700);
        add(img);
        
        JLabel text=new JLabel("Enter the amount you want to deposit.");
        text.setBounds(230,100,400,30);
        text.setFont(new Font("Ariel",Font.BOLD,20));
        text.setForeground(Color.white);
        img.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("Ariel",Font.BOLD,18));
        amount.setBounds(250,150,300,25);
        img.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(520,330,110,25);
        deposit.setFont(new Font("Ariel",Font.BOLD,18));
        deposit.setBackground(Color.black);
        deposit.setForeground(Color.white);
        deposit.addActionListener(this);
        img.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(520,370,110,25);
        back.setFont(new Font("Ariel",Font.BOLD,20));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        img.add(back);
        
        
        
        
        
        setVisible(true);

    }
    
    
    
    public static void main(String[] args) {
        new Deposit("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==deposit){
            String amountNo=amount.getText();
            Date date=new Date();
            if(amountNo.equals("")){
                JOptionPane.showMessageDialog(null, "Enter the amount you want to deposite");
            }else{
                 try{
                    Conn conn=new Conn();
                    String query="insert into bank values('"+pinnumber+"','"+date+"','Deposit','"+amountNo+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs "+amountNo+" has been Deposited Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                 }catch(Exception ex){
                    System.out.println(ex);
                    }
                }
        }else if(e.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
        
    }
}
