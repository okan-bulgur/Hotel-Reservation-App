public class Spa extends Services{
	final double price = 100;
	protected int days;
	protected double spaCost;

	public Spa(int customerID,int days) {
		setCustomerID(customerID);
		setDays(days);
	}

	public int getDays() {
		return days;
	}

	public void setDays(int days) {
		this.days = days;
	}

	public double getSpaCost() {
		return spaCost;
	}

	public void setSpaCost(double spaCost) {
		this.spaCost = spaCost;
	}


	@Override
	protected String getServiceType() {
		return "Spa";
	}

	@Override
	public double getCost()  {
		return price * getDays();
	}
	
}
