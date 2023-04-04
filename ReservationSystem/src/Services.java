public abstract class Services {
	protected int CustomerID;
	
	public Services() {
		
	}
	
	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	protected abstract String getServiceType();
	
	protected abstract Double calculateService();

	@Override
	public String toString() {
		return String.format("The cost for the %s service of reservation ID %d: %.2f", getServiceType(), getCustomerID(), calculateService());
	}
	
	
}
