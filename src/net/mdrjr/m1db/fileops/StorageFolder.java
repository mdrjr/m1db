package net.mdrjr.m1db.fileops;

import java.io.File;
import java.io.Serializable;

public class StorageFolder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static void testStorageFolder(String storage_folder) {
			File f = new File(storage_folder);
				if(!f.exists()) {
					createStorageFolder(storage_folder);
				}
				if(!f.isDirectory()) {
					System.out.println("Storage Folder is a File! Fix it");
					System.exit(1);
				}
			}
	
	private static void createStorageFolder(String storage_folder) {
		File f = new File(storage_folder);
		try {
			f.mkdirs();
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	
}
