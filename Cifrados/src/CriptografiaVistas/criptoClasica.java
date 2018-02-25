package CriptografiaVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class criptoClasica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					criptoClasica frame = new criptoClasica();
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
	public criptoClasica() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnEscitala = new JButton("Escitala");
		btnEscitala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaE();
				setVisible(false);
			}
		});
		btnEscitala.setBounds(179, 43, 143, 30);
		contentPane.add(btnEscitala);
		
		JButton btnPolybios = new JButton("Polybios");
		btnPolybios.setBounds(179, 84, 143, 30);
		contentPane.add(btnPolybios);
		
		JButton btnCifradoCesar = new JButton("Cifrado Cesar");
		btnCifradoCesar.setBounds(179, 125, 143, 30);
		contentPane.add(btnCifradoCesar);
		
		JButton btnCifradoDeVigenere = new JButton("Cifrado de Vigenere");
		btnCifradoDeVigenere.setBounds(179, 166, 143, 30);
		contentPane.add(btnCifradoDeVigenere);
		
		JButton btnTransformacionAfin = new JButton("Transformacion Afin");
		btnTransformacionAfin.setBounds(179, 207, 143, 30);
		contentPane.add(btnTransformacionAfin);
		
		JButton btnCifradoPlayfair = new JButton("Cifrado Playfair");
		btnCifradoPlayfair.setBounds(179, 248, 143, 30);
		contentPane.add(btnCifradoPlayfair);
		
		JButton btnCifradoHill = new JButton("Cifrado Hill");
		btnCifradoHill.setBounds(179, 289, 143, 30);
		contentPane.add(btnCifradoHill);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(367, 368, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnRegresar = new JButton("Regresar");
		btnRegresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaTP();
				setVisible(false);
			}
		});
		btnRegresar.setBounds(44, 368, 89, 23);
		contentPane.add(btnRegresar);
	}
	
	public void ventanaTP() {
		tiposCriptografia tc = new tiposCriptografia();
		tc.setVisible(true);
		tc.setTitle("Tipos de Criptografia");
		tc.setLocationRelativeTo(null);
		tc.setResizable(false);
	}
	
	public void ventanaE() {
		vistaEscitala es = new vistaEscitala();
		es.setVisible(true);
		es.setTitle("Tipos de Criptografia");
		es.setLocationRelativeTo(null);
		es.setResizable(false);
		
	}

}
