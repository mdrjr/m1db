package net.mdrjr.m1db.fileops;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import net.mdrjr.m1db.object.ProxyObject;

public class ObjectIOController {

	
	public void save(String storageFullPath, Object obj, Integer objId) throws FileNotFoundException, IOException {
			storageFullPath = storageFullPath + File.separator + objId.toString() + ".obj";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storageFullPath));
			oos.writeObject(obj);
	}
	
	public ProxyObject restore(String storageFullpath, String table, Integer objId) throws FileNotFoundException, IOException, ClassNotFoundException {
		storageFullpath = storageFullpath + File.separator + table + File.separator + objId.toString() + ".obj";
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storageFullpath));
		return (ProxyObject) ois.readObject();
	}
	
	public boolean delete(String storageFullPath, String table, Integer objId) {
		boolean ret = false;
			storageFullPath = storageFullPath + File.separator + table + File.separator + objId.toString() + ".obj";
			File f = new File(storageFullPath);
			ret = f.delete();
		return ret;
	}
	
}
