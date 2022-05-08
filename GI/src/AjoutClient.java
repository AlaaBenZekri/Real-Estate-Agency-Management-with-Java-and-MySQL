import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AjoutClient extends JFrame {

	private JPanel contentPane;
	int idProp;
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
	private JLabel lblAdresseEmail;
	private JTextField textAMail;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutClient frame = new AjoutClient();
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
	public AjoutClient() {
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
		lblNom.setBounds(22, 73, 108, 21);
		contentPane.add(lblNom);
		
		textNom = new JTextField();
		textNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNom.setColumns(10);
		textNom.setBounds(130, 72, 133, 21);
		contentPane.add(textNom);
		
		lblPrenom = new JLabel("Prenom:");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrenom.setBounds(273, 73, 108, 21);
		contentPane.add(lblPrenom);
		
		textPre = new JTextField();
		textPre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPre.setColumns(10);
		textPre.setBounds(381, 72, 133, 21);
		contentPane.add(textPre);
		
		lblNumTel = new JLabel("Num Rue:");
		lblNumTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel.setBounds(22, 105, 108, 21);
		contentPane.add(lblNumTel);
		
		textNumRue = new JTextField();
		textNumRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumRue.setColumns(10);
		textNumRue.setBounds(130, 104, 133, 21);
		contentPane.add(textNumRue);
		
		lblRue = new JLabel("Rue:");
		lblRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRue.setBounds(273, 105, 108, 21);
		contentPane.add(lblRue);
		
		textRue = new JTextField();
		textRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textRue.setColumns(10);
		textRue.setBounds(381, 104, 133, 21);
		contentPane.add(textRue);
		
		lblCodePostale = new JLabel("Code Postale:");
		lblCodePostale.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodePostale.setBounds(22, 137, 108, 21);
		contentPane.add(lblCodePostale);
		
		textCode = new JTextField();
		textCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textCode.setColumns(10);
		textCode.setBounds(130, 136, 133, 21);
		contentPane.add(textCode);
		
		lblLocalite = new JLabel("Localite:");
		lblLocalite.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocalite.setBounds(273, 137, 108, 21);
		contentPane.add(lblLocalite);
		
		textLocal = new JTextField();
		textLocal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textLocal.setColumns(10);
		textLocal.setBounds(381, 136, 133, 21);
		contentPane.add(textLocal);
		
		lblNumTel_1 = new JLabel("Num Tel:");
		lblNumTel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel_1.setBounds(22, 169, 108, 21);
		contentPane.add(lblNumTel_1);
		
		textNumTel = new JTextField();
		textNumTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textNumTel.setColumns(10);
		textNumTel.setBounds(130, 168, 133, 21);
		contentPane.add(textNumTel);
		
		JButton retourButton = new JButton("Retourner");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				MenuPreClient m=new MenuPreClient();
				m.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(26, 337, 104, 31);
		contentPane.add(retourButton);
		
		JButton btnAjout = new JButton("Confirmer");
		btnAjout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insererClient(e);
			}});
		btnAjout.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAjout.setBounds(300, 337, 117, 31);
		contentPane.add(btnAjout);
		
		lblAdresseEmail = new JLabel("Adresse E-mail:");
		lblAdresseEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAdresseEmail.setBounds(273, 169, 108, 21);
		contentPane.add(lblAdresseEmail);
		
		textAMail = new JTextField();
		textAMail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAMail.setColumns(10);
		textAMail.setBounds(381, 168, 133, 21);
		contentPane.add(textAMail);
	}
	public void insererClient(ActionEvent e) {
		try {
			Connection con = MysqlConnection.con();
			Statement stmnt = con.createStatement();
			String sql="SELECT COUNT(*) FROM client where Nom='"+textNom.getText()+"' and Prenom='"+textPre.getText()+"';";
			ResultSet res=stmnt.executeQuery(sql);
			res.next();
			int n=(res.getInt("COUNT(*)"));
			if (n==0) {
				sql="INSERT INTO client(Nom, Prenom, NumRue, Rue, CodePostale, Localite, NumTel, email) Values(?,?,?,?,?,?,?,?);";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, textNom.getText());
				pstmt.setString(2, textPre.getText());
				pstmt.setInt(3, Integer.parseInt(textNumRue.getText()));
				pstmt.setString(4, textRue.getText());
				pstmt.setInt(5, Integer.parseInt(textCode.getText()));
				pstmt.setString(6, textLocal.getText());
				pstmt.setInt(7, Integer.parseInt(textNumTel.getText()));
				pstmt.setString(8, textAMail.getText());
				pstmt.execute();
				this.setVisible(false);
				JOptionPane.showMessageDialog(null,"Ajout avec succes");
				MenuClient m=new MenuClient();
				m.setVisible(true);
				sql="SELECT idClient FROM client whereNom='"+textNom.getText()+"' and Prenom='"+textPre.getText()+"';";
				res=stmnt.executeQuery(sql);
				res.next();
				m.idClient=(res.getInt("idClient"));
				m.anonyme=false;
				con.close();
			}
			else
				JOptionPane.showMessageDialog(null,"Client deja existant");
			con.close();
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
	}
	
}
