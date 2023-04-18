public class Bills implements Calculable{
	
	String type;
	double amount;
	String month;
	

	public Bills(String type, double amount, String month) {
		setType(type);
		setAmount(amount);
		setMonth(month);
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}

	
	public double getCost() {
		return getAmount();
	}
	
	@Override
	public String toString() {
		return "Bills [type=" + getType() + ", amount=" + getAmount() + ", month=" + getAmount() + "]";
	}
}
