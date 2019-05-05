package soft1614080902306.androidlabs.hzuapps.edu.Soft1614080902306;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import soft1614080902306.androidlabs.hzuapps.edu.myapplication.R;

public class Main3Activity extends AppCompatActivity {
    private Button mButtonDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mButtonDisplay = (Button) findViewById(R.id.B4);
        mButtonDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //从内部存储读取数据
                String s = getContent();
                Toast.makeText(Main3Activity.this, s, Toast.LENGTH_SHORT).show();

            }
        });
    }
    private String getContent() {
        String s = null;
        FileInputStream fis = null;
        try {
            //通过该方法从内部存储中的edit_data.txt文件中读取数据
            fis = this.openFileInput("edit_data.txt");
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = fis.read(buf)) != -1) {
                s = new String(buf, 0, len, "UTF-8");

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return s;
    }
}
