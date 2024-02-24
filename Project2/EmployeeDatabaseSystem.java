package Project2;

import java.util.Scanner;


public class EmployeeDatabaseSystem {
private static void printMode() {
	System.out.println("\n\n1.Create Employee Detail");
	System.out.println("\n\n2. Remove The Employee Detail");
	System.out.println("\n\n3. Update the Employee Detail");
	System.out.println("\n\n4. Display The All Employee Details");
	System.out.println("\n\n5. Search A Emlopyee Detail");
	System.out.println("\n\n6. Exists Application");
	System.out.println("\n\nEnter The Choice:");
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("\n\t\t\t\tEMPLOYEE DATABASE MANAGEMENT");
		while(true) {
			printMode();
			Scanner input=new Scanner(System.in);
			int Choice=input.nextInt();
			switch(Choice) {
			case 1:
				Employees.toCreateAEmployee();
				break;
			case 2:Employees.toRemoveAEmployee();
				break;
			case 3:
				Employees.toUpdateAEmployee();
				break;
			case 4:
				Employees.toDisplayEmployeeDatabase();
				break;
			case 5:
				Employees.toSearchAEmployee();
				break;
			case 6:
				System.out.println("Application Exited!!!");
				input.close();
				return;
			default:
				System.out.println("Enter The Vaild Chioce:");
				break;
			}
		}
	}

}

