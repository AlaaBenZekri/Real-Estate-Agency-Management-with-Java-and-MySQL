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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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

import javax.swing.JTable;

public class MenuProp extends JFrame {
	private JPanel panelMaison;
	private JPanel panelAppartement;
	private JPanel panelStudio;
	private JPanel panelTerrain;
	private JPanel panelEntrepot;
	private JPanel panelBureau;
	private JTextField rueM;
	private JTextField numRueM;
	private JTextField locM;
	private JTextField codeM;
	private JTextField supM;
	private JTextField supJarM;
	private JTextField prixM;
	private JTextField prixA;
	private JTextField prixS;
	private JTextField prixE;
	private JTextField prixB;
	private JTextField prixT;
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
	private JTextField cautionA;
	private JTextField loyerA;
	private JTextField chargeA;
	private final ButtonGroup buttonGroupM = new ButtonGroup();
	private JTextField cautionM;
	private JTextField loyerM;
	private JTextField chargeM;
	private final ButtonGroup buttonGroupS = new ButtonGroup();
	private JTextField cautionS;
	private JTextField loyerS;
	private JTextField chargeS;
	private final ButtonGroup buttonGroupB = new ButtonGroup();
	private JTextField cautionB;
	private JTextField loyerB;
	private JTextField chargeB;
	private final ButtonGroup buttonGroupE = new ButtonGroup();
	private JTextField cautionE;
	private JTextField loyerE;
	private JTextField chargeE;
	private JSpinner chM;
	private JSpinner garM;
	private JSpinner etM;
	private JCheckBox chckbxCuisM;
	private JCheckBox chckbxMeubM;
	private JCheckBox chckbxMeubA;
	private JCheckBox chckbxMeubS;
	private JCheckBox chckbxMeubB;
	private JTextField rueApp;
	private JRadioButton rdbtnALouerM;
	private JRadioButton rdbtnAVendreM;
	private JRadioButton rdbtnALouerA;
	private JRadioButton rdbtnAVendreA;
	private JRadioButton rdbtnALouerB;
	private JRadioButton rdbtnAVendreB;
	private JRadioButton rdbtnALouerS;
	private JRadioButton rdbtnAVendreS;
	private JRadioButton rdbtnALouerE;
	private JRadioButton rdbtnAVendreE;
	private JComboBox etatM;
	private JComboBox etatA;
	private JComboBox etatB;
	private JComboBox etatE;
	private JComboBox etatS;
	private JTextField numRueApp;
	private JTextField locApp;
	private JTextField codeApp;
	private JTextField supApp;
	private JSpinner chApp;
	private JSpinner etApp;
	private JSpinner etS;
	private JTextField rueS;
	private JTextField rueE;
	private JTextField rueB;
	private JTextField rueT;
	private JTextField numRueS;
	private JTextField numRueT;
	private JTextField numRueE;
	private JTextField numRueB;
	private JTextField locS;
	private JTextField locE;
	private JTextField locB;
	private JTextField locT;
	private JCheckBox chckbxAsc;
	private JCheckBox chckbxAscS;
	private JTextField codeS;
	private JTextField codeB;
	private JTextField codeE;
	private JTextField codeT;
	private JCheckBox chckbxA;
	private JTextField supS;
	private JTextField supB;
	private JTextField supE;
	private JTextField supT;
	private JSpinner nbrPB;
	int idProp;
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuProp frame = new MenuProp();
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
	public MenuProp() {
		setResizable(false);
		
		setTitle("Espace Proprietaire");
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
				setTitle("Espace Proprietaire - Entrepot");
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
				setTitle("Espace Proprietaire - Bureau");
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
				setTitle("Espace Proprietaire - Studio");
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
				setTitle("Espace Proprietaire - Appartement");
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
				JOptionPane.showMessageDialog(null,idProp);
				panelMaison.setVisible(true);
				panelAppartement.setVisible(false);
				panelStudio.setVisible(false);
				panelBureau.setVisible(false);
				panelTerrain.setVisible(false);
				panelEntrepot.setVisible(false);
				setTitle("Espace Proprietaire - Maison");
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
				setTitle("Espace Proprietaire - Terrain");
			}
		});
		btnTerrain.setForeground(Color.WHITE);
		btnTerrain.setBackground(new Color(51, 102, 255));
		btnTerrain.setBounds(12, 307, 133, 33);
		panel.add(btnTerrain);
		
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
				MenuPreProp m=new MenuPreProp();
				m.setVisible(true);
			}
		});
		retourButton.setFont(new Font("Dialog", Font.BOLD, 12));
		
		//Panel Maison
		JLabel lblNewLabel = new JLabel("Localisation:");
		lblNewLabel.setForeground(new Color(51, 102, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(20, 26, 133, 26);
		panelMaison.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Rue:");
		lblNewLabel_1.setBounds(49, 69, 46, 14);
		panelMaison.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("N\u00B0 Rue:");
		lblNewLabel_1_1.setBounds(49, 116, 46, 14);
		panelMaison.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Code Postale:");
		lblNewLabel_1_2.setBounds(251, 69, 94, 14);
		panelMaison.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Localit\u00E9:");
		lblNewLabel_1_3.setBounds(251, 116, 60, 14);
		panelMaison.add(lblNewLabel_1_3);
		
		rueM = new JTextField();
		rueM.setBounds(142, 66, 86, 20);
		panelMaison.add(rueM);
		rueM.setColumns(10);
		
		numRueM = new JTextField();
		numRueM.setColumns(10);
		numRueM.setBounds(142, 113, 86, 20);
		panelMaison.add(numRueM);
		
		locM = new JTextField();
		locM.setColumns(10);
		locM.setBounds(339, 113, 86, 20);
		panelMaison.add(locM);
		
		codeM = new JTextField();
		codeM.setColumns(10);
		codeM.setBounds(339, 66, 86, 20);
		panelMaison.add(codeM);
		
		JLabel lblCaractristiques = new JLabel("Caract\u00E9ristiques:");
		lblCaractristiques.setForeground(new Color(51, 102, 255));
		lblCaractristiques.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaractristiques.setBounds(20, 155, 192, 26);
		panelMaison.add(lblCaractristiques);
		
		JLabel lblNewLabel_1_4 = new JLabel("Superficie:");
		lblNewLabel_1_4.setBounds(33, 204, 68, 14);
		panelMaison.add(lblNewLabel_1_4);
		
		supM = new JTextField();
		supM.setColumns(10);
		supM.setBounds(152, 201, 86, 20);
		panelMaison.add(supM);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Nbr Chambres:");
		lblNewLabel_1_2_1.setBounds(251, 204, 94, 14);
		panelMaison.add(lblNewLabel_1_2_1);
		
		chM = new JSpinner();
		chM.setBounds(340, 201, 46, 20);
		panelMaison.add(chM);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Nbr Garages:");
		lblNewLabel_1_2_1_1.setBounds(251, 243, 94, 14);
		panelMaison.add(lblNewLabel_1_2_1_1);
		
		garM = new JSpinner();
		garM.setBounds(340, 240, 46, 20);
		panelMaison.add(garM);
		
		JLabel lblNewLabel_1_2_1_1_1 = new JLabel("Nbr Etages:");
		lblNewLabel_1_2_1_1_1.setBounds(251, 278, 94, 14);
		panelMaison.add(lblNewLabel_1_2_1_1_1);
		
		etM = new JSpinner();
		etM.setBounds(340, 275, 46, 20);
		panelMaison.add(etM);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Superficie du Jardin:");
		lblNewLabel_1_4_1.setBounds(33, 243, 133, 14);
		panelMaison.add(lblNewLabel_1_4_1);
		
		supJarM = new JTextField();
		supJarM.setColumns(10);
		supJarM.setBounds(152, 240, 86, 20);
		panelMaison.add(supJarM);
		
		JLabel cuisM = new JLabel("Cuisine Equip\u00E9e:");
		cuisM.setBounds(33, 278, 133, 14);
		panelMaison.add(cuisM);
		
		chckbxCuisM = new JCheckBox("");
		chckbxCuisM.setBounds(152, 274, 97, 23);
		panelMaison.add(chckbxCuisM);
		
		JSeparator separatorM = new JSeparator();
		separatorM.setBounds(30, 55, 395, 89);
		panelMaison.add(separatorM);
		
		JSeparator separator_1M = new JSeparator();
		separator_1M.setBounds(30, 187, 395, 126);
		panelMaison.add(separator_1M);
		
		rdbtnALouerM = new JRadioButton("A Louer");
		buttonGroupM.add(rdbtnALouerM);
		rdbtnALouerM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterM.setVisible(false);
				panelLouerM.setVisible(true);
			}
		});
		rdbtnALouerM.setBounds(213, 303, 86, 32);
		panelMaison.add(rdbtnALouerM);
		
		rdbtnAVendreM = new JRadioButton("A Vendre");
		buttonGroupM.add(rdbtnAVendreM);
		rdbtnAVendreM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterM.setVisible(true);
				panelLouerM.setVisible(false);
			}
		});
		rdbtnAVendreM.setBounds(109, 303, 86, 32);
		panelMaison.add(rdbtnAVendreM);
		
		panelAcheterM = new JPanel();
		panelAcheterM.setBounds(0, 339, 468, 82);
		panelMaison.add(panelAcheterM);
		panelAcheterM.setLayout(null);
		
		JLabel lblNewLabel_1_4_1_2 = new JLabel("Prix d'Achat:");
		lblNewLabel_1_4_1_2.setBounds(33, 13, 133, 14);
		panelAcheterM.add(lblNewLabel_1_4_1_2);
		
		prixM = new JTextField();
		prixM.setColumns(10);
		prixM.setBounds(152, 10, 86, 20);
		panelAcheterM.add(prixM);
		
		JLabel lblNewLabel_1_4_1_2_1 = new JLabel("Etat:");
		lblNewLabel_1_4_1_2_1.setBounds(33, 46, 133, 14);
		panelAcheterM.add(lblNewLabel_1_4_1_2_1);
		
		etatM = new JComboBox();
		etatM.setModel(new DefaultComboBoxModel(new String[] {"", "A restaurer", "Correct", "Impeccable"}));
		etatM.setBounds(139, 43, 114, 20);
		panelAcheterM.add(etatM);
		
		panelLouerM = new JPanel();
		panelLouerM.setBounds(0, 339, 468, 82);
		panelMaison.add(panelLouerM);
		panelLouerM.setLayout(null);
		
		JLabel lblNewLabel_1_4_11 = new JLabel("Caution Locative:");
		lblNewLabel_1_4_11.setBounds(26, 10, 119, 14);
		panelLouerM.add(lblNewLabel_1_4_11);
		
		cautionM = new JTextField();
		cautionM.setColumns(10);
		cautionM.setBounds(147, 10, 86, 20);
		panelLouerM.add(cautionM);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Loyer Mensuel:");
		lblNewLabel_1_4_1_1.setBounds(245, 10, 119, 14);
		panelLouerM.add(lblNewLabel_1_4_1_1);
		
		loyerM = new JTextField();
		loyerM.setColumns(10);
		loyerM.setBounds(343, 10, 86, 20);
		panelLouerM.add(loyerM);
		
		JLabel lblNewLabel_1_4_1_21 = new JLabel("Charges Mensuels:");
		lblNewLabel_1_4_1_21.setBounds(26, 47, 119, 14);
		panelLouerM.add(lblNewLabel_1_4_1_21);
		
		chargeM = new JTextField();
		chargeM.setColumns(10);
		chargeM.setBounds(147, 47, 86, 20);
		panelLouerM.add(chargeM);
		
		JLabel lblNewLabel_1_4_1_1_1 = new JLabel("Meubl\u00E9:");
		lblNewLabel_1_4_1_1_1.setBounds(245, 47, 119, 14);
		panelLouerM.add(lblNewLabel_1_4_1_1_1);
		
		chckbxMeubM = new JCheckBox("");
		chckbxMeubM.setBounds(343, 45, 97, 23);
		panelLouerM.add(chckbxMeubM);
		
		JButton btnEnregistrer_4 = new JButton("Enregistrer");
		btnEnregistrer_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert(e);
			}
		});
		btnEnregistrer_4.setBounds(339, 423, 117, 32);
		panelMaison.add(btnEnregistrer_4);

		
		//Panel Appartement
		JLabel lblNewLabel1 = new JLabel("Localisation:");
		lblNewLabel1.setForeground(new Color(51, 102, 255));
		lblNewLabel1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel1.setBounds(20, 26, 133, 26);
		panelAppartement.add(lblNewLabel1);
		
		JLabel lblNewLabel_11 = new JLabel("Rue:");
		lblNewLabel_11.setBounds(49, 69, 46, 14);
		panelAppartement.add(lblNewLabel_11);
		
		JLabel lblNewLabel_1_11 = new JLabel("N\u00B0 Rue:");
		lblNewLabel_1_11.setBounds(49, 116, 46, 14);
		panelAppartement.add(lblNewLabel_1_11);
		
		JLabel lblNewLabel_1_21 = new JLabel("Code Postale:");
		lblNewLabel_1_21.setBounds(251, 69, 94, 14);
		panelAppartement.add(lblNewLabel_1_21);
		
		JLabel lblNewLabel_1_31 = new JLabel("Localit\u00E9:");
		lblNewLabel_1_31.setBounds(251, 116, 60, 14);
		panelAppartement.add(lblNewLabel_1_31);
		
		rueApp = new JTextField();
		rueApp.setBounds(142, 66, 86, 20);
		panelAppartement.add(rueApp);
		rueApp.setColumns(10);
		
		numRueApp = new JTextField();
		numRueApp.setColumns(10);
		numRueApp.setBounds(142, 113, 86, 20);
		panelAppartement.add(numRueApp);
		
		locApp = new JTextField();
		locApp.setColumns(10);
		locApp.setBounds(339, 113, 86, 20);
		panelAppartement.add(locApp);
		
		codeApp = new JTextField();
		codeApp.setColumns(10);
		codeApp.setBounds(339, 66, 86, 20);
		panelAppartement.add(codeApp);
		
		JLabel lblCaractristiques1 = new JLabel("Caract\u00E9ristiques:");
		lblCaractristiques1.setForeground(new Color(51, 102, 255));
		lblCaractristiques1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaractristiques1.setBounds(20, 155, 192, 26);
		panelAppartement.add(lblCaractristiques1);
		
		JLabel lblNewLabel_1_41 = new JLabel("Superficie:");
		lblNewLabel_1_41.setBounds(33, 204, 68, 14);
		panelAppartement.add(lblNewLabel_1_41);
		
		supApp = new JTextField();
		supApp.setColumns(10);
		supApp.setBounds(152, 201, 86, 20);
		panelAppartement.add(supApp);
		
		JLabel lblNewLabel_1_2_11 = new JLabel("Nbr Chambres:");
		lblNewLabel_1_2_11.setBounds(251, 204, 94, 14);
		panelAppartement.add(lblNewLabel_1_2_11);
		
		chApp = new JSpinner();
		chApp.setBounds(340, 201, 46, 20);
		panelAppartement.add(chApp);
		
		JLabel lblNewLabel_1_2_1_1_11 = new JLabel("N° d'Etage:");
		lblNewLabel_1_2_1_1_11.setBounds(127, 234, 94, 14);
		panelAppartement.add(lblNewLabel_1_2_1_1_11);
		
		etApp = new JSpinner();
		etApp.setBounds(240, 231, 46, 20);
		panelAppartement.add(etApp);
		
		JLabel cuisApp = new JLabel("Cuisine Equip\u00E9e:");
		cuisApp.setBounds(33, 278, 133, 14);
		panelAppartement.add(cuisApp);
		
		chckbxA = new JCheckBox("");
		chckbxA.setBounds(152, 274, 97, 23);
		panelAppartement.add(chckbxA);
		
		JSeparator separatorA = new JSeparator();
		separatorA.setBounds(30, 55, 395, 89);
		panelAppartement.add(separatorA);
		
		JSeparator separator_1A = new JSeparator();
		separator_1A.setBounds(30, 187, 395, 126);
		panelAppartement.add(separator_1A);
		
		rdbtnALouerA = new JRadioButton("A Louer");
		rdbtnALouerA.setBounds(213, 303, 86, 32);
		buttonGroupA.add(rdbtnALouerA);
		rdbtnALouerA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterA.setVisible(false);
				panelLouerA.setVisible(true);
			}
		});
		panelAppartement.add(rdbtnALouerA);
		
		rdbtnAVendreA = new JRadioButton("A Vendre");
		rdbtnAVendreA.setBounds(109, 303, 86, 32);
		buttonGroupA.add(rdbtnAVendreA);
		rdbtnAVendreA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterA.setVisible(true);
				panelLouerA.setVisible(false);
			}
		});
		panelAppartement.add(rdbtnAVendreA);
		
		JLabel ascApp = new JLabel("Pr\u00E9sence d'Ascenseur");
		ascApp.setBounds(251, 260, 200, 50);
		panelAppartement.add(ascApp);
		
		chckbxAsc = new JCheckBox("");
		chckbxAsc.setBounds(392, 260, 200, 50);
		panelAppartement.add(chckbxAsc);

		panelAcheterA = new JPanel();
		panelAcheterA.setBounds(0, 339, 468, 82);
		panelAcheterA.setLayout(null);
		panelAppartement.add(panelAcheterA);
		
		JLabel lblNewLabel_1_4_1_211 = new JLabel("Prix d'Achat:");
		lblNewLabel_1_4_1_211.setBounds(33, 13, 133, 14);
		panelAcheterA.add(lblNewLabel_1_4_1_211);
		
		prixA = new JTextField();
		prixA.setColumns(10);
		prixA.setBounds(152, 10, 86, 20);
		panelAcheterA.add(prixA);
		
		JLabel lblNewLabel_1_4_1_2_11 = new JLabel("Etat:");
		lblNewLabel_1_4_1_2_11.setBounds(33, 46, 133, 14);
		panelAcheterA.add(lblNewLabel_1_4_1_2_11);
		
		etatA = new JComboBox();
		etatA.setModel(new DefaultComboBoxModel(new String[] {"", "A restaurer", "Correct", "Impeccable"}));
		etatA.setBounds(139, 43, 114, 20);
		panelAcheterA.add(etatA);
		
		panelLouerA = new JPanel();
		panelLouerA.setBounds(0, 339, 468, 82);
		panelLouerA.setLayout(null);
		panelAppartement.add(panelLouerA);
		
		JLabel lblNewLabel_1_4_111 = new JLabel("Caution Locative:");
		lblNewLabel_1_4_111.setBounds(26, 10, 119, 14);
		panelLouerA.add(lblNewLabel_1_4_111);
		
		cautionA = new JTextField();
		cautionA.setColumns(10);
		cautionA.setBounds(147, 10, 86, 20);
		panelLouerA.add(cautionA);
		
		JLabel lblNewLabel_1_4_1_11 = new JLabel("Loyer Mensuel:");
		lblNewLabel_1_4_1_11.setBounds(245, 10, 119, 14);
		panelLouerA.add(lblNewLabel_1_4_1_11);
		
		loyerA = new JTextField();
		loyerA.setColumns(10);
		loyerA.setBounds(343, 10, 86, 20);
		panelLouerA.add(loyerA);
		
		JLabel lblNewLabel_1_4_1_2111 = new JLabel("Charges Mensuels:");
		lblNewLabel_1_4_1_2111.setBounds(26, 47, 119, 14);
		panelLouerA.add(lblNewLabel_1_4_1_2111);
		
		chargeA = new JTextField();
		chargeA.setColumns(10);
		chargeA.setBounds(147, 47, 86, 20);
		panelLouerA.add(chargeA);
		
		JLabel lblNewLabel_1_4_1_1_11 = new JLabel("Meubl\u00E9:");
		lblNewLabel_1_4_1_1_11.setBounds(245, 47, 119, 14);
		panelLouerA.add(lblNewLabel_1_4_1_1_11);
		
		chckbxMeubA = new JCheckBox("");
		chckbxMeubA.setBounds(343, 45, 97, 23);
		panelLouerA.add(chckbxMeubA);
		
		JButton btnEnregistrer_5 = new JButton("Enregistrer");
		btnEnregistrer_5.setBounds(339, 423, 117, 32);
		btnEnregistrer_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert(e);
			}
		});
		panelAppartement.add(btnEnregistrer_5);
		
		//Panel Studio

		JLabel lblNewLabel1ssss = new JLabel("Localisation:");
				lblNewLabel1ssss.setForeground(new Color(51, 102, 255));
				lblNewLabel1ssss.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNewLabel1ssss.setBounds(20, 26, 133, 26);
				panelStudio.add(lblNewLabel1ssss);
				
				JLabel sss = new JLabel("Rue:");
				sss.setBounds(49, 69, 46, 14);
				panelStudio.add(sss);
				
				JLabel ss = new JLabel("N\u00B0 Rue:");
				ss.setBounds(49, 116, 46, 14);
				panelStudio.add(ss);
				
				JLabel lblNewLabel_1_2sss = new JLabel("Code Postale:");
				lblNewLabel_1_2sss.setBounds(251, 69, 94, 14);
				panelStudio.add(lblNewLabel_1_2sss);
				
				JLabel lblNewLabel_1_3ss = new JLabel("Localit\u00E9:");
				lblNewLabel_1_3ss.setBounds(251, 116, 60, 14);
				panelStudio.add(lblNewLabel_1_3ss);
				
				rueS = new JTextField();
				rueS.setBounds(142, 66, 86, 20);
				panelStudio.add(rueS);
				rueS.setColumns(10);
				
				numRueS = new JTextField();
				numRueS.setColumns(10);
				numRueS.setBounds(142, 113, 86, 20);
				panelStudio.add(numRueS);
				
				locS = new JTextField();
				locS.setColumns(10);
				locS.setBounds(339, 113, 86, 20);
				panelStudio.add(locS);
				
				codeS = new JTextField();
				codeS.setColumns(10);
				codeS.setBounds(339, 66, 86, 20);
				panelStudio.add(codeS);
				
				JLabel lblCaractristiquesss = new JLabel("Caract\u00E9ristiques:");
				lblCaractristiquesss.setForeground(new Color(51, 102, 255));
				lblCaractristiquesss.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCaractristiquesss.setBounds(20, 155, 192, 26);
				panelStudio.add(lblCaractristiquesss);
				
				JLabel ssssssssss = new JLabel("Superficie:");
				ssssssssss.setBounds(33, 204, 68, 14);
				panelStudio.add(ssssssssss);
				
				supS = new JTextField();
				supS.setColumns(10);
				supS.setBounds(152, 201, 86, 20);
				panelStudio.add(supS);
				
				JLabel lblNewLabel_1_2_1_1_111 = new JLabel("N° d'Etage:");
				lblNewLabel_1_2_1_1_111.setBounds(275, 204, 94, 14);
				panelStudio.add(lblNewLabel_1_2_1_1_111);
				
				etS = new JSpinner();
				etS.setBounds(379, 201, 46, 20);
				panelStudio.add(etS);
				
				JSeparator separator = new JSeparator();
				separator.setBounds(30, 55, 395, 89);
				panelStudio.add(separator);
				
				JSeparator separator_1 = new JSeparator();
				separator_1.setBounds(30, 187, 395, 50);
				panelStudio.add(separator_1);
				//
				rdbtnALouerS = new JRadioButton("A Louer");
				rdbtnALouerS.setBounds(213, 303, 86, 32);
				buttonGroupS.add(rdbtnALouerS);
				rdbtnALouerS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelAcheterS.setVisible(false);
						panelLouerS.setVisible(true);
					}
				});
				panelStudio.add(rdbtnALouerS);
				
				rdbtnAVendreS = new JRadioButton("A Vendre");
				rdbtnAVendreS.setBounds(109, 303, 86, 32);
				buttonGroupS.add(rdbtnAVendreS);
				rdbtnAVendreS.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelAcheterS.setVisible(true);
						panelLouerS.setVisible(false);
					}
				});
				panelStudio.add(rdbtnAVendreS);
				
				JLabel ascss = new JLabel("Pr\u00E9sence d'Ascenseur");
				ascss.setBounds(106, 243, 104, 50);
				panelStudio.add(ascss);
				
				chckbxAscS = new JCheckBox("");
				chckbxAscS.setBounds(251, 244, 60, 50);
				panelStudio.add(chckbxAscS);
				
				panelAcheterS = new JPanel();
				panelAcheterS.setBounds(0, 339, 468, 82);
				panelStudio.add(panelAcheterS);
				panelAcheterS.setLayout(null);
				
				JLabel lblNewLabel_1_4_1_2S = new JLabel("Prix d'Achat:");
				lblNewLabel_1_4_1_2S.setBounds(33, 13, 133, 14);
				panelAcheterS.add(lblNewLabel_1_4_1_2S);
				
				prixS = new JTextField();
				prixS.setColumns(10);
				prixS.setBounds(152, 10, 86, 20);
				panelAcheterS.add(prixS);
				
				JLabel lblNewLabel_1_4_1_2_1S = new JLabel("Etat:");
				lblNewLabel_1_4_1_2_1S.setBounds(33, 46, 133, 14);
				panelAcheterS.add(lblNewLabel_1_4_1_2_1S);
				
				etatS = new JComboBox();
				etatS.setModel(new DefaultComboBoxModel(new String[] {"", "A restaurer", "Correct", "Impeccable"}));
				etatS.setBounds(139, 43, 114, 20);
				panelAcheterS.add(etatS);
				
				panelLouerS = new JPanel();
				panelLouerS.setBounds(0, 339, 468, 82);
				panelStudio.add(panelLouerS);
				panelLouerS.setLayout(null);
				
				JLabel lblNewLabel_1_4_1S = new JLabel("Caution Locative:");
				lblNewLabel_1_4_1S.setBounds(26, 10, 119, 14);
				panelLouerS.add(lblNewLabel_1_4_1S);
				
				cautionS = new JTextField();
				cautionS.setColumns(10);
				cautionS.setBounds(147, 10, 86, 20);
				panelLouerS.add(cautionS);
				
				JLabel lblNewLabel_1_4_1_1S = new JLabel("Loyer Mensuel:");
				lblNewLabel_1_4_1_1S.setBounds(245, 10, 119, 14);
				panelLouerS.add(lblNewLabel_1_4_1_1S);
				
				loyerS = new JTextField();
				loyerS.setColumns(10);
				loyerS.setBounds(343, 10, 86, 20);
				panelLouerS.add(loyerS);
				
				JLabel lblNewLabel_1_4_1_21S = new JLabel("Charges Mensuels:");
				lblNewLabel_1_4_1_21S.setBounds(26, 47, 119, 14);
				panelLouerS.add(lblNewLabel_1_4_1_21S);
				
				chargeS = new JTextField();
				chargeS.setColumns(10);
				chargeS.setBounds(147, 47, 86, 20);
				panelLouerS.add(chargeS);
				
				JLabel lblNewLabel_1_4_1_1_1ss = new JLabel("Meubl\u00E9:");
				lblNewLabel_1_4_1_1_1ss.setBounds(245, 47, 51, 14);
				panelLouerS.add(lblNewLabel_1_4_1_1_1ss);
				
				chckbxMeubS = new JCheckBox("");
				chckbxMeubS.setBounds(343, 45, 97, 23);
				panelLouerS.add(chckbxMeubS);
				
				JButton btnEnregistrer_3 = new JButton("Enregistrer");
				btnEnregistrer_3.setBounds(339, 423, 117, 32);
				btnEnregistrer_3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insert(e);
					}
				});
				panelStudio.add(btnEnregistrer_3);
				
		//Panel Bureau

