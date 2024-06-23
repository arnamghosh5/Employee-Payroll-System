
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;


	public class selectdemo {
		public static void main(String[] args)throws Exception{
			Class.forName("com.mysql.jdbc.Driver");
			//System.out.print("successfully");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/jdbc_db", "root","123");
			PreparedStatement ps=con.prepareStatement("select * from employee");
			/*ps.setString(1, Name);*/
			//ps.setInt(1, Sal);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
				System.out.println("Employee Details of the Company:");
				String nm=rs.getString("Name");
				System.out.println("Name:"+nm);
				int id=rs.getInt("Id");
				System.out.println("Id:"+id);
				int sal=rs.getInt("Salary");
				System.out.println("Salary:"+sal);
				System.out.println("-----------------");
			}
		}
	}
