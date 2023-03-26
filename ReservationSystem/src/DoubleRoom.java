public class DoubleRoom extends Room {
	
	public static String roomType = "Double";
	public static int dailyCost = 180;
	public static int roomSize = 30;
	public static boolean hasBath = false;
	
	public DoubleRoom() {
		super();
		setRoomType(roomType);
		setDailyCost(dailyCost);
		setRoomSize(roomSize);
		setHasBath(hasBath);
	}
}
