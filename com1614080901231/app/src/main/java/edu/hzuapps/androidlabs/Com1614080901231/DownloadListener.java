package ezu.hzuapps.androidlabs.Com1614080901231;

/**
 * Created by BA on 2018/6/1 0001.
 */

//回调接口，专门用来给DownloadService监听DownloadTask的状态的
public interface DownloadListener {

    //当下载的进度发生改变的时候告诉service
    public void refleshProgress(int progress);

    //当已经暂停的时候告诉service
    public void onPaused();

    //已经取消的时候告诉service
    public void onCanceled();

    //任务完成的时候告诉service
    public void onSuccess();

    //任务失败的时候告诉service
    public void onFailed();

    //网络发生改变时告诉service
    public void onIntenet();
}