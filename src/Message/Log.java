package Message;

public class Log {
	public static final int ERROR = 0;
	public static final int WARNING = 1;
	public static final int EVENT = 2;
	public static final int MESSAGE = 3;
	
	public static void send(int t, String msg) {
		String type = null;
		
		switch(t) {
			case 0: type = "Error"; break;
			case 1: type = "Warning"; break;
			case 2: type = "Event"; break;
			case 3: type = "Message"; break;
		}
		
		System.out.println(type + ": " + msg);
	}
}
