package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements ActionListener{
    
    long randomno;
    JTextField nameText, fNameText,emailText, addressText, stateText, cityText, pinText;
    JButton next;
    JRadioButton male, female, married, unmarried;
    JDateChooser dateChooser;
    
    SignupOne(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        Random random=new Random();
        randomno=Math.abs((random.nextLong()%9000L)+1000L);
        
        setTitle("New Account Application Form - Page 1");
        
        JLabel formno=new JLabel("APPLICATION FORM NO. "+randomno);
        formno.setFont(new Font("Raleway",Font.BOLD,28));
        formno.setBounds(220,10,520,30);
        add(formno);
        
        JLabel personalDetails=new JLabel("Page 1: Personal Details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,18));
        personalDetails.setBounds(320,50,320,30);
        add(personalDetails);
        
        JLabel name=new JLabel("Name:");
        name.setBounds(100, 100, 100, 30);
        name.setFont(new Font("ariel",Font.BOLD,16));
        add(name);
        
        nameText=new JTextField();
        nameText.setFont(new Font("Calibari",Font.ITALIC,16));
        nameText.setBounds(400, 100, 300, 30);
        add(nameText);
        
        JLabel fName=new JLabel("Father's Name:");
        fName.setBounds(100, 140, 120, 30);
        fName.setFont(new Font("ariel",Font.BOLD,16));
        add(fName);
        
        fNameText=new JTextField();
        fNameText.setFont(new Font("Calibari",Font.ITALIC,16));
        fNameText.setBounds(400, 140, 300, 30);
        add(fNameText);
        
        JLabel dob=new JLabel("Date of Birth:");
        dob.setBounds(100, 180, 120, 30);
        dob.setFont(new Font("ariel",Font.BOLD,16));
        add(dob);
                
        dateChooser=new JDateChooser();
        dateChooser.setBounds(400,180,220,30);
        dateChooser.setForeground(Color.red);
        add(dateChooser);
        
        JLabel gender=new JLabel("Gender:");
        gender.setBounds(100, 220, 120, 30);
        gender.setFont(new Font("ariel",Font.BOLD,16));
        add(gender);
        
        male=new JRadioButton("Male");
        male.setBounds(400, 220, 80, 30);
        male.setBackground(Color.white);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(520, 220, 80, 30);
        female.setBackground(Color.white);
        add(female);
        
        ButtonGroup genderGroup =new ButtonGroup();
        genderGroup.add(male);
        genderGroup.add(female);

        
        JLabel email=new JLabel("Email:");
        email.setBounds(100, 260, 120, 30);
        email.setFont(new Font("ariel",Font.BOLD,16));
        add(email);
        
        emailText=new JTextField();
        emailText.setFont(new Font("Calibari",Font.ITALIC,16));
        emailText.setBounds(400, 260, 300, 30);
        add(emailText);
        
        JLabel marital=new JLabel("Marital Status:");
        marital.setBounds(100, 300, 120, 30);
        marital.setFont(new Font("ariel",Font.BOLD,16));
        add(marital);
        
        unmarried=new JRadioButton("Unmarried");
        unmarried.setBounds(400, 300, 100, 30);
        unmarried.setBackground(Color.white);
        add(unmarried);
        
        married=new JRadioButton("Married");
        married.setBounds(520, 300, 80, 30);
        married.setBackground(Color.white);
        add(married);
        
        ButtonGroup maritalGroup =new ButtonGroup();
        maritalGroup.add(unmarried);
        maritalGroup.add(married);
        
        JLabel address=new JLabel("Address:");
        address.setBounds(100, 340, 120, 30);
        address.setFont(new Font("ariel",Font.BOLD,16));
        add(address);
        
        addressText=new JTextField();
        addressText.setFont(new Font("Calibari",Font.ITALIC,16));
        addressText.setBounds(400, 340, 300, 30);
        add(addressText);
        
        JLabel city=new JLabel("City:");
        city.setBounds(100, 380, 120, 30);
        city.setFont(new Font("Calibari",Font.BOLD,16));
        add(city);
        
        cityText=new JTextField();
        cityText.setFont(new Font("Calibari",Font.ITALIC,16));
        cityText.setBounds(400, 380, 300, 30);
        add(cityText);
        
        JLabel state=new JLabel("State:");
        state.setBounds(100, 420, 120, 30);
        state.setFont(new Font("ariel",Font.BOLD,16));
        add(state);
        
        stateText=new JTextField();
        stateText.setFont(new Font("Calibari",Font.ITALIC,16));
        stateText.setBounds(400, 420, 300, 30);
        add(stateText);
        
        JLabel pincode=new JLabel("Pin Code:");
        pincode.setBounds(100, 460, 120, 30);
        pincode.setFont(new Font("ariel",Font.BOLD,16));
        add(pincode);
        
        pinText=new JTextField();
        pinText.setFont(new Font("Calibari",Font.ITALIC,16));
        pinText.setBounds(400, 460, 300, 30);
        add(pinText);
        
        
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(400, 550,100,30);
        next.addActionListener(this);
        add(next);
        
        
        setSize(850,800);
        setLocation(220,0);
        setVisible(true);

}
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno="" + randomno;
        String name=nameText.getText();
        String fname=fNameText.getText();
        String email=emailText.getText();
        String address=addressText.getText();
        String state=stateText.getText();
        String city=cityText.getText();
        String pin=pinText.getText();
        
        
        String dob=((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        }else if(female.isSelected()){
            gender="Female";
        }
        
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(unmarried.isSelected()){
            marital="Unmarried";
        }
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is required");
            }else{
                Conn c=new Conn();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
//                String query="delete from signup where formno='8261'";
                c.s.executeUpdate(query);
                
                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        System.err.println("Entry successfully added");
    }
    
    
    
    public static void main(String[] args) {
    
        new SignupOne();
        
    }
}


