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

public class AfficherClient extends JFrame {

	private JPanel contentPane;
	int idClient;
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
	JTextField textNumTel;
	JTextField textAMail;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherClient frame = new AfficherClient();
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
	public AfficherClient() {
		setResizable(false);
		setTitle("Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 541, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNom = new JLabel("Nom:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom.setBounds(22, 95, 108, 21);
		contentPane.add(lblNom);
		
		textNom = new JTextField();
		textNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNom.setColumns(10);
		textNom.setBounds(130, 95, 133, 21);
		contentPane.add(textNom);
		
		lblPrenom = new JLabel("Prenom:");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrenom.setBounds(273, 95, 108, 21);
		contentPane.add(lblPrenom);
		
		textPre = new JTextField();
		textPre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPre.setColumns(10);
		textPre.setBounds(381, 95, 133, 21);
		contentPane.add(textPre);
		
		lblNumTel = new JLabel("Num Rue:");
		lblNumTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel.setBounds(22, 149, 108, 21);
		contentPane.add(lblNumTel);
		
		textNumRue = new JTextField();
		textNumRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumRue.setColumns(10);
		textNumRue.setBounds(130, 149, 133, 21);
		contentPane.add(textNumRue);
		
		lblRue = new JLabel("Rue:");
		lblRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRue.setBounds(273, 149, 108, 21);
		contentPane.add(lblRue);
		
		textRue = new JTextField();
		textRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textRue.setColumns(10);
		textRue.setBounds(381, 149, 133, 21);
		contentPane.add(textRue);
		
		lblCodePostale = new JLabel("Code Postale:");
		lblCodePostale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodePostale.setBounds(22, 207, 108, 21);
		contentPane.add(lblCodePostale);
		
		textCode = new JTextField();
		textCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCode.setColumns(10);
		textCode.setBounds(130, 207, 133, 21);
		contentPane.add(textCode);
		
		lblLocalite = new JLabel("Localite:");
		lblLocalite.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocalite.setBounds(273, 207, 108, 21);
		contentPane.add(lblLocalite);
		
		textLocal = new JTextField();
		textLocal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textLocal.setColumns(10);
		textLocal.setBounds(381, 207, 133, 21);
		contentPane.add(textLocal);
		
		lblNumTel_1 = new JLabel("Num Tel:");
		lblNumTel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel_1.setBounds(22, 262, 108, 21);
		contentPane.add(lblNumTel_1);
		
		textNumTel = new JTextField();
		textNumTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumTel.setColumns(10);
		textNumTel.setBounds(130, 262, 133, 21);
		contentPane.add(textNumTel);
		
		JButton retourButton = new JButton("Retourner");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				Client m=new Client();
				m.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(26, 337, 104, 31);
		contentPane.add(retourButton);
		
		JButton btnMettreJour = new JButton("Mettre \u00E0 jour");
		btnMettreJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mjClient(e);
			}});
		btnMettreJour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMettreJour.setBounds(300, 337, 117, 31);
		contentPane.add(btnMettreJour);
		
		JLabel lblAdresseEmail = new JLabel("Adresse E-mail:");
		lblAdresseEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdresseEmail.setBounds(273, 262, 108, 21);
		contentPane.add(lblAdresseEmail);
		
		textAMail = new JTextField();
		textAMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAMail.setColumns(10);
		textAMail.setBounds(381, 261, 133, 21);
		contentPane.add(textAMail);
	}
	
	private void mjClient(ActionEvent e) {
		try {
			Connection con = MysqlConnection.con();
			String sql="UPDATE client SET Nom= ?, Prenom= ?, NumRue= ?, Rue= ?, CodePostale= ?, Localite= ?, NumTel= ?, email= ? WHERE idClient= ? ;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, textNom.getText());
			pstmt.setString(2, textPre.getText());
			pstmt.setInt(3, Integer.parseInt(textNumRue.getText()));
			pstmt.setString(4, textRue.getText());
			pstmt.setInt(5, Integer.parseInt(textCode.getText()));
			pstmt.setString(6, textLocal.getText());
			pstmt.setInt(7, Integer.parseInt(textNumTel.getText()));
			pstmt.setString(8, textAMail.getText());
			pstmt.setInt(9, idClient);
			pstmt.execute();
			con.close();
			this.setVisible(false);
			EmpV em=new EmpV();
			em.setVisible(true);
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
	}
}
