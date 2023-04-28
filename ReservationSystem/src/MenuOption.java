public enum MenuOption {
	OPTION1("1. Create new Reservation with Room Type\n"),
	OPTION2("2. Display all Reservations\n"),
	OPTION3("3. List the reservations for a specific city\n"),
	OPTION4("4. Add extra services to a reservation\n"),
	OPTION5("5. Calculate total cost for each service\n"),
	OPTION6("6. Display the total cost of every customer\n"),
	OPTION7("7. Add an employee\n"),
	OPTION8("8. Add a bill\n"),
	OPTION9("9. Get monthly balance\n"),
	OPTION10("10. List all Services sorted based on cost\n"),
	OPTION11("11. List all Reservations sorted based on hotel names\n"),
	OPTION12("12. Exit");
	
	private String _option;
	
	MenuOption(String option){
		setOption(option);
	}
	
	public void setOption(String option){
		this._option = option;
	}
	
	public String getOption() {
		return this._option;
	}
}
