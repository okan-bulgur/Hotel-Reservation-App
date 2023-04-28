import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ServicesManager {
	
	Scanner scanner = new Scanner(System.in);	
	private final String months[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	
	private Map<Integer, ArrayList<Services>> services;
	private Map<Integer, Double> totalCostByID;
	private ArrayList<Calculable> calculables;
	private ReservationManager reservationManager;
	
	public ServicesManager(Map <Integer, ArrayList<Services>> services,Map<Integer, Double> totalCostByID , ArrayList <Calculable> calculables, ReservationManager reservationManager) {
		this.services = services;
		this.totalCostByID = totalCostByID;
		this.calculables = calculables;
		this.reservationManager = reservationManager;
	}
	
	void addReservation() {
		Services reservation = reservationManager.createReservation();
		
		ArrayList<Services> servicesByID = new ArrayList<Services>();
		servicesByID.add(reservation);
		services.put(reservation.getCustomerID(), servicesByID);
		
		totalCostByID.put(Reservation.totalNumOfReservation, reservation.getCost());

		calculables.add(reservation);
		
  		System.out.println("Reservation ID: " + Reservation.totalNumOfReservation + " is created\n");
	}

	void createService() {
		if(Reservation.totalNumOfReservation == 0) {
			System.out.println("There is not any reservation. Service cannot be used.");
			return;
		}
		
		System.out.println("Please select one of the extra services from below:");
		System.out.println("1. Laundry Service \n2. Spa Service");
  		int servicesNo = scanner.nextInt();
  		
  		Services service = null;
  		
  		switch (servicesNo) {
  		
			case 1:
				service = createLaundry();
				break;
				
			case 2:
				service = createSpa();
				break;
				
			default:
				System.out.println("Enter a valid input.");
				break;
		}
  		if(service != null) {	  	
  			ArrayList<Services> servicesByID = services.get(service.getCustomerID());
  			servicesByID.add(service);
  			services.put(service.getCustomerID(), servicesByID);
  			calculables.add(service);
  		}
	}

	Services createLaundry() {
		System.out.println("Type the reservation ID to credit this service:");
  		int CustomerID = scanner.nextInt();
  		
  		if(Reservation.totalNumOfReservation < CustomerID) {
  			System.out.println("Invalid customer ID.");
  			return null;
		}
  		
		System.out.println("How many pieces of clothing?");
		int piecesOfClothing = scanner.nextInt();
		
		Services laundry =  new Laundry(CustomerID, piecesOfClothing);
		totalCostByID.put(CustomerID, totalCostByID.get(CustomerID) + laundry.getCost());
		return laundry;
	}
	
	Services createSpa() {
		System.out.println("Type the reservation ID to credit this service:");
  		int CustomerID = scanner.nextInt();
  		
  		if(Reservation.totalNumOfReservation < CustomerID) {
  			System.out.println("Invalid customer ID.");
  			return null;
		}
  		
		System.out.println("How many days?");
		int days = scanner.nextInt();
		
		Spa spa = new Spa(CustomerID, days);
		totalCostByID.put(CustomerID, totalCostByID.get(CustomerID) + spa.getCost());
		return spa;
	}

	double inComeStatements(String month) {
		double inCome = 0;
		
		Set<Integer> ID = services.keySet();
		if(services.size() == 0) {
			return inCome;
		}
		for(Integer id : ID) {
			ArrayList<Services> servicesByID = services.get(id);
			
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

	void displayServices() {
		if(services.size() == 0) {
  			System.out.println("There is not service.");
  			return;
  		}
		Set<Integer> ID = services.keySet();
		for(Integer id : ID) {
			ArrayList<Services> servicesByID = services.get(id);
			
			Iterator<Services> itr = servicesByID.listIterator();
			while(itr.hasNext()) {
				Services ser = itr.next();
				System.out.println(ser);
			}
		}
	}

	void displayTotalCostByCustomer() {
		if(services.size() == 0) {
  			System.out.println("There is not any services.");
  			return;
  		}
		
		for(Integer ID : totalCostByID.keySet()) {
			double totalCost = totalCostByID.get(ID);
			System.out.println("The total cost of all services of the reservation with ID: "+ ID + " is " + totalCost);
		}
	}
	
	int displayServicesSize() {
		return services.size();
	}

	String inputMonth() {
		System.out.println("Enter Month: ");
		scanner.nextLine(); //to fix error
  		String month = scanner.nextLine();
  		
  		if(!Arrays.asList(months).contains(month)) {
  			System.out.println("Invalid input.\n");
  			month = inputMonth();
  		}
  		return month;
	}
}
