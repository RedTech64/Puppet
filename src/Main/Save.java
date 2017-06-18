package Main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Save {
	static List<Puppet> list = new ArrayList<Puppet>();
	
	public static void save() {
		Message.Log.send(Message.Log.MESSAGE, "Saving Puppet List " + list);
		try {
			Message.Log.send(Message.Log.MESSAGE, "Save started...");
			FileOutputStream file = new FileOutputStream("save.puppet");
			ObjectOutputStream save = new ObjectOutputStream(file);
			
			save.writeInt(list.size());
			for(int i = 0; i < list.size(); i++)
				//System.out.println(list.get(i));
				save.writeObject(new JPanel());
			save.close();
			Message.Log.send(Message.Log.MESSAGE, "Save completed.");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void load() {
		try {
			Message.Log.send(Message.Log.MESSAGE, "Loading started...");
			FileInputStream file = new FileInputStream("save.puppet");
			ObjectInputStream load = new ObjectInputStream(file);
			
			int n = load.readInt();
			
			for(int i = 0; i < n; i++) {
				Object in = load.readObject();
				if(in != null)
				list.add(new Puppet((Puppet) in));
			}
			load.close();
			
			Message.Log.send(Message.Log.MESSAGE, "Loading completed.");
		} catch (FileNotFoundException e) {
			Message.Log.send(Message.Log.WARNING, "Save file not found!");
		} catch (IOException e) {
			Message.Log.send(Message.Log.ERROR, "IO Exception thrown at load.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void loadTabs() {
		Message.Log.send(Message.Log.MESSAGE, "Loading tabs...");
		Save.load();
		List<Puppet> list = Save.getList();
		
		for(Puppet p : list) {
			Application.getTabbedPane().add(p);
		}
		
		Message.Log.send(Message.Log.MESSAGE, "Loading tabs completed.");
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
