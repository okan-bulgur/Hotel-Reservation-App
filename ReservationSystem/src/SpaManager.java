import java.util.InputMismatchException;
import java.util.Scanner;

public class SpaManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	Spa createSpa() {
  		int customerID = inputCustomerID();
		int days = inputDays();
		
		Spa spa = new Spa(customerID, days);
		return spa;
	}
	
	int inputCustomerID() {
		int customerID = 0;
		while(true) {			
			try {
				System.out.println("Type the reservation ID to credit this service:");
				customerID = scanner.nextInt();
				if(Reservation.totalNumOfReservation < customerID || 0 >= customerID) {
		  			throw new InvalidIDException("Invalid customer ID.");
				}
				break;
			} catch (InputMismatchException e) {
				System.err.println("\nID must be a numeric value!\n");
				scanner.nextLine();
			} catch (InvalidIDException e) {
				System.err.println(e.getMessage());
			}
		}
		return customerID;
	}
	
	int inputDays() {
		int days = 0;
		while(true) {
			try {
				System.out.println("How many days?");
				days = scanner.nextInt();		
				break;
			} catch (InputMismatchException e) {
				System.err.println("\nDays must be a numeric value!\n");
				scanner.nextLine();
			}			
		}
		return days;
	}
}
