package Message;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ConfirmDialoge {
	int r;
	public ConfirmDialoge(String msg)  {
		JFrame frame = new JFrame();
		int r = JOptionPane.showOptionDialog(frame, msg, "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
	}
	
	public boolean confirmed() {
		if(r == 0)
			return true;
		else
			return false;
	}
}
