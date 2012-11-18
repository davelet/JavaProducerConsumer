package com.liuzhiwei.pro;

public class Producer2 implements Runnable {
	Buffer2 buffer2=null;
	static boolean P2control=false;
	public Producer2(Buffer2 buffer2){
		this.buffer2=buffer2;
	}
	public void run(){
		for(int i=0;Move1.endthread;i++){
			while(P2control){}
			if(Move1.endthread){
				Goods goods=new Goods(i);
				buffer2.push(goods);
				try{
					Thread.sleep(3000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}

}
