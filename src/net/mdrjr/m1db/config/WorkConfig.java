package net.mdrjr.m1db.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WorkConfig {

	public M1DBConfig WorkConfigInit(Properties prop) {
		M1DBConfig m1dbConf = null;
		List<String> tables = new ArrayList<String>();
		String[] sTables = prop.getProperty("tables").split(";");
		
		for (String string : sTables) {
			tables.add(string);
		}
		
		m1dbConf = new M1DBConfig(prop.getProperty("storageFolder"), tables, prop.getProperty("logFile"), Integer.valueOf(prop.getProperty("5102")), prop.getProperty("networkPassword"));
		
		return m1dbConf;
		
	}
	
}
