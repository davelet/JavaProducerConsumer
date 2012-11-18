package com.liuzhiwei.pro;

public class Move2 implements Runnable {
	Goods goods;
	Buffer2 buffer2;
	Buffer buffer ;
	int index = 0;
	public static boolean M2control = false;
//	static boolean control=false;

	public Move2(Buffer2 buffer2,Buffer buffer){
		this.buffer2=buffer2;
		this.buffer=buffer;
//		this.tf = tf ;
	}
	public void run(){
		
		for(int i=0;Move1.endthread;i++){
			while(M2control){}
			if( buffer2.index > 0 && buffer.sign <ProducerAndConsumer.BNumber && Move1.endthread){//当Buffer2和Buffer都满足存取的条件时才允许Move1线程操作
				goods=buffer2.pop();
			    System.out.println("Move2已经从Buffer2中取到商品");
			    buffer.push(goods);
			    System.out.println("Move2 have moved the :"+goods+"from Buffer2 to Buffer.");
		        index++;
//		        this.tf.setText(String.valueOf(index));
			}
		}
	}
	public int getData(){						//返回 移动了的商品的数目
		return index;
	}

}
