public enum MenuOption {
	OPTION1("1. Create new Reservation\n"),
	OPTION2("2. Create new Reservation with Room Type\\n"),
	OPTION3("3. Display all Reservations\\n"),
	OPTION4("4. Display the total number of reservations\\n"),
	OPTION5("5. Exit");
	
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
