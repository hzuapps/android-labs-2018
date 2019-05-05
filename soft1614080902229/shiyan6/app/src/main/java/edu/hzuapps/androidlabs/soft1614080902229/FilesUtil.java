package edu.hzuapps.androidlabs.soft1614080902229;

import android.content.Context;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FilesUtil {

	private void writeFiles(Context c, String fileName, String content, int mode)
			throws Exception {

		FileOutputStream fos = c.openFileOutput(fileName, mode);
		fos.write(content.getBytes());
		fos.close();
	}


	private String readFiles(Context c, String fileName) throws Exception {
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		FileInputStream fis = c.openFileInput(fileName);
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = fis.read(buffer)) != -1) {
			baos.write(buffer, 0, len);
		}
		String content = baos.toString();
		fis.close();
		baos.close();
		return content;
	}
}
