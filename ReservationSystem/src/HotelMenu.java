import java.util.Scanner;
import java.util.Arrays;

public class HotelMenu {
	
	private Scanner ms = new Scanner(System.in);
	
	private final int ROOMNO = 10;  
	
	public String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	public String roomTypes[] = {"Single", "Double", "Club", "Family", "Family with View", "Suite"};
	private Reservation [] reservationInfos = new Reservation[ROOMNO];
	
	private String menuScreen() {
		for(MenuOption menuOption : MenuOption.values()) {
			System.out.printf(menuOption.getOption());
		}
		String userInput = ms.next();
		return userInput;
	}
	
	private void _createReservation() {
		String hotelName = _inputHotelName();
		String roomType = _inputRoomType();
		String reservationMonth = _inputReservationMonth();
		int reservationStart = _inputReservationStart();
		int reservationEnd = _inputReservationEnd(reservationStart);	
		Room room = _createRoom(roomType);
		
		reservationInfos[Reservation.getTotalNumOfReservation()] = new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd, room);
		Reservation.totalNumOfReservation++;
		
  		if(reservationInfos[Reservation.getTotalNumOfReservation()-1] != null) {
  			System.out.println("Reservation created!\n");
  		}
  		else {
  			System.out.println("Reservation not created!\n");
		}
	}
	
	private void _createReservationInitialTypeRoom(String roomType) {
		String hotelName = _inputHotelName();
		String reservationMonth = _inputReservationMonth();
		int reservationStart = _inputReservationStart();
		int reservationEnd = _inputReservationEnd(reservationStart);
		Room room = _createRoom(roomType);
		
		reservationInfos[Reservation.getTotalNumOfReservation()] = new Reservation(hotelName, reservationMonth, reservationStart, reservationEnd, room);
		Reservation.totalNumOfReservation++;
		
  		if(reservationInfos[Reservation.getTotalNumOfReservation()-1] != null) {
  			System.out.println("Reservation created!\n");
  		}
  		else {
  			System.out.println("Reservation not created!\n");
		}
	}
	
	private Room _createRoom(String roomType) {
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
	
	private int _checkReservationStart(int reservationStart) {
		if(reservationStart <= 0 || reservationStart > 30) {
			System.out.println("Invalid input. Please enter again.\n");
  			reservationStart = _inputReservationStart();
		}
		return reservationStart;
	}
	
	private int _checkReservationEnd(int reservationStart, int reservationEnd) {
		if(reservationStart >= reservationEnd || reservationEnd > 30) {
  			System.out.println("Invalid input. Please enter again.\n");
  			reservationEnd = _inputReservationEnd(reservationStart);
  		}
		return reservationEnd;
	}

	private String _inputRoomType() {
		System.out.println("Hotel Type: ");
  		String roomType = ms.nextLine();
  		
  		if(!Arrays.asList(roomTypes).contains(roomType)) {
  			System.out.println("Invalid input.\n");
  			roomType = _inputRoomType();
  		}
  		return roomType;
	}

	private String _inputHotelName() {
		System.out.println("Hotel Name: ");
  		String hotelName = ms.nextLine();
  		ms.nextLine(); //to fix error
  		return hotelName;
	}
	
	private String _inputReservationMonth() {
		System.out.println("Reservation Month: ");
  		String reservationMonth = ms.nextLine();
  		
  		if(!Arrays.asList(months).contains(reservationMonth)) {
  			System.out.println("Invalid input.\n");
  			reservationMonth = _inputReservationMonth();
  		}
  		return reservationMonth;
	}
	
	private int _inputReservationStart() {
		System.out.println("Reservation Start: ");
  		int reservationStart = ms.nextInt();
  		reservationStart = _checkReservationStart(reservationStart);
  		return reservationStart;
	}
	
	private int _inputReservationEnd(int reservationStart) {
		System.out.println("Reservation End: ");
  		int reservationEnd = ms.nextInt();
  		ms.nextLine(); //to fix error
  		reservationEnd = _checkReservationEnd(reservationStart, reservationEnd);
  		return reservationEnd;
	}

	private void _roomDisplay() {
		if(reservationInfos[0] == null) {
  			System.out.println("No room has been created yet.\n");
		}
		else {
			for(int reservation = 0; reservation < reservationInfos.length && reservationInfos[reservation] != null; reservation++) {
	  			reservationInfos[reservation].displayInfo();
	  		}
		}
	}
	
	private void _displayRoomTypesInfo() {
		System.out.println(
				"\nROOM INFOS:\n\n"
				+ "Room Type: Single, Daily Cost: 100, Room Size: 15, Has Bath: false\n"
				+ "Room Type: Double, Daily Cost: 180, Room Size: 30, Has Bath: false\n"
				+ "Room Type: Club, Daily Cost: 250, Room Size: 45, Has Bath: true\n"
				+ "Room Type: Family, Daily Cost: 400, Room Size: 50, Has Bath: false\n"
				+ "Room Type: Family With View, Daily Cost: 450, Room Size: 50, Has Bath: true\n"
				+ "Room Type: Suite, Daily Cost: 650, Room Size: 80, Has Bath: true\n"
				);
	}
	
	public static void main(String[] args) {
		
		HotelMenu hotelMenu = new HotelMenu();
	  
		while(true) {
			String userInput = hotelMenu.menuScreen();
			
			switch(userInput) {
			
		  		case "1":
		  			if(Reservation.getTotalNumOfReservation() < hotelMenu.ROOMNO) {
		  				hotelMenu._createReservationInitialTypeRoom("Single");
					}
		  			else {		  				
		  				System.out.println("There are no room left in the hotel.\n");
		  			}
			  		break;
			  		
		  		case "2":
		  			if(Reservation.getTotalNumOfReservation() < hotelMenu.ROOMNO) {
		  				hotelMenu._displayRoomTypesInfo();
		  				hotelMenu._createReservation();
					}
		  			else {		  				
		  				System.out.println("There are no room left in the hotel.\n");
		  			}
			  		break;
			  	
			  	case "3":
			  		hotelMenu._roomDisplay();
			  		break;
		  	
			  	case "4":
			  		System.out.println(Reservation.getTotalNumOfReservation() + " reservations created so far.\n");
			  		break;
			  		
			  	case "5":
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
 