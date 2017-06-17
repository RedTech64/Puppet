import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTextArea;

import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class NameInput {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static String getName() {
		
		JLabel label = new JLabel("Puppet Name:");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));

		return JOptionPane.showInputDialog(null, label);
	}
}
