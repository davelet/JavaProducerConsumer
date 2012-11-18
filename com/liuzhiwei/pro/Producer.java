package com.liuzhiwei.pro;
public class Producer implements Runnable {
	Buffer1 buffer1=null;
	static boolean P1control=false;
	public Producer(Buffer1 buffer1){
		this.buffer1=buffer1;
	}
	public void run(){
		for(int i=0;Move1.endthread;i++){

			while(P1control){}					//实现停止和继续，利用control和死循环。
			if(Move1.endthread){
				Goods goods=new Goods(i);
				buffer1.push(goods);
				try{
					Thread.sleep(1000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}

}
