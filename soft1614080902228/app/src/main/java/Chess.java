package edu.hzuapps.andriodlabs.soft1614080902228;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;

public class Chess {

	private int w,h;
	private int unit=15;
	private int totalLine,totalColumn;
	private Paint paint;

	private int radius;
	private int cx,cy;
	private int cLine,cColumn;
	private List<Point>list;
	
	public Chess(ChessView cv){
	   w=cv.w;
	   h=cv.h;
	   
	   totalLine=h/unit;
	   totalColumn=w/unit;
	   radius=5;
	   paint=new Paint();

	   list=new ArrayList<Point>();
	   
	}
	
	public void drawLine(Canvas canvas) {
		// TODO Auto-generated method stub
		canvas.drawColor(Color.GRAY);
		 paint.setColor(Color.BLACK);
		for(int i=0;i<=totalLine;i++)
		    canvas.drawLine(0, i*unit, totalColumn*unit, i*unit, paint);
	    
		for(int i=0;i<=totalColumn;i++) 
			canvas.drawLine(i*unit, 0, i*unit, totalLine*unit, paint);
	
	}

	public void drawChess(Canvas canvas) {
		// TODO Auto-generated method stub
	
		Point p=null;
		paint.setStyle(Style.FILL);
		for(int i=0;i<list.size();i++){
			paint.setColor(i%2!=1 ? Color.BLACK:Color.WHITE);
			p=list.get(i);
			canvas.drawCircle(p.x, p.y, radius, paint);
		}
	}

	public void luozi(int eventX, int eventY) {
		// TODO Auto-generated method stub
		cColumn=eventX/unit;
		cLine=eventY/unit;
		
		int modeX=eventX%unit;
		int modeY=eventY%unit;
		
		if(modeX<unit/2 && modeY<unit/2){
		}else if(modeX > unit/2 && modeY<unit/2){
			cColumn+=1;
		}else if(modeX<unit/2 && modeY>unit/2){
			cLine+=1;
		}else if(modeX>unit/2&& modeY>unit/2){
			cColumn+=1;
			cLine+=1;
		}
		cx=cColumn*unit;
		cy=cLine*unit;
		
		//添加到队列
		for(int i=0;i<list.size();i++){
			if(list.get(i).x==cx&&list.get(i).y==cy){
				return;
			}
		}
		list.add(new Point(cx,cy));
	}

}
