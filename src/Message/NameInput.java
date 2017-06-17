package Message;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

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
