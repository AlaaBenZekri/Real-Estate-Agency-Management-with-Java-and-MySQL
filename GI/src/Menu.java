import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Dialog.ModalExclusionType;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JButton confirmButton;
	private JRadioButton propButton;
	private JRadioButton cliButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton retourButton;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setResizable(false);
		setTitle("Bienvenue");
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 541, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton internButton = new JRadioButton("    Espace Interne");
		internButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButton.setEnabled(true);
			}
		});
		internButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		internButton.setBounds(85, 100, 226, 23);
		contentPane.add(internButton);
		
		propButton = new JRadioButton("    Espace Proprietaire");
		propButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		propButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButton.setEnabled(true);
			}
		});
		propButton.setBounds(85, 160, 226, 23);
		contentPane.add(propButton);
		
		cliButton = new JRadioButton("    Espace Client");
		cliButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		cliButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmButton.setEnabled(true);
			}
		});
		cliButton.setBounds(85, 220, 188, 23);
		contentPane.add(cliButton);
		
		ButtonGroup group = new ButtonGroup();
		group.add(internButton);
		group.add(propButton);
		group.add(cliButton);

		confirmButton = new JButton("Confirmer");
		confirmButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cliButton.isSelected())
				{
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					MenuPrePreClient mpc=new MenuPrePreClient();
					mpc.setVisible(true);
				}
				else if (propButton.isSelected())
				{
					Frame[] f = getFrames();
					f[f.length-1].dispose();
					MenuPreProp mp = new MenuPreProp();
					mp.setVisible(true);
				}
				else
				{
					Frame[] f = getFrames();
					f[f.length-1].dispose();
					MenuInterne mn = new MenuInterne();
					mn.setVisible(true);
				}
			}
		});
		confirmButton.setEnabled(false);
		confirmButton.setBounds(222, 307, 104, 31);
		contentPane.add(confirmButton);
		
		lblNewLabel = new JLabel("Bienvenue \u00E0 l'application ImmoTunisie:");
		lblNewLabel.setForeground(new Color(51, 102, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(33, 24, 375, 29);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Choisissez l'espace que vous voudrez acc\u00E9der:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(43, 64, 334, 23);
		contentPane.add(lblNewLabel_1);
		
		retourButton = new JButton("Retourner");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				Home hm=new Home();
				hm.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(28, 307, 104, 31);
		contentPane.add(retourButton);
		

	}
	}

