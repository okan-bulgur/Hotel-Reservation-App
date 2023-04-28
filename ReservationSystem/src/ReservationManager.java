import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class ReservationManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	private final String roomTypes[] = {"Single", "Double", "Club", "Family", "Family with View", "Suite"};
	private final String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	private ArrayList<Reservation> reservations;
	
	public ReservationManager(ArrayList<Reservation> reservations) {
		this.reservations = reservations;
	}
	
	Reservation  createReservation() {
		String hotelName = inputHotelName();
		String roomType = inputRoomType();
		String reservationMonth = inputReservationMonth();
		int reservationStart = inputReservationStart();
		int reservationEnd = inputReservationEnd(reservationStart);	
		Room room = createRoom(roomType);	
		
		Reservation reservation = new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd, room); 
		Reservation.totalNumOfReservation++;
		
		reservations.add(reservation);
		
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
	
	String inputReservationMonth() {
		System.out.println("Reservation Month: ");
  		String reservationMonth = scanner.nextLine();
  		
  		if(!Arrays.asList(months).contains(reservationMonth)) {
  			System.out.println("Invalid input.\n");
  			reservationMonth = inputReservationMonth();
  		}
  		return reservationMonth;
	}
	
	int inputReservationStart() {
		System.out.println("Reservation Start: ");
  		int reservationStart = scanner.nextInt();
  		reservationStart = checkReservationStart(reservationStart);
  		return reservationStart;
	}
	
	int inputReservationEnd(int reservationStart) {
		System.out.println("Reservation End: ");
  		int reservationEnd = scanner.nextInt();
  		scanner.nextLine(); //to fix error
  		reservationEnd = checkReservationEnd(reservationStart, reservationEnd);
  		return reservationEnd;
	}
	
	String inputRoomType() {
		System.out.println("Hotel Type: ");
  		String roomType = scanner.nextLine();
  		
  		if(!Arrays.asList(roomTypes).contains(roomType)) {
  			System.out.println("Invalid input.\n");
  			roomType = inputRoomType();
  		}
  		return roomType;
	}
	
	String inputCityName() {
		System.out.println("Type a city name for a reservation search: ");
		String cityName = scanner.nextLine();
		return cityName;
	}
	
	int checkReservationStart(int reservationStart) {
		if(reservationStart <= 0 || reservationStart > 30) {
			System.out.println("Invalid input. Please enter again.\n");
  			reservationStart = inputReservationStart();
		}
		return reservationStart;
	}
	
	int checkReservationEnd(int reservationStart, int reservationEnd) {
		if(reservationStart >= reservationEnd || reservationEnd > 30) {
  			System.out.println("Invalid input. Please enter again.\n");
  			reservationEnd = inputReservationEnd(reservationStart);
  		}
		return reservationEnd;
	}

	void roomDisplay() {
		if(reservations.size() == 0) {
  			System.out.println("No room has been created yet.\n");
		}
		else {
			for(Reservation reservation : reservations) {
				reservation.displayInfo();
			}
		}
	}
	
	void displayReservationByCity() {
		String city = inputCityName();
		Iterator<Reservation> itr = reservations.listIterator();
		
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
			System.out.println("There is not reservation in " + city + "\n");
		}
	}

	int displayReservationsSize() {
		return reservations.size();
	}
}