JLabel lblNewLabel1sb = new JLabel("Localisation:");
				lblNewLabel1sb.setForeground(new Color(51, 102, 255));
				lblNewLabel1sb.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblNewLabel1sb.setBounds(20, 26, 133, 26);
				panelBureau.add(lblNewLabel1sb);
				
				JLabel sssb = new JLabel("Rue:");
				sssb.setBounds(49, 69, 46, 14);
				panelBureau.add(sssb);
				
				JLabel ssb = new JLabel("N\u00B0 Rue:");
				ssb.setBounds(49, 116, 46, 14);
				panelBureau.add(ssb);
				
				JLabel bbb = new JLabel("Code Postale:");
				bbb.setBounds(251, 69, 94, 14);
				panelBureau.add(bbb);
				
				JLabel bbbbbbbbb = new JLabel("Localit\u00E9:");
				bbbbbbbbb.setBounds(251, 116, 60, 14);
				panelBureau.add(bbbbbbbbb);
				
				rueB = new JTextField();
				rueB.setBounds(142, 66, 86, 20);
				panelBureau.add(rueB);
				rueB.setColumns(10);
				
				numRueB = new JTextField();
				numRueB.setColumns(10);
				numRueB.setBounds(142, 113, 86, 20);
				panelBureau.add(numRueB);
				
				locB = new JTextField();
				locB.setColumns(10);
				locB.setBounds(339, 113, 86, 20);
				panelBureau.add(locB);
				
				codeB = new JTextField();
				codeB.setColumns(10);
				codeB.setBounds(339, 66, 86, 20);
				panelBureau.add(codeB);
				
				JLabel lblCaractristiqub = new JLabel("Caract\u00E9ristiques:");
				lblCaractristiqub.setForeground(new Color(51, 102, 255));
				lblCaractristiqub.setFont(new Font("Tahoma", Font.BOLD, 16));
				lblCaractristiqub.setBounds(20, 155, 192, 26);
				panelBureau.add(lblCaractristiqub);
				
				JLabel sb = new JLabel("Superficie:");
				sb.setBounds(33, 204, 68, 14);
				panelBureau.add(sb);
				
				supB = new JTextField();
				supB.setColumns(10);
				supB.setBounds(152, 201, 86, 20);
				panelBureau.add(supB);
				
				JLabel lblNewLabel_1_b = new JLabel("Nbr de Pieces");
				lblNewLabel_1_b.setBounds(275, 204, 94, 14);
				panelBureau.add(lblNewLabel_1_b);
				
				nbrPB = new JSpinner();
				nbrPB.setBounds(379, 201, 46, 20);
				panelBureau.add(nbrPB);
				
				JSeparator separator1 = new JSeparator();
				separator1.setBounds(30, 55, 395, 89);
				panelBureau.add(separator1);
				
				JSeparator separator_11 = new JSeparator();
				separator_11.setBounds(30, 187, 395, 50);
				panelBureau.add(separator_11);
				//
				rdbtnALouerB = new JRadioButton("A Louer");
				rdbtnALouerB.setBounds(259, 250, 86, 32);
				buttonGroupB.add(rdbtnALouerB);
				rdbtnALouerB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelAcheterB.setVisible(false);
						panelLouerB.setVisible(true);
					}
				});
				panelBureau.add(rdbtnALouerB);
				
				rdbtnAVendreB = new JRadioButton("A Vendre");
				rdbtnAVendreB.setBounds(114, 250, 86, 32);
				buttonGroupB.add(rdbtnAVendreB);
				rdbtnAVendreB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						panelAcheterB.setVisible(true);
						panelLouerB.setVisible(false);
					}
				});
				panelBureau.add(rdbtnAVendreB);
				
				panelAcheterB = new JPanel();
				panelAcheterB.setBounds(0, 339, 468, 82);
				panelBureau.add(panelAcheterB);
				panelAcheterB.setLayout(null);
				
				JLabel lblNewLabel_1_4_1_2B = new JLabel("Prix d'Achat:");
				lblNewLabel_1_4_1_2B.setBounds(33, 13, 133, 14);
				panelAcheterB.add(lblNewLabel_1_4_1_2B);
				
				prixB = new JTextField();
				prixB.setColumns(10);
				prixB.setBounds(152, 10, 86, 20);
				panelAcheterB.add(prixB);
				
				JLabel lblNewLabel_1_4_1_2_b = new JLabel("Etat:");
				lblNewLabel_1_4_1_2_b.setBounds(33, 46, 133, 14);
				panelAcheterB.add(lblNewLabel_1_4_1_2_b);
				
				etatB = new JComboBox();
				etatB.setModel(new DefaultComboBoxModel(new String[] {"", "A restaurer", "Correct", "Impeccable"}));
				etatB.setBounds(139, 43, 114, 20);
				panelAcheterB.add(etatB);
				
				panelLouerB = new JPanel();
				panelLouerB.setBounds(0, 339, 468, 82);
				panelBureau.add(panelLouerB);
				panelLouerB.setLayout(null);
				
				JLabel lblNewLabel_1_4_1S1 = new JLabel("Caution Locative:");
				lblNewLabel_1_4_1S1.setBounds(26, 10, 119, 14);
				panelLouerB.add(lblNewLabel_1_4_1S1);
				
				cautionB = new JTextField();
				cautionB.setColumns(10);
				cautionB.setBounds(147, 10, 86, 20);
				panelLouerB.add(cautionB);
				
				JLabel lblNewLabel_1_4_1_1S1 = new JLabel("Loyer Mensuel:");
				lblNewLabel_1_4_1_1S1.setBounds(245, 10, 119, 14);
				panelLouerB.add(lblNewLabel_1_4_1_1S1);
				
				loyerB = new JTextField();
				loyerB.setColumns(10);
				loyerB.setBounds(343, 10, 86, 20);
				panelLouerB.add(loyerB);
				
				JLabel lblNewLabel_1_4_1_21S1 = new JLabel("chargeB Mensuels:");
				lblNewLabel_1_4_1_21S1.setBounds(26, 47, 119, 14);
				panelLouerB.add(lblNewLabel_1_4_1_21S1);
				
				chargeB = new JTextField();
				chargeB.setColumns(10);
				chargeB.setBounds(147, 47, 86, 20);
				panelLouerB.add(chargeB);
				
				JLabel lblNewLabel_1_4_1_1_1ss1 = new JLabel("Meubl\u00E9:");
				lblNewLabel_1_4_1_1_1ss1.setBounds(245, 47, 51, 14);
				panelLouerB.add(lblNewLabel_1_4_1_1_1ss1);
				
				chckbxMeubB = new JCheckBox("");
				chckbxMeubB.setBounds(343, 45, 97, 23);
				panelLouerB.add(chckbxMeubB);
				
				JButton btnEnregistrer_1 = new JButton("Enregistrer");
				btnEnregistrer_1.setBounds(339, 423, 117, 32);
				btnEnregistrer_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						insert(e);
					}
				});
				panelBureau.add(btnEnregistrer_1);

		//Panel Entrepot

		JLabel lblNewLabel11 = new JLabel("Localisation:");
		lblNewLabel11.setForeground(new Color(51, 102, 255));
		lblNewLabel11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel11.setBounds(20, 26, 133, 26);
		panelEntrepot.add(lblNewLabel11);
		
		JLabel EE = new JLabel("Rue:");
		EE.setBounds(49, 69, 46, 14);
		panelEntrepot.add(EE);
		
		JLabel nomro = new JLabel("N\u00B0 Rue:");
		nomro.setBounds(49, 116, 46, 14);	
		panelEntrepot.add(nomro);
		
		JLabel codaE = new JLabel("Code Postale:");
		codaE.setBounds(251, 69, 94, 14);
		panelEntrepot.add(codaE);
		
		JLabel E = new JLabel("Localit\u00E9:");
		E.setBounds(251, 116, 60, 14);
		panelEntrepot.add(E);
		
		rueE = new JTextField();
		rueE.setBounds(142, 66, 86, 20);
		panelEntrepot.add(rueE);
		rueE.setColumns(10);
		
		numRueE = new JTextField();
		numRueE.setColumns(10);
		numRueE.setBounds(142, 113, 86, 20);
		panelEntrepot.add(numRueE);
		
		locE = new JTextField();
		locE.setColumns(10);
		locE.setBounds(339, 113, 86, 20);
		panelEntrepot.add(locE);
		
		codeE = new JTextField();
		codeE.setColumns(10);
		codeE.setBounds(339, 66, 86, 20);
		panelEntrepot.add(codeE);
		
		JLabel lblCaractristiques11 = new JLabel("Caract\u00E9ristiques:");
		lblCaractristiques11.setForeground(new Color(51, 102, 255));
		lblCaractristiques11.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaractristiques11.setBounds(20, 155, 192, 26);
		panelEntrepot.add(lblCaractristiques11);
		
		JLabel lblNewLabel_1_411 = new JLabel("Superficie:");
		lblNewLabel_1_411.setBounds(33, 204, 68, 14);
		panelEntrepot.add(lblNewLabel_1_411);
		
		supE = new JTextField();
		supE.setColumns(10);
		supE.setBounds(152, 201, 86, 20);
		panelEntrepot.add(supE);
		
		JSeparator separator11 = new JSeparator();
		separator11.setBounds(30, 55, 395, 89);
		panelEntrepot.add(separator11);
		
		JSeparator separator_111 = new JSeparator();
		separator_111.setBounds(30, 187, 395, 5);
		panelEntrepot.add(separator_111);
		
		//

		rdbtnALouerE = new JRadioButton("A Louer");
		rdbtnALouerE.setBounds(213, 303, 86, 32);
		buttonGroupE.add(rdbtnALouerE);
		rdbtnALouerE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterE.setVisible(false);
				panelLouerE.setVisible(true);
			}
		});
		panelEntrepot.add(rdbtnALouerE);
		
		rdbtnAVendreE = new JRadioButton("A Vendre");
		rdbtnAVendreE.setBounds(109, 303, 86, 32);
		buttonGroupE.add(rdbtnAVendreE);
		rdbtnAVendreE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelAcheterE.setVisible(true);
				panelLouerE.setVisible(false);
			}
		});
		panelEntrepot.add(rdbtnAVendreE);
		
		panelAcheterE = new JPanel();
		panelAcheterE.setBounds(0, 339, 468, 82);
		panelEntrepot.add(panelAcheterE);
		panelAcheterE.setLayout(null);
		
		JLabel eeeeeeeeeee = new JLabel("Prix d'Achat:");
		eeeeeeeeeee.setBounds(33, 13, 133, 14);
		panelAcheterE.add(eeeeeeeeeee);
		
		prixE = new JTextField();
		prixE.setColumns(10);
		prixE.setBounds(152, 10, 86, 20);
		panelAcheterE.add(prixE);
		
		JLabel lblNewLabel_1_4_1_2_1E = new JLabel("Etat:");
		lblNewLabel_1_4_1_2_1E.setBounds(33, 46, 133, 14);
		panelAcheterE.add(lblNewLabel_1_4_1_2_1E);
		//
		etatE = new JComboBox();
		etatE.setModel(new DefaultComboBoxModel(new String[] {"", "A restaurer", "Correct", "Impeccable"}));
		etatE.setBounds(139, 43, 114, 20);
		panelAcheterE.add(etatE);
		
		panelLouerE = new JPanel();
		panelLouerE.setBounds(0, 339, 468, 82);
		panelEntrepot.add(panelLouerE);
		panelLouerE.setLayout(null);
		
		JLabel lblNewLabel_1_4_1E = new JLabel("Caution Locative:");
		lblNewLabel_1_4_1E.setBounds(26, 10, 119, 14);
		panelLouerE.add(lblNewLabel_1_4_1E);
		
		cautionE = new JTextField();
		cautionE.setColumns(10);
		cautionE.setBounds(147, 10, 86, 20);
		panelLouerE.add(cautionE);
		
		JLabel lblNewLabel_1_4_1_1E = new JLabel("Loyer Mensuel:");
		lblNewLabel_1_4_1_1E.setBounds(245, 10, 119, 14);
		panelLouerE.add(lblNewLabel_1_4_1_1E);
		
		loyerE = new JTextField();
		loyerE.setColumns(10);
		loyerE.setBounds(343, 10, 86, 20);
		panelLouerE.add(loyerE);
		
		JLabel lblNewLabel_1_4_1_21E = new JLabel("Charges Mensuels:");
		lblNewLabel_1_4_1_21E.setBounds(26, 47, 119, 14);
		panelLouerE.add(lblNewLabel_1_4_1_21E);
		
		chargeE = new JTextField();
		chargeE.setColumns(10);
		chargeE.setBounds(147, 47, 86, 20);
		panelLouerE.add(chargeE);
		
		JButton btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.setBounds(339, 423, 117, 32);
		btnEnregistrer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert(e);
			}
		});
		panelEntrepot.add(btnEnregistrer);
		
		
		//Panel Terrain
		JLabel lOCaT = new JLabel("Localisation:");
		lOCaT.setForeground(new Color(51, 102, 255));
		lOCaT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lOCaT.setBounds(20, 26, 133, 26);
		panelTerrain.add(lOCaT);
		
		JLabel dfdsdf = new JLabel("Rue:");
		dfdsdf.setBounds(49, 69, 46, 14);
		panelTerrain.add(dfdsdf);
		
		JLabel nomrodd = new JLabel("N\u00B0 Rue:");
		nomrodd.setBounds(49, 116, 46, 14);
		panelTerrain.add(nomrodd);
		
		JLabel codaT = new JLabel("Code Postale:");
		codaT.setBounds(251, 69, 94, 14);
		panelTerrain.add(codaT);
		
		JLabel TT = new JLabel("Localit\u00E9:");
		TT.setBounds(251, 116, 60, 14);
		panelTerrain.add(TT);
		
		rueT = new JTextField();
		rueT.setBounds(142, 66, 86, 20);
		panelTerrain.add(rueT);
		rueT.setColumns(10);
		
		numRueT = new JTextField();
		numRueT.setColumns(10);
		numRueT.setBounds(142, 113, 86, 20);
		panelTerrain.add(numRueT);
		
		locT = new JTextField();
		locT.setColumns(10);
		locT.setBounds(339, 113, 86, 20);
		panelTerrain.add(locT);
		
		codeT = new JTextField();
		codeT.setColumns(10);
		codeT.setBounds(339, 66, 86, 20);
		panelTerrain.add(codeT);
		
		JLabel lblCaractristiquesT = new JLabel("Caract\u00E9ristiques:");
		lblCaractristiquesT.setForeground(new Color(51, 102, 255));
		lblCaractristiquesT.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCaractristiquesT.setBounds(20, 155, 192, 26);
		panelTerrain.add(lblCaractristiquesT);
		
		JLabel lblNewLabelT = new JLabel("Superficie:");
		lblNewLabelT.setBounds(33, 204, 68, 14);
		panelTerrain.add(lblNewLabelT);
		
		supT = new JTextField();
		supT.setColumns(10);
		supT.setBounds(152, 201, 86, 20);
		panelTerrain.add(supT);
		
		JSeparator separator111 = new JSeparator();
		separator111.setBounds(30, 55, 395, 89);
		panelTerrain.add(separator111);
		
		JSeparator separator_1111 = new JSeparator();
		separator_1111.setBounds(30, 187, 395, 5);
		panelTerrain.add(separator_1111);
		JLabel lblNewLabel_T = new JLabel("Prix:");
		lblNewLabel_T.setBounds(33, 248, 68, 14);
		panelTerrain.add(lblNewLabel_T);
		
		prixT = new JTextField();
		prixT.setColumns(10);
		prixT.setBounds(152, 252, 86, 20);
		panelTerrain.add(prixT);
		
		JButton btnEnregistrer_2 = new JButton("Enregistrer");
		btnEnregistrer_2.setBounds(339, 423, 117, 32);
		btnEnregistrer_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insert(e);
			}
		});
		panelTerrain.add(btnEnregistrer_2);
		
		panelMaison.setVisible(false);
		panelAppartement.setVisible(false);
		panelStudio.setVisible(false);
		panelBureau.setVisible(false);
		panelTerrain.setVisible(false);
		panelEntrepot.setVisible(false);
		
		panelAcheterA.setVisible(false);
		panelLouerA.setVisible(false);
		panelAcheterM.setVisible(false);
		panelLouerM.setVisible(false);
		panelAcheterS.setVisible(false);
		panelLouerS.setVisible(false);
		panelAcheterB.setVisible(false);
		panelLouerB.setVisible(false);
		panelAcheterE.setVisible(false);
		panelLouerE.setVisible(false);
	}
	private void insert(ActionEvent e) {
		try {
			int code;
			Connection con = MysqlConnection.con();
			Statement stmnt = con.createStatement();
			if ((panelMaison.isVisible())&&(rdbtnAVendreM.isSelected())) {
				String sql="SELECT Count(*) FROM classe where Type='Maison' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixM.getText())+" and SuperficieMin<="+Double.parseDouble(supM.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Maison");
					pstmt.setString(2, "A vendre");
					pstmt.setDouble(3, Double.parseDouble(prixM.getText()));
					pstmt.setDouble(4, Double.parseDouble(supM.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Maison' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixM.getText())+" and SuperficieMin<="+Double.parseDouble(supM.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,PrixDemande,Etat,NombreChambres,NombreGarages,CuisineEquipe,SuperficieJardin,NombreEtages,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueM.getText()));
				ps.setString(5, rueM.getText());
				ps.setInt(6, Integer.parseInt(codeM.getText()));
				ps.setString(7, locM.getText());
				ps.setInt(8, idProp);
				ps.setDouble(9, Double.parseDouble(prixM.getText()));
				ps.setString(10,String.valueOf(etatM.getSelectedItem()));
				ps.setInt(11,(int) chM.getValue());
				ps.setInt(12, (int)garM.getValue());
				ps.setBoolean(13,chckbxCuisM.isSelected());
				ps.setDouble(14, Double.parseDouble(supJarM.getText()));
				ps.setInt(15, (int)etM.getValue());
				ps.setDouble(16, Double.parseDouble(supM.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			else if ((panelMaison.isVisible())&&(rdbtnAVendreM.isSelected()==false)) {
				String sql="SELECT Count(*) FROM classe where Type='Maison' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerM.getText())+" and SuperficieMin<="+Double.parseDouble(supM.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Maison");
					pstmt.setString(2, "A louer");
					pstmt.setDouble(3, Double.parseDouble(loyerM.getText()));
					pstmt.setDouble(4, Double.parseDouble(supM.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Maison' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerM.getText())+" and SuperficieMin<="+Double.parseDouble(supM.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,Meuble,MontantCautionLocative,LoyerMensuel,ChargeMensuel,NombreChambres,NombreGarages,CuisineEquipe,SuperficieJardin,NombreEtages,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueM.getText()));
				ps.setString(5, rueM.getText());
				ps.setInt(6, Integer.parseInt(codeM.getText()));
				ps.setString(7, locM.getText());
				ps.setInt(8, idProp);
				ps.setBoolean(9, chckbxMeubM.isSelected());
				ps.setDouble(10, Double.parseDouble(cautionM.getText()));
				ps.setDouble(11, Double.parseDouble(loyerM.getText()));
				ps.setDouble(12, Double.parseDouble(chargeM.getText()));
				ps.setInt(13,(int) chM.getValue());
				ps.setInt(14, (int)garM.getValue());
				ps.setBoolean(15,chckbxCuisM.isSelected());
				ps.setDouble(16, Double.parseDouble(supJarM.getText()));
				ps.setInt(17, (int)etM.getValue());
				ps.setDouble(18, Double.parseDouble(supM.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			
			
			else if ((panelAppartement.isVisible())&&(rdbtnAVendreA.isSelected())) {
				String sql="SELECT Count(*) FROM classe where Type='Appartement' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixA.getText())+" and SuperficieMin<="+Double.parseDouble(supApp.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Appartement");
					pstmt.setString(2, "A vendre");
					pstmt.setDouble(3, Double.parseDouble(prixA.getText()));
					pstmt.setDouble(4, Double.parseDouble(supApp.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Appartement' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixA.getText())+" and SuperficieMin<="+Double.parseDouble(supApp.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,PrixDemande,Etat,NombreChambres,Ascenseur,CuisineEquipe,EtageDeLocal,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueApp.getText()));
				ps.setString(5, rueApp.getText());
				ps.setInt(6, Integer.parseInt(codeApp.getText()));
				ps.setString(7, locApp.getText());
				ps.setInt(8, idProp);
				ps.setDouble(9, Double.parseDouble(prixA.getText()));
				ps.setString(10,String.valueOf(etatA.getSelectedItem()));
				ps.setInt(11,(int) chApp.getValue());
				ps.setBoolean(12, chckbxAsc.isSelected());
				ps.setBoolean(13,chckbxA.isSelected());
				ps.setInt(14, (int)etApp.getValue());
				ps.setDouble(15, Double.parseDouble(supApp.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			else if ((panelAppartement.isVisible())&&(rdbtnAVendreA.isSelected()==false)) {
				String sql="SELECT Count(*) FROM classe where Type='Appartement' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerA.getText())+" and SuperficieMin<="+Double.parseDouble(supApp.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Appartement");
					pstmt.setString(2, "A louer");
					pstmt.setDouble(3, Double.parseDouble(loyerA.getText()));
					pstmt.setDouble(4, Double.parseDouble(supApp.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Appartement' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerA.getText())+" and SuperficieMin<="+Double.parseDouble(supApp.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,Meuble,MontantCautionLocative,LoyerMensuel,ChargeMensuel,NombreChambres,Ascenseur,CuisineEquipe,EtageDeLocal,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueApp.getText()));
				ps.setString(5, rueApp.getText());
				ps.setInt(6, Integer.parseInt(codeApp.getText()));
				ps.setString(7, locApp.getText());
				ps.setInt(8, idProp);
				ps.setBoolean(9, chckbxMeubA.isSelected());
				ps.setDouble(10, Double.parseDouble(cautionA.getText()));
				ps.setDouble(11, Double.parseDouble(loyerA.getText()));
				ps.setDouble(12, Double.parseDouble(chargeA.getText()));
				ps.setInt(13,(int) chApp.getValue());
				ps.setBoolean(14, chckbxAsc.isSelected());
				ps.setBoolean(15,chckbxA.isSelected());
				ps.setInt(16, (int)etApp.getValue());
				ps.setDouble(17, Double.parseDouble(supApp.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			
			
			else if ((panelStudio.isVisible())&&(rdbtnAVendreS.isSelected())) {
				String sql="SELECT Count(*) FROM classe where Type='Studio' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixS.getText())+" and SuperficieMin<="+Double.parseDouble(supS.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Studio");
					pstmt.setString(2, "A vendre");
					pstmt.setDouble(3, Double.parseDouble(prixS.getText()));
					pstmt.setDouble(4, Double.parseDouble(supS.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Studio' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixS.getText())+" and SuperficieMin<="+Double.parseDouble(supS.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,PrixDemande,Etat,Ascenseur,EtageDeLocal,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueS.getText()));
				ps.setString(5, rueS.getText());
				ps.setInt(6, Integer.parseInt(codeS.getText()));
				ps.setString(7, locS.getText());
				ps.setInt(8, idProp);
				ps.setDouble(9, Double.parseDouble(prixS.getText()));
				ps.setString(10,String.valueOf(etatS.getSelectedItem()));
				ps.setBoolean(11, chckbxAscS.isSelected());
				ps.setInt(12, (int)etS.getValue());
				ps.setDouble(13, Double.parseDouble(supS.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			else if ((panelStudio.isVisible())&&(rdbtnAVendreS.isSelected()==false)) {
				String sql="SELECT Count(*) FROM classe where Type='Studio' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerS.getText())+" and SuperficieMin<="+Double.parseDouble(supS.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Studio");
					pstmt.setString(2, "A louer");
					pstmt.setDouble(3, Double.parseDouble(loyerS.getText()));
					pstmt.setDouble(4, Double.parseDouble(supS.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Studio' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerS.getText())+" and SuperficieMin<="+Double.parseDouble(supS.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,Meuble,MontantCautionLocative,LoyerMensuel,ChargeMensuel,Ascenseur,EtageDeLocal,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueS.getText()));
				ps.setString(5, rueS.getText());
				ps.setInt(6, Integer.parseInt(codeS.getText()));
				ps.setString(7, locS.getText());
				ps.setInt(8, idProp);
				ps.setBoolean(9, chckbxMeubS.isSelected());
				ps.setDouble(10, Double.parseDouble(cautionS.getText()));
				ps.setDouble(11, Double.parseDouble(loyerS.getText()));
				ps.setDouble(12, Double.parseDouble(chargeS.getText()));
				ps.setBoolean(13, chckbxAscS.isSelected());
				ps.setInt(14, (int)etS.getValue());
				ps.setDouble(15, Double.parseDouble(supS.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			
			
			else if ((panelBureau.isVisible())&&(rdbtnAVendreB.isSelected())) {
				String sql="SELECT Count(*) FROM classe where Type='Bureau' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixB.getText())+" and SuperficieMin<="+Double.parseDouble(supB.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Bureau");
					pstmt.setString(2, "A vendre");
					pstmt.setDouble(3, Double.parseDouble(prixB.getText()));
					pstmt.setDouble(4, Double.parseDouble(supB.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Bureau' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixB.getText())+" and SuperficieMin<="+Double.parseDouble(supB.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,PrixDemande,Etat,NbrComposants,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueB.getText()));
				ps.setString(5, rueB.getText());
				ps.setInt(6, Integer.parseInt(codeB.getText()));
				ps.setString(7, locB.getText());
				ps.setInt(8, idProp);
				ps.setDouble(9, Double.parseDouble(prixB.getText()));
				ps.setString(10,String.valueOf(etatB.getSelectedItem()));
				ps.setInt(11, (int)nbrPB.getValue());
				ps.setDouble(12, Double.parseDouble(supB.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			else if ((panelBureau.isVisible())&&(rdbtnAVendreS.isSelected()==false)) {
				String sql="SELECT Count(*) FROM classe where Type='Bureau' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerB.getText())+" and SuperficieMin<="+Double.parseDouble(supB.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Bureau");
					pstmt.setString(2, "A louer");
					pstmt.setDouble(3, Double.parseDouble(loyerB.getText()));
					pstmt.setDouble(4, Double.parseDouble(supB.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Bureau' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerB.getText())+" and SuperficieMin<="+Double.parseDouble(supB.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,Meuble,MontantCautionLocative,LoyerMensuel,ChargeMensuel,NbrComposants,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueB.getText()));
				ps.setString(5, rueB.getText());
				ps.setInt(6, Integer.parseInt(codeB.getText()));
				ps.setString(7, locB.getText());
				ps.setInt(8, idProp);
				ps.setBoolean(9, chckbxMeubB.isSelected());
				ps.setDouble(10, Double.parseDouble(cautionB.getText()));
				ps.setDouble(11, Double.parseDouble(loyerB.getText()));
				ps.setDouble(12, Double.parseDouble(chargeB.getText()));
				ps.setInt(13, (int)nbrPB.getValue());
				ps.setDouble(14, Double.parseDouble(supB.getText()));
				ps.execute();	
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			
			else if ((panelEntrepot.isVisible())&&(rdbtnAVendreE.isSelected())) {
				String sql="SELECT Count(*) FROM classe where Type='Entrepot' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixE.getText())+" and SuperficieMin<="+Double.parseDouble(supE.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Entrepot");
					pstmt.setString(2, "A vendre");
					pstmt.setDouble(3, Double.parseDouble(prixE.getText()));
					pstmt.setDouble(4, Double.parseDouble(supE.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Entrepot' and ModeOffre='A vendre' and PrixMax>="+Double.parseDouble(prixE.getText())+" and SuperficieMin<="+Double.parseDouble(supE.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,PrixDemande,Etat,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueE.getText()));
				ps.setString(5, rueE.getText());
				ps.setInt(6, Integer.parseInt(codeE.getText()));
				ps.setString(7, locE.getText());
				ps.setInt(8, idProp);
				ps.setDouble(9, Double.parseDouble(prixE.getText()));
				ps.setString(10,String.valueOf(etatE.getSelectedItem()));
				ps.setDouble(11, Double.parseDouble(supE.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			else if ((panelEntrepot.isVisible())&&(rdbtnAVendreE.isSelected()==false)) {
				String sql="SELECT Count(*) FROM classe where Type='Entrepot' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerE.getText())+" and SuperficieMin<="+Double.parseDouble(supE.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Entrepot");
					pstmt.setString(2, "A louer");
					pstmt.setDouble(3, Double.parseDouble(loyerE.getText()));
					pstmt.setDouble(4, Double.parseDouble(supE.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Entrepot' and ModeOffre='A louer' and PrixMax>="+Double.parseDouble(loyerE.getText())+" and SuperficieMin<="+Double.parseDouble(supE.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,MontantCautionLocative,LoyerMensuel,ChargeMensuel,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueE.getText()));
				ps.setString(5, rueE.getText());
				ps.setInt(6, Integer.parseInt(codeE.getText()));
				ps.setString(7, locE.getText());
				ps.setInt(8, idProp);
				ps.setDouble(9, Double.parseDouble(cautionE.getText()));
				ps.setDouble(10, Double.parseDouble(loyerE.getText()));
				ps.setDouble(11, Double.parseDouble(chargeE.getText()));
				ps.setDouble(12, Double.parseDouble(supE.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			
			else if (panelTerrain.isVisible()) {
				String sql="SELECT Count(*) FROM classe where Type='Terrain' and PrixMax>="+Double.parseDouble(prixT.getText())+" and SuperficieMin<="+Double.parseDouble(supT.getText())+" ;";
				ResultSet res=stmnt.executeQuery(sql);
				res.next();
				int n=(res.getInt("COUNT(*)"));
				if (n==0) {
					sql="INSERT INTO classe(Type, ModeOffre, PrixMax, SuperficieMin) Values(?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, "Terrain");
					pstmt.setString(2, "A vendre");
					pstmt.setDouble(3, Double.parseDouble(prixT.getText()));
					pstmt.setDouble(4, Double.parseDouble(supT.getText()));
					pstmt.execute();
				}
				sql="SELECT code FROM classe where Type='Terrain' and PrixMax>="+Double.parseDouble(prixT.getText())+" and SuperficieMin<="+Double.parseDouble(supT.getText())+" ;";
				res=stmnt.executeQuery(sql);
				res.next();
				code=(res.getInt("code"));
				sql="INSERT INTO bien(Status,Code,Date,NumRue,Rue,CodePostale,Local,idProp,PrixDemande,Superficie) VALUES(?,?,?,?,?,?,?,?,?,?) ;";
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, "A vendre");
				ps.setInt(2,code);
				ps.setDate(3, java.sql.Date.valueOf(java.time.LocalDate.now()));
				ps.setInt(4, Integer.parseInt(numRueT.getText()));
				ps.setString(5, rueT.getText());
				ps.setInt(6, Integer.parseInt(codeT.getText()));
				ps.setString(7, locT.getText());
				ps.setInt(8, idProp);
				ps.setDouble(9, Double.parseDouble(prixT.getText()));
				ps.setDouble(10, Double.parseDouble(supT.getText()));
				ps.execute();
				JOptionPane.showMessageDialog(null,"Bien enregistré avec succes");
				this.setVisible(false);
				Menu m=new Menu();
				m.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(null,"Probleme dans la base");
			con.close();
		}
		catch(Exception e1) {
			System.out.println(e1);
			JOptionPane.showMessageDialog(null,"Probleme dans la base");
		}
		
	}
}
