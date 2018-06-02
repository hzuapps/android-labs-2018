package ezu.hzuapps.androidlabs.Com1614080901231;

import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by BA on 2018/6/1 0001.
 */

//第一个参数是你等下在耗时任务中将要用的数据的类型，第二个在你从子线程切换到主线程时想要从子线程带什么类型的数据给主线程，第三个声明是耗时任务结束后返回值的类型
public class DownloadTask extends AsyncTask<String, Integer, Integer> {

    //用于在线程中返回下载的结果
    private final int PAUSE = 1;
    private final int FAIL_CONNECTE=2;
    private final int CANCLE = 3;
    private final int SUCCESS = 4;
    private final int FAIL = 5;

    //用来控制下载状态的开关
    private boolean isPause = false;
    private boolean isCancel = false;

    public int lastProgest = 0;

    //服务监听下载状态的监听器
    private DownloadListener listener;

    //实例化的时候，服务会设置监听
    public DownloadTask(DownloadListener listener) {
        this.listener = listener;
    }

    //当doInBackground方法结束后，就会自动切换到主线程
    // 自动调用该方法，参数就是结果我们上面定义的返回结果
    //然后使用回调是告诉服务，下载的最后状态
    @Override
    protected void onPostExecute(Integer integer) {
        switch (integer) {
            case SUCCESS:
                listener.onSuccess();
                break;
            case FAIL:
                listener.onFailed();
                break;
            case PAUSE:
                listener.onPaused();
                break;
            case CANCLE:
                listener.onCanceled();
                break;
            case FAIL_CONNECTE:
                listener.onIntenet();
                break;
        }
    }

    //这个方法是用来告诉服务，下载的实时状态
    @Override
    protected void onProgressUpdate(Integer... values) {
        if (values[0] > lastProgest) {
            lastProgest = values[0];
            listener.refleshProgress(values[0]);
        }

    }

    //doInBackground()方法中
    // (第一个参数传入的时URL，第二个是储存的目录
    //这个方法会自动开启线程，所以我们在这里下载
    @Override
    protected Integer doInBackground(String... params) {
        String url = params[0];//获取下载的url

        //这个类用来操作文件，特点就是可以在已有的文件的末尾添加数据
        //用他来实现断点续传功能
        RandomAccessFile saveFile = null;

        //设置目录，名字是网址中最后一个 /  后面的字符串
        File file = new File(params[1], url.substring(url.lastIndexOf("/")));

        //记录已经下载了多少数据，为了实现断点续传
        long downloadedFile = 0;

        //带有缓冲区的字节流
        BufferedInputStream bi = null;
        try {
            //如果文件已经存在，说明下载过了，获取已经下载的数据大小
            if (file.exists())
                downloadedFile = file.length();
            else
                file.createNewFile();//没有下载过就新建文件
            //获取将要下载的文件大小，用来设置进度，还有判断上次下载的文件有没有下载完
            long downloadContentSize = getDownloadContentSize(url);
            if (downloadContentSize == 0) {
                return FAIL;//如果将要下载的文件获取不到数据，说明下载不了所以返回下载的结果
            }
            if (downloadedFile == downloadContentSize) {
                return SUCCESS;//如果下载过的文件数据大小等于将要下载的文件数据大小，说明上次下载成功了
            }
            //如果没有下载失败，而且下载没有完成或者没有下载，就开始下载
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(url)
                    //意思是，我们下载过的数据就不用请求下载了
                    .addHeader("RANGE", "bytes=" + downloadedFile + "-")
                    .build();
            Response response = client.newCall(request).execute();

            //如果请求的数据有返回，就写到文件中
            if (response != null) {
                //打开字节流
                InputStream is = response.body().byteStream();
                bi = new BufferedInputStream(is);
                byte[] bytes = new byte[1024 * 1024];
                //记录这一次已经下载的数据，用来更新下载进度
                int total, len;
                total = 0;
                //获取可以在文件末尾添加数据的实例，然后获取权限
                saveFile = new RandomAccessFile(file, "rw");
                //定位到文件中数据的末尾
                saveFile.seek(downloadedFile);
                //在每一次写入文件时判断用户有没有要求改变下载状态
                while ((len = bi.read(bytes)) != -1) {
                    if (isPause) {
                        return PAUSE;
                    } else if (isCancel) {
                        //既然取消了下载，那刚刚下载的文件就要删除掉
                        file.delete();
                        return CANCLE;
                    } else {
                        //如果没有，写入数据，将下载进度告诉服务，然后服务刷新控件
                        total += len;
                        saveFile.write(bytes, 0, len);
                        int progress = (int)
                                ((total + downloadedFile) * 100 / downloadContentSize);
                        publishProgress(progress);
                    }
                }
                //关闭流
                response.body().close();
                //执行到这一步说明下载已经成功了
                return SUCCESS;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bi != null)
                    bi.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果能执行到这一步，说明下载没成功，可能是网络问题
        return FAIL_CONNECTE;
    }

    //获取将要下载的文件的数据大小
    public long getDownloadContentSize(String url) throws IOException {
        long size = 0;
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        if (response != null && response.isSuccessful()) {
            size = response.body().contentLength();
            response.close();
        }
        return size;
    }

    //服务会调用这两个方法控制下载的状态
    public void onPauseDownload() {
        isPause = true;
    }

    public void onCancelDownload() {
        isCancel = true;
    }
}
