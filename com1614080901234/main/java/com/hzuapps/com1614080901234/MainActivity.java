package com.example.intelligentcooker;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intelligentcooker.adapter.BottomAdapter;
import com.example.intelligentcooker.widget.MyViewPager;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 推荐菜谱用的SliderLayout框架，如果是设置为主活动则第一张不会有问题，
 * 如果是从登录界面跳转到主页中，则第一张不会被加载出来
 * @author 王治平
 * 主界面的Activity
 * IP 192.168.0.105
 */
public class MainActivity extends BaseActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private long firstTime;
    private MyViewPager mViewPager;
    private List<View> mViews = new ArrayList<>();
    private LinearLayout mTabWeiXin;
    private LinearLayout mTabFrd;
    private LinearLayout mTabSetting;
    private ImageButton mWeiXinImg;
    private ImageButton mFrdImg;
    private ImageButton mSettingImg;
    private DrawerLayout mDrawerLayout;
    private Intent mIntent;
    private TextView mToolbarText;
    private ImageView mBackIcon;
    private TextView mMy;
    private TextView mHome;
    private TextView mFind;
    private ImageView mCurrentCooking;
    private String content = "";
    private BufferedReader mReader;
    private BufferedWriter mWriter;
    private String mName;
    private boolean isNormalTemp = true;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: " + msg.obj.toString());
            if (msg.obj.toString().contains("C")){
                String string1="锅外温度：";
                String string= msg.obj.toString();
                String s=string.substring(0,string.length()-1);
                Toast.makeText(MainActivity.this, "温度 " + s, Toast.LENGTH_SHORT).show();
                StringBuffer stringBuffer=new StringBuffer(s);
                String s1= String.valueOf(stringBuffer.append("℃"));
                Log.d(TAG, "handleMessage: " + s);
//                SpannableStringBuilder builder = new SpannableStringBuilder(string1+s1);
//                builder.setSpan(new ForegroundColorSpan(Color.RED),string1.length(),(s1+string1).length(), Spanned.SPAN_EXCLUSIVE_INCLUSIVE);
//                if (Float.parseFloat(s)>120.0f){
//                    Log.d(TAG, "handleMessage:锅外温度： " + s1);
//                    Toast.makeText(MainActivity.this, "温度过高！", Toast.LENGTH_SHORT).show();
//                    CustomToast.showToast(ShowDetailActivity.this,"温度过高!电磁炉已关闭",R.drawable.fire);
//                }
//                Log.d(TAG, "handleMessage: 温度" + s1);
//                Toast.makeText(MainActivity.this, "有d", Toast.LENGTH_SHORT).show();



                if (Float.parseFloat(s) > 70 && Float.parseFloat(s) < 1000 && isNormalTemp) {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("警告！");
                    dialog.setMessage("温度过高，已关闭烹饪设备！");
                    dialog.setCancelable(false);
                    dialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
//                        mConnectionThread.sendMessage("stop");
                            dialog.cancel();
                        }
                    });
                    dialog.show();
                    isNormalTemp = false;
                }



            }
        }
    };
    private DataOutputStream mOut;
    private ConnectionThread mConnectionThread;
    private DataInputStream mDataInputStream;
    private Socket mSocket;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        mConnectionThread = new ConnectionThread();
