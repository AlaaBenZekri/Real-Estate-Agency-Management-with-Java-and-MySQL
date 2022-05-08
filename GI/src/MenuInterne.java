import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;

public class MenuInterne extends JFrame {

	private JPanel contentPane;
	private JButton btnSuivant;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuInterne frame = new MenuInterne();
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
	public MenuInterne() {
		setResizable(false);
		setTitle("Menu Interne");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(480, 170, 446, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton retourButton = new JButton("Retourner");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				Menu m=new Menu();
				m.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(10, 156, 104, 31);
		contentPane.add(retourButton);
		
		JLabel lblNewLabel = new JLabel("Qu'est-ce que vous voulez g\u00E9rer?");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(32, 28, 412, 25);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(comboBox.getSelectedItem()).equals("")==false)
					btnSuivant.setEnabled(true);
				else
					btnSuivant.setEnabled(false);
			}
		});
		String[] valeurs = null;
		if (Home.admin)
			valeurs = new String[] {"", "Les employes du bureau", "Les employes des visites", "Les classes standards", "Les clients", "Les proprietaires"};
		else
			valeurs = new String[] {"", "Les employes des visites", "Les classes standards", "Les clients", "Les proprietaires"};
		comboBox.setModel(new DefaultComboBoxModel(valeurs));
		comboBox.setBounds(127, 74, 157, 31);
		contentPane.add(comboBox);
		
		btnSuivant = new JButton("Suivant");
		btnSuivant.setEnabled(false);
		btnSuivant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String x = String.valueOf(comboBox.getSelectedItem());
				if (x.equals("Les employes du bureau")){
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					EmpB m=new EmpB();
					m.setVisible(true);
				}
				else if (x.equals("Les employes des visites")) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					EmpV m=new EmpV();
					m.setVisible(true);
				}
				else if (x.equals("Les classes standards")) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					Classe m=new Classe();
					m.setVisible(true);
				}
				else if (x.equals("Les clients")) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					Client m=new Client();
					m.setVisible(true);
				}
				else if (x.equals("Les proprietaires")) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					Prop m=new Prop();
					m.setVisible(true);
				}
			}
		});
		btnSuivant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSuivant.setBounds(316, 156, 104, 31);
		contentPane.add(btnSuivant);
	}
}
