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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class AfficherClasse extends JFrame {

	private JPanel contentPane;
	int code;
	private JLabel lblNom;
	private JLabel lblPrenom;
	private JLabel lblNumTel;
	JTextField textPrix;
	private JLabel lblRue;
	JTextField textSuper;
	JComboBox comboBox;
	JComboBox comboBox_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfficherClasse frame = new AfficherClasse();
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
	public AfficherClasse() {
		setResizable(false);
		setTitle("Classe");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 541, 343);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNom = new JLabel("Type:");
		lblNom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNom.setBounds(22, 95, 108, 21);
		contentPane.add(lblNom);
		
		lblPrenom = new JLabel("Mode d'offre:");
		lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrenom.setBounds(273, 95, 108, 21);
		contentPane.add(lblPrenom);
		
		lblNumTel = new JLabel("Prix Max:");
		lblNumTel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumTel.setBounds(22, 149, 108, 21);
		contentPane.add(lblNumTel);
		
		textPrix = new JTextField();
		textPrix.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPrix.setColumns(10);
		textPrix.setBounds(130, 149, 133, 21);
		contentPane.add(textPrix);
		
		lblRue = new JLabel("Superficie Min:");
		lblRue.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRue.setBounds(273, 149, 108, 21);
		contentPane.add(lblRue);
		
		textSuper = new JTextField();
		textSuper.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textSuper.setColumns(10);
		textSuper.setBounds(381, 149, 133, 21);
		contentPane.add(textSuper);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Maison", "Appartement", "Studio", "Entrepot", "Emplacement", "Terrain"}));
		comboBox.setBounds(123, 93, 104, 25);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "A vendre", "A louer"}));
		comboBox_1.setBounds(350, 92, 104, 25);
		contentPane.add(comboBox_1);

		
		JButton retourButton = new JButton("Retourner");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				Classe m=new Classe();
				m.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(22, 232, 104, 31);
		contentPane.add(retourButton);
		
		JButton btnMettreJour = new JButton("Mettre \u00E0 jour");
		btnMettreJour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mjClasse(e);
			}});
		btnMettreJour.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnMettreJour.setBounds(297, 232, 117, 31);
		contentPane.add(btnMettreJour);
	}
	
	private void mjClasse(ActionEvent e) {
		try {
			Connection con = MysqlConnection.con();
			String sql="UPDATE classe SET Type= ?, ModeOffre= ?, PrixMax= ?, SuperficieMin= ? WHERE Code= ? ;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  String.valueOf(comboBox.getSelectedItem()));
			pstmt.setString(2,  String.valueOf(comboBox_1.getSelectedItem()));
			pstmt.setDouble(3, Double.parseDouble(textPrix.getText()));
			pstmt.setDouble(4, Double.parseDouble(textSuper.getText()));
			pstmt.setInt(5, code);
			pstmt.execute();
			con.close();
			this.setVisible(false);
			Classe em=new Classe();
			em.setVisible(true);
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
	}
}
