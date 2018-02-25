package CriptografiaVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;

import CriptografiaMetodos.*;

public class vistaEscitala extends JFrame {

	private JPanel contentPane;
	private JTextField Dir;
	private JTextField numCaras;
	private Escitala escitala = new Escitala();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vistaEscitala frame = new vistaEscitala();
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
	public vistaEscitala() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 612, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser explorador = new JFileChooser();
				explorador.setDialogTitle("Abrir documento...");
				//Muestro un dialogo sin pasarle parent con el boton de abrir
				int seleccion = explorador.showDialog(null, "Aceptar");
				  
				//analizamos la respuesta
				switch(seleccion) {
				case JFileChooser.APPROVE_OPTION:
					//seleccionó abrir
					File archivo = explorador.getSelectedFile();
					if (archivo != null) {
						Dir.setText(archivo.getAbsolutePath());
						numCaras.setEnabled(true);
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
		Dir.setBounds(146, 59, 417, 23);
		contentPane.add(Dir);
		Dir.setColumns(10);
		
		JButton btnCifrar = new JButton("Cifrar");
		JButton btnDescifrar = new JButton("Descifrar");
		
		numCaras = new JTextField();
		numCaras.setEnabled(false);
		numCaras.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char caracter = arg0.getKeyChar();
			      // Verificar si la tecla pulsada no es un digito 
			      if(((caracter < '0') || (caracter > '9')) && (caracter != '\b' /*corresponde a BACK_SPACE*/)){
			         arg0.consume();  // ignorar el evento de teclado
			      }else {
			    	  btnCifrar.setEnabled(true);
			    	  btnDescifrar.setEnabled(true);
			      }
			}
		});
		
		numCaras.setHorizontalAlignment(SwingConstants.CENTER);
		numCaras.setBounds(282, 128, 68, 23);
		contentPane.add(numCaras);
		numCaras.setColumns(10);
		
		
		btnCifrar.setEnabled(false);
		btnCifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File f = new File(Dir.getText());
				if (f.getAbsolutePath().endsWith(".txt") && (Integer.parseInt(numCaras.getText()) < 256 || Integer.parseInt(numCaras.getText()) >= 2)) {
					escitala.Cifrar(Dir.getText(), Integer.parseInt(numCaras.getText()));
					Dir.setText("");
					numCaras.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un archivo de texto valido (.txt) \n o un numero de caras >= a 2 y < 256");
					Dir.setText("");
					numCaras.setText("");
				}
			}
		});
		btnCifrar.setBounds(149, 249, 123, 33);
		contentPane.add(btnCifrar);
		
		btnDescifrar.setEnabled(false);
		btnDescifrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f = new File(Dir.getText());
				if (f.getAbsolutePath().endsWith("C.txt") && (Integer.parseInt(numCaras.getText()) < 256 || Integer.parseInt(numCaras.getText()) >= 2)) {
					escitala.Descifrar(Dir.getText(), Integer.parseInt(numCaras.getText()));
					Dir.setText("");
					numCaras.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Por favor ingrese un archivo de texto valido (*C.txt) \n o un numero de caras >= a 2 y < 256");
					Dir.setText("");
					numCaras.setText("");
				}
			}
		});
		btnDescifrar.setBounds(315, 249, 123, 33);
		contentPane.add(btnDescifrar);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaCC();
				setVisible(false);
			}
		});
		btnRegresar.setBounds(47, 398, 89, 23);
		contentPane.add(btnRegresar);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(461, 398, 89, 23);
		contentPane.add(btnSalir);
		
		JLabel lblNumeroDeCaras = new JLabel("Numero de Caras");
		lblNumeroDeCaras.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroDeCaras.setBounds(149, 128, 123, 23);
		contentPane.add(lblNumeroDeCaras);
	}
	
	public void ventanaCC() {
		criptoClasica cc = new criptoClasica();
		cc.setVisible(true);
		cc.setTitle("Metodos de la Criptografia Clasica");
		cc.setResizable(false);
		cc.setLocationRelativeTo(null);
	}
}
