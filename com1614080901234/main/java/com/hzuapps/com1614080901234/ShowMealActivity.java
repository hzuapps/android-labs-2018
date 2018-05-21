package com.example.intelligentcooker;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.intelligentcooker.adapter.ShowMealAdapter;
import com.example.intelligentcooker.bean.Event;
import com.example.intelligentcooker.bean.Meal;
import com.example.intelligentcooker.database.EventDatabaseHelper;
import com.example.intelligentcooker.socket.SendMessage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 王治平
 */
public class ShowMealActivity extends AppCompatActivity {

    private static final String TAG = "ShowMealActivity";
    List<Event> mEventList = new ArrayList<>();
    private EventDatabaseHelper mHelper;
    private SQLiteDatabase mDatabase;
    private int mMinutes;
    private String mStep;
    private String mMeal;
    private List<Event> mList;
    private Button mAddMeal;
    private BufferedReader mReader;
    private BufferedWriter mWriter;
    private String content = "";
    private DataOutputStream mOut;
    private ConnectionThread mConnectionThread;
    private Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            Log.d(TAG, "handleMessage: " + msg.obj.toString());
        }
    };
    private Socket mSocket;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_meal);
        mConnectionThread = new ConnectionThread();
        mHelper = new EventDatabaseHelper(ShowMealActivity.this, "Meal.db", null, 3);
        mDatabase = mHelper.getWritableDatabase();

        initData();




        initAddMeal(mList);
        initView();

//        Cursor cursor = mDatabase.query("EventTable", null, null, null, null, null, null);
//        if (cursor.moveToFirst()) {
//            do {
//                Log.d(TAG, "onCreatdddddddename: " + cursor.getString(cursor.getColumnIndex("name")));
//                Log.d(TAG, "onCreatdddddddestep: " + cursor.getString(cursor.getColumnIndex("step")));
//                Log.d(TAG, "onCreatdddddddemin: " + cursor.getString(cursor.getColumnIndex("min")));
//                Log.d(TAG, "onCreatdddddddecontent: " + cursor.getString(cursor.getColumnIndex("content")));
//            } while (cursor.moveToNext());
//        }
//        cursor.close();

        initRecyclerView();







//        AlertDialog.Builder dialog = new AlertDialog.Builder(ShowMealActivity.this);
//        dialog.setTitle("警告！");
//        dialog.setMessage("温度过高，烹饪设备已关闭！");
//        dialog.setCancelable(false);
//        dialog.setNegativeButton("确定", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        dialog.show();








    }

    @Override
    protected void onResume() {
        super.onResume();
        mConnectionThread.initSocket2();
    }

    @Override
    protected void onPause() {
        super.onPause();
        try {
            if (mSocket != null) {
                mConnectionThread.sendMessage("back");
                mSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initData() {
        ImageView imageView = (ImageView) findViewById(R.id.meal_image);
        imageView.setImageResource((int)getIntent().getExtras().get("image"));
        mList = (List<Event>)getIntent().getSerializableExtra("list");
        for (int i = 0; i< mList.size(); i++) {
            Log.d(TAG, "onCredddate: " + mList.size());
            mMinutes = mList.get(i).getMinutes();
            mStep = mList.get(i).getNum();
            mMeal = mList.get(i).getMeal();
            Event event = new Event(mMinutes, mStep, mMeal);
            mEventList.add(event);
        }
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.meal_rv);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        ShowMealAdapter adapter = new ShowMealAdapter(mEventList ,this);
        /**
         * 这里
         */
        Log.d(TAG, "initRecyclerView: " + mEventList.size());
        recyclerView.setAdapter(adapter);
    }

    private void initAddMeal(final List<Event> alist) {
        mAddMeal = (Button) findViewById(R.id.add_meal);
        mAddMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ContentValues values = new ContentValues();
                for (int i=0; i<mEventList.size(); i++) {
                    Log.d(TAG, "onClickaaaaa: ");

                    values.put("name", (String)getIntent().getExtras().get("name"));
                    values.put("step", alist.get(i).getNum());
                    values.put("content", alist.get(i).getMeal());
                    values.put("min", alist.get(i).getMinutes());
                    Log.d(TAG, "onClick: " + alist.get(i).getNum());
                    Log.d(TAG, "onClick: " + alist.get(i).getMeal());
                    Log.d(TAG, "onClick: " + alist.get(i).getMinutes());
                    mDatabase.insert("EventTable", null, values);
                }
                Toast.makeText(ShowMealActivity.this, "添加成功！", Toast.LENGTH_SHORT).show();



                mConnectionThread.sendMessage("a\n");


            }
        });
    }

    private void initView() {
        boolean hideTrash = (Boolean) getIntent().getExtras().get("hideTrash");
        TextView title = (TextView) findViewById(R.id.toolbar_text);
        ImageView currentCooking = (ImageView) findViewById(R.id.current_cooking);
        currentCooking.setImageResource(R.drawable.trash);
        if (hideTrash) {
            currentCooking.setVisibility(View.GONE);
        } else {
            mAddMeal.setVisibility(View.GONE);
        }
        currentCooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(ShowMealActivity.this);
                dialog.setMessage("是否删除该菜谱？");
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
                        EventDatabaseHelper mHelper;
                        SQLiteDatabase mDatabase;
                        mHelper = new EventDatabaseHelper(ShowMealActivity.this, "Meal.db", null, 3);
                        mDatabase = mHelper.getWritableDatabase();
                        mDatabase.delete("EventTable", "name = ? ", new String[]{(String)getIntent().getExtras().get("name")});



                        Intent intent = new Intent(ShowMealActivity.this, MyMealActivity.class);
                        intent.putExtra("closeActivity", true);
                        startActivity(intent);
                        finish();

                        if ("清汤牛丸".equals((String)getIntent().getExtras().get("name"))) {
                            mConnectionThread.sendMessage("b\n");
                        }

                        Toast.makeText(ShowMealActivity.this, "已删除菜谱！", Toast.LENGTH_SHORT).show();
                    }
                });
                dialog.show();
