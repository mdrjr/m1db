package net.mdrjr.m1db.logger;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;

import net.mdrjr.m1db.utils.M1DateTimeUtils;

public class M1Logger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private RandomAccessFile raf;
	
	public M1Logger(String logfile) {
		File f = new File(logfile);
		if(f.exists() && f.isFile() && f.canWrite()) {
			System.out.println("Logging System Enabled. " + f.getName() + " exists, is a file and I can write on it");
		} else {
			if(!f.exists()) {
				try {
					f.createNewFile();
					System.out.println("Created logfile: " + logfile);
				} catch (IOException e) {
					System.out.println("Could not create logfile: " + logfile);
					System.exit(1);
				}
			}
			if(!f.isFile()) {
				System.out.println("Logfile is a directory. Aborting startup.");
				System.exit(1);
			}
			if(!f.canWrite()) {
				System.out.println("I can't write to the log file. Aborting...");
				System.exit(1);
			}
			
		}
		start_logger(logfile);
	}
	
	private void start_logger(String logfile)  {
		try {
			this.raf = new RandomAccessFile(logfile, "rwd");
			this.raf.seek(this.raf.length()); // move to the end of the file.
			log("Started the logging system.");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void log(String log) {
		M1DateTimeUtils m1dtu = new M1DateTimeUtils();
		String to_log = m1dtu.getDateNowEasy() + " " + m1dtu.getTimeNowEasy() + ": " + log + "\n";
		try {
			raf.writeChars(to_log);
		} catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	
	
}
