package atm.simulation.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{
    JRadioButton r1,r2,r3,r4;
    ButtonGroup g1;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit ,cancel;
    String formno;
    SignupThree(String formno){
        this.formno = formno;
        
        
        JLabel heading = new JLabel("Page 3: Account Details");
        heading.setForeground(Color.WHITE);
         heading.setFont(new Font("Arial",Font.BOLD,24));
         heading.setBounds(230,40,350,30);
         add(heading);
         
         JLabel acc = new JLabel("Account Type");
         acc.setForeground(Color.WHITE);
         acc.setBounds(100,100,150,28);
         acc.setFont(new Font("Arial",Font.BOLD,18));
         add(acc);
         
         r1 = new JRadioButton("Saving Account");
         r1.setForeground(Color.WHITE);
         r1.setBackground(Color.BLUE);
         r1.setBounds(350,100,150,28);
         r1.setFont(new Font("Arial",Font.BOLD,15));
         add(r1);
         
          r2 = new JRadioButton("Recurring Deposite Account");
          r2.setForeground(Color.WHITE);
         r2.setBackground(Color.BLUE);
         r2.setBounds(530,100,270,28);
         r2.setFont(new Font("Arial",Font.BOLD,15));
         add(r2);
         
          r3 = new JRadioButton("Current Account");
          r3.setForeground(Color.WHITE);
         r3.setBackground(Color.BLUE);
         r3.setBounds(350,150,150,28);
         r3.setFont(new Font("Arial",Font.BOLD,15));
         add(r3);
         
          r4 = new JRadioButton("Fixed Deposite Account");
          r4.setForeground(Color.WHITE);
         r4.setBackground(Color.BLUE);
         r4.setBounds(530,150,270,28);
         r4.setFont(new Font("Arial",Font.BOLD,15));
         add(r4);
         
         g1 = new ButtonGroup();
         g1.add(r1);
         g1.add(r2);
         g1.add(r3);
         g1.add(r4);
         JLabel dtl = new JLabel("Your Card Details -");
         dtl.setForeground(Color.WHITE);
         dtl.setBounds(100,190,250,28);
         dtl.setFont(new Font("Arial",Font.BOLD,14));
         add(dtl);
         
         JLabel crd = new JLabel("Card No.");
         crd.setForeground(Color.WHITE);
         crd.setBounds(100,230,150,28);
         crd.setFont(new Font("Arial",Font.BOLD,18));
         add(crd);
         
         JLabel num = new JLabel("XXXX-XXXX-XXXX-6372");
         num.setForeground(Color.WHITE);
         num.setBounds(350,230,300,28);
         num.setFont(new Font("Arial",Font.BOLD,18));
         add(num);
         
         JLabel pin = new JLabel("Pin");
         pin.setForeground(Color.WHITE);
         pin.setBounds(100,270,150,28);
         pin.setFont(new Font("Arial",Font.BOLD,18));
         add(pin);
         
         JLabel pnum = new JLabel("XXXX");
         pnum.setForeground(Color.WHITE);
         pnum.setBounds(350,270,150,28);
         pnum.setFont(new Font("Arial",Font.BOLD,18));
         add(pnum);
         
         JLabel src = new JLabel("Services Required");
         src.setForeground(Color.WHITE);
         src.setBounds(100,310,250,28);
         src.setFont(new Font("Arial",Font.BOLD,18));
         add(src);
         
         c1 = new JCheckBox("ATM Card");
         c1.setForeground(Color.WHITE);
         c1.setBackground(Color.BLUE);
         c1.setBounds(100,340,150,28);
          c1.setFont(new Font("Arial",Font.BOLD,18));
          add(c1);
          
          c2 = new JCheckBox("Internet Banking");
          c2.setForeground(Color.WHITE);
         c2.setBackground(Color.BLUE);
         c2.setBounds(350,340,250,28);
          c2.setFont(new Font("Arial",Font.BOLD,18));
          add(c2);
          
          c3 = new JCheckBox("Mobile Banking");
          c3.setForeground(Color.WHITE);
         c3.setBackground(Color.BLUE);
         c3.setBounds(100,370,250,28);
          c3.setFont(new Font("Arial",Font.BOLD,18));
          add(c3);
          
           c4 = new JCheckBox("Cheque Book");
           c4.setForeground(Color.WHITE);
         c4.setBackground(Color.BLUE);
         c4.setBounds(350,370,250,28);
          c4.setFont(new Font("Arial",Font.BOLD,18));
          add(c4);
          
           c5 = new JCheckBox("Email & SMS Alerts");
           c5.setForeground(Color.WHITE);
         c5.setBackground(Color.BLUE);
         c5.setBounds(100,400,450,28);
          c5.setFont(new Font("Arial",Font.BOLD,18));
          add(c5);
         
          c6 = new JCheckBox("E-Statement");
          c6.setForeground(Color.WHITE);
         c6.setBackground(Color.BLUE);
         c6.setBounds(350,400,450,28);
          c6.setFont(new Font("Arial",Font.BOLD,18));
          add(c6);
          
          c7 = new JCheckBox("I here by declare that above entered details are correct to the best of my knowledge");
         c7.setBounds(100,440,450,28);
         c7.setForeground(Color.WHITE);
         c7.setBackground(Color.BLUE);
          c7.setFont(new Font("Arial",Font.BOLD,15));
          add(c7);
          
          submit = new JButton("Submit");
          submit.setBounds(100,480,150,28);
          submit.setFont(new Font("Arial",Font.BOLD,15));
          submit.addActionListener(this);
          add(submit);
          
          cancel = new JButton("Cancel");
          cancel.setBounds(350,480,150,28);
          cancel.setFont(new Font("Arial",Font.BOLD,15));
          cancel.addActionListener(this);
          add(cancel);
         
         
         
         
         
         
         getContentPane().setBackground(Color.BLUE);
         setLayout(null);
         setTitle("New Account Application Form - Page 3");
         setSize(800,580);
         setLocation(350,0);
         setVisible(true);
    }
    //method override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
             String account_type = null;
             if(r1.isSelected()){
                 account_type = "Saving Account";
             }else if(r2.isSelected()){
                 account_type = "Recurring Deposite Account";
             }
             else if(r3.isSelected()){
            account_type = "Current Account";
             }
             else if(r4.isSelected()){
            account_type = "Fixed Deposite Account";
             }
             
             Random random = new Random();
             String cardno =  ""+(Math.abs((random.nextLong()%90000000L)+ 5040936000000000L));
             String pinno = ""+(Math.abs((random.nextLong()%9000L)+ 1000L));
           String facility = "";
           if(c1.isSelected()){
               facility = facility+" ATM Card ";
           }if(c2.isSelected()){
               facility = facility+" Internet Banking ";
           }if(c3.isSelected()){
               facility = facility+" Mobile Banking ";
           }if(c4.isSelected()){
               facility = facility+" Cheque Book ";
           } if(c5.isSelected()){
               facility = facility+" Email & SMS Alerts ";
           } if(c6.isSelected()){
               facility = facility+" E-Statement ";
           }
           
           try {
               if(account_type.equals("")){
                   JOptionPane.showMessageDialog(null,"Account Type is Required");
               }
               
               else{
                   Conn conn = new Conn();
                   String query1 = "insert into signupthree values('" +formno+ "','" +account_type+ "','" +cardno+ "','" +pinno+ "','" +facility+ "')";
                   String query2 =  "insert into login values('" +formno+ "','" +cardno+ "','" +pinno+ "')";
                   
                   conn.s.executeUpdate(query1);
                   conn.s.executeUpdate(query2);
                   
                   JOptionPane.showMessageDialog(null, "Card Number: "+cardno+"\n Pin: "+pinno);
               }
               
               setVisible(false);
               new Deposite(pinno).setVisible(true);
               
           }catch(Exception e){
               System.out.print(e);
           }
           
           
           
        }else if(ae.getSource()==cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
             
    }
    public static void main(String[] args){
        new SignupThree("");
    }
} 
