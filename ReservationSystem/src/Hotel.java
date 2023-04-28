import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
	
	Scanner scanner = new Scanner(System.in);	
	
	private static Map<Integer, ArrayList<Services>> services = new HashMap<Integer, ArrayList<Services>>();
	private static ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	private static Map<Integer, Double> totalCostByID = new HashMap<Integer, Double>();
	private static ArrayList<Calculable> calculables = new ArrayList<Calculable>();
	
	public static void main(String[] args) {
		
		Hotel hotel = new Hotel();
		
		ReservationManager reservationManager = new ReservationManager(reservations);
		ServicesManager servicesManager = new ServicesManager(services, totalCostByID, calculables, reservationManager);
		
		EmployeeFunctions employeeFunctions = new EmployeeFunctions(calculables);
		EmployeeFunctions.Create employeeCreate = employeeFunctions.new Create();
		
		BillFunctions billFunctions = new BillFunctions(calculables);
		BillFunctions.Create billCreate = billFunctions.new Create();
		
		while(true) {
			String userInput = hotel.menuScreen();
			System.out.println();
			
			switch(userInput) {
			
		  		case "1":
		  			hotel.displayRoomTypesInfo();
		  			servicesManager.addReservation();
			  		break;
			  	
			  	case "2":
			  		reservationManager.roomDisplay();
			  		break;
			  		
			  	case "3":
			  		reservationManager.displayReservationByCity();
			  		break;
			  		
			  	case "4":
			  		servicesManager.createService();
			  		break;
			  		
			  	case "5":
			  		servicesManager.displayServices();
			  		break;

			  	case "6":
			  		servicesManager.displayTotalCostByCustomer();
			  		break;
			  	
			  	case "7":
			  		employeeCreate.createEmployee();
			  		break;
			  	
			  	case "8":
			  		billCreate.createBill();
			  		break;
			  		
			  	case "9":
			  		String month = servicesManager.inputMonth();
			  		double inCome = servicesManager.inComeStatements(month);
			  		double billsCost = 0;
			  		double employeeCost = Employees.totalMonthlyPayments;
			  		for(Calculable calculable : calculables) {
			  			if(calculable instanceof Bills && ((Bills) calculable).getMonth().equals(month)) {
			  				billsCost += calculable.getCost();
			  			}
			  		}
			  		double balance = inCome-billsCost-employeeCost;
			  		System.out.println("Total monthly income: " + inCome);
			  		System.out.println("Total monthly bills due: " + billsCost);
			  		System.out.println("Total monthly employee cost: " + employeeCost);
			  		System.out.println("TEnd of month balance: " + balance);
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


 