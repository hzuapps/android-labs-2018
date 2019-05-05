# 第5次实验
 
## 1.实验目标
* 新增soft1614080902329NewPassActivity用于新增密码Item
* 加入对每个Item进行显示的Dialog
* 将数据持久化
 
## 2.实验步骤
### 1. 新增soft1614080902329NewPassActivity用于新增密码Item，并存储在Sqlite中

* 布局
``` xml
        <EditText
            android:id="@+id/new_username"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="用户名"
            android:textSize="26dp"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="60px"
            />

        <EditText
            android:id="@+id/new_password"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:ems="10"
            android:hint="密码"
            android:textSize="26dp"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="60px"
            />


        <Button
            android:id="@+id/save"
            android:layout_width="170sp"
            android:layout_height="wrap_content"
            android:text="保存"
            android:textSize="26dp"
            android:layout_gravity="center_horizontal"
            android:layout_marginTop="200px"
            />

    </LinearLayout>
```

* 获取相关控件
``` java
      newPassButton = findViewById(R.id.save);
      tipMsgEditText = findViewById(R.id.tip_msg);
      newUsernameEditText = findViewById(R.id.new_username);
      newPasswrodEditText = findViewById(R.id.new_password);
```

* 判断数据是否合理
``` java
if(tipMsg.isEmpty() || newUsername.isEmpty() || newPassword.isEmpty()){
                Toast.makeText(soft1614080902329NewPassActivity.this,"信息不完整",Toast.LENGTH_SHORT).show();
            }else{ //合理，可进行存储
                DB = SQLiteDatabase.openOrCreateDatabase(getFilesDir() + "/pass_record_info.db", null);//打开pass_record_info数据库，没有则创建一个
                String sql = "insert into pass values (?,?,?);";
                DB.execSQL(sql,new String[] { tipMsg, newUsername, newPassword});
                Toast.makeText(soft1614080902329NewPassActivity.this,"保存成功",Toast.LENGTH_SHORT).show();
            }
```

### 2.对soft1614080902329RecordActivity进行改进和功能增加

* 新增意图使this与soft1614080902329NewPassActivity关联起来
``` java
Button newPass = findViewById(R.id.new_pass);
        newPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(soft1614080902329RecordActivity.this, soft1614080902329NewPassActivity.class);
                soft1614080902329RecordActivity.this.startActivity(intent);
            }
        });
    showListView();//在onCreate中，即app一运行先执行一次
```

* 封装ListView的显示过程，设置对每个Item进行显示的Dialog
``` java
private void showListView() {
    msgList = new ArrayList();
    String sql = "select * from pass";
    Cursor cursor;
    try{ //用于确保数据表是存在的
        cursor = DB.rawQuery(sql, null);
    }catch (Exception e){
        createTable();
        cursor = DB.rawQuery(sql, null);
    }
    itemCount = cursor.getCount();
    while (cursor.moveToNext()){
        String pmsg = cursor.getString(cursor.getColumnIndex("Pmsg"));
        Log.v("sys",pmsg);
        msgList.add(pmsg);
    }

    LvPassList.setAdapter(new passAdapter());

    LvPassList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView msg = (TextView)view;
            final String strMsg = msg.getText().toString().trim();

            if(!strMsg.isEmpty()){

                String sql = "select * from pass where Pmsg = ?";
                Cursor cursor = DB.rawQuery(sql, new String[] {strMsg});
                cursor.moveToNext();
                String pUsername = cursor.getString(cursor.getColumnIndex("Pusername"));
                String pPassword = cursor.getString(cursor.getColumnIndex("Ppassword"));

                //设置Dialog
                AlertDialog dialog = new AlertDialog.Builder(soft1614080902329RecordActivity.this) 
                        .setTitle(strMsg)//设置对话框的标题
                        .setMessage("\n\n" + "用户名:    " + pUsername + "\n\n" + "密    码:    " + pPassword)
                        .setNegativeButton("修改", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        }).setNeutralButton("删除",new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String sql = "delete from pass where Pmsg = ?";
                                DB.execSQL(sql,new String[] {strMsg});
                                Toast.makeText(soft1614080902329RecordActivity.this,"删除成功",Toast.LENGTH_SHORT).show();
                                showListView(); //此处用于ListView的数据刷新
                                dialog.dismiss();
                            }
                        }).create();
                dialog.show();
            }

        }
    });
}
```

* 在soft1614080902329NewPassActivity中完成新增后，执行该函数，使数据刷新
``` java
 @Override
    protected void onRestart() {
        super.onRestart();
        showListView();
        Log.v("life","onRestart");
    }
```

* 在soft1614080902329RecordActivity消亡时执行，关闭数据库连接（刚想起来cursor忘关了，下次实验改）
``` java
@Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("life","onDestroy");
        DB.close();
    }
```

