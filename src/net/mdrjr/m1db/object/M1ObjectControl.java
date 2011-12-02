package net.mdrjr.m1db.object;

import java.io.File;

import net.mdrjr.m1db.config.M1DBConfig;
import net.mdrjr.m1db.fileops.ObjectIOController;

public class M1ObjectControl {

	private ObjectIOController oIOC = new ObjectIOController();
	
	public boolean save(M1DBConfig dbConfig, String table, Object object, Integer objid) {
		boolean ret = false;
		try {
			oIOC.save(dbConfig.getStorageFolder() + File.separator + table, object, objid);
		} catch(Exception e) {
			dbConfig.getM1logger().log(e.getMessage());
		}
		dbConfig.getM1logger().log("Inserted object (" + table + ":" + objid.toString() + ")");
		return ret;
	}

	public Object restore(M1DBConfig dbConfig, String table, Integer objId) {
		Object retObj = null;
		try {
			retObj = oIOC.restore(dbConfig.getStorageFolder(), table, objId);
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
}
