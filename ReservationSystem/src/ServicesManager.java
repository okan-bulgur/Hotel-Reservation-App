import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ServicesManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	private Map<Integer, ArrayList<Services>> services;
	private Map<Integer, Double> totalCostByID;
	private ArrayList<Calculable> calculables;
	private ReservationManager reservationManager;
	private LaundryManager laundryManager;
	private SpaManager spaManager;

	
	public ServicesManager(Map <Integer, ArrayList<Services>> services, Map<Integer, Double> totalCostByID, ArrayList <Calculable> calculables, ReservationManager reservationManager) {
		this.services = services;
		this.totalCostByID = totalCostByID;
		this.calculables = calculables;
		this.reservationManager = reservationManager;
		laundryManager = new LaundryManager();
		spaManager = new SpaManager();
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

	void addExtraServices() {
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
				Laundry laundry = laundryManager.createLaundry();
				service = (Services) laundry;
				break;
				
			case 2:
				Spa spa = spaManager.createSpa();
				service = (Services) spa;
				break;
				
			default:
				System.out.println("Enter a valid input.");
				break;
		}
  		
  		if(service != null) {	  	
  			ArrayList<Services> servicesByID = services.get(service.getCustomerID());
  			servicesByID.add(service);
  			services.put(service.getCustomerID(), servicesByID);
  			totalCostByID.put(service.CustomerID, totalCostByID.get(service.CustomerID) + service.getCost());
  			calculables.add(service);
  		}
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
}
