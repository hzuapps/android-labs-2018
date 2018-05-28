package soft1614080902336.androidlabs.hzuapps.edu.wuziqi;
		 import android.os.Bundle;
		 import android.content.Intent;
		 import android.support.design.widget.FloatingActionButton;
		 import android.support.design.widget.Snackbar;
		 import android.support.v7.app.AppCompatActivity;
		 import android.support.v7.widget.Toolbar;
		 import android.view.View;
		 import android.widget.Button;
		 import android.widget.EditText;
		 import android.widget.TextView;
		 import android.os.Handler;
		 import org.w3c.dom.Text;
		 import java.io.FileInputStream;
		 import java.io.FileOutputStream;

		  public class SecondActivity extends AppCompatActivity {

    private ImageView imageView;
		      private Button xiazai;
    private Handler handler=new Handler();

		      @Override
		      protected void onCreate(Bundle savedInstanceState) {
	          super.onCreate(savedInstanceState);
		         setContentView(R.layout.activity_Second);
		        xiazai=(Button)findViewById(R.id.button_xiazai);
	         xiazai.setOnClickListener(new View.OnClickListener() {
		                                        @Override
		                                        public void onClick(View v) {

                                          EditText tx= (EditText) findViewById(R.id.edittext_input);
		                                            String s = tx.getText().toString();

                                          imageView = (ImageView)findViewById(R.id.image_1);
                                          new HttpThread(s,imageView,handler).start();
		                                            if(!s.isEmpty())
		                                                write(s);

		                                           refreshHistoricalRecord(s);

		                                           Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);

	                                       }
		                                   }
		         );
		         initHistoricalRecord();

		     }

		     private void refreshHistoricalRecord(String msg)
		     {
		         if(msg==null) return;
		         TextView textView = (TextView) findViewById(R.id.textview_history);
		         String s = textView.getText().toString();
		         textView.setText(s+"\n"+msg);
		     }
		     private void initHistoricalRecord()
	     {
 		         TextView textView = (TextView) findViewById(R.id.textview_history);
	         String s = read();
	         if(s!=null)
		         refreshHistoricalRecord(s);
	     }

 	     public String read() {
		         try {
		             FileInputStream inStream = this.openFileInput("message.txt");
		             byte[] buffer = new byte[1024];
		             int hasRead = 0;
		             StringBuilder sb = new StringBuilder();
		             while ((hasRead = inStream.read(buffer)) != -1) {
		                 sb.append(new String(buffer, 0, hasRead));
		             }

		             inStream.close();
		             return sb.toString();
		         } catch (Exception e) {
		             e.printStackTrace();
		         }
		         return null;
		     }

		     public void write(String msg){
		          if(msg == null) return;
		          try {
          FileOutputStream fos = openFileOutput("message.txt",
		                      MODE_APPEND);
	              fos.write(msg.getBytes());

		             fos.close();
	         } catch (Exception e) {
		             e.printStackTrace();
		         }
		     }

	 }