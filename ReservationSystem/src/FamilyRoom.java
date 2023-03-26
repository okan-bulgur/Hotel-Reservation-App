public class FamilyRoom extends Room {
	
	public static String roomType = "Family";
	public static int dailyCost = 400;
	public static int roomSize = 50;
	public static boolean hasBath = false;
	
	public FamilyRoom() {
		super();
		setRoomType(roomType);
		setDailyCost(dailyCost);
		setRoomSize(roomSize);
		setHasBath(hasBath);
	}
}
