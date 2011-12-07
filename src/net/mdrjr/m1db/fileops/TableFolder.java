package net.mdrjr.m1db.fileops;

import java.io.File;
import java.io.Serializable;
import java.util.List;

public class TableFolder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void testTablesFolder(List<String> tables, String storageFolder) {
		for (String table : tables) {
			testTableFolder(table, storageFolder);
		}
	}
	
	public static void testTableFolder(String table, String storageFolder) {
		String tableFullPath = storageFolder + File.separator + table; 
		File f = new File(tableFullPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		if(!f.isDirectory() && f.exists()) {
			System.out.println("Table Folder: " + table + " is not a folder");
			System.exit(1);
		}
		if(!f.canWrite()) {
			System.out.println("I can't write to the table folder: " + table);
			System.exit(1);
		}
		if(!f.canRead()) {
			System.out.println("I can't read the table folder: " + table);
			System.exit(1);
		}
	}

}
