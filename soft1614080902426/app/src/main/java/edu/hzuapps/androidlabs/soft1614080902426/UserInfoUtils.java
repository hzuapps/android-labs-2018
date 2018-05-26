package edu.hzuapps.androidlabs.soft1614080902426;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;


public class UserInfoUtils {
    // 保存用户名和密码的业务方法
    public static boolean saveInfo(Context context, String username, String pwd) {

        try {

            String result = username + "##" + pwd;

            // [3]通过上下文获取FileOutputStream
            File file = new File("data/data/edu.hzuapps.androidlabs.soft1614080902426/info.txt");
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(result.getBytes());
            fos.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
