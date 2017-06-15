import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class Application extends JFrame {

	private static final long serialVersionUID = 1L;

	private JTabbedPane tabbedPane;
	
	private JPanel contentPane;
	
	private JPanel tabMain;
	private JPanel tabSettings;
	
	private JLabel lblPuppet;
	private JLabel lblSlider;
	
	private JButton btnOne;
	private JButton btnTwo;
	
	private JSlider slider;
	private JTextArea textArea;
	private JLabel label;
	private JLabel lblPuppetiness;
	
	public Application() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 520);
		setTitle("Puppet");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);
		
		tabMain = new JPanel();
		tabbedPane.addTab("Puppet", null, tabMain, null);
		tabMain.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][]"));
		
		tabSettings = new JPanel();
		tabbedPane.addTab("Settings", null, tabSettings, null);
		tabSettings.setLayout(new MigLayout("", "[]", "[]"));
		
		lblPuppet = new JLabel("Welcome to the Puppet!");
		lblPuppet.setFont(new Font("Tahoma", Font.BOLD, 38));
		tabMain.add(lblPuppet, "cell 2 1 5 1,alignx center,aligny center");
		
		label = new JLabel("Puppet Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabMain.add(label, "cell 3 3 3 1,alignx center,aligny bottom");
		
		textArea = new JTextArea();
		tabMain.add(textArea, "cell 3 4 3 1,growx,aligny center");
		
		lblSlider = new JLabel("Puppetiness");
		lblSlider.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tabMain.add(lblSlider, "cell 3 9 3 1,alignx center");
		
		btnOne = new JButton("Puppetiness");

		tabMain.add(btnOne, "cell 3 6,grow");
		
		btnTwo = new JButton("Puppet Name");
		tabMain.add(btnTwo, "cell 5 6,grow");
		
		
		slider = new JSlider();
		
		tabMain.add(slider, "cell 3 10 3 1,alignx center");
		
		lblPuppetiness = new JLabel("50%");
		tabMain.add(lblPuppetiness, "cell 4 11,alignx center,aligny center");
		
		
		btnOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Your puppetiness is " + slider.getValue() + "%");
			}
		});
		
		btnTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(contentPane, "Your puppet name is " + textArea.getText());
			}
		});
		
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				lblPuppetiness.setText(slider.getValue()+"%");
			}
		});
	}
}
