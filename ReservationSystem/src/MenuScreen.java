import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class MenuScreen extends ScreenManager {

	public JFrame frame;
	private JTextArea textArea;
	
	private int width = 800;
	private int height = 600;

	public MenuScreen(Hotel hotel) {
		super(hotel);
	}

	public void createFrame() {
		frame = new JFrame();
		frame.setTitle("Hotel Reservation System");
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		
		JPanel btnPanel = createBtnPanel();
		frame.add(btnPanel, BorderLayout.NORTH);
		
		createTextArea();
		frame.add(textArea, BorderLayout.CENTER);
		
		createMenuBar();
	
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);	
	}
	
	public void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenu newMenu = new JMenu("New");
		JMenu helpMenu = new JMenu("Help");
		
		JMenuItem reservation = new JMenuItem("Reservation");
		JMenuItem services = new JMenuItem("Services");
		
		JMenuItem about = new JMenuItem("About");
		
		reservation.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				displayRoomTypesInfo();
				hotel.servicesManager.addReservation();
			}
		});
		
		services.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				hotel.servicesManager.addExtraServices();
			}
		});
		
		newMenu.add(reservation);
		newMenu.add(services);
		
		helpMenu.add(about);
		
		menuBar.add(fileMenu);
		menuBar.add(newMenu);
		menuBar.add(helpMenu);
		
		frame.setJMenuBar(menuBar);
	}

	private JPanel createBtnPanel() {
		JPanel btnPanel = new JPanel();
		
		JButton btn1 = new JButton("Display Reservation");
		JButton btn2 = new JButton("Display Extra Reservation");
		JButton btn3 = new JButton("Disp. Res. For City");
		
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hotel.reservationManager.roomDisplay();
			}
		});
		
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hotel.servicesManager.displayServices();
			}
		});

		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				hotel.reservationManager.displayReservationByCity();
			}
		});
		
		btn1.setPreferredSize(new Dimension(200,30));
		btn2.setPreferredSize(new Dimension(200,30));
		btn3.setPreferredSize(new Dimension(200,30));
		
		btn1.setBackground(Color.white);
		btn2.setBackground(Color.white);
		btn3.setBackground(Color.white);
		
		btnPanel.add(btn1);
		btnPanel.add(btn2);
		btnPanel.add(btn3);
		
		return btnPanel;
	}
	
	private void createTextArea() {
		textArea = new JTextArea();
		textArea.setEnabled(false);
		
	}
	
	public void addText(String message) {
		 textArea.append(message);
	}

	public void displayRoomTypesInfo() {
		addText(
				"\nROOM INFOS:\n\n"
				+ "Room Type: "+ SingleRoom.roomType +", Daily Cost: "+ SingleRoom.dailyCost +", Room Size: "+ SingleRoom.roomSize +", Has Bath: "+ SingleRoom.hasBath +"\n"
				+ "Room Type: "+ DoubleRoom.roomType +", Daily Cost: "+ DoubleRoom.dailyCost +", Room Size: "+ DoubleRoom.roomSize +", Has Bath: "+ DoubleRoom.hasBath +"\n"
				+ "Room Type: "+ ClubRoom.roomType +", Daily Cost: "+ ClubRoom.dailyCost +", Room Size: "+ ClubRoom.roomSize +", Has Bath: "+ ClubRoom.hasBath +"\n"
				+ "Room Type: "+ FamilyRoom.roomType +", Daily Cost: "+ FamilyRoom.dailyCost +", Room Size: "+ FamilyRoom.roomSize +", Has Bath: "+ FamilyRoom.hasBath +"\n"
				+ "Room Type: "+ FamilyWithViewRoom.roomType +", Daily Cost: "+ FamilyWithViewRoom.dailyCost +", Room Size: "+ FamilyWithViewRoom.roomSize +", Has Bath: "+ FamilyWithViewRoom.hasBath +"\n"
				+ "Room Type: "+ SuiteRoom.roomType +", Daily Cost: "+ SuiteRoom.dailyCost +", Room Size: "+ SuiteRoom.roomSize +", Has Bath: "+ SuiteRoom.hasBath +"\n\n"
				);
	}
}

