package conversor;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Temperatura extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	public String selected;
	public double Obtenido;
	public double totalKelvin, totalCelsius, totalFarenheit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Temperatura dialog = (Temperatura) new JDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setModal(true);
			dialog.setTitle("temperaturas");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Temperatura(MainMenu parent, boolean modal) {
		super(parent, true);
		setBounds(250, 300, 500, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Temperatura a convertir: ");
		lblNewLabel.setBounds(95, 31, 145, 14);
		contentPanel.add(lblNewLabel);
		
		/*Inicia JComboBox */
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(254, 28, 168, 20);
		contentPanel.add(comboBox);
		
		comboBox.addItem("Escoge una unidad de medida");
		comboBox.addItem("Kelvin");
		comboBox.addItem("Celsius");
		comboBox.addItem("Farenheit");
		
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					
					if(!comboBox.getSelectedItem().toString().equals("Temperatura a convertir: ")) {
						
						selected = comboBox.getSelectedItem().toString() + " convertido a: ";
					}
					
				}
			}
			
		});
		
		JLabel lblInput = new JLabel("Cantidad a convertir: ");
		lblInput.setBounds(113, 62, 145, 14);
		contentPanel.add(lblInput);
		
		textField = new JTextField();
		textField.setBounds(258, 59, 86, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblLine = new JLabel("_____________________________");
		lblLine.setBounds(149, 90, 241, 14);
		contentPanel.add(lblLine);
		
		
		/*Inicia listado de divisas:*/
		
		JLabel lblDivisa1 = new JLabel("");
		lblDivisa1.setBounds(126, 160, 125, 14);
		//lblDivisa1.setText(selected);
		contentPanel.add(lblDivisa1);
		
		JLabel lblDivisa2 = new JLabel("");
		lblDivisa2.setBounds(126, 185, 125, 14);
		//lblDivisa2.setText(selected);
		contentPanel.add(lblDivisa2);
		
		JLabel lblDivisa3 = new JLabel("");
		lblDivisa3.setBounds(126, 210, 125, 14);
		contentPanel.add(lblDivisa3);
		
		JLabel lblDivisa7 = new JLabel("");
		lblDivisa7.setBounds(280, 160, 166, 14);
		contentPanel.add(lblDivisa7);
		
		
		JLabel lblDivisa8 = new JLabel("");
		lblDivisa8.setBounds(280, 185, 166, 14);
		contentPanel.add(lblDivisa8);
		
		
		JLabel lblDivisa9 = new JLabel("");
		lblDivisa9.setBounds(280, 210, 166, 14);
		contentPanel.add(lblDivisa9);
		
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Convertir");
				okButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						lblDivisa1.setText(selected);
						lblDivisa2.setText(selected);
						lblDivisa3.setText(selected);
						Obtenido = Double.parseDouble(textField.getText());
						if(comboBox.getSelectedItem().toString().equals("Temperatura a convertir: ")) {
							JOptionPane.showMessageDialog(null, "Selecciona una unidaded de medida");
						}
						
						if(comboBox.getSelectedItem().toString().equals("Kelvin")) {
							totalKelvin = Obtenido;
							lblDivisa7.setText("Kelvin: " + String.valueOf(totalKelvin));
							
							totalCelsius = Obtenido - 273.15;
							lblDivisa8.setText("°Celsius: " + String.valueOf(totalCelsius) + "°C");
							
							totalFarenheit = 1.8 * (Obtenido - 273.15) + 32;
							lblDivisa9.setText("°Farenheit: " + String.valueOf(totalFarenheit) + "°F");
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Celsius")) {
							totalKelvin = Math.round(Obtenido + 273.15);
							lblDivisa7.setText("Kelvin: " + String.valueOf(totalKelvin));
							
							totalCelsius = Math.round(Obtenido);
							lblDivisa8.setText("°Celsius: " + String.valueOf(totalCelsius) + "°C");
							
							totalFarenheit = (Obtenido * 1.8) + 32;
							lblDivisa9.setText("°Farenheit: " + String.valueOf(totalFarenheit) + "°F");
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Farenheit")) {
							totalKelvin = Math.round((5/9)*(Obtenido - 32) + 273.15);
							lblDivisa7.setText("Kelvin: " +  String.valueOf(totalKelvin));
							
							totalCelsius = Math.round((Obtenido - 32)/1.8);
							lblDivisa8.setText("°Celsius: " + String.valueOf(totalCelsius) + "°C");
							
							totalFarenheit = Obtenido;
							lblDivisa9.setText("°Farenheit: "  + String.valueOf(totalFarenheit) + "°F");
							
							
							
						}
					}
					
				});
				okButton.setActionCommand("Convertir");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Regresar");
				cancelButton.setActionCommand("Regresar");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		dispose();
	}

	

}
