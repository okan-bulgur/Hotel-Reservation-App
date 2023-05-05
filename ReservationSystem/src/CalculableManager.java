import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;

public class CalculableManager {

	Scanner scanner = new Scanner(System.in);	
	
	private Hotel hotel;
	
	private final String months[] = {"JANUARY", "FEBRUARY", "MARCH", "APRIL", "MAY", "JUNE", "JULY", "AUGUST", "SEPTEMBER", "OCTOBER", "NOVEMBER", "DECEMBER"};

	public CalculableManager(Hotel hotel) {
		this.hotel = hotel;
	}
	
	void displayMonthlyBalance() {
		String month = null;
		
		while(true) {			
			try {							
				month = inputMonth();
				break;
			} catch (InvalidMonthException e) {
				System.err.println(e.getMessage());
			}
		}

		System.out.println();
  		double inCome = inComeStatements(month);
  		double billsCost = 0;
  		double employeeCost = Employees.totalMonthlyPayments;
  		
  		for(Calculable calculable : hotel.calculables) {
  			if(calculable instanceof Bills && ((Bills) calculable).getMonth().equals(month)) {
  				billsCost += calculable.getCost();
  			}
  		}
  		double balance = inCome-billsCost-employeeCost;
  		System.out.println("Total monthly income: " + inCome);
  		System.out.println("Total monthly bills due: " + billsCost);
  		System.out.println("Total monthly employee cost: " + employeeCost);
  		System.out.println("End of month balance: " + balance);
  		System.out.println();
	}
	
	double inComeStatements(String month) {
		double inCome = 0;
		
		Set<Integer> ID = hotel.services.keySet();
		if(hotel.services.size() == 0) {
			return inCome;
		}
		for(Integer id : ID) {
			ArrayList<Services> servicesByID = hotel.services.get(id);
			
			Reservation reservation = (Reservation)servicesByID.get(0);
			
			if(reservation.getReservationMonth().equals(month)) {
				for(Services service : servicesByID) {
					System.out.println("For reservation ID: "+ id +", Service type: " + service.getServiceType() + ", Service Cost: " + service.getCost());
					inCome += service.getCost();
				}
			}
		}
		return inCome;
	}	
	
	String inputMonth() throws InvalidMonthException {
		System.out.println("Enter Month: ");
  		String month = scanner.nextLine().toLowerCase();
  		
  		if(!Arrays.asList(months).contains(month.toUpperCase())) {
  			throw new InvalidMonthException("\nInvalid input.\n");
  		}
  		return month;
	}
}
