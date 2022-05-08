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

public class Recherche extends JFrame {

	private JPanel contentPane;
	JTable table;
	boolean anonyme1;
	int idClient1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recherche frame = new Recherche();
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
	public Recherche() {
		setResizable(false);
		setTitle("Choix de Bien");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 795, 526);
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
		retourButton.setBounds(10, 444, 114, 32);
		contentPane.add(retourButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 759, 412);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);

		JButton btnConfirmer = new JButton("Confirmer");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i!=-1) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					if (anonyme1) {
						AjoutClient1 a = new AjoutClient1();
						a.setVisible(true);
						a.idBien1=Integer.parseInt(table.getValueAt(i, 0).toString());
					}
					else {
						CreerVisite v = new CreerVisite();
						v.idBien=Integer.parseInt(table.getValueAt(i, 0).toString());
						v.idClient=idClient1;
						anonyme1=false;
						v.setVisible(true);
					}
				}
			}
		});
		btnConfirmer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmer.setBounds(658, 445, 111, 30);
		contentPane.add(btnConfirmer);
		
		
		
		
	}
	


}
