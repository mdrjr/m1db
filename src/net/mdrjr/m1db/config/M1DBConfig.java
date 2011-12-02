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
	private String storage_folder;
	private String logfile;
	private M1Logger m1logger;
	
	public M1DBConfig(String storage_folder, List<String> tables, String logfile) {
		setTables(tables);
		setLogfile(logfile);
		setStorage_folder(storage_folder);
		StorageFolder.testStorageFolder(getStorage_folder());
		TableFolder.testTablesFolder(getTables(), getStorage_folder());
		setM1logger(new M1Logger(getStorage_folder() + File.pathSeparator + getLogfile()));
		
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

	public String getStorage_folder() {
		return storage_folder;
	}

	public void setStorage_folder(String storage_folder) {
		this.storage_folder = storage_folder;
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
