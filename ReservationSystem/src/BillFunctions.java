import java.util.ArrayList;
import java.util.Scanner;

public class BillFunctions {
private ArrayList<Calculable> calculables;
	
	Scanner scanner = new Scanner(System.in);
	
	public BillFunctions(ArrayList <Calculable> calculables) {
		this.calculables = calculables;
	}
	
	class Create{
		
		Inputs inputs = new Inputs();
		
		void createBill() {
			String type = inputs.inputType();
			double amount = inputs.inputAmount();
			String month = inputs.inputMonth();
			
			Bills bill = new Bills(type, amount, month);
			calculables.add(bill);
		}
	}
	
	class Inputs{
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
}
