package edu.hzuapps.androidlabs.soft1614080902414;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Soft1614080902414a extends AppCompatActivity {
    private String[] data = {"Sport", "Study", "Work", "Music",
            "Health", "Read", "Fashion", "Food", "Pet", "Science" };
    private List<Activition> activityList = new ArrayList<Activition>();
    private LinearLayout s_sport;
    private LinearLayout s_study;
    private LinearLayout s_work;





    public class Activition {
        private String name;
        private int imageId;

        public Activition(String name, int imageId) {
            this.name = name;
            this.imageId = imageId;
        }

        public String getName() {
            return name;
        }

        public int getImageId() {
            return imageId;
        }
    }



   public class ActivitionAdapter extends ArrayAdapter{
        private final int resourceId;

        public ActivitionAdapter(Context context, int textViewResourceId, List<Activition> objects) {
            super(context, textViewResourceId, objects);
            resourceId = textViewResourceId;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Activition activity = (Activition) getItem(position); // 获取当前项的activity实例
            View view = LayoutInflater.from(getContext()).inflate(resourceId, null);//实例化一个对象
            ImageView ActivitionImage = (ImageView) view.findViewById(R.id.activition_image);//获取该布局内的图片视图
            TextView activityName = (TextView) view.findViewById(R.id.activition_name);//获取该布局内的文本视图
            ActivitionImage.setImageResource(activity.imageId);//为图片视图设置图片资源
            activityName.setText(activity.getName());//为文本视图设置文本内容
            return view;
        }
    }



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_soft1614080902414a);
            initActivitions();
            ActivitionAdapter adapter = new ActivitionAdapter(edu.hzuapps.androidlabs.soft1614080902414.Soft1614080902414a.this, R.layout.activition_item, activityList);
            ListView listView = (ListView) findViewById(R.id.list_view);
            listView.setAdapter(adapter);
        }

        private void initActivitions() {
            Activition Sport  = new Activition("Sport", R.drawable.sport);
            activityList.add(Sport);
            Activition Study = new Activition("Study", R.drawable.study);
            activityList.add(Study);
            Activition Work = new Activition("Work", R.drawable.work);
            activityList.add(Work);
            Activition Music = new Activition("Music", R.drawable.music);
            activityList.add(Music);
            Activition Health = new Activition("Health'", R.drawable.health);
            activityList.add(Health);
            Activition Read = new Activition("Read", R.drawable.read);
            activityList.add(Read);
            Activition Fashion = new Activition("Fashion", R.drawable.fashion);
            activityList.add(Fashion);
            Activition Food = new Activition("Food", R.drawable.food);
            activityList.add(Food);
            Activition Pet = new Activition("Pet", R.drawable.pet);
            activityList.add(Pet);
            Activition Science = new Activition("Science", R.drawable.science);
            activityList.add(Science);
        }
    }



