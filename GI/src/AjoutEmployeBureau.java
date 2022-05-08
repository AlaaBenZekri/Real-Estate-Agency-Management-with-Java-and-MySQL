import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mailing.utilities.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
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
import java.util.Random;


public class AjoutEmployeBureau extends JFrame {
	
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
	private boolean[] correct= {false,false,false,false,false,false,false,false,false};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutEmployeBureau frame = new AjoutEmployeBureau();
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
	public AjoutEmployeBureau() {
		setResizable(false);
		setTitle("Employ\u00E9 de Bureau");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 541, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		terminerButton = new JButton("Terminer");
		terminerButton.setEnabled(false);
		terminerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					insererCompte(e);
				} catch (AddressException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (MessagingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		terminerButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		terminerButton.setBounds(198, 313, 104, 31);
		contentPane.add(terminerButton);
		
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
		retourButton.setBounds(21, 313, 104, 31);
		contentPane.add(retourButton);
		
		JLabel lblNewLabel = new JLabel("Veuillez entrer vos donn\u00E9es personnelles:");
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
		
		JLabel lblNewLabel_8 = new JLabel("Veuillez entrer les donn\u00E9es du compte:");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_8.setBounds(10, 199, 314, 22);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_1_1 = new JLabel("Adresse Email:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(46, 238, 117, 14);
		contentPane.add(lblNewLabel_1_1);
		
		user = new JTextField();
		user.setBounds(198, 237, 126, 20);
		contentPane.add(user);
		user.setColumns(10);
		user.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((user.getText() == null) || ((user.getText()).equals(""))) {
						correct[7]=false;
						terminerButton.setEnabled(false);
					}
					else if (user.getText().matches("^[\\w.+\\-]+@gmail\\.com$")){
						correct[7]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((user.getText()+e.getKeyChar() == null) || ((user.getText()+e.getKeyChar()).equals(""))) {
					correct[7]=false;
					terminerButton.setEnabled(false);
				}
				else if ((user.getText()+e.getKeyChar()).matches("^[\\w.+\\-]+@gmail\\.com$")){
					correct[7]=true;
					if (verif(correct)==true)
						terminerButton.setEnabled(true);
				}
			}
		});
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mot de passe:");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(46, 271, 117, 14);
		contentPane.add(lblNewLabel_1_1_1);
		
		pass = new JPasswordField();
		pass.setBounds(198, 270, 126, 20);
		contentPane.add(pass);
		pass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((pass.getText() == null) || ((pass.getText()).equals(""))) {
						correct[8]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[8]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((pass.getText()+e.getKeyChar() == null) || ((pass.getText()+e.getKeyChar()).equals(""))) {
					correct[8]=false;
					terminerButton.setEnabled(false);
				}
				else{
					correct[8]=true;
					if (verif(correct)==true)
						terminerButton.setEnabled(true);
				}
			}
		});

		
			}
	public boolean verif(boolean[] t) {
		int i;
		for (i=0;i<9;i++) {
			if (correct[i]==false)
				return false;
		}
		return true;
	}
	
	public void insererCompte(ActionEvent e) throws AddressException, MessagingException{
		try {
			Connection con = MysqlConnection.con();
			Statement stmnt = con.createStatement();
			String sql="SELECT COUNT(*) FROM employebureau where Adresse='"+user.getText()+"';";
			ResultSet res=stmnt.executeQuery(sql);
			res.next();
			int n=(res.getInt("COUNT(*)"));
			if (n==0) {
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
					System.out.println("ok");
					sql="INSERT INTO employebureau(Adresse,MotDePasse,Nom,Prenom,NumRue,Rue,CodePostale,Localite,NumTel) Values(?,?,?,?,?,?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, user.getText());
					pstmt.setString(2, pass.getText());
					pstmt.setString(3, nom.getText());
					pstmt.setString(4, prenom.getText());
					pstmt.setInt(5, Integer.parseInt(numRue.getText()));
					pstmt.setString(6, rue.getText());
					pstmt.setInt(7, Integer.parseInt(codeP.getText()));
					pstmt.setString(8, local.getText());
					pstmt.setInt(9, Integer.parseInt(numTel.getText()));
					pstmt.execute();
					this.setVisible(false);
					JOptionPane.showMessageDialog(null,"Connexion avec succes");
					Menu menu=new Menu();
					menu.setVisible(true);
				}
				else {
					JOptionPane.showInputDialog("Code incorrect");
				}
			}
			else
				JOptionPane.showMessageDialog(null,"Nom d'utilisateur deja utilise");
			con.close();
		}
		catch(Exception e1) {
			System.out.println(e1);
		}
	}
}

