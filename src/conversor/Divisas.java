package conversor;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Divisas extends JDialog implements ActionListener  {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	public String selected;
	public double Obtenido;
	public double totalDolar, totalEuro, totalLibra, totalQuetzales, totalWones, totalYenes;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Divisas dialog = (Divisas) new JDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			dialog.setModal(true);
			dialog.setTitle("Divisas");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public Divisas(MainMenu parent, boolean modal) {
		super(parent, true);
		
		
		setBounds(250, 100, 500, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("Divisa a Cotizar: ");
		lblNewLabel.setBounds(126, 59, 99, 14);
		
		contentPanel.add(lblNewLabel);
		
		/*Inicia JComboBox */
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(264, 55, 130, 22);
		contentPanel.add(comboBox);
		
		comboBox.addItem("Escoge una divisa");
		comboBox.addItem("Dolar");
		comboBox.addItem("Euro");
		comboBox.addItem("Libra");
		comboBox.addItem("Quetzal");
		comboBox.addItem("Wones");
		comboBox.addItem("Yenes");
		
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					if(!comboBox.getSelectedItem().toString().equals("Divisa a Cotizar: ")) {
						
						selected = comboBox.getSelectedItem().toString() + " convertido a: ";
					}
					
				}
			}
			
		});
		
		
		/*Finaliza JComboBox*/
		
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
		
		
		/*Inicia listado de divisas:*/
		
		JLabel lblDivisa1 = new JLabel("");
		lblDivisa1.setBounds(126, 160, 120, 14);
		//lblDivisa1.setText(selected);
		contentPanel.add(lblDivisa1);
		
		JLabel lblDivisa2 = new JLabel("");
		lblDivisa2.setBounds(126, 185, 120, 14);
		//lblDivisa2.setText(selected);
		contentPanel.add(lblDivisa2);
		
		JLabel lblDivisa3 = new JLabel("");
		lblDivisa3.setBounds(126, 210, 120, 14);
		contentPanel.add(lblDivisa3);
		
		JLabel lblDivisa4 = new JLabel("");
		lblDivisa4.setBounds(126, 235, 120, 14);
		contentPanel.add(lblDivisa4);
		
		JLabel lblDivisa5 = new JLabel("");
		lblDivisa5.setBounds(126, 260, 120, 14);
		contentPanel.add(lblDivisa5);
		
		JLabel lblDivisa6 = new JLabel("");
		lblDivisa6.setBounds(126, 285, 120, 14);
		contentPanel.add(lblDivisa6);
		/* Termina Columna de las primeras labels */
		
		
		
		
		
		JLabel lblDivisa7 = new JLabel("");
		lblDivisa7.setBounds(280, 160, 166, 14);
		contentPanel.add(lblDivisa7);
		
		
		JLabel lblDivisa8 = new JLabel("");
		lblDivisa8.setBounds(280, 185, 166, 14);
		contentPanel.add(lblDivisa8);
		
		
		JLabel lblDivisa9 = new JLabel("");
		lblDivisa9.setBounds(280, 210, 166, 14);
		contentPanel.add(lblDivisa9);
		
		
		JLabel lblDivisa10 = new JLabel("");
		lblDivisa10.setBounds(280, 235, 166, 14);
		contentPanel.add(lblDivisa10);
		
		
		JLabel lblDivisa11 = new JLabel("");
		lblDivisa11.setBounds(280, 260, 166, 14);
		contentPanel.add(lblDivisa11);
		
		
		JLabel lblDivisa12 = new JLabel("");
		lblDivisa12.setBounds(280, 285, 166, 14);
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
						if(comboBox.getSelectedItem().toString().equals("Divisa a Cotizar: ")) {
							JOptionPane.showMessageDialog(null, "Selecciona una divisa");
						}
						
						if(comboBox.getSelectedItem().toString().equals("Dolar")) {
							totalDolar = Obtenido;
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Obtenido * 0.91;
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido * 0.79;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 7.85;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido * 1299.01;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido * 142.63;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Euro")) {
							totalDolar = Math.round(Obtenido * 1.10);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Math.round(Obtenido);
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido * 0.86;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 8.60;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido * 1424.25;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido * 156.29;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Libra")) {
							totalDolar = Math.round(Obtenido * 1.27);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Math.round(Obtenido * 1.16);
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 9.99;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido * 1655.82;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido * 181.63;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Quetzal")) {
							totalDolar = Math.round(Obtenido * 0.13);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Math.round(Obtenido * 0.12);
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido * 0.10;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido * 165.80;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Math.round(Obtenido * 18.19);
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						if(comboBox.getSelectedItem().toString().equals("Wones")) {
							totalDolar = Math.round(Obtenido * 0.00077);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Obtenido * 0.00070;
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido * 0.0000060;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 0.0060;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido * 0.11;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						if(comboBox.getSelectedItem().toString().equals("Yenes")) {
							totalDolar = Math.round(Obtenido * 0.0070);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Math.round(Obtenido * 0.0064);
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Math.round(Obtenido * 0.0055) ;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 0.055;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Math.round(Obtenido * 9.12);
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
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

	public Divisas(ActionListener actionListener, boolean modal) {
		// TODO Auto-generated constructor stub
		
		
		
		setBounds(250, 100, 500, 450);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Divisa a Cotizar: ");
		lblNewLabel.setBounds(126, 59, 99, 14);
		contentPanel.add(lblNewLabel);
		
		/*Inicia JComboBox */
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(264, 55, 130, 22);
		contentPanel.add(comboBox);
		
		comboBox.addItem("Escoge una divisa");
		comboBox.addItem("Dolar");
		comboBox.addItem("Euro");
		comboBox.addItem("Libra");
		comboBox.addItem("Quetzal");
		comboBox.addItem("Wones");
		comboBox.addItem("Yenes");
		
		comboBox.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				if(e.getStateChange()==ItemEvent.SELECTED) {
					if(comboBox.getSelectedItem().toString().equals("Divisa a Cotizar: ")) {
						JOptionPane.showMessageDialog(null, "Selecciona una divisa");
					}
					if(!comboBox.getSelectedItem().toString().equals("Divisa a Cotizar: ")) {
						
						selected = comboBox.getSelectedItem().toString() + " convertido a: ";
					}
					
				}
			}
			
		});
		
		
		/*Finaliza JComboBox*/
		
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
		
		
		/*Inicia listado de divisas:*/
		
		JLabel lblDivisa1 = new JLabel("");
		lblDivisa1.setBounds(126, 160, 120, 14);
		//lblDivisa1.setText(selected);
		contentPanel.add(lblDivisa1);
		
		JLabel lblDivisa2 = new JLabel("");
		lblDivisa2.setBounds(126, 185, 120, 14);
		//lblDivisa2.setText(selected);
		contentPanel.add(lblDivisa2);
		
		JLabel lblDivisa3 = new JLabel("");
		lblDivisa3.setBounds(126, 210, 120, 14);
		contentPanel.add(lblDivisa3);
		
		JLabel lblDivisa4 = new JLabel("");
		lblDivisa4.setBounds(126, 235, 120, 14);
		contentPanel.add(lblDivisa4);
		
		JLabel lblDivisa5 = new JLabel("");
		lblDivisa5.setBounds(126, 260, 120, 14);
		contentPanel.add(lblDivisa5);
		
		JLabel lblDivisa6 = new JLabel("");
		lblDivisa6.setBounds(126, 285, 120, 14);
		contentPanel.add(lblDivisa6);
		/* Termina Columna de las primeras labels */
		
		
		
		
		
		JLabel lblDivisa7 = new JLabel("");
		lblDivisa7.setBounds(280, 160, 166, 14);
		contentPanel.add(lblDivisa7);
		
		
		JLabel lblDivisa8 = new JLabel("");
		lblDivisa8.setBounds(280, 185, 166, 14);
		contentPanel.add(lblDivisa8);
		
		
		JLabel lblDivisa9 = new JLabel("");
		lblDivisa9.setBounds(280, 210, 166, 14);
		contentPanel.add(lblDivisa9);
		
		
		JLabel lblDivisa10 = new JLabel("");
		lblDivisa10.setBounds(280, 235, 166, 14);
		contentPanel.add(lblDivisa10);
		
		
		JLabel lblDivisa11 = new JLabel("");
		lblDivisa11.setBounds(280, 260, 166, 14);
		contentPanel.add(lblDivisa11);
		
		
		JLabel lblDivisa12 = new JLabel("");
		lblDivisa12.setBounds(280, 285, 166, 14);
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
						
						if(comboBox.getSelectedItem().toString().equals("Dolar")) {
							totalDolar = Obtenido;
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Obtenido * 0.91;
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido * 0.79;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 7.85;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido * 1299.01;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido * 142.63;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Euro")) {
							totalDolar = Math.round(Obtenido * 1.10);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Math.round(Obtenido);
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido * 0.86;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 8.60;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido * 1424.25;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido * 156.29;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Libra")) {
							totalDolar = Math.round(Obtenido * 1.27);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Math.round(Obtenido * 1.16);
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 9.99;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido * 1655.82;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido * 181.63;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						
						if(comboBox.getSelectedItem().toString().equals("Quetzal")) {
							totalDolar = Math.round(Obtenido * 0.13);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Math.round(Obtenido * 0.12);
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido * 0.10;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido * 165.80;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Math.round(Obtenido * 18.19);
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						if(comboBox.getSelectedItem().toString().equals("Wones")) {
							totalDolar = Math.round(Obtenido * 0.00077);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Obtenido * 0.00070;
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Obtenido * 0.0000060;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 0.0060;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Obtenido;
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido * 0.11;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
						}
						if(comboBox.getSelectedItem().toString().equals("Yenes")) {
							totalDolar = Math.round(Obtenido * 0.0070);
							lblDivisa7.setText("Dolar: " + " $USD" + String.valueOf(totalDolar));
							
							totalEuro = Math.round(Obtenido * 0.0064);
							lblDivisa8.setText("Euros: " + " €" + String.valueOf(totalEuro));
							
							totalLibra = Math.round(Obtenido * 0.0055) ;
							lblDivisa9.setText("Libras: " + " £" + String.valueOf(totalLibra));
							
							totalQuetzales = Obtenido * 0.055;
							lblDivisa10.setText("Quetzales: " + " Q" + String.valueOf(totalQuetzales));
							
							totalWones = Math.round(Obtenido * 9.12);
							lblDivisa11.setText("Wones: " + " ₩" + String.valueOf(totalWones));
							
							totalYenes = Obtenido;
							lblDivisa12.setText("Yenes: " + " ¥" + String.valueOf(totalYenes));
							
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
