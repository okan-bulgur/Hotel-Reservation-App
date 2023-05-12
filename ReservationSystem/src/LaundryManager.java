import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class LaundryManager {
	
	Scanner scanner = new Scanner(System.in);	
	private Hotel hotel;
	
	public LaundryManager(Hotel hotel) {
		this.hotel = hotel;
	}

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
	
	int inputPiecesOfClothing() {
		int piecesOfClothing = 0;
		while(true) {
			try {
				piecesOfClothing = Integer.parseInt(JOptionPane.showInputDialog("How many pieces of clothing?"));		
				break;
			} catch (InputMismatchException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, "Clothing count must be a numeric value!", "ERROR", JOptionPane.ERROR_MESSAGE);
			}			
		}
		return piecesOfClothing;
	}
}
