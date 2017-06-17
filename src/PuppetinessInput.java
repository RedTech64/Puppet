import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class PuppetinessInput {
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static int getName() {
		JFrame frame = new JFrame();
		JOptionPane pane = new JOptionPane();
		
		JLabel label = new JLabel("Puppetiness:");
		JLabel value = new JLabel("50%");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		JSlider slider = new JSlider();
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				value.setText(slider.getValue()+"%");
				pane.setInputValue(slider.getValue());
			}
		});
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		pane.setMessage(new Object[] {label, slider, value});
		pane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		pane.setOptionType(JOptionPane.OK_CANCEL_OPTION);
		
		JDialog dialog = pane.createDialog(frame, "Set Puppetiness");
		dialog.setVisible(true);
		return Integer.parseInt(pane.getInputValue().toString());
	}
}
