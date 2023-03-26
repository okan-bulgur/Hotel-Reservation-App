public class SuiteRoom extends Room{
	
	public static String roomType = "Suite";
	public static int dailyCost = 650;
	public static int roomSize = 80;
	public static boolean hasBath = true;
	
	public SuiteRoom() {
		super();
		setRoomType(roomType);
		setDailyCost(dailyCost);
		setRoomSize(roomSize);
		setHasBath(hasBath);
	}
}
