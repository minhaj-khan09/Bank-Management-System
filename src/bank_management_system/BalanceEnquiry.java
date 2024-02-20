package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.math.BigDecimal;
import java.sql.*;
import java.util.Date;
import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pinnnumber;

    BalanceEnquiry(String pinnumber) {
        this.pinnnumber = pinnumber;

        setSize(800, 720);
        setLocation(230, 10);
        setLayout(null);
        setUndecorated(true);
        getContentPane().setBackground(Color.white);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 720, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 800, 700);
        add(img);

        JLabel topText = new JLabel("Your Account Balance");
        topText.setBounds(280, 100, 400, 25);
        topText.setFont(new Font("Ariel", Font.BOLD, 22));
        topText.setForeground(Color.white);
        img.add(topText);

        back = new JButton("Back");
        back.setBounds(460, 330, 120, 30);
        back.setFont(new Font("Ariel", Font.BOLD, 22));
        back.setForeground(Color.white);
        back.setBackground(Color.black);
        back.addActionListener(this);
        img.add(back);

        Conn c = new Conn();
        BigDecimal balance = BigDecimal.ZERO;
//        int balance=0;
        try {
            ResultSet rs = c.s.executeQuery("select * from bank where pin_no='" + pinnumber + "'");
            while (rs.next()) {
                String type = rs.getString("type");
                BigDecimal amount = new BigDecimal(rs.getString("amount"));

                if ("Deposit".equals(type)) {
                    balance = balance.add(amount);
                } else {
                    balance = balance.subtract(amount);
                }

//                if(rs.getString("type").equals("Deposit")){
//                    balance+=Integer.parseInt(rs.getString("amount"));
//                }else{
//                    balance-=Integer.parseInt(rs.getString("amount"));
//                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JLabel text = new JLabel("Balance: " + balance);
        text.setBounds(180, 205, 500, 30);
        text.setFont(new Font("Ariel", Font.BOLD, 22));
        text.setForeground(Color.white);
        img.add(text);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinnnumber).setVisible(true);
        }
    }
}
