public class Room{
	
	private String _roomType;
	private int _dailyCost;
	private int _roomSize;
	private boolean _hasBath;
	
	public Room(String roomType, int dailyCost, int roomSize, boolean hasBath) {
		set_roomType(roomType);
		set_dailyCost(dailyCost);
		set_roomSize(roomSize);
		set_hasBath(hasBath);
	}

	public String get_roomType() {
		return _roomType;
	}

	public void set_roomType(String _roomType) {
		this._roomType = _roomType;
	}

	public int get_dailyCost() {
		return _dailyCost;
	}

	public void set_dailyCost(int _dailyCost) {
		this._dailyCost = _dailyCost;
	}

	public int get_roomSize() {
		return _roomSize;
	}

	public void set_roomSize(int _roomSize) {
		this._roomSize = _roomSize;
	}

	public boolean is_hasBath() {
		return _hasBath;
	}

	public void set_hasBath(boolean _hasBath) {
		this._hasBath = _hasBath;
	}
	
	
}