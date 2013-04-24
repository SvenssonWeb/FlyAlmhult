import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import classes.*;

public class MainWindow {

	private JFrame frame;
	private JTextField textAirportName;
	private JTextField textAddCity;
	private JTextField textFieldDepartureTime;
	private JTextField textFieldArrivalTime;
	private JTextField textUsername;
	private JTextField textPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	/**
	 * Create the application.
	 */
	public MainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 567, 598);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelLogIn = new JPanel();
		panelLogIn.setBounds(65, 39, 302, 246);
		frame.getContentPane().add(panelLogIn);
		panelLogIn.setLayout(null);
		
		textUsername = new JTextField();
		textUsername.setBounds(26, 64, 215, 20);
		panelLogIn.add(textUsername);
		textUsername.setColumns(10);
		
		JLabel lblLoggaIn = new JLabel("Logga in");
		lblLoggaIn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblLoggaIn.setBounds(10, 11, 82, 20);
		panelLogIn.add(lblLoggaIn);
		
		JLabel lblAnvndarnamn = new JLabel("Anv\u00E4ndarnamn:");
		lblAnvndarnamn.setBounds(26, 49, 92, 14);
		panelLogIn.add(lblAnvndarnamn);
		
		JLabel lblLsenord = new JLabel("L\u00F6senord:");
		lblLsenord.setBounds(26, 95, 92, 14);
		panelLogIn.add(lblLsenord);
		
		textPassword = new JTextField();
		textPassword.setBounds(26, 109, 215, 20);
		panelLogIn.add(textPassword);
		textPassword.setColumns(10);
		
		JButton btnLoggaIn = new JButton("Logga in");
		btnLoggaIn.setBounds(152, 136, 89, 23);
		panelLogIn.add(btnLoggaIn);
				
		final JPanel panelAirports = new JPanel();
		panelAirports.setBounds(65, 40, 276, 502);
		frame.getContentPane().add(panelAirports);
		panelAirports.setLayout(null);
		panelAirports.setVisible(false);
		
		JLabel lblHanteraFlygplatser = new JLabel("Hantera flygplatser");
		lblHanteraFlygplatser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHanteraFlygplatser.setBounds(10, 11, 162, 28);
		panelAirports.add(lblHanteraFlygplatser);
		
		JLabel lblFlygplats = new JLabel("Flygplats:");
		lblFlygplats.setBounds(10, 50, 56, 14);
		panelAirports.add(lblFlygplats);
		
		JLabel lblStad = new JLabel("Stad:");
		lblStad.setBounds(10, 75, 46, 14);
		panelAirports.add(lblStad);
		
		textAirportName = new JTextField();
		textAirportName.setBounds(61, 47, 205, 20);
		panelAirports.add(textAirportName);
		textAirportName.setColumns(10);
		
		JComboBox comboBoxCity = new JComboBox();
		comboBoxCity.setBounds(61, 72, 205, 20);
		panelAirports.add(comboBoxCity);
		
		JButton btnAddAirport = new JButton("L\u00E4gg till/\u00C4ndra");
		btnAddAirport.setBounds(145, 100, 121, 23);
		panelAirports.add(btnAddAirport);
		
		JButton btnDeleteAirport = new JButton("Ta bort flygplats");
		btnDeleteAirport.setBounds(145, 134, 121, 23);
		panelAirports.add(btnDeleteAirport);
		
		JLabel lblTillgngligaFlygplatser = new JLabel("Tillg\u00E4ngliga flygplatser");
		lblTillgngligaFlygplatser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTillgngligaFlygplatser.setBounds(10, 168, 162, 14);
		panelAirports.add(lblTillgngligaFlygplatser);
		
		DefaultListModel listModelAirports = new DefaultListModel();
		JList listAirports = new JList(listModelAirports);
		listAirports.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listAirports.setBounds(10, 193, 256, 94);
		panelAirports.add(listAirports);
		
		JLabel lblLggTillStder = new JLabel("L\u00E4gg till st\u00E4der");
		lblLggTillStder.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLggTillStder.setBounds(10, 312, 127, 14);
		panelAirports.add(lblLggTillStder);
		
		textAddCity = new JTextField();
		textAddCity.setBounds(10, 331, 144, 20);
		panelAirports.add(textAddCity);
		textAddCity.setColumns(10);
		
		JButton btnAddCity = new JButton("L\u00E4gg till/\u00C4ndra");
		btnAddCity.setBounds(155, 330, 111, 23);
		panelAirports.add(btnAddCity);
		
		JButton btnTaBortStad = new JButton("Ta bort stad");
		btnTaBortStad.setBounds(166, 354, 100, 23);
		panelAirports.add(btnTaBortStad);
		
		DefaultListModel listModelCities = new DefaultListModel();
		JList listCities = new JList(listModelCities);
		listCities.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listCities.setBounds(10, 399, 256, 92);
		panelAirports.add(listCities);
		
		JLabel lblTillgngligaStder = new JLabel("Tillg\u00E4ngliga st\u00E4der");
		lblTillgngligaStder.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTillgngligaStder.setBounds(10, 374, 152, 14);
		panelAirports.add(lblTillgngligaStder);
		
		//----------
		final JPanel panelRoute = new JPanel();
		panelRoute.setBounds(65, 40, 302, 502);
		frame.getContentPane().add(panelRoute);
		panelRoute.setLayout(null);
		
		JLabel lblFlightRoute = new JLabel("Flight Route");
		lblFlightRoute.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFlightRoute.setBounds(10, 11, 113, 26);
		panelRoute.add(lblFlightRoute);
		
		JLabel lblFlighter = new JLabel("Flight");
		lblFlighter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFlighter.setBounds(10, 257, 97, 20);
		panelRoute.add(lblFlighter);
		
		JComboBox comboBoxRouteFrom = new JComboBox();
		comboBoxRouteFrom.setBounds(10, 59, 139, 20);
		panelRoute.add(comboBoxRouteFrom);
		
		JComboBox comboBoxRouteTo = new JComboBox();
		comboBoxRouteTo.setBounds(153, 59, 139, 20);
		panelRoute.add(comboBoxRouteTo);
		
		JLabel lblFrn = new JLabel("Fr\u00E5n:");
		lblFrn.setBounds(10, 41, 46, 17);
		panelRoute.add(lblFrn);
		
		JLabel lblTill = new JLabel("Till:");
		lblTill.setBounds(153, 42, 46, 14);
		panelRoute.add(lblTill);
		
		JButton btnSaveRoute = new JButton("Spara");
		btnSaveRoute.setBounds(216, 90, 76, 23);
		panelRoute.add(btnSaveRoute);
		
		JComboBox comboBoxRoute = new JComboBox();
		comboBoxRoute.setBounds(66, 288, 226, 20);
		panelRoute.add(comboBoxRoute);
		
		JLabel lblFlygrutt = new JLabel("Flygrutt:");
		lblFlygrutt.setBounds(10, 291, 46, 14);
		panelRoute.add(lblFlygrutt);
		
		JComboBox comboBoxPlane = new JComboBox();
		comboBoxPlane.setBounds(66, 313, 226, 20);
		panelRoute.add(comboBoxPlane);
		
		JLabel lblFlygplan = new JLabel("Flygplan:");
		lblFlygplan.setBounds(10, 316, 46, 14);
		panelRoute.add(lblFlygplan);
		
		JLabel lblAvgng = new JLabel("Avg\u00E5ng:");
		lblAvgng.setBounds(10, 341, 46, 14);
		panelRoute.add(lblAvgng);
		
		JLabel lblAnkomst = new JLabel("Ankomst:");
		lblAnkomst.setBounds(163, 341, 63, 14);
		panelRoute.add(lblAnkomst);
		
		JButton btnSparaFlight = new JButton("Spara");
		btnSparaFlight.setBounds(203, 364, 89, 23);
		panelRoute.add(btnSparaFlight);
		
		textFieldDepartureTime = new JTextField();
		textFieldDepartureTime.setBounds(66, 338, 57, 20);
		panelRoute.add(textFieldDepartureTime);
		textFieldDepartureTime.setColumns(10);
		
		textFieldArrivalTime = new JTextField();
		textFieldArrivalTime.setBounds(236, 338, 56, 20);
		panelRoute.add(textFieldArrivalTime);
		textFieldArrivalTime.setColumns(10);
		
		DefaultListModel listModelRoutes = new DefaultListModel();
		JList listRoutes = new JList(listModelRoutes);
		listRoutes.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listRoutes.setBounds(10, 139, 282, 87);
		panelRoute.add(listRoutes);
		
		DefaultListModel listModelFlights = new DefaultListModel();
		JList listFlights = new JList(listModelFlights);
		listFlights.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		listFlights.setBounds(10, 418, 282, 73);
		panelRoute.add(listFlights);
		
		JButton btnDeleteFlight = new JButton("Ta bort");
		btnDeleteFlight.setBounds(110, 364, 89, 23);
		panelRoute.add(btnDeleteFlight);
		
		JButton btnDeleteRoute = new JButton("Ta bort");
		btnDeleteRoute.setBounds(117, 90, 89, 23);
		panelRoute.add(btnDeleteRoute);
		
		JLabel lblTillgngligaRoutes = new JLabel("Tillg\u00E4ngliga Routes");
		lblTillgngligaRoutes.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTillgngligaRoutes.setBounds(10, 122, 113, 14);
		panelRoute.add(lblTillgngligaRoutes);
		
		JLabel lblTillgngligaFlights = new JLabel("Tillg\u00E4ngliga Flights");
		lblTillgngligaFlights.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTillgngligaFlights.setBounds(10, 398, 123, 14);
		panelRoute.add(lblTillgngligaFlights);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 93, 21);
		frame.getContentPane().add(menuBar);
		
		JMenu mnMeny = new JMenu("Meny");
		menuBar.add(mnMeny);
		
		JMenuItem mntmHanteraFlygplatser = new JMenuItem("Hantera flygplatser");
		mntmHanteraFlygplatser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAirports.setVisible(true);
				panelRoute.setVisible(false);
				
			}
		});
		
		JMenuItem mntmHanteraFlygrutter = new JMenuItem("Hantera flygrutter");
		mntmHanteraFlygrutter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelRoute.setVisible(true);
				panelAirports.setVisible(false);
			}
		});
		mnMeny.add(mntmHanteraFlygrutter);
		mnMeny.add(mntmHanteraFlygplatser);
		panelRoute.setVisible(false);
	
	
		
		
