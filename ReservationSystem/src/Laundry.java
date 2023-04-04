public class Laundry extends Services{
	final double price = 20;
	protected int clothingPieces;
	protected double laundryCost;

	public Laundry(int customerID, int clothingPieces) {
		setCustomerID(customerID);
		setClothingPleces(clothingPieces);
	}
	
	public int getClothingPieces() {
		return clothingPieces;
	}


	public void setClothingPleces(int clothingPieces) {
		this.clothingPieces = clothingPieces;
	}


	public double getLaundryCost() {
		return laundryCost;
	}


	public void setLaundryCost(double laundryCost) {
		this.laundryCost = laundryCost;
	}


	@Override
	protected String getServiceType() {
		return "Laundry";
	}

	@Override
	protected Double calculateService() {
		return price * getClothingPieces();
	}
	
}
