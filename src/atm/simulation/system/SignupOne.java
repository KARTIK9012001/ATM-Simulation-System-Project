package atm.simulation.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener{
    long random;
    JTextField textname,fatname,emtext,adrtext,ctytext,sttext,pntext;
    JDateChooser datechooser ;
    JRadioButton gdbtn,gdbtn2,mrtbtn,mrtbtn2;
    ButtonGroup group1,group2;
    JButton next;
    
    SignupOne(){
        Random ran = new Random();
        
        setLayout(null);
        
        random = Math.abs((ran.nextLong()%9000l)+1000L);
        JLabel app = new JLabel("Application No."+random);
        app.setForeground(Color.WHITE);
        app.setBounds(320, 15, 350, 20);
        app.setFont(new Font("Arial",Font.BOLD,18));
        add(app);
        
        JLabel heading = new JLabel("Page 1:Personal Details");
        heading.setForeground(Color.WHITE);
        heading.setBounds(230, 40, 350, 30);
        heading.setFont(new Font("Arial",Font.BOLD,24));
        add(heading);
        
        JLabel name = new JLabel("Name ");
        name.setForeground(Color.WHITE);
        name.setBounds(100, 90, 150, 28);
        name.setFont(new Font("Arial",Font.BOLD,18));
        add(name);
        
        textname = new JTextField();
        textname.setBounds(350,90,300,28);
        textname.setFont(new Font("Arial",Font.BOLD,18));
        add(textname);
        
        
         JLabel Fat = new JLabel("Father's Name");
         Fat.setForeground(Color.WHITE);
        Fat.setBounds(100, 130, 150, 28);
        Fat.setFont(new Font("Arial",Font.BOLD,18));
        add(Fat);
        
        fatname = new JTextField();
        fatname.setBounds(350,130,300,28);
        fatname.setFont(new Font("Arial",Font.BOLD,18));
        add(fatname);
        
        JLabel dob = new JLabel("Date of Birth");
        dob.setForeground(Color.WHITE);
        dob.setBounds(100, 170, 150, 28);
        dob.setFont(new Font("Arial",Font.BOLD,18));
        add(dob);
        
        datechooser = new JDateChooser();
        datechooser.setBounds(350, 170,300, 28);
        add(datechooser);
        
        JLabel Gd = new JLabel("Gender");
        Gd.setForeground(Color.WHITE);
        Gd.setBounds(100, 210, 150, 28);
        Gd.setFont(new Font("Arial",Font.BOLD,18));
        add(Gd);
        
        gdbtn = new JRadioButton("Male");
        gdbtn.setBounds(350,210,130,28);
        add(gdbtn);
        gdbtn2 = new JRadioButton("Female");
        gdbtn2.setBounds(520,210,130,28);
        add(gdbtn2);
        group1 = new ButtonGroup();
        group1.add(gdbtn);
        group1.add(gdbtn2);
        
        
        JLabel Em = new JLabel("E-mail Address");
        Em.setForeground(Color.WHITE);
        Em.setBounds(100, 250, 150, 28);
        Em.setFont(new Font("Arial",Font.BOLD,18));
        add(Em);
        
        emtext = new JTextField();
        emtext.setBounds(350,250,300,28);
        emtext.setFont(new Font("Arial",Font.BOLD,18));
        add(emtext);
        
        JLabel Mrt = new JLabel("Marital Status");
         Mrt.setForeground(Color.WHITE);
        Mrt.setBounds(100, 290, 150, 28);
        Mrt.setFont(new Font("Arial",Font.BOLD,18));
        add(Mrt);
        
        mrtbtn = new JRadioButton("Married");
        mrtbtn.setBounds(350,290,130,28);
        add(mrtbtn);
        mrtbtn2 = new JRadioButton("Unmarried");
        mrtbtn2.setBounds(520,290,130,28);
        add(mrtbtn2);
        group2 = new ButtonGroup();
        group2.add(mrtbtn);
        group2.add(mrtbtn2);
        
        JLabel Adr = new JLabel("Address");
         Adr.setForeground(Color.WHITE);
        Adr.setBounds(100, 330, 150, 28);
        Adr.setFont(new Font("Arial",Font.BOLD,18));
        add(Adr);
        
        adrtext = new JTextField();
        adrtext.setBounds(350,330,300,28);
        adrtext.setFont(new Font("Arial",Font.BOLD,18));
        add(adrtext);
        
        JLabel cty = new JLabel("City");
         cty.setForeground(Color.WHITE);
        cty.setBounds(100, 370, 150, 28);
        cty.setFont(new Font("Arial",Font.BOLD,18));
        add(cty);
        
        ctytext = new JTextField();
        ctytext.setBounds(350,370,300,28);
        ctytext.setFont(new Font("Arial",Font.BOLD,18));
        add(ctytext);
        
         JLabel st = new JLabel("State");
          st.setForeground(Color.WHITE);
        st.setBounds(100, 410, 150, 28);
        st.setFont(new Font("Arial",Font.BOLD,18));
        add(st);
        
        sttext = new JTextField();
        sttext.setBounds(350,410,300,28);
        sttext.setFont(new Font("Arial",Font.BOLD,18));
        add(sttext);
        
        JLabel pn = new JLabel("Pin Code");
         pn.setForeground(Color.WHITE);
        pn.setBounds(100, 450, 150, 28);
        pn.setFont(new Font("Arial",Font.BOLD,18));
        add(pn);
        
        pntext = new JTextField();
        pntext.setBounds(350,450,300,28);
        pntext.setFont(new Font("Arial",Font.BOLD,18));
        add(pntext);
        
        next = new JButton("Next");
        next.setBounds(320,500,150,28);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.BLUE);
        setTitle("New Account Application Form");
        setSize(800,580);
        setVisible(true);
        setLocation(350,200);
    
}
    public void actionPerformed(ActionEvent ae){
        String formno =random+"";
        
        String name = textname.getText();
        String fname = fatname.getText();
        String dob = ((JTextField) datechooser.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(gdbtn.isSelected()){
            gender  = "Male";
        }else if(gdbtn2.isSelected()){
            gender = "Female";
        }
        String email = emtext.getText();
        String marital_status = null;
        if(mrtbtn.isSelected()){
              marital_status= "Married";
        }else if(gdbtn2.isSelected()){
            marital_status = "Unmarried";
        }
        
        String address = adrtext.getText();
        String city = ctytext.getText();
        String state = sttext.getText();
        String pincode = pntext.getText();
        
        try {
        if(name.equals("")){
            JOptionPane.showMessageDialog(null, "Name is Required");
        }else{
            Conn c = new Conn();
            String query = "insert into signup values('"+ formno +"', '"+ name +"','"+ fname +"','"+ dob +"','"+ gender +"','"+ email +"','"+ marital_status +"','"+ address +"','"+ city +"','"+ state +"','"+ pincode +"')";
            c.s.executeUpdate(query);
            setVisible(false);
            new SignupTwo(formno).setVisible(true);
        }
    }catch(Exception e){
        System.out.print(e);
        
    }
    }
    public static void main(String[] args){
        new SignupOne();
    }
}
