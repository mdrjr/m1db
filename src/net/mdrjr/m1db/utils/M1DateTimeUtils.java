package net.mdrjr.m1db.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class M1DateTimeUtils {

	public String getDateNow(String mask) {
		SimpleDateFormat sdf = new SimpleDateFormat(mask);
		Date y = new Date();
		return sdf.format(y);
	}
	
	public String getDateNowEasy() {
		return getDateNow("dd/MM/yyyy");	
	}
	
	public String getTimeNow(String mask) {
		SimpleDateFormat sdf = new SimpleDateFormat(mask);
		Date h = new Date();
		return sdf.format(h);
	}
	
	public String getTimeNowEasy() {
		return getTimeNow("kk:mm:ss");
	}
}
