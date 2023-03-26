public class FamilyWithViewRoom extends Room{
	
	public static String roomType = "Family with View";
	public static int dailyCost = 450;
	public static int roomSize = 50;
	public static boolean hasBath = true;
	
	public FamilyWithViewRoom() {
		super();
		setRoomType(roomType);
		setDailyCost(dailyCost);
		setRoomSize(roomSize);
		setHasBath(hasBath);
	}
}
