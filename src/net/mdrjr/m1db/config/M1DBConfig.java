package net.mdrjr.m1db.config;

import java.io.File;
import java.io.Serializable;
import java.util.List;

import net.mdrjr.m1db.fileops.StorageFolder;
import net.mdrjr.m1db.fileops.TableFolder;
import net.mdrjr.m1db.logger.M1Logger;

public class M1DBConfig implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> tables;
	private String dbname;
	private String storageFolder;
	private String logfile;
	private M1Logger m1logger;
	
	public M1DBConfig(String storageFolder, List<String> tables, String logfile) {
		setTables(tables);
		setLogfile(logfile);
		setStorageFolder(storageFolder);
		StorageFolder.testStorageFolder(getStorageFolder());
		TableFolder.testTablesFolder(getTables(), getStorageFolder());
		setM1logger(new M1Logger(getStorageFolder() + File.pathSeparator + getLogfile()));
		
	}

	public List<String> getTables() {
		return tables;
	}

	public void setTables(List<String> tables) {
		this.tables = tables;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getStorageFolder() {
		return storageFolder;
	}

	public void setStorageFolder(String storageFolder) {
		this.storageFolder = storageFolder;
	}

	public String getLogfile() {
		return logfile;
	}

	public void setLogfile(String logfile) {
		this.logfile = logfile;
	}

	public M1Logger getM1logger() {
		return m1logger;
	}

	public void setM1logger(M1Logger m1logger) {
		this.m1logger = m1logger;
	}
	
	

}
