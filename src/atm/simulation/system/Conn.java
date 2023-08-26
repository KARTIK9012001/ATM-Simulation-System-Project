package atm.simulation.system;
import java.sql.*;
public class Conn{
    Connection c;
    Statement s;
    public Conn(){
        try{
           
            c = DriverManager.getConnection("jdbc:mysql:///Bank_Management_System","root","K@rtik123");
            s = c.createStatement();
        
        }catch(Exception e){
            System.out.print(e);
        }
    }
}
