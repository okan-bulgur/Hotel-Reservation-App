import java.util.Scanner;

public class LaundryManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	Laundry createLaundry() {
		System.out.println("Type the reservation ID to credit this service:");
  		int CustomerID = scanner.nextInt();
  		
  		if(Reservation.totalNumOfReservation < CustomerID) {
  			System.out.println("Invalid customer ID.");
  			return null;
		}
  		
		System.out.println("How many pieces of clothing?");
		int piecesOfClothing = scanner.nextInt();
		
		Laundry laundry =  new Laundry(CustomerID, piecesOfClothing);
		return laundry;
	}
	
}
