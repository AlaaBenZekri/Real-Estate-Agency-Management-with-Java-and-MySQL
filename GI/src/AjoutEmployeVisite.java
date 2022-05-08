import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AjoutEmployeVisite extends JFrame {
	
	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTextField numTel;
	private JTextField numRue;
	private JTextField rue;
	private JTextField local;
	private JTextField codeP;
	private JTextField user;
	private JPasswordField pass;
	private JButton terminerButton;
	private JButton retourButton;
	private boolean[] correct= {false,false,false,false,false,false,false};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutEmployeVisite frame = new AjoutEmployeVisite();
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
	public AjoutEmployeVisite() {
		setResizable(false);
		setTitle("Employ\u00E9 de Visite");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 541, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		terminerButton = new JButton("Terminer");
		terminerButton.setEnabled(false);
		terminerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insererCompte(e);
			}
		});
		terminerButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		terminerButton.setBounds(198, 243, 104, 31);
		contentPane.add(terminerButton);
		
		retourButton = new JButton("Retourner");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				EmpV ev=new EmpV();
				ev.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(20, 243, 104, 31);
		contentPane.add(retourButton);
		
		JLabel lblNewLabel = new JLabel("Veuillez entrer les donn\u00E9es de l'employ\u00E9:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 17, 367, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nom:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(46, 80, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		nom = new JTextField();
		nom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((nom.getText() == null) || ((nom.getText()).equals(""))  || (!(nom.getText()).matches("^[a-zA-Z\s]*"))) {
						correct[0]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[0]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((nom.getText()+e.getKeyChar() == null) || ((nom.getText()+e.getKeyChar()).equals(""))  || (!(nom.getText()+e.getKeyChar()).matches("^[a-zA-Z\s]*"))) {
					correct[0]=false;
					terminerButton.setEnabled(false);
				}
				else{
					correct[0]=true;
					if (verif(correct)==true)
						terminerButton.setEnabled(true);
				}
			}
		});
		nom.setBounds(123, 77, 86, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Prenom:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(46, 111, 67, 14);
		contentPane.add(lblNewLabel_2);
		
		prenom = new JTextField();
		prenom.setBounds(123, 108, 86, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		prenom.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((prenom.getText() == null) || ((prenom.getText()).equals(""))  || (!(prenom.getText()).matches("^[a-zA-Z\s]*"))) {
						correct[1]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[1]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((prenom.getText()+e.getKeyChar() == null) || ((prenom.getText()+e.getKeyChar()).equals(""))  || (!(prenom.getText()+e.getKeyChar()).matches("^[a-zA-Z\s]*"))) {
					correct[1]=false;
					terminerButton.setEnabled(false);
				}
				else{
					correct[1]=true;
					if (verif(correct)==true)
						terminerButton.setEnabled(true);
				}
			}
		});
		
		JLabel lblNewLabel_3 = new JLabel("N\u00B0 Tel:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(46, 142, 52, 14);
		contentPane.add(lblNewLabel_3);
		
		numTel = new JTextField();
		numTel.setBounds(123, 139, 86, 20);
		contentPane.add(numTel);
		numTel.setColumns(10);
		numTel.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((numTel.getText() == null) || ((numTel.getText()).equals(""))  || (!(numTel.getText()).matches("^[0-9]*"))) {
						correct[2]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[2]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((numTel.getText()+e.getKeyChar() == null) || ((numTel.getText()+e.getKeyChar()).equals(""))  || (!(numTel.getText()+e.getKeyChar()).matches("^[0-9]*"))) {
					correct[2]=false;
					terminerButton.setEnabled(false);
				}
				else{
					correct[2]=true;
					if (verif(correct)==true)
						terminerButton.setEnabled(true);
				}
			}
		});
		JLabel lblNewLabel_4 = new JLabel("N\u00B0 de rue:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(256, 80, 68, 14);
		contentPane.add(lblNewLabel_4);
		
		numRue = new JTextField();
		numRue.setBounds(358, 79, 86, 20);
		contentPane.add(numRue);
		numRue.setColumns(10);
		numRue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((numRue.getText() == null) || ((numRue.getText()).equals(""))  || (!(numRue.getText()).matches("^[0-9]*"))) {
						correct[3]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[3]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((numRue.getText()+e.getKeyChar() == null) || ((numRue.getText()+e.getKeyChar()).equals(""))  || (!(numRue.getText()+e.getKeyChar()).matches("^[0-9]*"))) {
					correct[3]=false;
					terminerButton.setEnabled(verif(correct));
				}
				else {
					correct[3]=true;
					if (verif(correct))
						terminerButton.setEnabled(verif(correct));
				}
			}
		});
		
		JLabel lblNewLabel_5 = new JLabel("Rue:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(256, 111, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		rue = new JTextField();
		rue.setBounds(358, 110, 86, 20);
		contentPane.add(rue);
		rue.setColumns(10);
		rue.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((rue.getText() == null) || ((rue.getText()).equals(""))  || (!(rue.getText()).matches("^[a-zA-Z\s]*"))) {
						correct[4]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[4]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((rue.getText()+e.getKeyChar() == null) || ((rue.getText()+e.getKeyChar()).equals(""))  || (!(rue.getText()+e.getKeyChar()).matches("^[a-zA-Z\s]*"))) {
					correct[4]=false;
					terminerButton.setEnabled(false);
				}
				else{
					correct[4]=true;
					if (verif(correct)==true)
						terminerButton.setEnabled(true);
				}
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("Localit\u00E9:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(256, 142, 68, 14);
		contentPane.add(lblNewLabel_6);
		
		local = new JTextField();
		local.setBounds(358, 141, 86, 20);
		contentPane.add(local);
		local.setColumns(10);
		local.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((local.getText() == null) || ((local.getText()).equals(""))  || (!(local.getText()).matches("^[a-zA-Z0-9\s]*"))) {
						correct[5]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[5]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((local.getText()+e.getKeyChar() == null) || ((local.getText()+e.getKeyChar()).equals(""))  || (!(local.getText()+e.getKeyChar()).matches("^[a-zA-Z0-9\s]*"))) {
					correct[5]=false;
					terminerButton.setEnabled(false);
				}
				else{
					correct[5]=true;
					if (verif(correct)==true)
						terminerButton.setEnabled(true);
				}
			}});
		
		JLabel lblNewLabel_7 = new JLabel("Code postale:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(256, 174, 92, 14);
		contentPane.add(lblNewLabel_7);
		
		codeP = new JTextField();
		codeP.setBounds(358, 170, 86, 20);
		contentPane.add(codeP);
		codeP.setColumns(10);
		codeP.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((codeP.getText() == null) || ((codeP.getText()).equals(""))  || (!(codeP.getText()).matches("^[0-9]*"))) {
						correct[6]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[6]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((codeP.getText()+e.getKeyChar() == null) || ((codeP.getText()+e.getKeyChar()).equals(""))  || (!(codeP.getText()+e.getKeyChar()).matches("^[0-9]*"))) {
					correct[6]=false;
					terminerButton.setEnabled(false);
				}
				else{
					correct[6]=true;
					if (verif(correct)==true)
						terminerButton.setEnabled(true);
				}
				
			}
		});
		

				
			}
	public boolean verif(boolean[] t) {
		int i;
		for (i=0;i<7;i++) {
			if (correct[i]==false)
				return false;
		}
		return true;
	}
	
	private void insererCompte(ActionEvent e) {
		try {
				Connection con = MysqlConnection.con();
				String sql="INSERT INTO employevisite(Nom,Prenom,NumRue,Rue,CodePostale,Localite,NumTel) Values(?,?,?,?,?,?,?);";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, nom.getText());
				pstmt.setString(2, prenom.getText());
				pstmt.setInt(3, Integer.parseInt(numRue.getText()));
				pstmt.setString(4, rue.getText());
				pstmt.setInt(5, Integer.parseInt(codeP.getText()));
				pstmt.setString(6, local.getText());
				pstmt.setInt(7, Integer.parseInt(numTel.getText()));
				pstmt.execute();
				this.setVisible(false);
				JOptionPane.showMessageDialog(null,"Insertion avec succes");
				con.close();
				EmpV em=new EmpV();
				em.setVisible(true);
		}
		catch(Exception e1) {
				System.out.println(e1);
		}
	}
}

