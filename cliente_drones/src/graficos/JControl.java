package graficos;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.InfoDronFactory;
import service.InfoDronService;

public class JControl extends JFrame{
	private JPanel contentPane;
	private JTextField tfLongitud;
	private JTextField tfLatitud;
	JLabel lblInfo = new JLabel("Panel del dron: ");
	

	/**
	 * Create the frame.
	 */
	public JControl(String nombre,int pos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(pos, 100, 361, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblInfo.setText(lblInfo.getText()+nombre);
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInfo.setBounds(96, 25, 191, 22);
		contentPane.add(lblInfo);
		
		JLabel lblNewLabel = new JLabel("Longitud: ");
		lblNewLabel.setBounds(45, 83, 72, 14);
		contentPane.add(lblNewLabel);
		
		tfLongitud = new JTextField();
		tfLongitud.setBounds(127, 80, 96, 20);
		contentPane.add(tfLongitud);
		tfLongitud.setColumns(10);
		
		JLabel lblLatitud = new JLabel("Latitud: ");
		lblLatitud.setBounds(45, 128, 72, 14);
		contentPane.add(lblLatitud);
		
		tfLatitud = new JTextField();
		tfLatitud.setColumns(10);
		tfLatitud.setBounds(127, 125, 96, 20);
		contentPane.add(tfLatitud);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InfoDronService service=InfoDronFactory.getInfoDronService();
				service.actualizarPosicion(nombre,
						Double.parseDouble(tfLongitud.getText()), 
						Double.parseDouble(tfLatitud.getText()));
			}
		});
		btnNewButton.setBounds(127, 173, 89, 23);
		contentPane.add(btnNewButton);
		this.setVisible(true);
	}
}
