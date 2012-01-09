package net.mdrjr.m1db.object;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.mdrjr.m1db.config.M1DBConfig;
import net.mdrjr.m1db.fileops.ObjectIOController;

public class M1ObjectControl {

	private ObjectIOController oIOC = new ObjectIOController();
	private ObjectProxyController oPC = new ObjectProxyController();
	
	public boolean save(M1DBConfig dbConfig, String table, Object object, Integer objid) {
		boolean ret = false;
		try {
			oIOC.save(dbConfig.getStorageFolder() + File.separator + table, oPC.proxyTo(object), objid);
		} catch(Exception e) {
			dbConfig.getM1logger().log(e.getMessage());
		}
		dbConfig.getM1logger().log("Inserted object (" + table + ":" + objid.toString() + ")");
		return ret;
	}

	public Object restore(M1DBConfig dbConfig, String table, Integer objId) {
		Object retObj = null;
		try {
			retObj = oPC.proxyBack(oIOC.restore(dbConfig.getStorageFolder(), table, objId));
		} catch(Exception e) {
			dbConfig.getM1logger().log(e.getMessage());
		}
		dbConfig.getM1logger().log("Requested object (" + table + ":" + objId.toString() + ")");
		return retObj;
	}
	
	public boolean delete(M1DBConfig dbConfig, String table, Integer objId) { 
		boolean ret = false;
			ret = oIOC.delete(dbConfig.getStorageFolder() + File.separator, table, objId);
			if(ret) {
				dbConfig.getM1logger().log("Deleted object (" + table + ":" + objId.toString() + ")");
			} else {
				dbConfig.getM1logger().log("Unable to delete (" + table + ":" + objId.toString() + ")");
			}
			
		return ret;
	}
	
	public List<String> listTables(M1DBConfig dbConfig) {
		List<String> tables = new ArrayList<String>();
		
		return tables;
	}
	
	public List<String> listObjects(M1DBConfig dbConfig, String table) {
		List<String> objects = new ArrayList<String>();
		
		return objects;
	}
}
