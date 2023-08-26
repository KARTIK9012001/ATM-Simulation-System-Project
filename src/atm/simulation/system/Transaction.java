package atm.simulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Transaction extends JFrame implements ActionListener{
    JButton dep,csh,fstcsh,stt,pin,blc,ext;
    String pinno;
    
    Transaction(String pinno){
        this.pinno = pinno;
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
         JLabel img = new JLabel(i3);
        img.setBounds(0,0,900,900);
        add(img);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(165,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Arial",Font.BOLD,22));
        img.add(text);
         
        dep = new JButton("Deposite");
        dep.setFont(new Font("Arial",Font.BOLD,18));
        dep.setForeground(Color.GREEN);
        dep.setBackground(Color.BLACK);
        dep.setBounds(148,393,145,20);
        dep.addActionListener(this);
        img.add(dep);
        
        csh = new JButton("Cash Withdrawl");
        csh.setFont(new Font("Arial",Font.BOLD,18));
        csh.setForeground(Color.GREEN);
        csh.setBackground(Color.BLACK);
        csh.setBounds(332,393,180,20);
        csh.addActionListener(this);
        img.add(csh);
        
        fstcsh = new JButton("Fast Cash");
        fstcsh.setFont(new Font("Arial",Font.BOLD,18));
        fstcsh.setForeground(Color.GREEN);
        fstcsh.setBackground(Color.BLACK);
        fstcsh.setBounds(148,425,145,20);
        fstcsh.addActionListener(this);
        img.add(fstcsh);
        
        stt = new JButton("Mini Statement");
        stt.setFont(new Font("Arial",Font.BOLD,18));
        stt.setForeground(Color.GREEN);
        stt.setBackground(Color.BLACK);
        stt.setBounds(332,425,180,20);
        stt.addActionListener(this);
        img.add(stt);
        
        pin = new JButton("Pin Change");
        pin.setFont(new Font("Arial",Font.BOLD,18));
        pin.setForeground(Color.GREEN);
        pin.setBackground(Color.BLACK);
        pin.setBounds(148,462,145,20);
        img.add(pin);
        
        blc = new JButton("Balance Enquiry");
        blc.setFont(new Font("Arial",Font.BOLD,18));
        blc.setForeground(Color.GREEN);
        blc.setBackground(Color.BLACK);
        blc.setBounds(332,462,180,20);
        blc.addActionListener(this);
        img.add(blc);
        
        ext = new JButton("Exit");
        ext.setFont(new Font("Arial",Font.BOLD,18));
        ext.setForeground(Color.GREEN);
        ext.setBackground(Color.BLACK);
        ext.setBounds(148,495,145,20);
        ext.addActionListener(this);
        img.add(ext);
        
        
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent ae){
         if(ae.getSource()==ext){
             System.exit(0);
         }else if(ae.getSource()==dep){
             setVisible(false);
             new Deposite(pinno).setVisible(true);
             
         }else if(ae.getSource()==csh){
             setVisible(false);
             new Withdrawl(pinno).setVisible(true);
             
         }else if(ae.getSource()==fstcsh){
             JLabel pn = new JLabel(pinno);
             
             
             setVisible(false);
             new Fastcash(pinno).setVisible(true);
             
         }
         else if(ae.getSource()==pin){
             setVisible(false);
             new Pinchange(pinno).setVisible(true);
         }
         else if(ae.getSource()==blc){
             setVisible(false);
             new Balanceenquiry(pinno).setVisible(true);
         }
         else if(ae.getSource()==stt){
             
             new Ministatement(pinno).setVisible(true);
         }
    }
    
    public static void main(String[] args){
          new Transaction("");
    }
}
