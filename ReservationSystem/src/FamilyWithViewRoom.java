public class FamilyWithViewRoom extends Room{
	
	public static final String roomType = "Family with View";
	public static final int dailyCost = 450;
	public static final int roomSize = 50;
	public static final boolean hasBath = true;
	
	public FamilyWithViewRoom() {
		super(roomType, dailyCost, roomSize, hasBath);
	}
}
