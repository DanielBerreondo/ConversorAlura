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

public class Longitudes extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	public String selected;
	public double Obtenido;
	public double totalCentimetros, totalMetros, totalKilometros, totalPulgadas, totalPies, totalMillas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Longitudes dialog = (Longitudes) new JDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setModal(true);
			dialog.setTitle("Longitudes");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 * @param b 
	 * @param actionListener 
	 */
	public Longitudes(MainMenu parent, boolean modal) {
		super(parent, true);
		setBounds(250, 200, 500, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Unidad de medida: ");
		lblNewLabel.setBounds(126, 59, 145, 14);
		contentPanel.add(lblNewLabel);
		
		/*Inicia JComboBox */
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(264, 55, 145, 22);
		contentPanel.add(comboBox);
		
		comboBox.addItem("Escoge una medida:");
		comboBox.addItem("Centimetros");
		comboBox.addItem("Metros");
		comboBox.addItem("Kilometros");
		comboBox.addItem("Pulgadas");
		comboBox.addItem("Pies");
		comboBox.addItem("Millas");
		
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					if(comboBox.getSelectedItem().toString().equals("Escoge una medida: ")) {
						//JOptionPane.showMessageDialog(null, "Selecciona una medida");
			              
					}
					if(!comboBox.getSelectedItem().toString().equals("Escoge una medida: ")) {
						
						selected = comboBox.getSelectedItem().toString() + " a: ";
					}
					
				}
			}
			
		});
		
		JLabel lblInput = new JLabel("Cantidad a convertir: ");
		lblInput.setBounds(103, 103, 146, 14);
		contentPanel.add(lblInput);
		
		textField = new JTextField();
		textField.setBounds(264, 100, 130, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblLine = new JLabel("_____________________________");
		lblLine.setBounds(143, 135, 241, 14);
		contentPanel.add(lblLine);
		
		JLabel lblDivisa1 = new JLabel("");
		lblDivisa1.setBounds(150, 160, 120, 14);
		//lblDivisa1.setText(selected);
		contentPanel.add(lblDivisa1);
		
		JLabel lblDivisa2 = new JLabel("");
		lblDivisa2.setBounds(150, 185, 120, 14);
		//lblDivisa2.setText(selected);
		contentPanel.add(lblDivisa2);
		
		JLabel lblDivisa3 = new JLabel("");
		lblDivisa3.setBounds(150, 210, 120, 14);
		contentPanel.add(lblDivisa3);
		
		JLabel lblDivisa4 = new JLabel("");
		lblDivisa4.setBounds(150, 235, 120, 14);
		contentPanel.add(lblDivisa4);
		
		JLabel lblDivisa5 = new JLabel("");
		lblDivisa5.setBounds(150, 260, 120, 14);
		contentPanel.add(lblDivisa5);
		
		JLabel lblDivisa6 = new JLabel("");
		lblDivisa6.setBounds(150, 285, 120, 14);
		contentPanel.add(lblDivisa6);
		/* Termina Columna de las primeras labels */
		
		
		
		
		
		JLabel lblDivisa7 = new JLabel("");
		lblDivisa7.setBounds(260, 160, 166, 14);
		contentPanel.add(lblDivisa7);
		
		
		JLabel lblDivisa8 = new JLabel("");
		lblDivisa8.setBounds(260, 185, 166, 14);
		contentPanel.add(lblDivisa8);
		
		
		JLabel lblDivisa9 = new JLabel("");
		lblDivisa9.setBounds(260, 210, 166, 14);
		contentPanel.add(lblDivisa9);
		
		
		JLabel lblDivisa10 = new JLabel("");
		lblDivisa10.setBounds(260, 235, 166, 14);
		contentPanel.add(lblDivisa10);
		
		
		JLabel lblDivisa11 = new JLabel("");
		lblDivisa11.setBounds(260, 260, 166, 14);
		contentPanel.add(lblDivisa11);
		
		
		JLabel lblDivisa12 = new JLabel("");
		lblDivisa12.setBounds(260, 285, 166, 14);
		contentPanel.add(lblDivisa12);
		
		
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
						lblDivisa4.setText(selected);
						lblDivisa5.setText(selected);
						lblDivisa6.setText(selected);
						Obtenido = Double.parseDouble(textField.getText());
						if(comboBox.getSelectedItem().toString().equals("Escoge una medida:")) {
							JOptionPane.showMessageDialog(null, "Selecciona una divisa");
						}
						
						if(comboBox.getSelectedItem().toString().equals("Centimetros")) {
							totalCentimetros = Obtenido;
							lblDivisa7.setText("centimetros: " + String.valueOf(totalCentimetros)+"cm");
							
							totalMetros = Obtenido / 100;
							lblDivisa8.setText("metros: " + String.valueOf(totalMetros) + "m");
							
							totalKilometros = Obtenido / 100000;
							lblDivisa9.setText("kilometros: " + String.valueOf(totalKilometros)+"Km");
							
							totalPulgadas = Obtenido / 2.54;
							lblDivisa10.setText("pulgadas: " + String.valueOf(totalPulgadas)+"in");
							
							totalPies = Obtenido / 30.48;
							lblDivisa11.setText("pies: " + String.valueOf(totalPies) + "ft");
							
							totalMillas = Obtenido / 160900;
							lblDivisa12.setText("millas: " + String.valueOf(totalMillas)+"mi");
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Metros")) {
							totalCentimetros = Math.round(Obtenido * 100);
							lblDivisa7.setText("centimetros: " + String.valueOf(totalCentimetros)+"cm");
							
							totalMetros = Math.round(Obtenido);
							lblDivisa8.setText("metros: " + String.valueOf(totalMetros) + "m");
							
							totalKilometros = Obtenido / 1000;
							lblDivisa9.setText("kilometros: " + String.valueOf(totalKilometros)+"Km");
							
							totalPulgadas = Obtenido * 39.3701;
							lblDivisa10.setText("pulgadas: " + String.valueOf(totalPulgadas) + "in");
							
							totalPies = Obtenido * 3.28084;
							lblDivisa11.setText("pies: " + String.valueOf(totalPies) +"ft");
							
							totalMillas = Obtenido / 1609;
							lblDivisa12.setText("millas: " + String.valueOf(totalMillas)+ "mi");
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Kilometros")) {
							totalCentimetros = Math.round(Obtenido * 100000);
							lblDivisa7.setText("centimetros: " + String.valueOf(totalCentimetros) +"cm");
							
							totalMetros = Math.round(Obtenido * 1000);
							lblDivisa8.setText("metros: " + String.valueOf(totalMetros) + "m");
							
							totalKilometros = Obtenido;
							lblDivisa9.setText("kilometros: " + String.valueOf(totalKilometros)+"km");
							
							totalPulgadas= Obtenido * 39370;
							lblDivisa10.setText("pulgadas: " + String.valueOf(totalPulgadas)+"in");
							
							totalPies = Obtenido * 3281;
							lblDivisa11.setText("pies: " + String.valueOf(totalPies)+ "ft");
							
							totalMillas = Obtenido / 1.609;
							lblDivisa12.setText("millas: " +  String.valueOf(totalMillas) + "mi");
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Pulgadas")) {
							totalCentimetros = Math.round(Obtenido * 2.54);
							lblDivisa7.setText("centimetros: " + String.valueOf(totalCentimetros)+"cm");
							
							totalMetros = Math.round(Obtenido / 39.37);
							lblDivisa8.setText("metros: " + String.valueOf(totalMetros)+"m");
							
							totalKilometros = Obtenido / 39370;
							lblDivisa9.setText("kilometros: " + String.valueOf(totalKilometros)+"Km");
							
							totalPulgadas = Obtenido;
							lblDivisa10.setText("pulgadas: " + String.valueOf(totalPulgadas)+"in");
							
							totalPies = Obtenido / 12;
							lblDivisa11.setText("pies: " + String.valueOf(totalPies)+"ft");
							
							totalMillas = (Obtenido / 63360);
							lblDivisa12.setText("millas: " +  String.valueOf(totalMillas)+"mi");
							
						}
						if(comboBox.getSelectedItem().toString().equals("Pies")) {
							totalCentimetros = Math.round(Obtenido * 30.48);
							lblDivisa7.setText("centimetros: " + String.valueOf(totalCentimetros)+"m");
							
							totalMetros = Obtenido / 3.281;
							lblDivisa8.setText("metros: " +  String.valueOf(totalMetros)+"m");
							
							totalKilometros = Obtenido / 3281;
							lblDivisa9.setText("kilometros: " + String.valueOf(totalKilometros)+"Km");
							
							totalPulgadas = Obtenido * 12;
							lblDivisa10.setText("pulgadas: " + String.valueOf(totalPulgadas)+"in");
							
							totalPies = Obtenido;
							lblDivisa11.setText("pies: " + String.valueOf(totalPies)+"ft");
							
							totalMillas = Obtenido / 5280;
							lblDivisa12.setText("milas: " + String.valueOf(totalMillas)+"mi");
							
						}
						if(comboBox.getSelectedItem().toString().equals("Millas")) {
							totalCentimetros = Math.round(Obtenido * 160900);
							lblDivisa7.setText("centimetros: " + String.valueOf(totalCentimetros)+"cm");
							
							totalMetros = Math.round(Obtenido * 1609);
							lblDivisa8.setText("metros: " + String.valueOf(totalMetros)+"m");
							
							totalKilometros = Math.round(Obtenido * 1.60934) ;
							lblDivisa9.setText("kilometros: " + String.valueOf(totalKilometros)+"Km");
							
							totalPulgadas = Obtenido * 63360;
							lblDivisa10.setText("pulgadas: " +  String.valueOf(totalPulgadas)+"in");
							
							totalPies = Math.round(Obtenido * 5280);
							lblDivisa11.setText("pies: " +  String.valueOf(totalPies)+"ft");
							
							totalMillas = Obtenido;
							lblDivisa12.setText("millas: " + String.valueOf(totalMillas)+"mi");
							
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
