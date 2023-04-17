import java.util.Scanner;

public class HotelMenu {
	
	public static void main(String[] args) {
		Scanner ms = new Scanner(System.in);			
		
		ServiceFunctions serviceFunctions = new ServiceFunctions();
		ServiceFunctions.Create serviceCreate = serviceFunctions.new Create(ms);
		ServiceFunctions.Display serviceDisplay = serviceFunctions.new Display();
		ServiceFunctions.Inputs serviceInputs = serviceFunctions.new Inputs(ms);
	  
		while(true) {
			String userInput = serviceInputs.menuScreen();
			System.out.println();
			
			switch(userInput) {
			
		  		case "1":
		  				serviceDisplay.displayRoomTypesInfo();
		  				serviceCreate.createReservation();
			  		break;
			  	
			  	case "2":
			  		serviceDisplay.roomDisplay();
			  		break;
			  		
			  	case "3":
			  		String cityName = serviceInputs.inputCityName();
			  		serviceDisplay.displayReservationByCity(cityName);
			  		break;
			  		
			  	case "4":
			  		serviceCreate.createService();
			  		break;
			  		
			  	case "5":
			  		serviceDisplay.displayServices();
			  		break;

			  	case "6":
			  		serviceDisplay.displayServicesByCustomer();
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


 