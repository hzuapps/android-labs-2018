?package com.example.shinelon.soft1614080902139;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import android.widget.EditText;
public class MainActivitysoft1614080902139 extends AppCompatActivity {

    String �ı�;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activitysoft1614080902139);
        setTitle("ÿ���Ƽ�����");

    } 
                   private void ��ʾ() {
                        SharedPreferences prefs = getSharedPreferences("data", MODE_PRIVATE); 
                        String ���� = prefs.getString("�ı�", ""); 
                        Toast.makeText(MainActivitysoft1614080902139.this, "�����ǣ�"+����, Toast.LENGTH_LONG).show();
                    }

               
                     private void ����(String �ı�) {
                            SharedPreferences.Editor et = getSharedPreferences("data", MODE_PRIVATE).edit();
                            et.putString("�ı�", �ı�);  
                            et.commit();
                            et.clear();
                            Toast.makeText(MainActivity.this, "���ͳɹ�", Toast.LENGTH_LONG).show();
                        }
               
                 public void onClick(View view) {   
       
                        switch (view.getId()) {
                                       case R.id.��ʾ��ť:
                                        ��ʾ();   
                                        break;
                                case R.id.���Ͱ�ť:
                                        EditText et = (EditText)findViewById(R.id.��������);
                                        �ı� = et.getText().toString();
                                        ����(�ı�);   
                                        break;
                              
                }

                }
    }
