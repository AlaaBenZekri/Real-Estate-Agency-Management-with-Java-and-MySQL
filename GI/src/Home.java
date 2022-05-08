import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.*;
import java.util.Random;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;

import com.mindfusion.scheduling.ThemeType;

import mailing.utilities.Mail1;

import java.awt.Color;
public class Home {

	private JFrame frmConnexionLapplication;
	JTextField user;
	private JLabel lblNewLabel_1;
	private JButton cnctButton;
	private JButton creerButton;
	private JPasswordField pass;
	JLabel nonSaisi;
	private boolean[] correct= {false,false};
	static boolean admin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmConnexionLapplication.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void setVisible(boolean b) {
		this.frmConnexionLapplication.setVisible(b);
	}
	private void initialize() {
		frmConnexionLapplication = new JFrame();
		frmConnexionLapplication.setResizable(false);
		frmConnexionLapplication.setTitle("Connexion \u00E0 l'Application");
		frmConnexionLapplication.setBounds(485, 150, 405, 434);
		frmConnexionLapplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConnexionLapplication.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Addresse e-mail:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(30, 126, 137, 36);
		frmConnexionLapplication.getContentPane().add(lblNewLabel);
		
		user = new JTextField();
		user.setHorizontalAlignment(SwingConstants.CENTER);
		user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((user.getText() == null) || ((user.getText()).equals(""))) {
						correct[0]=false;
						cnctButton.setEnabled(false);
					}
					else if (user.getText().matches("^[\\w.+\\-]+@gmail\\.com$")){
						correct[0]=true;
						if (correct[1]==true)
							cnctButton.setEnabled(true);
					}
				}
				else if ((user.getText()+e.getKeyChar() == null) || ((user.getText()+e.getKeyChar()).equals(""))) {
					correct[0]=false;
					cnctButton.setEnabled(false);
				}
				else if ((user.getText()+e.getKeyChar()).matches("^[\\w.+\\-]+@gmail\\.com$")){
					correct[0]=true;
					if (correct[1]==true)
						cnctButton.setEnabled(true);
				}
			}			
		});
		user.setBounds(164, 132, 175, 26);
		frmConnexionLapplication.getContentPane().add(user);
		user.setColumns(10);
		
		lblNewLabel_1 = new JLabel("Mot de passe:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(31, 180, 118, 26);
		frmConnexionLapplication.getContentPane().add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setHorizontalAlignment(SwingConstants.CENTER);
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((pass.getText() == null) || ((pass.getText()).equals(""))) {
						correct[1]=false;
						cnctButton.setEnabled(false);
					}
					else{
						correct[1]=true;
						if (correct[0]==true)
							cnctButton.setEnabled(true);
					}
				}
				else if ((pass.getText()+e.getKeyChar() == null) || ((pass.getText()+e.getKeyChar()).equals(""))) {
					correct[1]=false;
					cnctButton.setEnabled(false);
				}
				else{
					correct[1]=true;
					if (correct[0]==true)
						cnctButton.setEnabled(true);
				}
			}
		});
		pass.setBounds(164, 181, 175, 26);
		frmConnexionLapplication.getContentPane().add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("Veuillez entrer vos coordonn\u00E9es:");
		lblNewLabel_2.setForeground(new Color(51, 102, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(40, 66, 299, 26);
		frmConnexionLapplication.getContentPane().add(lblNewLabel_2);
		
		cnctButton = new JButton("Se connecter");
		cnctButton.setEnabled(false);
		cnctButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cnctButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connecterButtonPerformed(e);
			}
		});
		cnctButton.setBounds(211, 277, 128, 36);
		frmConnexionLapplication.getContentPane().add(cnctButton);
		
		creerButton = new JButton("Creer un compte");
		creerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmConnexionLapplication.dispose();
				AjoutEmployeBureau emp=new AjoutEmployeBureau();
				emp.setVisible(true);
			}
			
		});
		creerButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		creerButton.setBounds(47, 277, 137, 36);
		frmConnexionLapplication.getContentPane().add(creerButton);
		
		JButton btnNewButton = new JButton("Mot de passe oubliée?");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modifierMdp(e);
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBounds(103, 218, 175, 26);
		frmConnexionLapplication.getContentPane().add(btnNewButton);
		
		nonSaisi = new JLabel("Veuillez saisier le(s) donn\u00E9e(s) correctement");
		nonSaisi.setVisible(false);
		nonSaisi.setForeground(Color.RED);
		nonSaisi.setBounds(120, 249, 154, 16);
		frmConnexionLapplication.getContentPane().add(nonSaisi);
		
		
	}
	
	Connection con = null;
	
	public void connecterButtonPerformed(ActionEvent e) {
		try {
			con = MysqlConnection.con();
			Statement stmnt = con.createStatement();
			String sql="SELECT Adresse, MotDePasse, Admin FROM employebureau where Adresse='"+user.getText()+"' and MotDePasse='"+pass.getText().toString()+"';";
			ResultSet res=stmnt.executeQuery(sql);
			if (res.next()) {
				admin=res.getBoolean("Admin");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			else
				nonSaisi.setVisible(true);
			con.close();
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
	}
	
	public void modifierMdp(ActionEvent e) {
		if (correct[0]==false) {
			nonSaisi.setVisible(true);
		}
		else {
			try {
				Connection con = MysqlConnection.con();
				Statement stmnt = con.createStatement();
				String sql="SELECT COUNT(*) FROM employebureau where Adresse='"+user.getText()+"';";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n>0) {
					Random rn = new Random();
					int x = rn.nextInt(10000);
					Mail1 m = new Mail1();
					//m.mailThis(user.getText(),"Bienvenue à l'applicatoin ImmoTunisie, ceci est votre code: "+x+"\nSi vous pensez que ce mail n'est pas dirigé à vous merci de l'ignorer.");
					m.mailThis(user.getText(), "<!DOCTYPE html>\r\n"
							+ "<html lang=\"en\">\r\n"
							+ "<head>\r\n"
							+ "    <meta charset=\"UTF-8\">\r\n"
							+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
							+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
							+ "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n"
							+ "<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;700;900&display=swap\" rel=\"stylesheet\">\r\n"
							+ "    <title>Bienvenue à ImmoTunisie</title>\r\n"
							+ "</head>\r\n"
							+ "<style>\r\n"
							+ "    html{\r\n"
							+ "        font-family: 'Roboto', sans-serif;\r\n"
							+ "    }\r\n"
							+ "    \r\n"
							+ "    #main{\r\n"
							+ "        border-radius: 10px;\r\n"
							+ "        background-color: white;\r\n"
							+ "        padding: 15px 25px;\r\n"
							+ "    }\r\n"
							+ "    h1{\r\n"
							+ "        color: #3366ff;\r\n"
							+ "        font-weight: 900;\r\n"
							+ "        font-size: xx-large;\r\n"
							+ "    }\r\n"
							+ "    p{\r\n"
							+ "      line-height: 2rem;\r\n"
							+ "      font-size: large;  \r\n"
							+ "    }\r\n"
							+ "    #code{\r\n"
							+ "        color: #3366ff;\r\n"
							+ "        font-weight: 600;\r\n"
							+ "    }\r\n"
							+ "</style>\r\n"
							+ "<body>\r\n"
							+ "    \r\n"
							+ "        <div id=\"main\">\r\n"
							+ "            <h1>Bienvenue à l'application ImmoTunisie,</h1>\r\n"
							+ "            <p>Ceci est votre code : <span id=\"code\">"+x+"</span>. <br> Si vous pensez que ce mail n'est pas dirigé à vous merci de l'ignorer.</p>\r\n"
							+ "        </div>\r\n"
							+ "    \r\n"
							+ "    </div>\r\n"
							+ "    \r\n"
							+ "</body>\r\n"
							+ "</html>");
					int y=Integer.parseInt(JOptionPane.showInputDialog("Veuillez entrer le code envoyé par mail"));
					if (y==x) {
						String nouveauMdp = JOptionPane.showInputDialog("Veuillez entrer le nouveau mot de passe");
						sql = "UPDATE employebureau SET MotDePasse = ? WHERE Adresse = ?;";
						PreparedStatement pstmt = con.prepareStatement(sql);
						pstmt.setString(1, nouveauMdp);
						pstmt.setString(2, user.getText());
						pstmt.execute();
						this.setVisible(false);
						JOptionPane.showMessageDialog(null,"Modification avec succes");
						Menu menu=new Menu();
						menu.setVisible(true);
					}
					else {
						JOptionPane.showInputDialog("Code incorrect");
					}
				}
				else
					nonSaisi.setVisible(true);
				con.close();
			}
			catch(Exception e1) {
				System.out.println(e1);
			}
		}
	}
}
