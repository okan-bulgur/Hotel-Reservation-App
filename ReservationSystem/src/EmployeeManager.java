import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManager {
	
	Scanner scanner = new Scanner(System.in);

	private Hotel hotel;
		
	public EmployeeManager(Hotel hotel) {
		this.hotel = hotel;
	}
	
	void createEmployee() {
		String name = inputName();
		String surname = inputSurname();
		int ID = inputID();
		double monthlyPayment = inputMonthlyPayment();
		
		Employees employee = new Employees(name, surname, ID, monthlyPayment);
		hotel.calculables.add(employee);
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
		int ID = 0;
		while(true) {			
			try {
				System.out.println("ID:");
				ID = scanner.nextInt();
				break;
			} catch (InputMismatchException e) {
				System.err.println("\nID must be a numeric value!\n");
				scanner.nextLine();
			}
		}
		return ID;
	}
	
	double inputMonthlyPayment() {
		double monthlyPayment = 0;
		
		while(true) {
			try {
				System.out.println("Monthly Payment:");
				monthlyPayment = scanner.nextDouble();
				break;
			} catch (InputMismatchException e) {
				System.err.println("Monthly Payment must be a numeric value!");
				scanner.nextLine();
			}
		}
		return monthlyPayment;
	}
}
