package com.liuzhiwei.pro;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PopupWindow extends Frame implements ActionListener{//初始化弹出窗口
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8574589756950342900L;
	Button button;
	Label label_1,label_2,label_3,label_4,label_5,label_6,label_7;
	Panel panel_1,panel_2,panel_3,panel_4,panel_5,panel_6,panel_7;
	TextField tf1,tf2,tf3,tf4,tf5,tf6;
	ProducerAndConsumer pc;
	String ss;
	int result = 2 ;
	public void actionPerformed(ActionEvent e) {
		String ss = e.getActionCommand();
		if(ss.compareTo("初始化")== 0)
			result = 0;
		else  result =1;
		switch (result) {												//判断事件发生的组件
		case 0:
			new PopupWindow();
			break;
		case 1:
			/*
			 * 设置在点击 "确定" 时的时间处理
			 */
			this.setVisible(false);
			ProducerAndConsumer.PNumber = Integer.parseInt(tf1.getText());//设置生产者的数目
			ProducerAndConsumer.CNumber = Integer.parseInt(tf2.getText());//设置消费者的数目
			ProducerAndConsumer.B1Number = Integer.parseInt(tf3.getText());//设置第一类容器的大小
			ProducerAndConsumer.B2Number = Integer.parseInt(tf4.getText());//设置第二类容器的大小
			ProducerAndConsumer.BNumber = Integer.parseInt(tf5.getText());//设置总Buffer的大小
			ProducerAndConsumer.MNumber = Integer.parseInt(tf6.getText());//设置Move线程的数目，Move1和Move2的数目相同
			
			
//			System.out.println("pc bnum is " + ProducerAndConsumer.PNumber);
//			System.out.println("pc bnum is " + ProducerAndConsumer.CNumber);
//			System.out.println("pc bnum is " + ProducerAndConsumer.B1Number);
//			System.out.println("pc bnum is " + ProducerAndConsumer.B2Number);
//			System.out.println("pc bnum is " + ProducerAndConsumer.BNumber);
//			System.out.println("pc bnum is " + ProducerAndConsumer.MNumber);
			
		default:
			break;
		}
			
	}
	
	
	public PopupWindow(ProducerAndConsumer pc){			//实现ProducerAndConsumer对象的引用的调入。
		this.pc = pc;
		
	}

	
	public PopupWindow(){
		button = new Button("确定");
		button.addActionListener(this);				//给Button加上监听器——其本身，初始化 调用actioPerformed方法实现事件的响应机制。
		
		panel_1 = new Panel(new FlowLayout());
		panel_2 = new Panel(new FlowLayout());
		panel_3 = new Panel(new FlowLayout());
		panel_4 = new Panel(new FlowLayout());
		panel_5 = new Panel(new FlowLayout());
		panel_6 = new Panel(new FlowLayout());
		panel_7 = new Panel(new FlowLayout());
		
		
		label_1 = new Label("生产者的数目: ");
		label_2 = new Label("消费者的数目:" );
		label_3 = new Label("Buffer1的容量:");
		label_4 = new Label("Buffer2的容量:");
		label_5 = new Label("Buffer的容量: ");
		label_6 = new Label();
		label_7 = new Label("搬运者的数目: ");
		
		
		tf1 = new TextField(10);
		tf2 = new TextField(10);
		tf3 = new TextField(10);
		tf4 = new TextField(10);
		tf5 = new TextField(10);
		tf6 = new TextField(10);
		
		
		panel_1.add(label_1);
		panel_1.add(tf1);
		panel_2.add(label_2);
		panel_2.add(tf2);
		panel_3.add(label_3);
		panel_3.add(tf3);
		panel_4.add(label_4);
		panel_4.add(tf4);
		panel_5.add(label_5);
		panel_5.add(tf5);
		panel_6.add(label_7);
		panel_6.add(tf6);
		panel_7.add(label_6);
		panel_7.add(button);
		panel_7.add(label_6);
		
		
		
		this.add(panel_1);
		this.add(panel_2);
		this.add(panel_3);
		this.add(panel_4);
		this.add(panel_5);
		this.add(panel_6);
		this.add(panel_7);
		/*
		 *
		*/
		this.setResizable(true);
		this.setTitle("初始化设置");
		this.setLayout(new GridLayout(7,1));
		this.setVisible(true);
		this.setSize(300, 300);
		this.setLocation(520, 230);
		this.addWindowListener(new window(this));             //设置窗口关闭时的时间响应 调用window类实现响应。
	}
	
	
	class window extends WindowAdapter{

		PopupWindow  s;
		public window(PopupWindow s){
			this.s=s;
		}
		public void windowClosing(WindowEvent e) {
			s.setVisible(false);
		}
		
	}
}
