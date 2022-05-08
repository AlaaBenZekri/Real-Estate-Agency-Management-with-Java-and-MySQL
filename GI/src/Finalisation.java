import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mailing.utilities.Mail1;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class Finalisation extends JFrame {
	String num, Statut;

	private JPanel contentPane;
	private JTextField nom;
	private JTextField prenom;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Finalisation frame = new Finalisation();
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
	public Finalisation() {
		setResizable(false);
		
	
		setTitle("Finalisation d'un Contrat");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 589, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nom:");
		lblNewLabel.setBounds(20, 24, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom:");
		lblNewLabel_1.setBounds(189, 24, 65, 14);
		contentPane.add(lblNewLabel_1);
		
		nom = new JTextField();
		nom.setBounds(54, 21, 86, 20);
		contentPane.add(nom);
		nom.setColumns(10);
		
		prenom = new JTextField();
		prenom.setBounds(245, 21, 86, 20);
		contentPane.add(prenom);
		prenom.setColumns(10);
		
		JButton btnNewButton = new JButton("Chercher les biens Visit\u00E9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechercherFin(e);
				} catch (SQLException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(365, 20, 189, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 71, 499, 235);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnConfirmer = new JButton("Confirmer l'aquisition");
		btnConfirmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				if (i!=-1) {
					num=table.getValueAt(i, 0).toString();
					Statut=(String) table.getValueAt(i, 1);
					
					try {
						Conf(e);
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(null,"Contrat enregistré avec succes");

					/// SEND MAIL
					
				}
			}
		});
		btnConfirmer.setBounds(383, 317, 171, 29);
		contentPane.add(btnConfirmer);
		
		JButton retourButton = new JButton("Retourner");
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				Client m=new Client();
				m.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Dialog", Font.BOLD, 12));
		retourButton.setBounds(10, 317, 97, 29);
		contentPane.add(retourButton);
	}
		private void Conf(ActionEvent e) throws SQLException {
			String sql="";
		
			Connection con = MysqlConnection.con();
			Statement stmnt = con.createStatement();
			if(Statut=="A Louer"){
				 sql="Update bien "
						+ "Set Status="+"'Loue'"
						+" where Bien.num ='" + num +"';";
			}
			else{
				 sql="Update bien "
						+ "Set Status="+"'Vendu'"
						+" where Bien.num ='" + num +"';";
			}
			//con.close();
			//con=MysqlConnection.con();
			Statement stmnt1 = con.createStatement();
			Statement stmnt2 = con.createStatement();
			String sql1="Select bien.num, idclient, MontantCautionLocative+LoyerMensuel+ChargeMensuel as prix1 "
		    		+ "from visite,bien "
		    		+ "where bien.num='"+num+"' and visite.num='"+num+"';";
			String sql2="Select bien.num, idclient,Prixdemande as prix2 "
		    		+ "from visite,bien "
		    		+ "where bien.num= '"+num+"' and visite.num='"+num+"';";
			ResultSet rs1 = stmnt1.executeQuery(sql1);
			ResultSet rs2 = stmnt2.executeQuery(sql2);
			rs1.next();
			rs2.next();
			String prix1=rs1.getString("prix1");
			String prix2=rs2.getString("prix2");
			if(prix1==null) {
				String idclient = rs2.getString("idclient");
				String FINN ="insert into Contrat (num,idclient,date,prix) Values ("+num+","+idclient+",'"+java.sql.Date.valueOf(java.time.LocalDate.now())+"',"+prix2+");";
				stmnt.execute(FINN);
			}
			else if(prix2==null){
				String idclient = rs1.getString("idclient");
				String FINN ="insert into Contrat (num,idclient,date,prix) Values ("+num+","+idclient+","+java.sql.Date.valueOf(java.time.LocalDate.now())+","+prix1+");";
				stmnt.execute(FINN);	       
			}
			con.close();
			selectionner(e);
			Frame[] f=getFrames();
			f[f.length-1].dispose();
			Menu m=new Menu();
			m.setVisible(true);
		}
	private void rechercherFin(ActionEvent e) throws SQLException {
		Connection con = MysqlConnection.con();
		Statement stmnt = con.createStatement();
		String sql = "Select Bien.num,Bien.Status ,Bien.Local , Bien.Rue ,Bien.NumRue from Bien,Client,Visite where Bien.num=visite.num and visite.idClient=Client.idClient and Client.Nom='"+nom.getText()+"' and Prenom= '"+prenom.getText()+"';";
		ResultSet rs = stmnt.executeQuery(sql);
		table.setModel(DbUtils.resultSetToTableModel(rs));
		
	}
	private void selectionner(ActionEvent e) throws SQLException {
		Connection con = MysqlConnection.con();
		Statement stmnt = con.createStatement();
		String sql = "Select distinct email, Bien.rue, Bien.local, Visite.Date "
				+ "from Bien, Client, Visite where"
				+ " visite.idClient=Client.idClient and Bien.num='"+num +"'";
		
		ResultSet rs = stmnt.executeQuery(sql);
		String adresse;
		String local;
		String rue;
		String date;
		try{
	        while(rs.next()){
		        adresse = rs.getString(1);
		        rue = rs.getString(2);
		        local = rs.getString(3);
		        date = rs.getString(4);
		        Mail1 m = new Mail1();
		        //m.mailThis(adresse,"Bienvenue à l'applicatoin ImmoTunisie,\nOn veut vous informer que le bien localisée en "+rue+", "+local+" que vous avez visité en "+date+" n'est plus disponible.\nSi vous pensez que ce mail n'est pas dirigé à vous merci de l'ignorer.")
		        m.mailThis(adresse,"<!DOCTYPE html>\r\n"
		        		+ "<html lang=\"en\">\r\n"
		        		+ "<head>\r\n"
		        		+ "    <meta charset=\"UTF-8\">\r\n"
		        		+ "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n"
		        		+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
		        		+ "    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\">\r\n"
		        		+ "<link href=\"https://fonts.googleapis.com/css2?family=Roboto:wght@400;700;900&display=swap\" rel=\"stylesheet\">\r\n"
		        		+ "    <title>Notification ImmoTunisie</title>\r\n"
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
		        		+ "    #rue, #local, #date{\r\n"
		        		+ "        font-weight: 600;\r\n"
		        		+ "    }\r\n"
		        		+ "</style>\r\n"
		        		+ "<body>\r\n"
		        		+ "        <div id=\"main\">\r\n"
		        		+ "            <h1>Bienvenue à l'application ImmoTunisie,</h1>\r\n"
		        		+ "            <p>On veut vous informer que le bien localisée en <span id=\"rue\"> "+rue+" </span>, <span id=\"local\"> "+local+"</span> que vous avez visité en <span id=\"date\">"+date+"</span> n'est plus disponible.<br>Si vous pensez que ce mail n'est pas dirigé à vous merci de l'ignorer.</p>\r\n"
		        		+ "        </div>\r\n"
		        		+ "    </div>\r\n"
		        		+ "    \r\n"
		        		+ "</body>\r\n"
		        		+ "</html>");
				
	        }
	    }
		catch(SQLException sqle){sqle.printStackTrace();}   
	    catch(Exception e1){e1.printStackTrace();}
		con.close();
	    
	}
	/*
	private void creer_contrat(ActionEvent e) throws SQLException {
		Connection con = MysqlConnection.con();
		Statement stmnt = con.createStatement();
		String sql1="Select num, idclient, MontantCautionLocative+LoyerMensuel+ChargeMensuel as prix1 "
		    		+ "from visite,bien "
		    		+ "where bien.num='"+num+"' and visite.bien='"+num+"';";
		String sql2="Select num, idclient,Prixdemande as prix2 "
		    		+ "from visite "
		    		+ "where bien.num= '"+num+"' and visite.bien='"+num+"';";
		ResultSet rs1 = stmnt.executeQuery(sql1);
	    ResultSet rs2 = stmnt.executeQuery(sql2);
	    String prix1=rs1.getString("prix1");
	    String prix2=rs2.getString("prix2");
	    if(prix1.isEmpty()) {
	    	String idclient = rs2.getString("idclient");
	    	String FINN ="insert into Contrat (num,idclient,date,prix) Values ("+num+","+idclient+","+java.sql.Date.valueOf(java.time.LocalDate.now())+","+prix2+");";
	    	stmnt.executeQuery(FINN);
	    }
	    else if(prix2.isEmpty()){
	    	String idclient = rs1.getString("idclient");
	    	String FINN ="insert into Contrat (num,idclient,date,prix) Values ("+num+","+idclient+","+java.sql.Date.valueOf(java.time.LocalDate.now())+","+prix1+");";
	    	stmnt.executeQuery(FINN);	       
	    }
	}
	*/
}
