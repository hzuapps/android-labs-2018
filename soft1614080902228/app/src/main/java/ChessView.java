package edu.hzuapps.andriodlabs.soft1614080902228;

import java.io.FileOutputStream;


import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;

public class ChessView extends View {

	private FileOutputStream fos;
	public int w,h;
	private Chess chess;
	public ChessView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		 w=context.getResources().getDisplayMetrics().widthPixels;
		 h=context.getResources().getDisplayMetrics().heightPixels;
	     chess=new Chess(this);
	   
	}
  @Override 
 protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
	// TODO Auto-generated method stub
	setMeasuredDimension(w, h);
 }
  @Override
 protected void onDraw(Canvas canvas) {
	// TODO Auto-generated method stub
	super.onDraw(canvas);
	chess.drawLine(canvas);
	
	chess.drawChess(canvas);
	
  }
  
  @Override
  public boolean onTouchEvent(MotionEvent event) {
	if(event.getAction()==MotionEvent.ACTION_UP){
		int eventX=(int) event.getX();
		int eventY=(int) event.getY();
		String path="e:/data.txt";
		System.out.println(path);
		try {
			fos=new FileOutputStream(path);
		    fos.write(eventX);
		    fos.write(" ".getBytes());
		    fos.write(eventY);
		    fos.write("\r\n".getBytes());
		    fos.close();
		    
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		chess.luozi(eventX,eventY);
		invalidate();
	}
	  return true;
  }
}
