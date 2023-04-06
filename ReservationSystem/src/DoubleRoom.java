public class DoubleRoom extends Room {
	
	public static final String roomType = "Double";
	public static final int dailyCost = 180;
	public static final int roomSize = 30;
	public static final boolean hasBath = false;
	
	public DoubleRoom() {
		super(roomType, dailyCost, roomSize, hasBath);
	}
}
