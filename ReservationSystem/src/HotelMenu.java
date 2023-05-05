import java.util.InputMismatchException;
import java.util.Scanner;

public class HotelMenu {
	
	Scanner scanner = new Scanner(System.in);	
	
	private Hotel hotel;
		
	public HotelMenu(Hotel hotel) {
		this.hotel = hotel;
	}
	
	void displayHotelMenu() {
		
		while(true) {
			int userInput = 0;
			userInput = getInput();
			System.out.println();				

			switch(userInput) {
			
		  		case 1:
		  			displayRoomTypesInfo();
		  		    hotel.servicesManager.addReservation();
			  		break;
			  	
			  	case 2:
			  		hotel.reservationManager.roomDisplay();
			  		break;
			  		
			  	case 3:
			  		hotel.reservationManager.displayReservationByCity();
			  		break;
			  		
			  	case 4:
			  		hotel.servicesManager.addExtraServices();
			  		break;
			  		
			  	case 5:
			  		hotel.servicesManager.displayServices();
			  		break;
	
			  	case 6:
			  		hotel.servicesManager.displayTotalCostByCustomer();
			  		break;
			  	
			  	case 7:
			  		hotel.employeeManager.createEmployee();
			  		break;
			  	
			  	case 8:
			  		hotel.billManager.createBill();
			  		break;
			  		
			  	case 9:
			  		hotel.calculableManager.displayMonthlyBalance();
			  		break;
			  		
			  	case 10:
			  		hotel.servicesManager.sortServices();
			  		break;
			  				 
			  	case 11:
			  		hotel.reservationManager.sortReservations();
			  		break;
			  				 
			  	case 12:
			  		System.out.println("Exiting, Goodbye!");
			  		System.exit(0);
			  		break;
			  				  	
			  	default:
			  		System.err.println("\nYou entered an invalid menu option. Enter again.\n");
			  		break;  		
			}
		}
	}
	
	int getInput(){
		int userInput = 0;
		
		while(true) {
			try {
				displayMenuOptions();
				userInput = scanner.nextInt();			
				break;
			}catch (InputMismatchException e) {
				System.err.println("\nYou entered an invalid menu option. Enter again.\n");
				scanner.nextLine();
			}
		}
		return userInput;
	}
	
	void displayMenuOptions() {
		System.out.println();
		for(MenuOption menuOption : MenuOption.values()) {
			System.out.printf(menuOption.getOption());
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
}
