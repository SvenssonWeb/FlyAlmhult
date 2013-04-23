import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow {

	private JFrame frame;
	private JTextField textAirportName;
	private JTextField textAddCity;
	private JTextField textFieldDepartureTime;
	private JTextField textFieldArrivalTime;

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
		frame.setBounds(100, 100, 567, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		final JPanel panelRoute = new JPanel();
		panelRoute.setBounds(65, 40, 302, 380);
		frame.getContentPane().add(panelRoute);
		panelRoute.setLayout(null);
		
		JLabel lblFlightRoute = new JLabel("Flight Route");
		lblFlightRoute.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFlightRoute.setBounds(10, 11, 113, 26);
		panelRoute.add(lblFlightRoute);
		
		JLabel lblFlighter = new JLabel("Flight");
		lblFlighter.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblFlighter.setBounds(10, 162, 97, 20);
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
		comboBoxRoute.setBounds(66, 193, 166, 20);
		panelRoute.add(comboBoxRoute);
		
		JLabel lblFlygrutt = new JLabel("Flygrutt:");
		lblFlygrutt.setBounds(10, 196, 46, 14);
		panelRoute.add(lblFlygrutt);
		
		JComboBox comboBoxPlane = new JComboBox();
		comboBoxPlane.setBounds(66, 219, 166, 20);
		panelRoute.add(comboBoxPlane);
		
		JLabel lblFlygplan = new JLabel("Flygplan:");
		lblFlygplan.setBounds(10, 222, 46, 14);
		panelRoute.add(lblFlygplan);
		
		JLabel lblAvgng = new JLabel("Avg\u00E5ng:");
		lblAvgng.setBounds(10, 253, 46, 14);
		panelRoute.add(lblAvgng);
		
		JLabel lblAnkomst = new JLabel("Ankomst:");
		lblAnkomst.setBounds(122, 253, 63, 14);
		panelRoute.add(lblAnkomst);
		
		JButton btnSparaFlight = new JButton("Spara");
		btnSparaFlight.setBounds(143, 278, 89, 23);
		panelRoute.add(btnSparaFlight);
		
		textFieldDepartureTime = new JTextField();
		textFieldDepartureTime.setBounds(66, 250, 46, 20);
		panelRoute.add(textFieldDepartureTime);
		textFieldDepartureTime.setColumns(10);
		
		textFieldArrivalTime = new JTextField();
		textFieldArrivalTime.setBounds(186, 250, 46, 20);
		panelRoute.add(textFieldArrivalTime);
		textFieldArrivalTime.setColumns(10);
		panelRoute.setVisible(false);
				
		final JPanel panelAirports = new JPanel();
		panelAirports.setBounds(65, 40, 276, 380);
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
		
		JList listAirports = new JList();
		listAirports.setBounds(10, 193, 256, 94);
		panelAirports.add(listAirports);
		
		JLabel lblLggTillStder = new JLabel("L\u00E4gg till st\u00E4der");
		lblLggTillStder.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLggTillStder.setBounds(10, 312, 127, 14);
		panelAirports.add(lblLggTillStder);
		
		textAddCity = new JTextField();
		textAddCity.setBounds(10, 331, 162, 20);
		panelAirports.add(textAddCity);
		textAddCity.setColumns(10);
		
		JButton btnAddCity = new JButton("L\u00E4gg till");
		btnAddCity.setBounds(177, 330, 89, 23);
		panelAirports.add(btnAddCity);
		
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
		
		
	}
}
