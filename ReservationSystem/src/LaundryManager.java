import java.util.InputMismatchException;
import java.util.Scanner;

public class LaundryManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	Laundry createLaundry() {
		int customerID = inputCustomerID();
		int piecesOfClothing = inputPiecesOfClothing();
		
		Laundry laundry =  new Laundry(customerID, piecesOfClothing);
		return laundry;
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
	
	int inputPiecesOfClothing() {
		int piecesOfClothing = 0;
		while(true) {
			try {
				System.out.println("How many pieces of clothing?");
				piecesOfClothing = scanner.nextInt();		
				break;
			} catch (InputMismatchException e) {
				System.err.println("\nClothing count must be a numeric value!\n");
				scanner.nextLine();
			}			
		}
		return piecesOfClothing;
	}
}
