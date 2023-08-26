package atm.simulation.system;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener{
    JPasswordField pinf,repinf;
    JButton chg,back;
    JLabel repintext,pintext;
    String pinno;
    Pinchange(String pinno){
        this.pinno = pinno;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        
        JLabel text = new JLabel("Change your Pin");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,18));
        text.setBounds(264,300,700,35);
        img.add(text);
        
       pintext = new JLabel("New Pin :");
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Arial",Font.BOLD,18));
        pintext.setBounds(164,360,250,25);
        img.add(pintext);
        
         pinf = new JPasswordField();
        pinf.setBounds(309,360,150,23);
        pintext.setFont(new Font("Arial",Font.BOLD,18));
        img.add(pinf);
        
        
       
         repintext = new JLabel("Confirm Pin :");
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Arial",Font.BOLD,18));
        repintext.setBounds(164,390,250,25);
        img.add(repintext);
        
        repinf = new JPasswordField();
        repinf.setBounds(309,390,150,23);
        pintext.setFont(new Font("Arial",Font.BOLD,18));
        img.add(repinf);
        
        chg = new JButton("Change");
        chg.setForeground(Color.GREEN);
        chg.setBackground(Color.BLACK);
        chg.setBounds(390,455,120,23);
        chg.setFont(new Font("Arial",Font.BOLD,18));
        chg.addActionListener(this);
        img.add(chg);
        
        back = new JButton("Back");
        back.setForeground(Color.GREEN);
        back.setBackground(Color.BLACK);
        back.setBounds(390,490,120,23);
        back.setFont(new Font("Arial",Font.BOLD,18));
        back.addActionListener(this);
        img.add(back);
        
        setLayout(null);
        setVisible(true);
        setSize(900,900);
        setLocation(300,0);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
       if(ae.getSource()==chg){
        
           try{
        
            if(pintext.getText()!=repintext.getText()){
                JOptionPane.showMessageDialog(null,"Please enter same Pin in both fields");
                return;
            }else{
                if(pintext.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Please enter New Pin");
                return;
                }
                if(repintext.getText().equals("")){
                   JOptionPane.showMessageDialog(null,"Please Re-enter New Pin");
                return;
                
                }
                String npin = pintext.getText();
                Conn conn = new Conn();
                String query1 = "update bank set pinno ='" +npin+ "' where pinno = '"+pinno+"'";
                 String query2 = "update  set login ='" +npin+ "' where pinno = '"+pinno+"'";
                    String query3 = "update signupthree set pinno ='" +npin+ "' where pinno = '"+pinno+"'";
                     
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    conn.s.executeUpdate(query3);
                    
                    JOptionPane.showMessageDialog(null,"Pin changed successfully");
                     setVisible(false);
                     new Transaction(npin).setVisible(true);
            }
       }
        
        catch(Exception e){
            System.out.print(e);
        }
           
           
       }else if(ae.getSource()==back){
           setVisible(false);
           new Transaction(pinno).setVisible(true);
       }
        
        
    }
    
    public static void main(String[] args){
        new Pinchange("");
    }
}
