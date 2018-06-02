package edu.hzuapps.androidlabs.Soft161408092441;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Soft1614080902441UserActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902441_03);
    }

    public String writeToString(List<UserInfo> users){
        //实现xml信息序列号的一个对象
        XmlSerializer serializer=Xml.newSerializer();
        StringWriter writer=new StringWriter();
        try {
            //xml数据经过序列化后保存到String中，然后将字串通过OutputStream保存为xml文件
            serializer.setOutput(writer);

            //文档开始
            serializer.startDocument("utf-8", true);

            //开始一个节点
            serializer.startTag("", "users");

            //开始一个子节点
            for(UserInfo user : users){
                serializer.startTag("", "user");
                serializer.attribute("", "id", String.valueOf(user.getId()));

                serializer.startTag("", "name");
                serializer.text(user.getName());
                serializer.endTag("", "name");

                serializer.startTag("", "pwd");
                serializer.text(user.getPwd());
                serializer.endTag("", "pwd");

                serializer.startTag("", "isremember");
                serializer.text(String.valueOf(user.getIsRemember()));
                serializer.endTag("", "isremember");

                serializer.endTag("", "user");
            }

            serializer.endTag("", "users");
            //关闭文档
            serializer.endDocument();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return writer.toString();
    }

}
