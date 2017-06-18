package Main;

import java.awt.EventQueue;

public class Main {
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				//try {
					Application frame = new Application();
					frame.setVisible(true);
				//} catch (Exception e) {
					//System.out.println(e.getCause());
				//}
			}
		});
	}
}