//        initSocket();
        addActivity(this);
        initView();
        //初始化四个布局，并且设置适配器，将画面填充到ViewPage上
        initViewPage();
        //初始化事件逻辑
        initEvent();
        addActivity(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mConnectionThread.initSocket2();
    }

    /**
     * 处理返回按钮，连续两次才能推出活动
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (System.currentTimeMillis() - firstTime < 2000) {
                finish();
            } else {
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            }
            firstTime = System.currentTimeMillis();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 初始化设置
     */
    private void initView() {
        mCurrentCooking = (ImageView) findViewById(R.id.current_cooking);
        mCurrentCooking.setOnClickListener(this);
        mMy = (TextView) findViewById(R.id.my);
        mHome = (TextView) findViewById(R.id.home);
        mFind = (TextView) findViewById(R.id.find);
        mToolbarText = (TextView) findViewById(R.id.toolbar_text);
        mBackIcon = (ImageView) findViewById(R.id.back_button);
        mBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mToolbarText.setText("智能厨房");
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mViewPager = (MyViewPager) findViewById(R.id.id_view_page);
        mViewPager.setScanScroll(false);
        // 初始化3个LinearLayout
        mTabWeiXin = (LinearLayout) findViewById(R.id.id_tab_weixin);
        mTabFrd = (LinearLayout) findViewById(R.id.id_tab_frd);
        mTabSetting = (LinearLayout) findViewById(R.id.id_tab_settings);
        // 初始化3个按钮
        mWeiXinImg = (ImageButton) findViewById(R.id.id_tab_weixin_img);
        //打开主活动时先将home按钮设置为被点击状态
        mWeiXinImg.setImageResource(R.drawable.home_pressed);
        mMy.setTextColor(ContextCompat.getColor(this, R.color.bottomNormal));
        mFind.setTextColor(ContextCompat.getColor(this, R.color.bottomNormal));
        mHome.setTextColor(ContextCompat.getColor(this, R.color.colorPrimary));
        mFrdImg = (ImageButton) findViewById(R.id.id_tab_frd_img);
        mSettingImg = (ImageButton) findViewById(R.id.id_tab_settings_img);
    }

    private void initViewPage() {

        // 初始化3个碎片布局
        LayoutInflater mLayoutInflater = LayoutInflater.from(this);
        View tab01 = mLayoutInflater.inflate(R.layout.tab01_fragment, null);
        View tab02 = mLayoutInflater.inflate(R.layout.tab02_fragment, null);
        View tab03 = mLayoutInflater.inflate(R.layout.tab03_fragment, null);

        /*
        mViews是List
        tab是布局
        把布局对象添加到List中
         */
        mViews.add(tab01);
        mViews.add(tab02);
        mViews.add(tab03);

        /**
         * 适配器初始化并设置
         * 作用：将页面填充到ViewPager中
         */
        BottomAdapter adapter = new BottomAdapter(mViews);
        mViewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View arg0) {
        /*
        点击一个底部栏后，跳转到相应的ViewPage，将所有图标设置为黑色，再设置亮的图标
        setCurrentItem最终会切换到传入的第几个布局
         */
        switch (arg0.getId()) {
            case R.id.id_tab_weixin:
                mViewPager.setCurrentItem(0);
                resetImg();
                mWeiXinImg.setImageResource(R.drawable.home_pressed);
                mHome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                break;
            case R.id.id_tab_frd:
                mViewPager.setCurrentItem(1);
                resetImg();
                mFrdImg.setImageResource(R.drawable.find_pressed);
                mFind.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                break;
            case R.id.id_tab_settings:
                mViewPager.setCurrentItem(2);
                resetImg();
                mSettingImg.setImageResource(R.drawable.my_pressed);
                mMy.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                break;
            case R.id.nav_head:
                mIntent = new Intent(MainActivity.this, HeadActivity.class);
                startActivity(mIntent);
                mDrawerLayout.closeDrawers();
                overridePendingTransition(R.anim.head_in,R.anim.head_out);
                break;
            case R.id.current_cooking:
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("警告！");
                dialog.setMessage("是否强制关闭电磁炉？");
                dialog.setCancelable(false);
                dialog.setPositiveButton("否", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                dialog.setNegativeButton("是", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mConnectionThread.sendMessage("stop");
                    }
                });
                dialog.show();
                break;
            default:
                break;
        }
    }

    /**
     * 处理事件逻辑
     * 切换页面监听器，当已经切换了界面才会调用
     * 所以不用再切换界面，因为已经切换了
     */
    private void initEvent() {

        /**
         * mTabWeiXin是3个LinearLayout其中的一个
         * 设置监听器，在onClick方法中处理逻辑（点击底部栏的时候的效果）
         */
        mTabWeiXin.setOnClickListener(this);
        mTabFrd.setOnClickListener(this);
        mTabSetting.setOnClickListener(this);

        /*
        setOnPageChangeListener已经过时了
         */
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            /**
             *ViewPage左右滑动时
             *ViewPage
             */
            @Override
            public void onPageSelected(int arg0) {
                int currentItem = mViewPager.getCurrentItem();
                switch (currentItem) {
                    /*
                    滑动到某一个ViewPage，会通过ViewPager的getCurrentItem方法获取当前
                    项，将底部栏的3个图标都设置为黑色的，然后根据所选的项设置相应的“亮了”的图片
                     */
                    case 0:
                        resetImg();
                        mWeiXinImg.setImageResource(R.drawable.home_pressed);
                        mHome.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                        break;
                    case 1:
                        resetImg();
                        mFrdImg.setImageResource(R.drawable.find_pressed);
                        mFind.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                        break;
                    case 2:
                        resetImg();
                        mSettingImg.setImageResource(R.drawable.my_pressed);
                        mMy.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.colorPrimary));
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {

            }
        });
    }

    /**
     * 把所有图片变暗
     */
    private void resetImg() {
        mWeiXinImg.setImageResource(R.drawable.home_normal);
        mFrdImg.setImageResource(R.drawable.find_normal);
        mSettingImg.setImageResource(R.drawable.my_normal);
        mMy.setTextColor(ContextCompat.getColor(this, R.color.bottomNormal));
        mFind.setTextColor(ContextCompat.getColor(this, R.color.bottomNormal));
        mHome.setTextColor(ContextCompat.getColor(this, R.color.bottomNormal));
    }





