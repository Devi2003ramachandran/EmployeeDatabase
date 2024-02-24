package Project2;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import JdbcApplication.DbOperations;

class Employees{
	int empID;
	String empName;
	String empDesigination;
	float empExperience;
	int empSalary;
	static HashMap<Integer,Employees>EmployeeDatabase=new HashMap<Integer,Employees>();
	static int employeeIdCount = 1;
	public static void toCreateAEmployee() {
		System.out.println("Creating A Employee Detail");
		Employees employeeData=new Employees();
		Scanner input=new Scanner(System.in);
		employeeData.empID=employeeIdCount;
		System.out.println("Employee Id:"+employeeData.empID);
		
		System.out.println("Employee Name:");
		employeeData.empName=input.next();
		
		System.out.println("Employee Desigination:");
		employeeData.empDesigination=input.next();
		
		System.out.println("Employee Experience:");
		employeeData.empExperience = input.nextFloat();
		
		System.out.println("Employee Salary:");
		employeeData.empSalary=input.nextInt();
		
		
		EmployeeDatabase.put(employeeData.empID, employeeData);
		employeeIdCount++;
		DbSystem.toAddEmployee(employeeData);

	}
	public static void toRemoveAEmployee() {
		System.out.println("Removing The Employee:");
		Scanner input=new Scanner(System.in);
		System.out.println("Enter an ID to be removed:");
		int id=input.nextInt();
		
		if(DbSystem.toemployeeExists(id)) {
			DbSystem.toRemoveEmployee(id);
			}
		else {
			System.err.println("Employee With Id Does Not Exists");
		}
		
	}
public static void toUpdateAEmployee() {
	System.out.println("Updating A Employee:");
	Scanner input=new Scanner(System.in);
	System.out.println("Enter Id to be Update:");
	int id=input.nextInt();
	if(DbSystem.toemployeeExists(id)) {
		System.out.println("/n1. Enter A EmployeeName");
		System.out.println("\n2. Enter A EmployeeDesigination");
		System.out.println("\n3. Enter A EmployeeExperience");
		System.out.println("\n4. Enter A EmployeeSalary");
		System.out.println("Enter the Choice");
		int choice=input.nextInt();
		switch (choice) {
		case 1:
			System.out.println("Enter the Name:");
			DbSystem.toUpdateName(id, input.next());
			break;
		case 2:
			System.out.println("Enter the Desigination:");
			DbSystem.toUpdateDesigination(id, input.next());
			break;
		case 3:
			System.out.println("Enter the Experience:");
			DbSystem.toUpdateExperience(id, input.nextFloat());
			break;
		case 4:
			System.out.println("Enter the Salary:");
			DbSystem.toUpdateSalary(id, input.nextInt());
			break;
		default:
			System.err.println("Enter a valid choice!!!");
			break;
		}

	}
	else {
		System.err.println("Employee With Id Does Not Exists");
	}
}

public static void toDisplayEmployeeDatabase() {
	HashMap<Integer, Employees> employeeDB = DbSystem.toGetDisplayAllEmployeeData();
	System.out.println("Displaying all Students data");
	System.out.println("------------------------------------------------------------------------------------");
	System.out.println("ID \t Name \t\t Desigination \t Experience \t Salary");
	System.out.println("------------------------------------------------------------------------------------");
	for (Map.Entry<Integer, Employees> employeeEntry :employeeDB .entrySet()) {
		System.out.print(employeeEntry.getKey() + "\t");
		System.out.print(employeeEntry.getValue().empName + "\t\t");
		System.out.print(employeeEntry.getValue().empDesigination + "\t\t");
		System.out.print(employeeEntry.getValue().empExperience + "\t\t");
		System.out.println(employeeEntry.getValue().empSalary +"\t\t\t");
		System.out.println("---------------------------------------------------------------------------------");
	}

}
public static void toSearchAEmployee() {
	System.out.println("Search A Employee Details");
	Scanner input=new Scanner(System.in);
	System.out.println("Enter Id to be Search:");
	int id=input.nextInt();
	if(DbSystem.toemployeeExists(id)) {
		Employees employeeObj=DbSystem.toSearchStudents(id);
		System.out.println("Employee ID          : "+employeeObj.empID);
		System.out.println("Employee Name        : "+employeeObj.empName);
		System.out.println("Employee Desigination: "+employeeObj.empDesigination);
		System.out.println("Employee Experience  : "+employeeObj.empExperience);
		System.out.println("Employee Salary      : "+employeeObj.empSalary);

	}
	else {
		System.out.println("Employee With Id Does Not Exists");
	}
	
	
}
}

