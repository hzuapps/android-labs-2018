package ezu.hzuapps.androidlabs.Com1614080901231;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.example.ba.balabdemo.MainActivity;
import com.example.ba.balabdemo.R;

import java.io.File;

public class MyDownloadService extends Service {
    //记录将要下载数据的Url
    //我们知道，在我们点了开始下载后，会传一个url给服务，然后服务再去传给下载
    //很多时候我们在点击开始下载后，然后没有网络导致下载被暂停，然后我们取消下载
    //这个时候，如果文件是没有下载完的话，我们应该删除刚刚下载到的文件
    //但是程序并不知道发什么时候该删除，你看，如果是调用了start方法后，
    //再取消就是意味着，要删除，删除又要知道文件的地址，strat方法的参数就要传入文件目录，如果我们
    //在Strat方法中记录目录，然后在取消的时候判断有没有记录，有的话说明调用过Strat方法，那就删
    String url = null;
    String dir;

    //这个就是服务用来控制下载的
    //由于在上面的类中我们控制了暂停时或者取消已经结束了线程
    //所以每次开始我们都要新建一个Task对象
    DownloadTask dt = null;

    //等下用来给活动控制服务的
    private DownloadBind db = new DownloadBind();

    public class DownloadBind extends Binder {
        public void startDownload(String... value) {
            if (dt == null) {
                dt = new DownloadTask(downloadListener);
                dt.execute(value);
                url = value[0];
                dir = value[1];
                //开启前台服务，让下载进度显示出来
                startForeground(1, changeDownloadNotification("下载中", 0));
                Toast.makeText(MyDownloadService.this, "开始下载"
                        , Toast.LENGTH_SHORT).show();
            }
        }

        public void pause() {
            if (dt != null)
                dt.onPauseDownload();
        }

        //这里我们为啥要对dt是不是null，因为在我们可能会在下载的过程中取消下载
        //如果是下载的过程中。dt是非null的，所以直接控制下dt里面的方法来取消下载
        //如果在暂停的时候取消，就是null的
        public void cancel() {
            if (dt != null) {
                dt.onCancelDownload();
            } else if (url != null) {
                String name = url.substring(url.lastIndexOf("/"));
                File file = new File(dir, name);
                if (file.exists()) {
                    file.delete();
                }
                getNotificationManager().cancel(1);
                Toast.makeText(MyDownloadService.this, "已取消下载"
                        , Toast.LENGTH_SHORT).show();
            }
        }
    }

    public MyDownloadService() {
    }

    //这里就是给AsyncTask的回调方法，一旦暂停，什么的都要将dt设置为null，这样做的原因在
    //上一个注释里
    int nowProgress = 0;
    DownloadListener downloadListener = new DownloadListener() {
        @Override
        public void refleshProgress(int progress) {
            nowProgress = progress;
            getNotificationManager().notify(1, changeDownloadNotification(
                    "下载中", progress));
            Log.d("sssss", progress + "");
        }

        public void onIntenet(){
            //除了更新进度条，其他的都取消前台服务，原因很简单，取消下载，暂停下载
            //，不应该作为常驻通知
            stopForeground(true);
            dt=null;
            Toast.makeText(MyDownloadService.this,
                    "连接失败!", Toast.LENGTH_SHORT).show();
            getNotificationManager().notify(1, changeDownloadNotification(
                    "连接失败",nowProgress));
        }

        @Override
        public void onPaused() {
            stopForeground(true);
            dt = null;
            getNotificationManager()
                    .notify(1, changeDownloadNotification("暂停中", nowProgress));
            Toast.makeText(MyDownloadService.this,
                    "暂停下载", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCanceled() {
            stopForeground(true);
            dt = null;
            Toast.makeText(MyDownloadService.this,
                    "已取消下载！", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onSuccess() {
            stopForeground(true);
            dt = null;
            url = null;
            getNotificationManager()
                    .notify(1, changeDownloadNotification("下载成功", -1));
            Toast.makeText(MyDownloadService.this,
                    "下载成功！", Toast.LENGTH_SHORT).show();
            Log.d("sssss", nowProgress + "");
        }

        @Override
        public void onFailed() {
            stopForeground(true);
            dt = null;
            NotificationManager nm = getNotificationManager();
            nm.notify(1, changeDownloadNotification("下载失败", -1));
        }
    };
    public NotificationManager getNotificationManager() {
        return (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public Notification changeDownloadNotification(String situation, int progress) {
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setContentTitle(situation);
        if (progress > 0)
            builder.setContentText(progress + "%");
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setLargeIcon
                (BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher));
        builder.setContentIntent(pendingIntent);
        return builder.build();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return db;
    }
}
