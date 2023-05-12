public class ScreenManager {
	
	private MenuScreen screen;
	
	protected Hotel hotel;
	
	public ScreenManager(Hotel hotel) {
		this.hotel = hotel;
	}
	
	public void setScreen(MenuScreen screen) {
		this.screen = screen;
	}
	
	public void showScreen() {
		screen.createFrame();
	}
}
