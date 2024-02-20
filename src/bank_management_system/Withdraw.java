package bank_management_system;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class Withdraw extends JFrame implements ActionListener {

    JButton withdraw, back;
    String pinnumber;
    JTextField amount;

    Withdraw(String pinnumber) {
        this.pinnumber = pinnumber;

        setSize(800, 700);
        setLocation(220, 10);
        setLayout(null);
        setUndecorated(true);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.png"));
        Image i2 = i1.getImage().getScaledInstance(800, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 800, 700);
        add(img);

        JLabel text = new JLabel("Enter the amount you want to Withdraw.");
        text.setBounds(230, 100, 400, 30);
        text.setFont(new Font("Ariel", Font.BOLD, 20));
        text.setForeground(Color.white);
        img.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Ariel", Font.BOLD, 18));
        amount.setBounds(250, 150, 300, 25);
        img.add(amount);

        withdraw = new JButton("Withdraw");
        withdraw.setBounds(510, 330, 120, 25);
        withdraw.setFont(new Font("Ariel", Font.BOLD, 18));
        withdraw.setBackground(Color.black);
        withdraw.setForeground(Color.white);
        withdraw.addActionListener(this);
        img.add(withdraw);

        back = new JButton("Back");
        back.setBounds(510, 370, 120, 25);
        back.setFont(new Font("Ariel", Font.BOLD, 20));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        img.add(back);

        setVisible(true);

    }

    public static void main(String[] args) {
        new Withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == withdraw) {
            String amountNo = amount.getText();
            Date date = new Date();
            if (amountNo.equals("")) {
                JOptionPane.showMessageDialog(null, "Enter the amount you want to Withdraw");
            } else {
                try {
                    Conn conn = new Conn();

                    ResultSet rs = conn.s.executeQuery("select * from bank where pin_no='" + pinnumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }

                    if (e.getSource() != back && balance < Integer.parseInt(amountNo)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        return;
                    }

                    String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdraw','" + amountNo + "')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs " + amountNo + " has been Withdrawn Successfully");
                    setVisible(false);
                    new Transaction(pinnumber).setVisible(true);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        }

    }
}
