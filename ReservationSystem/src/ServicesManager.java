import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.JOptionPane;

public class ServicesManager {
	
	Scanner scanner = new Scanner(System.in);	
	
	private Hotel hotel;
	private LaundryManager laundryManager;
	private SpaManager spaManager;

	public ServicesManager(Hotel hotel) {
		this.hotel = hotel;
		laundryManager = new LaundryManager(hotel);
		spaManager = new SpaManager(hotel);
	}
	
	void addReservation() {
		Services reservation = hotel.reservationManager.createReservation();
		
		ArrayList<Services> servicesByID = new ArrayList<Services>();
		servicesByID.add(reservation);
		hotel.services.put(reservation.getCustomerID(), servicesByID);
		
		//hotel.totalCostByID.put(Reservation.totalNumOfReservation, reservation.getCost());

		//hotel.calculables.add(reservation);
	}

	void addExtraServices() {
		if(Reservation.totalNumOfReservation == 0) {
			JOptionPane.showMessageDialog(hotel.menuScreen.frame, "There is not any reservation. Service cannot be used.", "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		int servicesNo = Integer.parseInt(JOptionPane.showInputDialog("Please select one of the extra services from below:\n1. Laundry Service \n2. Spa Service\n"));
  		
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
				JOptionPane.showMessageDialog(hotel.menuScreen.frame, "Invalid input.", "ERROR", JOptionPane.ERROR_MESSAGE);
				break;
		}
  		
  		if(service != null) {	  	
  			ArrayList<Services> servicesByID = hotel.services.get(service.getCustomerID());
  			servicesByID.add(service);
  			hotel.services.put(service.getCustomerID(), servicesByID);
  			//hotel.totalCostByID.put(service.CustomerID, hotel.totalCostByID.get(service.CustomerID) + service.getCost());
  			//hotel.calculables.add(service);
  		}
	}
	
	void displayServices() {
		if(hotel.services.size() == 0) {
			JOptionPane.showMessageDialog(hotel.menuScreen.frame, "There is not any service.", "ERROR", JOptionPane.ERROR_MESSAGE);
  			return;
  		}
		Set<Integer> ID = hotel.services.keySet();
		for(Integer id : ID) {
			ArrayList<Services> servicesByID = hotel.services.get(id);
			
			Iterator<Services> itr = servicesByID.listIterator();
			while(itr.hasNext()) {
				Services ser = itr.next();
				if(ser instanceof Reservation) {
					continue;
				}
				hotel.menuScreen.addText("Reservation ID #" + ser.getCustomerID() + " " + ser + "\n");
			}
		}
	}

	void displayTotalCostByCustomer() {
		if(hotel.services.size() == 0) {
			JOptionPane.showMessageDialog(hotel.menuScreen.frame, "There is not any service.", "ERROR", JOptionPane.ERROR_MESSAGE);
  			return;
  		}
		
		for(Integer ID : hotel.totalCostByID.keySet()) {
			double totalCost = hotel.totalCostByID.get(ID);
			hotel.menuScreen.addText("\nThe total cost of all services of the reservation with ID: "+ ID + " is " + totalCost);
		}
	}
	
	int displayServicesSize() {
		return hotel.services.size();
	}
	
	void sortServices() {
		
		ArrayList<Services> allServices = new ArrayList<Services>();
		
		for(ArrayList<Services> services : hotel.services.values()) {
			allServices.addAll(services);
		}
		
		Collections.sort(allServices, new CostComparator());
		
		for(Services service : allServices) {
			Services.displayServiceInfo((Services)service);
		}
	}
}
