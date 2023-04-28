import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeManager {
	
	Scanner scanner = new Scanner(System.in);

	private ArrayList<Calculable> calculables;
		
	public EmployeeManager(ArrayList <Calculable> calculables) {
		this.calculables = calculables;
	}
	
	void createEmployee() {
		String name = inputName();
		String surname = inputSurname();
		int ID = inputID();
		double monthlyPayment = inputMonthlyPayment();
		
		Employees employee = new Employees(name, surname, ID, monthlyPayment);
		calculables.add(employee);
	}

	String inputName() {
		scanner.nextLine(); //to fix error
		System.out.println("Name:");
		return scanner.nextLine();
	}
	
	String inputSurname() {
		System.out.println("Surname:");
		return scanner.nextLine();
	}
	
	int inputID() {
		System.out.println("ID:");
		return scanner.nextInt();
	}
	
	double inputMonthlyPayment() {
		System.out.println("Monthly Payment:");
		return scanner.nextDouble();
	}
}
