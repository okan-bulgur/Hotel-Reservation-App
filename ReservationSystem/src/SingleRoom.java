public class SingleRoom extends Room{
	
	public static String roomType = "Single";
	public static int dailyCost = 100;
	public static int roomSize = 15;
	public static boolean hasBath = false;

	public SingleRoom() {
		super();
		setRoomType(roomType);
		setDailyCost(dailyCost);
		setRoomSize(roomSize);
		setHasBath(hasBath);
	}
}
