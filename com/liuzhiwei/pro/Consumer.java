package com.liuzhiwei.pro;

public class Consumer implements Runnable {

	Buffer buffer=null;
	int cnumber;
	Goods goods;
	static boolean CNcontrol=false;
	
	public Consumer(Buffer buffer){
		this.buffer=buffer;
	}
	
	public void run(){
		for(int i=0;Move1.endthread;i++){
			while(CNcontrol){}
			if(Move1.endthread){
				goods=buffer.pop();
				cnumber++;
				System.out.println(cnumber);
//				System.out.println("ฯ๛ทัมห"+goods);
				try{
					Thread.sleep(5000);
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		}
	}

}
