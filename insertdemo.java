import java.sql.DriverManager;
import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

		public class insertdemo {
		    public static void main(String[] args)throws Exception{
		    	Scanner sc=new Scanner(System.in);
		    	System.out.print("Enter Name:");
		    	String Name=sc.nextLine();
		    	System.out.print("Enter Id:");
		    	int Id=sc.nextInt();
		    	System.out.print("Enter Salary:");
		    	int Sal=sc.nextInt();
		    	
		    	Class.forName("com.mysql.jdbc.Driver");
				//System.out.print("successfully");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc_db", "root","123");
				PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?)");
				ps.setString(1, Name);
				ps.setInt(2, Id);
				ps.setInt(3, Sal);
		    	int i=ps.executeUpdate();
		    	if(i>0){
		    		System.out.print("Value is inserted to the database");
		    	}
		    }
		}
				
