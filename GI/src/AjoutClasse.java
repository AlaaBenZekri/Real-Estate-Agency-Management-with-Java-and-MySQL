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
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AjoutClasse extends JFrame {
	
	private JPanel contentPane;
	private JTextField textPrix;
	private JTextField textSuper;
	private JButton terminerButton;
	private JButton retourButton;
	private boolean[] correct= {false,false,false,false};
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjoutClasse frame = new AjoutClasse();
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
	public AjoutClasse() {
		setResizable(false);
		setTitle("Classe Standard");
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
				insererClasse(e);
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
				Classe ev=new Classe();
				ev.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(20, 243, 104, 31);
		contentPane.add(retourButton);
		
		JLabel lblNewLabel = new JLabel("Veuillez entrer les crit\u00E8res du classe:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 17, 367, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Type:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(46, 93, 46, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Prix max:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(46, 145, 78, 25);
		contentPane.add(lblNewLabel_2);
		
		textPrix = new JTextField();
		textPrix.setBounds(123, 149, 86, 20);
		contentPane.add(textPrix);
		textPrix.setColumns(10);
		textPrix.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((textPrix.getText() == null) || ((textPrix.getText()).equals(""))  || (!(textPrix.getText()).matches("[+-]?(?:[0-9]*[.])?[0-9]+"))) {
						correct[1]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[1]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((textPrix.getText()+e.getKeyChar() == null) || ((textPrix.getText()+e.getKeyChar()).equals(""))  || (!(textPrix.getText()+e.getKeyChar()).matches("[+-]?(?:[0-9]*[.])?[0-9]+"))) {
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
		JLabel lblNewLabel_4 = new JLabel("Mode d'offre:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(256, 93, 88, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Superficie Min:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(256, 150, 88, 20);
		contentPane.add(lblNewLabel_5);
		
		textSuper = new JTextField();
		textSuper.setBounds(354, 149, 86, 20);
		contentPane.add(textSuper);
		textSuper.setColumns(10);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Maison", "Appartement", "Studio", "Entrepot", "Emplacement", "Terrain"}));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(comboBox.getSelectedItem()).equals("")==false)
					correct[0]=true;
				else
					correct[0]=false;
			}
		});
		comboBox.setBounds(123, 93, 104, 25);
		contentPane.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"", "A vendre", "A louer"}));
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (String.valueOf(comboBox.getSelectedItem()).equals("")==false)
					correct[2]=true;
				else
					correct[2]=false;
			}
		});
		comboBox_1.setBounds(350, 92, 104, 25);
		contentPane.add(comboBox_1);
		
		textSuper.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char key=e.getKeyChar();
				int k=key;


				if(k==KeyEvent.VK_BACK_SPACE){
					if ((textSuper.getText() == null) || ((textSuper.getText()).equals(""))  || (!(textSuper.getText()).matches("[+-]?(?:[0-9]*[.])?[0-9]+"))) {
						correct[3]=false;
						terminerButton.setEnabled(false);
					}
					else{
						correct[3]=true;
						if (verif(correct)==true)
							terminerButton.setEnabled(true);
					}
				}
				else if ((textSuper.getText()+e.getKeyChar() == null) || ((textSuper.getText()+e.getKeyChar()).equals(""))  || (!(textSuper.getText()+e.getKeyChar()).matches("[+-]?(?:[0-9]*[.])?[0-9]+"))) {
					correct[3]=false;
					terminerButton.setEnabled(false);
				}
				else{
					correct[3]=true;
					if (verif(correct)==true)
						terminerButton.setEnabled(true);
				}
			}
		});
		

				
			}
	public boolean verif(boolean[] t) {
		int i;
		for (i=0;i<4;i++) {
			if (correct[i]==false)
				return false;
		}
		return true;
	}
	
	private void insererClasse(ActionEvent e) {
		try {
				Connection con = MysqlConnection.con();
				String sql="INSERT INTO classe(Type,ModeOffre,PrixMax,SuperficieMin) Values(?,?,?,?);";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, String.valueOf(comboBox.getSelectedItem()));
				pstmt.setString(2, String.valueOf(comboBox_1.getSelectedItem()));
				pstmt.setDouble(3, Double.parseDouble(textPrix.getText()));
				pstmt.setDouble(4, Double.parseDouble(textSuper.getText()));
				pstmt.execute();
				this.setVisible(false);
				JOptionPane.showMessageDialog(null,"Insertion avec succes");
				con.close();
				Classe em=new Classe();
				em.setVisible(true);
		}
		catch(Exception e1) {
				System.out.println(e1);
		}
	}
}

