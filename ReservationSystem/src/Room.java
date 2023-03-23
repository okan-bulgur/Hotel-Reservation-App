public class Room{
	
	protected String _roomType;
	protected int _dailyCost;
	protected int _roomSize;
	protected boolean _hasBath;

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