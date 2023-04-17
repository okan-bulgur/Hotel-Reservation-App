import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ServiceFunctions {
	
	private static ArrayList<Services> services = new ArrayList<Services>();
	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	private static Map<Integer, Double> totalCostByID = new HashMap<Integer, Double>();
	
	class Create{
		
		private Scanner scanner;
		private Inputs inputs;
		
		public Create(Scanner scanner) {
			this.scanner = scanner;
			inputs = new Inputs(this.scanner);
		}
		
		void createReservation() {
			
			String hotelName = inputs.inputHotelName();
			String roomType = inputs.inputRoomType();
			String reservationMonth = inputs.inputReservationMonth();
			int reservationStart = inputs.inputReservationStart();
			int reservationEnd = inputs.inputReservationEnd(reservationStart);	
			Room room = createRoom(roomType);	
			Services reservation = new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd, room); 
			
			reservations.add((Reservation)reservation);
			services.add(reservation);

			Reservation.totalNumOfReservation++;
			
			totalCostByID.put(Reservation.totalNumOfReservation, reservation.calculateService());
			
	  		if(reservations.get(reservations.size()-1) != null) {
	  			System.out.println("Reservation ID: " + Reservation.totalNumOfReservation + " is created\n");
	  		}
	  		else {
	  			System.out.println("Reservation not created!\n");
			}
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

		void createService() {
			if(reservations.size() == 0) {
				System.out.println("There is not any reservation. Service cannot be used.");
				return;
			}
			
			System.out.println("Please select one of the extra services from below:");
			System.out.println("1. Laundry Service \n2. Spa Service");
	  		int servicesNo = scanner.nextInt();
	  		
	  		Services service = null;
	  		
	  		switch (servicesNo) {
	  		
				case 1:
					service = createLaundry();
					break;
					
				case 2:
					service = createSpa();
					break;
					
				default:
					System.out.println("Enter a valid input.");
					break;
			}
	  		if(service != null) {	  			
	  			services.add(service);
	  		}
		}

		Services createLaundry() {
			System.out.println("Type the reservation ID to credit this service:");
	  		int CustomerID = scanner.nextInt();
	  		
	  		if(reservations.size() < CustomerID) {
	  			System.out.println("Invalid customer ID.");
	  			return null;
			}
	  		
			System.out.println("How many pieces of clothing?");
			int piecesOfClothing = scanner.nextInt();
			Services laundry =  new Laundry(CustomerID, piecesOfClothing);
			totalCostByID.put(CustomerID, totalCostByID.get(CustomerID) + laundry.calculateService());
			return laundry;
		}
		
		Services createSpa() {
			System.out.println("Type the reservation ID to credit this service:");
	  		int CustomerID = scanner.nextInt();
	  		
	  		if(reservations.size() < CustomerID) {
	  			System.out.println("Invalid customer ID.");
	  			return null;
			}
	  		
			System.out.println("How many days?");
			int days = scanner.nextInt();
			Spa spa = new Spa(CustomerID, days);
			totalCostByID.put(CustomerID, totalCostByID.get(CustomerID) + spa.calculateService());
			return spa;
		}
	}

	class Display{
		
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
		
		void displayRoomTypesInfo() {
			System.out.println(
					"\nROOM INFOS:\n\n"
					+ "Room Type: "+ SingleRoom.roomType +", Daily Cost: "+ SingleRoom.dailyCost +", Room Size: "+ SingleRoom.roomSize +", Has Bath: "+ SingleRoom.hasBath +"\n"
					+ "Room Type: "+ DoubleRoom.roomType +", Daily Cost: "+ DoubleRoom.dailyCost +", Room Size: "+ DoubleRoom.roomSize +", Has Bath: "+ DoubleRoom.hasBath +"\n"
					+ "Room Type: "+ ClubRoom.roomType +", Daily Cost: "+ ClubRoom.dailyCost +", Room Size: "+ ClubRoom.roomSize +", Has Bath: "+ ClubRoom.hasBath +"\n"
					+ "Room Type: "+ FamilyRoom.roomType +", Daily Cost: "+ FamilyRoom.dailyCost +", Room Size: "+ FamilyRoom.roomSize +", Has Bath: "+ FamilyRoom.hasBath +"\n"
					+ "Room Type: "+ FamilyWithViewRoom.roomType +", Daily Cost: "+ FamilyWithViewRoom.dailyCost +", Room Size: "+ FamilyWithViewRoom.roomSize +", Has Bath: "+ FamilyWithViewRoom.hasBath +"\n"
					+ "Room Type: "+ SuiteRoom.roomType +", Daily Cost: "+ SuiteRoom.dailyCost +", Room Size: "+ SuiteRoom.roomSize +", Has Bath: "+ SuiteRoom.hasBath +"\n"
					);
		}

		void displayReservationByCity(String city) {
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

		void displayServices() {
			if(services.size() == 0) {
	  			System.out.println("There is not service.");
	  			return;
	  		}
	  		Iterator<Services> itr = services.listIterator();
	  		while(itr.hasNext()) {
	  			Services ser = itr.next();
	  			System.out.println(ser);
	  		}
		}

		void displayServicesByCustomer() {
			if(services.size() == 0) {
	  			System.out.println("There is not any services.");
	  			return;
	  		}
			
			for(Integer ID : totalCostByID.keySet()) {
				double totalCost = totalCostByID.get(ID);
				System.out.println("The cost for the Room booking service of reservation ID " + ID + ": " + totalCost);
			}
		}
		
		int displayReservationsSize() {
			return reservations.size();
		}
		
		int displayServicesSize() {
			return services.size();
		}
	}

	class Inputs{
		
		private Scanner scanner;
		private String roomTypes[] = {"Single", "Double", "Club", "Family", "Family with View", "Suite"};
		private final String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		
		
		public Inputs(Scanner scanner) {
			this.scanner = scanner;
		}

		String menuScreen() {
			System.out.println();
			for(MenuOption menuOption : MenuOption.values()) {
				System.out.printf(menuOption.getOption());
			}
			String userInput = scanner.next();
			return userInput;
		}
		
		String inputHotelName() {
			System.out.println("Hotel Name: ");
			scanner.nextLine(); //to fix error
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
			scanner.nextLine(); //to fix error
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

	}
}
