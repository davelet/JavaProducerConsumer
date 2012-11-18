package com.liuzhiwei.pro;

import java.awt.TextArea;
import java.awt.TextField;

public class Buffer2{
	int index=0;
	int p2number=0;
	int remain=0;
	TextArea textArea;
	TextField textfield1,textfield2,textfield3;
	
	public Buffer2(TextArea q,TextField tf,TextField tf2,TextField tf3){
		this.textArea = q;
		this.textfield1 = tf;
		this.textfield2 = tf2;
		this.textfield3 = tf3;
	}
	Goods goods[]=new Goods[ProducerAndConsumer.B2Number];
	public synchronized void push(Goods a){
		while(index==goods.length){
			try{
			    this.wait();
		  }catch(InterruptedException e){
			e.printStackTrace();
		}
	}
		this.notifyAll();
		goods[index]=a;
		index=index+1;
		p2number++;
		System.out.println("Producer2������:" +a);
		System.out.println("buffer2���У�"+index+"����Ʒ");
		textfield2.setText(String.valueOf(index));
		textfield1.setText(String.valueOf(p2number));
		textArea.append("Paoducer2 ������һ��\n");
	}
	public synchronized Goods pop(){
		while(index==0){
			try{
				this.wait();
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	    this.notifyAll();
	   	index--;
	   	remain++;
	   	textfield3.setText(String.valueOf(remain));
	   	textfield2.setText(String.valueOf(index));
	   	textArea.append("Move2������һ��\n");
		return goods[index];
	}
	public int getData(){						//������������Ʒ��Ŀ
		return index;
	}
}
