package com.liuzhiwei.pro;

import java.awt.TextArea;
import java.awt.TextField;

public class Buffer{
	int sign=0;
	int number=0;
	int remain=0;
	private static int Empty = 0;
	TextField tf,tf1,tf2;
	Goods goods[];
	TextArea textarea;
	public Buffer(int n,TextArea q,TextField tf,TextField tf2,TextField tf3){
		this.textarea=q;
		this.tf=tf;
		this.tf1 = tf2;
		this.tf2 = tf3;
		goods =new Goods[n];
		System.out.println(" before loop Buffer empty" + sign +"   " + n);
	}
	
	public synchronized void push(Goods a){
		
		while(sign==goods.length){
			System.out.println("Buffer empty" + sign +"   " + goods.length);
			try{
			    this.wait();
		  }catch(InterruptedException e){
			e.printStackTrace();
		}
	}
		
		this.notifyAll();	
		goods[sign]=a;
		sign ++;
		number++;
		tf.setText(String.valueOf(number));
		tf1.setText(String.valueOf(sign));
		tf2.setText(String.valueOf(remain));
		Empty = ProducerAndConsumer.BNumber - sign;
		System.out.println("Buffer��ʣ�ࣺ"+ Empty +"�ռ�" );
		textarea.append("Move�����ͽ�ȥһ��\n");
	}
	public synchronized Goods pop(){
		while(sign==0){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
			sign--;
			remain++;
			this.notifyAll();
			tf2.setText(String.valueOf(remain));
			tf1.setText(String.valueOf(sign));
			textarea.append("Consumer ������һ��\n");
			System.out.println("������" +goods[sign]);
			System.out.println("Buffer�ﻹ�У�"+sign+"������");
			
			return goods[sign];
	}
	public int getData(){						//������������Ʒ����Ŀ
		return sign;
	}
}
