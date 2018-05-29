package edu.hzuapps.androidlabs.soft1614080902427;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public abstract class DownloaderListener {
    public DownloaderListener() {
    }

    public void onError(String url) {

    }

    public void onDone(String url, ByteArrayOutputStream stream) {

    }
}
