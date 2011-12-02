package net.mdrjr.m1db.fileops;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectIOController {

	
	public void save(String storage_full_path, Object obj, Integer objId) {
		try {
			storage_full_path = storage_full_path + File.pathSeparator + objId.toString() + ".obj";
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(storage_full_path));
			oos.writeObject(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object restore(String storage_full_path, String table, Integer objId) {
		Object retObj = null;
		try {
			storage_full_path = storage_full_path + File.pathSeparator + table + File.pathSeparator + objId.toString() + ".obj";
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(storage_full_path));
			retObj = ois.readObject();
		} catch(Exception E) {
			E.printStackTrace();
		}
		return retObj;
	}
	
}