* 修改后的适配器
``` java
    private class passAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return itemCount + 1; //+1布局问题，哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tvMsg;
            if(convertView == null){
                tvMsg = new TextView(soft1614080902329RecordActivity.this);
            }else {
                tvMsg = (TextView) convertView;
            }
            if(position < itemCount){
                itemMsg = (String) msgList.get(position);
            }else{
                itemMsg = "";
            }
            tvMsg.setText(itemMsg);
            tvMsg.setTextSize(32);
            tvMsg.setPadding(50,50,0,50);
            return tvMsg;
        }
    }
```

 
## 3.实验结果
* 实验截图
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab5_1.png)
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab5_2.png
)
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab5_3.png)
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab5_4.png)
![实验截图](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab5_5.png
)

## 4.实验体会 

* 搞完睡觉，累 

## 5.调试笔记,完整版，语法的什么弱爆了好么，中文乱码什么的，用英文不就好了

``` SQL
C:\Users\Orange>adb shell
generic_x86:/ $ su
generic_x86:/ # cd data/data/edu.soft1614080902329.password_record/
generic_x86:/data/data/edu.soft1614080902329.password_record # cd files/
generic_x86:/data/data/edu.soft1614080902329.password_record/files # ls
instant-run pass_record_info.db pass_record_info.db-journal
generic_x86:/data/data/edu.soft1614080902329.password_record/files # sqlite3 pass_record_info.db
SQLite version 3.19.4 2017-08-18 19:28:12
Enter ".help" for usage hints.
sqlite> create table user(
   ...> Uid int primary key auto_increment,
   ...> Uusername varchar(20),
   ...> Upassword varchar(20)
   ...> )charset utf8;
Error: near "auto_increment": syntax error
sqlite> create table user(
   ...> Uid int primary key autoincrement,
   ...> Uusername varchar(20),
   ...> Upassword varchar(20)
   ...> )charset utf8;
Error: AUTOINCREMENT is only allowed on an INTEGER PRIMARY KEY
sqlite> create table user(
   ...> Uid integer PRIMARY KEY autoincrement,
   ...> Uusername varchar(20),
   ...> Upassword varchar(20)
   ...> );
sqlite> .tables
android_metadata  user
sqlite> inster into user values
   ...> (null,'Orange','123456'),
   ...> (null,'OrangeHap','125658');
Error: near "inster": syntax error
sqlite> insert into user values
   ...> (null,'Orange','123645'),
   ...> (null.'OrangeHap','555212');
Error: near ".": syntax error
sqlite> insert into user values
   ...> (null,'Orange','123456'),
   ...> (null,'OrangeHap,'6233');
   ...> select * from user;
   ...> .user
   ...> ;
   ...> ;
   ...>;
   ...> ;
   ...> ;
   ...> ;
   ...> ^C^C^C1|generic_x86:/data/data/edu.soft1614080902329.password_record/files qlite3 pass_record_info.db                                                       <
SQLite version 3.19.4 2017-08-18 19:28:12
Enter ".help" for usage hints.
sqlite> .tables
android_metadata  user
sqlite> select * from user;
sqlite> insert into user values
   ...> (null,'Orange','123456'),
   ...> (null,'OrangeHap,'6233');
   ...> ;;;;;
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...>
   ...> gsff
   ...>
   ...> '
   ...> ;
Error: near "6233": syntax error
sqlite> insert into user values (null,'O','56');
sqlite> select * from user;
1|O|56
sqlite> create table pass(
   ...> Pmsg varchar(20),
   ...> Pusername varchar(20),
   ...> Ppassword varchar(20),
   ...> Uid integer);
sqlite> .tables
android_metadata  pass              user
sqlite> insert into pass values ('QQpassword','gggg','56515',1);
sqlite> insert into pass values ('email','hhhhh','6215',1);
sqlite> select * from pass;
QQÃÃQQpassword|gggg|56515|1
email|hhhhh|6215|1
sqlite> insert into pass values ('QQÃÜ?,'ddsf,'5665',1);
   ...> ^C^C^C1|generic_x86:/data/data/edu.soft1614080902329.password_record/files #
qlite3 pass_record_info.db                                                       <
SQLite version 3.19.4 2017-08-18 19:28:12
Enter ".help" for usage hints.
sqlite> delete from user where Pusername = 'gggg';
Error: no such column: Pusername
sqlite> delect form pass where Pusername = 'gggg';
Error: near "delect": syntax error
sqlite> delete form pass where Pusername = 'gggg';
Error: near "form": syntax error
sqlite> delete from pass where Pusername = 'gggg';
sqlite> insert into pass values ('QQ','dadf','fdsa',1);
sqlite> insert into pass values ('µçÄÔÃÜÂë','dadf','fdsa',1);
sqlite> insert into pass values ('GitHubÃÜÂë','dadf','fdsa',1);
sqlite> insert into pass values ('GitÃÜÂë','dadf','fdsa',1);
sqlite> insert into pass values ('ÒøÐÐÃÜÂë','dadf','fdsa',1);
sqlite> insert into pass values ('ÖÇÉÌÃÜÂë','dadf','fdsa',1);
sqlite> insert into pass values ('Êó±êÃÜÂë','dadf','fdsa',1);insert into pass value
   ...> ;
Error: near "in": syntax error
sqlite> insert into pass values ('Êó±êÃÜÂë','dadf','fdsa',1);
sqlite> insert into pass values ('¾ø¶ÔÊÇÃÜÂë','dadf','fdsa',1);
sqlite> select * from pass;
email|hhhhh|6215|1
QQ|dadf|fdsa|1
µçÄÔÃÜÂë|dadf|fdsa|1
GitHubÃÜÂë|dadf|fdsa|1
GitÃÜÂë|dadf|fdsa|1
ÒøÐÐÃÜÂë|dadf|fdsa|1
ÖÇÉÌÃÜÂë|dadf|fdsa|1
Êó±êÃÜÂë|dadf|fdsa|1
¾ø¶ÔÊÇÃÜÂë|dadf|fdsa|1
sqlite> delete from pass where Pusername = 'dadf';
sqlite> select * from pass;
email|hhhhh|6215|1
sqlite> insert into pass values ('QQ','dadf','fdsa',1);
sqlite> insert into pass values ('Githup','dadf','fdsa',1);
sqlite> insert into pass values ('MySql','dadf','fdsa',1);
sqlite> insert into pass values ('Apache','dadf','fdsa',1);
sqlite> insert into pass values ('diandao','dadf','fdsa',1);
sqlite> insert into pass values ('dian','dadf','fdsa',1);
sqlite> insert into pass values ('diajhhhn','dadf','fdsa',1);insert into pass values ('diajhhhn','dadf','fdsa',1);
sqlite> insert into pass values ('dihhn','dadf','fdsa',1);
sqlite> ^C^C^C1|generic_x86:/data/data/edu.soft1614080902329.password_record/files #
130|generic_x86:/data/data/edu.soft1614080902329.password_record/files #
```

