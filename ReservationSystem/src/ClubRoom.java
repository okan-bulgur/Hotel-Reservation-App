public class ClubRoom extends Room{
	
	public static final String roomType = "Club";
	public static final int dailyCost = 250;
	public static final int roomSize = 45;
	public static final boolean hasBath = true;
	
	public ClubRoom() {
		super(roomType, dailyCost, roomSize, hasBath);
	}
}
