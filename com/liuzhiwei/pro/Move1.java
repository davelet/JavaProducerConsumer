package com.liuzhiwei.pro;

public class Move1 implements Runnable{
	Goods goods;
	Buffer1 buffer1; 
	Buffer buffer;
	int myindex = 0;
	static boolean endthread = true;
	public static boolean M1control=false;
	
	public Move1(){}
	public Move1(Buffer1 buffer1,Buffer buffer){
		this.buffer1=buffer1;
		this.buffer=buffer;
	}
	@SuppressWarnings("static-access")
	public void run(){
		
		for(int i=0;endthread;i++){
			while(M1control){}
			if(buffer1.index > 0 && buffer.sign < ProducerAndConsumer.BNumber && endthread){//��buffer2��Buffer����������ʱ����Move�̲߳���

				goods=buffer1.pop();
				System.out.println("Move1�Ѿ���Buffer1��ȡ����Ʒ");
				buffer.push(goods);
				System.out.println("Move1 have moved the :"+goods +"from Buffer1 to Buffer.");
				myindex++;
				
			}  
		}
	}
	public int getData(){					//�����ƶ�����Ʒ����Ŀ
		return myindex;
	}
}

