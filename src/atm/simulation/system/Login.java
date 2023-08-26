package atm.simulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    JButton signin , signup , clear;
    JTextField cardTextField;
    JPasswordField pinField;
    Login(){
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 40, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(30,10,200,80);
        add(label);
        
        JLabel text = new JLabel("Welcome to ATM");
        text.setForeground(Color.WHITE);
        text.setBounds(250, 40, 400, 40);
        text.setFont(new Font("osward",Font.BOLD,38));
        add(text);
        
          
         JLabel cardno = new JLabel("Enter Card No.");
         cardno.setForeground(Color.WHITE);
        cardno.setBounds(180, 150, 250, 40);
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        add(cardno);
        
        cardTextField = new JTextField();
        cardTextField.setBounds(400,150,250,40);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
         JLabel pin = new JLabel("Enter Your Pin");
         pin.setForeground(Color.WHITE);
        pin.setBounds(180, 220, 250, 40);
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        add(pin);
        
        pinField = new JPasswordField();
        pinField.setBounds(400,220,250,40);
        pinField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinField);
        
        signin = new JButton("SIGN IN");
        signin.setBounds(400,320,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.WHITE);
        signin.addActionListener(this);
        add(signin);
        
         
        clear = new JButton("CLEAR");
        clear.setBounds(550,320,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(475,360,100,30);
//        signup.setBackground(Color.BLACK);
//        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        getContentPane().setBackground(Color.BLUE);
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinField.setText("");
        }else if(ae.getSource()== signin){
            Conn conn = new Conn();
            String cardno = cardTextField.getText();
            String pinno = pinField.getText();
            String query1 = "select * from signupthree where cardno = '"+cardno+"' and pinno = '"+pinno+"'";
            try{
              ResultSet rs = conn.s.executeQuery(query1); 
              if(rs.next()){
                   setVisible(false);
                  new Transaction(pinno).setVisible(true);
                 
                  
                  
              }else{
                  JOptionPane.showMessageDialog(null,"Wrong Credentials");
              }
            }catch(Exception e){
                System.out.print(e);
            }
            
        }else if(ae.getSource()== signup){
            setVisible(false);
            new SignupOne().setVisible(true);
    }
    }
    public static void main(String[] args){
        new Login();
        
    }
}
