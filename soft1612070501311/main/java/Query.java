package edu.hzuapps.androidlabs.soft1612070501311;

import android.app.Activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import android.app.Activity;
import org.json.JSONObject;
import static edu.hzuapps.androidlabs.soft1612070501311.R.*;

public class Query extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query);

        final Activity thisActivity = this;

        final TextView tv1=(TextView) findViewById(id.tv1);
        //String url = "https://raw.githubusercontent.com/GeekLee1998/android-labs-2018/master/soft1612070501311/main/assets/text.json";
        RequestQueue mQueue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest("https://raw.githubusercontent.com/GeekLee1998/android-labs-2018/master/soft1612070501311/main/assets/text.json", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        tv1.setText(response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        });
        mQueue.add(jsonObjectRequest);
    }
}
