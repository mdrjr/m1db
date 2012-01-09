package net.mdrjr.m1db.server;

import java.io.IOException;
import java.net.ServerSocket;

public class M1Listener {
	
	public M1Listener() {
		super();
		try {
			ServerSocket skt = new ServerSocket(1010);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
