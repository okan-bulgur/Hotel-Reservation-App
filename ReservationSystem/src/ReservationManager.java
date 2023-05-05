import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ReservationManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	private final String roomTypes[] = {"Single", "Double", "Club", "Family", "Family with View", "Suite"};
	private final String months[] = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};
	
	private Hotel hotel;
	
	public ReservationManager(Hotel hotel) {
		this.hotel = hotel;
	}
	
	Reservation  createReservation() {
		String hotelName = inputHotelName();
		String roomType = null;
		String reservationMonth = null;
		
		while(true) {			
			try {			
				roomType = inputRoomType();
				break;
			} catch (InvalidRoomTypeException e) {
				System.err.println(e.getMessage());
			}
		}
		
		while(true) {			
			try {							
				reservationMonth = inputReservationMonth();
				break;
			} catch (InvalidMonthException e) {
				System.err.println(e.getMessage());
			}
		}
		
		int reservationStart = inputReservationStart();
		int reservationEnd = inputReservationEnd(reservationStart);	
		Room room = createRoom(roomType);	
		
		Reservation reservation = new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd, room); 
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
		System.out.println("Hotel Name: ");
  		String hotelName = scanner.nextLine();
  		return hotelName;
	}
	
	String inputReservationMonth() throws InvalidMonthException {
		System.out.println("Reservation Month: ");
  		String reservationMonth = scanner.nextLine().toLowerCase();
  		
  		if(!Arrays.asList(months).contains(reservationMonth.toUpperCase())) {
  			throw new InvalidMonthException("\nInvalid input.\n");
  		}
  		return reservationMonth;
	}
	
	int inputReservationStart() {
		int reservationStart = 0;
		while(true) {
			try {
				System.out.println("Reservation Start: ");
				reservationStart = scanner.nextInt();
				checkReservationStart(reservationStart);
				break;
			} catch (InputMismatchException e) {
				System.err.println("\nReservation Start must be a numeric value!\n");
				scanner.nextLine();
			} catch (InvalidReservationDateException e) {
				System.err.println(e.getMessage());
				scanner.nextLine();
			}
		}
  		return reservationStart;
	}
	
	int inputReservationEnd(int reservationStart) {
		int reservationEnd = 0;
		while(true) {
			try {
				System.out.println("Reservation End: ");
				reservationEnd = scanner.nextInt();
				checkReservationEnd(reservationStart, reservationEnd);		
				break;
			} catch (InputMismatchException e) {
				System.err.println("\nReservation End must be a numeric value!\n");
				scanner.nextLine();
			} catch (InvalidReservationDateException e) {
				System.err.println(e.getMessage());
				scanner.nextLine();
			}
		}
  		return reservationEnd;
	}
	
	String inputRoomType() throws InvalidRoomTypeException{
		System.out.println("Hotel Type: ");
		String roomType = scanner.nextLine();
		
		if(!Arrays.asList(roomTypes).contains(roomType)) {
  			throw new InvalidRoomTypeException("Room Type is not valid!\n");
  		}
  		return roomType;
	}
	
	String inputCityName() {
		System.out.println("Type a city name for a reservation search: ");
		String cityName = scanner.nextLine();
		scanner.nextLine(); //to fix error
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
  			System.err.println("No room has been created yet.\n");
		}
		else {
			for(Reservation reservation : hotel.reservations) {
				reservation.displayInfo();
			}
		}
	}
	
	void displayReservationByCity() {
		String city = inputCityName();
		Iterator<Reservation> itr = hotel.reservations.listIterator();
		
		Reservation reservation;
		String hotelName;
		boolean check = false;

		while(itr.hasNext()) {
			reservation = itr.next();
			if(reservation != null) {
				hotelName = reservation.getHotelName();
				if(hotelName.contains(city)) {
					check = true;
					System.out.println(hotelName);
				}
			}
		}
		if(!check) {
			System.err.println("There is not reservation in " + city + "\n");
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
