package com.liuzhiwei.pro;

import java.awt.TextArea;

public class ProducerAndConsumer {
	public static int PNumber = 0;
	public static int CNumber = 0;
	public static int B1Number = 0;
	public static int B2Number = 0;
	public static int BNumber = 0;
	public static int MNumber = 0;

	Buffer1 buffer1;
	Buffer2 buffer2;
	Buffer buffer;
	Thread th;
	Producer producer1;
	Producer2 producer2;
	Consumer consumer;
	Move1 move1;
	Move2 move2;
	MyTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, tfA, tfB, tfC,
			tfE, tfF, tfG;
	TextArea textArea1, textArea2, textArea3;
	int i = 0;

	public ProducerAndConsumer(int a) {
		// InitTextField();
		this.i = a;
	}

	void setTextArea(TextArea s1, TextArea s2, TextArea s3) { // 传递引用，实现对三个Buffer的输出
		this.textArea1 = s1;
		this.textArea2 = s2;
		this.textArea3 = s3;
	}

	void setTextField(MyTextField tf1, MyTextField tf2, MyTextField tf3,
			MyTextField tf4, MyTextField tf5, MyTextField tf9) {
		this.tf1 = tf1;
		this.tf2 = tf2;
		this.tf3 = tf3;
		this.tf4 = tf4;
		this.tf5 = tf5;
		this.tf9 = tf9;
	}

	void InitTextField(MyTextField tf6, MyTextField tf7, MyTextField tf8,
			MyTextField tfA, MyTextField tfB, MyTextField tfC, MyTextField tfE,
			MyTextField tfF, MyTextField tfG) {
		this.tf6 = tf6;
		this.tf7 = tf7;
		this.tf8 = tf8; // 实现对窗口的几个TextField中的输出
		this.tfA = tfA;
		this.tfB = tfB;
		this.tfC = tfC;
		this.tfE = tfE;
		this.tfF = tfF;
		this.tfG = tfG;
	}

	void InitTextField_1() { // 初始化ProduceAndConsumer 初始化
		buffer1 = new Buffer1(textArea1, tf6, tfE, tfA);
		buffer2 = new Buffer2(textArea2, tf7, tfF, tfB);
		System.out.println("ProducerAndConsumer.BNumber"
				+ ProducerAndConsumer.BNumber);
		// System.exit(1);
		buffer = new Buffer(ProducerAndConsumer.BNumber, textArea3, tf8, tfG,
				tfC);
		producer1 = new Producer(buffer1);
		producer2 = new Producer2(buffer2);
		consumer = new Consumer(buffer);
		move1 = new Move1(buffer1, buffer);
		move2 = new Move2(buffer2, buffer);
		System.out.println("init over..");
	}

	public void launch() {

		InitTextField_1();
		System.out.println("start thread...");
		this.tf1.setText(String.valueOf(PNumber));
		this.tf2.setText(String.valueOf(B1Number));
		this.tf3.setText(String.valueOf(B2Number));
		this.tf4.setText(String.valueOf(BNumber));
		this.tf5.setText(String.valueOf(CNumber));
		this.tf9.setText(String.valueOf(MNumber));

		for (int i = 0; i < PNumber; i++) { // 启动producer1线程
			th = new Thread(producer1);
			th.setName("N1producer" + i);
			th.start();
			System.out.println("n  1  " + i);

		}

		for (int i = 0; i < PNumber; i++) { // 启动producer2线程
			th = new Thread(producer2);
			th.setName("N2producer" + i);
			th.start();
			System.out.println("n  2  " + i);
		}

		for (int i = 0; i < CNumber; i++) { // 启动消费线程
			new Thread(consumer).start();

		}
		System.out.println("hello");
		for (int i = 0; i < MNumber; i++) {
			new Thread(move1).start();
		}
		for (int i = 0; i < MNumber; i++) {
			new Thread(move2).start();
		}
	}

}
