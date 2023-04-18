import java.util.ArrayList;

public class HotelMenu {
	
	private static ArrayList<Calculable> calculables = new ArrayList<Calculable>();
	
	public static void main(String[] args) {
		ServiceFunctions serviceFunctions = new ServiceFunctions(calculables);
		ServiceFunctions.Create serviceCreate = serviceFunctions.new Create();
		ServiceFunctions.Display serviceDisplay = serviceFunctions.new Display();
		ServiceFunctions.Inputs serviceInputs = serviceFunctions.new Inputs();
		
		EmployeeFunctions employeeFunctions = new EmployeeFunctions(calculables);
		EmployeeFunctions.Create employeeCreate = employeeFunctions.new Create();
		
		BillFunctions billFunctions = new BillFunctions(calculables);
		BillFunctions.Create billCreate = billFunctions.new Create();
		
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
			  		serviceDisplay.displayTotalCostByCustomer();
			  		break;
			  	
			  	case "7":
			  		employeeCreate.createEmployee();
			  		break;
			  	
			  	case "8":
			  		billCreate.createBill();
			  		break;
			  		
			  	case "9":
			  		String month = serviceInputs.inputMonth();
			  		double inCome = serviceCreate.inComeStatements(month);
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


 