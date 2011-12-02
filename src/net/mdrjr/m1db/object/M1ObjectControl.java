package net.mdrjr.m1db.object;

import java.io.File;

import net.mdrjr.m1db.config.M1DBConfig;
import net.mdrjr.m1db.fileops.ObjectIOController;

public class M1ObjectControl {

	private ObjectIOController oIOC = new ObjectIOController();
	
	public boolean save(M1DBConfig dbConfig, String table, Object object, Integer objid) {
		boolean ret = false;
		oIOC.save(dbConfig.getStorageFolder() + File.pathSeparator + table, object, objid);
		return ret;
	}

	public Object restore(M1DBConfig dbConfig, String table, Integer objId) {
		Object retObj = null;
			retObj = oIOC.restore(dbConfig.getStorageFolder(), table, objId);
		return retObj;
	}
}
