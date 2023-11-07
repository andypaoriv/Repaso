import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Gui extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNom;
	private JTextField textField_Emp;
	private JTextField textField_Pre;
	private JTextField textField;
	controlaArchivos archivo = new controlaArchivos("tienda.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Gui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setBounds(42, 46, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Empresa:");
		lblNewLabel_1.setBounds(42, 89, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Precio:");
		lblNewLabel_2.setBounds(42, 139, 46, 14);
		contentPane.add(lblNewLabel_2);
		
		textFieldNom = new JTextField();
		textFieldNom.setBounds(96, 43, 86, 20);
		contentPane.add(textFieldNom);
		textFieldNom.setColumns(10);
		
		textField_Emp = new JTextField();
		textField_Emp.setBounds(98, 86, 86, 20);
		contentPane.add(textField_Emp);
		textField_Emp.setColumns(10);
		
		textField_Pre = new JTextField();
		textField_Pre.setBounds(96, 136, 86, 20);
		contentPane.add(textField_Pre);
		textField_Pre.setColumns(10);
		
		JButton btnNewButton = new JButton("Escribir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				archivo.escribeEnArchivo(textFieldNom.getText(), textField_Emp.getText(), Integer.parseInt(textField_Pre.getText()));
			}
		});
		btnNewButton.setBounds(42, 207, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Leer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BufferedReader in = new BufferedReader(new FileReader("\\Users\\Andypao\\Documents\\tienda.txt"));
					String linea = in.readLine();
					while(linea!=null) {
						int indexComaUno = linea.indexOf(",",1);
						int indexComaDos = linea.indexOf(",",indexComaUno+1);
						String nombre = linea.substring(0,indexComaUno);
						String tel = linea.substring(indexComaUno+1,indexComaDos);
						String correo = linea.substring(indexComaDos+1, linea.length());
						textField.setText(linea);
						linea = in.readLine(); 
						
					
					} 
					in.close();
				} catch (IOException e2) {
				JOptionPane.showMessageDialog(btnNewButton_1, "No encontré");
				}
				
			}

			
		});
		btnNewButton_1.setBounds(171, 207, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButtonBuscar = new JButton("Buscar");
		btnNewButtonBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nombreBuscar = JOptionPane.showInputDialog("Dime el nombre a buscar");
				Clase encontrado = archivo.buscar(nombreBuscar);
				textFieldNom.setText(encontrado.getNombre());
				textField_Emp.setText(encontrado.getEmpresa());
				textField_Pre.setText(String.valueOf(encontrado.getPrecio()));
			
			}
			
		});
		btnNewButtonBuscar.setBounds(298, 207, 89, 23);
		contentPane.add(btnNewButtonBuscar);
		
		textField = new JTextField();
		textField.setBounds(220, 25, 204, 171);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
