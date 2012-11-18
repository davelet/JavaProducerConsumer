package com.liuzhiwei.pro;

import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.liuzhiwei.pro.PopupWindow.window;

@SuppressWarnings("serial")
public class InfoWindow extends Frame implements ActionListener {// 初始化弹出窗口

	Label label = new Label("tyghh");
	Panel panel = new Panel();

	public void actionPerformed(ActionEvent e) {
		new InfoWindow();
	}
	

	public InfoWindow() {
		this.add(panel);
		panel.add(label);
		
		this.setResizable(true);
		this.setTitle("操作说明");
//		this.setLayout(new GridLayout(7,1));
		this.setVisible(true);
		this.setSize(300, 300);
		this.setLocation(520, 230);
		this.addWindowListener(new window(this));
	}

	class window extends WindowAdapter {

		InfoWindow s;

		public window(InfoWindow s) {
			this.s = s;
		}

		public void windowClosing(WindowEvent e) {
			s.setVisible(false);
		}

	}
}
