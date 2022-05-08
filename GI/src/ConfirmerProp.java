import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class ConfirmerProp extends JFrame {

	private JPanel contentPane;
	int idProp1;
	private JLabel lblNom;
	JTextField textNom;
	private JLabel lblPrenom;
	JTextField textPre;
	private JLabel lblNumTel;
	JTextField textNumRue;
	private JLabel lblRue;
	JTextField textRue;
	private JLabel lblCodePostale;
	JTextField textCode;
	private JLabel lblLocalite;
	JTextField textLocal;
	private JLabel lblNumTel_1;
	JTextField textNumTelP;
	private JLabel lblNumTel_2;
	JTextField textNumTelT;
	private JLabel lblNumTel_3;
	private JLabel lblNumTel_4;
	JSpinner de1;
	JSpinner de2;
	JSpinner jus1;
	JSpinner jus2;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmerProp frame = new ConfirmerProp();
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
	public ConfirmerProp() {
		setResizable(false);
		setTitle("Propri\u00E9taire");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 541, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom.setBounds(22, 39, 108, 21);
		contentPane.add(lblNom);
		
		textNom = new JTextField();
		textNom.setEditable(false);
		textNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNom.setColumns(10);
		textNom.setBounds(130, 38, 133, 21);
		contentPane.add(textNom);
		
		lblPrenom = new JLabel("Prenom:");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrenom.setBounds(273, 39, 108, 21);
		contentPane.add(lblPrenom);
		
		textPre = new JTextField();
		textPre.setEditable(false);
		textPre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPre.setColumns(10);
		textPre.setBounds(381, 38, 133, 21);
		contentPane.add(textPre);
		
		lblNumTel = new JLabel("Num Rue:");
		lblNumTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel.setBounds(22, 71, 108, 21);
		contentPane.add(lblNumTel);
		
		textNumRue = new JTextField();
		textNumRue.setEditable(false);
		textNumRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumRue.setColumns(10);
		textNumRue.setBounds(130, 71, 133, 21);
		contentPane.add(textNumRue);
		
		lblRue = new JLabel("Rue:");
		lblRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRue.setBounds(273, 71, 108, 21);
		contentPane.add(lblRue);
		
		textRue = new JTextField();
		textRue.setEditable(false);
		textRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textRue.setColumns(10);
		textRue.setBounds(381, 71, 133, 21);
		contentPane.add(textRue);
		
		lblCodePostale = new JLabel("Code Postale:");
		lblCodePostale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodePostale.setBounds(22, 104, 108, 21);
		contentPane.add(lblCodePostale);
		
		textCode = new JTextField();
		textCode.setEditable(false);
		textCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCode.setColumns(10);
		textCode.setBounds(130, 103, 133, 21);
		contentPane.add(textCode);
		
		lblLocalite = new JLabel("Localite:");
		lblLocalite.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocalite.setBounds(273, 104, 108, 21);
		contentPane.add(lblLocalite);
		
		textLocal = new JTextField();
		textLocal.setEditable(false);
		textLocal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textLocal.setColumns(10);
		textLocal.setBounds(381, 103, 133, 21);
		contentPane.add(textLocal);
		
		lblNumTel_1 = new JLabel("Num Tel Prive:");
		lblNumTel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel_1.setBounds(22, 158, 108, 21);
		contentPane.add(lblNumTel_1);
		
		textNumTelP = new JTextField();
		textNumTelP.setEditable(false);
		textNumTelP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumTelP.setColumns(10);
		textNumTelP.setBounds(130, 157, 133, 21);
		contentPane.add(textNumTelP);
		
		JButton retourButton = new JButton("Retourner");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				MenuPreProp m=new MenuPreProp();
				m.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(26, 337, 104, 31);
		contentPane.add(retourButton);
		
		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f = getFrames();
				f[f.length-1].dispose();
				MenuProp mp = new MenuProp();
				mp.setVisible(true);
				mp.idProp=idProp1;
			}});
		btnConfirmer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmer.setBounds(300, 337, 117, 31);
		contentPane.add(btnConfirmer);
		
		lblNumTel_2 = new JLabel("Num Tel Travail:");
		lblNumTel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel_2.setBounds(22, 237, 108, 21);
		contentPane.add(lblNumTel_2);
		
		textNumTelT = new JTextField();
		textNumTelT.setEditable(false);
		textNumTelT.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumTelT.setColumns(10);
		textNumTelT.setBounds(130, 238, 133, 21);
		contentPane.add(textNumTelT);
		
		lblNumTel_3 = new JLabel("De:");
		lblNumTel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel_3.setBounds(309, 158, 75, 21);
		contentPane.add(lblNumTel_3);
		
		lblNumTel_4 = new JLabel("Jusqu'\u00E0:");
		lblNumTel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel_4.setBounds(300, 190, 108, 21);
		contentPane.add(lblNumTel_4);
		
		de1 = new JSpinner();
		de1.setEnabled(false);
		de1.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		de1.setBounds(381, 159, 36, 20);
		contentPane.add(de1);
		
		jus1 = new JSpinner();
		jus1.setEnabled(false);
		jus1.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		jus1.setBounds(381, 191, 36, 20);
		contentPane.add(jus1);
		
		de2 = new JSpinner();
		de2.setEnabled(false);
		de2.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		de2.setBounds(381, 238, 36, 20);
		contentPane.add(de2);
		
		jus2 = new JSpinner();
		jus2.setEnabled(false);
		jus2.setModel(new SpinnerNumberModel(0, 0, 24, 1));
		jus2.setBounds(381, 271, 36, 20);
		contentPane.add(jus2);
		
		JLabel lblNumTel_3_1 = new JLabel("De:");
		lblNumTel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel_3_1.setBounds(309, 237, 108, 21);
		contentPane.add(lblNumTel_3_1);
		
		JLabel lblNumTel_4_1 = new JLabel("Jusqu'\u00E0:");
		lblNumTel_4_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel_4_1.setBounds(300, 269, 108, 21);
		contentPane.add(lblNumTel_4_1);
	}
	
}