//    private class ConnectionThread extends Thread {
//        String message = null;
//
//        public ConnectionThread(String message) {
//            this.message = message;
//        }
//
//        @Override
//        public void run() {
//            boolean isStartRecieveMsg = true;
//            try {
//                /**
//                 * 正式的
//                 */
////                mIpString = "192.168.0.105";
//                mIpString = "192.168.0.172";
//                Log.d(TAG, "run: 4");
//                mSocket = new Socket(mIpString, 8888);
////                SocketAddress socketAddress = new InetSocketAddress(mIpString, 8888);
////                mSocket.connect(socketAddress, 100);//连不上的0.1毫秒断掉连接
////                mSocket.setSoTimeout(timeout);
//                Log.d(TAG, "run: 2");
//                mReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
//                mWriter = new BufferedWriter(new OutputStreamWriter(mSocket.getOutputStream(), "utf-8"));
//                //接收来自服务器的消息
//                while (isStartRecieveMsg) {
//                    if (mReader.ready()) {
//                         /*读取一行字符串，读取的内容来自于客户机
//                            reader.readLine()方法是一个阻塞方法，
//                            从调用这个方法开始，该线程会一直处于阻塞状态，
//                            直到接收到新的消息，代码才会往下走*/
//                        //String data = mReader.readLine();
//                        String txt = "";
//                        while ((content = mReader.readLine()) != null) {
//                            //txt = content ;
//                            mHandler.sendMessage(mHandler.obtainMessage(0, content));
//                        }
//                        //handler发送消息，在handleMessage（）方法中接收
//                        //mHandler.obtainMessage(0, data).sendToTarget();
//                    }
//                }
//
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            } catch (UnknownHostException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    public class ConnectionThread {

        private String mString;
        private String mResponseMessage;

        public void sendMessage() {
            initSocket2();
        }

        private void initSocket2() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    boolean isStartRecieveMsg = true;
                    try {
                        mSocket = new Socket("192.168.0.105", 8888);
//                        mReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
                        mOut = new DataOutputStream(mSocket.getOutputStream());
//                        mDataInputStream = new DataInputStream(mSocket.getInputStream());
                        mReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));

//                    Log.d(TAG, "runsaaad: " + in.readUTF());


//                     接收服务器的返回数据


//                        while (isStartRecieveMsg) {
//                            Log.d(TAG, "runfff: ");
//                            String s = mDataInputStream.readUTF();
//                            mSocket = new Socket("192.168.0.105", 8888);
//                            mDataInputStream = new DataInputStream(mSocket.getInputStream());
//                            if (s!=null) {
//                                Log.d(TAG, "runfff: " + s);
//                            }
//                            mHandler.sendMessage(mHandler.obtainMessage(0, s));
//
//                        }


                        while (isStartRecieveMsg) {
                            if (mReader.ready()) {

                         /*读取一行字符串，读取的内容来自于客户机
                            reader.readLine()方法是一个阻塞方法，
                            从调用这个方法开始，该线程会一直处于阻塞状态，
                            直到接收到新的消息，代码才会往下走*/
                                //String data = mReader.readLine();
                                String txt = "";
                                while ((content = mReader.readLine()) != null) {
//                                    mSocket = new Socket("192.168.0.105", 8888);
                                    //txt = content ;
                                    mHandler.sendMessage(mHandler.obtainMessage(0, content));
                                    Log.d(TAG, "run: " + content);
                                }
                                //handler发送消息，在handleMessage（）方法中接收
                                //mHandler.obtainMessage(0, data).sendToTarget();
                            }
                        }

//                        while (isStartRecieveMsg) {
//                            if (mReader.ready()) {
//                         /*读取一行字符串，读取的内容来自于客户机
//                            reader.readLine()方法是一个阻塞方法，
//                            从调用这个方法开始，该线程会一直处于阻塞状态，
//                            直到接收到新的消息，代码才会往下走*/
//                                String data = mReader.readLine();
//                                String txt = "";
//                                while ((content = mReader.readLine()) != null) {
//                                    txt = content ;
//                                    mHandler.sendMessage(mHandler.obtainMessage(0, content));
//                                }
//                                handler发送消息，在handleMessage（）方法中接收
//                                mHandler.obtainMessage(0, data).sendToTarget();
//                            }
//                        }



//                    DataInputStream in = new DataInputStream(socket.getInputStream());
//                    Log.d(TAG, "runsaaad: " + in.readUTF());
//                    mResponseMessage = in.readUTF();
                        Log.d(TAG, "runfff: ");
//                    if (mResponseMessage.equals("start")) {
//                        Log.d(TAG, "runaaa: ");
//                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
//                        startActivity(intent);
//                    }
//                    socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        public void sendMessage(String s) {
            try {
                byte b[] = s.getBytes();
                mOut.write(b);
                mOut.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        try {
            if (mSocket != null) {
                mConnectionThread.sendMessage("back");
                mSocket.close();
                mReader.close();
                mOut.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
