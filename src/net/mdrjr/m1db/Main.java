package net.mdrjr.m1db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import net.mdrjr.m1db.config.M1DBConfig;
import net.mdrjr.m1db.config.WorkConfig;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) {
		Properties m1dbConfigFile = new Properties();
		try {
			m1dbConfigFile.load(new FileInputStream("m1db.conf"));
		} catch (FileNotFoundException e) {
			System.out.println("Config file m1db.conf not found on this folder.");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.print("Unknown Error at loading config file");
			e.printStackTrace();
		}
		
		M1DBConfig m1dbConfig = new WorkConfig().WorkConfigInit(m1dbConfigFile);
		
	}

}
