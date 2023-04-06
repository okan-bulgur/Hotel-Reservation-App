public class FamilyRoom extends Room {
	
	public static final String roomType = "Family";
	public static final int dailyCost = 400;
	public static final int roomSize = 50;
	public static final boolean hasBath = false;
	
	public FamilyRoom() {
		super(roomType, dailyCost, roomSize, hasBath);
	}
}