//		for(Airport a : DbFactory.getAllAirports()){
//			listModelAirports.add(a.getId(), a.getName());
//		}
//		for(City c : DbFactory.getAllCities()){
//			listModelCities.add(c.getId(), c.getName());
//		}
//		for(Route r : DbFactory.getAllRoutes()){
//			listModelRoutes.add(r.getId(), r.getDepartAirport() + " till " + r.getArriveAirport());
//		}
//		for(Flight f : DbFactory.getAllFlights()){
//			listModelFlights.add(f.getId(), f.getDeparture());
//		}
//		btnSaveRoute.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)
//            {
//				Route tempRoute;
//				tempRoute.setArriveAirport(arriveAirport);
//				tempRoute.setDepartAirport(departAirport);
//                DbFactory.insertRoute(tempRoute);
//            }
//		});
//		btnAddCity.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)
//          {
//				City tempCity;
//				tempCity.setCountry(country);
//				tempCity.setName(name);
//              DbFactory.insertCity(tempCity);
//          }
//		});
//		btnAddAirport.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)
//          {
//				Airport tempAirport;
//				tempAirport.setCity(city);
//				tempAirport.setName(name);
//              DbFactory.insertAirport(tempAirport);
//          }
//		});
//		btnSparaFlight.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e)
//          {
//				Flight tempFlight;
//				tempFlight.setArrival(arrival);
//				tempFlight.setDeparture(departure);
//				tempFlight.setPlane(plane);
//				tempFlight.setRoute(route);
//              DbFactory.insertFlight(tempFlight);
//          }
//		});
	}
}
