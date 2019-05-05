package com.example.asus;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * 五子棋面板
 * Created by Administrator on 2016/5/2 0002.
 */
public class Wuziqipanel extends View {

    private int mPanelWidth;//棋盘宽度
    private float mLineHeight;//棋盘每行行高
    private int MAX_LINE = 10;//棋盘最大行数
    //创建绘画对象
    private Paint mPaint = new Paint();


    private Bitmap mWhitePiece;//白色棋子
    private Bitmap mBlackPiece;//黑色棋子

    //比例：棋子的大小是行高的3/4;
    private float ratioPieceOfLineHeight = 3*1.0f / 4;

    //白棋先手，当前轮到白棋。
    private boolean mIsWhite = true;
    private ArrayList<Point> mWhiteArray = new ArrayList<>();
    private ArrayList<Point> mBlackArray = new ArrayList<>();

    private boolean mIsGameOver;
    private boolean mIsWhiteWinner;

    private int MAX_COUNT_IN_LINE = 5;
    public Wuziqipanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(0x44ff0000);
        init();
    }
    /**初始化画笔属性*/
    private void init() {
        mPaint.setColor(0x88000000);//设置颜色为灰色效果
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        mPaint.setStyle(Paint.Style.STROKE);

        mWhitePiece = BitmapFactory.decodeResource(getResources(),R.drawable.stone_w2);
        mBlackPiece = BitmapFactory.decodeResource(getResources(),R.drawable.stone_b1);
    }
    /**测量一个view的大小*/
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);

        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(widthMeasureSpec);

        int width = Math.min(widthSize,heightSize);
        if(widthMode == MeasureSpec.UNSPECIFIED){
            width = heightSize;
        }else if(heightMode == MeasureSpec.UNSPECIFIED){
            width = widthSize;
        }
        //设置自身大小
        setMeasuredDimension(width,width);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mPanelWidth = w;
        mLineHeight = mPanelWidth*1.0f / MAX_LINE;

        int pieceWidth = (int) (mLineHeight * ratioPieceOfLineHeight);//棋子宽度

        mWhitePiece = Bitmap.createScaledBitmap(mWhitePiece,pieceWidth,pieceWidth,false);
        mBlackPiece = Bitmap.createScaledBitmap(mBlackPiece,pieceWidth,pieceWidth,false);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if(action == MotionEvent.ACTION_DOWN){
            int x = (int) event.getX();
            int y = (int) event.getY();
            Point p = getValidPoint(x,y);
            if(mWhiteArray.contains(p) || mBlackArray.contains(p)){
                return false;
            }
            if(mIsWhite){
                mWhiteArray.add(p);
            }else{
                mBlackArray.add(p);
            }
            invalidate();//请求重绘
            mIsWhite = !mIsWhite;
            return true;
        }
        return super.onTouchEvent(event);
    }

    private Point getValidPoint(int x, int y) {
        return new Point((int)(x/mLineHeight) ,(int)(y/mLineHeight));
    }

    /**Draw画出View的显示内容*/
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制棋盘
        drawBoard(canvas);
        //绘制棋子
        drawPieces(canvas);
        //检查游戏结束
        checkGameOver();
    }

    private void checkGameOver() {
        boolean whiteWin = checkFiveInLine(mWhiteArray);
        boolean blackWin = checkFiveInLine(mBlackArray);
        if(whiteWin || blackWin){
            mIsGameOver = true;
            mIsWhiteWinner = whiteWin;
            String text = mIsWhiteWinner ? "白棋胜利":"黑棋胜利";
            Toast.makeText(getContext(),text,Toast.LENGTH_LONG).show();
        }
    }

    private boolean checkFiveInLine(List<Point> points) {
        for (Point p : points){
            int x = p.x;
            int y = p.y;
            boolean win = checkHorizontal(x,y,points);
            if(win) return true;
            win = checkVertical(x,y,points);
            if(win) return true;
            win =checkLeftDiagonal(x,y,points);
            if(win) return true;
            win = checkRightDiagonal(x,y,points);
            if(win) return true;
        }
        return false;
    }

    /**
     * 判断x,y位置的棋子，是否横向有相邻的五个一致。
     * @param x
     * @param y
     * @param points
     * @return
     */
    private boolean checkHorizontal(int x, int y, List<Point> points) {
        int count = 1;
        //左
        for(int i=0;i<MAX_COUNT_IN_LINE;i++){
            if(points.contains(new Point(x-i,y))){
                count++;
            }else{
                break;
            }
        }
        if(count ==MAX_COUNT_IN_LINE) return true;
        for(int i=1;i<MAX_COUNT_IN_LINE;i++){
            if(points.contains(new Point(x+i,y))){
                count++;
            }else{
                break;
            }
        }
        if(count==MAX_COUNT_IN_LINE) return true;
        return  false;
    }
    /**
     * 判断x,y位置的棋子，是否纵向有相邻的五个一致。
     * @param x
     * @param y
     * @param points
     * @return
     */
    private boolean checkVertical(int x, int y, List<Point> points) {
        int count = 1;
        //上
        for(int i=0;i<MAX_COUNT_IN_LINE;i++){
            if(points.contains(new Point(x,y-i))){
                count++;
            }else{
                break;
            }
        }
        if(count ==MAX_COUNT_IN_LINE) return true;
        for(int i=1;i<MAX_COUNT_IN_LINE;i++){
            if(points.contains(new Point(x,y+i))){
                count++;
            }else{
                break;
            }
        }
        if(count==MAX_COUNT_IN_LINE) return true;
        return  false;
    }

    /**
     * 判断x,y位置的棋子，是否左斜有相邻的五个一致。
     * @param x
     * @param y
     * @param points
     * @return
     */
    private boolean checkLeftDiagonal(int x, int y, List<Point> points) {
        int count = 1;

        for(int i=0;i<MAX_COUNT_IN_LINE;i++){
            if(points.contains(new Point(x-i,y+i))){
                count++;
            }else{
                break;
            }
        }
        if(count ==MAX_COUNT_IN_LINE) return true;
        for(int i=1;i<MAX_COUNT_IN_LINE;i++){
            if(points.contains(new Point(x+i,y-i))){
                count++;
            }else{
                break;
            }
        }
        if(count==MAX_COUNT_IN_LINE) return true;
        return  false;
    }
    /**
     * 判断x,y位置的棋子，是否右斜有相邻的五个一致。
     * @param x
     * @param y
     * @param points
     * @return
     */
    private boolean checkRightDiagonal(int x, int y, List<Point> points) {
        int count = 1;

        for(int i=0;i<MAX_COUNT_IN_LINE;i++){
            if(points.contains(new Point(x-i,y-i))){
                count++;
            }else{
                break;
            }
        }
        if(count ==MAX_COUNT_IN_LINE) return true;
        for(int i=1;i<MAX_COUNT_IN_LINE;i++){
            if(points.contains(new Point(x+i,y+i))){
                count++;
            }else{
                break;
            }
        }
        if(count==MAX_COUNT_IN_LINE) return true;
        return  false;
    }

    private void drawPieces(Canvas canvas) {
        for(int i=0,n = mWhiteArray.size(); i< n ;i++){
            Point whitePoint = mWhiteArray.get(i);
            canvas.drawBitmap(mWhitePiece,
                    (whitePoint.x+(1-ratioPieceOfLineHeight)/2)*mLineHeight,
                    (whitePoint.y+(1-ratioPieceOfLineHeight)/2)*mLineHeight,null);
        }
        for(int i=0,n = mBlackArray.size(); i< n ;i++){
            Point blackPoint = mBlackArray.get(i);
            canvas.drawBitmap(mBlackPiece,
                    (blackPoint.x+(1-ratioPieceOfLineHeight)/2)*mLineHeight,
                    (blackPoint.y+(1-ratioPieceOfLineHeight)/2)*mLineHeight,null);
        }
    }

    private void drawBoard(Canvas canvas) {
        /**
         * 分析：根据棋盘的效果，我们知道棋子是下在边界的交叉点上的。可得棋盘中间有9个完整的lineHeight,
         * 上下两边有半个lineHeight，总共10个lineHeight。左右也是。
         */
        int w = mPanelWidth;
        float lineHeight = mLineHeight;
        for(int i=0;i<MAX_LINE;i++){
            int startX = (int) (lineHeight / 2);//起点坐标
            int endX = (int) (w - lineHeight / 2);//终点坐标
            int y = (int) ((0.5+i)*lineHeight);
            canvas.drawLine(startX,y,endX,y,mPaint);
            canvas.drawLine(y,startX,y,endX,mPaint);
        }
    }
    private static final String INSTANCE = "instance";
    private static final String INSTANCE_GAME_OVER = "instance_game_over";
    private static final String INSTANCE_WHITE_ARRAY = "instance_white_array";
    private static final String INSTANCE_BLACK_ARRAY = "instance_black_array";
    @Override
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(INSTANCE,super.onSaveInstanceState());
        bundle.putBoolean(INSTANCE_GAME_OVER,mIsGameOver);
        bundle.putParcelableArrayList(INSTANCE_WHITE_ARRAY,mWhiteArray);
        bundle.putParcelableArrayList(INSTANCE_BLACK_ARRAY,mBlackArray);
        return bundle;
    }

    @Override
    protected void onRestoreInstanceState(Parcelable state) {
        if(state instanceof Bundle){
            Bundle bundle = (Bundle) state;
            mIsGameOver = bundle.getBoolean(INSTANCE_GAME_OVER);
            mWhiteArray = bundle.getParcelableArrayList(INSTANCE_WHITE_ARRAY);
            mBlackArray = bundle.getParcelableArrayList(INSTANCE_BLACK_ARRAY);
            super.onRestoreInstanceState(bundle.getParcelable(INSTANCE));
            return ;
        }
        super.onRestoreInstanceState(state);

    }
}

