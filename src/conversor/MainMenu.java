package conversor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class MainMenu extends JFrame implements ActionListener {

	private JPanel contentPane;
	/*private Divisas divisas;
	private Temperatura temperatura;
	private Longitudes longitudes*/

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
					frame.setTitle("Bienvenidos al conversor Alura");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Escoge el Conversor a utilizar: ");
		lblNewLabel.setBounds(130, 49, 186, 14);
		contentPane.add(lblNewLabel);
		
		
		
		JButton btnDivisas = new JButton("Conversor de Divisas");
		btnDivisas.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()== btnDivisas) {
					Divisas divisas = new Divisas(MainMenu.this, true);
					divisas.setVisible(true);
					divisas.setModal(true);
				}
				
			}
			
		});
		btnDivisas.setBounds(130, 87, 189, 23);
		contentPane.add(btnDivisas);
		
		
		
		JButton btnTemperatura = new JButton("Conversor de Temperatura");
		btnTemperatura.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Temperatura temperatura = new Temperatura(MainMenu.this, true);
				
				temperatura.setModal(true);
				temperatura.setVisible(true);
				
			}
			
		});	
		btnTemperatura.setBounds(130, 121, 189, 23);
		contentPane.add(btnTemperatura);
		
		JButton btnLongitudes = new JButton("Conversor de Longitudes");
		btnLongitudes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Longitudes longitudes = new Longitudes(MainMenu.this, true);
				longitudes.setVisible(true);
				longitudes.setModal(true);
			}
			
		});
		btnLongitudes.setBounds(130, 155, 189, 23);
		contentPane.add(btnLongitudes);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(this);
		btnSalir.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalir);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}
}