### Activity 生命周期一览（引用）

![生命周期](https://github.com/OrangeHap/android-labs-2018/blob/master/soft1614080902329/lab5_life.png)

* 所谓的典型的生命周期就是在有用户参与的情况下，Activity经历从创建，运行，停止，销毁等正常的生命周期过程。我们这里先来介绍一下几个主要方法的调用时机，然后再通过代码层面来验证其调用流程。
* <font color="red">onCreate </font>: 该方法是在Activity被创建时回调，它是生命周期第一个调用的方法，我们在创建Activity时一般都需要重写该方法，然后在该方法中做一些初始化的操作，如通过setContentView设置界面布局的资源，初始化所需要的组件信息等。
* <font color="red">onStart </font>: 此方法被回调时表示Activity正在启动，此时Activity已处于可见状态，只是还没有在前台显示，因此无法与用户进行交互。可以简单理解为Activity已显示而我们无法看见摆了。
* <font color="red">onResume </font>: 当此方法回调时，则说明Activity已在前台可见，可与用户交互了（处于前面所说的Active/Running形态），onResume方法与onStart的相同点是两者都表示Activity可见，只不过onStart回调时Activity还是后台无法与用户交互，而onResume则已显示在前台，可与用户交互。当然从流程图，我们也可以看出当Activity停止后（onPause方法和onStop方法被调用），重新回到前台时也会调用onResume方法，因此我们也可以在onResume方法中初始化一些资源，比如重新初始化在onPause或者onStop方法中释放的资源。
* <font color="red">onPause </font>: 此方法被回调时则表示Activity正在停止（Paused形态），一般情况下onStop方法会紧接着被回调。但通过流程图我们还可以看到一种情况是onPause方法执行后直接执行了onResume方法，这属于比较极端的现象了，这可能是用户操作使当前Activity退居后台后又迅速地再回到到当前的Activity，此时onResume方法就会被回调。当然，在onPause方法中我们可以做一些数据存储或者动画停止或者资源回收的操作，但是不能太耗时，因为这可能会影响到新的Activity的显示——onPause方法执行完成后，新Activity的onResume方法才会被执行。
* <font color="red">onStop </font>: 一般在onPause方法执行完成直接执行，表示Activity即将停止或者完全被覆盖（Stopped形态），此时Activity不可见，仅在后台运行。同样地，在onStop方法可以做一些资源释放的操作（不能太耗时）。
* <font color="red">onRestart </font>:表示Activity正在重新启动，当Activity由不可见变为可见状态时，该方法被回调。这种情况一般是用户打开了一个新的Activity时，当前的Activity就会被暂停（onPause和onStop被执行了），接着又回到当前Activity页面时，onRestart方法就会被回调。
* <font color="red">onDestroy </font>:此时Activity正在被销毁，也是生命周期最后一个执行的方法，一般我们可以在此方法中做一些回收工作和最终的资源释放。


