package atm.simulation.system;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Ministatement extends JFrame implements ActionListener{
    JButton b1;
    JLabel card;
    String pinno;
    Ministatement(String pinno){
        this.pinno = pinno;
        
        JLabel text = new JLabel("Ministatement");
        text.setBounds(100,10,250,25);
        text.setFont(new Font("Arial",Font.BOLD,24));
        add(text);
        
        JLabel card = new JLabel();
        card.setBounds(40,50,350,25);
        card.setFont(new Font("Arial",Font.BOLD,14));
        add(card);
        
         JLabel rec = new JLabel();
        rec.setBounds(40, 140, 450, 278);
        rec.setFont(new Font("Arial",Font.BOLD,14));
        add(rec);
        
        JLabel blnc = new JLabel();
        blnc.setBounds(40, 450, 300, 20);
        add(blnc);
        
        
        
        try{
            Conn c = new Conn();
            
            ResultSet rs = c.s.executeQuery("select * from login where pinno = '" +pinno+ "'");
            while(rs.next()){
                card.setText("Card Number:    " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX" + rs.getString("cardno").substring(12));
            }
            
            
        }catch(Exception e){
            System.out.print(e);
        }
        
         try{
            int balance = 0;
            Conn c  = new Conn();
            ResultSet rs = c.s.executeQuery("Select * from bank where pinno = '" +pinno+ "'");
            while(rs.next()){
                
                rec.setText(rec.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }
            if(balance<0){
                 blnc.setText("Your total Balance is Rs 0");
            }else{
            blnc.setText("Your total Balance is Rs "+balance);
            }
        }catch(Exception e){
            System.out.print(e);
        }
         
         b1 = new JButton("close");
         b1.setBounds(130,480,120,25);
         b1.addActionListener(this);
         add(b1);
         
        
        setLayout(null);
        setVisible(true);
        setSize(400,600);
        setLocation(80,20);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        
    }
    
    public static void main(String[] args){
        new Ministatement("");
    }
}
