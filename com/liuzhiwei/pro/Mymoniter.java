package com.liuzhiwei.pro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

class Mymoniter implements ActionListener {
	ProducerAndConsumer s;
	Button button_1, button_2, button_3, button_4, button_5, button_6,
			button_7, button_8, button_9, button_A;
	boolean boolean1, boolean2, boolean3, boolean4, boolean5, boolean6;
	boolean producer1_state, producer2_state, move1_state, move2_state,
			consumer_state;
	MyTimeLabel l;

	public Mymoniter(ProducerAndConsumer a, Button button_1, Button button_2,
			Button button_3, Button button_4, Button button_5, Button button_6,
			Button button_7, Button button_8, Button button_9, Button button_A,
			MyTimeLabel l) {
		this.s = a;
		this.button_1 = button_1;
		this.button_2 = button_2;
		this.button_3 = button_3;
		this.button_4 = button_4;
		this.button_5 = button_5;
		this.button_6 = button_6;
		this.button_7 = button_7;
		this.button_8 = button_8;
		this.button_9 = button_9;
		this.button_A = button_A;
		this.l = l;
	}

	public Mymoniter() {
	}

	public void actionPerformed(ActionEvent e) {

		String ss = e.getActionCommand();
		int result = 100;
		if (ss.compareTo("开始") == 0)
			result = 0;
		else if (ss.compareTo("初始化设置") == 0)
			result = 1;
		else if (ss.compareTo("停止生产线程") == 0)
			result = 2;
		else if (ss.compareTo("继续生产线程") == 0)
			result = 3;
		else if (ss.compareTo("停止搬运线程") == 0)
			result = 4;
		else if (ss.compareTo("继续搬运线程") == 0)
			result = 5;
		else if (ss.compareTo("停止消费线程") == 0)
			result = 6;
		else if (ss.compareTo("继续消费线程") == 0)
			result = 7;
		else if (ss.compareTo("结束") == 0)
			result = 8;
		else if (ss.compareTo("暂停") == 0)
			result = 9;
		else if (ss.compareTo("继续") == 0)
			result = 10;
		switch (result) {
		case 0:
			button_1.setEnabled(false);
			button_4.setEnabled(false);
			button_6.setEnabled(false);
			button_8.setEnabled(false);
			button_A.setEnabled(false);
			s.launch();
			button_2.setEnabled(true);
			button_3.setEnabled(true);
			button_5.setEnabled(true);
			button_7.setEnabled(true);
			button_9.setEnabled(true);
			new Thread(l).start();
			break;

		case 1:
			System.out.println("Hello");
			break;
		case 2:
			button_5.setEnabled(false);
			button_6.setEnabled(true);
			Producer.P1control = true;
			Producer2.P2control = true;
			break;
		case 3:
			button_6.setEnabled(false);
			button_5.setEnabled(true);
			Producer.P1control = false;
			Producer2.P2control = false;
			break;
		case 4:
			button_7.setEnabled(false);
			button_8.setEnabled(true);
			Move1.M1control = true;
			Move2.M2control = true;
			break;
		case 5:
			button_8.setEnabled(false);
			button_7.setEnabled(true);
			Move1.M1control = false;
			Move2.M2control = false;
			break;
		case 6:
			button_9.setEnabled(false);
			button_A.setEnabled(true);
			Consumer.CNcontrol = true;
			break;
		case 7:
			button_A.setEnabled(false);
			button_9.setEnabled(true);
			Consumer.CNcontrol = false;
			break;
		case 8:
			Move1.endthread = false;
			Producer.P1control = false;
			Producer2.P2control = false;
			Move1.M1control = false;
			Move2.M2control = false;
			Consumer.CNcontrol = false;
			button_1.setEnabled(true);
			button_5.setEnabled(false);
			button_6.setEnabled(false);
			button_7.setEnabled(false);
			button_8.setEnabled(false);
			button_9.setEnabled(false);
			button_A.setEnabled(false);
			button_4.setEnabled(false);
			button_3.setEnabled(false);
			button_2.setEnabled(false);
			String data = "生产者数目" + Myframe.tf1.getText() + "\n消费者数目"
					+ Myframe.tf5.getText() + "\n搬运者数目" + Myframe.tf9.getText()
					+ "\n运行时间：" + Myframe.l.getText() + "\n\n" + "Buffer1的生产量"
					+ Myframe.tf6.getText() + "\n		剩余量" + Myframe.tfE.getText()
					+ "\n\nBuffer2的生产量" + Myframe.tf7.getText() + "\n		剩余量"
					+ Myframe.tfF.getText() + "\n\nBuffer的容量"
					+ Myframe.tf4.getText() + "\n		送入量" + Myframe.tf8.getText()
					+ "\n		剩余量" + Myframe.tfG.getText();
			Myframe.dataArea.setText(data);
			Myframe.textarea1.setText("");
			Myframe.textarea2.setText("");
			Myframe.textarea3.setText("");
			Myframe.tf1.setText("");
			Myframe.tf2.setText("");
			Myframe.tf3.setText("");
			Myframe.tf4.setText("");
			Myframe.tf5.setText("");
			Myframe.tf6.setText("");
			Myframe.tf7.setText("");
			Myframe.tf8.setText("");
			Myframe.tf9.setText("");
			Myframe.tfA.setText("");
			Myframe.tfB.setText("");
			Myframe.tfC.setText("");
			Myframe.tfG.setText("");
			Myframe.tfE.setText("");
			Myframe.tfF.setText("");
			// new Thread(l).destroy();
			break;
		case 9:
			boolean1 = button_5.isEnabled();
			boolean2 = button_6.isEnabled();
			boolean3 = button_7.isEnabled();
			boolean4 = button_8.isEnabled();
			boolean5 = button_9.isEnabled();
			boolean6 = button_A.isEnabled();
			button_5.setEnabled(false);
			button_6.setEnabled(false);
			button_7.setEnabled(false);
			button_8.setEnabled(false);
			button_9.setEnabled(false);
			button_A.setEnabled(false);
			button_4.setEnabled(true);
			button_3.setEnabled(false);

			producer1_state = Producer.P1control;
			producer2_state = Producer2.P2control;
			move1_state = Move1.M1control;
			move2_state = Move2.M2control;
			consumer_state = Consumer.CNcontrol;
			Producer.P1control = true;
			Producer2.P2control = true;
			Move1.M1control = true;
			Move2.M2control = true;
			Consumer.CNcontrol = true;
			break;
		case 10:
			button_3.setEnabled(true);
			button_4.setEnabled(false);
			button_5.setEnabled(boolean1);
			button_6.setEnabled(boolean2);
			button_7.setEnabled(boolean3);
			button_8.setEnabled(boolean4);
			button_9.setEnabled(boolean5);
			button_A.setEnabled(boolean6);
			Producer.P1control = producer1_state;
			Producer2.P2control = producer2_state;
			Move1.M1control = move1_state;
			Move2.M2control = move2_state;
			Consumer.CNcontrol = consumer_state;
			break;
		default:
			break;
		}

	}

}