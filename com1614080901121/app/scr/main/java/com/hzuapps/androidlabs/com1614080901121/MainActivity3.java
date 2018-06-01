package edu.hzuapps.androidlabs.com1614080901121;

 import android.os.Bundle;
 import android.support.design.widget.FloatingActionButton;
 import android.support.design.widget.Snackbar;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.Toolbar;
 import android.view.View;

         import android.content.Context;

         import android.os.Bundle;

         import android.os.Environment;

         import android.support.v7.app.AppCompatActivity;

         import android.util.Log;

         import android.view.View;

         import android.widget.Button;

         import android.widget.EditText;

         import android.widget.TextView;

         import android.widget.Toast;



         import java.io.BufferedInputStream;

         import java.io.BufferedReader;

         import java.io.File;

         import java.io.FileInputStream;

         import java.io.FileNotFoundException;

         import java.io.FileOutputStream;

         import java.io.FileReader;

         import java.io.IOException;



         import myapplication3.com.example.myapplication3.R;

         public class Main3Activity extends AppCompatActivity {
     public static final String DIRECTORY = "demo";
     public static final String FILENAME = "file_demo.txt";
     public static final String TAG = Main3Activity.class.getSimpleName();

        @Override

             protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main3);
                ((Button) findViewById(R.id.bt1)).setOnClickListener(new View.OnClickListener() {

                    @Override

                    public void onClick(View view) {
                                String text = ((EditText) findViewById(R.id.view1)).getText().toString();
                                saveTextIntoInternalStorage(text);
                            }
        });
           }
    
             private void saveTextIntoInternalStorage(String text) {
                
                        File dir = this.getFilesDir();
               File dir = getCacheDir();
                       if (dir.isDirectory()) {
                        dir.mkdir();
                                dir.mkdirs();
                                    }
                if (dir.isFile()) {
                         D:/Abc.txt , -> D:/Abc1.txt ->D:/abc.txt
                            }
                File file = new File(dir, FILENAME);
               try {
                            File = File.createTempFile(FILENAME, null, dir);
                                } catch (IOException e) {
                                           e.printStackTrace();
                                                }
                                                        if (file.exists()) { 
                        Log.i(TAG, file.getAbsolutePath());
                       Log.i(TAG, file.length() + ""); 
                       Log.i(TAG, file.isFile() + "");
                        file.canRead();
                       file.canWrite();
                       file.canExecute();
                        file.getFreeSpace();
                        file.getTotalSpace();
                    }
                FileOutputStream fos = null;  
                try {
                        fos = openFileOutput(FILENAME, MODE_PRIVATE);
                        //FileOutputStream fos = new FileOutputStream(file);
                                fos.write(text.getBytes());
                        fos.close(); 
                    } catch (FileNotFoundException e) {
                       e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        try {
                                fos.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                    }
                FileReader reader = null; // char
                try {
                        reader = new FileReader(file.getAbsoluteFile());
                        BufferedReader bReader = new BufferedReader(reader);
                        String line = bReader.readLine();
                        Log.i(TAG, "从文件读取的内容: " + line);
                        bReader.close();
                        reader.close();
                  } catch (FileNotFoundException e) {
                       e.printStackTrace();
                   } catch (IOException e) {
                        e.printStackTrace();
                    }
             
                       showResult(file.getAbsolutePath());
              
                       // file.delete();
                               // deleteFile(FILENAME);
                                   }
   
            private void saveTextIntoExternalStorage(String text) {
               if (!isExternalStorageWritable()) {
                       Log.e(TAG, "外部存储不可写!");
                        return;
                   }
               File dir = getPublicExtStorageDir(DIRECTORY, Environment.DIRECTORY_DOWNLOADS);
              File file = new File(dir, FILENAME);
                try {
                        FileOutputStream fos = new FileOutputStream(file);
                        fos.write(text.getBytes());
                        fos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
               
                        showResult(file.getAbsolutePath());
            }
             private boolean isExternalStorageWritable() {
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state)) {
                        return true;
                   }
              return false;
            }
             private boolean isExternalStorageReadable() {
                String state = Environment.getExternalStorageState();
                if (Environment.MEDIA_MOUNTED.equals(state) ||
                                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
                       return true;
                   }
                return false;
           }
     
             private File getPublicExtStorageDir(String dirName, String type) {
                if (type == null) {
                        type = Environment.DIRECTORY_PICTURES;
                    }
                File dir = new File(Environment 
                                .getExternalStoragePublicDirectory(type), dirName);
               if (!dir.mkdirs()) {
                        Log.e(TAG, "目录无法创建!");
                    }
                long freeSpace = dir.getFreeSpace();
                Log.i(TAG, "剩余空间大小: " + (freeSpace / 1024 / 1024) + "MB");
                long totalSpace = dir.getTotalSpace();
                Log.i(TAG, "总空间大小: " + (totalSpace / 1024 / 1024) + "MB");
               return dir;
            }
    
             private File getPrivateExtStorageDir(Context context, String dirName, String type) {
               if (type == null) { 
                        type = Environment.DIRECTORY_PICTURES;
                   }
                File file = new File(context //
                                .getExternalFilesDir(type), dirName);
               if (!file.mkdirs()) {
                       Log.e(TAG, "目录无法创建!");
                    }
                return file;
           }
     private void showResult(String result) {
               ((TextView) findViewById(R.id.view2)) 
                                .setText(result.toCharArray(), 0, result.length());
            }
 }