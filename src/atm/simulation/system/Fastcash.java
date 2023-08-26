package atm.simulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;

public class Fastcash extends JFrame implements ActionListener{
    JButton oh,fh,ot,tt,ft,ttt,exit,temp;
    String pinno;
    Fastcash(String pinno){
        this.pinno = pinno ;
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        
        JLabel text = new JLabel("Select Withdrawl Amount");
        text.setBounds(165,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,22));
        img.add(text);
         
        oh = new JButton("Rs 100");
        oh.setForeground(Color.GREEN);
        oh.setBackground(Color.BLACK);
        oh.setFont(new Font("Arial",Font.BOLD,18));
        oh.setForeground(Color.GREEN);
        oh.setBackground(Color.BLACK);
        oh.setBounds(148,393,145,20);
        oh.addActionListener(this);
        img.add(oh);
        
        fh = new JButton("Rs 500");
        fh.setForeground(Color.GREEN);
        fh.setBackground(Color.BLACK);
        fh.setFont(new Font("Arial",Font.BOLD,18));
        fh.setForeground(Color.GREEN);
        fh.setBackground(Color.BLACK);
        fh.setBounds(332,393,180,20);
        fh.addActionListener(this);
        img.add(fh);
        
        ot = new JButton("Rs 1000");
        ot.setForeground(Color.GREEN);
        ot.setBackground(Color.BLACK);
        ot.setFont(new Font("Arial",Font.BOLD,18));
        ot.setForeground(Color.GREEN);
        ot.setBackground(Color.BLACK);
        ot.setBounds(148,425,145,20);
        ot.addActionListener(this);
        img.add(ot);
        
        tt = new JButton("Rs 2000");
        tt.setForeground(Color.GREEN);
        tt.setBackground(Color.BLACK);
        tt.setFont(new Font("Arial",Font.BOLD,18));
        tt.setForeground(Color.GREEN);
        tt.setBackground(Color.BLACK);
        tt.setBounds(332,425,180,20);
        tt.addActionListener(this);
        img.add(tt);
        
        ft = new JButton("Rs 5000");
        ft.setForeground(Color.GREEN);
        ft.setBackground(Color.BLACK);
        ft.setFont(new Font("Arial",Font.BOLD,18));
        ft.setForeground(Color.GREEN);
        ft.setBackground(Color.BLACK);
        ft.setBounds(148,462,145,20);
        ft.addActionListener(this);
        img.add(ft);
        
        ttt = new JButton("Rs 10000");
        ttt.setForeground(Color.GREEN);
        ttt.setBackground(Color.BLACK);
        ttt.setFont(new Font("Arial",Font.BOLD,18));
        ttt.setForeground(Color.GREEN);
        ttt.setBackground(Color.BLACK);
        ttt.setBounds(332,462,180,20);
        ttt.addActionListener(this);
        img.add(ttt);
        
        exit = new JButton("Exit");
        exit.setFont(new Font("Arial",Font.BOLD,18));
        exit.setForeground(Color.GREEN);
        exit.setBackground(Color.BLACK);
        exit.setBounds(332,495,145,20);
        exit.addActionListener(this);
        
        img.add(exit);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==exit){
             System.exit(0);
             
             
         }else{
             // ae.getSource return object so we have to typecast it to (JButton)
             if (ae.getSource() instanceof JButton) {
            JButton clickedButton = (JButton) ae.getSource();
            String buttonText = clickedButton.getText().substring(3);
            Conn c = new Conn();
            
            try{
                ResultSet rs = c.s.executeQuery("select * from bank where pinno = '"+pinno+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!=exit && balance < Integer.parseInt(buttonText)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                 return;
                
                }
                Date date = new Date();
                String query = "insert into bank values('" +pinno+ "','" +date+ "','Withdraw','" +buttonText+ "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+buttonText+" debited successfully");
                setVisible(false);
                new Transaction(pinno).setVisible(true);
            }
            
            
            catch(Exception e){
                System.out.print(e);
            }
//            JOptionPane.showMessageDialog(null, "Amount Rs " + buttonText+" Withdrawn Successfully");
        }
    }
    }
    
    public static void main(String[] args){
          new Fastcash(""); 
    }
}
