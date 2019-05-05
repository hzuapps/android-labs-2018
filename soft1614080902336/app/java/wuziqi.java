package soft1614080902336.androidlabs.hzuapps.edu.wuziqi;

	import android.support.v7.app.AppCompatActivity;
		  import android.os.Bundle;
		 import android.content.Intent;
		 import android.view.View;
		  import android.view.View.OnClickListener;
		  import android.widget.Button;

class wuziqi extends AppCompatActivity implements OnClickListener{

		      @Override
		      protected void onCreate(Bundle savedInstanceState) {
		          super.onCreate(savedInstanceState);
		          setContentView(R.layout.content_wuziqirj);
        Button button = (Button) findViewById(R.id.button1);
		          button.setOnClickListener(this);
		      }

		      @Override
		      public void onClick(View v) {
        Intent intent=new Intent(wuziqi.this,wuziqirj.class);
		          startActivity(intent);
		      }

		 }