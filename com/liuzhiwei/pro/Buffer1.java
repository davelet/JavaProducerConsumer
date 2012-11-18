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
	public synchronized void push(Goods a){ 					//Producer1线程往Buffer1中放商品的过程。
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
		System.out.println("Producer1生产了:" +pnumber);				//index 表示Buffer1中现有的商品的个数。
		System.out.println("Buffer1中有"+index+"个商品");
		textfield1.setText(String.valueOf(pnumber));
		textfield2.setText(String.valueOf(index));
		textArea.append("Paoducer1 生产了一个\n");
	}
	public synchronized Goods pop(){							//实现Move1操作，表示从Buffer1中取出过程。
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
			textArea.append("Move1 搬走了一个\n");
			textfield3.setText(String.valueOf(remain));
			textfield2.setText(String.valueOf(index));
			return goods[index];
	}
	public int getData(){										//返回生产的商品数目
		return index;
	}
	
}

