package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Transaction extends JFrame implements ActionListener{

    JButton deposit,withdraw,fastcash,ministatement,pinChange,balance,exit;
    String pinnumber;
    
    Transaction(String pinnumber){
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
        

        
        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(230, 100, 350, 30);
        text.setFont(new Font("Ariel",Font.BOLD,24));
        text.setForeground(Color.white);
        img.add(text);
        
        
        deposit=new JButton("Deposite");
        deposit.setBounds(170,213,150,30);
        deposit.setFont(new Font("Ariel",Font.BOLD,20));
        deposit.setForeground(Color.white);
        deposit.setBackground(Color.black);
        deposit.addActionListener(this);
        img.add(deposit);
        
        withdraw=new JButton("Cash Withdraw");
        withdraw.setBounds(430,213,200,30);
        withdraw.setFont(new Font("Ariel",Font.BOLD,20));
        withdraw.setForeground(Color.white);
        withdraw.setBackground(Color.black);
        withdraw.addActionListener(this);
        img.add(withdraw);
        
        fastcash=new JButton("Fast Cash");
        fastcash.setBounds(170,270,150,30);
        fastcash.setFont(new Font("Ariel",Font.BOLD,20));
        fastcash.setForeground(Color.white);
        fastcash.setBackground(Color.black);
        fastcash.addActionListener(this);
        img.add(fastcash);
        
        ministatement=new JButton("Mini Statement");
        ministatement.setBounds(430,270,200,30);
        ministatement.setFont(new Font("Ariel",Font.BOLD,20));
        ministatement.setForeground(Color.white);
        ministatement.setBackground(Color.black);
        ministatement.addActionListener(this);
        img.add(ministatement);
        
        pinChange=new JButton("Pin Change");
        pinChange.setBounds(170,330,150,30);
        pinChange.setFont(new Font("Ariel",Font.BOLD,20));
        pinChange.setForeground(Color.white);
        pinChange.setBackground(Color.black);
        pinChange.addActionListener(this);
        img.add(pinChange);
        
        balance=new JButton("Balance Enquiry");
        balance.setBounds(430,330,200,30);
        balance.setFont(new Font("Ariel",Font.BOLD,20));
        balance.setForeground(Color.white);
        balance.setBackground(Color.black);
        balance.addActionListener(this);
        img.add(balance);
        
        exit=new JButton("Exit");
        exit.setBounds(430,380,200,30);
        exit.setFont(new Font("Ariel",Font.BOLD,20));
        exit.setForeground(Color.white);
        exit.setBackground(Color.black);
        exit.addActionListener(this);
        img.add(exit);
        
        
        setVisible(true);

        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            System.exit(0);
        }else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinnumber).setVisible(true);
        }else if(ae.getSource()==withdraw){
            setVisible(false);
            new Withdraw(pinnumber).setVisible(true);
        } else if(ae.getSource()==fastcash){
            setVisible(false);
            new FastCash(pinnumber).setVisible(true);
        } else if(ae.getSource()==pinChange){
            setVisible(false);
            new PinChange(pinnumber).setVisible(true);
        }else if(ae.getSource()==balance){
            setVisible(false);
            new BalanceEnquiry(pinnumber).setVisible(true);
        }else if(ae.getSource()==ministatement){
            setVisible(false);
            new MiniStatement(pinnumber).setVisible(true);
        }
    }
    
    public static void main(String[] args) {
        new Transaction("");
    }

}