package net.mdrjr.m1db.fileops;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOController {

	
	public void save(String storageFullPath, Object obj, Integer objId) {
		try {
			storageFullPath = storageFullPath + File.separator + objId.toString() + ".obj";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storageFullPath));
			oos.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object restore(String storageFullpath, String table, Integer objId) {
		Object retObj = null;
		try {
			storageFullpath = storageFullpath + File.separator + table + File.separator + objId.toString() + ".obj";
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storageFullpath));
			retObj = ois.readObject();
		} catch(Exception E) {
			E.printStackTrace();
		}
		return retObj;
	}
	
	public boolean delete(String storageFullPath, String table, Integer objId) {
		boolean ret = false;
		 
			storageFullPath = storageFullPath + File.separator + table + File.separator + objId.toString() + ".obj";
			File f = new File(storageFullPath);
			ret = f.delete();
		
		return ret;
	}
	
}
