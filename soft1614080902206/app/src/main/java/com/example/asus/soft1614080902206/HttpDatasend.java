package com.example.asus.soft1614080902206;
import java.io.*;
import java.net.*;
/**
 * Created by asus on 2018/4/27.
 */

public class HttpDatasend {
    public static String sendGet(String url)throws IOException{
        String result="";
        BufferedReader in =null;
        try {
            String urlNameString = url;
            //创建连接
            URL realUrl =new URL(urlNameString);
            //连接
            URLConnection connection = realUrl.openConnection();
            //设置http头信息
            connection.setRequestProperty("accept","*/*");
            connection.setRequestProperty("connection","Keep-Alive");
            connection.setRequestProperty("user-agent","Mozilla/4.0(compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            connection.setRequestProperty("Referer",Value.URL);
            //打开连接
            connection.connect();
            //设置文件的编码格式
            in =new BufferedReader(new InputStreamReader(connection.getInputStream(),"UTF-8"));
            String line;
            Value.URL=connection.getURL().toString();
            //读取HTML文本
            while((line = in.readLine())!=null){
                result+=line;
            }
        } catch (Exception e) {
            System.out.println("error!"+e);
            return null;
        }
        finally{
            try {
                if(in!=null){
                    in.close();
                }
            } catch (Exception e) {
                return null;
            }
        }
        return result;
    }
    public static String sendPost(String url,String param){
        PrintWriter out=null;
        BufferedReader in =null;
        String result ="";
        try {
            URL realUrl =new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept","*/*");
            conn.setRequestProperty("connection","Keep-Alive");
            conn.setRequestProperty("user-agent","Mozilla/4.0(compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Referer",Value.URL);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            //设置读取文件的编码格式
            in= new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
            String line;
            //读取文本
            while((line = in.readLine())!=null){
                result+=line;
            }
        } catch (Exception e) {
            System.out.println("发送post请求失败"+e);
            System.out.println(param);
            System.out.println(url);
        }
        finally{
            try {
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }
}