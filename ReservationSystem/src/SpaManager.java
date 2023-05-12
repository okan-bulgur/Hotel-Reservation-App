import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class SpaManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	private Hotel hotel;
	
	public SpaManager(Hotel hotel) {
		this.hotel = hotel;
	}
	
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
				customerID = Integer.parseInt(JOptionPane.showInputDialog("Type the reservation ID to credit this service:"));
				if(Reservation.totalNumOfReservation < customerID || 0 >= customerID) {
		  			throw new InvalidIDException("Invalid customer ID.");
				}
				break;
			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, "ID must be a numeric value!", "ERROR", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidIDException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		return customerID;
	}
	
	int inputDays() {
		int days = 0;
		while(true) {
			try {
				days = Integer.parseInt(JOptionPane.showInputDialog("How many days?"));	
				break;
			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, "Days must be a numeric value!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}			
		}
		return days;
	}
}
