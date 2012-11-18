package com.liuzhiwei.pro;

import java.awt.TextField;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.Serializable;

class MyTextField extends TextField implements TextListener,Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Move1 move1;
	Move2 move2;
	Buffer1 buffer1;
	Buffer2 buffer2;
	static int i=0;
	MyTextField(Move1 move1){
		this.move1 = move1;
		this.setEditable(false);
	}
	MyTextField(int s){
		super(s);
		this.setEditable(false);
//		this.addTextListener(this);
//		this.setName(Integer.toString(i));
//		i++;
			
	}
	public void textValueChanged(TextEvent e) {
		
	}
}
