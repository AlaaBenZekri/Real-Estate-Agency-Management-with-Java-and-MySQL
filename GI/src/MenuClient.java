import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

public class MenuClient extends JFrame {
	private JPanel panelMaison;
	private JPanel panelAppartement;
	private JPanel panelStudio;
	private JPanel panelTerrain;
	private JPanel panelEntrepot;
	private JPanel panelBureau;
	
	private JRadioButton rdbtnAVendreB;
	private JCheckBox chckbxMeubB;
	private JTextField locChM;
	private JTextField supminM;
	private JTextField prixM;
	private JPanel panelLouerA;
	private JPanel panelLouerM;
	private JPanel panelAcheterA;
	private JPanel panelAcheterM;
	private JPanel panelLouerS;
	private JPanel panelAcheterS;
	private JPanel panelLouerB;
	private JPanel panelAcheterB;
	private JPanel panelLouerE;
	private JPanel panelAcheterE;
	private final ButtonGroup buttonGroupA = new ButtonGroup();
	private JTextField budgetMA;
	private final ButtonGroup buttonGroupM = new ButtonGroup();
	private JTextField budgetMM;
	private final ButtonGroup buttonGroupS = new ButtonGroup();
	private JTextField budgetMS;
	private final ButtonGroup buttonGroupB = new ButtonGroup();
	private JTextField budgetMB;
	private final ButtonGroup buttonGroupE = new ButtonGroup();
	private JTextField budgetME;
	private JTextField locb;
	private JTextField locE;
	private JTextField locT;
	private JTextField budgetB;
	private JTextField budgetE;
	private JRadioButton rdbtnAVendreM;
	private JTextField supminB;
	private JSpinner nbrPB;
	private JTextField supminE;
	private JTextField supminT;
	private JTextField budgetT;
	private JRadioButton rdbtnAVendreS;
	private JCheckBox chckbxMeubS;
	private JTextField budgetS;
	private JCheckBox chckbxAscS;
	private JTextField locS;
	private JTextField supS;
	private JSpinner etS;
	private JCheckBox chckbxMeubA;
	private JTextField budgetA;
	private JCheckBox chckbxchA;
	private JCheckBox chckbxchAsc;
	private JTextField locchA;
	private JTextField supminA;
	private JSpinner nbrchmin;
	private JCheckBox chckbxchMeubM;
	private JTextField budgetM;
	private JCheckBox chckbxGarageM;
	private JSpinner nbrChM;
	boolean anonyme;
	int idClient;
	private JRadioButton rdbtnAVendrechA;
	private JRadioButton rdbtnAVendreE;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuClient frame = new MenuClient();
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
	public MenuClient() {
		setResizable(false);
		setTitle("Espace Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 120, 641, 506);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 255));
		panel.setBounds(0, 0, 157, 477);
		getContentPane().add(panel);
		panel.setLayout(null);
		JButton btnEntrepot = new JButton("Entrepot");
		btnEntrepot.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnEntrepot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMaison.setVisible(false);
				panelAppartement.setVisible(false);
				panelStudio.setVisible(false);
				panelBureau.setVisible(false);
				panelTerrain.setVisible(false);
				panelEntrepot.setVisible(true);
				setTitle("Espace Client - Entrepot");
			}
		});
		btnEntrepot.setBackground(new Color(51, 102, 255));
		btnEntrepot.setForeground(Color.WHITE);
		btnEntrepot.setBounds(12, 262, 133, 33);
		panel.add(btnEntrepot);
		
		panelMaison = new JPanel();
		panelMaison.setBounds(157, 0, 468, 467);
		getContentPane().add(panelMaison);
		panelMaison.setLayout(null);
		
		panelAppartement = new JPanel();
		panelAppartement.setBounds(157, 0, 468, 467);
		getContentPane().add(panelAppartement);
		panelAppartement.setLayout(null);
		
		panelStudio = new JPanel();
		panelStudio.setBounds(157, 0, 468, 467);
		getContentPane().add(panelStudio);
		panelStudio.setLayout(null);
		
		panelTerrain = new JPanel();
		panelTerrain.setBounds(157, 0, 468, 467);
		getContentPane().add(panelTerrain);
		panelTerrain.setLayout(null);
		
		panelBureau = new JPanel();
		panelBureau.setBounds(157, 0, 468, 467);
		getContentPane().add(panelBureau);
		panelBureau.setLayout(null);
		
		panelEntrepot = new JPanel();
		panelEntrepot.setBounds(157, 0, 468, 467);
		getContentPane().add(panelEntrepot);
		panelEntrepot.setLayout(null);
		
		JButton retourButton = new JButton("Retourner");
		retourButton.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		retourButton.setForeground(Color.WHITE);
		retourButton.setBackground(new Color(51, 102, 255));
		retourButton.setBounds(12, 424, 133, 31);
		panel.add(retourButton);
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				MenuPreClient m=new MenuPreClient();
				m.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Dialog", Font.BOLD, 12));
		
		JButton btnBureau = new JButton("Bureau");
		btnBureau.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBureau.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMaison.setVisible(false);
				panelAppartement.setVisible(false);
				panelStudio.setVisible(false);
				panelBureau.setVisible(true);
				panelTerrain.setVisible(false);
				panelEntrepot.setVisible(false);
				setTitle("Espace Client - Bureau");
			}
		});
		btnBureau.setForeground(Color.WHITE);
		btnBureau.setBackground(new Color(51, 102, 255));
		btnBureau.setBounds(12, 217, 133, 33);
		panel.add(btnBureau);
		
		JButton btnStudio = new JButton("Studio");
		btnStudio.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnStudio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMaison.setVisible(false);
				panelAppartement.setVisible(false);
				panelStudio.setVisible(true);
				panelBureau.setVisible(false);
				panelTerrain.setVisible(false);
				panelEntrepot.setVisible(false);
				setTitle("Espace Client - Studio");
			}
		});
		btnStudio.setForeground(Color.WHITE);
		btnStudio.setBackground(new Color(51, 102, 255));
		btnStudio.setBounds(12, 172, 133, 33);
		panel.add(btnStudio);
		
		JButton btnAppartement = new JButton("Appartement");
		btnAppartement.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnAppartement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMaison.setVisible(false);
				panelAppartement.setVisible(true);
				panelStudio.setVisible(false);
				panelBureau.setVisible(false);
				panelTerrain.setVisible(false);
				panelEntrepot.setVisible(false);
				setTitle("Espace Client - Appartement");
			}
		});
		btnAppartement.setForeground(Color.WHITE);
		btnAppartement.setBackground(new Color(51, 102, 255));
		btnAppartement.setBounds(12, 127, 133, 33);
		panel.add(btnAppartement);
		
		JButton btnMaison = new JButton("Maison");
		btnMaison.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnMaison.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMaison.setVisible(true);
				panelAppartement.setVisible(false);
				panelStudio.setVisible(false);
				panelBureau.setVisible(false);
				panelTerrain.setVisible(false);
				panelEntrepot.setVisible(false);
				setTitle("Espace Client - Maison");
			}
		});
		btnMaison.setForeground(Color.WHITE);
		btnMaison.setBackground(new Color(51, 102, 255));
		btnMaison.setBounds(12, 79, 133, 33);
		panel.add(btnMaison);
		
		JButton btnTerrain = new JButton("Terrain");
		btnTerrain.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnTerrain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelMaison.setVisible(false);
				panelAppartement.setVisible(false);
				panelStudio.setVisible(false);
				panelBureau.setVisible(false);
				panelTerrain.setVisible(true);
				panelEntrepot.setVisible(false);
				setTitle("Espace Client - Terrain");
			}
		});
		btnTerrain.setForeground(Color.WHITE);
		btnTerrain.setBackground(new Color(51, 102, 255));
		btnTerrain.setBounds(12, 307, 133, 33);
		panel.add(btnTerrain);
		
		JLabel lblNewLabel_1_3 = new JLabel("Localit\u00E9:");
		lblNewLabel_1_3.setBounds(30, 64, 60, 14);
		panelMaison.add(lblNewLabel_1_3);
		
		locChM = new JTextField();
		locChM.setColumns(10);
		locChM.setBounds(140, 64, 86, 20);
		panelMaison.add(locChM);
		
		JLabel lblCaractristiques = new JLabel("Caract\u00E9ristiques:");
		lblCaractristiques.setForeground(new Color(51, 102, 255));
		lblCaractristiques.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaractristiques.setBounds(12, 26, 192, 26);
		panelMaison.add(lblCaractristiques);
		
		JLabel lblNewLabel_1_4 = new JLabel("Superficie:");
		lblNewLabel_1_4.setBounds(30, 104, 68, 14);
		panelMaison.add(lblNewLabel_1_4);
		
		supminM = new JTextField();
		supminM.setColumns(10);
		supminM.setBounds(140, 101, 86, 20);
		panelMaison.add(supminM);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Existance de garage");
		lblNewLabel_1_2_1_1.setBounds(28, 150, 129, 14);
		panelMaison.add(lblNewLabel_1_2_1_1);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Nbr Chambre:");
		lblNewLabel_1_2_1_1_1.setBounds(30, 187, 94, 14);
		panelMaison.add(lblNewLabel_1_2_1_1_1);
		
		nbrChM = new JSpinner();
		nbrChM.setBounds(180, 187, 46, 20);
		panelMaison.add(nbrChM);
		
		JSeparator separatorM = new JSeparator();
		separatorM.setBounds(30, 55, 395, 89);
		panelMaison.add(separatorM);
		
		JRadioButton rdbtnALouerM = new JRadioButton("A Louer");
		buttonGroupM.add(rdbtnALouerM);
		rdbtnALouerM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterM.setVisible(false);
				panelLouerM.setVisible(true);
			}
		});
		rdbtnALouerM.setBounds(213, 228, 86, 32);
		panelMaison.add(rdbtnALouerM);
		
		rdbtnAVendreM = new JRadioButton("A Vendre");
		buttonGroupM.add(rdbtnAVendreM);
		rdbtnAVendreM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterM.setVisible(true);
				panelLouerM.setVisible(false);
			}
		});
		rdbtnAVendreM.setBounds(95, 228, 86, 32);
		panelMaison.add(rdbtnAVendreM);
		
		panelAcheterM = new JPanel();
		panelAcheterM.setBounds(0, 268, 468, 82);
		panelMaison.add(panelAcheterM);
		panelAcheterM.setLayout(null);
		
		JLabel lblNewLabel_1_4_1_2 = new JLabel("Budget:");
		lblNewLabel_1_4_1_2.setBounds(33, 13, 133, 14);
		panelAcheterM.add(lblNewLabel_1_4_1_2);
		
		budgetM = new JTextField();
		budgetM.setColumns(10);
		budgetM.setBounds(152, 10, 86, 20);
		panelAcheterM.add(budgetM);
		
		panelLouerM = new JPanel();
		panelLouerM.setBounds(0, 268, 468, 82);
		panelMaison.add(panelLouerM);
		panelLouerM.setLayout(null);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Budget Mensuel:");
		lblNewLabel_1_4_1_1.setBounds(26, 13, 119, 14);
		panelLouerM.add(lblNewLabel_1_4_1_1);
		
		budgetMM = new JTextField();
		budgetMM.setColumns(10);
		budgetMM.setBounds(147, 10, 86, 20);
		panelLouerM.add(budgetMM);
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("Meubl\u00E9:");
		lblNewLabel_1_4_1_1_1.setBounds(26, 54, 119, 14);
		panelLouerM.add(lblNewLabel_1_4_1_1_1);
		
		chckbxchMeubM = new JCheckBox("");
		chckbxchMeubM.setBounds(213, 45, 30, 23);
		panelLouerM.add(chckbxchMeubM);
		panelLouerM.setVisible(false);
		
		chckbxGarageM = new JCheckBox("");
		chckbxGarageM.setBounds(202, 152, 97, 23);
		panelMaison.add(chckbxGarageM);
		
		JLabel lblNewLabel_1_31 = new JLabel("Localit\u00E9:");
		lblNewLabel_1_31.setBounds(30, 64, 60, 14);
		panelAppartement.add(lblNewLabel_1_31);
		
		locchA = new JTextField();
		locchA.setColumns(10);
		locchA.setBounds(119, 61, 86, 20);
		panelAppartement.add(locchA);
		
		JLabel lblCaractristiques1 = new JLabel("Caract\u00E9ristiques:");
		lblCaractristiques1.setForeground(new Color(51, 102, 255));
		lblCaractristiques1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaractristiques1.setBounds(3, 26, 192, 26);
		panelAppartement.add(lblCaractristiques1);
		
		JLabel lblNewLabel_1_41 = new JLabel("Superficie:");
		lblNewLabel_1_41.setBounds(30, 90, 68, 14);
		panelAppartement.add(lblNewLabel_1_41);
		
		supminA = new JTextField();
		supminA.setColumns(10);
		supminA.setBounds(119, 87, 86, 20);
		panelAppartement.add(supminA);
		
		JLabel lblNewLabel_1_2_11 = new JLabel("Nbr Chambres:");
		lblNewLabel_1_2_11.setBounds(30, 129, 94, 14);
		panelAppartement.add(lblNewLabel_1_2_11);
		
		nbrchmin = new JSpinner();
		nbrchmin.setBounds(159, 126, 46, 20);
		panelAppartement.add(nbrchmin);
		
		JLabel cuisApp = new JLabel("Cuisine Equip\u00E9e:");
		cuisApp.setBounds(30, 164, 133, 14);
		panelAppartement.add(cuisApp);
		
		chckbxchA = new JCheckBox("");
		chckbxchA.setBounds(190, 155, 97, 23);
		panelAppartement.add(chckbxchA);
		
		JSeparator separatorA = new JSeparator();
		separatorA.setBounds(30, 55, 395, 14);
		panelAppartement.add(separatorA);
		
		JRadioButton rdbtnALouerchA = new JRadioButton("A Louer");
		rdbtnALouerchA.setBounds(209, 230, 86, 32);
		buttonGroupA.add(rdbtnALouerchA);
		rdbtnALouerchA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterA.setVisible(false);
				panelLouerA.setVisible(true);
			}
		});
		panelAppartement.add(rdbtnALouerchA);
		
		rdbtnAVendrechA = new JRadioButton("A Vendre");
		rdbtnAVendrechA.setBounds(119, 230, 86, 32);
		buttonGroupA.add(rdbtnAVendrechA);
		rdbtnAVendrechA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterA.setVisible(true);
				panelLouerA.setVisible(false);
			}
		});
		panelAppartement.add(rdbtnAVendrechA);
		
		JLabel ascApp = new JLabel("Pr\u00E9sence d'Ascenseur");
		ascApp.setBounds(30, 172, 133, 50);
		panelAppartement.add(ascApp);
		
		chckbxchAsc = new JCheckBox("");
		chckbxchAsc.setBounds(190, 172, 200, 50);
		panelAppartement.add(chckbxchAsc);

		panelAcheterA = new JPanel();
		panelAcheterA.setBounds(3, 270, 468, 82);
		panelAcheterA.setLayout(null);
		panelAppartement.add(panelAcheterA);
		
		JLabel lblNewLabel_1_4_1_211 = new JLabel("Budget:");
		lblNewLabel_1_4_1_211.setBounds(33, 13, 133, 14);
		panelAcheterA.add(lblNewLabel_1_4_1_211);
		
		budgetA = new JTextField();
		budgetA.setColumns(10);
		budgetA.setBounds(152, 10, 86, 20);
		panelAcheterA.add(budgetA);
		
		panelLouerA = new JPanel();
		panelLouerA.setBounds(3, 270, 468, 82);
		panelLouerA.setLayout(null);
		panelAppartement.add(panelLouerA);
		
		JLabel lblNewLabel_1_4_1_11 = new JLabel("Budget Mensuel:");
		lblNewLabel_1_4_1_11.setBounds(26, 13, 119, 14);
		panelLouerA.add(lblNewLabel_1_4_1_11);
		
		budgetMA = new JTextField();
		budgetMA.setColumns(10);
		budgetMA.setBounds(130, 13, 86, 20);
		panelLouerA.add(budgetMA);
		
		JLabel lblNewLabel_1_4_1_1_11 = new JLabel("Meubl\u00E9:");
		lblNewLabel_1_4_1_1_11.setBounds(26, 54, 119, 14);
		panelLouerA.add(lblNewLabel_1_4_1_1_11);
		
		chckbxMeubA = new JCheckBox("");
		chckbxMeubA.setBounds(190, 45, 97, 23);
		panelLouerA.add(chckbxMeubA);
		
		JLabel lblNewLabel_2 = new JLabel("(minimale)");
		lblNewLabel_2.setForeground(new Color(128, 128, 128));
		lblNewLabel_2.setBounds(218, 117, 68, 38);
		panelAppartement.add(lblNewLabel_2);
		JLabel lblNewLabel_1_3ss = new JLabel("Localit\u00E9:");
		lblNewLabel_1_3ss.setBounds(25, 100, 60, 14);
		panelStudio.add(lblNewLabel_1_3ss);
		locS = new JTextField();
		locS.setColumns(10);
		locS.setBounds(118, 100, 86, 20);
		panelStudio.add(locS);
		JLabel lblCaractristiquesss = new JLabel("Caract\u00E9ristiques:");
		lblCaractristiquesss.setForeground(new Color(51, 102, 255));
		lblCaractristiquesss.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaractristiquesss.setBounds(12, 27, 192, 26);
		panelStudio.add(lblCaractristiquesss);
		JLabel ssssssssss = new JLabel("Superficie:");
		ssssssssss.setBounds(25, 125, 68, 14);
		panelStudio.add(ssssssssss);
		supS = new JTextField();
		supS.setColumns(10);
		supS.setBounds(118, 125, 86, 20);
		panelStudio.add(supS);
		JLabel lblNewLabel_1_2_1_1_111 = new JLabel("N° d'Etage:");
		lblNewLabel_1_2_1_1_111.setBounds(25, 150, 94, 14);
		panelStudio.add(lblNewLabel_1_2_1_1_111);
		etS = new JSpinner();
		etS.setBounds(158, 150, 46, 20);
		panelStudio.add(etS);
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(30, 65, 395, 8);
		panelStudio.add(separator_1);
		JRadioButton rdbtnALouerS = new JRadioButton("A Louer");
		rdbtnALouerS.setBounds(210, 208, 86, 32);
		buttonGroupS.add(rdbtnALouerS);
		rdbtnALouerS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterS.setVisible(false);
				panelLouerS.setVisible(true);
			}
		});
		panelStudio.add(rdbtnALouerS);
		rdbtnAVendreS = new JRadioButton("A Vendre");
		rdbtnAVendreS.setBounds(103, 208, 86, 32);
		buttonGroupS.add(rdbtnAVendreS);
		rdbtnAVendreS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterS.setVisible(true);
				panelLouerS.setVisible(false);
			}
		});
		panelStudio.add(rdbtnAVendreS);
		JLabel ascss = new JLabel("Pr\u00E9sence d'Ascenseur");
		ascss.setBounds(23, 176, 130, 26);
		panelStudio.add(ascss);
		chckbxAscS = new JCheckBox("");
		chckbxAscS.setBounds(187, 165, 21, 35);
		panelStudio.add(chckbxAscS);
		
		panelAcheterS = new JPanel();
		panelAcheterS.setBounds(0, 266, 468, 82);
		panelStudio.add(panelAcheterS);
		panelAcheterS.setLayout(null);
			
		JLabel lblNewLabel_1_4_1_2S = new JLabel("budget");
		lblNewLabel_1_4_1_2S.setBounds(33, 13, 133, 14);
		panelAcheterS.add(lblNewLabel_1_4_1_2S);
		
		budgetS = new JTextField();
		budgetS.setColumns(10);
		budgetS.setBounds(152, 10, 86, 20);
		panelAcheterS.add(budgetS);
			
		panelLouerS = new JPanel();
		panelLouerS.setBounds(0, 266, 468, 82);
		panelStudio.add(panelLouerS);
		panelLouerS.setLayout(null);
				
				JLabel lblNewLabel_1_4_1_1S = new JLabel("Budget Mensuel:");
				lblNewLabel_1_4_1_1S.setBounds(25, 13, 119, 14);
				panelLouerS.add(lblNewLabel_1_4_1_1S);
				
				budgetMS = new JTextField();
				budgetMS.setColumns(10);
				budgetMS.setBounds(133, 10, 73, 20);
				panelLouerS.add(budgetMS);
				
				JLabel lblNewLabel_1_4_1_1_1ss = new JLabel("Meubl\u00E9:");
				lblNewLabel_1_4_1_1_1ss.setBounds(25, 54, 51, 14);
				panelLouerS.add(lblNewLabel_1_4_1_1_1ss);
				
				chckbxMeubS = new JCheckBox("");
				chckbxMeubS.setBounds(187, 54, 97, 23);
				panelLouerS.add(chckbxMeubS);
				
				JLabel lblCaractristiqub = new JLabel("Caract\u00E9ristiques:");
				lblCaractristiqub.setForeground(new Color(51, 102, 255));
				lblCaractristiqub.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCaractristiqub.setBounds(8, 30, 192, 26);
				panelBureau.add(lblCaractristiqub);
				
				JLabel sb = new JLabel("Superficie:");
				sb.setBounds(30, 103, 68, 14);
				panelBureau.add(sb);
				
				supminB = new JTextField();
				supminB.setColumns(10);
				supminB.setBounds(114, 100, 86, 20);
				panelBureau.add(supminB);
				
				JLabel lblNewLabel_1_b = new JLabel("Nbr de Pieces");
				lblNewLabel_1_b.setBounds(30, 129, 94, 14);
				panelBureau.add(lblNewLabel_1_b);
				
				nbrPB = new JSpinner();
				nbrPB.setBounds(154, 126, 46, 20);
				panelBureau.add(nbrPB);
				
				JSeparator separator_11 = new JSeparator();
				separator_11.setBounds(30, 68, 395, 7);
				panelBureau.add(separator_11);
				//
				JRadioButton rdbtnALouerB = new JRadioButton("A Louer");
				rdbtnALouerB.setBounds(216, 167, 86, 32);
				buttonGroupB.add(rdbtnALouerB);
				rdbtnALouerB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelAcheterB.setVisible(false);
						panelLouerB.setVisible(true);
					}
				});
				panelBureau.add(rdbtnALouerB);
				
				rdbtnAVendreB = new JRadioButton("A Vendre");
				rdbtnAVendreB.setBounds(58, 167, 86, 32);
				buttonGroupB.add(rdbtnAVendreB);
				rdbtnAVendreB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelAcheterB.setVisible(true);
						panelLouerB.setVisible(false);
					}
				});
				panelBureau.add(rdbtnAVendreB);
				
				panelAcheterB = new JPanel();
				panelAcheterB.setBounds(24, 266, 401, 72);
				panelBureau.add(panelAcheterB);
				panelAcheterB.setLayout(null);
				
				JLabel lblNewLabel_1_4_1_2B = new JLabel("Budget ");
				lblNewLabel_1_4_1_2B.setBounds(33, 13, 133, 14);
				panelAcheterB.add(lblNewLabel_1_4_1_2B);
				
				budgetB = new JTextField();
				budgetB.setColumns(10);
				budgetB.setBounds(152, 10, 86, 20);
				panelAcheterB.add(budgetB);
				
				panelLouerB = new JPanel();
				panelLouerB.setBounds(12, 266, 468, 82);
				panelBureau.add(panelLouerB);
				panelLouerB.setLayout(null);
				
				JLabel lblNewLabel_1_4_1_1S1 = new JLabel("Budget Mensuel");
				lblNewLabel_1_4_1_1S1.setBounds(30, 13, 119, 14);
				panelLouerB.add(lblNewLabel_1_4_1_1S1);
				
				budgetMB = new JTextField();
				budgetMB.setColumns(10);
				budgetMB.setBounds(137, 10, 86, 20);
				panelLouerB.add(budgetMB);
				
				JLabel lblNewLabel_1_4_1_1_1ss1 = new JLabel("Meubl\u00E9:");
				lblNewLabel_1_4_1_1_1ss1.setBounds(30, 56, 51, 14);
				panelLouerB.add(lblNewLabel_1_4_1_1_1ss1);
				
				chckbxMeubB = new JCheckBox("");
				chckbxMeubB.setBounds(184, 56, 97, 23);
				panelLouerB.add(chckbxMeubB);
				
				locb = new JTextField();
				locb.setBounds(114, 73, 86, 20);
				panelBureau.add(locb);
				locb.setColumns(10);
				
				JLabel lblNewLabel = new JLabel("Localit\u00E9:");
				lblNewLabel.setBounds(30, 68, 55, 23);
				panelBureau.add(lblNewLabel);
		
		JLabel lblCaractristiques11 = new JLabel("Caract\u00E9ristiques:");
		lblCaractristiques11.setForeground(new Color(51, 102, 255));
		lblCaractristiques11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaractristiques11.setBounds(12, 87, 192, 26);
		panelEntrepot.add(lblCaractristiques11);
		
		JLabel lblNewLabel_1_411 = new JLabel("Superficie:");
		lblNewLabel_1_411.setBounds(23, 176, 68, 16);
		panelEntrepot.add(lblNewLabel_1_411);
		
		supminE = new JTextField();
		supminE.setColumns(10);
		supminE.setBounds(118, 174, 86, 20);
		panelEntrepot.add(supminE);
		
		JSeparator separator_111 = new JSeparator();
		separator_111.setBounds(34, 125, 395, 5);
		panelEntrepot.add(separator_111);
		
		//

		JRadioButton rdbtnALouerE = new JRadioButton("A Louer");
		rdbtnALouerE.setBounds(203, 200, 86, 32);
		buttonGroupE.add(rdbtnALouerE);
		rdbtnALouerE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterE.setVisible(false);
				panelLouerE.setVisible(true);
			}
		});
		panelEntrepot.add(rdbtnALouerE);
		
		rdbtnAVendreE = new JRadioButton("A Vendre");
		rdbtnAVendreE.setBounds(69, 200, 86, 32);
		buttonGroupE.add(rdbtnAVendreE);
		rdbtnAVendreE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterE.setVisible(true);
				panelLouerE.setVisible(false);
			}
		});
		panelEntrepot.add(rdbtnAVendreE);
		
		panelAcheterE = new JPanel();
		panelAcheterE.setBounds(-2, 254, 468, 82);
		panelEntrepot.add(panelAcheterE);
		panelAcheterE.setLayout(null);
		
		budgetE = new JTextField();
		budgetE.setColumns(10);
		budgetE.setBounds(152, 10, 86, 20);
		panelAcheterE.add(budgetE);
		
		JLabel eeeeeeeeeee = new JLabel("Budget:");
		eeeeeeeeeee.setBounds(28, 13, 133, 14);
		panelAcheterE.add(eeeeeeeeeee);
		
		panelLouerE = new JPanel();
		panelLouerE.setBounds(-2, 254, 468, 82);
		panelEntrepot.add(panelLouerE);
		panelLouerE.setLayout(null);
		
		JLabel lblNewLabel_1_4_1_1E = new JLabel("Budget Mensuel:");
		lblNewLabel_1_4_1_1E.setBounds(30, 10, 119, 14);
		panelLouerE.add(lblNewLabel_1_4_1_1E);
		
		budgetME = new JTextField();
		budgetME.setColumns(10);
		budgetME.setBounds(145, 7, 86, 20);
		panelLouerE.add(budgetME);
		
		JLabel lblNewLabel_1_411_1 = new JLabel("Localit\u00E9:");
		lblNewLabel_1_411_1.setBounds(23, 148, 68, 16);
		panelEntrepot.add(lblNewLabel_1_411_1);
		
		locE = new JTextField();
		locE.setColumns(10);
		locE.setBounds(118, 142, 86, 20);
		panelEntrepot.add(locE);
		panelLouerE.setVisible(false);
		
		JLabel lblCaractristiquesT = new JLabel("Caract\u00E9ristiques:");
		lblCaractristiquesT.setForeground(new Color(51, 102, 255));
		lblCaractristiquesT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaractristiquesT.setBounds(12, 117, 192, 26);
		panelTerrain.add(lblCaractristiquesT);
		
		JLabel lblNewLabelT = new JLabel("Superficie:");
		lblNewLabelT.setBounds(43, 190, 68, 14);
		panelTerrain.add(lblNewLabelT);
		
		supminT = new JTextField();
		supminT.setColumns(10);
		supminT.setBounds(129, 184, 86, 20);
		panelTerrain.add(supminT);
		
		JSeparator separator_1111 = new JSeparator();
		separator_1111.setBounds(27, 141, 395, 5);
		panelTerrain.add(separator_1111);
		JLabel lblNewLabel_T = new JLabel("Budget:");
		lblNewLabel_T.setBounds(43, 216, 68, 14);
		panelTerrain.add(lblNewLabel_T);
		
		budgetT = new JTextField();
		budgetT.setColumns(10);
		budgetT.setBounds(129, 213, 86, 20);
		panelTerrain.add(budgetT);
		
		JLabel lblLocalit = new JLabel("Localit\u00E9");
		lblLocalit.setBounds(43, 162, 68, 14);
		panelTerrain.add(lblLocalit);
		
		locT = new JTextField();
		locT.setColumns(10);
		locT.setBounds(129, 158, 86, 20);
		panelTerrain.add(locT);
		
		JButton btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechercher(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRechercher.setBounds(339, 423, 117, 32);
		panelEntrepot.add(btnRechercher);
		
		JButton btnRechercher_1 = new JButton("Rechercher");
		btnRechercher_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechercher(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRechercher_1.setBounds(339, 423, 117, 32);
		panelBureau.add(btnRechercher_1);
		
		JButton btnRechercher_2 = new JButton("Rechercher");
		btnRechercher_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechercher(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRechercher_2.setBounds(339, 423, 117, 32);
		panelTerrain.add(btnRechercher_2);
		
		JButton btnRechercher_3 = new JButton("Rechercher");
		btnRechercher_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechercher(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRechercher_3.setBounds(339, 423, 117, 32);
		panelStudio.add(btnRechercher_3);
		
		JButton btnRechercher_4 = new JButton("Rechercher");
		btnRechercher_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechercher(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRechercher_4.setBounds(339, 423, 117, 32);
		panelMaison.add(btnRechercher_4);
		
		JButton btnRechercher_5 = new JButton("Rechercher");
		btnRechercher_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					rechercher(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnRechercher_5.setBounds(339, 423, 117, 32);
		panelAppartement.add(btnRechercher_5);
		
		
		panelMaison.setVisible(false);
		panelAppartement.setVisible(false);
		panelStudio.setVisible(false);
		panelBureau.setVisible(false);
		panelTerrain.setVisible(false);
		panelEntrepot.setVisible(false);
		
		panelAcheterA.setVisible(false);
		panelLouerA.setVisible(false);
		panelAcheterM.setVisible(false);
		panelAcheterS.setVisible(false);
		panelLouerS.setVisible(false);
		panelAcheterB.setVisible(false);
		panelLouerB.setVisible(false);
		panelAcheterE.setVisible(false);
	}
	
	private void rechercher(ActionEvent e) throws SQLException {
		Connection con = MysqlConnection.con();
		Statement stmnt = con.createStatement();
		String sql = null;
		if (panelMaison.isVisible()) {
				sql=" FROM bien, classe WHERE bien.code=classe.code and classe.Type='Maison' and Local='"+locChM.getText()+"' and Superficie>='"+supminM.getText()+"' and NombreChambres>='"+nbrChM.getValue()+"'";
				if(chckbxGarageM.isSelected()) {
					sql+=" and NombreGarages>0 ";
				}
			
				if(rdbtnAVendreM.isSelected()) {
					sql+=" and PrixDemande<='"+budgetM.getText()+"' and Status='A vendre'";
				//AVENDRE
					sql="select num, local, Rue, PrixDemande, Etat, NombreChambres, NombreGarages, SuperficieJardin, NombreEtages "+sql;
				
				}else {
					sql+=" and MontantCautionLocative+LoyerMensuel+ChargeMensuel<='"+budgetMM.getText()+"' Status='A Louer'";
					if(chckbxchMeubM.isSelected()) {
						sql+=" and Meuble=1 ";
					}else{
						sql+=" and Meuble=0 ";
						
					}
					sql="select num, local, Rue, MontantCautionLocative, LoyerMensuel, ChargeMensuel, NombreChambres, NombreGarages, SuperficieJardin, NombreEtages "+sql;
					
					
				}
				sql+=" ;";
				
			
		}else if(panelAppartement.isVisible()) {
			sql=" FROM bien, classe WHERE bien.code=classe.code and classe.Type='Appartemant' and Local='"+locchA.getText()+"' and Superficie>='"+supminA.getText()+"' and NombreChambres>='"+nbrchmin.getValue()+"' ";
			if(chckbxchAsc.isSelected()) {
				sql+=" and Ascenseur=1 ";
			}
			//chckbxchA
			if(chckbxchA.isSelected()) {
				sql+=" and CuisineEquipe=1 ";}
		
			if(rdbtnAVendrechA.isSelected()) {
				sql="select num, local, Rue, PrixDemande, Etat, NombreChambres, EtageDeLocal, "+sql;
				
				sql+=" and PrixDemande<='"+budgetA.getText()+"' and Status='A vendre'";
			}else {
				sql+=" and MontantCautionLocative+LoyerMensuel+ChargeMensuel<='"+budgetMA.getText()+"' and Status='A vendre'";
				if(chckbxMeubA.isSelected()) {
					sql+=" and Meuble=1 ";
				}else{
					sql+=" and Meuble=0 ";
					
				}
				sql="select num, local, Rue, MontantCautionLocative, LoyerMensuel, ChargeMensuel, NombreChambres, EtageDeLocal, "+sql;
			}
			sql+=" ;";
			
		}else if(panelStudio.isVisible()) {
			sql=" FROM bien, classe WHERE bien.Code=classe.Code and classe.Type='Studio' and Local='"+locS.getText()+"' and Superficie>='"+supS.getText()+"' and EtageDeLocal<='"+etS.getValue()+"'";
			if(chckbxAscS.isSelected()) {
				sql+=" and Ascenseur=1 ";
			}
			
			if(rdbtnAVendreS.isSelected()) {
				sql+=" and PrixDemande<='"+budgetS.getText()+"' and Status='A vendre'";
				sql="select num, local, Rue, PrixDemande, Etat, EtageDeLocal "+sql;
			}else {
				sql+=" and MontantCautionLocative+LoyerMensuel+ChargeMensuel<='"+budgetMS.getText()+"' and Status='A Louer'";
				if(chckbxMeubS.isSelected()) {
					sql+=" and Meuble=1 ";
				}else{
					sql+=" and Meuble=0 ";
					
				}
				sql="select num, local, Rue, MontantCautionLocative, LoyerMensuel, ChargeMensuel, Etat, EtageDeLocal "+sql;
			}
			sql+=" ;";
			
		}else if(panelTerrain.isVisible()) {
			sql="SELECT num, Local,rue, prixdemande FROM bien,classe WHERE bien.code=classe.code and classe.Type='Terrain' and Local='"+locT.getText()+"' and Superficie >='"+supminT.getText()+"' and PrixDemande<='"+budgetT.getText()+"'";
			sql+=" ;";
		}else if(panelEntrepot.isVisible()) {
			sql=" FROM bien, classe WHERE bien.code=classe.code and classe.Type='Entrepot' and Local='"+locE.getText()+"' and Superficie>='"+supminE.getText()+"'";
		
			if(rdbtnAVendreE.isSelected()) {
				sql+=" and PrixDemande<='"+budgetE.getText()+"' and Status='A vendre";
				sql="select num, local, rue, NumRue, Superficie, PrixDemande"+sql;
			}else {
				sql+=" and  MontantCautionLocative+LoyerMensuel+ChargeMensuel<='"+budgetME.getText()+"' and Status='A louer";
				sql="select num, local, rue, NumRue, Superficie, MontantCautionLocative, LoyerMensuel, ChargeMensuel"+sql;
			}
			sql+=" ;";
			
		}//panelBureau
		else if (panelBureau.isVisible()) {
			sql=" FROM bien, classe WHERE bien.code=classe.code and classe.Type='Bureau' and Local='"+locb.getText()+"' and Superficie >='"+supminB.getText()+"' and NbrComposants>='"+nbrPB.getValue()+"'";
			
			if(rdbtnAVendreB.isSelected()) {
				sql="select num, local, rue, NumRue, NbrComposants, Superficie, PrixDemande"+sql;
				sql+=" and PrixDemande<='"+budgetB.getText()+"' and Status='A vendre'";
			}else {
				sql+=" and MontantCautionLocative+LoyerMensuel+ChargeMensuel<='"+budgetMB.getText()+"' and Status='A louer'";
				if(chckbxMeubB.isSelected()) {
					sql+=" and Meuble=1 ";
				}else{
					sql+=" and Meuble=0 ";
					
				}
				sql="select num, local, rue, NumRue, Superficie, MontantCautionLocative, LoyerMensuel, ChargeMensuel "+sql;
				
			}
			sql+=" ;";
			
		
	}
		///////
		
		ResultSet rs = stmnt.executeQuery(sql);
		Frame[] f=getFrames();
		f[f.length-1].dispose();
		Recherche r = new Recherche();
		r.table.setModel(DbUtils.resultSetToTableModel(rs));
		r.anonyme1=anonyme;
		r.idClient1=idClient;
		r.setVisible(true);
	}


}