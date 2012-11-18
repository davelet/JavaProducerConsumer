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

public class PopupWindow extends Frame implements ActionListener{//��ʼ����������
	
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
		if(ss.compareTo("��ʼ��")== 0)
			result = 0;
		else  result =1;
		switch (result) {												//�ж��¼����������
		case 0:
			new PopupWindow();
			break;
		case 1:
			/*
			 * �����ڵ�� "ȷ��" ʱ��ʱ�䴦��
			 */
			this.setVisible(false);
			ProducerAndConsumer.PNumber = Integer.parseInt(tf1.getText());//���������ߵ���Ŀ
			ProducerAndConsumer.CNumber = Integer.parseInt(tf2.getText());//���������ߵ���Ŀ
			ProducerAndConsumer.B1Number = Integer.parseInt(tf3.getText());//���õ�һ�������Ĵ�С
			ProducerAndConsumer.B2Number = Integer.parseInt(tf4.getText());//���õڶ��������Ĵ�С
			ProducerAndConsumer.BNumber = Integer.parseInt(tf5.getText());//������Buffer�Ĵ�С
			ProducerAndConsumer.MNumber = Integer.parseInt(tf6.getText());//����Move�̵߳���Ŀ��Move1��Move2����Ŀ��ͬ
			
			
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
	
	
	public PopupWindow(ProducerAndConsumer pc){			//ʵ��ProducerAndConsumer��������õĵ��롣
		this.pc = pc;
		
	}

	
	public PopupWindow(){
		button = new Button("ȷ��");
		button.addActionListener(this);				//��Button���ϼ����������䱾����ʼ�� ����actioPerformed����ʵ���¼�����Ӧ���ơ�
		
		panel_1 = new Panel(new FlowLayout());
		panel_2 = new Panel(new FlowLayout());
		panel_3 = new Panel(new FlowLayout());
		panel_4 = new Panel(new FlowLayout());
		panel_5 = new Panel(new FlowLayout());
		panel_6 = new Panel(new FlowLayout());
		panel_7 = new Panel(new FlowLayout());
		
		
		label_1 = new Label("�����ߵ���Ŀ: ");
		label_2 = new Label("�����ߵ���Ŀ:" );
		label_3 = new Label("Buffer1������:");
		label_4 = new Label("Buffer2������:");
		label_5 = new Label("Buffer������: ");
		label_6 = new Label();
		label_7 = new Label("�����ߵ���Ŀ: ");
		
		
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
		this.setTitle("��ʼ������");
		this.setLayout(new GridLayout(7,1));
		this.setVisible(true);
		this.setSize(300, 300);
		this.setLocation(520, 230);
		this.addWindowListener(new window(this));             //���ô��ڹر�ʱ��ʱ����Ӧ ����window��ʵ����Ӧ��
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
