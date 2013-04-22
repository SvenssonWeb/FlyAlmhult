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


public class MainWindow {

	private JFrame frame;
	private JTextField textAirportName;

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
		frame.setBounds(100, 100, 581, 383);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panelAirports = new JPanel();
		panelAirports.setBounds(23, 51, 262, 287);
		frame.getContentPane().add(panelAirports);
		panelAirports.setLayout(null);
		
		JLabel lblHanteraFlygplatser = new JLabel("Hantera flygplatser");
		lblHanteraFlygplatser.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHanteraFlygplatser.setBounds(10, 11, 162, 28);
		panelAirports.add(lblHanteraFlygplatser);
		
		JLabel lblFlygplats = new JLabel("Flygplats:");
		lblFlygplats.setBounds(10, 50, 62, 14);
		panelAirports.add(lblFlygplats);
		
		JLabel lblStad = new JLabel("Stad:");
		lblStad.setBounds(10, 75, 46, 14);
		panelAirports.add(lblStad);
		
		textAirportName = new JTextField();
		textAirportName.setBounds(61, 47, 137, 20);
		panelAirports.add(textAirportName);
		textAirportName.setColumns(10);
		
		JComboBox comboBoxCity = new JComboBox();
		comboBoxCity.setBounds(61, 72, 137, 20);
		panelAirports.add(comboBoxCity);
		
		JButton btnLggTillndra = new JButton("L\u00E4gg till/\u00C4ndra");
		btnLggTillndra.setBounds(61, 103, 137, 23);
		panelAirports.add(btnLggTillndra);
		
		JButton btnTaBortFlygplats = new JButton("Ta bort flygplats");
		btnTaBortFlygplats.setBounds(61, 134, 137, 23);
		panelAirports.add(btnTaBortFlygplats);
		
		JLabel lblTillgngligaFlygplatser = new JLabel("Tillg\u00E4ngliga flygplatser");
		lblTillgngligaFlygplatser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTillgngligaFlygplatser.setBounds(10, 168, 162, 14);
		panelAirports.add(lblTillgngligaFlygplatser);
		
		JList list = new JList();
		list.setBounds(10, 193, 188, 83);
		panelAirports.add(list);
		
		JMenu mnMeny = new JMenu("Meny");
		mnMeny.setBounds(23, 21, 83, 19);
		frame.getContentPane().add(mnMeny);
		
		JMenuItem mntmHanteraFlygplatser = new JMenuItem("Hantera flygplatser");
		/*mntmHanteraFlygplatser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelAirports.setVisible(false);
			}
		});*/
		mnMeny.add(mntmHanteraFlygplatser);
	}
}
