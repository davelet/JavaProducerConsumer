 package com.liuzhiwei.pro;

import java.awt.TextArea;
import java.awt.TextField;

public class Buffer1{
//	Myframe m=new Myframe();
	static	int index=0;
	static int pnumber=0;
	static int remain=0;
	TextArea textArea;
	TextField textfield1,textfield2,textfield3;
	public  Buffer1(TextArea s1,TextField s2,TextField s3,TextField s4){
		this.textArea = s1;
		this.textfield1 = s2;
		this.textfield2 = s3;
		this.textfield3 = s4;
	}
	Goods goods[]=new Goods[ProducerAndConsumer.B1Number];
	public synchronized void push(Goods a){ 					//Producer1�߳���Buffer1�з���Ʒ�Ĺ��̡�
		System.out.println("push  ");
		while(index==goods.length){
			try{
			    this.wait();
		  }catch(InterruptedException e){
			e.printStackTrace();
		}
	}
		this.notifyAll();
		goods[index]=a;
		index++;
		pnumber++;
		System.out.println("Producer1������:" +pnumber);				//index ��ʾBuffer1�����е���Ʒ�ĸ�����
		System.out.println("Buffer1����"+index+"����Ʒ");
		textfield1.setText(String.valueOf(pnumber));
		textfield2.setText(String.valueOf(index));
		textArea.append("Paoducer1 ������һ��\n");
	}
	public synchronized Goods pop(){							//ʵ��Move1��������ʾ��Buffer1��ȡ�����̡�
		while(index==0){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
			index--;
			remain++;
			this.notifyAll();
			textArea.append("Move1 ������һ��\n");
			textfield3.setText(String.valueOf(remain));
			textfield2.setText(String.valueOf(index));
			return goods[index];
	}
	public int getData(){										//������������Ʒ��Ŀ
		return index;
	}
	
}

