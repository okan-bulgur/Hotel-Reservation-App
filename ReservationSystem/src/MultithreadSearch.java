import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class MultithreadSearch {
	private static final int POOL_SIZE = 4;
	private Hotel hotel;
	
	public MultithreadSearch(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public void search() {
		String hotelName = inputHotelName();
		if (hotelName == null) {
			return;
		}
		ExecutorService executor = Executors.newFixedThreadPool(POOL_SIZE);
		ConcurrentLinkedQueue<Integer> results = new ConcurrentLinkedQueue<>();
		
		for(Reservation reservation : hotel.reservations) {
			executor.submit(()->{
				if(reservation.getHotelName().equals(hotelName)) {
					results.add(reservation.getCustomerID());
				}
			});
		}
		
		executor.shutdown();
		try {
			executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
		} catch (InterruptedException e) {
			 e.printStackTrace();
		}
		
		if(results.size() == 0) {
			JOptionPane.showMessageDialog(hotel.menuScreen.frame, "There are not any reservation in " + hotelName, "ERROR", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		List<Integer> sortedResult = new ArrayList<>(results);
		Collections.sort(sortedResult);
		
		hotel.menuScreen.addText("Reservations ID's for " + hotelName + "\n");
		for(int r : sortedResult) {
			hotel.menuScreen.addText(r + " ");
		}
		
		
	}
	
	public String inputHotelName() {
		if(Reservation.totalNumOfReservation < 8) {
			JOptionPane.showMessageDialog(hotel.menuScreen.frame, "Please enter at least 8 reservation - now it is only " + Reservation.totalNumOfReservation, "ERROR", JOptionPane.ERROR_MESSAGE);
			return null;
		}
  		String hotelName = JOptionPane.showInputDialog("Enter hotel name: ");
  		return hotelName;
	}
}
