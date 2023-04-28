import java.util.Scanner;

public class HotelMenu {
	
	Scanner scanner = new Scanner(System.in);	
	
	private ReservationManager reservationManager;
	private ServicesManager servicesManager;
	private EmployeeManager employeeManager;
	private BillManager billManager;
	private CalculableManager calculableManager;
		
	public HotelMenu(ReservationManager reservationManager, ServicesManager servicesManager, EmployeeManager employeeManager, BillManager billManager, CalculableManager calculableManager) {
		this.reservationManager = reservationManager;
		this.servicesManager = servicesManager;
		this.employeeManager = employeeManager;
		this.billManager = billManager;
		this.calculableManager = calculableManager;
	}
	
	void displayHotelMenu() {
		
		while(true) {
			String userInput = menuScreen();
			System.out.println();
			
			switch(userInput) {
			
		  		case "1":
		  			displayRoomTypesInfo();
		  			servicesManager.addReservation();
			  		break;
			  	
			  	case "2":
			  		reservationManager.roomDisplay();
			  		break;
			  		
			  	case "3":
			  		reservationManager.displayReservationByCity();
			  		break;
			  		
			  	case "4":
			  		servicesManager.addExtraServices();
			  		break;
			  		
			  	case "5":
			  		servicesManager.displayServices();
			  		break;
	
			  	case "6":
			  		servicesManager.displayTotalCostByCustomer();
			  		break;
			  	
			  	case "7":
			  		employeeManager.createEmployee();
			  		break;
			  	
			  	case "8":
			  		billManager.createBill();
			  		break;
			  		
			  	case "9":
			  		calculableManager.displayMonthlyBalance();
			  		break;
			  		
			  	case "10":
			  		System.out.println("10. List all Services sorted based on cost");
			  		break;
			  				 
			  	case "11":
			  		System.out.println("11. List all Reservations sorted based on hotel names");
			  		break;
			  				 
			  	case "12":
			  		System.out.println("Exit...");
			  		System.exit(0);
			  		break;
			  				  	
			  	default:
			  		System.out.println("Please enter valid input!\n");
			  		break;  		
			}
		}
	}
	
	String menuScreen() {
		System.out.println();
		for(MenuOption menuOption : MenuOption.values()) {
			System.out.printf(menuOption.getOption());
		}
		String userInput = scanner.next();
		return userInput;
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
