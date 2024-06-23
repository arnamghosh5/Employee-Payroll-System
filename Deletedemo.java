import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;


public class Deletedemo {
	public static void main(String[]args)throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter Id of the Emp who leave the company:");
    	/*String Name=sc.nextLine();
    	System.out.print("Enter Id:");*/
    	int Id=sc.nextInt();
    	
    	/*System.out.print("Enter Salary:");
    	int Sal=sc.nextInt();*/
    	
    	Class.forName("com.mysql.jdbc.Driver");
		//System.out.print("successfully");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc_db", "root","123");
		PreparedStatement ps=con.prepareStatement("Delete from Employee where Id=?");
		/*ps.setString(1, Name);*/
		//ps.setInt(1, Sal);
		ps.setInt(1, Id);
    	int i=ps.executeUpdate();
    	if(i>0){
    		System.out.print("Value is Deleted from the database");
    	}
    	else{
    		System.out.print("failed");
    	}
	}
	}
