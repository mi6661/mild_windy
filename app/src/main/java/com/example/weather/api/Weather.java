package com.example.weather.api;

import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Weather {
    private static final String URL_STR = "https://v2.xxapi.cn/api/weather?city=";
    private String city;
    private HttpURLConnection connection;
    private URL url;

    private InputStream ISM;

    public Weather(String city){
        this.city = city;
    }
    public void setCity(String city){
        this.city = city;
    }
    /*
    * 初始化，配置http基本信息
    * */
    public boolean init(){
        try{
            url = new URL(URL_STR+city);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");         //GET请求
            connection.setConnectTimeout(10000);        //设置连接延时10秒
            connection.setReadTimeout(10000);           //设置读取延时10秒
        } catch (MalformedURLException e) {
            Log.e("http","Failed to init");
            return false;
        } catch (IOException e) {
            Log.e("http","Failed to openConnection in Init()");
            return false;
        }
        return true;
    }
    /*
    * 获取与API连接的输入流
    * */
    public boolean connect(){
        try{
            connection.connect();
            int code = connection.getResponseCode();
            if(code == 200){
                ISM = connection.getInputStream();
            }
            return code == 200;
        }catch (IOException e){
            Log.e("http","Failed to Connect");
            return false;
        }
    }
    //关闭输入流
    public void close(){
        try{
            if(ISM !=null) ISM.close();
            connection.disconnect();

        } catch (IOException e) {
            Log.e("http","Failed to close()");
        }
    }


    //数据读取
    public String getData(){
        StringBuffer sb = new StringBuffer();       //数据储存区
        byte buffer[] = new byte[1024];             //数据缓冲区
        int len = 0;
        try{
            if((len = ISM.read(buffer))>0){
                String ts = new String(buffer, StandardCharsets.UTF_8);
                sb.append(ts);
            }
        } catch (IOException e) {
            Log.e("http","Failed to read data form ISM");
        }
        return sb.toString();
    }
}
