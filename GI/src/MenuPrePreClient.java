import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrePreClient extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrePreClient frame = new MenuPrePreClient();
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
	public MenuPrePreClient() {
		setResizable(false);
		setTitle("Menu pour le Client");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(420, 150, 541, 406);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRecherche = new JButton("Recherche d'immobilier");
		btnRecherche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				MenuPreClient mc=new MenuPreClient();
				mc.setVisible(true);
			}
		});
		btnRecherche.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRecherche.setBounds(116, 69, 260, 85);
		contentPane.add(btnRecherche);
		
		JButton btnFinalisationDunContrat = new JButton("Finalisation d'un contrat");
		btnFinalisationDunContrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				Finalisation fn=new Finalisation();
				fn.setVisible(true);
			}
		});
		btnFinalisationDunContrat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFinalisationDunContrat.setBounds(116, 187, 260, 85);
		contentPane.add(btnFinalisationDunContrat);
		
		JButton retourButton = new JButton("Retourner");
		retourButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		retourButton.setBounds(27, 310, 104, 31);
		contentPane.add(retourButton);
		retourButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame[] f=getFrames();
				f[f.length-1].dispose();
				Menu m=new Menu();
				m.setVisible(true);
			}
		});
	}
}
