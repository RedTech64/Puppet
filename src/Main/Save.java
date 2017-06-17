package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Save {
	static List<Puppet> list = new ArrayList<Puppet>();
	
	public static void save() {
		try {
			FileOutputStream file = new FileOutputStream("save.puppet");
			ObjectOutputStream save = new ObjectOutputStream(file);
			
			save.writeInt(list.size());
			for(int i = 0; i < list.size(); i++)
				save.writeObject(list.get(i));
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
			
			int n = load.readInt();
			
			for(int i = 0; i < n; i++)
				list.add(new Puppet((Puppet) load.readObject()));
			
			load.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found, no puppets saved.");
		} catch (IOException e) {
			System.out.println("IO Exception thrown at Puppet.load()");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadTabs() {
		Save.load();
		List<Puppet> list = Save.getList();
		
		for(Puppet p : list) {
			Application.getTabbedPane().add(p);
		}
	}
	
	public static void reset() {
		list.clear();
		save();
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
	
	public static List<Puppet> getList() {
		return list;
	}
}
