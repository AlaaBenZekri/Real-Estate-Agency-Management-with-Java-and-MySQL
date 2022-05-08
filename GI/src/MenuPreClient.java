import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MenuPreClient extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPreClient frame = new MenuPreClient();
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
	public MenuPreClient() {
		setResizable(false);
		setTitle("Les Clients ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 626, 406);
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
		retourButton.setBounds(10, 324, 114, 32);
		contentPane.add(retourButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 66, 557, 130);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				AjoutClient m=new AjoutClient();
				m.setVisible(true);
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAjouter.setBounds(246, 325, 111, 30);
		contentPane.add(btnAjouter);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i!=-1) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					AfficherClient1 c = new AfficherClient1();
					c.setVisible(true);
					c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					c.idClient1 = (int) table.getValueAt(i, 0);
		            String nom = table.getValueAt(i, 1).toString();
		            String prenom = table.getValueAt(i, 2).toString();
		            String numRue = table.getValueAt(i, 3).toString();
		            String rue = table.getValueAt(i, 4).toString();
		            String codeP = table.getValueAt(i, 5).toString();
		            String local = table.getValueAt(i, 6).toString();
		            String numTel = table.getValueAt(i, 7).toString();
		            String mail = table.getValueAt(i, 8).toString();
		        	c.textNom.setText(nom);
		        	c.textPre.setText(prenom);
		        	c.textNumRue.setText(numRue.toString());
		        	c.textRue.setText(rue);
		        	c.textCode.setText(codeP);
		        	c.textLocal.setText(local);
		        	c.textNumTel.setText(numTel);
		        	c.textAMail.setText(mail);
				}
			}
		});
		btnAfficher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAfficher.setBounds(367, 325, 111, 30);
		contentPane.add(btnAfficher);
		
		JButton btnPasser = new JButton("Passer");
		btnPasser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f = getFrames();
				f[f.length-1].dispose();
				MenuClient mc = new MenuClient();
				mc.setVisible(true);
				mc.anonyme=true;
			}
		});
		btnPasser.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPasser.setBounds(489, 324, 111, 30);
		contentPane.add(btnPasser);
		showData();
	}
	
	private void showData() {
		Connection con = MysqlConnection.con();
		try {
			String sql = "SELECT * FROM client;";
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));	
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
