package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
 
    JRadioButton savingAcc,fixedAcc,currentAcc,recurringAcc;
    JCheckBox serviceAtm,serviceNetBank,serviceSMS,servicebook,serviceStmnt,serviceMobile,selfDeclare;
    JButton submit,cancel;
    String formno;
    
     SignupThree(String formno) {
         
         this.formno=formno;
         
         
         setSize(700,700);
         getContentPane().setBackground(Color.white);
         setLocation(300,0);
         setLayout(null);
           
         setTitle("Account Details - Page 3");
         
         
         JLabel page3= new JLabel("Page 3: Account Details");
         page3.setFont(new Font("Ariel",Font.BOLD,30));
         page3.setBounds(200, 10, 400, 40);
         add(page3);
         
         
         JLabel accountType=new JLabel("Account Type");
         accountType.setBounds(100,80,150,30);
         accountType.setFont(new Font("Ariel",Font.BOLD,18));
         add(accountType);
         
         savingAcc=new JRadioButton("Saving Account");
         savingAcc.setBounds(100,110,200,30);
         savingAcc.setFont(new Font("Ariel",Font.BOLD,14));
         savingAcc.setBackground(Color.white);
         add(savingAcc);
         
         fixedAcc=new JRadioButton("Fixed Deposit Account");
         fixedAcc.setBounds(400,110,250,30);
         fixedAcc.setFont(new Font("Ariel",Font.BOLD,14));
         fixedAcc.setBackground(Color.white);
         add(fixedAcc);
         
         currentAcc=new JRadioButton("Current Account");
         currentAcc.setBounds(100,140,200,30);
         currentAcc.setFont(new Font("Ariel",Font.BOLD,14));
         currentAcc.setBackground(Color.white);
         add(currentAcc);
         
         recurringAcc=new JRadioButton("Recurring Deposit Account");
         recurringAcc.setBounds(400,140,250,30);
         recurringAcc.setFont(new Font("Ariel",Font.BOLD,14));
         recurringAcc.setBackground(Color.white);
         add(recurringAcc);
         
         ButtonGroup accTypeBtn=new ButtonGroup();
         accTypeBtn.add(savingAcc);
         accTypeBtn.add(fixedAcc);
         accTypeBtn.add(currentAcc);
         accTypeBtn.add(recurringAcc);
         
         JLabel cardNo= new JLabel("Card Number");
         cardNo.setBounds(100,180,150,30);
         cardNo.setFont(new Font("Ariel",Font.BOLD,18));
         add(cardNo);
         
         JLabel digits= new JLabel("Your 16 digit Card No.");
         digits.setBounds(108,205,150,15);
         digits.setFont(new Font("Ariel",Font.BOLD,10));
         add(digits);
         
         JLabel number= new JLabel("XXXX-XXXX-XXXX-4680");
         number.setBounds(400,190,250,30);
         number.setFont(new Font("Ariel",Font.BOLD,18));
         add(number);
         
         JLabel pin= new JLabel("Card PIN:");
         pin.setBounds(100,235,100,30);
         pin.setFont(new Font("Ariel",Font.BOLD,18));
         add(pin);
         
         JLabel pinDigit= new JLabel("Your 4 digit PIN");
         pinDigit.setBounds(102,260,150,15);
         pinDigit.setFont(new Font("Ariel",Font.BOLD,10));
         add(pinDigit);
         
         JLabel pinNo= new JLabel("••••");
         pinNo.setBounds(400,230,150,50);
         pinNo.setFont(new Font("Ariel",Font.BOLD,50));
         add(pinNo);
         
         JLabel service= new JLabel("Service Required:");
         service.setBounds(100,290,250,30);
         service.setFont(new Font("Ariel",Font.BOLD,18));
         add(service);

         serviceAtm= new JCheckBox("ATM Card");
         serviceAtm.setBounds(100, 325, 100, 15);
         serviceAtm.setFont(new Font("Ariel",Font.BOLD,14));
         serviceAtm.setBackground(Color.white);
         add(serviceAtm);
         
         serviceNetBank= new JCheckBox("Net Banking");
         serviceNetBank.setBounds(400, 325, 150, 15);
         serviceNetBank.setFont(new Font("Ariel",Font.BOLD,14));
         serviceNetBank.setBackground(Color.white);
         add(serviceNetBank);
         
         serviceSMS= new JCheckBox("Email & SMS Alert");
         serviceSMS.setBounds(100, 350, 150, 15);
         serviceSMS.setFont(new Font("Ariel",Font.BOLD,14));
         serviceSMS.setBackground(Color.white);
         add(serviceSMS);
         
         servicebook= new JCheckBox("Cheque Book");
         servicebook.setBounds(400, 350, 150, 15);
         servicebook.setFont(new Font("Ariel",Font.BOLD,14));
         servicebook.setBackground(Color.white);
         add(servicebook);
         
         serviceStmnt= new JCheckBox("E-Statement");
         serviceStmnt.setBounds(100, 375, 150, 15);
         serviceStmnt.setFont(new Font("Ariel",Font.BOLD,14));
         serviceStmnt.setBackground(Color.white);
         add(serviceStmnt);
         
         serviceMobile= new JCheckBox("Mobile Banking");
         serviceMobile.setBounds(400, 375, 150, 15);
         serviceMobile.setFont(new Font("Ariel",Font.BOLD,14));
         serviceMobile.setBackground(Color.white);
         add(serviceMobile);
         
         selfDeclare= new JCheckBox("I hereby declare that all the details provided above are true to the best of my knowledge");
         selfDeclare.setBounds(100, 550, 650, 15);
         selfDeclare.setFont(new Font("Ariel",Font.BOLD,12));
         selfDeclare.setBackground(Color.white);
         add(selfDeclare);
         
         submit=new JButton("Submit");
         submit.setBounds(200, 600, 100, 30);
         submit.setFont(new Font("Ariel",Font.BOLD,15));
         submit.setBackground(Color.black);
         submit.setForeground(Color.white);
         submit.addActionListener(this);
         add(submit);
         
         cancel=new JButton("Cancel");
         cancel.setBounds(350, 600, 100, 30);
         cancel.setFont(new Font("Ariel",Font.BOLD,15));
         cancel.setBackground(Color.black);
         cancel.setForeground(Color.white);
         cancel.addActionListener(this);
         add(cancel);

         
         
        setVisible(true);

         
    }
     
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accType="a";
            if(savingAcc.isSelected()){
                accType="Saving Account";
            }else if(fixedAcc.isSelected()){
                accType="Fixed Deposit Account";
            }else if(currentAcc.isSelected()){
                accType="Current Account";
            }else if(recurringAcc.isSelected()){
                accType="Recurring Deposit Account";
            }
            
            Random random= new Random();
            String cardnumber=""+ Math.abs((random.nextLong()%90000000L)+9285076000000000L);
            
            String pinnumber=""+Math.abs((random.nextLong()%9000L)+1000L);
            
            String accServices="";
            
            if(serviceAtm.isSelected()){
                accServices+=" ATM Card";
            }else if(serviceNetBank.isSelected()){
                accServices+=" Net Banking";
            }else if(serviceSMS.isSelected()){
                accServices+=" Email & SMS Alert";
            }else if(servicebook.isSelected()){
                accServices+=" Cheque Book";
            }else if(serviceStmnt.isSelected()){
                accServices+=" E-Statement";
            }else if(serviceMobile.isSelected()){
                accServices+=" Mobile Banking";
            }
            
            try{
                if(accType.equals("a")){
                    JOptionPane.showMessageDialog(null, "Account Type is required");
                }
                else{
                    Conn conn=new Conn();
                    String query1="insert into signup_three values('"+formno+"','"+accType+"','"+cardnumber+"','"+pinnumber+"','"+accServices+"')";
                    String query2="insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Your Card Number: "+cardnumber +"\nYour Pin Number: "+pinnumber);
                    
                    setVisible(false);
                    new Deposit(pinnumber).setVisible(true);
                }
                
            }catch(Exception e){
                System.err.println(e);
            }
            
            
            
        }
        else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    } 
     
    public static void main(String[] args) {
        new SignupThree("");
    }
 
 
}

