package atm.simulation.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;


public class Balanceenquiry extends JFrame implements ActionListener{
    
    String pinno;
    JButton back;
    Balanceenquiry(String pinno){
        this.pinno = pinno;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        
        back = new JButton("back");
        back.setForeground(Color.GREEN);
        back.setBackground(Color.BLACK);
        back.setBounds(390,490,120,23);
        back.setFont(new Font("Arial",Font.BOLD,18));
        back.addActionListener(this);
        img.add(back);
        
        Conn conn = new Conn();
        int balance = 0;
        try{
        ResultSet rs = conn.s.executeQuery("select * from bank where pinno = '" +pinno+ "'");
        
        while(rs.next()){
            if(rs.getString("type").equals("Deposit")){
                balance += Integer.parseInt(rs.getString("amount"));
            }
            else if(rs.getString("type").equals("Withdraw")){
                balance -= Integer.parseInt(rs.getString("amount"));
            }
        
        }
        
        }catch(Exception e){
            System.out.print(e);
        }
        
        JLabel text = new JLabel("Your current account balance");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,22));
        text.setBounds(160,300,700,35);
        img.add(text);
        JLabel text2 = new JLabel("is Rs :"+balance);
        text2.setForeground(Color.WHITE);
        text2.setFont(new Font("Arial",Font.BOLD,22));
        text2.setBounds(160,340,700,35);
        img.add(text2);
        
        
        setLayout(null);
        setVisible(true);
        
        setSize(900,900);
        setLocation(300,0);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        setVisible(false);
        new Transaction(pinno).setVisible(true);
        
        
        
        
        
        
    }
    
    public static void main(String[] args){
        new Balanceenquiry("");
    }
}
