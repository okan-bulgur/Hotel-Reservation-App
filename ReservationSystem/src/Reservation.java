public class Reservation {
	
	private String _hotelName;
	private String _reservationMonth;
	private int _reservationStart;
	private int _reservationEnd;
	private Room _room;
	private int _dailyCost;
	
	
	public Reservation(String hotelName, String reservationMonth, int reservationStart, int reservationEnd, Room room) {
		setHotelName(hotelName);
		setReservationMonth(reservationMonth);
		setReservationStart(reservationStart);
		setReservationEnd(reservationEnd);
		setRoom(room);
		setDailyCost();
	}
	
	public void setHotelName(String hotelName) {
		this._hotelName = hotelName;
	}
	
	public void setReservationMonth(String reservationMonth) {
		this._reservationMonth = reservationMonth;
	}
	
	public void setReservationStart(int reservationStart) {
		this._reservationStart = reservationStart;
	}

	public void setReservationEnd(int reservationEnd) {
		this._reservationEnd = reservationEnd;
	}
	
	public void setRoom(Room room) {
		this._room = room;
	}
	
	public void setDailyCost() {
		this._dailyCost = getRoom().get_dailyCost();
	}
	
	public String getHotelName() {
		return this._hotelName;
	}
	
	public String getReservationMonth() {
		return this._reservationMonth;
	}
	
	public int getReservationStart() {
		return this._reservationStart;
	}

	public int getReservationEnd() {
		return this._reservationEnd;
	}

	public Room getRoom() {
		return this._room;
	}
	
	public int getDailyCost() {
		return this._dailyCost;
	}
	
	private int calculateTotalPrice() {
		String month = getReservationMonth();
		int totalDay = getReservationEnd() - getReservationStart();
		int totalCost = getDailyCost() * totalDay;
		
		switch (month) {
			case "June":
			case "July":
			case "August":
				return 2*totalCost;
		default:
				return totalCost;
		}
	}
	
	public void displayInfo() {
		System.out.println("Reservation for a " + getRoom().get_roomType() + " room in "+ getHotelName() + " starts on " + getReservationMonth() + " " + getReservationStart() + " and ends on " + getReservationMonth() + " " + getReservationEnd() + ". Reservation has a total cost of " + calculateTotalPrice() +  "$.");
	}
}
