public class Reservation extends Services implements Comparable<Reservation> {
	
	private String _cityName;
	private String _hotelName;
	private String _reservationMonth;
	private int _reservationStart;
	private int _reservationEnd;
	private Room _room;
	private int _dailyCost;
	private double _totalCost;
	
	public static int totalNumOfReservation = 0;
	
	
	public Reservation(String cityName, String hotelName, String reservationMonth, int reservationStart, int reservationEnd) {
		setCityName(cityName);
		setHotelName(hotelName);
		setReservationMonth(reservationMonth);
		setReservationStart(reservationStart);
		setReservationEnd(reservationEnd);
		//setRoom(room);
		//setDailyCost();
		//calculateTotalPrice();
		setCustomerID(totalNumOfReservation + 1);
	}
	
	public void setCityName(String cityName) {
		this._cityName = cityName;
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
		this._dailyCost = getRoom().getDailyCost();
	}
	
	public void setTotalCost(int totalCost) {
		this._totalCost = totalCost;
	}
	
	public String getCityName() {
		return _cityName;
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
	
	public static int getTotalNumOfReservation() {
		return totalNumOfReservation;
	}
	
	public double getTotalCost() {
		return this._totalCost;
	}
	
	private void calculateTotalPrice() {
		String month = getReservationMonth();
		int totalDay = getReservationEnd() - getReservationStart();
		int totalCost = getDailyCost() * totalDay;
		
		switch (month) {
			case "June":
			case "July":
			case "August":
				setTotalCost(totalCost*2);
				break;
			default:
				setTotalCost(totalCost);
				break;
		}
	}
	
	public void displayInfo(MenuScreen menuScreen) {
		menuScreen.addText("Reservation ID #" + getCustomerID() + " at " + getHotelName() + " starts on " + getReservationMonth() + " " + getReservationStart() + " and ends on " + getReservationMonth() + " " + getReservationEnd() + "\n");
	}
	
	public void displayTotalNumberOfReservation() {
		System.out.println(totalNumOfReservation + "reservation created so far.\n");
	}
	
	@Override
	protected String getServiceType() {
		return "Room Booking";
	}

	@Override
	public double getCost() {
		return getTotalCost();
	}

	@Override
	public int compareTo(Reservation r) {
		return this.getHotelName().compareTo(r.getHotelName());
	}

	//@Override
	static void displayServiceInfo(Services service) {
		System.out.printf("Hotel Name: " + ((Reservation) service).getHotelName() + ", ");
		System.out.println("Customer ID: " + service.getCustomerID() + ", Service Type: " + service.getServiceType() + ", Cost: " + service.getCost());
	}
	
}
