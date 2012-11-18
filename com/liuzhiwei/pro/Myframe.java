package com.liuzhiwei.pro;

import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class Myframe extends Frame {
	static TextArea textarea1, textarea2, textarea3,dataArea;
	ProducerAndConsumer ss;
	static MyTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tfA, tfB, tfC,
			tfD, tfE, tfF, tfG;
	Label Label_1, Label_2, Label_3, Label_4, Label_5, Label_6, Label_7,
			Label_8, Label_9, Label_A, Label_B, Label_C, Label_D, Label_E,
			Label_F, Label_G;
	GridBagLayout gridbag;
	GridBagConstraints c;
	Button Button_1, Button_2, Button_3, Button_4, Button_5, Button_6,
			Button_7, Button_8, Button_9, Button_A, Button_B, Button_C,
			Button_D, Button_E;
	Canvas canvas;
	Panel panel_1, panel_2, panel_3;
	MenuBar Mymenu;
	Menu m1, m2, m3;
	MenuItem m1_1, m1_2, m2_1, m3_1,m4;
	Mymoniter mymoniter;
	static MyTimeLabel l;

	public Myframe() {

	}

	@SuppressWarnings("static-access")
	public Myframe(ProducerAndConsumer a) {
		this.ss = a;

		gridbag = new GridBagLayout();
		c = new GridBagConstraints();
		this.addWindowListener(new WindowAdapter() { // �������ʵ�ַ���ʵ�ִ��ڵĹر�
					public void windowClosing(WindowEvent e) {
						setVisible(false);
						System.exit(0);
					}
				});
		this.setLayout(gridbag);

		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weighty = 0.3;
		c.weightx = 1.0;
		panel_1 = new Panel();
		// panel_1.setBackground(Color.black);
		gridbag.setConstraints(panel_1, c);
		this.add(panel_1);
		panel_1.setLayout(new GridLayout(4, 8));
		MakeMypanel_1();

		/*
		 * panel_2ʵ��Buffer��Buffer1��Buffer2֮�������ת������ʾ
		 * ��Buffer1��Buffer2��ȡ�����ݷŵ�Buffer�еĹ���
		 * 
		 */
		c.weighty = 1.0;
		panel_2 = new Panel();
		// panel_2.setBackground(Color.blue);
		gridbag.setConstraints(panel_2, c);
		this.add(panel_2);
		panel_2.setLayout(gridbag);
		panel_2.setLayout(new GridLayout(1, 4));
		Makepanel_2();

		/*
		 * //��panel_3�з�������panelʵ�ֶԶ��߳�ģ�����Ŀ��ƹ���
		 */
		c.weighty = 0.3;
		panel_3 = new Panel();
		// panel_3.setBackground(Color.green);
		gridbag.setConstraints(panel_3, c);
		this.add(panel_3);
		panel_3.setLayout(gridbag);
		// System.out.println(panel_3.getLayout());
		Panel panel3_1, panel3_2, panel3_3;

		panel3_1 = new Panel(); // �����ܿ���ģ�顪����ʼ�ͽ���ʱ�Ŀ���ģ�飡
		Button_1 = new Button("��ʼ");
		Button_2 = new Button("����");

		panel3_1.setLayout(new GridLayout(2, 1, 10, 10)); // �������֮��ļ�϶
		// panel3_1.setBackground(Color.red);
		panel3_1.add(Button_1);
		panel3_1.add(Button_2);

		panel3_2 = new Panel(); // �ֲ�����ģ��
		Button_3 = new Button("��ͣ");
		Button_4 = new Button("����");
		Button_5 = new Button("ֹͣ�����߳�");
		Button_6 = new Button("���������߳�");
		Button_7 = new Button("ֹͣ�����߳�");
		Button_8 = new Button("���������߳�");
		Button_9 = new Button("ֹͣ�����߳�");
		Button_A = new Button("���������߳�");
		panel3_2.setLayout(new GridLayout(2, 4, 10, 10));
		mymoniter = new Mymoniter(ss, Button_1, Button_2, Button_3, Button_4,
				Button_5, Button_6, Button_7, Button_8, Button_9, Button_A,l);

		Button_1.addActionListener(mymoniter);
		Button_2.addActionListener(mymoniter);
		Button_3.addActionListener(mymoniter);
		Button_5.addActionListener(mymoniter);
		Button_4.addActionListener(mymoniter);
		Button_6.addActionListener(mymoniter);
		Button_7.addActionListener(mymoniter);
		Button_8.addActionListener(mymoniter);
		Button_9.addActionListener(mymoniter);
		Button_A.addActionListener(mymoniter);

		// panel3_2.setBackground(Color.LIGHT_GRAY);
		panel3_2.add(Button_3);
		panel3_2.add(Button_5);
		panel3_2.add(Button_7);
		panel3_2.add(Button_9);
		panel3_2.add(Button_4);
		panel3_2.add(Button_6);
		panel3_2.add(Button_8);
		panel3_2.add(Button_A);

		panel3_3 = new Panel(); // ʱ�����ģ��
		// panel3_3.setBackground(Color.yellow);
		/*
		 * ����ȫ������ģ��Ĳ��ֹ���.
		 */
		c.fill = GridBagConstraints.BOTH;
		c.gridheight = GridBagConstraints.REMAINDER;
		c.gridwidth = 3;
		c.weighty = 1.0;
		c.weightx = 0.3;
		gridbag.setConstraints(panel3_1, c);
		panel_3.add(panel3_1);

		c.gridwidth = GridBagConstraints.RELATIVE;
		c.weightx = 0.8;
		gridbag.setConstraints(panel3_2, c);
		panel_3.add(panel3_2);

		c.weightx = 0.3;
		gridbag.setConstraints(panel3_3, c);
		panel_3.add(panel3_3);

		this.setVisible(true);
		this.setLocation(30, 70);
		MakeMymenu();
		this.setMenuBar(Mymenu);
//		this.pack();
		this.setSize(2200, 700);
		// this.show();
		this.setTitle("���߳���ʾ��");
		a.setTextField(tf1, tf2, tf3, tf4, tf5, tf9);
		a.setTextArea(this.textarea1, this.textarea2, this.textarea3);
		a.InitTextField(this.tf6, this.tf7, this.tf8, this.tfA, this.tfB,
				this.tfC, this.tfE, this.tfF, this.tfG); // ʵ�ֶ��ı����������ʾ������PruducerAndConsumer
															// �����е�InitTextField������
	}

	public void MakeMymenu() { // �����Լ��Ĳ˵�

		Mymenu = new MenuBar();// �����˵���
//		m1 = new Menu("�ļ�", true);// ������һ���˵�
//		m1_1 = new MenuItem("�½�");
//		m1.add(m1_1);
//		m1.addSeparator();
//		m1_2 = new MenuItem("��");
//		m1.add(m1_2);
		m1 = new Menu("����",true);
		m2_1 = new MenuItem("��ʼ��");
		m3_1 = new MenuItem("�����ܻ�");
		m4 = new MenuItem("˵��");// �������ĸ��˵�
		m1.add(m2_1);
		m1.add(m3_1);
		m1.addSeparator();
		m1.add(m4);
//		m2 = new Menu("�༭", true);// �����ڶ����˵�
		m2_1.addActionListener(new PopupWindow(ss));
//		m2.add(m2_1);
//		m3 = new Menu("����", true);// �����������˵�
		m4.addActionListener(new InfoWindow());
//		m3.add(m3_1);
		Mymenu.add(m1);
//		Mymenu.add(m2);
//		Mymenu.add(m3);
//		Mymenu.add(m4);

	}

	public void MakeMypanel_1() {
		Label_1 = new Label(" ��������Ŀ  ");
		Label_2 = new Label(" ��������Ŀ  ");
		Label_3 = new Label(" ��������Ŀ  ");
		Label_4 = new Label("  ����ʱ��   ");
		l=new MyTimeLabel();
		Label_5 = new Label("Buffer1������");
		Label_6 = new Label(" ��������Ŀ  ");
		Label_7 = new Label(" ȡ��������  ");
		Label_8 = new Label(" ʣ�������  ");
		Label_9 = new Label("Buffer2������");
		Label_A = new Label(" ��������Ŀ  ");
		Label_B = new Label(" ȡ������Ŀ  ");
		Label_C = new Label(" ʣ�����Ŀ  ");
		Label_D = new Label("Buffer������ ");
		Label_E = new Label(" �������Ŀ  ");
		Label_F = new Label(" ���ѵ���Ŀ  ");
		Label_G = new Label(" ʣ�����Ŀ  ");
		panel_1.add(Label_1);
		panel_1.add(tf1 = new MyTextField(2)); 
		panel_1.add(Label_5);
		panel_1.add(tf2 = new MyTextField(2));
		panel_1.add(Label_9);
		panel_1.add(tf3 = new MyTextField(2));
		panel_1.add(Label_D);
		panel_1.add(tf4 = new MyTextField(2));
		panel_1.add(Label_2);
		panel_1.add(tf5 = new MyTextField(2));
		panel_1.add(Label_6);
		panel_1.add(tf6 = new MyTextField(2));
		panel_1.add(Label_A);
		panel_1.add(tf7 = new MyTextField(2));
		panel_1.add(Label_E);
		panel_1.add(tf8 = new MyTextField(2));
		panel_1.add(Label_3);
		panel_1.add(tf9 = new MyTextField(2));
		panel_1.add(Label_7);
		panel_1.add(tfA = new MyTextField(2));
		panel_1.add(Label_B);
		panel_1.add(tfB = new MyTextField(2));
		panel_1.add(Label_F);
		panel_1.add(tfC = new MyTextField(2));
		panel_1.add(Label_4);
		panel_1.add(l);
		panel_1.add(Label_8);
		panel_1.add(tfE = new MyTextField(2));
		panel_1.add(Label_C);
		panel_1.add(tfF = new MyTextField(2));
		panel_1.add(Label_G);
		panel_1.add(tfG = new MyTextField(2));
	}

	public void Makepanel_2() {
		dataArea = new TextArea();
		Panel panel2_1, panel2_2, panel2_3, panel2_4;
		panel2_1 = new Panel();
		panel2_1.add(dataArea);
		panel2_2 = new Panel();
		panel2_2.setLayout(new GridLayout(2, 2));
		textarea1 = new TextArea();
		textarea2 = new TextArea();
		textarea3 = new TextArea();
		textarea1.setEditable(false);
		textarea2.setEditable(false);
		textarea3.setEditable(false);
		panel2_2.add(new Label("Buffer1:"));
		panel2_2.add(textarea1);
		panel2_2.add(new Label("Buffer2:"));
		panel2_2.add(textarea2);

		canvas = new Canvas();
		panel2_2.add(textarea2);
		panel2_3 = new Panel();
		panel2_3.setLayout(new GridLayout(1, 2));
		Panel ss;
		panel2_3.add(ss = new Panel());
		ss.setBackground(Color.green);
		panel2_3.add(new Label("Buffer:"));
		panel2_3.setBackground(Color.CYAN);
		panel2_4 = new Panel();
		panel2_4.setLayout(new GridLayout(1, 2));
		panel2_4.add(textarea3);
		panel2_4.add(canvas);
		panel2_4.setBackground(Color.blue);
		panel_2.add(panel2_1);
		panel_2.add(panel2_2);
		panel_2.add(panel2_3);
		panel_2.add(panel2_4);
	}

	public static void main(String[] args) {
		int b = 0;
		ProducerAndConsumer a = new ProducerAndConsumer(b);
		new Myframe(a);
	}

}
