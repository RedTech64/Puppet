import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Puppet extends JPanel {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int p;
	private JButton btnSave = new JButton("Save");
	private JLabel lblPuppetiness = new JLabel("Puppetiness");
	private JLabel lblName = new JLabel("Puppet Name");
	private JLabel lblNameValue = new JLabel("Name Puppet");
	private JLabel lblPuppetinessValue = new JLabel("50%");
	private JButton btnEditName = new JButton("Edit Name");
	private JButton btnEditPuppetiness = new JButton("Edit Puppetiness");
	
	public Puppet() {
		super();
		id = Save.getID();
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		btnSave.setText("Save");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		lblNameValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		lblPuppetiness.setFont(new Font("Tahoma", Font.PLAIN, 22));
	
		lblPuppetinessValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		this.add(btnSave, "cell 4 9,grow");
		this.add(lblName, "cell 4 1,grow");
		add(lblPuppetinessValue, "cell 4 6,grow");
		add(btnEditPuppetiness, "cell 4 7,alignx center,aligny center");
		this.add(lblPuppetiness, "cell 4 5,grow");
		add(lblNameValue, "cell 4 2,grow");
		add(btnEditName, "cell 4 3,alignx center,aligny center");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Save.save();
			}
		});
		
		btnEditPuppetiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = PuppetinessInput.getName();
				lblPuppetinessValue.setText(p+"%");
			}
		});
		
		btnEditName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name = NameInput.getName();
				lblNameValue.setText(name);
			}
		});
	}
	public String getName() {
		return lblNameValue.getText();
	}
	
	public int getPuppetiness() {
		return p;
	}
	
	public int getID() {
		return id;
	}
	
	public void remove() {
		Save.clear(id);
	}
}