import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ReservationManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	private final String roomTypes[] = {"Single", "Double", "Club", "Family", "Family with View", "Suite"};
	private final String months[] = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
	
	private Hotel hotel;
	
	public ReservationManager(Hotel hotel) {
		this.hotel = hotel;
	}
	
	Reservation  createReservation() {
		String cityName = inputCityName();
		String hotelName = inputHotelName();
		//String roomType = null;
		String reservationMonth = null;
		
		/*
		while(true) {			
			try {			
				roomType = inputRoomType();
				break;
			} catch (InvalidRoomTypeException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		*/
		
		while(true) {			
			try {							
				reservationMonth = inputReservationMonth();
				break;
			} catch (InvalidMonthException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		int reservationStart = inputReservationStart();
		int reservationEnd = inputReservationEnd(reservationStart);	
		//Room room = createRoom(roomType);	
		
		Reservation reservation = new Reservation(cityName, hotelName, reservationMonth, reservationStart, reservationEnd); 
		Reservation.totalNumOfReservation++;
		
		hotel.reservations.add(reservation);
		
		return reservation;
	}
	
	Room createRoom(String roomType) {
		if(roomType.equals("Single")) {
			return new SingleRoom();
		}
		else if(roomType.equals("Double")) {
			return new DoubleRoom();
		}
		else if(roomType.equals("Club")) {
			return new ClubRoom();
		}
		else if(roomType.equals("Family")) {
			return new FamilyRoom();
		}
		else if(roomType.equals("Family with View")) {
			return new FamilyWithViewRoom();
		}
		else{
			return new SuiteRoom();
		}
	}
	
	String inputHotelName() {
  		String hotelName = JOptionPane.showInputDialog("Hotel Name: ");
  		return hotelName;
	}
	
	String inputReservationMonth() throws InvalidMonthException {
		String reservationMonth = JOptionPane.showInputDialog("Reservation Month: ");
  		reservationMonth = reservationMonth.toLowerCase();
  		
  		if(!Arrays.asList(months).contains(reservationMonth.toUpperCase())) {
  			throw new InvalidMonthException("\nInvalid input.\n");
  		}
  		return reservationMonth;
	}
	
	int inputReservationStart() {
		int reservationStart = 0;
		while(true) {
			try {
				reservationStart = Integer.parseInt( JOptionPane.showInputDialog("Reservation Start: "));
				checkReservationStart(reservationStart);
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, "Reservation Start must be a numeric value!", "ERROR", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidReservationDateException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
  		return reservationStart;
	}
	
	int inputReservationEnd(int reservationStart) {
		int reservationEnd = 0;
		while(true) {
			try {
				reservationEnd = Integer.parseInt( JOptionPane.showInputDialog("Reservation End: "));
				checkReservationEnd(reservationStart, reservationEnd);		
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, "Reservation End must be a numeric value!", "ERROR", JOptionPane.ERROR_MESSAGE);
			} catch (InvalidReservationDateException e) {
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
			}
		}
  		return reservationEnd;
	}
	
	String inputRoomType() throws InvalidRoomTypeException{
		String roomType = JOptionPane.showInputDialog("Hotel Type: ");
		
		if(!Arrays.asList(roomTypes).contains(roomType)) {
  			throw new InvalidRoomTypeException("Room Type is not valid!\n");
  		}
  		return roomType;
	}
	
	String inputCityName() {
		String cityName = JOptionPane.showInputDialog("Enter City: ");
		return cityName;
	}
	
	void checkReservationStart(int reservationStart) throws InvalidReservationDateException {
		if(reservationStart <= 0 || reservationStart >= 30) {
			throw new InvalidReservationDateException("\nInvalid reservation start.\n");
		}
	}
	
	void checkReservationEnd(int reservationStart, int reservationEnd) throws InvalidReservationDateException {
		if(reservationStart >= reservationEnd || reservationEnd > 30) {
			throw new InvalidReservationDateException("\nInvalid reservation end.\n");
  		}
	}

	void roomDisplay() {
		if(hotel.reservations.size() == 0) {
			JOptionPane.showMessageDialog(hotel.menuScreen.frame, "No room has been created yet.", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
		else {
			for(Reservation reservation : hotel.reservations) {
				reservation.displayInfo(hotel.menuScreen);
			}
		}
	}
	
	void displayReservationByCity() {
		String city = inputCityName();
		Iterator<Reservation> itr = hotel.reservations.listIterator();
		
		Reservation reservation;
		String cityName;
		boolean check = false;
		
		hotel.menuScreen.addText("Reservations for " + city + ":\n");

		while(itr.hasNext()) {
			reservation = itr.next();
			if(reservation != null) {
				cityName = reservation.getCityName();
				if(cityName.equals(city)) {
					check = true;
					reservation.displayInfo(hotel.menuScreen);
				}
			}
		}
		if(!check) {
			JOptionPane.showMessageDialog(hotel.menuScreen.frame, "There is not reservation in " + city , "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	int displayReservationsSize() {
		return hotel.reservations.size();
	}

	void sortReservations() {
		
		ArrayList<Reservation> sortedReservations = new ArrayList<Reservation>();
		sortedReservations = hotel.reservations;
		
		Collections.sort(sortedReservations);
		
		for(Reservation reservation : sortedReservations) {
			Reservation.displayServiceInfo(reservation);
		}
	}
}
