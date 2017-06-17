import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;
import java.awt.Color;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTabbedPane tabbedPane;
	
	private JPanel contentPane;
	
	private JPanel tabMain;
	private JPanel tabSettings;
	
	private JLabel lblPuppet;
	
	private JButton btnCreate;
	private JButton btnReset;
	private JLabel lblPuppetiness;
	private JLabel lblYouHave;
	
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 520);
		setTitle("Puppet");
		
		//Content Pane
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		setContentPane(contentPane);
		
		//Tabbed Pane
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		//Main Tab
		tabMain = new JPanel();
		lblPuppet = new JLabel("Welcome to Puppet Creator!");
		lblPuppetiness = new JLabel("50%");
		lblYouHave = new JLabel("You have  ");
		btnCreate = new JButton("Create new Puppet");
		btnReset = new JButton("Reset");
		
		tabMain.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][]"));
		
		
		lblPuppet.setFont(new Font("Tahoma", Font.BOLD, 35));
		
		tabMain.add(lblPuppet, "cell 2 1 5 1,alignx center,aligny center");
		tabMain.add(lblPuppetiness, "cell 3 11 3 1,alignx center,aligny center");
		
		tabbedPane.addTab("Puppet", null, tabMain, null);
		

		
		lblYouHave.setFont(new Font("Tahoma", Font.BOLD, 18));
		tabMain.add(lblYouHave, "cell 4 3");
		
		btnCreate.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabMain.add(btnCreate, "cell 4 5,growx,aligny center");
		
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabMain.add(btnReset, "cell 4 7,growx,aligny center");
		
		//Settings Tab
		tabSettings = new JPanel();
		tabSettings.setLayout(new MigLayout("", "[]", "[]"));
		tabbedPane.addTab("Settings", null, tabSettings, null);
		
		loadTabs();
		
		//Listeners
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			Puppet tab = new Puppet();
				tabbedPane.add(tab);
				Save.add(tab);
			}
		});
		
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Save.reset();
			}
		});
		
		
	}

	private void loadTabs() {
		Save.load();
		ArrayList<Puppet> list = Save.getList();
		
		for(Puppet p : list) {
			tabbedPane.add(p);
		}
	}
}
