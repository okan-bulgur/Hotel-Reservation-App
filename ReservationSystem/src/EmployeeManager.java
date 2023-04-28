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
		System.out.println("ID:");
		return scanner.nextInt();
	}
	
	double inputMonthlyPayment() {
		System.out.println("Monthly Payment:");
		return scanner.nextDouble();
	}
}
