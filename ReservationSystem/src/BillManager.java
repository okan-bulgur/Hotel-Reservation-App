import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BillManager {
	
	private final String months[] = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
	
	Scanner scanner = new Scanner(System.in);

	private Hotel hotel;
		
	public BillManager(Hotel hotel) {
		this.hotel = hotel;
	}
		
	void createBill() {
		String type = inputType();
		double amount = inputAmount();
		String month = null;
		
		while(true) {			
			try {							
				month = inputMonth();
				break;
			} catch (InvalidMonthException e) {
				System.err.println(e.getMessage());
			}
		}
		
		Bills bill = new Bills(type, amount, month);
		hotel.calculables.add(bill);
	}

	String inputType() {
		System.out.println("Type:");
		return scanner.nextLine();
	}
	
	double inputAmount() {
		double amount = 0;
		
		while(true) {
			try {
				System.out.println("Amount:");
				amount = scanner.nextDouble();		
				scanner.nextLine(); //to fix error
				break;
			}catch (InputMismatchException e) {
				System.err.println("\nBill Amount must be a numeric value!\n");
				scanner.nextLine();
			}
		}
		return amount;
	}
	
	String inputMonth() throws InvalidMonthException {
		System.out.println("Month: ");
  		String reservationMonth = scanner.nextLine().toLowerCase();
  		
  		if(!Arrays.asList(months).contains(reservationMonth.toUpperCase())) {
  			throw new InvalidMonthException("\nInvalid input.\n");
  		}
  		return reservationMonth;
	}
}
