package com.liuzhiwei.pro;

import java.awt.Label;
import java.text.SimpleDateFormat;

@SuppressWarnings("serial")
public class MyTimeLabel extends Label implements Runnable {
	public MyTimeLabel() {
		this.setText("00:00");
	}

	public void showT() {
		long initTime = new java.util.Date().getTime();
		for (;Move1.endthread;) {
			long runsTime = new java.util.Date().getTime() - initTime;
			SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
			String time = sdf.format(runsTime);
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
			} finally {
				this.setText(time);
			}
		}

	}

	public void run() {
		showT();
	}
}
