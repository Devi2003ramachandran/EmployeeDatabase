package Project2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
public class DbSystem {

	private static final String host="jdbc:mysql://localhost:3306/empdp";
	private static final String userName="root";
	private static final String password="deviga@29";

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(host, userName, password);
			return con;
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static void toAddEmployee(Employees employeeData) {
		try {
			Connection con=getConnection();
			String query = "Insert into employee(empName,empDesigination,empExperience,empSalary)"
					+ "values(?,?,?,?)";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1,employeeData.empName);
			stmt.setString(2,employeeData.empDesigination);
			stmt.setFloat(3,employeeData.empExperience);
			stmt.setInt(4,employeeData.empSalary);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Employee creation Successfully!!!");
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
		public static HashMap<Integer,Employees>toGetDisplayAllEmployeeData(){
			try {
				Connection con=getConnection();
				String query="Select * from  employee";
				PreparedStatement stmt = con.prepareStatement(query);
				ResultSet result = stmt.executeQuery();
				HashMap<Integer, Employees> EmployeeDatabase = new HashMap<>();
				while (result.next()) {
					Employees obj = new Employees();
					obj.empID = result.getInt(1);
					obj.empName = result.getString(2);
					obj.empDesigination = result.getString(3);
					obj.empExperience = result.getString(4).charAt(0);
					obj.empSalary = result.getInt(5);
					EmployeeDatabase.put(obj.empID, obj);
				}
				con.close();
				return EmployeeDatabase;
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			return null;
		}
	public static boolean toemployeeExists(int id) {
		try {
			Connection con=getConnection();
			String query="select * from employee where empID=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			boolean flag=result.next();
			con.close();
			return flag;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	public static void toRemoveEmployee(int id) {
		try {
			Connection con = getConnection();
			String query = "Delete from employee where empID=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Employee with id " + id + " is removed successfully!!!");
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static Employees toSearchStudents(int id) {
		try {
			Connection con = getConnection();
			String query = "Select * from employee where empID=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setInt(1, id);
			ResultSet result = stmt.executeQuery();
			Employees employeeData = new Employees();
			result.next();
			employeeData.empID = result.getInt(1);
			employeeData.empName = result.getString(2);
			employeeData.empDesigination = result.getString(3);
			employeeData.empExperience = result.getFloat(4);
			employeeData.empSalary = result.getInt(5);
			stmt.close();
			con.close();
			return employeeData;

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	public static void toUpdateName(int id,String name) {
		try {
			Connection con =getConnection();
			String query="Update employee set empName=? where empID=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, name);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Employee name is updated succesfully!!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void toUpdateDesigination(int id,String desigination ) {
		try {
			Connection con =getConnection();
			String query="Update employee set empDesigination=? where empID=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setString(1, desigination);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Employee Desigination is updated succesfully!!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void toUpdateExperience(int id,Float Experience ) {
		try {
			Connection con =getConnection();
			String query="Update employee set empExperience=? where empID=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setFloat(1, Experience);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Employee Experience is updated succesfully!!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public static void toUpdateSalary(int id,int salary ) {
		try {
			Connection con =getConnection();
			String query="Update employee set empSalary=? where empID=?";
			PreparedStatement stmt=con.prepareStatement(query);
			stmt.setInt(1, salary);
			stmt.setInt(2, id);
			stmt.executeUpdate();
			stmt.close();
			con.close();
			System.out.println("Employee Salary is updated succesfully!!!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
