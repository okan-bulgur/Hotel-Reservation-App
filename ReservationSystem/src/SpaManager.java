import java.util.Scanner;

public class SpaManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	Spa createSpa() {
		System.out.println("Type the reservation ID to credit this service:");
  		int CustomerID = scanner.nextInt();
  		
  		if(Reservation.totalNumOfReservation < CustomerID) {
  			System.out.println("Invalid customer ID.");
  			return null;
		}
  		
		System.out.println("How many days?");
		int days = scanner.nextInt();
		
		Spa spa = new Spa(CustomerID, days);
		return spa;
	}
}
