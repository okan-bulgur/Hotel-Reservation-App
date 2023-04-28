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
	
	private static ReservationManager reservationManager = new ReservationManager(reservations);
	private static ServicesManager servicesManager = new ServicesManager(services, totalCostByID, calculables, reservationManager);
	
	
	private static EmployeeManager employeeManager = new EmployeeManager(calculables);
	private static BillManager billManager = new BillManager(calculables);
	
	private static CalculableManager calculableManager = new CalculableManager(calculables, services);
	
	public static void main(String[] args) {
		
		HotelMenu hotelMenu = new HotelMenu(reservationManager, servicesManager, employeeManager, billManager, calculableManager);
		hotelMenu.displayHotelMenu();
    }
}


 