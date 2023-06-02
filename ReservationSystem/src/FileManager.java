import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {
	
	private Hotel hotel;
	private static final String FILE_PATH = "src/reservations.csv";
	private boolean check = false;
	
	public FileManager(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public void saveReservations() {
		try {
			if (check) {
				FileWriter writer1 = new FileWriter(FILE_PATH);
				BufferedWriter bufferedWriter1 = new BufferedWriter(writer1);
				bufferedWriter1.write("");				
			}
			
			FileWriter writer = new FileWriter(FILE_PATH, true);
			BufferedWriter bufferedWriter = new BufferedWriter(writer);
			
			for(Reservation reservation : hotel.reservations) {
				bufferedWriter.write(reservation.getCityName() + "," + reservation.getHotelName() + "," + reservation.getReservationMonth() + "," + reservation.getReservationStart() + "," + reservation.getReservationEnd());
				bufferedWriter.newLine();
			}
			
			bufferedWriter.close();
					
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadReservations() {
		try {
			check = true;
			FileReader reader = new FileReader(FILE_PATH);
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] words = line.split(",");
				String cityName = words[0];
				String hotelName = words[1];
				String month = words[2];
				int start = Integer.parseInt(words[3]);
				int end = Integer.parseInt(words[4]);
				
				Reservation loadReservation = new Reservation(cityName, hotelName, month, start, end);
				hotel.reservations.add(loadReservation);
				Reservation.totalNumOfReservation = hotel.reservations.size();
				ArrayList<Services> servicesByID = new ArrayList<Services>();
				servicesByID.add(loadReservation);
				hotel.services.put(Reservation.totalNumOfReservation, servicesByID);
				loadReservation.displayInfo(hotel.menuScreen);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
