package bank_management_system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;

public class MiniStatement extends JFrame implements ActionListener {

    Conn conn = new Conn();
    Statement stmt = conn.s;

    String pinnumber;
    JButton back, exit;
    JTable table;

    MiniStatement(String pinnumber) {
        this.pinnumber = pinnumber;
        setTitle("Account Mini Statement");

        setSize(600, 500);
        setLocation(200, 20);
        setLayout(null);
        setUndecorated(true);
        getContentPane().setBackground(Color.white);

        JLabel bank = new JLabel("Private Bank");
        bank.setBounds(260, 20, 200, 30);
        bank.setFont(new Font("Arial", Font.BOLD, 18));
        add(bank);

        table = new JTable();
        table.setBackground(new Color(232, 232, 232));
        table.setFont(new Font("Ariel", Font.PLAIN, 14));

        try {
            String sql = "SELECT * FROM bank WHERE pin_no='" + pinnumber + "'";
            ResultSet rs = stmt.executeQuery(sql);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBounds(10, 80, 580, 300);
        add(scroll);

        back = new JButton("Back");
        back.setBounds(450, 400, 100, 30);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        exit = new JButton("Exit");
        exit.setBounds(50, 400, 100, 30);
        exit.setFont(new Font("Arial", Font.BOLD, 18));
        exit.setBackground(Color.black);
        exit.setForeground(Color.white);
        exit.addActionListener(this);
        add(exit);

        setVisible(true);
    }

    public static void main(String[] args) {
        new MiniStatement("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new Transaction(pinnumber).setVisible(true);
        } else {
            System.exit(0);
        }
    }
}
