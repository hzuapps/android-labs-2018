package edu.hzuapps.androidlabs;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.ImageView;

public class Soft1613071002201Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1613071002201);

        ImageView image1=(ImageView)findViewById(R.id.clothAdd);
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Soft1613071002201Activity.this,Add.class);
                startActivity(intent1);
            }
        });
        ImageView image2=(ImageView)findViewById(R.id.clothSearch);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Soft1613071002201Activity.this,Search.class);
                startActivity(intent2);
            }
        });
    }
}
