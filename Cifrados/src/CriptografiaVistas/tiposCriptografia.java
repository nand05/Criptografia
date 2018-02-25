package CriptografiaVistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tiposCriptografia extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tiposCriptografia frame = new tiposCriptografia();
					frame.setVisible(true);
					frame.setTitle("Tipos de Criptografia");
					frame.setLocationRelativeTo(null);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public tiposCriptografia() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 311, 271);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
			
		JButton btnCC = new JButton("Criptografia Clasica");
		btnCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanaCC();
				setVisible(false);
			}
		});
		btnCC.setBounds(80, 28, 148, 36);
		contentPane.add(btnCC);
		
		JButton btnCM = new JButton("Criptografia Moderna");
		btnCM.setBounds(80, 111, 148, 36);
		contentPane.add(btnCM);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(196, 198, 89, 23);
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
