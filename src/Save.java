import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Save {
	static ArrayList<Puppet> list = new ArrayList<Puppet>();
	
	public static void save() {
		try {
			FileOutputStream file = new FileOutputStream("save.puppet");
			ObjectOutputStream save = new ObjectOutputStream(file);
			
			save.writeObject(list);
			save.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		try {
			FileInputStream file = new FileInputStream("save.puppet");
			
			ObjectInputStream load = new ObjectInputStream(file);
			
			list = (ArrayList<Puppet>) load.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void reset() {
		list.clear();
	}
	
	public static void add(Puppet p) {
		list.add(p);
	}
	
	public static int getID() {
		return list.size();
	}
	
	public static void clear(int i) {
		list.set(i, null);
	}
	
	public static void update(Puppet p) {
		list.set(p.getID(), p);
	}
	
	public static ArrayList<Puppet> getList() {
		return list;
	}
}
