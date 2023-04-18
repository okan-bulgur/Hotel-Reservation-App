import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeFunctions {
	
	private ArrayList<Calculable> calculables;
	
	Scanner scanner = new Scanner(System.in);
	
	public EmployeeFunctions(ArrayList <Calculable> calculables) {
		this.calculables = calculables;
	}
	
	class Create{
		
		Inputs inputs = new Inputs();
		
		void createEmployee() {
			String name = inputs.inputName();
			String surname = inputs.inputSurname();
			int ID = inputs.inputID();
			double monthlyPayment = inputs.inputMonthlyPayment();
			
			Employees employee = new Employees(name, surname, ID, monthlyPayment);
			calculables.add(employee);
		}
	}
	
	class Inputs{
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
}
