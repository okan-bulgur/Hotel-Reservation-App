import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hotel {
	
	Scanner scanner = new Scanner(System.in);	
	
	public Map<Integer, ArrayList<Services>> services = new HashMap<Integer, ArrayList<Services>>();
	public ArrayList<Reservation> reservations = new ArrayList<Reservation>();
	public Map<Integer, Double> totalCostByID = new HashMap<Integer, Double>();
	public ArrayList<Calculable> calculables = new ArrayList<Calculable>();
	
	
	public ScreenManager screenManager;
	public MenuScreen menuScreen;
	
	public CalculableManager calculableManager;
	public ServicesManager servicesManager;
	public ReservationManager reservationManager;
	public EmployeeManager employeeManager;
	public BillManager billManager;
	public MultithreadSearch multithreadSearch;
	
	public Hotel() {		
		screenManager = new ScreenManager(this);
		menuScreen = new MenuScreen(this);
		
		servicesManager = new ServicesManager(this);
		reservationManager = new ReservationManager(this);
		employeeManager = new EmployeeManager(this);
		billManager = new BillManager(this);
		calculableManager = new CalculableManager(this);
		multithreadSearch = new MultithreadSearch(this);
	}
	
	public static void main(String[] args) {
		
		Hotel hotel = new Hotel();
		
		hotel.screenManager.setScreen(hotel.menuScreen);
		hotel.screenManager.showScreen();

    }
}


 