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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
		
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem reservation = new JMenuItem("Reservation");
		JMenuItem services = new JMenuItem("Services");
		JMenuItem contents = new JMenuItem("Contents");
		JMenuItem about = new JMenuItem("About");
		
		exit.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		
		reservation.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				hotel.servicesManager.addReservation();
			}
		});
		
		services.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				hotel.servicesManager.addExtraServices();
			}
		});

		contents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String message = ""
						+ "1) You can create reservation in new menu.\n"
						+ "2) You can create services in new menu.\n"
						+ "3) You can display all reservation with Display Reservation button.\n"
						+ "4) You can display all services with Display Extra Services button.\n"
						+ "5) You can display reservation by specific city with Display Reservation For City button.";
 				JOptionPane.showMessageDialog(frame, message);
			}
		});

		about.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(frame, "Okan Bulgur 20200702017");
			}
		});
		
		fileMenu.add(exit);
		newMenu.add(reservation);
		newMenu.add(services);
		helpMenu.add(contents);
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
}

