
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import mailing.utilities.Mail1;
import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;


public class CreerVisite extends JFrame implements PropertyChangeListener {
	int idEmpl,idClient,idBien;/////////////// ASUPPRIMER idClient
	String date,time;
	/**
	 * 
	 */

	//the TextField for typing the date
	//DateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
	//JFormattedTextField madate = new JFormattedTextField(sdf);
	//DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
	JFormattedTextField  madate = new JFormattedTextField(df);
	private JTable table;
	
	public static void main(String[] args)
	{
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				CreerVisite window = null;
				try {
					window = new CreerVisite();
					window.setVisible(true);
				}
				catch (Exception exp) {
					exp.printStackTrace();
				}
			}
		});
	}
		
		public CreerVisite()
		{
			setResizable(false);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setSize(541, 464);
			setTitle("Organiser une Visite");
			setBounds(420, 150, 541, 486);
			
			Container cp = getContentPane();
			madate.setBounds(67, 60, 130, 30);
			 			
			madate.setValue(new Date());
			madate.setPreferredSize(new Dimension(130, 30));
			    
			// display the window with the calendar
			CalendarWindow calendarWindow = new CalendarWindow(); 
			    
			//wire a listener for the PropertyChange event of the calendar window
			calendarWindow.addPropertyChangeListener(this);
			
			
			JButton calendarButton = new JButton("Choisir une date");
			calendarButton.setBounds(207, 64, 130, 23);
					
			calendarButton.addActionListener(new ActionListener()
			{
			  public void actionPerformed(ActionEvent e)
			  {
				//render the calendar window below the text field
				calendarWindow.setLocation(madate.getLocationOnScreen().x, (madate.getLocationOnScreen().y + madate.getHeight()));
				//get the Date and assign it to the calendar
				Date d = (Date)madate.getValue();				
				calendarWindow.resetSelection(d);				
				//calendarWindow.setUndecorated(true);
			    calendarWindow.setVisible(true);
			  }
			});
			getContentPane().setLayout(null);

			//add the UI controls to the ContentPane
			cp.add(madate);
			cp.add(calendarButton);
			cp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			
			JLabel lblNewLabel = new JLabel("Choisir une date:");
			lblNewLabel.setBounds(27, 18, 242, 30);
			getContentPane().add(lblNewLabel);
			
			JSpinner spinnerH = new JSpinner();
			spinnerH.setModel(new SpinnerNumberModel(9, null, 12, 1));
			spinnerH.setBounds(56, 137, 45, 20);
			getContentPane().add(spinnerH);
			
			JLabel lblNewLabel_1 = new JLabel("H");
			lblNewLabel_1.setBounds(104, 139, 13, 16);
			getContentPane().add(lblNewLabel_1);
			
			JSpinner spinnerMin = new JSpinner();
			spinnerMin.setModel(new SpinnerNumberModel(0, 0, 59, 1));
			spinnerMin.setBounds(125, 137, 45, 20);
			getContentPane().add(spinnerMin);
			
			JLabel lblNewLabel_2 = new JLabel("Min");
			lblNewLabel_2.setBounds(176, 136, 21, 23);
			getContentPane().add(lblNewLabel_2);
			
			JButton btnNewButton = new JButton("Chercher un Employer disponible");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//DateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
					//JFormattedTextField dateTextField = new JFormattedTextField(sdf);
					
					 date =df.format(madate.getValue());
					 time=spinnerH.getValue()+":"+spinnerMin.getValue();
					//////////////////////////////A tester apresss
					 try {
						chercherEmp(date,time);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
			btnNewButton.setBounds(43, 175, 258, 26);
			getContentPane().add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("Confirmer");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i =table.getSelectedRow();
					if (i!=-1) {
						int idEmp=(int)table.getValueAt(i, 0);
						try {
							confirmer(idEmp,idClient,date,time);
							selectionner(e);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			});
			btnNewButton_1.setBounds(404, 377, 98, 26);
			getContentPane().add(btnNewButton_1);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(67, 213, 422, 131);
			getContentPane().add(scrollPane);
			
			table = new JTable();
			scrollPane.setViewportView(table);
			
			JLabel lblNewLabel_3 = new JLabel("(les visites se passent entre 8 h et 12 h)");
			lblNewLabel_3.setForeground(new Color(119, 136, 153));
			lblNewLabel_3.setBounds(207, 134, 266, 23);
			getContentPane().add(lblNewLabel_3);
	        
			JButton retourButton = new JButton("Retourner");
			retourButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Frame[] f=getFrames();
					f[f.length-1].dispose();
					Menu m=new Menu();
					m.setVisible(true);
				}
			});
			retourButton.setFont(new Font("Dialog", Font.BOLD, 12));
			retourButton.setBounds(20, 377, 97, 29);
			cp.add(retourButton);
			
			JLabel lblChoisirUnHoraire = new JLabel("Choisir un horaire:");
			lblChoisirUnHoraire.setBounds(27, 95, 242, 30);
			getContentPane().add(lblChoisirUnHoraire);
	        
		}
		
        @Override
		public void propertyChange(PropertyChangeEvent event) {
			
        	//get the selected date from the calendar control and set it to the text field
			if (event.getPropertyName().equals("selectedDate")) {
	            
				java.util.Calendar cal = (java.util.Calendar)event.getNewValue();
				Date selDate =  cal.getTime();
				madate.setValue(selDate);
				
	        }
			
		}
        public void chercherEmp(String date,String time) throws SQLException {
        	Connection con = MysqlConnection.con();
    		Statement stmnt = con.createStatement();
        	String req = "Select * From employevisite where employevisite.idEmp in (Select employevisite.idEmp from employevisite where employevisite.idEmp not in (Select employevisite.idEmp from employevisite ,visite where visite.idEmp=employevisite.idEmp and Date = "+date+" and Heure = '"+time+"' ));";
        	ResultSet rs = stmnt.executeQuery(req);
    		table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        public void confirmer(int idEmp,int idClient,String madate,String time) throws SQLException {
        	Connection con = MysqlConnection.con();
        	Statement stmnt = con.createStatement();
        	String sql= "INSERT INTO visite(idClient,idEmp,num,Date,Heure)"	+ " VALUES ("+idClient+","+idEmp+","+idBien+",'"+madate+"','"+time+"');";
        	stmnt.execute(sql);
        	Frame[] f=getFrames();
			f[f.length-1].dispose();
			JOptionPane.showMessageDialog(null,"Visite enregistré");
			Menu m=new Menu();
			m.setVisible(true);
        }
    	private void selectionner(ActionEvent e) throws SQLException {
    		Connection con = MysqlConnection.con();
    		Statement stmnt = con.createStatement();
    		String sql = "Select distinct email, Bien.rue, Bien.local, Visite.Date "
    				+ "from Bien, Client, Visite where"
    				+ " visite.idClient=Client.idClient and Bien.num='"+idBien +"'";
    		
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
    		        //m.mailThis(adresse,"Bienvenue à l'applicatoin ImmoTunisie,\nOn veut vous informer que le bien localisée en "+rue+", "+local+" que vous avez visité en "+date+" a été visité par un autre client.\nSi vous pensez que ce mail n'est pas dirigé à vous merci de l'ignorer.");
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
    		        		+ "            <p>On veut vous informer que le bien localisée en <span id=\"rue\"> "+rue+" </span> , <span id=\"local\"> "+local+"</span> que vous avez visité en <span id=\"date\">"+date+"</span> a été visité par un autre client. <br>Si vous pensez que ce mail n'est pas dirigé à vous merci de l'ignorer.</p>\r\n"
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
}