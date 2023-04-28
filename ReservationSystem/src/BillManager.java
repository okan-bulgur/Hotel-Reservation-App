import java.util.ArrayList;
import java.util.Scanner;

public class BillManager {
	
	Scanner scanner = new Scanner(System.in);

	private ArrayList<Calculable> calculables;
		
	public BillManager(ArrayList <Calculable> calculables) {
		this.calculables = calculables;
	}
		
	void createBill() {
		String type = inputType();
		double amount = inputAmount();
		String month = inputMonth();
		
		Bills bill = new Bills(type, amount, month);
		calculables.add(bill);
	}

	String inputType() {
		System.out.println("Type:");
		return scanner.nextLine();
	}
	
	double inputAmount() {
		System.out.println("Amount:");
		return scanner.nextDouble();
	}
	
	String inputMonth() {
		System.out.println("Month:");
		scanner.nextLine(); //to fix error
		return scanner.nextLine();
	}
}
