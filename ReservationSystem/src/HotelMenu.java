import java.util.Scanner;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HotelMenu {
	
	private Scanner ms = new Scanner(System.in);
	private final int ROOMNO = 3;  
	private Reservation [] reservationInfos = new Reservation[ROOMNO];
	
	private String menuScreen() {
		for(MenuOption menuOption : MenuOption.values()) {
			System.out.printf(menuOption.getOption());
		}
		String userInput = ms.next();
		return userInput;
	}
	
	private void removeReservationByCity() {
		System.out.println("Type a city name for remove:");
		String cityName = ms.next();
		String hotelName;
		
		List<Reservation> listReservation = Arrays.asList(reservationInfos);
		Iterator<Reservation> itr = listReservation.listIterator();
		
		while(itr.hasNext()) {
			hotelName = itr.next().getHotelName();
			if(hotelName.contains(cityName)) {
				itr.remove();
			}
		}
	}
	
	public static void main(String[] args) {
		
		HotelMenu hotelMenu = new HotelMenu();
		
		Create create = new Create(hotelMenu.reservationInfos, hotelMenu.ms);
		Display display = new Display(hotelMenu.reservationInfos);
		Inputs inputs = new Inputs(hotelMenu.ms);
	  
		while(true) {
			String userInput = hotelMenu.menuScreen();
			
			switch(userInput) {
			
		  		case "1":
		  			if(Reservation.getTotalNumOfReservation() < hotelMenu.ROOMNO) {
		  				create.createReservationInitialTypeRoom("Single");
					}
		  			else {		  				
		  				System.out.println("There are no room left in the hotel.\n");
		  			}
			  		break;
			  		
		  		case "2":
		  			if(Reservation.getTotalNumOfReservation() < hotelMenu.ROOMNO) {
		  				display.displayRoomTypesInfo();
		  				create.createReservation();
					}
		  			else {		  				
		  				System.out.println("There are no room left in the hotel.\n");
		  			}
			  		break;
			  	
			  	case "3":
			  		display.roomDisplay();
			  		break;
		  	
			  	case "4":
			  		System.out.println(Reservation.getTotalNumOfReservation() + " reservations created so far.\n");
			  		break;
			  		
			  	case "5":
			  		String cityName = inputs.inputCityName();
			  		display.displayReservationByCity(cityName);
			  		break;
			  		
			  	case "6":
			  		hotelMenu.removeReservationByCity();
			  		break;
			  		
			  	case "7":
			  		System.out.println("Exit...");
			  		System.exit(0);
			  		break;
			  	
			  	default:
			  		System.out.println("Please enter valid input!\n");
			  		break;  		
			}
		}
    }
}

class Create{
	
	private Reservation [] reservationInfos;
	private Scanner scanner;
	private Inputs inputs;
	
	public Create(Reservation [] reservationInfos, Scanner scanner) {
		this.reservationInfos = reservationInfos;
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
		
		reservationInfos[Reservation.getTotalNumOfReservation()] = new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd, room);
		Reservation.totalNumOfReservation++;
		
  		if(reservationInfos[Reservation.getTotalNumOfReservation()-1] != null) {
  			System.out.println("Reservation created!\n");
  		}
  		else {
  			System.out.println("Reservation not created!\n");
		}
	}
	
	void createReservationInitialTypeRoom(String roomType) {
	
		String hotelName = inputs.inputHotelName();
		String reservationMonth = inputs.inputReservationMonth();
		int reservationStart = inputs.inputReservationStart();
		int reservationEnd = inputs.inputReservationEnd(reservationStart);
		Room room = createRoom(roomType);
		
		reservationInfos[Reservation.getTotalNumOfReservation()] = new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd, room);
		Reservation.totalNumOfReservation++;
		
  		if(reservationInfos[Reservation.getTotalNumOfReservation()-1] != null) {
  			System.out.println("Reservation created!\n");
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

}

class Display{
	
	private Reservation [] reservationInfos;
	
	public Display (Reservation [] reservationInfos) {
		this.reservationInfos = reservationInfos;
	}
	
	void roomDisplay() {
		if(reservationInfos[0] == null) {
  			System.out.println("No room has been created yet.\n");
		}
		else {
			for(int reservation = 0; reservation < reservationInfos.length && reservationInfos[reservation] != null; reservation++) {
	  			reservationInfos[reservation].displayInfo();
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
		List<Reservation> listReservation = Arrays.asList(reservationInfos);
		Iterator<Reservation> itr = listReservation.listIterator();
		
		String hotelName;
		boolean check = false;

		while(itr.hasNext()) {
			hotelName = itr.next().getHotelName();
			if(hotelName.contains(city)) {
				check = true;
				System.out.println(hotelName + "\n");
			}
		}
		if(!check) {
			System.out.println("There is not reservation in " + city + "\n");
		}
	}
}


class Inputs{
	
	private Scanner scanner;
	private String roomTypes[] = {"Single", "Double", "Club", "Family", "Family with View", "Suite"};
	private final String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	
	public Inputs(Scanner scanner) {
		this.scanner = scanner;
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
 