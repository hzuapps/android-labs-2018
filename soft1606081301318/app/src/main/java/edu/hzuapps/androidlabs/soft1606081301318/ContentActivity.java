package androidlabs.hzuapps.edu.soft1606081301318;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ContentActivity extends AppCompatActivity {
    private WebView wb;
    private String data_html;
    private String Title;
    private String imgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        wb = findViewById(R.id.webv);
        Intent intent=getIntent();
        String i = intent.getStringExtra("NewsId");
        wb.loadDataWithBaseURL(null, "<p1>加载中...</p1>", "text/html" , "utf-8", null);
        initData(i);
    }

    public void initData(String NewsId){

        OkHttpClient mOkHttpClient=new OkHttpClient();
        Request.Builder requestBuilder = new Request.Builder().url("https://news-at.zhihu.com/api/4/news/" + NewsId);
        requestBuilder.method("GET",null);
        Request request = requestBuilder.build();
        Call mcall= mOkHttpClient.newCall(request);

        mcall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String sbody;
                if (null != response.cacheResponse()) {
                    String str = response.cacheResponse().toString();
                } else {
                    sbody = response.body().string();

                    Gson cgson = new Gson();
                    ContentGson g_data = cgson.fromJson(sbody,ContentGson.class);
                    List<String> css = g_data.getCss();
                    Title = g_data.getTitle();
                    imgUrl = g_data.getImage();
                    css.get(0);
                    data_html = "<link rel=\"stylesheet\" type=\"text/css\" href=\"" + css.get(0) +"\" />";
                    data_html += "<img  src=\"" + imgUrl +"\"  style=\"max-width:100%; width:100%; max-height:345px; vertical-align:middle;  margin-bottom:-200px;\" />";
                    data_html = data_html + g_data.getBody();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setTitle (Title);
                        wb.loadDataWithBaseURL(null, data_html, "text/html" , "utf-8", null);
                    }
                });
            }
        });

    }
}
