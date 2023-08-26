package atm.simulation.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Deposite extends JFrame implements ActionListener{
    JTextField depo;
    JButton depbtn,back;
    String pinno;
    Deposite(String pinno){
        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        
        JLabel dep = new JLabel("Enter amount to deposite");
        dep.setBounds(180,300,700,35);
        dep.setForeground(Color.WHITE);
        dep.setFont(new Font("Arial",Font.BOLD,22));
        img.add(dep);
        
        depo = new JTextField();
        depo.setBounds(155,350,350,28);
        depo.setFont(new Font("Arial",Font.BOLD,18));
        img.add(depo);
        
        depbtn = new JButton("Deposite");
        depbtn.setForeground(Color.GREEN);
        depbtn.setBackground(Color.BLACK);
        depbtn.setBounds(350,450,150,30);
        depbtn.addActionListener(this);
        img.add(depbtn);
        
        back = new JButton("Back");
        back.setForeground(Color.GREEN);
        back.setBackground(Color.BLACK);
        back.setBounds(350,490,150,30);
        back.addActionListener(this);
        img.add(back);
        
        
        
        
        
        
        
    setSize(900,900);
    setLocation(300,0);
    setVisible(true);
    setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==depbtn){
            String amount = depo.getText();
            Date date = new Date();
            if(amount.equals("")){
                JOptionPane.showMessageDialog(null,"Please Enter Some Amount");
            }else{
                 try{
                Conn conn = new Conn();
                String query1 = "insert into bank values('" +pinno+ "','" +date+ "','Deposit','" +amount+ "')";
                conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Rs "+amount+" deposited successfully");
                    System.out.print(pinno);
                setVisible(false);
                new Transaction(pinno).setVisible(true);
                 
                 }catch(Exception e){
                    System.out.print(e);
                }
            
            }
        }else if(ae.getSource()==back){
            setVisible(false);
            new Transaction(pinno).setVisible(true);
        }
    }
    
    public static void main(String[] args){
        new Deposite("");
    }
}
