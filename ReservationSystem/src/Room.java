public class Room{
	
	protected String _roomType;
	protected int _dailyCost;
	protected int _roomSize;
	protected boolean _hasBath;

	public Room(){
		
	}

	public String getRoomType() {
		return _roomType;
	}

	public void setRoomType(String _roomType) {
		this._roomType = _roomType;
	}

	public int getDailyCost() {
		return _dailyCost;
	}

	public void setDailyCost(int _dailyCost) {
		this._dailyCost = _dailyCost;
	}

	public int getRoomSize() {
		return _roomSize;
	}

	public void setRoomSize(int _roomSize) {
		this._roomSize = _roomSize;
	}

	public boolean isHasBath() {
		return _hasBath;
	}

	public void setHasBath(boolean _hasBath) {
		this._hasBath = _hasBath;
	}
}