//                dialog.show();
//                EventDatabaseHelper mHelper;
//                SQLiteDatabase mDatabase;
//                mHelper = new EventDatabaseHelper(ShowMealActivity.this, "Meal.db", null, 3);
//                mDatabase = mHelper.getWritableDatabase();
//                mDatabase.delete("EventTable", "name = ? ", new String[]{(String)getIntent().getExtras().get("name")});
//                finish();





//                Intent data=new Intent();
//                data.putExtra("closeActivity", true);
//                setResult(0,data);





            }
        });

        title.setText((String)getIntent().getExtras().get("name"));
        ImageView backBtn = (ImageView) findViewById(R.id.back_button);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        mDatabase.delete("EventTable", "min > ? ", new String[]{"0"});
    }

    public class ConnectionThread {

        private String mString;
        private String mResponseMessage;

//        public void sendMessage() {
//            initSocket2();
//        }

        private void initSocket2() {
            new Thread(new Runnable() {
                @Override
                public void run() {
//                    boolean isStartRecieveMsg = true;
                    try {
                        mSocket = new Socket("192.168.0.105", 8888);
//                        mReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
                        mOut = new DataOutputStream(mSocket.getOutputStream());
//                        mDataInputStream = new DataInputStream(mSocket.getInputStream());
//                        mReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
//                    Log.d(TAG, "runsaaad: " + in.readUTF());


//                     接收服务器的返回数据


//                        while (isStartRecieveMsg) {
////                            String s = mDataInputStream.readUTF();
//                            byte[] b = new byte[1024];
//                            mDataInputStream.read(b);
//                            Log.d(TAG, "ruddddddn: " + Arrays.toString(b));
//                            mSocket = new Socket("192.168.0.105", 8888);
//                            mDataInputStream = new DataInputStream(mSocket.getInputStream());
////                            if (s!=null) {
////                                Log.d(TAG, "runfff: " + s);
////                            }
////                            mHandler.sendMessage(mHandler.obtainMessage(0, s));
//
//                        }

//                        while (isStartRecieveMsg) {
//                            if (mReader.ready()) {
//
//                         /*读取一行字符串，读取的内容来自于客户机
//                            reader.readLine()方法是一个阻塞方法，
//                            从调用这个方法开始，该线程会一直处于阻塞状态，
//                            直到接收到新的消息，代码才会往下走*/
//                                //String data = mReader.readLine();
//                                String txt = "";
//                                while ((content = mReader.readLine()) != null) {
//                                    mSocket = new Socket("192.168.0.105", 8888);
//                                    mReader = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
//                                    //txt = content ;
//                                    mHandler.sendMessage(mHandler.obtainMessage(0, content));
//                                    Log.d(TAG, "run: " + content);
//                                }
//                                //handler发送消息，在handleMessage（）方法中接收
//                                //mHandler.obtainMessage(0, data).sendToTarget();
//                            }
//                        }


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
//                        Log.d(TAG, "runfff: ");
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



        /**
         * 要发送出去的字符串
         * @param s
         */
        public void sendMessage(final String s) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        byte b[] = s.getBytes();
                        Log.d(TAG, "run23334 " + s);

                        if (mSocket != null) {
                            mOut.write(b);
                            mOut.flush();
                        }

                        Log.d(TAG, "run23333: " + s);
//                        mSocket = new Socket("192.168.0.105", 8888);
//                        mOut = new DataOutputStream(mSocket.getOutputStream());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }

    }




}
