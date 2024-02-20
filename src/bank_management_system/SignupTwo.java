package bank_management_system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener{
    
    JTextField  panText,adhaarText;
    JButton next;
    JRadioButton yes, no, accountYes, accountNo;
    JComboBox religionText,categoryText,incomeText,educationText,occupationText;
    String formno;
     
    
    
    SignupTwo(String formno){
        
        this.formno=formno;
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        setTitle("New Account Application Form - Page 2");
        
        
        JLabel aditionalDetails=new JLabel("Page 2: Additional Details");
        aditionalDetails.setFont(new Font("Raleway",Font.BOLD,18));
        aditionalDetails.setBounds(320,40,320,30);
        add(aditionalDetails);
        
        JLabel name=new JLabel("Religion:");
        name.setBounds(100, 100, 100, 30);
        name.setFont(new Font("ariel",Font.BOLD,16));
        add(name);
        
        String valReligion []={"None","Hindu","Muslim","Christian","Sikh","Other"};
        religionText=new JComboBox(valReligion);
        religionText.setBounds(400,100,300,30);
        religionText.setBackground(Color.white);
        add(religionText);
        
        JLabel fName=new JLabel("Category:");
        fName.setBounds(100, 140, 120, 30);
        fName.setFont(new Font("ariel",Font.BOLD,16));
        add(fName);
        
        String valcategory []={"None","General","OBC","SC","ST","Other"};
        categoryText=new JComboBox(valcategory);
        categoryText.setBounds(400,140,300,30);
        categoryText.setBackground(Color.white);
        add(categoryText);
        
        JLabel income=new JLabel("Income:");
        income.setBounds(100, 180, 120, 30);
        income.setFont(new Font("ariel",Font.BOLD,16));
        add(income);
        
        String valincome []={"None","<100000","100000 to 250000","250000 to 500000","Above 500000"};
        incomeText=new JComboBox(valincome);
        incomeText.setBounds(400,180,300,30);
        incomeText.setBackground(Color.white);
        add(incomeText);

        
        JLabel education=new JLabel("Education Qualification:");
        education.setBounds(100, 220, 220, 30);
        education.setFont(new Font("ariel",Font.BOLD,16));
        add(education);
        
        String valeducation []={"None","Matric","High School","Undergraduate","Graduate","Postgraduate"};
        educationText=new JComboBox(valeducation);
        educationText.setBounds(400,220,300,30);
        educationText.setBackground(Color.white);
        add(educationText);

        
        JLabel occupation=new JLabel("Occupation:");
        occupation.setBounds(100, 260, 120, 30);
        occupation.setFont(new Font("ariel",Font.BOLD,16));
        add(occupation);
        
        String valoccupation []={"None","Aggriculture","Business","Doctor","Private Sector","Teacher","Other"};
        occupationText=new JComboBox(valoccupation);
        occupationText.setBounds(400,260,300,30);
        occupationText.setBackground(Color.white);
        add(occupationText);
        
        JLabel pan=new JLabel("PAN Number:");
        pan.setBounds(100, 300, 120, 30);
        pan.setFont(new Font("ariel",Font.BOLD,16));
        add(pan);
        
        panText=new JTextField();
        panText.setBounds(400,300,300,30);
        panText.setBackground(Color.white);
        add(panText);
        
        JLabel addhaar=new JLabel("Addhaar Number:");
        addhaar.setBounds(100, 340, 220, 30);
        addhaar.setFont(new Font("ariel",Font.BOLD,16));
        add(addhaar);
        
        adhaarText=new JTextField();
        adhaarText.setFont(new Font("Calibari",Font.ITALIC,16));
        adhaarText.setBounds(400, 340, 300, 30);
        add(adhaarText);
        
        JLabel citizen=new JLabel("Senior Citizen:");
        citizen.setBounds(100, 380, 120, 30);
        citizen.setFont(new Font("Calibari",Font.BOLD,16));
        add(citizen);
        
        
        yes=new JRadioButton("Yes");
        yes.setBounds(400,380,60,30);
        yes.setBackground(Color.white);
        add(yes);
        
        no=new JRadioButton("No");
        no.setBounds(520,380,60,30);
        no.setBackground(Color.white);
        add(no);
        
        ButtonGroup citizenGroup=new ButtonGroup();
        citizenGroup.add(yes);
        citizenGroup.add(no);
        
        
        JLabel account=new JLabel("Exixting Account:");
        account.setBounds(100, 420, 220, 30);
        account.setFont(new Font("ariel",Font.BOLD,16));
        add(account);
        
        accountYes=new JRadioButton("Yes");
        accountYes.setBounds(400,420,60,30);
        accountYes.setBackground(Color.white);
        add(accountYes);
        
        accountNo=new JRadioButton("No");
        accountNo.setBounds(520,420,60,30);
        accountNo.setBackground(Color.white);
        add(accountNo);
        
        ButtonGroup accountGroup=new ButtonGroup();
        accountGroup.add(accountYes);
        accountGroup.add(accountNo);
        
        
        
        
        next=new JButton("Next");
        next.setBackground(Color.black);
        next.setForeground(Color.white);
        next.setBounds(380, 550,100,30);
        next.addActionListener(this);
        add(next);
        
        
        setSize(850,700);
        setLocation(220,0);
        setVisible(true);

}
    @Override
    public void actionPerformed(ActionEvent ae){
        String religion= (String) religionText.getSelectedItem();
        String category=(String) categoryText.getSelectedItem();
        String income=(String) incomeText.getSelectedItem();
        String education=(String) educationText.getSelectedItem();
        String occupation= (String) occupationText.getSelectedItem();
        String span=panText.getText();
        String sadhaar=adhaarText.getText();
        
        
        String scitizen=null;
        if(yes.isSelected()){
            scitizen="Yes";
        }else if(no.isSelected()){
            scitizen="No";
        }
        
        String saccount=null;
        if(accountYes.isSelected()){
            saccount="Yes";
        }else if(accountNo.isSelected()){
            saccount="No";
        }
        
        try{ 
                Conn c=new Conn();
                String query="insert into signup_two values('"+formno+"','"+religion+"','"+category+"','"+income+"','"+education+"','"+occupation+"','"+span+"','"+sadhaar+"','"+scitizen+"','"+saccount+"')";
//                String query="delete from signup where formno='8261'";
                c.s.executeUpdate(query);
                
                //
                
                setVisible(false);
                new SignupThree(formno).setVisible(true);
            }catch(Exception e){
            System.out.println(e);
        }
        System.err.println("Entry successfully added");
    }
    
    
    
    public static void main(String[] args) {
    
        new SignupTwo("");
        
    }
}

