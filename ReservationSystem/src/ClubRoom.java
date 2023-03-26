public class ClubRoom extends Room{
	
	public static String roomType = "Club";
	public static int dailyCost = 250;
	public static int roomSize = 45;
	public static boolean hasBath = true;
	
	public ClubRoom() {
		super();
		setRoomType(roomType);
		setDailyCost(dailyCost);
		setRoomSize(roomSize);
		setHasBath(hasBath);
	}
}
