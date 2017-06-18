package Main;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;

	private static JTabbedPane tabbedPane;
	
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
		setTitle("Puppet Creator");
		//this.setMaximumSize(new Dimension(1000,1000));
		//this.setMinimumSize(new Dimension(400, 400));
		
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
		tabMain.add(btnCreate, "cell 4 5,grow");
		
		
		
		//Settings Tab
		tabSettings = new JPanel();
		tabSettings.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][]"));
		tabbedPane.addTab("Settings", null, tabSettings, null);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 20));
		tabSettings.add(btnReset, "cell 4 7,growx");
		
		Save.loadTabs();
		
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
				Message.ConfirmDialoge dialoge = new Message.ConfirmDialoge("Are you sure you want to delete all puppets?");
				if(dialoge.confirmed()) {
					Save.reset();
				}
			}
		});
		
		
	}

	public static JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
}
