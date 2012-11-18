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
			if(buffer1.index > 0 && buffer.sign < ProducerAndConsumer.BNumber && endthread){//在buffer2和Buffer都满足条件时才让Move线程操作

				goods=buffer1.pop();
				System.out.println("Move1已经从Buffer1中取到商品");
				buffer.push(goods);
				System.out.println("Move1 have moved the :"+goods +"from Buffer1 to Buffer.");
				myindex++;
				
			}  
		}
	}
	public int getData(){					//返回移动了商品的数目
		return myindex;
	}
}

