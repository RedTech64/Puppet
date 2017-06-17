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
	JButton btnSave = new JButton();
	JLabel lblPuppetiness = new JLabel();
	JLabel lblName = new JLabel();
	JLabel lblValue = new JLabel();
	JSlider slider = new JSlider();
	JTextArea text = new JTextArea();
	
	public Puppet() {
		super();
		id = Save.getID();
		setLayout(new MigLayout("", "[grow][grow][grow][grow][grow][grow][grow][grow][grow]", "[grow][grow][grow][grow][grow][grow][][grow][grow][grow][][grow][grow][]"));
		
		lblPuppetiness.setText("Puppetiness");
		lblName.setText("Puppet Name");
		lblValue.setText("50%");
		btnSave.setText("Save");
		
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPuppetiness.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblValue.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		this.add(btnSave, "cell 4 12,grow");
		this.add(lblPuppetiness, "cell 4 8,alignx center");
		this.add(lblName, "cell 4 6,alignx center");
		this.add(lblValue, "cell 4 10,alignx center");
		this.add(slider, "cell 4 9,alignx center");
		this.add(text, "cell 4 7,growx,aligny center");
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				lblValue.setText(slider.getValue()+"%");
			}
		});
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Save.save();
				getParent().setName(text.getText());
			}
		});
	}
	public String getName() {
		return lblName.getText();
	}
	
	public int getPuppetiness() {
		return slider.getValue();
	}
	
	public int getID() {
		return id;
	}
	
	public void remove() {
		Save.clear(id);
	}
}