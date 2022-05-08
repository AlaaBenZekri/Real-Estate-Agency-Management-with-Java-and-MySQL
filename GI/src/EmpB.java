import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class EmpB extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpB frame = new EmpB();
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
	public EmpB() {
		setResizable(false);
		setTitle("Les Employ\u00E9s de Bureau");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 684, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton retourButton = new JButton("Retourner");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				MenuInterne m=new MenuInterne();
				m.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(10, 324, 114, 32);
		contentPane.add(retourButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 66, 648, 130);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=table.getSelectedRow();
				if (n!=-1) {
					Connection con = MysqlConnection.con();
					int id=(int) table.getValueAt(n,0);
					String query = "delete from employebureau where idEmp = ?";
				    PreparedStatement preparedStmt;
					try {
						preparedStmt = con.prepareStatement(query);
					    preparedStmt.setInt(1, id);
					    preparedStmt.execute();
					    con.close();
					    showData();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSupprimer.setBounds(305, 325, 111, 30);
		contentPane.add(btnSupprimer);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i!=-1) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					AfficherEmpB eb = new AfficherEmpB();
					eb.setVisible(true);
					eb.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					eb.idEmp = Integer.parseInt(table.getValueAt(i, 0).toString());
					String usr = table.getValueAt(i, 1).toString();
		            String nom = table.getValueAt(i, 2).toString();
		            String prenom = table.getValueAt(i, 3).toString();
		            String numRue = table.getValueAt(i, 4).toString();
		            String rue = table.getValueAt(i, 5).toString();
		            String codeP = table.getValueAt(i, 6).toString();
		            String local = table.getValueAt(i, 7).toString();
		            String numTel = table.getValueAt(i, 8).toString();
		            int adm = Integer.parseInt(table.getValueAt(i, 9).toString());
		            eb.textUsr.setText(usr);
		        	eb.textNom.setText(nom);
		        	eb.textPre.setText(prenom);
		        	eb.textNumRue.setText(numRue.toString());
		        	eb.textRue.setText(rue);
		        	eb.textCode.setText(codeP);
		        	eb.textLocal.setText(local);;
		        	eb.textNumTel.setText(numTel);
		        	if (adm==1)
		        		eb.checkAdmin.setSelected(true);
		        	else
		        		eb.checkAdmin.setSelected(false);
				}
			}
		});
		btnAfficher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAfficher.setBounds(547, 324, 111, 30);
		contentPane.add(btnAfficher);
		showData();
	}
	
	private void showData() {
		Connection con = MysqlConnection.con();
		try {
			String sql = "SELECT idEmp, Adresse,  Nom, Prenom, NumRue, Rue, CodePostale, Localite, NumTel, Admin FROM employebureau;";
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));	
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
