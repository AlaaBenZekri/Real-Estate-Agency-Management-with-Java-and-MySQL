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

public class MenuPreProp extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPreProp frame = new MenuPreProp();
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
	public MenuPreProp() {
		setResizable(false);
		setTitle("Les Propri\u00E9taires");
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
				AjoutProp m=new AjoutProp();
				m.setVisible(true);
			}
		});
		btnAjouter.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAjouter.setBounds(329, 325, 111, 30);
		contentPane.add(btnAjouter);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i!=-1) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					ConfirmerProp p = new ConfirmerProp();
					p.setVisible(true);
					p.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					p.idProp1 = (int) table.getValueAt(i, 0);
		            String nom = table.getValueAt(i, 1).toString();
		            String prenom = table.getValueAt(i, 2).toString();
		            String numRue = table.getValueAt(i, 3).toString();
		            String rue = table.getValueAt(i, 4).toString();
		            String codeP = table.getValueAt(i, 5).toString();
		            String local = table.getValueAt(i, 6).toString();
		            String numTelP = table.getValueAt(i, 7).toString();
		            String de1 = table.getValueAt(i,8).toString();
		            String jus1 = table.getValueAt(i,9).toString();
		            String numTelT = table.getValueAt(i, 10).toString();
		            String de2 = table.getValueAt(i,11).toString();
		            String jus2 = table.getValueAt(i,12).toString();
		        	p.textNom.setText(nom);
		        	p.textPre.setText(prenom);
		        	p.textNumRue.setText(numRue.toString());
		        	p.textRue.setText(rue);
		        	p.textCode.setText(codeP);
		        	p.textLocal.setText(local);
		        	p.textNumTelP.setText(numTelP);
		        	p.de1.setValue(Integer.parseInt(de1));
		        	p.jus1.setValue(Integer.parseInt(jus1));
		        	p.textNumTelT.setText(numTelT);
		        	p.de2.setValue(Integer.parseInt(de2));
		        	p.jus2.setValue(Integer.parseInt(jus2));
				}
			}
		});
		btnAfficher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAfficher.setBounds(466, 325, 111, 30);
		contentPane.add(btnAfficher);
		showData();
	}
	
	private void showData() {
		Connection con = MysqlConnection.con();
		try {
			String sql = "SELECT * FROM proprietaire;";
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));	
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
