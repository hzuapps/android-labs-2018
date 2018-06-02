package com.hzu.com1614080901218;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public  class Com1614080901218Activity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_com1614080901218_main);
        final Activity Activity=this;
        Button btnOpen = (Button) findViewById(R.id.activity_second);

        btnOpen.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public  void onClick(View v){
                                           Intent intent = new Intent(Com1614080901218Activity.this, SecondActivity.class);

                                           startActivity(intent);


                                       }


                                   }
        );
        Button btnOpen1 = (Button) findViewById(R.id.activity_third);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                Intent intent = new Intent(Com1614080901218Activity.this, ThirdActivity.class);

                startActivity(intent);


            }


                                   }

        );
        Button btnOpen2 = (Button) findViewById(R.id.activity_four);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public  void onClick(View v){
                                            Intent intent = new Intent(Com1614080901218Activity.this, FourActivity.class);

                                            startActivity(intent);


                                        }


                                    }

        );

        Button btnOpen3 = (Button) findViewById(R.id.activity_tp);
        btnOpen1.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public  void onClick(View v){
                                            Intent intent = new Intent(Com1614080901218Activity.this, tpActivity.class);

                                            startActivity(intent);


                                        }


                                    }

        );


    }


}

