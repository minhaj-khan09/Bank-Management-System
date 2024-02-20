package bank_management_system;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import javax.swing.*;


public class FastCash extends JFrame implements ActionListener{

    JButton withdraw100,withdraw500,withdraw1000,withdraw2000,withdraw5000,withdraw10000,back;
    String pinnumber;
    
    FastCash(String pinnumber){
        this.pinnumber=pinnumber;
        
        setSize(800,700);
        setLocation(200,10);
        setUndecorated(true);
        setLayout(null);

        getContentPane().setBackground(Color.white);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2=i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,800,700);
        add(img);
        

        
        JLabel text=new JLabel("Select Withdawl Amount");
        text.setBounds(230, 100, 350, 30);
        text.setFont(new Font("Ariel",Font.BOLD,24));
        text.setForeground(Color.white);
        img.add(text);
        
        
        withdraw100=new JButton("Rs 100");
        withdraw100.setBounds(170,213,150,30);
        withdraw100.setFont(new Font("Ariel",Font.BOLD,20));
        withdraw100.setForeground(Color.white);
        withdraw100.setBackground(Color.black);
        withdraw100.addActionListener(this);
        img.add(withdraw100);
        
        withdraw500=new JButton("Rs 500");
        withdraw500.setBounds(430,213,200,30);
        withdraw500.setFont(new Font("Ariel",Font.BOLD,20));
        withdraw500.setForeground(Color.white);
        withdraw500.setBackground(Color.black);
        withdraw500.addActionListener(this);
        img.add(withdraw500);
        
        withdraw1000=new JButton("Rs 1000");
        withdraw1000.setBounds(170,270,150,30);
        withdraw1000.setFont(new Font("Ariel",Font.BOLD,20));
        withdraw1000.setForeground(Color.white);
        withdraw1000.setBackground(Color.black);
        withdraw1000.addActionListener(this);
        img.add(withdraw1000);
        
        withdraw2000=new JButton("Rs 2000");
        withdraw2000.setBounds(430,270,200,30);
        withdraw2000.setFont(new Font("Ariel",Font.BOLD,20));
        withdraw2000.setForeground(Color.white);
        withdraw2000.setBackground(Color.black);
        withdraw2000.addActionListener(this);
        img.add(withdraw2000);
        
        withdraw5000=new JButton("Rs 5000");
        withdraw5000.setBounds(170,330,150,30);
        withdraw5000.setFont(new Font("Ariel",Font.BOLD,20));
        withdraw5000.setForeground(Color.white);
        withdraw5000.setBackground(Color.black);
        withdraw5000.addActionListener(this);
        img.add(withdraw5000);
        
        withdraw10000=new JButton("Rs 10000");
        withdraw10000.setBounds(430,330,200,30);
        withdraw10000.setFont(new Font("Ariel",Font.BOLD,20));
        withdraw10000.setForeground(Color.white);
        withdraw10000.setBackground(Color.black);
        withdraw10000.addActionListener(this);
        img.add(withdraw10000);
        
        back=new JButton("Back");
        back.setBounds(430,380,200,30);
        back.setFont(new Font("Ariel",Font.BOLD,20));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        img.add(back);
        
        
        setVisible(true);

        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }else{
            String amountNo=((JButton)ae.getSource()).getText().substring(3);
            Conn c=new Conn();
            Date date=new Date();
            
            try{
                ResultSet rs=c.s.executeQuery("select * from bank where pin_no='"+pinnumber+"'");
                int balance=0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance-=Integer.parseInt(rs.getString("amount"));
                    }
                }
                
                if(ae.getSource()!=back && balance<Integer.parseInt(amountNo)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                String query="insert into bank values('"+pinnumber+"','"+date+"','Withdraw','"+amountNo+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs "+amountNo+" has been Withdraw Successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }
    
    
    
    public static void main(String[] args) {
        new FastCash("");
    }
}

