public class SingleRoom extends Room{
	
	public static final String roomType = "Single";
	public static final int dailyCost = 100;
	public static final int roomSize = 15;
	public static final boolean hasBath = false;

	public SingleRoom() {
		super(roomType, dailyCost, roomSize, hasBath);
	}
}
