package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PinChange extends JFrame implements ActionListener{

    JPasswordField newPinText,rePinText;
    JButton change, back;
    String pinnumber;
    
    PinChange(String pinnumber) {
        
        this.pinnumber=pinnumber;
        
        setSize(800,720);
        setLocation(230,10);
        getContentPane().setBackground(Color.white);
        setUndecorated(true);
        setLayout(null);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2=i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel img=new JLabel(i3);
        img.setBounds(0,0,800,725);
        add(img);
        
        JLabel text=new JLabel("Change your PIN");
        text.setBounds(300,110,300,30);
        text.setFont(new Font("Ariel",Font.BOLD,22));
        text.setForeground(Color.white);
        img.add(text);
        
        JLabel newPin=new JLabel("New PIN:");
        newPin.setBounds(180,220,200,30);
        newPin.setFont(new Font("Ariel",Font.BOLD,20));
        newPin.setForeground(Color.white);
        img.add(newPin);
        
        newPinText=new JPasswordField();
        newPinText.setBounds(400,220,220,30);
        newPinText.setFont(new Font("Ariel",Font.BOLD,20));
//        newPinText.setForeground(Color.white);
        img.add(newPinText);
        
        
        JLabel rePin=new JLabel("Re-Enter New PIN:");
        rePin.setBounds(180,280,300,30);
        rePin.setFont(new Font("Ariel",Font.BOLD,20));
        rePin.setForeground(Color.white);
        img.add(rePin);
        
        rePinText=new JPasswordField();
        rePinText.setBounds(400,280,220,30);
        rePinText.setFont(new Font("Ariel",Font.BOLD,20));
//        rePinText.setForeground(Color.white);
        img.add(rePinText);
        
        change=new JButton("Change");
        change.setBounds(180,340,120,30);
        change.setFont(new Font("Ariel",Font.BOLD,18));
        change.setForeground(Color.white);
        change.setBackground(Color.black);
        change.addActionListener(this);
        img.add(change);
        
        back=new JButton("Back");
        back.setBounds(500,340,120,30);
        back.setFont(new Font("Ariel",Font.BOLD,18));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        img.add(back);
        
        
        setVisible(true);
        
    }
    
    
    
    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==change){
            try{
                String npin=newPinText.getText();
                String repin=rePinText.getText();

                if(!npin.equals(repin)){
                    JOptionPane.showMessageDialog(null, "Entered New PIN does not match");
                    return;
                }
                
                if(npin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter New PIN");
                    return;
                }
                
                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re-Enter New PIN");
                    return;
                }
                
                Conn conn=new Conn();
                String query1="update bank set pin_no='"+repin+"' where pin_no='"+pinnumber+"'";
                String query2="update login set pin_no='"+repin+"' where pin_no='"+pinnumber+"'";
                String query3="update signupthree set pin_no='"+repin+"' where pin_no='"+pinnumber+"'";
                
                 JOptionPane.showMessageDialog(rootPane, "New Pin has been successfully updated");
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                
               
//                JOptionPane.showMessageDialog(null, "New Pin has been successfully updated");
                
                setVisible(false);
                new Transaction(repin).setVisible(true);
                    
                
            }catch(Exception ex){
                System.out.println(ex);
            }
        }else{
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }
    }
}
