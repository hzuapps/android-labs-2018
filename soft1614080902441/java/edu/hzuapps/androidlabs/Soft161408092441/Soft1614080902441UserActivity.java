package edu.hzuapps.androidlabs.Soft161408092441;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class Soft1614080902441UserActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soft1614080902441_03);
    }

    public String writeToString(List<UserInfo> users){
        //ʵ��xml��Ϣ���кŵ�һ������
        XmlSerializer serializer=Xml.newSerializer();
        StringWriter writer=new StringWriter();
        try {
            //xml���ݾ������л��󱣴浽String�У�Ȼ���ִ�ͨ��OutputStream����Ϊxml�ļ�
            serializer.setOutput(writer);

            //�ĵ���ʼ
            serializer.startDocument("utf-8", true);

            //��ʼһ���ڵ�
            serializer.startTag("", "users");

            //��ʼһ���ӽڵ�
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
            //�ر��ĵ�
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
