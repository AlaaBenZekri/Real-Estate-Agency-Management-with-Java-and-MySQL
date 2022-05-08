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
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class EmpV extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmpV frame = new EmpV();
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
	public EmpV() {
		setResizable(false);
		setTitle("Les Employ\u00E9s de Visite");
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
				MenuInterne m=new MenuInterne();
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

		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				AjoutEmployeVisite aev = new AjoutEmployeVisite();
				aev.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(489, 325, 111, 30);
		contentPane.add(btnNewButton);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n=table.getSelectedRow();
				if (n!=-1) {
					Connection con = MysqlConnection.con();
					int idEmp=(int) table.getValueAt(n,0);
					String sql = "SELECT COUNT(*) FROM visite WHERE idEmp="+idEmp+";";
					int a=0;
					try {
						PreparedStatement ps = con.prepareStatement(sql);
						ResultSet res=ps.executeQuery(sql);
						res.next();
						a=(res.getInt("COUNT(*)"));
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					if (a<=0) {
						String query = "delete from employevisite where idEmp = ?";
						PreparedStatement preparedStmt;
						try {
							preparedStmt = con.prepareStatement(query);
							preparedStmt.setInt(1, idEmp);
							preparedStmt.execute();
							con.close();
							showData();
						} catch (SQLException e1) {
							e1.printStackTrace();
							
						}
					}
					else {
						JOptionPane.showMessageDialog(null,"Ce employé ne peut pas être supprimé car il est associé à un/des visite(s).");
					}
				}
			}
		});
		btnSupprimer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSupprimer.setBounds(249, 325, 111, 30);
		contentPane.add(btnSupprimer);
		
		JButton btnAfficher = new JButton("Afficher");
		btnAfficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i!=-1) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					AfficherEmpV ev = new AfficherEmpV();
					ev.setVisible(true);
					ev.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					ev.idEmp = (int) table.getValueAt(i, 0);
		            String nom = table.getValueAt(i, 1).toString();
		            String prenom = table.getValueAt(i, 2).toString();
		            String numRue = table.getValueAt(i, 3).toString();
		            String rue = table.getValueAt(i, 4).toString();
		            String codeP = table.getValueAt(i, 5).toString();
		            String local = table.getValueAt(i, 6).toString();
		            String numTel = table.getValueAt(i, 7).toString();
		        	ev.textNom.setText(nom);
		        	ev.textPre.setText(prenom);
		        	ev.textNumRue.setText(numRue.toString());
		        	ev.textRue.setText(rue);
		        	ev.textCode.setText(codeP);
		        	ev.textLocal.setText(local);;
		        	ev.textNumTel.setText(numTel);
				}
			}
		});
		btnAfficher.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAfficher.setBounds(370, 325, 111, 30);
		contentPane.add(btnAfficher);
		showData();
	}
	
	private void showData() {
		Connection con = MysqlConnection.con();
		try {
			String sql = "SELECT * FROM employevisite;";
			PreparedStatement pst= con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));	
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
