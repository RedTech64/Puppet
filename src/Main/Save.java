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
		Message.Log.MESSAGE.send("Saving Puppet List " + list);
		try {
			Message.Log.MESSAGE.send("Save started...");
			FileOutputStream file = new FileOutputStream("save.puppet");
			ObjectOutputStream save = new ObjectOutputStream(file);
			
			save.writeInt(list.size());
			for(int i = 0; i < list.size(); i++)
				save.writeObject((Object) list.get(i));
			save.close();
			Message.Log.MESSAGE.send("Save completed.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		try {
			Message.Log.MESSAGE.send("Loading started...");
			FileInputStream file = new FileInputStream("save.puppet");
			ObjectInputStream load = new ObjectInputStream(file);
			
			int n = load.readInt();
			
			for(int i = 0; i < n; i++) {
				Object in = load.readObject();
				if(in != null)
				list.add(new Puppet(((Puppet) in)));
			}
			load.close();
			
			Message.Log.MESSAGE.send("Loading completed.");
		} catch (FileNotFoundException e) {
			Message.Log.WARNING.send("Save file not found!");
		} catch (IOException e) {
			Message.Log.ERROR.send("IO Exception thrown at load.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadTabs() {
		Message.Log.MESSAGE.send("Loading tabs...");
		Save.load();
		List<Puppet> list = Save.getList();
		
		for(Puppet p : list) {
			Application.getTabbedPane().add(p);
		}
		
		Message.Log.MESSAGE.send("Loading tabs completed.");
	}
	
	public static void reset() {
		for(Puppet p : list)
			Application.getTabbedPane().remove(p);
		list.clear();
		save();
	}
	
	public static void add(Puppet p) {
		list.add(p);
	}
	
	public static void clear(int i) {
		list.remove(i);
	}
	
	public static void update(Puppet p) {
		list.set(p.getID(), p);
	}
	
	public static List<Puppet> getList() {
		return list;
	}
	
	public static int getID() {
		return list.size();
	}
}
