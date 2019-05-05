package edu.hzuapps.androidlabs.soft1614080902327;
        ;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class ImgUtils {
    //�����ļ���ָ��·��
    public static boolean saveImageToGallery(Context context, Bitmap bmp) {
        // ���ȱ���ͼƬ
        String storePath = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "demo";
        File appDir = new File(storePath);
        if (!appDir.exists()) {
            appDir.mkdir();
        }
        String fileName = System.currentTimeMillis() + ".jpg";
        File file = new File(appDir, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //ͨ��io���ķ�ʽ��ѹ������ͼƬ
            boolean isSuccess = bmp.compress(Bitmap.CompressFormat.JPEG, 60, fos);
            fos.flush();
            fos.close();

            //���ļ����뵽ϵͳͼ��
            //MediaStore.Images.Media.insertImage(context.getContentResolver(), file.getAbsolutePath(), fileName, null);

            //����ͼƬ���͹㲥֪ͨ�������ݿ�
            Uri uri = Uri.fromFile(file);
            context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            if (isSuccess) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}