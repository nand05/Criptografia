package CriptografiaVistas;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

import CriptografiaMetodos.*;

public class vistaPolybios extends JFrame {

	private JPanel contentPane;
	private JTextField Dir;
	private Polybios polybios = new Polybios();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {	
		Polybios p = new Polybios();
		p.llenaMatriz();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaPolybios frame = new vistaPolybios();
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
	public vistaPolybios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 483);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JButton btnCifrar = new JButton("Cifrar");
		JButton btnDescifrar = new JButton("Descifrar");
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser explorador = new JFileChooser();
				explorador.setDialogTitle("Abrir documento...");
				//Muestro un dialogo sin pasarle parent con el boton de abrir
				int seleccion = explorador.showDialog(null, "Aceptar");
				  
				//analizamos la respuesta
				switch(seleccion) {
				case JFileChooser.APPROVE_OPTION:
					//seleccionó abrir
					File archivo = explorador.getSelectedFile();
					if (archivo.isFile() && archivo != null) {
						Dir.setText(archivo.getAbsolutePath());
						btnCifrar.setEnabled(true);
						btnDescifrar.setEnabled(true);
					}
					break;
				case JFileChooser.CANCEL_OPTION:
				 //dio click en cancelar o cerro la ventana
					break;

				case JFileChooser.ERROR_OPTION:
				 //llega aqui si sucede un error
				 break;
				}
			}
		});
		btnBuscar.setBounds(47, 54, 89, 33);
		contentPane.add(btnBuscar);
		
		Dir = new JTextField();
		Dir.setEnabled(false);
		Dir.setBounds(146, 59, 417, 23);
		contentPane.add(Dir);
		Dir.setColumns(10);
		
		btnCifrar.setEnabled(false);
		btnCifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File(Dir.getText());
				if (f.getAbsolutePath().endsWith(".txt")) {
					
					//aqui va el cigo de cifrado de polybios
					Dir.setText("");
					btnCifrar.setEnabled(false);
			    	btnDescifrar.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un archivo de texto valido (.txt)");
					Dir.setText("");
				}
			}
		});
		btnCifrar.setBounds(149, 249, 123, 33);
		contentPane.add(btnCifrar);
		
		btnDescifrar.setEnabled(false);
		btnDescifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = new File(Dir.getText());
				if (f.getAbsolutePath().endsWith("C.txt")) {
					//aqui va el codigo de descifrado de polybios
					Dir.setText("");
					btnCifrar.setEnabled(false);
			    	btnDescifrar.setEnabled(false);
				} else {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un archivo de texto valido (*C.txt)");
					Dir.setText("");
				}
			}
		});
		btnDescifrar.setBounds(315, 249, 123, 33);
		contentPane.add(btnDescifrar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaCC();
				setVisible(false);
			}
		});
		btnRegresar.setBounds(47, 398, 89, 23);
		contentPane.add(btnRegresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(461, 398, 89, 23);
		contentPane.add(btnSalir);
	}
	
	public void ventanaCC() {
		criptoClasica cc = new criptoClasica();
		cc.setVisible(true);
		cc.setTitle("Metodos de la Criptografia Clasica");
		cc.setResizable(false);
		cc.setLocationRelativeTo(null);
	}
}