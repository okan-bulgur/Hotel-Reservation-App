public class SuiteRoom extends Room{
	
	public static final String roomType = "Suite";
	public static final int dailyCost = 650;
	public static final int roomSize = 80;
	public static final boolean hasBath = true;
	
	public SuiteRoom() {
		super(roomType, dailyCost, roomSize, hasBath);
	}
}
