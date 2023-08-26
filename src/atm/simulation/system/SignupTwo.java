package atm.simulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class SignupTwo extends JFrame implements ActionListener{
    
    JRadioButton scrbtn,scrbtn2,exacbtn1,exacbtn2;
    JButton next;
    JTextField incm,pantext,adhrtext;
    JComboBox rlgn,catg,educ,ocpn;
    ButtonGroup group1,group2;
    String formno;
    SignupTwo(String formno){
        
        this.formno = formno;
        setLayout(null);
        
       
        
        JLabel heading = new JLabel("Page 2:Additional Details");
        heading.setForeground(Color.WHITE);
        heading.setBounds(230, 40, 350, 30);
        heading.setFont(new Font("Arial",Font.BOLD,24));
        add(heading);
        
        JLabel rlg = new JLabel("Religion ");
        rlg.setForeground(Color.WHITE);
        rlg.setBounds(100, 90, 150, 28);
        rlg.setFont(new Font("Arial",Font.BOLD,18));
        add(rlg);
        
        String str1[] = {"Hindu","Muslim","Sikh","Religion","Other"};
        rlgn = new JComboBox(str1);
        rlgn.setBounds(350,90,300,28);
        add(rlgn);
        
        JLabel cat = new JLabel("Category");
        cat.setForeground(Color.WHITE);
        cat.setBounds(100, 130, 150, 28);
        cat.setFont(new Font("Arial",Font.BOLD,18));
        add(cat);
        
         String str2[] = {"General","SC/ST","OBC","Other"};
        catg = new JComboBox(str2);
        catg.setBounds(350,130,300,28);
        add(catg);
        
        JLabel inc = new JLabel("Income");
        inc.setForeground(Color.WHITE);
        inc.setBounds(100, 170, 150, 28);
        inc.setFont(new Font("Arial",Font.BOLD,18));
        add(inc);
        
        incm = new JTextField();
        incm.setBounds(350,170,300,28);
        incm.setFont(new Font("Arial",Font.BOLD,18));
        add(incm);
        
        
        
        JLabel edu = new JLabel("Educational");
        edu.setBounds(100, 210, 150, 28);
        edu.setFont(new Font("Arial",Font.BOLD,18));
        edu.setForeground(Color.WHITE);
        add(edu);
        JLabel qua = new JLabel("Qualification");
        qua.setForeground(Color.WHITE);
        qua.setBounds(100, 225, 150, 28);
        qua.setFont(new Font("Arial",Font.BOLD,18));
        add(qua);
        
        String str3[] = {"Non-Graduate","Graduation","Post Graduation","Doctrate","Other"};
        educ = new JComboBox(str3);
        educ.setBounds(350,225,300,28);
        add(educ);
        
        
        
        JLabel ocp = new JLabel("Occupation");
        ocp.setForeground(Color.WHITE);
        ocp.setBounds(100, 265, 150, 28);
        ocp.setFont(new Font("Arial",Font.BOLD,18));
        add(ocp);
        
        String str4[] = {"Salaried","Self-Employed","Bussiness","Student","Retired","Other"};
        ocpn = new JComboBox(str4);
        ocpn.setBounds(350,265,300,28);
        add(ocpn);
        
        
        
        JLabel pan = new JLabel("Pan No.");
        pan.setForeground(Color.WHITE);
        pan.setBounds(100, 305, 150, 28);
        pan.setFont(new Font("Arial",Font.BOLD,18));
        add(pan);
        
        pantext = new JTextField();
        pantext.setBounds(350,305,300,28);
        pantext.setFont(new Font("Arial",Font.BOLD,18));
        add(pantext);
        
        JLabel adhr = new JLabel("Aadhar No.");
        adhr.setForeground(Color.WHITE);
        adhr.setBounds(100, 355, 150, 28);
        adhr.setFont(new Font("Arial",Font.BOLD,18));
        add(adhr);
        
        adhrtext = new JTextField();
        adhrtext.setBounds(350,355,300,28);
        adhrtext.setFont(new Font("Arial",Font.BOLD,18));
        add(adhrtext);
        
         JLabel srctzn = new JLabel("Senior Citizen");
         srctzn.setForeground(Color.WHITE);
        srctzn.setBounds(100, 395, 150, 28);
        srctzn.setFont(new Font("Arial",Font.BOLD,18));
        add(srctzn);
        
        scrbtn = new JRadioButton("Yes");
        scrbtn.setBounds(350, 395, 130, 28);
        add(scrbtn);
        scrbtn2 = new JRadioButton("No");
        scrbtn2.setBounds(520, 395, 130, 28);
        add(scrbtn2);
        group1 = new ButtonGroup();
        group1.add(scrbtn);
        group1.add(scrbtn2);
        
        
        
        JLabel  exac = new JLabel("Existing Account");
        exac.setForeground(Color.WHITE);
        exac.setBounds(100, 435, 200, 28);
        exac.setFont(new Font("Arial",Font.BOLD,18));
        add(exac);
        
        exacbtn1 = new JRadioButton("Yes");
        exacbtn1.setBounds(350, 435, 130, 28);
        add(exacbtn1);
        exacbtn2 = new JRadioButton("No");
        exacbtn2.setBounds(520, 435, 130, 28);
        add(exacbtn2);
        group2 = new ButtonGroup();
        group2.add(exacbtn1);
        group2.add(exacbtn2);
        
        next = new JButton("Next");
        next.setBounds(320,500,150,28);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.BLUE);
        setTitle("New Account Application Form - Page 2");
        setSize(800,580);
        setVisible(true);
        setLocation(350,200);
    
}
    public void actionPerformed(ActionEvent ae){
       
        String religion = (String)rlgn.getSelectedItem();
        String category = (String)catg.getSelectedItem();
        String income = incm.getText();
        String qualification = (String)educ.getSelectedItem();
        String occupation = (String)ocpn.getSelectedItem();      
    String senior_citizen = null;
        if(scrbtn.isSelected()){
           senior_citizen   = "Yes";
        }else if(scrbtn2.isSelected()){
            senior_citizen = "No";
        }
        
        String existing_account = null;
        if(exacbtn1.isSelected()){
              existing_account = "Yes";
        }else if(exacbtn2.isSelected()){
            existing_account = "No";
        }
        
        
        
        try {
        if(religion.equals("")){
            JOptionPane.showMessageDialog(null, "Name is Required");
        }else{
            Conn c = new Conn();
            String query = "insert into signuptwo values('"+formno+"','"+ religion +"', '"+ category +"','"+ income +"','"+ qualification +"','"+ occupation +"','"+ senior_citizen +"','"+ existing_account +"')";
            c.s.executeUpdate(query);
            
            //signup3 object
            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }
    }catch(Exception e){
        System.out.print(e);
        
    }
    }
    public static void main(String[] args){
        new SignupTwo("");
    }
}

