package edu.hzuapps.androidlabs.soft1613071002123.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hww on 2018/5/2.
 */

public class LoginActivity extends AppCompatActivity {
    private String[] data = {"apple", "banana", "orange", "watermelon", "pear", "grape", "pineapple", "strawberry", "cherry", "mango"};
    private List<File> fileList = new ArrayList<File>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        ImageView addImage = findViewById(R.id.plus_image);
        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(LoginActivity.this, DownloadActivity.class);
                startActivity(i);
            }
        });
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                LoginActivity.this, android.R.layout.simple_list_item_1, data);
        ListView listView = findViewById(R.id.liset_view);
        listView.setAdapter(adapter);

        //
        initFiles();
        FileAdapter adapter1 = new FileAdapter(LoginActivity.this, R.layout.file_layout, fileList);
        ListView listView1 = findViewById(R.id.liset_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(LoginActivity.this, "第" + i + "项", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(LoginActivity.this, InputActivity.class);
                startActivity(intent);
            }
        });
        listView.setAdapter(adapter);
    }

    private void initFiles(){
        File apple = new File("apple", R.drawable.empty);
        fileList.add(apple);
        File banana = new File("banana", R.drawable.empty);
        fileList.add(apple);
        File orange = new File("orange", R.drawable.empty);
        fileList.add(apple);
        File watermelon = new File("watermelon", R.drawable.empty);
        fileList.add(apple);
        File pear = new File("pear", R.drawable.empty);
        fileList.add(apple);
        File grape = new File("grape", R.drawable.empty);
        fileList.add(apple);
        File pineapple = new File("pineapple", R.drawable.empty);
        fileList.add(apple);
        File strawberry = new File("strawberry", R.drawable.empty);
        fileList.add(apple);
        File cherry = new File("cherry", R.drawable.empty);
        fileList.add(apple);
        File mango = new File("mango", R.drawable.empty);
        fileList.add(apple);
    }
}
