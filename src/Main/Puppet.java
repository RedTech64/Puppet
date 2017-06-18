package Main;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import Message.NameInput;
import Message.PuppetinessInput;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Puppet extends JPanel {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name = "";
	private int p = 0;
	private JButton btnSave = new JButton("Save");
	private JLabel lblPuppetiness = new JLabel("Puppetiness");
	private JLabel lblName = new JLabel("Puppet Name");
	private JLabel lblNameValue = new JLabel("New Puppet");
	private JLabel lblPuppetinessValue = new JLabel("50%");
	private JButton btnEditName = new JButton("Edit Name");
	private JButton btnEditPuppetiness = new JButton("Edit Puppetiness");
	private JButton btnDelete = new JButton("Delete Puppet");
	
	public Puppet() {
		super();
		id = Save.getID();
		launch();
	}
	
	public Puppet(Puppet p) {
		super();
		//this.id = p.getID();
		this.p = p.getPuppetiness();
		this.name = p.getName();
		
		lblNameValue.setText(name);
		lblPuppetinessValue.setText(this.p+"%");
		setName(name);
		
		launch();
	}
	
	public void launch() {
		this.setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNameValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPuppetiness.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPuppetinessValue.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		this.add(btnSave, "cell 4 9,grow");
		this.add(lblName, "cell 4 1,alignx center,aligny bottom");
		this.add(lblPuppetinessValue, "cell 4 6,alignx center,aligny top");
		this.add(btnEditPuppetiness, "cell 4 7,alignx center,aligny top");
		this.add(lblPuppetiness, "cell 4 5,alignx center,aligny bottom");
		this.add(lblNameValue, "cell 4 2,alignx center,aligny top");
		this.add(btnEditName, "cell 4 3,alignx center,aligny top");
		this.add(btnDelete, "cell 4 10,alignx center,aligny center");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setName(name);
				Application.getTabbedPane().setTitleAt(Application.getTabbedPane().getSelectedIndex(), name);
				Save.save();
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Save.clear(getID());
				Application.getTabbedPane().removeTabAt(Application.getTabbedPane().getSelectedIndex());
				Application.getPuppetAmount().setText("You have " + (Application.getTabbedPane().getTabCount()-2) + " puppets!");
				Save.save();
				Message.Log.EVENT.send("Puppet " + name + " deleted.");
			}
		});
		btnEditPuppetiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p = PuppetinessInput.getName();
				lblPuppetinessValue.setText(p+"%");
				Message.Log.EVENT.send("Puppet " + name + " puppetiness value changed to " + p+"%");
			}
		});
		
		btnEditName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldName = name;
				name = NameInput.getName();
				lblNameValue.setText(name);
				Message.Log.EVENT.send("Puppet " + oldName + " changed to " + name + ".");
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